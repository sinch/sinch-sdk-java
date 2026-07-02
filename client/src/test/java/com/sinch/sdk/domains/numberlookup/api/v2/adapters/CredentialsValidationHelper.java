package com.sinch.sdk.domains.numberlookup.api.v2.adapters;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.models.NumberLookupContext;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.function.Consumer;
import java.util.function.Supplier;

class CredentialsValidationHelper {

  static ServerConfiguration oAuthServer = new ServerConfiguration("https://oauth.foo.url");

  static void checkCredentials(
      Supplier<HttpClient> httpClientSupplier, Consumer<NumberLookupService> service) {
    doNotAcceptNullCredentials(httpClientSupplier, service);
    doNotAcceptNullKey(httpClientSupplier, service);
    doNotAcceptNullKeySecret(httpClientSupplier, service);
    doNotAcceptNullProject(httpClientSupplier, service);
    doNotAcceptNullContext(httpClientSupplier, service);
    doNotAcceptNullNumberLookupUrl(httpClientSupplier, service);
    initPassed(httpClientSupplier, service);
  }

  static void doNotAcceptNullCredentials(
      Supplier<HttpClient> httpClientSupplier, Consumer<NumberLookupService> service) {
    NumberLookupContext context =
        NumberLookupContext.builder().setNumberLookupUrl("foo url").build();

    Exception exception =
        assertThrows(
            NullPointerException.class,
            () ->
                service.accept(
                    new NumberLookupService(null, context, oAuthServer, httpClientSupplier)));
    assertTrue(
        exception
            .getMessage()
            .contains("Number Lookup service requires unified credentials to be defined"));
  }

  static void doNotAcceptNullKey(
      Supplier<HttpClient> httpClientSupplier, Consumer<NumberLookupService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId(null).setKeySecret("foo").setProjectId("foo").build();
    NumberLookupContext context =
        NumberLookupContext.builder().setNumberLookupUrl("foo url").build();

    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                service.accept(
                    new NumberLookupService(
                        credentials, context, oAuthServer, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("keyId"));
  }

  static void doNotAcceptNullKeySecret(
      Supplier<HttpClient> httpClientSupplier, Consumer<NumberLookupService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId("foo").setKeySecret(null).setProjectId("foo").build();
    NumberLookupContext context =
        NumberLookupContext.builder().setNumberLookupUrl("foo url").build();

    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                service.accept(
                    new NumberLookupService(
                        credentials, context, oAuthServer, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("keySecret"));
  }

  static void doNotAcceptNullProject(
      Supplier<HttpClient> httpClientSupplier, Consumer<NumberLookupService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId("foo").setKeySecret("foo").setProjectId(null).build();
    NumberLookupContext context =
        NumberLookupContext.builder().setNumberLookupUrl("foo url").build();

    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                service.accept(
                    new NumberLookupService(
                        credentials, context, oAuthServer, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("projectId"));
  }

  static void doNotAcceptNullContext(
      Supplier<HttpClient> httpClientSupplier, Consumer<NumberLookupService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder()
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId("foo")
            .build();

    Exception exception =
        assertThrows(
            NullPointerException.class,
            () ->
                service.accept(
                    new NumberLookupService(credentials, null, oAuthServer, httpClientSupplier)));
    assertTrue(
        exception.getMessage().contains("Number Lookup service requires context to be defined"));
  }

  static void doNotAcceptNullNumberLookupUrl(
      Supplier<HttpClient> httpClientSupplier, Consumer<NumberLookupService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder()
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId("foo")
            .build();
    NumberLookupContext context = NumberLookupContext.builder().build();

    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                service.accept(
                    new NumberLookupService(
                        credentials, context, oAuthServer, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("numberLookupUrl"));
  }

  static void initPassed(
      Supplier<HttpClient> httpClientSupplier, Consumer<NumberLookupService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder()
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId("foo")
            .build();
    NumberLookupContext context =
        NumberLookupContext.builder().setNumberLookupUrl("foo url").build();

    assertDoesNotThrow(
        () ->
            service.accept(
                new NumberLookupService(credentials, context, oAuthServer, httpClientSupplier)),
        "Init passed");
  }
}
