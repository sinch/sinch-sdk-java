package com.sinch.sdk.domains.conversation.api.templates.adapters;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.models.ConversationContext;
import com.sinch.sdk.models.UnifiedCredentials;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class TemplateServiceTest {

  @Mock HttpClient httpClient;

  @Test
  void doNotAcceptNullKey() {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId(null).setKeySecret("foo").setProjectId("foo").build();
    ConversationContext context = ConversationContext.builder().build();
    ServerConfiguration server = new ServerConfiguration("foo");
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new TemplatesService(credentials, context, server, httpClient));
    assertTrue(exception.getMessage().contains("keyId"));
  }

  @Test
  void doNotAcceptNullKeySecret() {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId("foo").setKeySecret(null).setProjectId("foo").build();
    ConversationContext context = ConversationContext.builder().build();
    ServerConfiguration server = new ServerConfiguration("foo");
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new TemplatesService(credentials, context, server, httpClient));
    assertTrue(exception.getMessage().contains("keySecret"));
  }

  @Test
  void doNotAcceptNullProject() {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId("foo").setKeySecret("foo").setProjectId(null).build();
    ConversationContext context = ConversationContext.builder().build();
    ServerConfiguration server = new ServerConfiguration("foo");
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new TemplatesService(credentials, context, server, httpClient));
    assertTrue(exception.getMessage().contains("projectId"));
  }

  @Test
  void doNotAcceptNullCredentials() {

    ConversationContext context = ConversationContext.builder().build();
    ServerConfiguration server = new ServerConfiguration("foo");
    Exception exception =
        assertThrows(
            NullPointerException.class,
            () -> new TemplatesService(null, context, server, httpClient));
    assertTrue(
        exception.getMessage().contains("Templates service requires credentials to be defined"));
  }

  @Test
  void doNotAcceptNullContext() {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder()
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId("foo")
            .build();
    ServerConfiguration server = new ServerConfiguration("foo");
    Exception exception =
        assertThrows(
            NullPointerException.class,
            () -> new TemplatesService(credentials, null, server, httpClient));
    assertTrue(exception.getMessage().contains("Templates service requires context to be defined"));
  }

  @Test
  void doNotAcceptEmptyManagementURL() {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder()
            .setKeyId("foo")
            .setKeySecret("foo")
            .setProjectId("foo")
            .build();
    ConversationContext context =
        ConversationContext.builder().setTemplateManagementUrl("").build();
    ServerConfiguration server = new ServerConfiguration("");
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new TemplatesService(credentials, context, server, httpClient));
    assertTrue(
        exception
            .getMessage()
            .contains("Templates service requires 'templateManagementUrl' to be defined"));
  }

  @Test
  void doNotAcceptNullManagementURL() {
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
            () -> new TemplatesService(credentials, context, server, httpClient));
    assertTrue(
        exception
            .getMessage()
            .contains("Templates service requires 'templateManagementUrl' to be defined"));
  }

  @Test
  void passInit() {
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
        () -> new TemplatesService(credentials, context, server, httpClient), "Init passed");
  }
}
