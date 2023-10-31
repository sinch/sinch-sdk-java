package com.sinch.sdk.domains.numbers.models.requests;

import com.sinch.sdk.domains.numbers.models.Capability;
import com.sinch.sdk.domains.numbers.models.NumberPattern;
import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.SearchPattern;
import java.util.Arrays;
import java.util.Collection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class AvailableNumberListAllRequestParametersTest {

  final String regionCode = "foo region";
  final NumberType type = NumberType.MOBILE;
  final NumberPattern numberPattern = new NumberPattern("a pattern", SearchPattern.END);
  final Collection<Capability> capabilities = Arrays.asList(Capability.VOICE, Capability.SMS);
  final Integer size = 145;

  final AvailableNumberListAllRequestParameters value =
      new AvailableNumberListAllRequestParameters(
          regionCode, type, numberPattern, capabilities, size);

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
