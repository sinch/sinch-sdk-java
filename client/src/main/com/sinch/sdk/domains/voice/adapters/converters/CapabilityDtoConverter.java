package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.domains.voice.models.CapabilityType;
import com.sinch.sdk.domains.voice.models.v1.applications.Capability;

public class CapabilityDtoConverter {

  public static CapabilityType convert(Capability dto) {
    if (null == dto) {
      return null;
    }
    return CapabilityType.from(dto.value());
  }
}
