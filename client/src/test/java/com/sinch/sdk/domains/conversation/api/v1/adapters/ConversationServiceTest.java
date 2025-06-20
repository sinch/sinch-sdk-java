package com.sinch.sdk.domains.conversation.api.v1.adapters;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.sinch.sdk.LogRecorder;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.conversation.api.templates.adapters.TemplatesService;
import com.sinch.sdk.models.ConversationContext;
import com.sinch.sdk.models.ConversationRegion;
import com.sinch.sdk.models.UnifiedCredentials;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class ConversationServiceTest {

  @Mock HttpClient httpClient;

  @Test
  void checkCredentialsApp() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, ConversationService::app);
  }

  @Test
  void checkCredentialsCapability() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, ConversationService::capability);
  }

  @Test
  void checkCredentialsContact() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, ConversationService::contact);
  }

  @Test
  void checkCredentialsConversations() {
    CredentialsValidationHelper.checkCredentials(
        () -> httpClient, ConversationService::conversations);
  }

  @Test
  void checkCredentialsEvents() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, ConversationService::events);
  }

  @Test
  void checkCredentialsMessages() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, ConversationService::messages);
  }

  @Test
  void checkCredentialsTranscoding() {
    CredentialsValidationHelper.checkCredentials(
        () -> httpClient, ConversationService::transcoding);
  }

  @Test
  void passInitWithoutSettings() {
    assertDoesNotThrow(() -> new TemplatesService(null, null, null, null), "Init passed");
  }

  @Test
  void defaultRegionWarning() {

    LogRecorder logRecorder = new LogRecorder();
    LogManager.getLogManager().reset();
    Logger rootLogger = LogManager.getLogManager().getLogger("");
    rootLogger.addHandler(logRecorder);

    UnifiedCredentials credentials =
        UnifiedCredentials.builder()
            .setKeyId("foo key ")
            .setKeySecret("foo secret")
            .setProjectId("foo project")
            .build();
    ConversationContext context =
        ConversationContext.builder()
            .setUrl("https://foo.url")
            .setRegion(ConversationRegion.US)
            .setRegionAsDefault(true)
            .build();
    ServerConfiguration server = new ServerConfiguration("https://oauth.foo.url");

    new ConversationService(credentials, context, server, () -> httpClient).app();

    Optional<LogRecord> record =
        logRecorder.records.stream()
            .filter(r -> r.getMessage().contains("Using default region for Conversation 'us"))
            .findFirst();

    assertTrue(record.isPresent());
    assertEquals(record.get().getLevel(), Level.WARNING);
    LogManager.getLogManager().reset();
  }

  @Test
  void regionNoWarning() {

    LogRecorder logRecorder = new LogRecorder();
    LogManager.getLogManager().reset();
    Logger rootLogger = LogManager.getLogManager().getLogger("");
    rootLogger.addHandler(logRecorder);

    UnifiedCredentials credentials =
        UnifiedCredentials.builder()
            .setKeyId("foo key ")
            .setKeySecret("foo secret")
            .setProjectId("foo project")
            .build();
    ConversationContext context =
        ConversationContext.builder()
            .setUrl("https://foo.url")
            .setRegion(ConversationRegion.BR)
            .setRegionAsDefault(false)
            .build();
    ServerConfiguration server = new ServerConfiguration("https://oauth.foo.url");

    new ConversationService(credentials, context, server, () -> httpClient).app();

    Optional<LogRecord> record =
        logRecorder.records.stream()
            .filter(r -> r.getMessage().contains("Using default region for Conversation 'us"))
            .findFirst();

    assertFalse(record.isPresent());
    LogManager.getLogManager().reset();
  }

  @Test
  void defaultRegionTemplateWarning() {

    LogRecorder logRecorder = new LogRecorder();
    LogManager.getLogManager().reset();
    Logger rootLogger = LogManager.getLogManager().getLogger("");
    rootLogger.addHandler(logRecorder);

    UnifiedCredentials credentials =
        UnifiedCredentials.builder()
            .setKeyId("foo key ")
            .setKeySecret("foo secret")
            .setProjectId("foo project")
            .build();
    ConversationContext context =
        ConversationContext.builder()
            .setTemplateManagementUrl("https://foo.url")
            .setRegion(ConversationRegion.US)
            .setRegionAsDefault(true)
            .build();
    ServerConfiguration server = new ServerConfiguration("https://oauth.foo.url");

    new ConversationService(credentials, context, server, () -> httpClient).templates().v2();

    Optional<LogRecord> record =
        logRecorder.records.stream()
            .filter(
                r -> r.getMessage().contains("Using default region for Conversation Template 'us"))
            .findFirst();

    assertTrue(record.isPresent());
    assertEquals(record.get().getLevel(), Level.WARNING);
    LogManager.getLogManager().reset();
  }

  @Test
  void regionTemplateNoWarning() {

    LogRecorder logRecorder = new LogRecorder();
    LogManager.getLogManager().reset();
    Logger rootLogger = LogManager.getLogManager().getLogger("");
    rootLogger.addHandler(logRecorder);

    UnifiedCredentials credentials =
        UnifiedCredentials.builder()
            .setKeyId("foo key ")
            .setKeySecret("foo secret")
            .setProjectId("foo project")
            .build();
    ConversationContext context =
        ConversationContext.builder()
            .setTemplateManagementUrl("https://foo.url")
            .setRegion(ConversationRegion.BR)
            .setRegionAsDefault(false)
            .build();
    ServerConfiguration server = new ServerConfiguration("https://oauth.foo.url");

    new ConversationService(credentials, context, server, () -> httpClient).templates().v2();

    Optional<LogRecord> record =
        logRecorder.records.stream()
            .filter(
                r -> r.getMessage().contains("Using default region for Conversation Template 'us"))
            .findFirst();

    assertFalse(record.isPresent());
    LogManager.getLogManager().reset();
  }
}
