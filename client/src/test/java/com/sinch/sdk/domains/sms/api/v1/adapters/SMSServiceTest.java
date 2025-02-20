package com.sinch.sdk.domains.sms.api.v1.adapters;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.sinch.sdk.core.http.HttpClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class SMSServiceTest {

  @Mock HttpClient httpClient;

  @Test
  void checkCredentialsBatches() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, SMSService::batches);
  }

  @Test
  void checkCredentialsInbounds() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, SMSService::inbounds);
  }

  @Test
  void checkCredentialsDeliveryReports() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, SMSService::deliveryReports);
  }

  @Test
  void checkCredentialsGroups() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, SMSService::groups);
  }

  @Test
  void checkCredentialsWebhooks() {
    assertDoesNotThrow(() -> new SMSService(null, null, null, null).webhooks(), "Init passed");
  }

  @Test
  void passInitWithoutSettings() {
    assertDoesNotThrow(() -> new SMSService(null, null, null, null), "Init passed");
  }
}
