package com.sinch.sdk.domains.numbers.models.requests;

import com.sinch.sdk.domains.numbers.models.*;
import java.util.Arrays;
import java.util.Collection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ActiveNumberListRequestParametersTest {

  static final String regionCode = "foo region";
  static final NumberType type = NumberType.MOBILE;
  static final NumberPattern numberPattern = new NumberPattern("a pattern", SearchPattern.END);
  static final Collection<Capability> capabilities =
      Arrays.asList(Capability.VOICE, Capability.SMS);
  static final Integer pageSize = 45;

  static final String pageToken = "page token";

  static final OrderBy orderBy = OrderBy.PHONE_NUMBER;

  public static final ActiveNumberListRequestParameters value =
      new ActiveNumberListRequestParameters(
          regionCode, type, numberPattern, capabilities, pageSize, pageToken, orderBy);

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
