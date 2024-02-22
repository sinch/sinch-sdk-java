package com.sinch.sdk.domains.verification.adapters;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.models.ApplicationCredentials;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.VerificationContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class VerificationServiceTest {

  @Mock HttpClient httpClient;

  VerificationContext context = VerificationContext.builder().setVerificationUrl("foo url").build();

  @Test
  void doNotAcceptEmptyApplicationCredentials() {
    Configuration configuration = Configuration.builder().setVerificationContext(context).build();

    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new VerificationService(configuration, httpClient));

    assertTrue(exception.getMessage().contains("Application credentials must be defined"));
  }

  @Test
  void doNotAcceptNullApplicationCredentials() {
    Configuration configuration =
        Configuration.builder()
            .setVerificationContext(context)
            .setApplicationCredentials(null)
            .build();

    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new VerificationService(configuration, httpClient));

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
        Configuration.builder()
            .setVerificationContext(context)
            .setApplicationCredentials(credentials)
            .build();

    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new VerificationService(configuration, httpClient));

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
        Configuration.builder()
            .setVerificationContext(context)
            .setApplicationCredentials(credentials)
            .build();

    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new VerificationService(configuration, httpClient));

    assertTrue(exception.getMessage().contains("applicationSecret"));
  }

  @Test
  void doNotAcceptNullContext() {
    ApplicationCredentials credentials =
        ApplicationCredentials.builder()
            .setApplicationKey("foo key")
            .setApplicationSecret("foo secret")
            .build();
    Configuration configuration =
        Configuration.builder().setApplicationCredentials(credentials).build();
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new VerificationService(configuration, httpClient));
    assertTrue(exception.getMessage().contains("Verification context must be defined"));
  }

  @Test
  void doNotAcceptNullVerificationUrl() {
    ApplicationCredentials credentials =
        ApplicationCredentials.builder()
            .setApplicationKey("foo key")
            .setApplicationSecret("foo secret")
            .build();
    Configuration configuration =
        Configuration.builder()
            .setApplicationCredentials(credentials)
            .setVerificationContext(VerificationContext.builder().build())
            .build();
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new VerificationService(configuration, httpClient));
    assertTrue(exception.getMessage().contains("verificationUrl"));
  }
}
