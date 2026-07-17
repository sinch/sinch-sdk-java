package com.sinch.sdk.auth.adapters;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sinch.sdk.auth.models.BearerAuthResponse;
import com.sinch.sdk.core.exceptions.ApiAuthException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.http.HttpStatus;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OAuthManager implements AuthManager {

  public static final String BEARER_EXPIRED_KEYWORD = "expired";
  public static final String BEARER_AUTHENTICATE_RESPONSE_HEADER_KEYWORD = "www-authenticate";
  private static final Logger LOGGER = Logger.getLogger(OAuthManager.class.getName());
  private static final String AUTH_KEYWORD = "Bearer";
  // Total refresh attempts for 429 and other failures; sufficient given the backoff.
  protected static final int MAX_REFRESH_ATTEMPT = 3;

  private static final double BACKOFF_BASE_SECONDS = 1.0;
  private static final int BACKOFF_GROWTH = 4;

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
          refreshToken();
          currentToken = token;
        }
      }
    }
    return Collections.singletonList(
        new Pair<>("Authorization", AUTH_KEYWORD + " " + currentToken));
  }

  private void refreshToken() {

    int attempt = 0;
    while (attempt < MAX_REFRESH_ATTEMPT) {
      Optional<String> newValue = getNewToken(attempt);
      if (newValue.isPresent()) {
        token = newValue.get();
        return;
      }
      attempt++;
    }
    throw new ApiAuthException("Unable to get new token");
  }

  private Optional<String> getNewToken(int attempt) {

    LOGGER.fine("Refreshing OAuth token");
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
    HttpResponse httpResponse;
    try {
      httpResponse = httpClientSupplier.get().invokeAPI(oAuthServer, authManagers, request);
    } catch (Exception e) {
      throw new ApiAuthException(
          "Token refresh failed: network or client error: " + e.getMessage());
    }
    if (httpResponse == null) {
      throw new ApiAuthException("Token refresh failed: no response received");
    }

    if (httpResponse.getCode() == HttpStatus.TOO_MANY_REQUESTS) {
      // Only back off if another attempt will follow; on the last attempt we give up immediately.
      if (attempt < MAX_REFRESH_ATTEMPT - 1) {
        long sleepMillis = computeBackoffMillis(attempt);
        LOGGER.fine(
            "Rate limited (HTTP 429) during token refresh, attempt "
                + (attempt + 1)
                + "/"
                + MAX_REFRESH_ATTEMPT
                + ", waiting "
                + sleepMillis
                + "ms before next attempt");
        try {
          Thread.sleep(sleepMillis);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
          throw new ApiAuthException("Token refresh interrupted");
        }
      }
      return Optional.empty();
    }

    if (!HttpStatus.isSuccessfulStatus(httpResponse.getCode())) {
      throw new ApiAuthException("Token refresh failed with HTTP " + httpResponse.getCode());
    }

    try {
      BearerAuthResponse authResponse =
          mapper.deserialize(httpResponse, new TypeReference<BearerAuthResponse>() {});
      return Optional.ofNullable(authResponse.getAccessToken());
    } catch (Exception e) {
      throw new ApiAuthException(
          "Token refresh failed: could not deserialize response: " + e.getMessage());
    }
  }

  long computeBackoffMillis(int attempt) {
    double maxDelay = BACKOFF_BASE_SECONDS * Math.pow(BACKOFF_GROWTH, attempt);
    return (long) (ThreadLocalRandom.current().nextDouble(maxDelay) * 1000);
  }

  public boolean validateAuthenticatedRequest(
      String method, String path, Map<String, String> headers, String jsonPayload) {
    LOGGER.severe("checkAuthentication not implemented");
    return false;
  }
}
