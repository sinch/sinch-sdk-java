package com.sinch.sdk.domains.voice.models.svaml;

public class InstructionStopRecording extends Instruction {

  private InstructionStopRecording() {}

  @Override
  public String toString() {
    return "InstructionStopRecording{" + "} " + super.toString();
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> {

    public InstructionStopRecording build() {
      return new InstructionStopRecording();
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
