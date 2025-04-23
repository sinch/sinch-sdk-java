package com.sinch.sdk.domains.numbers.api.v1.adapters;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.models.NumbersContext;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.function.Consumer;
import java.util.function.Supplier;

class CredentialsValidationHelper {

  static void checkCredentials(
      Supplier<HttpClient> httpClientSupplier, Consumer<NumbersService> service) {
    doNotAcceptNullKey(httpClientSupplier, service);
    doNotAcceptNullKeySecret(httpClientSupplier, service);
    doNotAcceptNullProject(httpClientSupplier, service);
    doNotAcceptNullContext(httpClientSupplier, service);
    doNotAcceptNullNumbersUrl(httpClientSupplier, service);
    initPassed(httpClientSupplier, service);
  }

  static void doNotAcceptNullKey(
      Supplier<HttpClient> httpClientSupplier, Consumer<NumbersService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId(null).setKeySecret("foo").setProjectId("foo").build();
    NumbersContext context = NumbersContext.builder().setNumbersUrl("foo url").build();
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> service.accept(new NumbersService(credentials, context, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("keyId"));
  }

  static void doNotAcceptNullKeySecret(
      Supplier<HttpClient> httpClientSupplier, Consumer<NumbersService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId("foo").setKeySecret(null).setProjectId("foo").build();
    NumbersContext context = NumbersContext.builder().setNumbersUrl("foo url").build();
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> service.accept(new NumbersService(credentials, context, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("keySecret"));
  }

  static void doNotAcceptNullProject(
      Supplier<HttpClient> httpClientSupplier, Consumer<NumbersService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId("foo").setKeySecret("foo").setProjectId(null).build();
    NumbersContext context = NumbersContext.builder().setNumbersUrl("foo url").build();
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> service.accept(new NumbersService(credentials, context, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("projectId"));
  }

  static void doNotAcceptNullContext(
      Supplier<HttpClient> httpClientSupplier, Consumer<NumbersService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder()
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId("foo")
            .build();
    Exception exception =
        assertThrows(
            NullPointerException.class,
            () -> service.accept(new NumbersService(credentials, null, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("Numbers service requires context to be defined"));
  }

  static void doNotAcceptNullNumbersUrl(
      Supplier<HttpClient> httpClientSupplier, Consumer<NumbersService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder()
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId("foo")
            .build();
    NumbersContext context = NumbersContext.builder().build();

    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> service.accept(new NumbersService(credentials, context, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("numbersUrl"));
  }

  static void initPassed(
      Supplier<HttpClient> httpClientSupplier, Consumer<NumbersService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder()
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId("foo")
            .build();
    NumbersContext context = NumbersContext.builder().setNumbersUrl("foo url").build();

    assertDoesNotThrow(
        () -> service.accept(new NumbersService(credentials, context, httpClientSupplier)),
        "Init passed");
  }
}
