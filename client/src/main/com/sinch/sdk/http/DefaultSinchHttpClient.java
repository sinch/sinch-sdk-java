package com.sinch.sdk.http;

import static com.sinch.sdk.core.http.HttpContentType.CONTENT_TYPE_HEADER;

import com.sinch.sdk.auth.adapters.OAuthManager;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.exceptions.ApiHttpException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.transport.HttpContent;
import com.sinch.sdk.core.http.transport.HttpHeaders;
import com.sinch.sdk.core.http.transport.HttpRequest;
import com.sinch.sdk.core.http.transport.HttpResponse;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.models.TransportSettings;
import com.sinch.sdk.models.UnifiedCredentials;
import java.io.File;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * {@link SinchHttpClient} implementation the SDK ships with, sending the requests with the HTTP
 * client of the domain services.
 *
 * @since 2.5
 */
public class DefaultSinchHttpClient implements SinchHttpClient {

  static final String USER_AGENT_HEADER = "User-Agent";

  private static final HttpRequestOptions NO_OPTIONS = HttpRequestOptions.builder().build();

  private final UnifiedCredentials credentials;
  private final ServerConfiguration oAuthServer;
  private final TransportSettings transportSettings;
  private final String userAgent;
  private final Supplier<HttpClientApache> httpClientSupplier;

  private volatile AuthManager oAuthManager;

  /**
   * @param credentials Credentials used to fetch the OAuth tokens, <code>null</code> when none
   * @param oAuthServer Server delivering the OAuth tokens
   * @param transportSettings Settings applied to the calls not overriding them, <code>null</code>
   *     for {@link TransportSettings#DEFAULTS}
   * @param userAgent Value of the <code>User-Agent</code> header sent onto every request
   * @param httpClientSupplier HTTP client the requests are sent with
   * @since 2.5
   */
  public DefaultSinchHttpClient(
      UnifiedCredentials credentials,
      ServerConfiguration oAuthServer,
      TransportSettings transportSettings,
      String userAgent,
      Supplier<HttpClientApache> httpClientSupplier) {
    this.credentials = credentials;
    this.oAuthServer = oAuthServer;
    this.transportSettings =
        null != transportSettings ? transportSettings : TransportSettings.DEFAULTS;
    this.userAgent = Objects.requireNonNull(userAgent, "userAgent");
    this.httpClientSupplier = Objects.requireNonNull(httpClientSupplier, "httpClientSupplier");
  }

  @Override
  public HttpResponse get(String url) throws ApiException {
    return get(url, null);
  }

  @Override
  public HttpResponse get(String url, HttpCallParameters parameters) throws ApiException {
    return call(HttpMethod.GET, url, null, parameters);
  }

  @Override
  public HttpResponse delete(String url) throws ApiException {
    return delete(url, null);
  }

  @Override
  public HttpResponse delete(String url, HttpCallParameters parameters) throws ApiException {
    return call(HttpMethod.DELETE, url, null, parameters);
  }

  @Override
  public HttpResponse post(String url, String body, HttpCallParameters parameters)
      throws ApiException {
    return callWithText(HttpMethod.POST, url, body, parameters);
  }

  @Override
  public HttpResponse post(String url, byte[] body, HttpCallParameters parameters)
      throws ApiException {
    return callWithBody(HttpMethod.POST, url, HttpContent.ofBytes(body), parameters);
  }

  @Override
  public HttpResponse post(String url, File body, HttpCallParameters parameters)
      throws ApiException {
    return callWithBody(HttpMethod.POST, url, HttpContent.ofFile(body), parameters);
  }

  @Override
  public HttpResponse postFormData(
      String url, Map<String, ?> formParameters, HttpCallParameters parameters)
      throws ApiException {
    return call(HttpMethod.POST, url, HttpContent.ofFormData(formParameters), parameters);
  }

  @Override
  public HttpResponse put(String url, String body, HttpCallParameters parameters)
      throws ApiException {
    return callWithText(HttpMethod.PUT, url, body, parameters);
  }

  @Override
  public HttpResponse put(String url, byte[] body, HttpCallParameters parameters)
      throws ApiException {
    return callWithBody(HttpMethod.PUT, url, HttpContent.ofBytes(body), parameters);
  }

  @Override
  public HttpResponse put(String url, File body, HttpCallParameters parameters)
      throws ApiException {
    return callWithBody(HttpMethod.PUT, url, HttpContent.ofFile(body), parameters);
  }

  @Override
  public HttpResponse patch(String url, String body, HttpCallParameters parameters)
      throws ApiException {
    return callWithText(HttpMethod.PATCH, url, body, parameters);
  }

  @Override
  public HttpResponse patch(String url, byte[] body, HttpCallParameters parameters)
      throws ApiException {
    return callWithBody(HttpMethod.PATCH, url, HttpContent.ofBytes(body), parameters);
  }

  @Override
  public HttpResponse patch(String url, File body, HttpCallParameters parameters)
      throws ApiException {
    return callWithBody(HttpMethod.PATCH, url, HttpContent.ofFile(body), parameters);
  }

  private HttpResponse callWithText(
      HttpMethod method, String url, String body, HttpCallParameters parameters) {
    Objects.requireNonNull(body, "body");
    HttpHeaders headers = requireContentType(parameters);
    return call(
        method, url, HttpContent.ofBytes(TransportRequestMapper.encode(body, headers)), parameters);
  }

  private HttpResponse callWithBody(
      HttpMethod method, String url, HttpContent content, HttpCallParameters parameters) {
    requireContentType(parameters);
    return call(method, url, content, parameters);
  }

  // a body is sent untouched: the caller has to describe it, failing before the server does
  private static HttpHeaders requireContentType(HttpCallParameters parameters) {
    HttpHeaders headers =
        null == parameters ? new HttpHeaders() : parameters.getHeaders().orElse(new HttpHeaders());
    boolean present =
        headers.getAll(CONTENT_TYPE_HEADER).stream().anyMatch(value -> !value.trim().isEmpty());
    if (!present) {
      throw new IllegalArgumentException(
          "The 'content-type' header is required when sending a body: set it in the headers of"
              + " the HttpCallParameters (e.g. 'application/json')");
    }
    return headers;
  }

  private HttpResponse call(
      HttpMethod method, String url, HttpContent content, HttpCallParameters parameters) {

    HttpCallParameters guard =
        null != parameters ? parameters : HttpCallParameters.builder().build();
    HttpRequestOptions options = guard.getOptions().orElse(NO_OPTIONS);

    HttpRequest request = toRequest(method, url, content, guard);

    boolean useSinchAuth = options.getUseSinchAuth().orElse(transportSettings.getUseSinchAuth());
    AuthManager authManager = useSinchAuth ? oAuthManager() : null;

    HttpClientApache httpClient = httpClientSupplier.get();
    RetryManager retryManager =
        options
            .getRetryConfiguration()
            .<RetryManager>map(DefaultRetryManager::new)
            .orElseGet(() -> httpClient.getRetryManager().orElse(RetryManager.NO_RETRY));

    HttpResponse response =
        httpClient.send(
            request, authManager, retryManager, options.getTimeoutSeconds().orElse(null));

    if (response.getStatus() >= 400) {
      throw new ApiHttpException(response);
    }
    return response;
  }

  private HttpRequest toRequest(
      HttpMethod method, String url, HttpContent content, HttpCallParameters parameters) {

    Objects.requireNonNull(url, "url");
    int queryIndex = url.indexOf('?');
    String urlQuery = queryIndex < 0 ? null : url.substring(queryIndex);
    String parametersQuery =
        parameters
            .getQueryParameters()
            .filter(query -> !query.isEmpty())
            .map(query -> query.startsWith("?") ? query : "?" + query)
            .orElse(null);
    if (null != urlQuery && null != parametersQuery) {
      throw new IllegalArgumentException(
          "Query parameters are set both in the URL ('"
              + urlQuery
              + "') and in the call parameters ('"
              + parametersQuery
              + "'): set them only once");
    }

    // the SDK User-Agent replaces any one set by the caller
    HttpHeaders headers = parameters.getHeaders().orElse(new HttpHeaders());
    headers.set(USER_AGENT_HEADER, userAgent);

    return HttpRequest.builder()
        .setMethod(method)
        .setUrl(queryIndex < 0 ? url : url.substring(0, queryIndex))
        .setQueryParameters(null != urlQuery ? urlQuery : parametersQuery)
        .setHeaders(headers)
        .setContent(content)
        .build();
  }

  private AuthManager oAuthManager() {
    if (null == oAuthManager) {
      synchronized (this) {
        if (null == oAuthManager) {
          Objects.requireNonNull(
              credentials,
              "HTTP client requires unified credentials to be defined to authenticate a call");
          StringUtil.requireNonEmpty(
              credentials.getKeyId(),
              "HTTP client requires 'keyId' to be defined to authenticate a call");
          StringUtil.requireNonEmpty(
              credentials.getKeySecret(),
              "HTTP client requires 'keySecret' to be defined to authenticate a call");
          oAuthManager =
              new OAuthManager(
                  credentials.getKeyId(),
                  credentials.getKeySecret(),
                  oAuthServer,
                  HttpMapper.getInstance(),
                  httpClientSupplier::get);
        }
      }
    }
    return oAuthManager;
  }
}
