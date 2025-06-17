package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinch.sdk.core.models.OptionalValue;

@Deprecated
public class ConnectPstnAnsweringMachineDetectionImpl extends AnsweringMachineDetectionQueryImpl
    implements ConnectPstnAnsweringMachineDetection {

  public ConnectPstnAnsweringMachineDetectionImpl(
      OptionalValue<Boolean> enabled, OptionalValue<Boolean> async) {
    super(enabled, async);
  }

  @Deprecated
  static class Builder implements ConnectPstnAnsweringMachineDetection.Builder {

    OptionalValue<Boolean> enabled = OptionalValue.empty();
    OptionalValue<Boolean> async = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ENABLED)
    public Builder setEnabled(Boolean enabled) {
      this.enabled = OptionalValue.of(enabled);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ASYNC)
    public Builder setAsync(Boolean async) {
      this.async = OptionalValue.of(async);
      return this;
    }

    public ConnectPstnAnsweringMachineDetectionImpl build() {
      return new ConnectPstnAnsweringMachineDetectionImpl(enabled, async);
    }
  }
}
