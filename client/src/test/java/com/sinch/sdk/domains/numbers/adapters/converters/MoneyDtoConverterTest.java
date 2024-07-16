package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numbers.models.Money;
import org.junit.jupiter.api.Test;

class MoneyDtoConverterTest {

  @Test
  void convert() {
    com.sinch.sdk.domains.numbers.models.v1.Money.Builder builder =
        com.sinch.sdk.domains.numbers.models.v1.Money.builder();
    builder.setAmount(15.37);
    builder.setCurrencyCode("currency code");

    Money expected = new Money("currency code", 15.37);
    TestHelpers.recursiveEquals(expected, MoneyDtoConverter.convert(builder.build()));
  }
}
