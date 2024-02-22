package com.sinch.sdk.domains.voice.adapters;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.models.ApplicationCredentials;
import com.sinch.sdk.models.Configuration;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class VoiceServiceTest {

  @Mock HttpClient httpClient;

  @Test
  void doNotAcceptEmptyApplicationCredentials() {
    Configuration configuration = Configuration.builder().build();

    Exception exception =
        assertThrows(
            IllegalArgumentException.class, () -> new VoiceService(configuration, httpClient));

    assertTrue(exception.getMessage().contains("Application credentials must be defined"));
  }

  @Test
  void doNotAcceptNullApplicationCredentials() {
    Configuration configuration = Configuration.builder().setApplicationCredentials(null).build();

    Exception exception =
        assertThrows(
            IllegalArgumentException.class, () -> new VoiceService(configuration, httpClient));

    assertTrue(exception.getMessage().contains("Application credentials must be defined"));
  }

  @Test
  void doNotAcceptNullApplicationKey() {
    ApplicationCredentials credentials =
        ApplicationCredentials.builder()
            .setApplicationKey(null)
            .setApplicationSecret("foo secret")
            .build();
    Configuration configuration =
        Configuration.builder().setApplicationCredentials(credentials).build();

    Exception exception =
        assertThrows(
            IllegalArgumentException.class, () -> new VoiceService(configuration, httpClient));

    assertTrue(exception.getMessage().contains("applicationKey"));
  }

  @Test
  void doNotAcceptNullApplicationSecret() {
    ApplicationCredentials credentials =
        ApplicationCredentials.builder()
            .setApplicationKey("foo key")
            .setApplicationSecret(null)
            .build();
    Configuration configuration =
        Configuration.builder().setApplicationCredentials(credentials).build();

    Exception exception =
        assertThrows(
            IllegalArgumentException.class, () -> new VoiceService(configuration, httpClient));

    assertTrue(exception.getMessage().contains("applicationSecret"));
  }
}
