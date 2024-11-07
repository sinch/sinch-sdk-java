package com.sinch.sdk.domains.voice.models.v1.svaml.instruction;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  SvamlInstructionStartRecordingImpl.JSON_PROPERTY_NAME,
  SvamlInstructionStartRecordingImpl.JSON_PROPERTY_OPTIONS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SvamlInstructionStartRecordingImpl
    implements SvamlInstructionStartRecording,
        com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstruction {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_NAME = "name";

  private OptionalValue<NameEnum> name;

  public static final String JSON_PROPERTY_OPTIONS = "options";

  private OptionalValue<StartRecordingOptions> options;

  public SvamlInstructionStartRecordingImpl() {}

  protected SvamlInstructionStartRecordingImpl(
      OptionalValue<NameEnum> name, OptionalValue<StartRecordingOptions> options) {
    this.name = name;
    this.options = options;
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

  @JsonIgnore
  public StartRecordingOptions getOptions() {
    return options.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<StartRecordingOptions> options() {
    return options;
  }

  /** Return true if this svaml.instruction.startRecording object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SvamlInstructionStartRecordingImpl svamlInstructionStartRecording =
        (SvamlInstructionStartRecordingImpl) o;
    return Objects.equals(this.name, svamlInstructionStartRecording.name)
        && Objects.equals(this.options, svamlInstructionStartRecording.options);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, options);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SvamlInstructionStartRecordingImpl {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    options: ").append(toIndentedString(options)).append("\n");
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
  static class Builder implements SvamlInstructionStartRecording.Builder {
    OptionalValue<NameEnum> name = OptionalValue.of(NameEnum.START_RECORDING);
    OptionalValue<StartRecordingOptions> options = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_OPTIONS)
    public Builder setOptions(StartRecordingOptions options) {
      this.options = OptionalValue.of(options);
      return this;
    }

    public SvamlInstructionStartRecording build() {
      return new SvamlInstructionStartRecordingImpl(name, options);
    }
  }
}
