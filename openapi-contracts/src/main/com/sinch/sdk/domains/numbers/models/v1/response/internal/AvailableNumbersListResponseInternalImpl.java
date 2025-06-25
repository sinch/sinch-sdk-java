package com.sinch.sdk.domains.numbers.models.v1.response.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.v1.response.AvailableNumber;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({AvailableNumbersListResponseInternalImpl.JSON_PROPERTY_AVAILABLE_NUMBERS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class AvailableNumbersListResponseInternalImpl
    implements AvailableNumbersListResponseInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_AVAILABLE_NUMBERS = "availableNumbers";

  private OptionalValue<List<AvailableNumber>> availableNumbers;

  public AvailableNumbersListResponseInternalImpl() {}

  protected AvailableNumbersListResponseInternalImpl(
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

  /** Return true if this ListAvailableNumbersResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AvailableNumbersListResponseInternalImpl listAvailableNumbersResponse =
        (AvailableNumbersListResponseInternalImpl) o;
    return Objects.equals(this.availableNumbers, listAvailableNumbersResponse.availableNumbers);
  }

  @Override
  public int hashCode() {
    return Objects.hash(availableNumbers);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AvailableNumbersListResponseInternalImpl {\n");
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
  static class Builder implements AvailableNumbersListResponseInternal.Builder {
    OptionalValue<List<AvailableNumber>> availableNumbers = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_AVAILABLE_NUMBERS)
    public Builder setAvailableNumbers(List<AvailableNumber> availableNumbers) {
      this.availableNumbers = OptionalValue.of(availableNumbers);
      return this;
    }

    public AvailableNumbersListResponseInternal build() {
      return new AvailableNumbersListResponseInternalImpl(availableNumbers);
    }
  }
}
