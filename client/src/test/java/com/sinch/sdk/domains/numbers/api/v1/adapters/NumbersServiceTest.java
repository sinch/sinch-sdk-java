package com.sinch.sdk.domains.numbers.api.v1.adapters;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.sinch.sdk.core.http.HttpClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class NumbersServiceTest {

  @Mock HttpClient httpClient;

  @Test
  void checkCredentialsAvailable() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, NumbersService::available);
  }

  @Test
  void checkCredentialsActive() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, NumbersService::active);
  }

  @Test
  void checkCredentialsRegions() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, NumbersService::regions);
  }

  @Test
  void checkCredentialsCallback() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, NumbersService::callback);
  }

  @Test
  void checkCredentialsWebhooks() {
    assertDoesNotThrow(() -> new NumbersService(null, null, null, null).webhooks(), "Init passed");
  }
}
