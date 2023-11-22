package com.sinch.sdk.auth.adapters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.models.Configuration;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import org.junit.jupiter.api.Test;

class BasicAuthManagerTest {

  static final String KEY = "fooKey";
  static final String SECRET = "fooSecret";
  static final String PROJECT = "fooProject";

  Configuration configuration =
      Configuration.builder().setKeyId(KEY).setKeySecret(SECRET).setProjectId(PROJECT).build();

  AuthManager authManager = new BasicAuthManager(configuration);

  @Test
  void getSchema() {
    assertEquals("Basic", authManager.getSchema());
  }

  @Test
  void getAuthorizationHeaderValue() {

    String expectedToken =
        "Basic "
            + Base64.getEncoder()
                .encodeToString(
                    (configuration.getKeyId() + ":" + configuration.getKeySecret())
                        .getBytes(StandardCharsets.UTF_8));
    assertEquals(expectedToken, authManager.getAuthorizationHeaderValue());
  }
}
