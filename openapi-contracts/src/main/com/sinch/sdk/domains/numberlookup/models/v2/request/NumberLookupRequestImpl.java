package com.sinch.sdk.domains.numberlookup.models.v2.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  NumberLookupRequestImpl.JSON_PROPERTY_NUMBER,
  NumberLookupRequestImpl.JSON_PROPERTY_FEATURES,
  NumberLookupRequestImpl.JSON_PROPERTY_RND_FEATURE_OPTIONS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class NumberLookupRequestImpl implements NumberLookupRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_NUMBER = "number";

  private OptionalValue<String> number;

  public static final String JSON_PROPERTY_FEATURES = "features";

  private OptionalValue<List<LookupFeatureType>> features;

  public static final String JSON_PROPERTY_RND_FEATURE_OPTIONS = "rndFeatureOptions";

  private OptionalValue<RndFeatureOptions> rndFeatureOptions;

  public NumberLookupRequestImpl() {}

  protected NumberLookupRequestImpl(
      OptionalValue<String> number,
      OptionalValue<List<LookupFeatureType>> features,
      OptionalValue<RndFeatureOptions> rndFeatureOptions) {
    this.number = number;
    this.features = features;
    this.rndFeatureOptions = rndFeatureOptions;
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

  @JsonIgnore
  public List<LookupFeatureType> getFeatures() {
    return features.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FEATURES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<LookupFeatureType>> features() {
    return features;
  }

  @JsonIgnore
  public RndFeatureOptions getRndFeatureOptions() {
    return rndFeatureOptions.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RND_FEATURE_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<RndFeatureOptions> rndFeatureOptions() {
    return rndFeatureOptions;
  }

  /** Return true if this NumberLookupRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NumberLookupRequestImpl numberLookupRequest = (NumberLookupRequestImpl) o;
    return Objects.equals(this.number, numberLookupRequest.number)
        && Objects.equals(this.features, numberLookupRequest.features)
        && Objects.equals(this.rndFeatureOptions, numberLookupRequest.rndFeatureOptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, features, rndFeatureOptions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NumberLookupRequestImpl {\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    features: ").append(toIndentedString(features)).append("\n");
    sb.append("    rndFeatureOptions: ").append(toIndentedString(rndFeatureOptions)).append("\n");
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
  static class Builder implements NumberLookupRequest.Builder {
    OptionalValue<String> number = OptionalValue.empty();
    OptionalValue<List<LookupFeatureType>> features = OptionalValue.empty();
    OptionalValue<RndFeatureOptions> rndFeatureOptions = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_NUMBER, required = true)
    public Builder setNumber(String number) {
      this.number = OptionalValue.of(number);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FEATURES)
    public Builder setFeatures(List<LookupFeatureType> features) {
      this.features = OptionalValue.of(features);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_RND_FEATURE_OPTIONS)
    public Builder setRndFeatureOptions(RndFeatureOptions rndFeatureOptions) {
      this.rndFeatureOptions = OptionalValue.of(rndFeatureOptions);
      return this;
    }

    public NumberLookupRequest build() {
      return new NumberLookupRequestImpl(number, features, rndFeatureOptions);
    }
  }
}
