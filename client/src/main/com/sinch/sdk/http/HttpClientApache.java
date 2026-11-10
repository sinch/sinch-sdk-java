package com.sinch.sdk.http;

import static com.sinch.sdk.auth.adapters.OAuthManager.BEARER_AUTHENTICATE_RESPONSE_HEADER_KEYWORD;
import static com.sinch.sdk.auth.adapters.OAuthManager.BEARER_EXPIRED_KEYWORD;

import com.sinch.sdk.auth.adapters.OAuthManager;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.http.HttpStatus;
import com.sinch.sdk.core.http.IdempotencyKey;
import com.sinch.sdk.core.http.transport.HttpTransport;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.models.HttpProxyConfiguration;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;
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
      TransportCall call =
          new TransportCall(
              activeTransport,
              TransportRequestMapper.toTransportRequest(
                  serverConfiguration,
                  httpRequest,
                  withIdempotencyKey(httpRequest),
                  headersToBeAdded),
              authManagersByOasSecuritySchemes,
              httpRequest.getAuthNames(),
              httpRequest.getBody());

      LOGGER.fine(
          "Invoke '"
              + call.getRequest().getMethod()
              + "' onto '"
              + call.getRequest().getUrl()
              + "'");
      LOGGER.fine("queryParameters: " + call.getRequest().getQueryParameters().orElse(null));
      LOGGER.fine("body: " + httpRequest.getBody());
      LOGGER.fine("formParams: " + httpRequest.getFormParams());
      LOGGER.fine("headers: " + call.getRequest().getHeaders());
      LOGGER.fine("authNames: " + httpRequest.getAuthNames());

      HttpResponse response = send(call);
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
          response = send(call);
          LOGGER.finest("connection response on retry: " + response);
        }
      }
      return response;
    } catch (Exception e) {
      throw toApiException(e);
    }
  }

  /**
   * Send a request of the low-level HTTP client, under the retry policy. When authenticated with
   * OAuth, an expired token is refreshed and the request sent again once.
   *
   * <p><b>Internal use:</b> used by {@link com.sinch.sdk.SinchClient#http()}, not part of the SDK
   * public API. It may change without notice.
   *
   * @param request Request to send, without authorization header
   * @param authManager Manager of the authorization header injected onto the request, <code>null
   *     </code> to send it without authorization header
   * @param signedBody Body signed by the authentication scheme (signed requests), <code>null</code>
   *     when none
   * @param retryManager Policy applied to rate-limited responses
   * @param timeoutSeconds Timeout of the request, <code>null</code> for the client one
   * @return Response of the last attempt, whatever its status code
   * @throws ApiException if the request could not be sent
   * @since 2.5
   */
  public com.sinch.sdk.core.http.transport.HttpResponse send(
      com.sinch.sdk.core.http.transport.HttpRequest request,
      AuthManager authManager,
      String signedBody,
      RetryManager retryManager,
      Integer timeoutSeconds)
      throws ApiException {

    HttpTransport activeTransport = this.transport;
    if (activeTransport == null) {
      throw new ApiException("HTTP client has been closed");
    }

    Map<String, AuthManager> authManagers =
        null == authManager
            ? Collections.emptyMap()
            : Collections.singletonMap(authManager.getSchema(), authManager);
    TransportCall call =
        new TransportCall(
            activeTransport,
            request,
            authManagers,
            new ArrayList<>(authManagers.keySet()),
            signedBody,
            timeoutSeconds);

    LOGGER.fine("Invoke '" + request.getMethod() + "' onto '" + request.getUrl() + "'");
    LOGGER.fine("queryParameters: " + request.getQueryParameters().orElse(null));
    LOGGER.fine("content: " + request.getContent().orElse(null));
    LOGGER.fine("headers: " + request.getHeaders());
    LOGGER.fine("authenticated: " + (null != authManager));

    try {
      com.sinch.sdk.core.http.transport.HttpResponse response = exchange(call, retryManager);
      LOGGER.finest("connection response: " + response);

      if (authManager instanceof OAuthManager
          && response.getStatus() == HttpStatus.UNAUTHORIZED
          && isExpiredTokenChallenge(
              response.getHeaders().getAll(BEARER_AUTHENTICATE_RESPONSE_HEADER_KEYWORD).stream())) {
        response.close();
        authManager.resetToken();
        response = exchange(call, retryManager);
        LOGGER.finest("connection response on retry: " + response);
      }
      return response;
    } catch (Exception e) {
      throw toApiException(e);
    }
  }

  private static ApiException toApiException(Exception e) {
    if (e instanceof ClientProtocolException) {
      ClientProtocolException cpe = (ClientProtocolException) e;
      int code = extractHttpStatusCode(cpe);
      if (code > 0) {
        LOGGER.severe("HTTP protocol error with status code " + code + ": " + cpe.getMessage());
        return new ApiException(
            "HTTP protocol error (status code " + code + "): " + cpe.getMessage(), cpe, code);
      }
      LOGGER.severe("HTTP protocol error: " + cpe.getMessage());
      return new ApiException("HTTP protocol error: " + cpe.getMessage(), cpe);
    }
    LOGGER.severe("Error:" + e);
    if (e instanceof ApiException) {
      return (ApiException) e;
    }
    return new ApiException(e);
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
    // header names are case-insensitive: the server can send it as "WWW-Authenticate"
    boolean headerPresent =
        isExpiredTokenChallenge(
            response.getHeaders().entrySet().stream()
                .filter(
                    entry ->
                        BEARER_AUTHENTICATE_RESPONSE_HEADER_KEYWORD.equalsIgnoreCase(
                            entry.getKey()))
                .map(Map.Entry::getValue)
                .filter(Objects::nonNull)
                .flatMap(List::stream));
    if (headerPresent) {
      bearerAuthManager.resetToken();
    }
    return headerPresent;
  }

  private static boolean isExpiredTokenChallenge(Stream<String> authenticateHeaderValues) {
    return authenticateHeaderValues.anyMatch(e -> null != e && e.contains(BEARER_EXPIRED_KEYWORD));
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

  /**
   * Performs one HTTP exchange under the retry policy, so that a rate-limited response is retried
   * for every endpoint that goes through this transport.
   */
  private HttpResponse send(TransportCall call) throws Exception {
    try (com.sinch.sdk.core.http.transport.HttpResponse response = exchange(call, retryManager)) {
      return TransportRequestMapper.toServiceResponse(response);
    }
  }

  /**
   * Performs one HTTP exchange under a retry policy, and returns the response of the last attempt.
   * The responses of the previous attempts are closed.
   */
  private static com.sinch.sdk.core.http.transport.HttpResponse exchange(
      TransportCall call, RetryManager retryManager) throws Exception {
    // Authorization of the first attempt is computed outside the retry policy: fetching a token
    // then goes through its own retry policy rather than sharing the one of this request
    call.authorize();

    AtomicBoolean firstAttempt = new AtomicBoolean(true);
    AtomicReference<com.sinch.sdk.core.http.transport.HttpResponse> last = new AtomicReference<>();
    try {
      retryManager.execute(
          () -> {
            if (!firstAttempt.getAndSet(false)) {
              call.authorize();
            }
            com.sinch.sdk.core.http.transport.HttpResponse previous = last.getAndSet(null);
            if (null != previous) {
              previous.close();
            }
            com.sinch.sdk.core.http.transport.HttpResponse response = call.exchange();
            last.set(response);
            return TransportRequestMapper.toRetryView(response);
          });
    } catch (Exception e) {
      com.sinch.sdk.core.http.transport.HttpResponse response = last.get();
      if (null != response) {
        response.close();
      }
      throw e;
    }
    if (null == last.get()) {
      throw new ApiException("No response received");
    }
    return last.get();
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
