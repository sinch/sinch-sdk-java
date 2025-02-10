package com.sinch.sdk.domains.conversation.api.v1.adapters;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.models.ConversationContext;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.function.Consumer;

class CredentialsValidationHelper {
  static void checkCredentials(HttpClient httpClient, Consumer<ConversationService> service) {

    doNotAcceptNullKey(httpClient, service);
    doNotAcceptNullKeySecret(httpClient, service);
    doNotAcceptNullProject(httpClient, service);
    doNotAcceptNullCredentials(httpClient, service);
    doNotAcceptNullContext(httpClient, service);
    doNotAcceptEmptyURL(httpClient, service);
    doNotAcceptNullURL(httpClient, service);
    passInit(httpClient, service);
  }

  private static void doNotAcceptNullKey(
      HttpClient httpClient, Consumer<ConversationService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId(null).setKeySecret("foo").setProjectId("foo").build();
    ConversationContext context = ConversationContext.builder().build();
    ServerConfiguration server = new ServerConfiguration("");
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                service.accept(new ConversationService(credentials, context, server, httpClient)));
    assertTrue(exception.getMessage().contains("keyId"));
  }

  private static void doNotAcceptNullKeySecret(
      HttpClient httpClient, Consumer<ConversationService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId("foo").setKeySecret(null).setProjectId("foo").build();
    ConversationContext context = ConversationContext.builder().build();
    ServerConfiguration server = new ServerConfiguration("");
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                service.accept(new ConversationService(credentials, context, server, httpClient)));
    assertTrue(exception.getMessage().contains("keySecret"));
  }

  private static void doNotAcceptNullProject(
      HttpClient httpClient, Consumer<ConversationService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId("foo").setKeySecret("foo").setProjectId(null).build();
    ConversationContext context = ConversationContext.builder().build();
    ServerConfiguration server = new ServerConfiguration("");

    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                service.accept(new ConversationService(credentials, context, server, httpClient)));
    assertTrue(exception.getMessage().contains("projectId"));
  }

  private static void doNotAcceptNullCredentials(
      HttpClient httpClient, Consumer<ConversationService> service) {
    ConversationContext context = ConversationContext.builder().build();
    ServerConfiguration server = new ServerConfiguration("");
    Exception exception =
        assertThrows(
            NullPointerException.class,
            () -> service.accept(new ConversationService(null, context, server, httpClient)));
    assertTrue(
        exception.getMessage().contains("Conversation service requires credentials to be defined"));
  }

  private static void doNotAcceptNullContext(
      HttpClient httpClient, Consumer<ConversationService> service) {
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
            () -> service.accept(new ConversationService(credentials, null, server, httpClient)));
    assertTrue(
        exception.getMessage().contains("Conversation service requires context to be defined"));
  }

  private static void doNotAcceptEmptyURL(
      HttpClient httpClient, Consumer<ConversationService> service) {
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
                service.accept(new ConversationService(credentials, context, server, httpClient)));
    assertTrue(
        exception.getMessage().contains("Conversation service requires 'url' to be defined"));
  }

  private static void doNotAcceptNullURL(
      HttpClient httpClient, Consumer<ConversationService> service) {
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
                service.accept(new ConversationService(credentials, context, server, httpClient)));
    assertTrue(
        exception.getMessage().contains("Conversation service requires 'url' to be defined"));
  }

  private static void passInit(HttpClient httpClient, Consumer<ConversationService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder()
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId("foo")
            .build();
    ConversationContext context = ConversationContext.builder().setUrl("foo").build();
    ServerConfiguration server = new ServerConfiguration("foo");
    assertDoesNotThrow(
        () -> service.accept(new ConversationService(credentials, context, server, httpClient)),
        "Init passed");
  }
}
