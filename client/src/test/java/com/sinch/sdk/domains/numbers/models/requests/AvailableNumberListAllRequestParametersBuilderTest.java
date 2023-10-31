package com.sinch.sdk.domains.numbers.models.requests;

import com.sinch.sdk.domains.numbers.models.Capability;
import com.sinch.sdk.domains.numbers.models.NumberPattern;
import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.SearchPattern;
import java.util.Arrays;
import java.util.Collection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AvailableNumberListAllRequestParametersBuilderTest {

  final String regionCode = "foo region";
  final NumberType type = NumberType.MOBILE;
  final NumberPattern numberPattern =
      NumberPattern.builder().setPattern("a pattern").setSearchPattern(SearchPattern.END).build();
  final Collection<Capability> capabilities = Arrays.asList(Capability.VOICE, Capability.SMS);
  final Integer size = 145;

  final AvailableNumberListAllRequestParameters value =
      AvailableNumberListAllRequestParameters.builder()
          .setRegionCode(regionCode)
          .setType(type)
          .setNumberPattern(numberPattern)
          .setCapabilities(capabilities)
          .setSize(size)
          .build();

  @Test
  void getRegionCode() {
    Assertions.assertThat(value.getRegionCode()).isEqualTo(regionCode);
  }

  @Test
  void getType() {
    Assertions.assertThat(value.getType()).usingRecursiveComparison().isEqualTo(type);
  }

  @Test
  void getNumberPattern() {
    Assertions.assertThat(value.getNumberPattern().get())
        .usingRecursiveComparison()
        .isEqualTo(numberPattern);
  }

  @Test
  void getCapabilities() {
    Assertions.assertThat(value.getCapabilities().get())
        .usingRecursiveComparison()
        .isEqualTo(capabilities);
  }

  @Test
  void getSize() {
    Assertions.assertThat(value.getSize().get()).isEqualTo(size);
  }
}
