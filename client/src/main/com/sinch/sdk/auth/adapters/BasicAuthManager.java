package com.sinch.sdk.auth.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.models.UnifiedCredentials;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Logger;

public class BasicAuthManager implements AuthManager {

  private static final Logger LOGGER = Logger.getLogger(BasicAuthManager.class.getName());

  private static final String AUTH_KEYWORD = "Basic";
  private final String keyId;
  private final String keySecret;

  public BasicAuthManager(UnifiedCredentials credentials) {
    this(credentials.getKeyId(), credentials.getKeySecret());
  }

  public BasicAuthManager(String keyId, String keySecret) {
    this.keyId = keyId;
    this.keySecret = keySecret;
  }

  public String getSchema() {
    return SCHEMA_KEYWORD_BASIC;
  }

  @Override
  public void resetToken() {
    // no op
  }

  @Override
  public Collection<Pair<String, String>> getAuthorizationHeaders(
      String timestamp, String method, String httpContentType, String path, String body) {
    String key = keyId == null ? "" : keyId;
    String secret = keySecret == null ? "" : keySecret;

    String raw = key + ":" + secret;

    return Collections.singletonList(
        new Pair<>(
            "Authorization",
            AUTH_KEYWORD
                + " "
                + Base64.getEncoder().encodeToString(raw.getBytes(StandardCharsets.UTF_8))));
  }

  public boolean validateAuthenticatedRequest(
      String method, String path, Map<String, String> headers, String jsonPayload) {
    LOGGER.severe("checkAuthentication not implemented");
    return false;
  }
}
