package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.domains.numbers.models.Money;
import com.sinch.sdk.domains.numbers.models.dto.v1.MoneyDto;

public class MoneyDtoConverter {

  public static Money convert(MoneyDto dto) {

    if (null == dto) {
      return null;
    }
    return new Money(dto.getCurrencyCode(), Double.valueOf(dto.getAmount()));
  }
}
