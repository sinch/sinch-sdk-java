package com.sinch.sdk.domains.voice.adapters;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.verification.adapters.VerificationService;
import com.sinch.sdk.models.Configuration;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class VoiceServiceTest {

  @Mock HttpClient httpClient;

  @Test
  void doNotAcceptNullApplicationKey() {
    Configuration configuration =
        Configuration.builder().setApplicationKey(null).setApplicationSecret("foo secret").build();
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new VerificationService(configuration, httpClient));
    assertTrue(exception.getMessage().contains("applicationKey"));
  }

  @Test
  void doNotAcceptNullApplicationSecret() {
    Configuration configuration =
        Configuration.builder().setApplicationKey("foo key").setApplicationSecret(null).build();
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new VerificationService(configuration, httpClient));
    assertTrue(exception.getMessage().contains("applicationSecret"));
  }
}
