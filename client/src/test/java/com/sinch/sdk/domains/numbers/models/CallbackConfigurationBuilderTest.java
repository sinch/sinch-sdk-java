package com.sinch.sdk.domains.numbers.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CallbackConfigurationBuilderTest {

  final CallbackConfiguration value =
      CallbackConfiguration.builder()
          .setProjectId("project id")
          .setHMACSecret("a HMAC secret")
          .build();

  @Test
  void getProjectId() {
    Assertions.assertThat(value.getProjectId()).isEqualTo("project id");
  }

  @Test
  void getHMACSecret() {
    Assertions.assertThat(value.getHMACSecret()).isEqualTo("a HMAC secret");
  }
}
