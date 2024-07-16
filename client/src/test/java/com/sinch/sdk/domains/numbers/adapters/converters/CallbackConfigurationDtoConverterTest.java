package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numbers.models.CallbackConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.CallbackConfigurationDtoTest;
import org.junit.jupiter.api.Test;

class CallbackConfigurationDtoConverterTest {

  @Test
  void convert() {
    CallbackConfiguration item =
        CallbackConfiguration.builder()
            .setProjectId("Project ID value")
            .setHMACSecret("HMAC value")
            .build();

    CallbackConfiguration converted =
        CallbackConfigurationDtoConverter.convert(CallbackConfigurationDtoTest.getResponse);
    TestHelpers.recursiveEquals(converted, item);
  }
}
