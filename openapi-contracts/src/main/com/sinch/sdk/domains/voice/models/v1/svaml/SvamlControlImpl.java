package com.sinch.sdk.domains.voice.models.v1.svaml;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlAction;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstruction;
import java.util.Collection;
import java.util.Objects;

@JsonPropertyOrder({
  SvamlControlImpl.JSON_PROPERTY_INSTRUCTIONS,
  SvamlControlImpl.JSON_PROPERTY_ACTION
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SvamlControlImpl
    implements SvamlControl, com.sinch.sdk.domains.voice.models.v1.svaml.Control {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_INSTRUCTIONS = "instructions";

  private OptionalValue<Collection<SvamlInstruction>> instructions;

  public static final String JSON_PROPERTY_ACTION = "action";

  private OptionalValue<SvamlAction> action;

  public SvamlControlImpl() {}

  protected SvamlControlImpl(
      OptionalValue<Collection<SvamlInstruction>> instructions, OptionalValue<SvamlAction> action) {
    this.instructions = instructions;
    this.action = action;
  }

  @JsonIgnore
  public Collection<SvamlInstruction> getInstructions() {
    return instructions.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_INSTRUCTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Collection<SvamlInstruction>> instructions() {
    return instructions;
  }

  @JsonIgnore
  public SvamlAction getAction() {
    return action.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ACTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<SvamlAction> action() {
    return action;
  }

  /** Return true if this SVAMLRequestBody object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SvamlControlImpl svAMLRequestBody = (SvamlControlImpl) o;
    return Objects.equals(this.instructions, svAMLRequestBody.instructions)
        && Objects.equals(this.action, svAMLRequestBody.action);
  }

  @Override
  public int hashCode() {
    return Objects.hash(instructions, action);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SvamlControlImpl {\n");
    sb.append("    instructions: ").append(toIndentedString(instructions)).append("\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements SvamlControl.Builder {
    OptionalValue<Collection<SvamlInstruction>> instructions = OptionalValue.empty();
    OptionalValue<SvamlAction> action = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_INSTRUCTIONS)
    public Builder setInstructions(Collection<SvamlInstruction> instructions) {
      this.instructions = OptionalValue.of(instructions);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ACTION)
    public Builder setAction(SvamlAction action) {
      this.action = OptionalValue.of(action);
      return this;
    }

    public SvamlControl build() {
      return new SvamlControlImpl(instructions, action);
    }
  }
}
