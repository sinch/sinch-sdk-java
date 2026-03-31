package com.sinch.sdk.domains.voice.models.v1.svaml.instruction;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({SvamlInstructionStopRecordingImpl.JSON_PROPERTY_NAME})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SvamlInstructionStopRecordingImpl
    implements SvamlInstructionStopRecording,
        com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstruction {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_NAME = "name";

  private OptionalValue<NameEnum> name;

  public SvamlInstructionStopRecordingImpl() {}

  protected SvamlInstructionStopRecordingImpl(OptionalValue<NameEnum> name) {
    this.name = name;
  }

  @JsonIgnore
  public NameEnum getName() {
    return name.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<NameEnum> name() {
    return name;
  }

  /** Return true if this svaml.instruction.stopRecording object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SvamlInstructionStopRecordingImpl svamlInstructionStopRecording =
        (SvamlInstructionStopRecordingImpl) o;
    return Objects.equals(this.name, svamlInstructionStopRecording.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SvamlInstructionStopRecordingImpl {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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
  static class Builder implements SvamlInstructionStopRecording.Builder {
    OptionalValue<NameEnum> name = OptionalValue.of(NameEnum.STOP_RECORDING);

    @JsonProperty(value = JSON_PROPERTY_NAME, required = true)
    Builder setName(NameEnum name) {
      if (!Objects.equals(name, NameEnum.STOP_RECORDING)) {
        throw new IllegalArgumentException(
            String.format("'name' must be '%s' (is '%s')", NameEnum.STOP_RECORDING, name));
      }
      return this;
    }

    public SvamlInstructionStopRecording build() {
      return new SvamlInstructionStopRecordingImpl(name);
    }
  }
}
