package com.sinch.sdk.domains.numbers.adapters.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sinch.sdk.domains.numbers.models.dto.v1.CallbackConfigurationUpdateDto;
import com.sinch.sdk.domains.numbers.models.requests.CallbackConfigurationUpdateRequestParameters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CallbackConfigurationUpdateParametersDtoConverterTest {

  CallbackConfigurationUpdateRequestParameters item;

  public static void compareWithDto(
      CallbackConfigurationUpdateRequestParameters client, CallbackConfigurationUpdateDto dto) {
    assertEquals(dto.getHmacSecret(), client.getHMACSecret().get());
  }

  @Test
  void convert() {
    CallbackConfigurationUpdateDto converted =
        CallbackConfigurationUpdateRequestParametersDtoConverter.convert(item);
    compareWithDto(item, converted);
  }

  @BeforeEach
  void setUp() {

    item = CallbackConfigurationUpdateRequestParameters.builder().setHMACSecret("my HMAC").build();
  }
}
