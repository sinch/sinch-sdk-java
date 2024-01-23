package com.sinch.sdk.domains.voice.models.svaml;

import com.sinch.sdk.core.models.OptionalValue;

public class AnsweringMachineDetection {

  private final OptionalValue<Boolean> enabled;

  private AnsweringMachineDetection(OptionalValue<Boolean> enabled) {
    this.enabled = enabled;
  }

  public OptionalValue<Boolean> getEnabled() {
    return enabled;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    OptionalValue<Boolean> enabled = OptionalValue.empty();

    public Builder setEnabled(Boolean enabled) {
      this.enabled = OptionalValue.of(enabled);
      return this;
    }

    public AnsweringMachineDetection build() {
      return new AnsweringMachineDetection(enabled);
    }
  }
}
