package com.sinch.sdk.auth.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.utils.Pair;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Logger;

public class BearerAuthManager implements AuthManager {

  private static final Logger LOGGER = Logger.getLogger(BearerAuthManager.class.getName());

  private static final String AUTH_KEYWORD = "Bearer";
  private final String token;

  public BearerAuthManager(String token) {
    this.token = token;
  }

  public String getSchema() {
    return SCHEMA_KEYWORD_BEARER;
  }

  @Override
  public void resetToken() {
    // no op
  }

  @Override
  public Collection<Pair<String, String>> getAuthorizationHeaders(
      String timestamp, String method, String httpContentType, String path, String body) {

    return Collections.singletonList(new Pair<>("Authorization", AUTH_KEYWORD + " " + token));
  }

  public boolean validateAuthenticatedRequest(
      String method, String path, Map<String, String> headers, String jsonPayload) {
    LOGGER.severe("checkAuthentication not implemented");
    return false;
  }
}
