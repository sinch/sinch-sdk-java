package com.sinch.sdk.domains.numbers.adapters;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import com.sinch.sdk.core.http.HttpClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class NumbersServiceTest {

  @Mock HttpClient httpClient;

  /*
  Due to V1 wrapper usage context: credentials are checked at request level  when calling a dedicated V1 function
  So test do not have sense here and is covered by V1 unit tests
   @Test
   void checkCredentialsAvailable() {
     CredentialsValidationHelper.checkCredentials(() -> httpClient, NumbersService::available);
   }*/

  /*
   Due to V1 wrapper usage context: credentials are checked at request level  when calling a dedicated V1 function
   So test do not have sense here and is covered by V1 unit tests @Test
    void checkCredentialsActive() {
      CredentialsValidationHelper.checkCredentials(() -> httpClient, NumbersService::active);
    }
  */

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
