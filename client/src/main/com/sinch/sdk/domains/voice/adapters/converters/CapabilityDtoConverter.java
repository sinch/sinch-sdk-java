package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.domains.voice.models.CapabilityType;

public class CapabilityDtoConverter {

  public static CapabilityType convert(String dto) {
    if (null == dto) {
      return null;
    }
    return CapabilityType.from(dto);
  }
}
