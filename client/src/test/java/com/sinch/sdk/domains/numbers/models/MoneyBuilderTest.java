package com.sinch.sdk.domains.numbers.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MoneyBuilderTest {

  final Money value = Money.builder().setAmount(.9).setCurrencyCode("currency").build();

  @Test
  void getCurrencyCode() {
    Assertions.assertThat(value.getCurrencyCode()).isEqualTo("currency");
  }

  @Test
  void getAmount() {
    Assertions.assertThat(value.getAmount()).isEqualTo(.9);
  }
}
