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
  SvamlInstructionSetCookieImpl.JSON_PROPERTY_NAME,
  SvamlInstructionSetCookieImpl.JSON_PROPERTY_KEY,
  SvamlInstructionSetCookieImpl.JSON_PROPERTY_VALUE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SvamlInstructionSetCookieImpl
    implements SvamlInstructionSetCookie,
        com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstruction {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_NAME = "name";

  private OptionalValue<NameEnum> name;

  public static final String JSON_PROPERTY_KEY = "key";

  private OptionalValue<String> key;

  public static final String JSON_PROPERTY_VALUE = "value";

  private OptionalValue<String> value;

  public SvamlInstructionSetCookieImpl() {}

  protected SvamlInstructionSetCookieImpl(
      OptionalValue<NameEnum> name, OptionalValue<String> key, OptionalValue<String> value) {
    this.name = name;
    this.key = key;
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
  public String getKey() {
    return key.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> key() {
    return key;
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

  /** Return true if this svaml.instruction.setCookie object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SvamlInstructionSetCookieImpl svamlInstructionSetCookie = (SvamlInstructionSetCookieImpl) o;
    return Objects.equals(this.name, svamlInstructionSetCookie.name)
        && Objects.equals(this.key, svamlInstructionSetCookie.key)
        && Objects.equals(this.value, svamlInstructionSetCookie.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, key, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SvamlInstructionSetCookieImpl {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    key: ").append(toIndentedString(key)).append("\n");
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
  static class Builder implements SvamlInstructionSetCookie.Builder {
    OptionalValue<NameEnum> name = OptionalValue.of(NameEnum.SET_COOKIE);
    OptionalValue<String> key = OptionalValue.empty();
    OptionalValue<String> value = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_KEY)
    public Builder setKey(String key) {
      this.key = OptionalValue.of(key);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_VALUE)
    public Builder setValue(String value) {
      this.value = OptionalValue.of(value);
      return this;
    }

    public SvamlInstructionSetCookie build() {
      return new SvamlInstructionSetCookieImpl(name, key, value);
    }
  }
}
