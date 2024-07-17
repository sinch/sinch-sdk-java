package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numbers.models.requests.CallbackConfigurationUpdateRequestParameters;
import com.sinch.sdk.domains.numbers.models.v1.CallbackConfigurationDtoTest;
import com.sinch.sdk.domains.numbers.models.v1.callbacks.request.CallbackConfigurationUpdateRequest;
import org.junit.jupiter.api.Test;

class CallbackConfigurationUpdateParametersDtoConverterTest {

  @Test
  void convert() {
    CallbackConfigurationUpdateRequest converted =
        CallbackConfigurationUpdateRequestParametersDtoConverter.convert(
            CallbackConfigurationUpdateRequestParameters.builder()
                .setHMACSecret("HMAC value")
                .build());
    TestHelpers.recursiveEquals(converted, CallbackConfigurationDtoTest.updateRequest);
  }
}
