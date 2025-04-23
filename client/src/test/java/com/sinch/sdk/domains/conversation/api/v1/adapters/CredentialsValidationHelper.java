package com.sinch.sdk.domains.conversation.api.v1.adapters;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.models.ConversationContext;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.function.Consumer;
import java.util.function.Supplier;

class CredentialsValidationHelper {
  static void checkCredentials(
      Supplier<HttpClient> httpClientSupplier, Consumer<ConversationService> service) {

    doNotAcceptNullKey(httpClientSupplier, service);
    doNotAcceptNullKeySecret(httpClientSupplier, service);
    doNotAcceptNullProject(httpClientSupplier, service);
    doNotAcceptNullCredentials(httpClientSupplier, service);
    doNotAcceptNullContext(httpClientSupplier, service);
    doNotAcceptEmptyURL(httpClientSupplier, service);
    doNotAcceptNullURL(httpClientSupplier, service);
    passInit(httpClientSupplier, service);
  }

  private static void doNotAcceptNullKey(
      Supplier<HttpClient> httpClientSupplier, Consumer<ConversationService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId(null).setKeySecret("foo").setProjectId("foo").build();
    ConversationContext context = ConversationContext.builder().build();
    ServerConfiguration server = new ServerConfiguration("");
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                service.accept(
                    new ConversationService(credentials, context, server, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("keyId"));
  }

  private static void doNotAcceptNullKeySecret(
      Supplier<HttpClient> httpClientSupplier, Consumer<ConversationService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId("foo").setKeySecret(null).setProjectId("foo").build();
    ConversationContext context = ConversationContext.builder().build();
    ServerConfiguration server = new ServerConfiguration("");
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                service.accept(
                    new ConversationService(credentials, context, server, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("keySecret"));
  }

  private static void doNotAcceptNullProject(
      Supplier<HttpClient> httpClientSupplier, Consumer<ConversationService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId("foo").setKeySecret("foo").setProjectId(null).build();
    ConversationContext context = ConversationContext.builder().build();
    ServerConfiguration server = new ServerConfiguration("");

    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                service.accept(
                    new ConversationService(credentials, context, server, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("projectId"));
  }

  private static void doNotAcceptNullCredentials(
      Supplier<HttpClient> httpClientSupplier, Consumer<ConversationService> service) {
    ConversationContext context = ConversationContext.builder().build();
    ServerConfiguration server = new ServerConfiguration("");
    Exception exception =
        assertThrows(
            NullPointerException.class,
            () ->
                service.accept(new ConversationService(null, context, server, httpClientSupplier)));
    assertTrue(
        exception.getMessage().contains("Conversation service requires credentials to be defined"));
  }

  private static void doNotAcceptNullContext(
      Supplier<HttpClient> httpClientSupplier, Consumer<ConversationService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder()
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId("foo")
            .build();
    ServerConfiguration server = new ServerConfiguration("");
    Exception exception =
        assertThrows(
            NullPointerException.class,
            () ->
                service.accept(
                    new ConversationService(credentials, null, server, httpClientSupplier)));
    assertTrue(
        exception.getMessage().contains("Conversation service requires context to be defined"));
  }

  private static void doNotAcceptEmptyURL(
      Supplier<HttpClient> httpClientSupplier, Consumer<ConversationService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder()
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId("foo")
            .build();
    ConversationContext context = ConversationContext.builder().setUrl("").build();
    ServerConfiguration server = new ServerConfiguration("");
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                service.accept(
                    new ConversationService(credentials, context, server, httpClientSupplier)));
    assertTrue(
        exception.getMessage().contains("Conversation service requires 'url' to be defined"));
  }

  private static void doNotAcceptNullURL(
      Supplier<HttpClient> httpClientSupplier, Consumer<ConversationService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder()
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId("foo")
            .build();
    ConversationContext context = ConversationContext.builder().build();
    ServerConfiguration server = new ServerConfiguration("");
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                service.accept(
                    new ConversationService(credentials, context, server, httpClientSupplier)));
    assertTrue(
        exception.getMessage().contains("Conversation service requires 'url' to be defined"));
  }

  private static void passInit(
      Supplier<HttpClient> httpClientSupplier, Consumer<ConversationService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder()
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId("foo")
            .build();
    ConversationContext context = ConversationContext.builder().setUrl("foo").build();
    ServerConfiguration server = new ServerConfiguration("foo");
    assertDoesNotThrow(
        () ->
            service.accept(
                new ConversationService(credentials, context, server, httpClientSupplier)),
        "Init passed");
  }
}
