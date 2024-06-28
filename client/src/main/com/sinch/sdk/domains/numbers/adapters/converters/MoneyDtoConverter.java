package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.domains.numbers.models.Money;

public class MoneyDtoConverter {

  public static Money convert(com.sinch.sdk.domains.numbers.models.v1.Money dto) {

    if (null == dto) {
      return null;
    }
    return new Money(dto.getCurrencyCode(), dto.getAmount());
  }
}
