package com.sinch.sdk.domains.conversation.api.v1.adapters;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.models.ConversationContext;
import com.sinch.sdk.models.UnifiedCredentials;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class ConversationServiceTest {

  @Mock HttpClient httpClient;

  @Test
  void doNotAcceptNullKey() {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId(null).setKeySecret("foo").setProjectId("foo").build();
    ConversationContext context = ConversationContext.builder().build();
    ServerConfiguration server = new ServerConfiguration("");
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new ConversationService(credentials, context, server, httpClient));
    assertTrue(exception.getMessage().contains("keyId"));
  }

  @Test
  void doNotAcceptNullKeySecret() {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId("foo").setKeySecret(null).setProjectId("foo").build();
    ConversationContext context = ConversationContext.builder().build();
    ServerConfiguration server = new ServerConfiguration("");
    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new ConversationService(credentials, context, server, httpClient));
    assertTrue(exception.getMessage().contains("keySecret"));
  }

  @Test
  void doNotAcceptNullProject() {
    UnifiedCredentials credentials =
        UnifiedCredentials.builder().setKeyId("foo").setKeySecret("foo").setProjectId(null).build();
    ConversationContext context = ConversationContext.builder().build();
    ServerConfiguration server = new ServerConfiguration("");

    Exception exception =
        assertThrows(
            IllegalArgumentException.class,
            () -> new ConversationService(credentials, context, server, httpClient));
    assertTrue(exception.getMessage().contains("projectId"));
  }

  @Test
  void doNotAcceptNullCredentials() {

    ConversationContext context = ConversationContext.builder().build();
    ServerConfiguration server = new ServerConfiguration("");
    Exception exception =
        assertThrows(
            NullPointerException.class,
            () -> new ConversationService(null, context, server, httpClient));
    assertTrue(
        exception.getMessage().contains("Conversation service requires credentials to be defined"));
  }

  @Test
  void doNotAcceptNullContext() {
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
            () -> new ConversationService(credentials, null, server, httpClient));
    assertTrue(
        exception.getMessage().contains("Conversation service requires context to be defined"));
  }
}
