package com.sinch.sdk.domains.conversation.api.v1.adapters;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.conversation.api.templates.adapters.TemplatesService;
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
}
