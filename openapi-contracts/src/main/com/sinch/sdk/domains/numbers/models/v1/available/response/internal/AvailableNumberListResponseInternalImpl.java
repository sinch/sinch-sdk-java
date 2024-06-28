package com.sinch.sdk.domains.numbers.models.v1.available.response.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.v1.available.response.AvailableNumber;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({AvailableNumberListResponseInternalImpl.JSON_PROPERTY_AVAILABLE_NUMBERS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AvailableNumberListResponseInternalImpl
    implements AvailableNumberListResponseInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_AVAILABLE_NUMBERS = "availableNumbers";

  private OptionalValue<List<AvailableNumber>> availableNumbers;

  public AvailableNumberListResponseInternalImpl() {}

  protected AvailableNumberListResponseInternalImpl(
      OptionalValue<List<AvailableNumber>> availableNumbers) {
    this.availableNumbers = availableNumbers;
  }

  @JsonIgnore
  public List<AvailableNumber> getAvailableNumbers() {
    return availableNumbers.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_AVAILABLE_NUMBERS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<AvailableNumber>> availableNumbers() {
    return availableNumbers;
  }

  /** Return true if this AvailableNumbersResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AvailableNumberListResponseInternalImpl availableNumbersResponse =
        (AvailableNumberListResponseInternalImpl) o;
    return Objects.equals(this.availableNumbers, availableNumbersResponse.availableNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(availableNumbers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AvailableNumberListResponseInternalImpl {\n");
    sb.append("    availableNumbers: ").append(toIndentedString(availableNumbers)).append("\n");
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
  static class Builder implements AvailableNumberListResponseInternal.Builder {
    OptionalValue<List<AvailableNumber>> availableNumbers = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_AVAILABLE_NUMBERS)
    public Builder setAvailableNumbers(List<AvailableNumber> availableNumbers) {
      this.availableNumbers = OptionalValue.of(availableNumbers);
      return this;
    }

    public AvailableNumberListResponseInternal build() {
      return new AvailableNumberListResponseInternalImpl(availableNumbers);
    }
  }
}
