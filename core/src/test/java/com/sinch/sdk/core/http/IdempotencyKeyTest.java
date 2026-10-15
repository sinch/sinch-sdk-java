package com.sinch.sdk.core.http;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class IdempotencyKeyTest {

  // Sinch API standards: keys are 16 to 128 characters long
  @Test
  void generatedKeyLengthFollowsStandard() {
    Assertions.assertThat(IdempotencyKey.generate()).hasSizeBetween(16, 128);
  }

  // One key per operation: two calls must not return the same key
  @Test
  void generatedKeysAreDistinct() {
    Assertions.assertThat(IdempotencyKey.generate()).isNotEqualTo(IdempotencyKey.generate());
  }
}
