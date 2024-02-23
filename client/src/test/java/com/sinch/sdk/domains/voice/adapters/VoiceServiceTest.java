package com.sinch.sdk.domains.voice.adapters;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.models.ApplicationCredentials;
import com.sinch.sdk.models.VoiceContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class VoiceServiceTest {

  @Mock HttpClient httpClient;

  @Test
  void doNotAcceptNullApplicationCredentials() {
    VoiceContext context = VoiceContext.builder().build();
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
    VoiceContext context = VoiceContext.builder().build();

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
    VoiceContext context = VoiceContext.builder().build();

    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new VoiceService(credentials, context, httpClient));

    assertTrue(exception.getMessage().contains("applicationSecret"));
  }
}
