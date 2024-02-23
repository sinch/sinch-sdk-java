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
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OAuthManager implements AuthManager {

  public static final String BEARER_EXPIRED_KEYWORD = "expired";
  public static final String BEARER_AUTHENTICATE_RESPONSE_HEADER_KEYWORD = "www-authenticate";
  private static final Logger LOGGER = Logger.getLogger(OAuthManager.class.getName());
  private static final String AUTH_KEYWORD = "Bearer";
  private static final int maxRefreshAttempt = 5;
  private final ServerConfiguration oAuthServer;
  private final HttpMapper mapper;
  private final HttpClient httpClient;
  private final Map<String, AuthManager> authManagers;
  private String token;

  public OAuthManager(
      UnifiedCredentials credentials,
      ServerConfiguration oAuthServer,
      HttpMapper mapper,
      HttpClient httpClient) {
    this(credentials.getKeyId(), credentials.getKeySecret(), oAuthServer, mapper, httpClient);
  }

  public OAuthManager(
      String keyId,
      String keySecret,
      ServerConfiguration oAuthServer,
      HttpMapper mapper,
      HttpClient httpClient) {
    this.oAuthServer = oAuthServer;
    this.mapper = mapper;
    this.httpClient = httpClient;

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

    if (token == null) {
      refreshToken();
    }
    return Collections.singletonList(new Pair<>("Authorization", AUTH_KEYWORD + " " + token));
  }

  private void refreshToken() {

    int attempt = 0;
    while (attempt < maxRefreshAttempt) {
      Optional<String> newValue = getNewToken();
      if (newValue.isPresent()) {
        token = newValue.get();
        return;
      }
      attempt++;
    }
    throw new ApiAuthException("Unable to get new token");
  }

  private Optional<String> getNewToken() {

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
    try {
      HttpResponse httpResponse = httpClient.invokeAPI(oAuthServer, authManagers, request);
      BearerAuthResponse authResponse =
          mapper.deserialize(httpResponse, new TypeReference<BearerAuthResponse>() {});
      return Optional.ofNullable(authResponse.getAccessToken());
    } catch (Exception e) {
      return Optional.empty();
    }
  }

  public boolean validateAuthenticatedRequest(
      String method, String path, Map<String, String> headers, String jsonPayload) {
    LOGGER.severe("checkAuthentication not implemented");
    return false;
  }
}
