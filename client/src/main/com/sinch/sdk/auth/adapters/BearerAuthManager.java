package com.sinch.sdk.auth.adapters;

import com.fasterxml.jackson.core.type.TypeReference;
import com.sinch.sdk.auth.AuthManager;
import com.sinch.sdk.auth.models.BearerAuthResponse;
import com.sinch.sdk.core.exceptions.ApiAuthException;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.models.Configuration;
import java.util.Collections;
import java.util.Optional;
import java.util.logging.Logger;

public class BearerAuthManager implements AuthManager {
  public static final String BEARER_EXPIRED_KEYWORD = "expired";
  public static final String BEARER_AUTHENTICATE_RESPONSE_HEADER_KEYWORD = "www-authenticate";
  private static final Logger LOGGER = Logger.getLogger(BearerAuthManager.class.getName());
  private static final String SCHEMA_KEYWORD = "Bearer";
  private static final String AUTH_KEYWORD = "Bearer";
  private static final int maxRefreshAttempt = 5;
  private final Configuration configuration;
  private final HttpMapper mapper;
  private HttpClient httpClient;
  private String token;

  public BearerAuthManager(Configuration configuration, HttpMapper mapper) {
    this.configuration = configuration;
    this.mapper = mapper;
  }

  public String getSchema() {
    return SCHEMA_KEYWORD;
  }

  @Override
  public void setHttpClient(HttpClient httpClient) {
    this.httpClient = httpClient;
  }

  @Override
  public void resetToken() {
    token = null;
  }

  @Override
  public String getAuthorizationHeaderValue() {

    if (token == null) {
      refreshToken();
    }
    return AUTH_KEYWORD + " " + token;
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
            Collections.singletonList("Basic"));
    try {
      HttpResponse httpResponse = httpClient.invokeAPI(configuration.getOAuthServer(), request);
      BearerAuthResponse authResponse =
          mapper.deserialize(httpResponse, new TypeReference<BearerAuthResponse>() {});
      return Optional.ofNullable(authResponse.getAccessToken());
    } catch (Exception e) {
      return Optional.empty();
    }
  }
}
