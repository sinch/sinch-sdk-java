package com.sinch.sdk.domains.numbers.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MoneyTest {

  final Money value = new Money("currency", .9);

  @Test
  void getCurrencyCode() {
    Assertions.assertThat(value.getCurrencyCode()).isEqualTo("currency");
  }

  @Test
  void getAmount() {
    Assertions.assertThat(value.getAmount()).isEqualTo(.9);
  }
}
