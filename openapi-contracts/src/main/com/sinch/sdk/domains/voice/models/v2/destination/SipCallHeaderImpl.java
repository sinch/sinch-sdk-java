package com.sinch.sdk.domains.voice.models.v2.destination;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({SipCallHeaderImpl.JSON_PROPERTY_KEY, SipCallHeaderImpl.JSON_PROPERTY_VALUE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SipCallHeaderImpl implements SipCallHeader {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_KEY = "key";

  private OptionalValue<String> key;

  public static final String JSON_PROPERTY_VALUE = "value";

  private OptionalValue<String> value;

  public SipCallHeaderImpl() {}

  protected SipCallHeaderImpl(OptionalValue<String> key, OptionalValue<String> value) {
    this.key = key;
    this.value = value;
  }

  @JsonIgnore
  public String getKey() {
    return key.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_KEY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
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

  /** Return true if this SipCallHeader object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SipCallHeaderImpl sipCallHeader = (SipCallHeaderImpl) o;
    return Objects.equals(this.key, sipCallHeader.key)
        && Objects.equals(this.value, sipCallHeader.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(key, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SipCallHeaderImpl {\n");
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
  static class Builder implements SipCallHeader.Builder {
    OptionalValue<String> key = OptionalValue.empty();
    OptionalValue<String> value = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_KEY, required = true)
    public Builder setKey(String key) {
      this.key = OptionalValue.of(key);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_VALUE)
    public Builder setValue(String value) {
      this.value = OptionalValue.of(value);
      return this;
    }

    public SipCallHeader build() {
      return new SipCallHeaderImpl(key, value);
    }
  }
}
