package com.sinch.sdk.domains.numbers.models.requests;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CallbackConfigurationUpdateRequestParametersTest {

  final CallbackConfigurationUpdateRequestParameters value =
      new CallbackConfigurationUpdateRequestParameters("hmac value");

  @Test
  void getHMACSecret() {
    Assertions.assertThat(value.getHMACSecret()).isEqualTo("hmac value");
  }
}
