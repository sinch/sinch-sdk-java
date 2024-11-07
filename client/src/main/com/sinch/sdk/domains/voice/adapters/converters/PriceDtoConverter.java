package com.sinch.sdk.domains.voice.adapters.converters;

import com.sinch.sdk.domains.voice.models.Price;

public class PriceDtoConverter {

  public static Price convert(com.sinch.sdk.domains.voice.models.v1.Price dto) {
    if (null == dto) {
      return Price.builder().build();
    }
    return Price.builder().setCurrencyId(dto.getCurrencyId()).setAmount(dto.getAmount()).build();
  }
}
