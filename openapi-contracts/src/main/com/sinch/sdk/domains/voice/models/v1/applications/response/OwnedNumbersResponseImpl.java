package com.sinch.sdk.domains.voice.models.v1.applications.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({OwnedNumbersResponseImpl.JSON_PROPERTY_NUMBERS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OwnedNumbersResponseImpl implements OwnedNumbersResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_NUMBERS = "numbers";

  private OptionalValue<List<OwnedNumberInformation>> numbers;

  public OwnedNumbersResponseImpl() {}

  protected OwnedNumbersResponseImpl(OptionalValue<List<OwnedNumberInformation>> numbers) {
    this.numbers = numbers;
  }

  @JsonIgnore
  public List<OwnedNumberInformation> getNumbers() {
    return numbers.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NUMBERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<OwnedNumberInformation>> numbers() {
    return numbers;
  }

  /** Return true if this getNumbersResponseObj object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OwnedNumbersResponseImpl getNumbersResponseObj = (OwnedNumbersResponseImpl) o;
    return Objects.equals(this.numbers, getNumbersResponseObj.numbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numbers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OwnedNumbersResponseImpl {\n");
    sb.append("    numbers: ").append(toIndentedString(numbers)).append("\n");
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
  static class Builder implements OwnedNumbersResponse.Builder {
    OptionalValue<List<OwnedNumberInformation>> numbers = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_NUMBERS)
    public Builder setNumbers(List<OwnedNumberInformation> numbers) {
      this.numbers = OptionalValue.of(numbers);
      return this;
    }

    public OwnedNumbersResponse build() {
      return new OwnedNumbersResponseImpl(numbers);
    }
  }
}
