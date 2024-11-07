package com.sinch.sdk.domains.voice.adapters;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.models.ApplicationCredentials;
import com.sinch.sdk.models.VoiceContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class VoiceServiceTest {

  @Mock HttpClient httpClient;

  VoiceContext context = VoiceContext.builder().build();

  @Test
  void doNotAcceptNullApplicationCredentials() {
    Exception exception =
        assertThrows(NullPointerException.class, () -> new VoiceService(null, context, httpClient));

    assertTrue(exception.getMessage().contains("Credentials must be defined"));
  }

  @Test
  void doNotAcceptNullContext() {
    ApplicationCredentials credentials = ApplicationCredentials.builder().build();

    Exception exception =
        assertThrows(
            NullPointerException.class, () -> new VoiceService(credentials, null, httpClient));

    assertTrue(exception.getMessage().contains("Context must be defined"));
  }

  @Test
  void doNotAcceptNullApplicationKey() {
    ApplicationCredentials credentials =
        ApplicationCredentials.builder()
            .setApplicationKey(null)
            .setApplicationSecret("foo secret")
            .build();

    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new VoiceService(credentials, context, httpClient));

    assertTrue(exception.getMessage().contains("applicationKey"));
  }

  @Test
  void doNotAcceptNullApplicationSecret() {
    ApplicationCredentials credentials =
        ApplicationCredentials.builder()
            .setApplicationKey("foo key")
            .setApplicationSecret(null)
            .build();

    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new VoiceService(credentials, context, httpClient));

    assertTrue(exception.getMessage().contains("applicationSecret"));
  }

  @Test
  void passInit() {
    ApplicationCredentials credentials =
        ApplicationCredentials.builder()
            .setApplicationKey("foo key")
            .setApplicationSecret("Zm9vIHNlY3JldA==")
            .build();

    assertDoesNotThrow(() -> new VoiceService(credentials, context, httpClient), "Init passed");
  }
}
