package com.sinch.sdk.domains.numbers.models.requests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CallbackConfigurationUpdateRequestParametersBuilderTest {

  final CallbackConfigurationUpdateRequestParameters value =
      CallbackConfigurationUpdateRequestParameters.builder().setHMACSecret("hmac value").build();

  @Test
  void getHMACSecret() {
    Assertions.assertThat(value.getHMACSecret()).isEqualTo("hmac value");
  }
}
