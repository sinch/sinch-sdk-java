package com.sinch.sdk.domains.numbers.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RentVoiceConfigurationRequestParametersBuilderTest {

  RentVoiceConfigurationRequestParameters value =
      RentVoiceConfigurationRequestParameters.builder().setAppId("app id").build();

  @Test
  void getAppId() {
    Assertions.assertThat(value.getAppId()).isEqualTo(OptionalValue.of("app id"));
  }
}
