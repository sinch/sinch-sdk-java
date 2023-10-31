package com.sinch.sdk.domains.numbers.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberPatternBuilderTest {
  final NumberPattern value =
      NumberPattern.builder()
          .setPattern("a pattern")
          .setSearchPattern(SearchPattern.CONTAINS)
          .build();

  @Test
  void getPattern() {
    Assertions.assertThat(value.getPattern()).isEqualTo("a pattern");
  }

  @Test
  void getSearchPattern() {
    Assertions.assertThat(value.getSearchPattern()).isEqualTo(SearchPattern.CONTAINS);
  }
}
