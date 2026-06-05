package com.sinch.sdk.domains.numberlookup.api.v2.adapters;

import com.sinch.sdk.core.http.HttpClient;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

class NumberLookupServiceTest {

  @Mock HttpClient httpClient;

  @Test
  void checkCredentialsNumberLookup() {
    CredentialsValidationHelper.checkCredentials(() -> httpClient, NumberLookupService::lookup);
  }
}
