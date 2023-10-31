package com.sinch.sdk.domains.numbers.models.requests;

import com.sinch.sdk.domains.numbers.models.NumberType;
import java.util.Arrays;
import java.util.Collection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AvailableRegionListAllRequestParametersTest {

  final Collection<NumberType> types = Arrays.asList(NumberType.MOBILE, NumberType.TOLL_FREE);

  final AvailableRegionListAllRequestParameters value =
      new AvailableRegionListAllRequestParameters(types);

  @Test
  void getTypes() {
    Assertions.assertThat(value.getTypes().get()).usingRecursiveComparison().isEqualTo(types);
  }
}
