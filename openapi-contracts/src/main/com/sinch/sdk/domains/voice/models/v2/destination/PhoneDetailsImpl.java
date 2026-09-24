package com.sinch.sdk.domains.voice.models.v2.destination;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({PhoneDetailsImpl.JSON_PROPERTY_NUMBER})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class PhoneDetailsImpl implements PhoneDetails {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_NUMBER = "number";

  private OptionalValue<String> number;

  public PhoneDetailsImpl() {}

  protected PhoneDetailsImpl(OptionalValue<String> number) {
    this.number = number;
  }

  @JsonIgnore
  public String getNumber() {
    return number.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NUMBER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> number() {
    return number;
  }

  /** Return true if this PhoneDetails object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PhoneDetailsImpl phoneDetails = (PhoneDetailsImpl) o;
    return Objects.equals(this.number, phoneDetails.number);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PhoneDetailsImpl {\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
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
  static class Builder implements PhoneDetails.Builder {
    OptionalValue<String> number = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_NUMBER, required = true)
    public Builder setNumber(String number) {
      this.number = OptionalValue.of(number);
      return this;
    }

    public PhoneDetails build() {
      return new PhoneDetailsImpl(number);
    }
  }
}
