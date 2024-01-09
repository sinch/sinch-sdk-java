package com.sinch.sdk.domains.voice.models.svaml;

public class AnsweringMachineDetection {

  private final Boolean enabled;

  public AnsweringMachineDetection(Boolean enabled) {
    this.enabled = enabled;
  }

  public Boolean getEnabled() {
    return enabled;
  }

  public static class Builder {

    Boolean enabled;

    public AnsweringMachineDetection build() {
      return new AnsweringMachineDetection(enabled);
    }
  }
}
