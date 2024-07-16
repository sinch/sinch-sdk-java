package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.domains.numbers.models.CallbackConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.callbacks.response.CallbackConfigurationResponse;

public class CallbackConfigurationDtoConverter {

  public static CallbackConfiguration convert(CallbackConfigurationResponse dto) {

    if (null == dto) {
      return null;
    }
    return CallbackConfiguration.builder()
        .setProjectId(dto.getProjectId())
        .setHMACSecret(dto.getHmacSecret())
        .build();
  }
}
