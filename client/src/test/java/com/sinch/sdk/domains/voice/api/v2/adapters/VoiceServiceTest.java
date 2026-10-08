package com.sinch.sdk.domains.voice.api.v2.adapters;

import com.sinch.sdk.SinchClient;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.models.Configuration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class VoiceServiceTest {

  @Mock HttpClient httpClient;

  @Test
  void checkCredentialsCalls() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, VoiceService::calls);
  }

  @Test
  void checkCredentialsBatches() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, VoiceService::batches);
  }

  @Test
  void checkCredentialsSessions() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, VoiceService::sessions);
  }

  @Test
  void checkCredentialsServices() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, VoiceService::services);
  }

  @Test
  void sinchEventsRequireNoCredentials() {
    Assertions.assertNotNull(
        new SinchClient(Configuration.builder().build()).voice().v2().sinchEvents());
  }
}
