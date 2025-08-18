package com.sinch.sdk.domains.conversation.api.templates.adapters;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.conversation.templates.api.adapters.TemplatesService;
import com.sinch.sdk.models.ConversationContext;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.function.Consumer;
import java.util.function.Supplier;

class CredentialsValidationHelper {

  static void checkCredentialsTemplates(
      Supplier<HttpClient> httpClientSupplier, Consumer<TemplatesService> service) {

    doNotAcceptNullKeyTemplates(httpClientSupplier, service);
    doNotAcceptNullKeySecretTemplates(httpClientSupplier, service);
    doNotAcceptNullProjectTemplates(httpClientSupplier, service);
    doNotAcceptNullCredentialsTemplates(httpClientSupplier, service);
    doNotAcceptNullContextTemplates(httpClientSupplier, service);
    doNotAcceptEmptyURLTemplates(httpClientSupplier, service);
    doNotAcceptNullURLTemplates(httpClientSupplier, service);
    passInitTemplates(httpClientSupplier, service);
  }

  private static void doNotAcceptNullKeyTemplates(
      Supplier<HttpClient> httpClientSupplier, Consumer<TemplatesService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId(null).setKeySecret("foo").setProjectId("foo").build();
    ConversationContext context = ConversationContext.builder().build();
    ServerConfiguration server = new ServerConfiguration("");
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                service.accept(
                    new TemplatesService(credentials, context, server, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("keyId"));
  }

  private static void doNotAcceptNullKeySecretTemplates(
      Supplier<HttpClient> httpClientSupplier, Consumer<TemplatesService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId("foo").setKeySecret(null).setProjectId("foo").build();
    ConversationContext context = ConversationContext.builder().build();
    ServerConfiguration server = new ServerConfiguration("");
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                service.accept(
                    new TemplatesService(credentials, context, server, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("keySecret"));
  }

  private static void doNotAcceptNullProjectTemplates(
      Supplier<HttpClient> httpClientSupplier, Consumer<TemplatesService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId("foo").setKeySecret("foo").setProjectId(null).build();
    ConversationContext context = ConversationContext.builder().build();
    ServerConfiguration server = new ServerConfiguration("");

    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () ->
                service.accept(
                    new TemplatesService(credentials, context, server, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("projectId"));
  }

  private static void doNotAcceptNullCredentialsTemplates(
      Supplier<HttpClient> httpClientSupplier, Consumer<TemplatesService> service) {
    ConversationContext context = ConversationContext.builder().build();
    ServerConfiguration server = new ServerConfiguration("");
    Exception exception =
        assertThrows(
            NullPointerException.class,
            () -> service.accept(new TemplatesService(null, context, server, httpClientSupplier)));
    assertTrue(
        exception.getMessage().contains("Templates service requires credentials to be defined"));
  }

  private static void doNotAcceptNullContextTemplates(
      Supplier<HttpClient> httpClientSupplier, Consumer<TemplatesService> service) {
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
                    new TemplatesService(credentials, null, server, httpClientSupplier)));
    assertTrue(exception.getMessage().contains("Templates service requires context to be defined"));
  }

  private static void doNotAcceptEmptyURLTemplates(
      Supplier<HttpClient> httpClientSupplier, Consumer<TemplatesService> service) {
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
                    new TemplatesService(credentials, context, server, httpClientSupplier)));
    assertTrue(
        exception
            .getMessage()
            .contains("Templates service requires 'templateManagementUrl' to be defined"));
  }

  private static void doNotAcceptNullURLTemplates(
      Supplier<HttpClient> httpClientSupplier, Consumer<TemplatesService> service) {
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
                    new TemplatesService(credentials, context, server, httpClientSupplier)));
    assertTrue(
        exception
            .getMessage()
            .contains("Templates service requires 'templateManagementUrl' to be defined"));
  }

  private static void passInitTemplates(
      Supplier<HttpClient> httpClientSupplier, Consumer<TemplatesService> service) {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder()
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId("foo")
            .build();
    ConversationContext context =
        ConversationContext.builder().setTemplateManagementUrl("foo").build();
    ServerConfiguration server = new ServerConfiguration("foo");
    assertDoesNotThrow(
        () ->
            service.accept(new TemplatesService(credentials, context, server, httpClientSupplier)),
        "Init passed");
  }
}
