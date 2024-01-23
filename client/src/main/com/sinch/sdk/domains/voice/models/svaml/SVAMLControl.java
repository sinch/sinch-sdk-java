package com.sinch.sdk.domains.voice.models.svaml;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.requests.Control;
import java.util.Collection;

/**
 * Class enabling to define SAVML actions and instructions
 *
 * @see <a href="https://developers.sinch.com/docs/voice/api-reference/svaml/">SAVML
 *     Dcoumentation</a>
 */
public class SVAMLControl extends Control {
  private final OptionalValue<Collection<Instruction>> instructions;
  private final OptionalValue<Action> action;

  private SVAMLControl(
      OptionalValue<Collection<Instruction>> instructions, OptionalValue<Action> action) {
    this.instructions = instructions;
    this.action = action;
  }

  /**
   * Get instructions related to request
   *
   * @return See builder {@link Builder#setInstructions setter}
   */
  public OptionalValue<Collection<Instruction>> getInstructions() {
    return instructions;
  }

  /**
   * Get action related to request
   *
   * @return See builder {@link Builder#setAction setter}
   */
  public OptionalValue<Action> getAction() {
    return action;
  }

  @Override
  public String toString() {
    return "SVAMLControl{" + "instructions=" + instructions + ", action=" + action + '}';
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

    OptionalValue<Collection<Instruction>> instructions = OptionalValue.empty();
    OptionalValue<Action> action = OptionalValue.empty();

    public Builder() {}

    /**
     * The collection of instructions that can perform various tasks during the call
     *
     * @param instructions Instructions list
     * @return Current builder
     */
    public Builder setInstructions(Collection<Instruction> instructions) {
      this.instructions = OptionalValue.of(instructions);
      return this;
    }

    /**
     * The action that will control the call
     *
     * @param action The action description
     * @return Current builder
     */
    public Builder setAction(Action action) {
      this.action = OptionalValue.of(action);
      return this;
    }

    /**
     * Build the instance
     *
     * @return Built instance
     */
    public SVAMLControl build() {
      return new SVAMLControl(instructions, action);
    }
  }
}
