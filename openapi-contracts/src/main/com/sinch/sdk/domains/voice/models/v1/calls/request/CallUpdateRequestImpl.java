package com.sinch.sdk.domains.voice.models.v1.calls.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.ManagedCallSvamlAction;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstruction;
import java.util.Collection;
import java.util.Objects;

@JsonPropertyOrder({
  CallUpdateRequestImpl.JSON_PROPERTY_INSTRUCTIONS,
  CallUpdateRequestImpl.JSON_PROPERTY_ACTION
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CallUpdateRequestImpl implements CallUpdateRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_INSTRUCTIONS = "instructions";

  private OptionalValue<Collection<SvamlInstruction>> instructions;

  public static final String JSON_PROPERTY_ACTION = "action";

  private OptionalValue<ManagedCallSvamlAction> action;

  public CallUpdateRequestImpl() {}

  protected CallUpdateRequestImpl(
      OptionalValue<Collection<SvamlInstruction>> instructions,
      OptionalValue<ManagedCallSvamlAction> action) {
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
  public ManagedCallSvamlAction getAction() {
    return action.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ACTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ManagedCallSvamlAction> action() {
    return action;
  }

  /** Return true if this PATCHSVAMLRequestBody object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CallUpdateRequestImpl paTCHSVAMLRequestBody = (CallUpdateRequestImpl) o;
    return Objects.equals(this.instructions, paTCHSVAMLRequestBody.instructions)
        && Objects.equals(this.action, paTCHSVAMLRequestBody.action);
  }

  @Override
  public int hashCode() {
    return Objects.hash(instructions, action);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CallUpdateRequestImpl {\n");
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
  static class Builder implements CallUpdateRequest.Builder {
    OptionalValue<Collection<SvamlInstruction>> instructions = OptionalValue.empty();
    OptionalValue<ManagedCallSvamlAction> action = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_INSTRUCTIONS)
    public Builder setInstructions(Collection<SvamlInstruction> instructions) {
      this.instructions = OptionalValue.of(instructions);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ACTION)
    public Builder setAction(ManagedCallSvamlAction action) {
      this.action = OptionalValue.of(action);
      return this;
    }

    public CallUpdateRequest build() {
      return new CallUpdateRequestImpl(instructions, action);
    }
  }
}
