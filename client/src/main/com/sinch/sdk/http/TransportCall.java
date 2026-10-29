package com.sinch.sdk.http;

import static com.sinch.sdk.core.http.HttpContentType.CONTENT_TYPE_HEADER;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.transport.HttpHeaders;
import com.sinch.sdk.core.http.transport.HttpRequest;
import com.sinch.sdk.core.http.transport.HttpResponse;
import com.sinch.sdk.core.http.transport.HttpTransport;
import com.sinch.sdk.core.utils.Pair;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;
import java.util.logging.Logger;

/**
 * One call of an SDK service: the request sent through an {@link HttpTransport}, authorized by the
 * authentication schemes it supports.
 *
 * <p>The authorization headers are computed by {@link #authorize()}, then sent by every {@link
 * #send()} until the next {@link #authorize()}. A call is used by a single thread.
 */
final class TransportCall {

  private static final Logger LOGGER = Logger.getLogger(TransportCall.class.getName());

  private final HttpTransport transport;
  private final HttpRequest request;
  private final Map<String, AuthManager> authManagersByOasSecuritySchemes;
  private final Collection<String> authNames;
  private final String body;

  private HttpRequest authorized;

  /**
   * @param transport Transport the request is sent with
   * @param request Request to send, without authorization headers
   * @param authManagersByOasSecuritySchemes Authentication managers available
   * @param authNames Authentication schemes supported by the request, in order of preference
   * @param body Body signed by the authentication schemes, <code>null</code> when none
   */
  TransportCall(
      HttpTransport transport,
      HttpRequest request,
      Map<String, AuthManager> authManagersByOasSecuritySchemes,
      Collection<String> authNames,
      String body) {
    this.transport = transport;
    this.request = request;
    this.authManagersByOasSecuritySchemes = authManagersByOasSecuritySchemes;
    this.authNames = authNames;
    this.body = body;
    this.authorized = request;
  }

  /**
   * @return Request to send, without authorization headers
   */
  HttpRequest getRequest() {
    return request;
  }

  /**
   * Compute the authorization headers, with the first supported scheme that has a manager. A token
   * may be fetched from the authentication server.
   */
  void authorize() {
    authorized = withAuth();
  }

  /**
   * Send the request with the latest authorization headers
   *
   * @return Response to be consumed by the SDK services
   * @throws IOException if the exchange failed
   */
  com.sinch.sdk.core.http.HttpResponse send() throws IOException {
    try (HttpResponse response = transport.send(authorized)) {
      return TransportRequestMapper.toServiceResponse(response);
    }
  }

  private HttpRequest withAuth() {

    if (null == authNames || authNames.isEmpty() || null == authManagersByOasSecuritySchemes) {
      return request;
    }

    for (String entry : authNames) {
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
        return HttpRequest.builder(request).setHeaders(headers).build();
      } else {
        LOGGER.finest("Ignore unknown authentication value: '" + entry + "'");
      }
    }
    return request;
  }
}
