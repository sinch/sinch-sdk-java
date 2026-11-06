package com.sinch.sdk;

import static com.sinch.sdk.core.http.HttpContentType.CONTENT_TYPE_HEADER;

import com.sinch.sdk.auth.adapters.ApplicationAuthManager;
import com.sinch.sdk.auth.adapters.BearerAuthManager;
import com.sinch.sdk.auth.adapters.OAuthManager;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.exceptions.ApiHttpException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpContentType;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.transport.HttpContent;
import com.sinch.sdk.core.http.transport.HttpHeaders;
import com.sinch.sdk.core.http.transport.HttpRequest;
import com.sinch.sdk.core.http.transport.HttpResponse;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.http.DefaultRetryManager;
import com.sinch.sdk.http.HttpCallParameters;
import com.sinch.sdk.http.HttpClientApache;
import com.sinch.sdk.http.HttpRequestOptions;
import com.sinch.sdk.http.RetryManager;
import com.sinch.sdk.http.SinchHttpClient;
import com.sinch.sdk.models.ApplicationCredentials;
import com.sinch.sdk.models.SmsServicePlanCredentials;
import com.sinch.sdk.models.TransportSettings;
import com.sinch.sdk.models.UnifiedCredentials;
import java.io.File;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * {@link SinchHttpClient} implementation, sending the requests with the HTTP client of the domain
 * services. Created by {@link SinchClient#http()}.
 */
final class DefaultSinchHttpClient implements SinchHttpClient {

  static final String USER_AGENT_HEADER = "User-Agent";

  private static final HttpRequestOptions NO_OPTIONS = HttpRequestOptions.builder().build();

  private final UnifiedCredentials credentials;
  private final SmsServicePlanCredentials smsServicePlanCredentials;
  private final ApplicationCredentials applicationCredentials;
  private final ServerConfiguration oAuthServer;
  private final TransportSettings transportSettings;
  private final String userAgent;
  private final Supplier<HttpClientApache> httpClientSupplier;

  private volatile AuthManager authManager;

  /**
   * @param credentials Credentials used to fetch the OAuth tokens, <code>null</code> when none
   * @param smsServicePlanCredentials Credentials of the SMS API token, <code>null</code> when none
   * @param applicationCredentials Credentials of the signed requests, <code>null</code> when none
   * @param oAuthServer Server delivering the OAuth tokens
   * @param transportSettings Settings applied to the calls not overriding them, <code>null</code>
   *     for {@link TransportSettings#DEFAULTS}
   * @param userAgent Value of the <code>User-Agent</code> header sent onto every request
   * @param httpClientSupplier HTTP client the requests are sent with
   */
  DefaultSinchHttpClient(
      UnifiedCredentials credentials,
      SmsServicePlanCredentials smsServicePlanCredentials,
      ApplicationCredentials applicationCredentials,
      ServerConfiguration oAuthServer,
      TransportSettings transportSettings,
      String userAgent,
      Supplier<HttpClientApache> httpClientSupplier) {
    this.credentials = credentials;
    this.smsServicePlanCredentials = smsServicePlanCredentials;
    this.applicationCredentials = applicationCredentials;
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
    return call(method, url, HttpContent.ofBytes(encode(body, headers)), body, parameters);
  }

  private HttpResponse callWithBody(
      HttpMethod method, String url, HttpContent content, HttpCallParameters parameters) {
    requireContentType(parameters);
    return call(method, url, content, parameters);
  }

  private HttpResponse call(
      HttpMethod method, String url, HttpContent content, HttpCallParameters parameters) {
    return call(method, url, content, null, parameters);
  }

  // text is encoded with the charset of the content type, or UTF-8 when it does not define one
  private static byte[] encode(String body, HttpHeaders headers) {
    Charset charset =
        headers
            .getFirst(CONTENT_TYPE_HEADER)
            .flatMap(HttpContentType::getCharsetValue)
            .map(Charset::forName)
            .orElse(StandardCharsets.UTF_8);
    return body.getBytes(charset);
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

  /**
   * @param textBody Body of the request when sent as a <code>String</code>, signed by the
   *     application credentials; <code>null</code> otherwise
   */
  private HttpResponse call(
      HttpMethod method,
      String url,
      HttpContent content,
      String textBody,
      HttpCallParameters parameters) {

    HttpCallParameters guard =
        null != parameters ? parameters : HttpCallParameters.builder().build();
    HttpRequestOptions options = guard.getOptions().orElse(NO_OPTIONS);

    HttpRequest request = toRequest(method, url, content, guard);

    boolean useSinchAuth = options.getUseSinchAuth().orElse(transportSettings.getUseSinchAuth());
    AuthManager authManager = useSinchAuth ? authManager() : null;
    if (authManager instanceof ApplicationAuthManager && null != content && null == textBody) {
      throw new IllegalArgumentException(
          "A signed request (application credentials) requires a String body: the SDK signs the"
              + " text of the body, it cannot sign a byte[], File or form data body");
    }

    HttpClientApache httpClient = httpClientSupplier.get();
    RetryManager retryManager =
        options
            .getRetryConfiguration()
            .<RetryManager>map(DefaultRetryManager::new)
            .orElseGet(() -> httpClient.getRetryManager().orElse(RetryManager.NO_RETRY));

    HttpResponse response =
        httpClient.send(
            request, authManager, textBody, retryManager, options.getTimeoutSeconds().orElse(null));

    if (response.getStatus() >= 400) {
      throw new ApiHttpException(response);
    }
    return response;
  }

  private HttpRequest toRequest(
      HttpMethod method, String url, HttpContent content, HttpCallParameters parameters) {

    Objects.requireNonNull(url, "url");
    // the URL is sent as is: only the leading '?' of the query parameters is added when missing
    String query =
        parameters
            .getQueryParameters()
            .filter(value -> !value.isEmpty())
            .map(value -> value.startsWith("?") ? value : "?" + value)
            .orElse(null);

    // the SDK User-Agent replaces any one set by the caller
    HttpHeaders headers = parameters.getHeaders().orElse(new HttpHeaders());
    headers.set(USER_AGENT_HEADER, userAgent);

    return HttpRequest.builder()
        .setMethod(method)
        .setUrl(url)
        .setQueryParameters(query)
        .setHeaders(headers)
        .setContent(content)
        .build();
  }

  private AuthManager authManager() {
    AuthManager current = authManager;
    if (null == current) {
      synchronized (this) {
        if (null == authManager) {
          authManager = createAuthManager();
        }
        current = authManager;
      }
    }
    return current;
  }

  // OAuth is accepted by every Sinch API: it wins over the other credentials. Without it, the SDK
  // cannot tell which API is called, so it requires the credentials of a single other scheme
  private AuthManager createAuthManager() {
    if (null != credentials
        && !StringUtil.isEmpty(credentials.getKeyId())
        && !StringUtil.isEmpty(credentials.getKeySecret())) {
      return new OAuthManager(
          credentials.getKeyId(),
          credentials.getKeySecret(),
          oAuthServer,
          HttpMapper.getInstance(),
          httpClientSupplier::get);
    }
    boolean smsToken =
        null != smsServicePlanCredentials
            && !StringUtil.isEmpty(smsServicePlanCredentials.getServicePlanId())
            && !StringUtil.isEmpty(smsServicePlanCredentials.getApiToken());
    boolean application =
        null != applicationCredentials
            && !StringUtil.isEmpty(applicationCredentials.getApplicationKey())
            && !StringUtil.isEmpty(applicationCredentials.getApplicationSecret());
    if (smsToken && application) {
      throw new IllegalStateException(
          "HTTP client cannot choose between the SMS service plan credentials and the application"
              + " credentials to authenticate a call: define 'keyId' and 'keySecret' to use OAuth,"
              + " or keep only one of them");
    }
    if (smsToken) {
      return new BearerAuthManager(smsServicePlanCredentials.getApiToken());
    }
    if (application) {
      return new ApplicationAuthManager(
          applicationCredentials.getApplicationKey(),
          applicationCredentials.getApplicationSecret());
    }
    throw new IllegalStateException(
        "HTTP client requires credentials to authenticate a call: 'keyId' and 'keySecret' (OAuth),"
            + " SMS service plan credentials or application credentials. Set 'useSinchAuth' to"
            + " false to send it without authentication");
  }
}
