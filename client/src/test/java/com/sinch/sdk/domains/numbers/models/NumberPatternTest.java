package com.sinch.sdk.domains.numbers.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberPatternTest {
  final NumberPattern value = new NumberPattern("a pattern", SearchPattern.CONTAINS);

  @Test
  void getPattern() {
    Assertions.assertThat(value.getPattern()).isEqualTo("a pattern");
  }

  @Test
  void getSearchPattern() {
    Assertions.assertThat(value.getSearchPattern()).isEqualTo(SearchPattern.CONTAINS);
  }
}
