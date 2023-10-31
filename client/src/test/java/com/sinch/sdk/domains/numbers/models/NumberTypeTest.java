package com.sinch.sdk.domains.numbers.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberTypeTest {
  final NumberType newDefinedValue = NumberType.from("foo");

  @Test
  void values() {
    Assertions.assertThat(NumberType.values()).contains(NumberType.LOCAL);
  }

  @Test
  void fromDefined() {
    Assertions.assertThat(NumberType.from("LOCAL")).isEqualTo(NumberType.LOCAL);
  }

  @Test
  void fromUndefined() {
    Assertions.assertThat(newDefinedValue.value()).isEqualTo("foo");
    Assertions.assertThat(NumberType.values()).contains(newDefinedValue);
  }

  @Test
  void valueOf() {
    Assertions.assertThat(NumberType.valueOf(newDefinedValue)).isEqualTo("foo");
  }
}
