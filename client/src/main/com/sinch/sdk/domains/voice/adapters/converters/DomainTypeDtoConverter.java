package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.domains.voice.models.DomainType;
import com.sinch.sdk.domains.voice.models.v1.Domain;

public class DomainTypeDtoConverter {

  public static DomainType convert(String dto) {
    if (null == dto) {
      return null;
    }
    return DomainType.from(dto.toLowerCase());
  }

  public static DomainType convert(Domain dto) {
    if (null == dto) {
      return null;
    }
    return DomainType.from(dto.value().toLowerCase());
  }
}
