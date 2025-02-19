package com.sinch.sdk.domains.verification.api.v1.adapters;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.verification.api.v1.VerificationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class VerificationServiceTest {

  @Mock HttpClient httpClient;

  @Test
  void checkCredentialsVerificationReport() {
    CredentialsValidationHelper.checkCredentials(
        () -> httpClient, VerificationService::verificationReport);
  }

  @Test
  void checkCredentialsVerificationStatus() {
    CredentialsValidationHelper.checkCredentials(
        () -> httpClient, VerificationService::verificationStatus);
  }

  @Test
  void checkCredentialsVerificationStart() {
    CredentialsValidationHelper.checkCredentials(
        () -> httpClient, VerificationService::verificationStart);
  }

  @Test
  void checkCredentialsWebhooks() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, VerificationService::webhooks);
  }
}
