package com.sinch.sdk.domains.voice.models.requests;

import com.sinch.sdk.domains.voice.models.svaml.Action;
import com.sinch.sdk.domains.voice.models.svaml.Instruction;
import java.util.Collection;

/**
 * Class enabling to define SAVML actions and instructions
 *
 * @see <a href="https://developers.sinch.com/docs/voice/api-reference/svaml/">SAVML
 *     Dcoumentation</a>
 */
public class CallsUpdateRequestParameters {
  private final Collection<Instruction> instructions;
  private final Action action;

  private CallsUpdateRequestParameters(Collection<Instruction> instructions, Action action) {
    this.instructions = instructions;
    this.action = action;
  }

  /**
   * Get instructions related to request
   *
   * @return See builder {@link Builder#setInstructions setter}
   */
  public Collection<Instruction> getInstructions() {
    return instructions;
  }

  /**
   * Get action related to request
   *
   * @return See builder {@link Builder#setAction setter}
   */
  public Action getAction() {
    return action;
  }

  @Override
  public String toString() {
    return "CallsUpdateRequestParameters{"
        + "instructions="
        + instructions
        + ", action="
        + action
        + '}';
  }

  /**
   * Create a builder instance
   *
   * @return Dedicated builder
   */
  public static Builder builder() {
    return new Builder();
  }

  public static class Builder {

    Collection<Instruction> instructions;
    Action action;

    public Builder() {}

    /**
     * The collection of instructions that can perform various tasks during the call
     *
     * @param instructions Instructions list
     * @return Current builder
     */
    public Builder setInstructions(Collection<Instruction> instructions) {
      this.instructions = instructions;
      return this;
    }

    /**
     * The action that will control the call
     *
     * @param action The action description
     * @return Current builder
     */
    public Builder setAction(Action action) {
      this.action = action;
      return this;
    }

    /**
     * Build the instance
     *
     * @return Built instance
     */
    public CallsUpdateRequestParameters build() {
      return new CallsUpdateRequestParameters(instructions, action);
    }
  }
}
