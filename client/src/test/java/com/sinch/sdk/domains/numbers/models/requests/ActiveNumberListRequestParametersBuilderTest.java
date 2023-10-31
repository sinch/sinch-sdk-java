package com.sinch.sdk.domains.numbers.models.requests;

import com.sinch.sdk.domains.numbers.models.*;
import java.util.Arrays;
import java.util.Collection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ActiveNumberListRequestParametersBuilderTest {

  final String regionCode = "foo region";
  final NumberType type = NumberType.MOBILE;
  final NumberPattern numberPattern =
      NumberPattern.builder().setPattern("a pattern").setSearchPattern(SearchPattern.END).build();
  final Collection<Capability> capabilities = Arrays.asList(Capability.VOICE, Capability.SMS);
  final Integer pageSize = 45;

  final String pageToken = "page token";

  final OrderBy orderBy = OrderBy.PHONE_NUMBER;
  final ActiveNumberListRequestParameters value =
      ActiveNumberListRequestParameters.builder()
          .setRegionCode(regionCode)
          .setType(type)
          .setNumberPattern(numberPattern)
          .setCapabilities(capabilities)
          .setPageSize(pageSize)
          .setPageToken(pageToken)
          .setOrderBy(orderBy)
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
  void getPageSize() {
    Assertions.assertThat(value.getPageSize().get()).isEqualTo(pageSize);
  }

  @Test
  void getPageToken() {
    Assertions.assertThat(value.getPageToken().get()).isEqualTo(pageToken);
  }

  @Test
  void getOrderBy() {
    Assertions.assertThat(value.getOrderBy().get()).isEqualTo(orderBy);
  }
}
