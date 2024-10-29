package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.domains.voice.models.NumberType;
import com.sinch.sdk.domains.voice.models.v1.applications.response.QueryNumberInformation.NumberTypeEnum;

public class NumberTypeDtoConverter {

  public static NumberType convert(NumberTypeEnum dto) {
    if (null == dto) {
      return null;
    }
    return NumberType.from(dto.value());
  }
}
