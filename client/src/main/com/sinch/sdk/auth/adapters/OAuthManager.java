package com.sinch.sdk.auth.adapters;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sinch.sdk.auth.models.BearerAuthResponse;
import com.sinch.sdk.core.exceptions.ApiAuthException;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.http.HttpStatus;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.http.RetryCapable;
import com.sinch.sdk.http.RetryManager;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OAuthManager implements AuthManager {

  public static final String BEARER_EXPIRED_KEYWORD = "expired";
  public static final String BEARER_AUTHENTICATE_RESPONSE_HEADER_KEYWORD = "www-authenticate";
  private static final Logger LOGGER = Logger.getLogger(OAuthManager.class.getName());
  private static final String AUTH_KEYWORD = "Bearer";

  private final ServerConfiguration oAuthServer;
  private final HttpMapper mapper;
  private final Supplier<HttpClient> httpClientSupplier;
  private final Map<String, AuthManager> authManagers;
  private volatile String token;

  public OAuthManager(
      UnifiedCredentials credentials,
      ServerConfiguration oAuthServer,
      HttpMapper mapper,
      Supplier<HttpClient> httpClientSupplier) {
    this(
        credentials.getKeyId(),
        credentials.getKeySecret(),
        oAuthServer,
        mapper,
        httpClientSupplier);
  }

  public OAuthManager(
      String keyId,
      String keySecret,
      ServerConfiguration oAuthServer,
      HttpMapper mapper,
      Supplier<HttpClient> httpClientSupplier) {
    this.oAuthServer = oAuthServer;
    this.mapper = mapper;
    this.httpClientSupplier = httpClientSupplier;

    AuthManager basicAuthManager = new BasicAuthManager(keyId, keySecret);
    authManagers =
        Stream.of(new AbstractMap.SimpleEntry<>(SCHEMA_KEYWORD_BASIC, basicAuthManager))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
  }

  public String getSchema() {
    return SCHEMA_KEYWORD_BEARER;
  }

  @Override
  public void resetToken() {
    token = null;
  }

  @Override
  public Collection<Pair<String, String>> getAuthorizationHeaders(
      String timestamp, String method, String httpContentType, String path, String body) {

    String currentToken = token;
    if (currentToken == null) {
      synchronized (this) {
        currentToken = token;
        if (currentToken == null) {
          currentToken = getNewToken();
          token = currentToken;
        }
      }
    }
    return Collections.singletonList(
        new Pair<>("Authorization", AUTH_KEYWORD + " " + currentToken));
  }

  private String getNewToken() {
    return extractAccessToken(callOAuthEndpoint());
  }

  /**
   * Performs the OAuth request under the retry policy. A transport failure or a missing response is
   * final; a rate-limited one is retried for as long as the policy allows.
   */
  private HttpResponse callOAuthEndpoint() {

    LOGGER.fine("Calling OAuth endpoint");
    HttpRequest request =
        new HttpRequest(
            null,
            HttpMethod.POST,
            Collections.emptyList(),
            "grant_type=client_credentials",
            null,
            null,
            Collections.singletonList("application/x-www-form-urlencoded"),
            Collections.singletonList(SCHEMA_KEYWORD_BASIC));
    HttpClient httpClient = httpClientSupplier.get();
    HttpResponse httpResponse;
    try {
      httpResponse =
          retryManagerOf(httpClient)
              .execute(() -> httpClient.invokeAPI(oAuthServer, authManagers, request));
    } catch (Exception e) {
      throw new ApiAuthException(
          "OAuth request failed: network or client error: " + e.getMessage());
    }
    if (httpResponse == null) {
      throw new ApiAuthException("OAuth request failed: no response received");
    }
    return httpResponse;
  }

  private static RetryManager retryManagerOf(HttpClient client) {
    if (!(client instanceof RetryCapable)) {
      return RetryManager.DEFAULTS;
    }
    return ((RetryCapable) client).getRetryManager().orElse(RetryManager.NO_RETRY);
  }

  private String extractAccessToken(HttpResponse response) {

    // Reported with the status the server actually sent, not as an authentication failure: a
    // caller branching on HTTP 429 must see the same code here as from any other endpoint.
    if (response.getCode() == HttpStatus.TOO_MANY_REQUESTS) {
      throw new ApiException(
          HttpStatus.TOO_MANY_REQUESTS,
          "Token refresh failed: rate limited by the authentication service (HTTP 429)");
    }
    if (!HttpStatus.isSuccessfulStatus(response.getCode())) {
      throw new ApiAuthException("Unable to extract token with HTTP " + response.getCode());
    }

    BearerAuthResponse authResponse;
    try {
      authResponse = mapper.deserialize(response, new TypeReference<BearerAuthResponse>() {});
    } catch (Exception e) {
      throw new ApiAuthException(
          "Unable to extract token: could not deserialize response: " + e.getMessage());
    }

    String accessToken = null != authResponse ? authResponse.getAccessToken() : null;
    if (StringUtil.isEmpty(accessToken)) {
      throw new ApiAuthException(
          "Unable to extract token: the HTTP "
              + response.getCode()
              + " response carries no access_token");
    }
    return accessToken;
  }

  public boolean validateAuthenticatedRequest(
      String method, String path, Map<String, String> headers, String jsonPayload) {
    LOGGER.severe("checkAuthentication not implemented");
    return false;
  }
}
