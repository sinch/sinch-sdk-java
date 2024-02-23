package com.sinch.sdk.auth.adapters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.models.UnifiedCredentials;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Collection;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BasicAuthManagerTest {

  static final String KEY = "fooKey";
  static final String SECRET = "fooSecret";
  static final String PROJECT = "fooProject";

  UnifiedCredentials credentials =
      UnifiedCredentials.builder().setKeyId(KEY).setKeySecret(SECRET).setProjectId(PROJECT).build();

  AuthManager authManager = new BasicAuthManager(credentials);

  @Test
  void getSchema() {
    assertEquals("Basic", authManager.getSchema());
  }

  @Test
  void getAuthorizationHeaders() {

    Collection<Pair<String, String>> expectedHeaders =
        Collections.singletonList(
            new Pair<>(
                "Authorization",
                "Basic "
                    + Base64.getEncoder()
                        .encodeToString(
                            (credentials.getKeyId() + ":" + credentials.getKeySecret())
                                .getBytes(StandardCharsets.UTF_8))));

    Collection<Pair<String, String>> headers =
        authManager.getAuthorizationHeaders(null, null, null, null);

    Assertions.assertThat(headers).usingRecursiveComparison().isEqualTo(expectedHeaders);
  }
}
