package com.sinch.sdk.core.http;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class HttpStatusTest {

  @Test
  void isSuccessfulStatus() {
    Assertions.assertThat(HttpStatus.isSuccessfulStatus(200)).isTrue();
  }

  @Test
  void isFailureStatus() {
    Assertions.assertThat(HttpStatus.isSuccessfulStatus(500)).isFalse();
  }
}
