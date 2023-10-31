package com.sinch.sdk.domains.numbers.models;

import java.util.Collection;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RegionTest {

  Collection<NumberType> types = Collections.singletonList(NumberType.TOLL_FREE);
  final Region value = new Region("foo code", "foo name", types);

  @Test
  void getRegionCode() {
    Assertions.assertThat(value.getRegionCode()).isEqualTo("foo code");
  }

  @Test
  void getRegionName() {
    Assertions.assertThat(value.getRegionName()).isEqualTo("foo name");
  }

  @Test
  void getTypes() {
    Assertions.assertThat(value.getTypes()).usingRecursiveComparison().isEqualTo(types);
  }
}
