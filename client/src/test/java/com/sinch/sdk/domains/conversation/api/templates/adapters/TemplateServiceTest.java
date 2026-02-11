package com.sinch.sdk.domains.conversation.api.templates.adapters;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.conversation.templates.api.adapters.TemplatesService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class TemplateServiceTest {

  @Mock HttpClient httpClient;

  @Test
  void checkCredentialsV2() {
    CredentialsValidationHelper.checkCredentialsTemplates(() -> httpClient, TemplatesService::v2);
  }

  @Test
  void passInitWithoutSettings() {
    assertDoesNotThrow(() -> new TemplatesService(null, null, null, null), "Init passed");
  }
}
