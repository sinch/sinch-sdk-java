package com.sinch.sdk.domains.numbers.models.requests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RentVoiceConfigurationRequestParametersTest {

  RentVoiceConfigurationRequestParameters value =
      new RentVoiceConfigurationRequestParameters("app id");

  @Test
  void getAppId() {
    Assertions.assertThat(value.getAppId()).isEqualTo("app id");
  }
}
