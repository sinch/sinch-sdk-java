package com.sinch.sdk.domains.voice.api.v1.adapters;

import com.sinch.sdk.core.http.HttpClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class VoiceServiceTest {

  @Mock HttpClient httpClient;

  @Test
  void checkCredentialsVoiceApplications() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, VoiceService::applications);
  }

  @Test
  void checkCredentialsVoiceCallouts() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, VoiceService::callouts);
  }

  @Test
  void checkCredentialsVoiceCalls() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, VoiceService::calls);
  }

  @Test
  void checkCredentialsVoiceConferences() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, VoiceService::conferences);
  }

  @Test
  void checkCredentialsVoiceWebhooks() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, VoiceService::webhooks);
  }
}
