package com.sinch.sdk.domains.numbers.adapters.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sinch.sdk.domains.numbers.models.Money;
import com.sinch.sdk.domains.numbers.models.dto.v1.MoneyDto;
import org.junit.jupiter.api.Test;

class MoneyDtoConverterTest {

  public static void compareWithDto(Money client, MoneyDto dto) {
    if (null == client && null == dto) {
      return;
    }
    assertEquals(Double.valueOf(dto.getAmount()), client.getAmount());
    assertEquals(dto.getCurrencyCode(), client.getCurrencyCode());
  }

  @Test
  void convert() {
    MoneyDto dto = new MoneyDto();
    dto.setAmount("15.37");
    dto.setCurrencyCode("currency code");

    Money converted = MoneyDtoConverter.convert(dto);
    compareWithDto(converted, dto);
  }
}
