package com.sinch.sdk.domains.verification.adapters.converters;

import com.sinch.sdk.domains.verification.models.Price;

public class PriceDtoConverter {

  public static Price convert(com.sinch.sdk.domains.verification.models.v1.Price dto) {
    if (null == dto) {
      return Price.builder().build();
    }
    return Price.builder().setCurrencyId(dto.getCurrencyId()).setAmount(dto.getAmount()).build();
  }
}
