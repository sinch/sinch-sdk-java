package com.sinch.sdk.domains.numbers.models.requests;

import com.sinch.sdk.domains.numbers.models.*;
import java.util.Arrays;
import java.util.Collection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActiveNumberListRequestParametersBuilderTest {

  static final String regionCode = "foo region";
  static final NumberType type = NumberType.MOBILE;
  static final NumberPattern numberPattern =
      NumberPattern.builder().setPattern("a pattern").setSearchPattern(SearchPattern.END).build();
  static final Collection<Capability> capabilities =
      Arrays.asList(Capability.VOICE, Capability.SMS);
  static final Integer pageSize = 45;

  static final String pageToken = "page token";

  static final OrderBy orderBy = OrderBy.PHONE_NUMBER;
  public static final ActiveNumberListRequestParameters value =
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
    Assertions.assertThat(value.getRegionCode().get()).isEqualTo(regionCode);
  }

  @Test
  void getType() {
    Assertions.assertThat(value.getType().get()).usingRecursiveComparison().isEqualTo(type);
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
