package com.sinch.sdk.domains.numbers.adapters.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sinch.sdk.domains.numbers.models.CallbackConfiguration;
import com.sinch.sdk.domains.numbers.models.dto.v1.CallbackConfigurationDto;
import org.junit.jupiter.api.Test;

class CallbackConfigurationDtoConverterTest {

  public static void compareWithDto(CallbackConfiguration client, CallbackConfigurationDto dto) {
    if (null == client && null == dto) {
      return;
    }
    assertEquals(dto.getProjectId(), client.getProjectId());
    assertEquals(dto.getHmacSecret(), client.getHMACSecret());
  }

  @Test
  void convert() {
    CallbackConfigurationDto dto = new CallbackConfigurationDto();
    dto.setProjectId("my project");
    dto.setHmacSecret("a HMAC secret");

    CallbackConfiguration converted = CallbackConfigurationDtoConverter.convert(dto);
    compareWithDto(converted, dto);
  }
}
