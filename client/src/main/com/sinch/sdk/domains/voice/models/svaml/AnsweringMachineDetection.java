package com.sinch.sdk.domains.voice.models.svaml;

import com.sinch.sdk.domains.voice.models.svaml.ActionConnectPstn.Builder;

public class AnsweringMachineDetection {

  private final Boolean enabled;

  private AnsweringMachineDetection(Boolean enabled) {
    this.enabled = enabled;
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    Boolean enabled;

    public Builder setEnabled(Boolean enabled) {
      this.enabled = enabled;
      return this;
    }

    public AnsweringMachineDetection build() {
      return new AnsweringMachineDetection(enabled);
    }
  }
}
