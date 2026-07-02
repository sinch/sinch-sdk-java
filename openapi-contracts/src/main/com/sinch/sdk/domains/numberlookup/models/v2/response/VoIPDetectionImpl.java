package com.sinch.sdk.domains.numberlookup.models.v2.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numberlookup.models.v2.errors.LookupError;
import java.util.Objects;

@JsonPropertyOrder({
  VoIPDetectionImpl.JSON_PROPERTY_PROBABILITY,
  VoIPDetectionImpl.JSON_PROPERTY_ERROR
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VoIPDetectionImpl implements VoIPDetection {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PROBABILITY = "probability";

  private OptionalValue<VoIPProbabilityType> probability;

  public static final String JSON_PROPERTY_ERROR = "error";

  private OptionalValue<LookupError> error;

  public VoIPDetectionImpl() {}

  protected VoIPDetectionImpl(
      OptionalValue<VoIPProbabilityType> probability, OptionalValue<LookupError> error) {
    this.probability = probability;
    this.error = error;
  }

  @JsonIgnore
  public VoIPProbabilityType getProbability() {
    return probability.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PROBABILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<VoIPProbabilityType> probability() {
    return probability;
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

  /** Return true if this VoIPDetectionResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VoIPDetectionImpl voIPDetectionResponse = (VoIPDetectionImpl) o;
    return Objects.equals(this.probability, voIPDetectionResponse.probability)
        && Objects.equals(this.error, voIPDetectionResponse.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(probability, error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VoIPDetectionImpl {\n");
    sb.append("    probability: ").append(toIndentedString(probability)).append("\n");
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
  static class Builder implements VoIPDetection.Builder {
    OptionalValue<VoIPProbabilityType> probability = OptionalValue.empty();
    OptionalValue<LookupError> error = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_PROBABILITY)
    public Builder setProbability(VoIPProbabilityType probability) {
      this.probability = OptionalValue.of(probability);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ERROR)
    public Builder setError(LookupError error) {
      this.error = OptionalValue.of(error);
      return this;
    }

    public VoIPDetection build() {
      return new VoIPDetectionImpl(probability, error);
    }
  }
}
