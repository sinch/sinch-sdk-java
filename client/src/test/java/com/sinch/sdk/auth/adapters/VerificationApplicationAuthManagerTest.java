package com.sinch.sdk.auth.adapters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpContentType;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.utils.Pair;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class VerificationApplicationAuthManagerTest {

  static final String KEY = "my-key-id";
  static final String SECRET =
      Base64.getEncoder().encodeToString("my-key-secret".getBytes(StandardCharsets.UTF_8));

  AuthManager authManager = new VerificationApplicationAuthManager(KEY, SECRET);

  @Test
  void getSchema() {
    assertEquals("Basic", authManager.getSchema());
  }

  @Test
  void getAuthorizationHeaderValue() {
    String method = HttpMethod.POST.name();
    String contentType = HttpContentType.APPLICATION_JSON + "; charset=UTF-8";
    String path = "/path/pathParamValue";
    String body =
        "{\"identity\":{\"type\":\"number\",\"endpoint\":\"+33444555666\"},\"method\":\"sms\"}";

    Instant timestamp = Instant.parse("2023-11-22T09:10:11.999Z");

    try (MockedStatic<Instant> utilities = Mockito.mockStatic(Instant.class)) {
      utilities.when(Instant::now).thenReturn(timestamp);

      Collection<Pair<String, String>> expectedHeaders =
          Arrays.asList(
              new Pair<>(
                  "Authorization",
                  "Application my-key-id:QP3OzQZVzRZAEev6DBLvJkgpiqyZPuXYsc7oyjUV0K8="),
              new Pair<>("x-timestamp", timestamp.toString()));

      Collection<Pair<String, String>> headers =
          authManager.getAuthorizationHeaders(method, contentType, path, body);

      Assertions.assertThat(headers).usingRecursiveComparison().isEqualTo(expectedHeaders);
    }
  }
}
