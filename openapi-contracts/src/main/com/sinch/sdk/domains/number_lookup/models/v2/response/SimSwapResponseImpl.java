package com.sinch.sdk.domains.number_lookup.models.v2.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.number_lookup.models.v2.errors.LookupError;
import java.util.Objects;

@JsonPropertyOrder({
  SimSwapResponseImpl.JSON_PROPERTY_SWAPPED,
  SimSwapResponseImpl.JSON_PROPERTY_SWAP_PERIOD,
  SimSwapResponseImpl.JSON_PROPERTY_ERROR
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SimSwapResponseImpl implements SimSwapResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_SWAPPED = "swapped";

  private OptionalValue<Boolean> swapped;

  public static final String JSON_PROPERTY_SWAP_PERIOD = "swapPeriod";

  private OptionalValue<SwapPeriodType> swapPeriod;

  public static final String JSON_PROPERTY_ERROR = "error";

  private OptionalValue<LookupError> error;

  public SimSwapResponseImpl() {}

  protected SimSwapResponseImpl(
      OptionalValue<Boolean> swapped,
      OptionalValue<SwapPeriodType> swapPeriod,
      OptionalValue<LookupError> error) {
    this.swapped = swapped;
    this.swapPeriod = swapPeriod;
    this.error = error;
  }

  @JsonIgnore
  public Boolean getSwapped() {
    return swapped.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SWAPPED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> swapped() {
    return swapped;
  }

  @JsonIgnore
  public SwapPeriodType getSwapPeriod() {
    return swapPeriod.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SWAP_PERIOD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<SwapPeriodType> swapPeriod() {
    return swapPeriod;
  }

  @JsonIgnore
  public LookupError getError() {
    return error.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ERROR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<LookupError> error() {
    return error;
  }

  /** Return true if this SimSwapResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SimSwapResponseImpl simSwapResponse = (SimSwapResponseImpl) o;
    return Objects.equals(this.swapped, simSwapResponse.swapped)
        && Objects.equals(this.swapPeriod, simSwapResponse.swapPeriod)
        && Objects.equals(this.error, simSwapResponse.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(swapped, swapPeriod, error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SimSwapResponseImpl {\n");
    sb.append("    swapped: ").append(toIndentedString(swapped)).append("\n");
    sb.append("    swapPeriod: ").append(toIndentedString(swapPeriod)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
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
  static class Builder implements SimSwapResponse.Builder {
    OptionalValue<Boolean> swapped = OptionalValue.empty();
    OptionalValue<SwapPeriodType> swapPeriod = OptionalValue.empty();
    OptionalValue<LookupError> error = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_SWAPPED)
    public Builder setSwapped(Boolean swapped) {
      this.swapped = OptionalValue.of(swapped);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SWAP_PERIOD)
    public Builder setSwapPeriod(SwapPeriodType swapPeriod) {
      this.swapPeriod = OptionalValue.of(swapPeriod);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ERROR)
    public Builder setError(LookupError error) {
      this.error = OptionalValue.of(error);
      return this;
    }

    public SimSwapResponse build() {
      return new SimSwapResponseImpl(swapped, swapPeriod, error);
    }
  }
}
