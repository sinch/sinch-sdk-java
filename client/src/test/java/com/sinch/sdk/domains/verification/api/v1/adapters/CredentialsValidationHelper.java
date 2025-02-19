package com.sinch.sdk.domains.verification.api.v1.adapters;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.models.ApplicationCredentials;
import com.sinch.sdk.models.VerificationContext;
import java.util.function.Consumer;
import java.util.function.Supplier;

class CredentialsValidationHelper {

  static void checkCredentials(
      Supplier<HttpClient> httpClientSupplier, Consumer<VerificationService> service) {

    doNotAcceptNullApplicationCredentials(httpClientSupplier, service);
    doNotAcceptNullApplicationKey(httpClientSupplier, service);
    doNotAcceptNullApplicationSecret(httpClientSupplier, service);
    doNotAcceptNullContext(httpClientSupplier, service);
    doNotAcceptNullVerificationUrl(httpClientSupplier, service);
    passInit(httpClientSupplier, service);
  }

  static void doNotAcceptNullApplicationCredentials(
      Supplier<HttpClient> httpClientSupplier, Consumer<VerificationService> service) {

    VerificationContext context =
        VerificationContext.builder().setVerificationUrl("foo url").build();
    Exception exception =
        assertThrows(
            NullPointerException.class,
            () -> service.accept(new VerificationService(null, context, httpClientSupplier)));

    assertTrue(
        exception.getMessage().contains("service requires application credentials to be defined"));
  }

  static void doNotAcceptNullApplicationKey(
      Supplier<HttpClient> httpClientSupplier, Consumer<VerificationService> service) {
    VerificationContext context =
        VerificationContext.builder().setVerificationUrl("foo url").build();
    ApplicationCredentials credentials =
        ApplicationCredentials.builder()
            .setApplicationKey(null)
            .setApplicationSecret("foo secret")
            .build();

    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                service.accept(new VerificationService(credentials, context, httpClientSupplier)));

    assertTrue(exception.getMessage().contains("applicationKey"));
  }

  static void doNotAcceptNullApplicationSecret(
      Supplier<HttpClient> httpClientSupplier, Consumer<VerificationService> service) {
    VerificationContext context =
        VerificationContext.builder().setVerificationUrl("foo url").build();
    ApplicationCredentials credentials =
        ApplicationCredentials.builder()
            .setApplicationKey("foo key")
            .setApplicationSecret(null)
            .build();

    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                service.accept(new VerificationService(credentials, context, httpClientSupplier)));

    assertTrue(exception.getMessage().contains("applicationSecret"));
  }

  static void doNotAcceptNullContext(
      Supplier<HttpClient> httpClientSupplier, Consumer<VerificationService> service) {
    ApplicationCredentials credentials =
        ApplicationCredentials.builder()
            .setApplicationKey("foo key")
            .setApplicationSecret("foo secret")
            .build();
    Exception exception =
        assertThrows(
            NullPointerException.class,
            () -> service.accept(new VerificationService(credentials, null, httpClientSupplier)));
    assertTrue(
        exception.getMessage().contains("Verification service requires context to be defined"));
  }

  static void doNotAcceptNullVerificationUrl(
      Supplier<HttpClient> httpClientSupplier, Consumer<VerificationService> service) {
    ApplicationCredentials credentials =
        ApplicationCredentials.builder()
            .setApplicationKey("foo key")
            .setApplicationSecret("foo secret")
            .build();
    VerificationContext context = VerificationContext.builder().build();
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                service.accept(new VerificationService(credentials, context, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("verificationUrl"));
  }

  static void passInit(
      Supplier<HttpClient> httpClientSupplier, Consumer<VerificationService> service) {
    VerificationContext context =
        VerificationContext.builder().setVerificationUrl("foo url").build();
    ApplicationCredentials credentials =
        ApplicationCredentials.builder()
            .setApplicationKey("foo key")
            .setApplicationSecret("Zm9vIHNlY3JldA==")
            .build();

    assertDoesNotThrow(
        () -> service.accept(new VerificationService(credentials, context, httpClientSupplier)),
        "Init passed");
  }
}
