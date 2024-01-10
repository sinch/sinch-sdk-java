package com.sinch.sdk.domains.voice.models.requests;

import com.sinch.sdk.domains.voice.models.svaml.Action;
import com.sinch.sdk.domains.voice.models.svaml.Instruction;
import java.util.Collection;

public class CallUpdateRequestParameters {
  private final Collection<Instruction> instructions;
  private final Action action;

  private CallUpdateRequestParameters(Collection<Instruction> instructions, Action action) {
    this.instructions = instructions;
    this.action = action;
  }

  public Collection<Instruction> getInstructions() {
    return instructions;
  }

  public Action getAction() {
    return action;
  }

  @Override
  public String toString() {
    return "CallUpdateRequestParameters{"
        + "instructions="
        + instructions
        + ", action="
        + action
        + '}';
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    Collection<Instruction> instructions;
    Action action;

    public Builder() {}

    public Builder setInstructions(Collection<Instruction> instructions) {
      this.instructions = instructions;
      return this;
    }

    public Builder setAction(Action action) {
      this.action = action;
      return this;
    }

    public CallUpdateRequestParameters build() {
      return new CallUpdateRequestParameters(instructions, action);
    }
  }
}
