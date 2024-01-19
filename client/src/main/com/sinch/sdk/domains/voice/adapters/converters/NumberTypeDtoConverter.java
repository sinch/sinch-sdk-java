package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.domains.voice.models.NumberType;

public class NumberTypeDtoConverter {

  public static NumberType convert(String dto) {
    if (null == dto) {
      return null;
    }
    return NumberType.from(dto);
  }
}
