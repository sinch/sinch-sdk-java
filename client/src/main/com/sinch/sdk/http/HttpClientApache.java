package com.sinch.sdk.http;

import static com.sinch.sdk.auth.adapters.BearerAuthManager.BEARER_AUTHENTICATE_RESPONSE_HEADER_KEYWORD;
import static com.sinch.sdk.auth.adapters.BearerAuthManager.BEARER_EXPIRED_KEYWORD;
import static com.sinch.sdk.core.http.HttpContentType.CONTENT_TYPE_HEADER;
import static com.sinch.sdk.core.http.URLParameterUtils.encodeParametersAsString;

import com.sinch.sdk.auth.adapters.BearerAuthManager;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.http.HttpStatus;
import com.sinch.sdk.core.http.URLParameter;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.utils.Pair;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.ClassicHttpRequest;
import org.apache.hc.core5.http.ClassicHttpResponse;
import org.apache.hc.core5.http.Header;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.apache.hc.core5.http.io.support.ClassicRequestBuilder;

public class HttpClientApache implements com.sinch.sdk.core.http.HttpClient {

  private static final Logger LOGGER = Logger.getLogger(HttpClientApache.class.getName());

  private Map<String, String> headersToBeAdded;

  private CloseableHttpClient client;

  public HttpClientApache() {
    this.client = HttpClients.createDefault();
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
    Scanner s = new Scanner(entity.getContent()).useDelimiter("\\A");
    String content = (s.hasNext() ? s.next() : "");

    return new HttpResponse(statusCode, message, headers, content.getBytes(StandardCharsets.UTF_8));
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

    try {
      String path = serverConfiguration.getUrl() + httpRequest.getPath().orElse("");
      HttpMethod method = httpRequest.getMethod();
      Collection<URLParameter> queryParameters = httpRequest.getQueryParameters();

      String body = httpRequest.getBody();
      Map<String, String> headerParams = httpRequest.getHeaderParams();
      Collection<String> accept = httpRequest.getAccept();
      Collection<String> contentType = httpRequest.getContentType();
      Collection<String> authNames = httpRequest.getAuthNames();

      LOGGER.fine("Invoke '" + method + "' onto '" + path + "'");
      LOGGER.fine("queryParameters: " + queryParameters);
      LOGGER.fine("body: " + body);
      LOGGER.fine("headerParams: " + headerParams);
      LOGGER.fine("accept: " + accept);
      LOGGER.fine("contentType: " + contentType);
      LOGGER.fine("authNames: " + authNames);

      ClassicRequestBuilder requestBuilder = ClassicRequestBuilder.create(method.name());

      setUri(requestBuilder, path, queryParameters);

      addBody(requestBuilder, body);

      addCollectionHeader(requestBuilder, CONTENT_TYPE_HEADER, contentType);
      addCollectionHeader(requestBuilder, "Accept", accept);

      addHeaders(requestBuilder, headerParams);
      addHeaders(requestBuilder, headersToBeAdded);

      addAuth(requestBuilder, authManagersByOasSecuritySchemes, authNames, body);

      ClassicHttpRequest request = requestBuilder.build();

      HttpResponse response = processRequest(client, request);
      LOGGER.finest("connection response: " + response);

      // UNAUTHORIZED (HTTP 401) error code could imply refreshing the OAuth token
      if (response.getCode() == HttpStatus.UNAUTHORIZED) {
        boolean couldRetryRequest =
            processUnauthorizedResponse(httpRequest, response, authManagersByOasSecuritySchemes);
        if (couldRetryRequest) {
          // refresh authorization
          addAuth(requestBuilder, authManagersByOasSecuritySchemes, authNames, body);
          request = requestBuilder.build();
          response = processRequest(client, request);
          LOGGER.finest("connection response on retry: " + response);
        }
      }
      return response;
    } catch (Exception e) {
      LOGGER.severe("Error:" + e);
      throw new ApiException(e);
    }
  }

  private boolean processUnauthorizedResponse(
      HttpRequest request,
      HttpResponse response,
      Map<String, AuthManager> authManagersByOasSecuritySchemes) {

    Map<String, AuthManager> authManagersByAuthSchemes =
        authManagersByOasSecuritySchemes.values().stream()
            .map(authManager -> new AbstractMap.SimpleEntry<>(authManager.getSchema(), authManager))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1, a2) -> a1));
    AuthManager bearerAuthManager =
        authManagersByAuthSchemes.get(BearerAuthManager.SCHEMA_KEYWORD_BEARER);
    if (null == bearerAuthManager) {
      // no bearer manager registered
      return false;
    }

    Collection<String> auths = request.getAuthNames();
    Optional<String> requestSupportBearerAuthentication =
        auths.stream()
            .filter(
                f ->
                    null != authManagersByOasSecuritySchemes.get(f)
                        && authManagersByOasSecuritySchemes
                            .get(f)
                            .getSchema()
                            .equals(BearerAuthManager.SCHEMA_KEYWORD_BEARER))
            .findFirst();

    if (!requestSupportBearerAuthentication.isPresent()) {
      return false;
    }
    // looking for "expired" keyword present in "www-authenticate" header
    Map<String, List<String>> responseHeaders = response.getHeaders();
    Collection<String> header = responseHeaders.get(BEARER_AUTHENTICATE_RESPONSE_HEADER_KEYWORD);

    boolean headerPresent = header.stream().anyMatch(e -> e.contains(BEARER_EXPIRED_KEYWORD));
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
    if (null != body) {
      requestBuilder.setEntity(new StringEntity(body));
    }
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
        LOGGER.info("Ignore unknown authentication value: '" + entry + "'");
      }
    }
  }

  private HttpResponse processRequest(CloseableHttpClient client, ClassicHttpRequest request)
      throws IOException {
    return client.execute(request, HttpClientApache::processResponse);
  }

  @Override
  public boolean isClosed() {
    return null == client;
  }

  @Override
  public void close() throws Exception {
    if (!isClosed()) {
      try {
        client.close();
      } finally {
        client = null;
      }
    }
  }
}
