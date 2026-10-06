package com.sinch.sdk.domains.voice.api.v2.adapters;

import com.sinch.sdk.core.http.HttpClient;
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
}
