package com.sinch.sdk.domains.voice.models.svaml;

public class InstructionStartRecording extends Instruction {

  private final StartRecordingOptions options;

  private InstructionStartRecording(StartRecordingOptions options) {
    this.options = options;
  }

  public StartRecordingOptions getOptions() {
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

    StartRecordingOptions options;

    public Builder<B> setOptions(StartRecordingOptions options) {
      this.options = options;
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
