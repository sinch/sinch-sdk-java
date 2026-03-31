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
  SvamlInstructionSendDtmfImpl.JSON_PROPERTY_NAME,
  SvamlInstructionSendDtmfImpl.JSON_PROPERTY_VALUE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SvamlInstructionSendDtmfImpl
    implements SvamlInstructionSendDtmf,
        com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstruction {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_NAME = "name";

  private OptionalValue<NameEnum> name;

  public static final String JSON_PROPERTY_VALUE = "value";

  private OptionalValue<String> value;

  public SvamlInstructionSendDtmfImpl() {}

  protected SvamlInstructionSendDtmfImpl(
      OptionalValue<NameEnum> name, OptionalValue<String> value) {
    this.name = name;
    this.value = value;
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
  public String getValue() {
    return value.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> value() {
    return value;
  }

  /** Return true if this svaml.instruction.sendDtmf object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SvamlInstructionSendDtmfImpl svamlInstructionSendDtmf = (SvamlInstructionSendDtmfImpl) o;
    return Objects.equals(this.name, svamlInstructionSendDtmf.name)
        && Objects.equals(this.value, svamlInstructionSendDtmf.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SvamlInstructionSendDtmfImpl {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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
  static class Builder implements SvamlInstructionSendDtmf.Builder {
    OptionalValue<NameEnum> name = OptionalValue.of(NameEnum.SEND_DTMF);
    OptionalValue<String> value = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_NAME, required = true)
    Builder setName(NameEnum name) {
      if (!Objects.equals(name, NameEnum.SEND_DTMF)) {
        throw new IllegalArgumentException(
            String.format("'name' must be '%s' (is '%s')", NameEnum.SEND_DTMF, name));
      }
      return this;
    }

    @JsonProperty(JSON_PROPERTY_VALUE)
    public Builder setValue(String value) {
      this.value = OptionalValue.of(value);
      return this;
    }

    public SvamlInstructionSendDtmf build() {
      return new SvamlInstructionSendDtmfImpl(name, value);
    }
  }
}
