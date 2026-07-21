package com.sinch.sdk.http;

import static com.sinch.sdk.auth.adapters.OAuthManager.BEARER_AUTHENTICATE_RESPONSE_HEADER_KEYWORD;
import static com.sinch.sdk.auth.adapters.OAuthManager.BEARER_EXPIRED_KEYWORD;
import static com.sinch.sdk.core.http.HttpContentType.CONTENT_TYPE_HEADER;
import static com.sinch.sdk.core.http.URLParameterUtils.encodeParametersAsString;

import com.sinch.sdk.auth.adapters.OAuthManager;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpContentType;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.http.HttpStatus;
import com.sinch.sdk.core.http.URLParameter;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.models.HttpProxyConfiguration;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.HttpResponseException;
import org.apache.hc.client5.http.auth.AuthScope;
import org.apache.hc.client5.http.auth.CredentialsProvider;
import org.apache.hc.client5.http.entity.mime.MultipartEntityBuilder;
import org.apache.hc.client5.http.impl.auth.CredentialsProviderBuilder;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.client5.http.impl.routing.DefaultProxyRoutePlanner;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.ContentType;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.HttpHost;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;
import org.apache.hc.core5.http.support.AbstractMessageBuilder;

public class HttpClientApache implements com.sinch.sdk.core.http.HttpClient {

  private static final Logger LOGGER = Logger.getLogger(HttpClientApache.class.getName());

  /**
   * HTTP 407 Proxy Authentication Required. Kept as a local constant to make the guard in {@link
   * #invokeAPI} self-documenting and independent of any external enum.
   */
  private static final int HTTP_PROXY_AUTHENTICATION_REQUIRED = 407;

  private volatile Map<String, String> headersToBeAdded;

  private volatile CloseableHttpClient client;

  public HttpClientApache() {
    this(null);
  }

  public HttpClientApache(HttpProxyConfiguration proxyConfiguration) {
    this.client = buildHttpClient(proxyConfiguration);
  }

  private static CloseableHttpClient buildHttpClient(HttpProxyConfiguration proxyConfiguration) {
    if (proxyConfiguration == null) {
      return HttpClients.createDefault();
    }

    HttpHost proxyHost =
        new HttpHost(proxyConfiguration.getHostname(), proxyConfiguration.getPort());
    HttpClientBuilder builder =
        HttpClients.custom().setRoutePlanner(new DefaultProxyRoutePlanner(proxyHost));

    if (proxyConfiguration.getUsername().isPresent()) {
      // getPassword() returns a defensive copy of the internal array; HC5 receives that copy and
      // owns it for the lifetime of the client. The caller does not need to keep the original
      // alive.
      CredentialsProvider credentialsProvider =
          CredentialsProviderBuilder.create()
              .add(
                  new AuthScope(proxyHost),
                  proxyConfiguration.getUsername().orElse(""),
                  proxyConfiguration.getPassword().orElse(new char[0]))
              .build();
      builder.setDefaultCredentialsProvider(credentialsProvider);
    }
    return builder.build();
  }

  public void setRequestHeaders(Map<String, String> headers) {
    this.headersToBeAdded = headers;
  }

  private static HttpResponse processResponse(ClassicHttpResponse response) throws IOException {

    int statusCode = response.getCode();
    Map<String, List<String>> headers = transformResponseHeaders(response.getHeaders());
    String message = response.getReasonPhrase();
    LOGGER.finest("response: " + statusCode + ", headers:" + headers);

    if (statusCode == org.apache.hc.core5.http.HttpStatus.SC_NO_CONTENT) {
      return new HttpResponse(statusCode, message, headers, null);
    }

    HttpEntity entity = response.getEntity();
    if (null == entity) {
      return new HttpResponse(statusCode, message, headers, null);
    }
    try (Scanner s =
        new Scanner(entity.getContent(), StandardCharsets.UTF_8.name()).useDelimiter("\\A")) {
      String content = (s.hasNext() ? s.next() : "");
      return new HttpResponse(
          statusCode, message, headers, content.getBytes(StandardCharsets.UTF_8));
    }
  }

  private static Map<String, List<String>> transformResponseHeaders(Header[] headers) {
    Map<String, List<String>> headersMap = new HashMap<>();
    for (Header header : headers) {
      List<String> valuesList = headersMap.get(header.getName());
      if (valuesList != null) {
        valuesList.add(header.getValue());
      } else {
        valuesList = new ArrayList<>();
        valuesList.add(header.getValue());
        headersMap.put(header.getName(), valuesList);
      }
    }
    return headersMap;
  }

  @Override
  public HttpResponse invokeAPI(
      ServerConfiguration serverConfiguration,
      Map<String, AuthManager> authManagersByOasSecuritySchemes,
      HttpRequest httpRequest)
      throws ApiException {

    CloseableHttpClient activeClient = this.client;
    if (activeClient == null) {
      throw new ApiException("HTTP client has been closed");
    }

    try {
      String path =
          httpRequest
              .getFullUrl()
              .orElse(serverConfiguration.getUrl() + httpRequest.getPath().orElse(""));
      HttpMethod method = httpRequest.getMethod();
      Collection<URLParameter> queryParameters = httpRequest.getQueryParameters();

      String body = httpRequest.getBody();
      Map<String, Object> formParams = httpRequest.getFormParams();
      Map<String, String> headerParams = httpRequest.getHeaderParams();
      Collection<String> accept = httpRequest.getAccept();
      Collection<String> contentType = httpRequest.getContentType();
      Collection<String> authNames = httpRequest.getAuthNames();

      LOGGER.fine("Invoke '" + method + "' onto '" + path + "'");
      LOGGER.fine("queryParameters: " + queryParameters);
      LOGGER.fine("body: " + body);
      LOGGER.fine("formParams: " + formParams);
      LOGGER.fine("headerParams: " + headerParams);
      LOGGER.fine("accept: " + accept);
      LOGGER.fine("contentType: " + contentType);
      LOGGER.fine("authNames: " + authNames);

      ClassicRequestBuilder requestBuilder = ClassicRequestBuilder.create(method.name());

      setUri(requestBuilder, path, queryParameters);

      addCollectionHeader(requestBuilder, "Accept", accept);

      addHeaders(requestBuilder, headerParams);
      addHeaders(requestBuilder, headersToBeAdded);

      if (null != body) {
        addCollectionHeader(requestBuilder, CONTENT_TYPE_HEADER, contentType);
        addBody(requestBuilder, body);
      }

      addFormParams(requestBuilder, contentType, formParams);

      addAuth(requestBuilder, authManagersByOasSecuritySchemes, authNames, body);

      ClassicHttpRequest request = requestBuilder.build();

      HttpResponse response = processRequest(activeClient, request);
      LOGGER.finest("connection response: " + response);

      // HTTP 407 (Proxy Authentication Required) is normally handled transparently by Apache
      // HttpClient via DefaultProxyRoutePlanner + CredentialsProvider (the 407→retry cycle
      // happens inside processRequest and is invisible to this method).
      // If 407 surfaces here it means proxy credentials are absent, wrong, or the proxy uses an
      // unsupported auth scheme. Guard explicitly so that the OAuth-refresh block below does NOT
      // misfire: some enterprise proxies include a `www-authenticate: Bearer error="expired"`
      // header on 407 responses, which would incorrectly trigger an OAuth token reset.
      if (response.getCode() == HTTP_PROXY_AUTHENTICATION_REQUIRED) {
        LOGGER.warning(
            "Proxy authentication required (HTTP 407). "
                + "Verify HttpProxyConfiguration hostname, port and credentials.");
        return response;
      }

      // UNAUTHORIZED (HTTP 401) error code could imply refreshing the OAuth token
      if (response.getCode() == HttpStatus.UNAUTHORIZED) {
        boolean couldRetryRequest =
            processUnauthorizedResponse(httpRequest, response, authManagersByOasSecuritySchemes);
        if (couldRetryRequest) {
          // refresh authorization
          addAuth(requestBuilder, authManagersByOasSecuritySchemes, authNames, body);
          request = requestBuilder.build();
          response = processRequest(activeClient, request);
          LOGGER.finest("connection response on retry: " + response);
        }
      }
      return response;
    } catch (ClientProtocolException cpe) {
      int code = extractHttpStatusCode(cpe);
      if (code > 0) {
        LOGGER.severe("HTTP protocol error with status code " + code + ": " + cpe.getMessage());
        throw new ApiException(
            "HTTP protocol error (status code " + code + "): " + cpe.getMessage(), cpe, code);
      }
      LOGGER.severe("HTTP protocol error: " + cpe.getMessage());
      throw new ApiException("HTTP protocol error: " + cpe.getMessage(), cpe);
    } catch (Exception e) {
      LOGGER.severe("Error:" + e);
      throw new ApiException(e);
    }
  }

  private boolean processUnauthorizedResponse(
      HttpRequest request,
      HttpResponse response,
      Map<String, AuthManager> authManagersByOasSecuritySchemes) {

    if (null == authManagersByOasSecuritySchemes) {
      return false;
    }
    Map<String, AuthManager> authManagersByAuthSchemes =
        authManagersByOasSecuritySchemes.values().stream()
            .map(authManager -> new AbstractMap.SimpleEntry<>(authManager.getSchema(), authManager))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1));
    AuthManager bearerAuthManager =
        authManagersByAuthSchemes.get(OAuthManager.SCHEMA_KEYWORD_BEARER);
    if (null == bearerAuthManager) {
      // no bearer manager registered
      return false;
    }

    Collection<String> auths = request.getAuthNames();

    boolean requestSupportsBearer =
        auths.stream()
            .anyMatch(
                authName -> {
                  AuthManager authManager = authManagersByOasSecuritySchemes.get(authName);
                  return authManager != null
                      && authManager.getSchema().equals(OAuthManager.SCHEMA_KEYWORD_BEARER);
                });
    if (!requestSupportsBearer) {
      return false;
    }
    Map<String, List<String>> responseHeaders = response.getHeaders();
    Collection<String> header = responseHeaders.get(BEARER_AUTHENTICATE_RESPONSE_HEADER_KEYWORD);

    boolean headerPresent =
        header != null && header.stream().anyMatch(e -> e.contains(BEARER_EXPIRED_KEYWORD));
    if (headerPresent) {
      bearerAuthManager.resetToken();
    }
    return headerPresent;
  }

  private void setUri(
      ClassicRequestBuilder requestBuilder, String path, Collection<URLParameter> parameters) {

    if (null == parameters || parameters.isEmpty()) {
      requestBuilder.setUri(path);
      return;
    }
    String requestParameters = "?" + encodeParametersAsString(parameters);
    LOGGER.finest("Request parameters: " + requestParameters);
    requestBuilder.setUri(path + requestParameters);
  }

  private void addBody(ClassicRequestBuilder requestBuilder, String body) {

    if (null == body) {
      return;
    }
    Charset charset = extractCharset(requestBuilder).orElse(StandardCharsets.UTF_8);
    requestBuilder.setEntity(new StringEntity(body, charset));
  }

  private void addFormParams(
      ClassicRequestBuilder requestBuilder,
      Collection<String> contentType,
      Map<String, Object> formParams) {

    if (null == formParams) {
      return;
    }

    MultipartEntityBuilder multiPartBuilder = MultipartEntityBuilder.create();
    if (null == contentType
        || contentType.stream().noneMatch(cType -> cType.toLowerCase().contains("charset="))) {
      multiPartBuilder.setCharset(StandardCharsets.UTF_8);
    }
    formParams.forEach((key, value) -> addMultiPart(requestBuilder, multiPartBuilder, key, value));

    requestBuilder.setEntity(multiPartBuilder.build());
  }

  private void addMultiPart(
      AbstractMessageBuilder<?> messageBuilder,
      MultipartEntityBuilder multiPartBuilder,
      String name,
      Object value) {

    if (value instanceof File) {
      addMultiPartFile(multiPartBuilder, name, (File) value);
    } else if (value instanceof byte[]) {
      addMultiPartByteArray(multiPartBuilder, name, (byte[]) value);
    } else if (value instanceof Collection) {
      addMultiPartCollection(messageBuilder, multiPartBuilder, name, (Collection<?>) value);
    } else {
      Charset charset = extractCharset(messageBuilder).orElse(StandardCharsets.UTF_8);
      ContentType customContentType =
          ContentType.create(ContentType.TEXT_PLAIN.getMimeType(), charset);
      multiPartBuilder.addTextBody(name, (String) value, customContentType);
    }
  }

  private void addMultiPartFile(MultipartEntityBuilder multiPartBuilder, String name, File file) {
    multiPartBuilder.addBinaryBody(name, file);
  }

  private void addMultiPartByteArray(
      MultipartEntityBuilder multiPartBuilder, String name, byte[] bytes) {
    multiPartBuilder.addBinaryBody(name, bytes);
  }

  private void addMultiPartCollection(
      AbstractMessageBuilder<?> messageBuilder,
      MultipartEntityBuilder multiPartBuilder,
      String name,
      Collection<?> collection) {
    collection.forEach(item -> addMultiPart(messageBuilder, multiPartBuilder, name, item));
  }

  private void addCollectionHeader(
      ClassicRequestBuilder requestBuilder, String header, Collection<String> values) {
    if (null != values && !values.isEmpty()) {
      requestBuilder.setHeader(header, String.join(",", values));
    }
  }

  private void addHeaders(ClassicRequestBuilder requestBuilder, Map<String, String> headers) {

    if (null == headers) {
      return;
    }
    headers
        .entrySet()
        .iterator()
        .forEachRemaining(f -> requestBuilder.setHeader(f.getKey(), f.getValue()));
  }

  private void addAuth(
      ClassicRequestBuilder requestBuilder,
      Map<String, AuthManager> authManagersByOasSecuritySchemes,
      Collection<String> values,
      String body) {

    if (null == values || values.isEmpty() || null == authManagersByOasSecuritySchemes) {
      return;
    }

    for (String entry : values) {
      if (authManagersByOasSecuritySchemes.containsKey(entry)) {
        AuthManager authManager = authManagersByOasSecuritySchemes.get(entry);
        Collection<Pair<String, String>> headers =
            authManager.getAuthorizationHeaders(
                requestBuilder.getMethod(),
                null != requestBuilder.getFirstHeader(CONTENT_TYPE_HEADER)
                    ? requestBuilder.getFirstHeader(CONTENT_TYPE_HEADER).getValue()
                    : null,
                requestBuilder.getPath(),
                body);
        headers.stream()
            .iterator()
            .forEachRemaining(f -> requestBuilder.setHeader(f.getLeft(), f.getRight()));
        return;
      } else {
        LOGGER.finest("Ignore unknown authentication value: '" + entry + "'");
      }
    }
  }

  HttpResponse processRequest(CloseableHttpClient client, ClassicHttpRequest request)
      throws IOException {
    return client.execute(request, HttpClientApache::processResponse);
  }

  /**
   * Extracts the HTTP status code from a {@link ClientProtocolException}.
   *
   * <p>Handles two cases:
   *
   * <ul>
   *   <li>{@link HttpResponseException} — carries the code directly via {@code getStatusCode()}.
   *   <li>Plain {@link ClientProtocolException} — Apache embeds the status line in the message
   *       (e.g. {@code "CONNECT refused by proxy: HTTP/1.1 407 Proxy Authentication Required"}).
   * </ul>
   *
   * @return the HTTP status code, or {@code -1} if it cannot be determined
   */
  private static int extractHttpStatusCode(ClientProtocolException e) {
    if (e instanceof HttpResponseException) {
      return ((HttpResponseException) e).getStatusCode();
    }
    String message = e.getMessage();
    if (message == null) {
      return -1;
    }
    int idx = message.indexOf("HTTP/");
    if (idx < 0) {
      return -1;
    }
    String[] parts = message.substring(idx).split(" ", 3);
    if (parts.length < 2) {
      return -1;
    }
    try {
      return Integer.parseInt(parts[1]);
    } catch (NumberFormatException ignored) {
      return -1;
    }
  }

  private Optional<Charset> extractCharset(AbstractMessageBuilder<?> messageBuilder) {

    Header[] headers = messageBuilder.getHeaders(CONTENT_TYPE_HEADER);
    if (null == headers) {
      return Optional.empty();
    }
    Optional<Header> charsetHeader =
        Arrays.stream(headers).filter(f -> f.getValue().contains("charset=")).findFirst();

    return charsetHeader.flatMap(
        header -> HttpContentType.getCharsetValue(header.getValue()).map(Charset::forName));
  }

  @Override
  public boolean isClosed() {
    return null == client;
  }

  @Override
  public void close() throws Exception {
    if (!isClosed()) {
      synchronized (this) {
        CloseableHttpClient local = client;
        client = null;
        if (local != null) {
          local.close();
        }
      }
    }
  }
}
