package com.sinch.sdk.domains.sms.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MediaBodyTest {

  final MediaBody value = new MediaBody("the url", "the message");

  @Test
  void getMessage() {
    Assertions.assertThat(value.getMessage()).isEqualTo("the message");
  }

  @Test
  void getUrl() {
    Assertions.assertThat(value.getUrl()).isEqualTo("the url");
  }
}
