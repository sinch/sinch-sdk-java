package com.sinch.sdk.domains.voice.models.svaml;

public class InstructionAnswer extends Instruction {

  private InstructionAnswer() {}

  @Override
  public String toString() {
    return "InstructionAnswer{} " + super.toString();
  }

  public static Builder<?> builder() {
    return new Builder<>();
  }

  public static class Builder<B extends Builder<B>> {

    public InstructionAnswer build() {
      return new InstructionAnswer();
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }
  }
}
