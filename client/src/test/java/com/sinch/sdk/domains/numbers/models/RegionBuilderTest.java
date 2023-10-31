package com.sinch.sdk.domains.numbers.models;

import java.util.Collection;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RegionBuilderTest {

  Collection<NumberType> types = Collections.singletonList(NumberType.TOLL_FREE);
  final Region value =
      Region.builder().setRegionCode("foo code").setRegionName("foo name").setTypes(types).build();

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
