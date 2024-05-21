package com.sinch.sdk.domains.verification.adapters.converters;

import com.sinch.sdk.domains.verification.models.Price;
import com.sinch.sdk.domains.verification.models.dto.v1.PriceDto;

public class PriceDtoConverter {

  public static Price convert(PriceDto dto) {
    if (null == dto) {
      return Price.builder().build();
    }
    return Price.builder()
        .setCurrencyId(dto.getCurrencyId())
        .setAmount(dto.getAmount())
        .build();
  }
}
