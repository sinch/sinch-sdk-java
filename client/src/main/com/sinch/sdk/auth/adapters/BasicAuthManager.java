package com.sinch.sdk.auth.adapters;

import com.sinch.sdk.auth.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.models.Configuration;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class BasicAuthManager implements AuthManager {
  public static final String BASIC_SCHEMA_KEYWORD = "BasicAuth";
  private static final String BASIC_AUTH_KEYWORD = "Basic";
  private final Configuration configuration;

  public BasicAuthManager(Configuration configuration) {
    this.configuration = configuration;
  }

  public String getSchema() {
    return BASIC_SCHEMA_KEYWORD;
  }

  @Override
  public void setHttpClient(HttpClient httpClient) {
    // no op
  }

  @Override
  public void resetToken() {
    // no op
  }

  @Override
  public String getAuthorizationHeaderValue() {
    String key = configuration.getKeyId() == null ? "" : configuration.getKeyId();
    String secret = configuration.getKeySecret() == null ? "" : configuration.getKeySecret();

    String raw = key + ":" + secret;

    return BASIC_AUTH_KEYWORD
        + " "
        + Base64.getEncoder().encodeToString(raw.getBytes(StandardCharsets.UTF_8));
  }
}
