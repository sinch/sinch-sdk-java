package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.domains.voice.models.DomainType;
import com.sinch.sdk.domains.voice.models.dto.v1.DomainDto;

public class DomainTypeDtoConverter {

  public static DomainType convert(String dto) {
    if (null == dto) {
      return null;
    }
    return DomainType.from(dto.toLowerCase());
  }

  public static DomainType convert(DomainDto dto) {
    if (null == dto) {
      return null;
    }
    return DomainType.from(dto.getValue().toLowerCase());
  }
}
