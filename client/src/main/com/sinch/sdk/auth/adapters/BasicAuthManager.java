package com.sinch.sdk.auth.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.models.Configuration;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;

public class BasicAuthManager implements AuthManager {

  private static final String AUTH_KEYWORD = "Basic";
  private final String keyId;
  private final String keySecret;

  public BasicAuthManager(Configuration configuration) {
    this.keyId = configuration.getKeyId();
    this.keySecret = configuration.getKeySecret();
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
      String method, String httpContentType, String path, String body) {
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
}
