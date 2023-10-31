package com.sinch.sdk.domains.numbers.models;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CapabilityTest {

  final Capability newDefinedValue = Capability.from("foo");

  @Test
  void values() {
    Assertions.assertThat(Capability.values()).contains(Capability.SMS);
  }

  @Test
  void fromDefined() {
    Assertions.assertThat(Capability.from("SMS")).isEqualTo(Capability.SMS);
  }

  @Test
  void fromUndefined() {
    Assertions.assertThat(newDefinedValue.value()).isEqualTo("foo");
    Assertions.assertThat(Capability.values()).contains(newDefinedValue);
  }

  @Test
  void valueOf() {
    Assertions.assertThat(Capability.valueOf(newDefinedValue)).isEqualTo("foo");
  }
}
