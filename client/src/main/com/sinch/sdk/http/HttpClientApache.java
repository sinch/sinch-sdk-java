package com.sinch.sdk.http;

import static com.sinch.sdk.auth.adapters.OAuthManager.BEARER_AUTHENTICATE_RESPONSE_HEADER_KEYWORD;
import static com.sinch.sdk.auth.adapters.OAuthManager.BEARER_EXPIRED_KEYWORD;
import static com.sinch.sdk.core.http.HttpContentType.CONTENT_TYPE_HEADER;

import com.sinch.sdk.auth.adapters.OAuthManager;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.http.HttpStatus;
import com.sinch.sdk.core.http.IdempotencyKey;
import com.sinch.sdk.core.http.transport.HttpHeaders;
import com.sinch.sdk.core.http.transport.HttpTransport;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.models.HttpProxyConfiguration;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.apache.hc.client5.http.ClientProtocolException;
import org.apache.hc.client5.http.HttpResponseException;

public class HttpClientApache implements com.sinch.sdk.core.http.HttpClient, RetryCapable {

  private static final Logger LOGGER = Logger.getLogger(HttpClientApache.class.getName());

  /**
   * HTTP 407 Proxy Authentication Required. Kept as a local constant to make the guard in {@link
   * #invokeAPI} self-documenting and independent of any external enum.
   */
  private static final int HTTP_PROXY_AUTHENTICATION_REQUIRED = 407;

  private volatile Map<String, String> headersToBeAdded;

  private volatile HttpTransport transport;

  private final RetryManager retryManager;

  /**
   * @param proxyConfiguration Proxy to route through, or {@code null} for a direct connection
   * @param retryManager Manager applied to rate-limited responses, or {@code null} to retry nothing
   * @param timeoutSeconds Timeout applied to I/O operations, zero to disable it
   * @since 2.3
   */
  public HttpClientApache(
      HttpProxyConfiguration proxyConfiguration, RetryManager retryManager, int timeoutSeconds) {
    this(new ApacheHttpTransport(proxyConfiguration, timeoutSeconds), retryManager);
  }

  /**
   * @param transport Transport the requests are sent with
   * @param retryManager Manager applied to rate-limited responses, or {@code null} to retry nothing
   */
  HttpClientApache(HttpTransport transport, RetryManager retryManager) {
    this.transport = transport;
    this.retryManager = null != retryManager ? retryManager : RetryManager.NO_RETRY;
  }

  @Override
  public Optional<RetryManager> getRetryManager() {
    return Optional.ofNullable(retryManager);
  }

  public void setRequestHeaders(Map<String, String> headers) {
    this.headersToBeAdded = headers;
  }

  @Override
  public HttpResponse invokeAPI(
      ServerConfiguration serverConfiguration,
      Map<String, AuthManager> authManagersByOasSecuritySchemes,
      HttpRequest httpRequest)
      throws ApiException {

    HttpTransport activeTransport = this.transport;
    if (activeTransport == null) {
      throw new ApiException("HTTP client has been closed");
    }

    try {
      com.sinch.sdk.core.http.transport.HttpRequest transportRequest =
          TransportRequestMapper.toTransportRequest(
              serverConfiguration, httpRequest, withIdempotencyKey(httpRequest), headersToBeAdded);
      Collection<String> authNames = httpRequest.getAuthNames();
      String body = httpRequest.getBody();

      LOGGER.fine(
          "Invoke '" + transportRequest.getMethod() + "' onto '" + transportRequest.getUrl() + "'");
      LOGGER.fine("queryParameters: " + transportRequest.getQueryParameters().orElse(null));
      LOGGER.fine("body: " + body);
      LOGGER.fine("formParams: " + httpRequest.getFormParams());
      LOGGER.fine("headers: " + transportRequest.getHeaders());
      LOGGER.fine("authNames: " + authNames);

      HttpResponse response =
          send(
              activeTransport, transportRequest, authManagersByOasSecuritySchemes, authNames, body);
      LOGGER.finest("connection response: " + response);

      // HTTP 407 (Proxy Authentication Required) is normally handled transparently by Apache
      // HttpClient via DefaultProxyRoutePlanner + CredentialsProvider (the 407→retry cycle
      // happens inside the transport and is invisible to this method).
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
          response =
              send(
                  activeTransport,
                  transportRequest,
                  authManagersByOasSecuritySchemes,
                  authNames,
                  body);
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
    } catch (ApiException e) {
      LOGGER.severe("Error:" + e);
      throw e;
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

  // The key is added once, before the request goes through the retry policy, so that every attempt
  // of the request sends the same key
  private static Map<String, String> withIdempotencyKey(HttpRequest httpRequest) {
    Map<String, String> headers = httpRequest.getHeaderParams();
    if (!httpRequest.isIdempotent()
        || (null != headers
            && headers.keySet().stream().anyMatch(IdempotencyKey.HEADER::equalsIgnoreCase))) {
      return headers;
    }
    Map<String, String> withKey = null == headers ? new HashMap<>() : new HashMap<>(headers);
    withKey.put(IdempotencyKey.HEADER, IdempotencyKey.generate());
    return withKey;
  }

  private com.sinch.sdk.core.http.transport.HttpRequest withAuth(
      com.sinch.sdk.core.http.transport.HttpRequest request,
      Map<String, AuthManager> authManagersByOasSecuritySchemes,
      Collection<String> values,
      String body) {

    if (null == values || values.isEmpty() || null == authManagersByOasSecuritySchemes) {
      return request;
    }

    for (String entry : values) {
      if (authManagersByOasSecuritySchemes.containsKey(entry)) {
        AuthManager authManager = authManagersByOasSecuritySchemes.get(entry);
        Collection<Pair<String, String>> authHeaders =
            authManager.getAuthorizationHeaders(
                request.getMethod().name(),
                request.getHeaders().getFirst(CONTENT_TYPE_HEADER).orElse(null),
                TransportRequestMapper.authorizationPath(request),
                body);
        HttpHeaders headers = new HttpHeaders(request.getHeaders());
        authHeaders.forEach(f -> headers.set(f.getLeft(), f.getRight()));
        return com.sinch.sdk.core.http.transport.HttpRequest.builder(request)
            .setHeaders(headers)
            .build();
      } else {
        LOGGER.finest("Ignore unknown authentication value: '" + entry + "'");
      }
    }
    return request;
  }

  /**
   * Performs one HTTP exchange under the retry policy, so that a rate-limited response is retried
   * for every endpoint that goes through this transport.
   */
  private HttpResponse send(
      HttpTransport transport,
      com.sinch.sdk.core.http.transport.HttpRequest request,
      Map<String, AuthManager> authManagersByOasSecuritySchemes,
      Collection<String> authNames,
      String body)
      throws Exception {
    // Authorization of the first attempt is computed outside the retry policy: fetching a token
    // then goes through its own retry policy rather than sharing the one of this request
    com.sinch.sdk.core.http.transport.HttpRequest authorized =
        withAuth(request, authManagersByOasSecuritySchemes, authNames, body);

    AtomicBoolean firstAttempt = new AtomicBoolean(true);
    return retryManager.execute(
        () -> {
          com.sinch.sdk.core.http.transport.HttpRequest attempt =
              firstAttempt.getAndSet(false)
                  ? authorized
                  : withAuth(request, authManagersByOasSecuritySchemes, authNames, body);
          try (com.sinch.sdk.core.http.transport.HttpResponse response = transport.send(attempt)) {
            return TransportRequestMapper.toServiceResponse(response);
          }
        });
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

  @Override
  public boolean isClosed() {
    return null == transport;
  }

  @Override
  public void close() throws Exception {
    if (!isClosed()) {
      synchronized (this) {
        HttpTransport local = transport;
        transport = null;
        if (local != null) {
          local.close();
        }
      }
    }
  }
}
