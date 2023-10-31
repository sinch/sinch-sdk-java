package com.sinch.sdk.domains.numbers.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CallbackConfigurationTest {

  final CallbackConfiguration value =
      new CallbackConfiguration("the project id", "the secret HMAC");

  @Test
  void getProjectId() {
    Assertions.assertThat(value.getProjectId()).isEqualTo("the project id");
  }

  @Test
  void getHMACSecret() {
    Assertions.assertThat(value.getHMACSecret()).isEqualTo("the secret HMAC");
  }
}
