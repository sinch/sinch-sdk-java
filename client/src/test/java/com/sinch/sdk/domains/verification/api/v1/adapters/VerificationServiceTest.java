package com.sinch.sdk.domains.verification.api.v1.adapters;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.models.ApplicationCredentials;
import com.sinch.sdk.models.VerificationContext;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class VerificationServiceTest {

  @Mock HttpClient httpClient;

  VerificationContext context = VerificationContext.builder().setVerificationUrl("foo url").build();

  @Test
  void doNotAcceptNullApplicationCredentials() {

    Exception exception =
        assertThrows(
            NullPointerException.class, () -> new VerificationService(null, context, httpClient));

    assertTrue(
        exception.getMessage().contains("service requires application credentials to be defined"));
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
            () -> new VerificationService(credentials, context, httpClient));

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
            () -> new VerificationService(credentials, context, httpClient));

    assertTrue(exception.getMessage().contains("applicationSecret"));
  }

  @Test
  void doNotAcceptNullContext() {
    ApplicationCredentials credentials =
        ApplicationCredentials.builder()
            .setApplicationKey("foo key")
            .setApplicationSecret("foo secret")
            .build();
    Exception exception =
        assertThrows(
            NullPointerException.class,
            () -> new VerificationService(credentials, null, httpClient));
    assertTrue(
        exception.getMessage().contains("Verification service requires context to be defined"));
  }

  @Test
  void doNotAcceptNullVerificationUrl() {
    ApplicationCredentials credentials =
        ApplicationCredentials.builder()
            .setApplicationKey("foo key")
            .setApplicationSecret("foo secret")
            .build();
    VerificationContext context = VerificationContext.builder().build();
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new VerificationService(credentials, context, httpClient));
    assertTrue(exception.getMessage().contains("verificationUrl"));
  }

  @Test
  void passInit() {
    ApplicationCredentials credentials =
        ApplicationCredentials.builder()
            .setApplicationKey("foo key")
            .setApplicationSecret("Zm9vIHNlY3JldA==")
            .build();

    assertDoesNotThrow(
        () -> new VerificationService(credentials, context, httpClient), "Init passed");
  }
}
