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
import com.sinch.sdk.core.utils.DateUtil;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.models.UnifiedCredentials;
import java.time.Duration;
import java.time.Instant;
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

  private static final double BACKOFF_BASE_SECONDS = 1.0;
  private static final int BACKOFF_GROWTH = 4;

  private static final String RETRY_AFTER_HEADER = "Retry-After";

  protected static final int MAX_RATE_LIMIT_RETRIES = 3;

  private static final long RETRY_AFTER_JITTER_MILLIS = 250L;

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

  /** Fetches a token, retrying only while the authentication service reports a rate limit. */
  private String getNewToken() {

    for (int attempt = 0; ; attempt++) {
      HttpResponse response = callOAuthEndpoint();
      if (response.getCode() != HttpStatus.TOO_MANY_REQUESTS) {
        return extractAccessToken(response);
      }
      if (attempt >= MAX_RATE_LIMIT_RETRIES) {
        throw new ApiAuthException(
            "Token refresh failed: rate limited by the authentication service (HTTP 429) after "
                + (MAX_RATE_LIMIT_RETRIES + 1)
                + " attempts");
      }
      long sleepMillis = computeBackoffMillis(response, attempt);
      LOGGER.fine(
          "Rate limited (HTTP 429) during token refresh, attempt "
              + (attempt + 1)
              + "/"
              + (MAX_RATE_LIMIT_RETRIES + 1)
              + ", waiting "
              + sleepMillis
              + "ms before retrying");
      try {
        Thread.sleep(sleepMillis);
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        throw new ApiAuthException("Token refresh interrupted");
      }
    }
  }

  /** Performs the OAuth request once. A transport failure or a missing response is final. */
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
    HttpResponse httpResponse;
    try {
      httpResponse = httpClientSupplier.get().invokeAPI(oAuthServer, authManagers, request);
    } catch (Exception e) {
      throw new ApiAuthException(
          "OAuth request failed: network or client error: " + e.getMessage());
    }
    if (httpResponse == null) {
      throw new ApiAuthException("OAuth request failed: no response received");
    }
    return httpResponse;
  }

  private String extractAccessToken(HttpResponse response) {

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

  long computeBackoffMillis(HttpResponse response, int attempt) {
    Optional<Long> retryAfter =
        retryAfterHeader(response).flatMap(OAuthManager::parseRetryAfterMillis);
    if (retryAfter.isPresent()) {
      return retryAfter.get() + ThreadLocalRandom.current().nextLong(RETRY_AFTER_JITTER_MILLIS + 1);
    }
    double maxDelay = BACKOFF_BASE_SECONDS * Math.pow(BACKOFF_GROWTH, attempt);
    return (long) (ThreadLocalRandom.current().nextDouble(maxDelay) * 1000);
  }

  private static Optional<String> retryAfterHeader(HttpResponse response) {
    return response.getHeaders().entrySet().stream()
        .filter(entry -> RETRY_AFTER_HEADER.equalsIgnoreCase(entry.getKey()))
        .map(Map.Entry::getValue)
        .filter(values -> null != values && !values.isEmpty())
        .map(values -> values.get(0))
        .findFirst();
  }

  private static Optional<Long> parseRetryAfterMillis(String value) {
    String trimmed = null == value ? "" : value.trim();
    if (trimmed.isEmpty()) {
      return Optional.empty();
    }
    try {
      double seconds = Double.parseDouble(trimmed);
      boolean usable = seconds >= 0 && seconds < Long.MAX_VALUE / 1000d;
      return usable ? Optional.of((long) (seconds * 1000)) : Optional.empty();
    } catch (NumberFormatException notDeltaSeconds) {
    }
    // Not a number, so try the HTTP-date form: all three RFC 7231 spellings are accepted.
    Instant retryAt = DateUtil.RFC7231StringToInstant(trimmed);
    if (null == retryAt) {
      return Optional.empty();
    }
    try {
      return Optional.of(Math.max(0, Duration.between(Instant.now(), retryAt).toMillis()));
    } catch (ArithmeticException tooFarInTheFuture) {
      return Optional.empty();
    }
  }

  public boolean validateAuthenticatedRequest(
      String method, String path, Map<String, String> headers, String jsonPayload) {
    LOGGER.severe("checkAuthentication not implemented");
    return false;
  }
}
