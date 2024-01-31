package com.sinch.sdk.domains.voice.models.svaml;

import com.sinch.sdk.core.models.OptionalValue;

public class InstructionStartRecording extends Instruction {

  private final OptionalValue<StartRecordingOptions> options;

  private InstructionStartRecording(OptionalValue<StartRecordingOptions> options) {
    this.options = options;
  }

  public OptionalValue<StartRecordingOptions> getOptions() {
    return options;
  }

  @Override
  public String toString() {
    return "InstructionStartRecording{" + "options=" + options + "} " + super.toString();
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> {

    OptionalValue<StartRecordingOptions> options = OptionalValue.empty();

    public Builder<B> setOptions(StartRecordingOptions options) {
      this.options = OptionalValue.of(options);
      return this;
    }

    public InstructionStartRecording build() {
      return new InstructionStartRecording(options);
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
