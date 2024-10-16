package com.sinch.sdk.domains.voice.models.v1.applications.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v1.Price;
import java.util.Objects;

@JsonPropertyOrder({
  QueryNumberInformationImpl.JSON_PROPERTY_COUNTRY_ID,
  QueryNumberInformationImpl.JSON_PROPERTY_NUMBER_TYPE,
  QueryNumberInformationImpl.JSON_PROPERTY_NORMALIZED_NUMBER,
  QueryNumberInformationImpl.JSON_PROPERTY_RESTRICTED,
  QueryNumberInformationImpl.JSON_PROPERTY_RATE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class QueryNumberInformationImpl implements QueryNumberInformation {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_COUNTRY_ID = "countryId";

  private OptionalValue<String> countryId;

  public static final String JSON_PROPERTY_NUMBER_TYPE = "numberType";

  private OptionalValue<NumberTypeEnum> numberType;

  public static final String JSON_PROPERTY_NORMALIZED_NUMBER = "normalizedNumber";

  private OptionalValue<String> normalizedNumber;

  public static final String JSON_PROPERTY_RESTRICTED = "restricted";

  private OptionalValue<Boolean> restricted;

  public static final String JSON_PROPERTY_RATE = "rate";

  private OptionalValue<Price> rate;

  public QueryNumberInformationImpl() {}

  protected QueryNumberInformationImpl(
      OptionalValue<String> countryId,
      OptionalValue<NumberTypeEnum> numberType,
      OptionalValue<String> normalizedNumber,
      OptionalValue<Boolean> restricted,
      OptionalValue<Price> rate) {
    this.countryId = countryId;
    this.numberType = numberType;
    this.normalizedNumber = normalizedNumber;
    this.restricted = restricted;
    this.rate = rate;
  }

  @JsonIgnore
  public String getCountryId() {
    return countryId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_COUNTRY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> countryId() {
    return countryId;
  }

  @JsonIgnore
  public NumberTypeEnum getNumberType() {
    return numberType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NUMBER_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<NumberTypeEnum> numberType() {
    return numberType;
  }

  @JsonIgnore
  public String getNormalizedNumber() {
    return normalizedNumber.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NORMALIZED_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> normalizedNumber() {
    return normalizedNumber;
  }

  @JsonIgnore
  public Boolean getRestricted() {
    return restricted.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RESTRICTED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Boolean> restricted() {
    return restricted;
  }

  @JsonIgnore
  public Price getRate() {
    return rate.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Price> rate() {
    return rate;
  }

  /** Return true if this getQueryNumber_number object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    QueryNumberInformationImpl getQueryNumberNumber = (QueryNumberInformationImpl) o;
    return Objects.equals(this.countryId, getQueryNumberNumber.countryId)
        && Objects.equals(this.numberType, getQueryNumberNumber.numberType)
        && Objects.equals(this.normalizedNumber, getQueryNumberNumber.normalizedNumber)
        && Objects.equals(this.restricted, getQueryNumberNumber.restricted)
        && Objects.equals(this.rate, getQueryNumberNumber.rate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(countryId, numberType, normalizedNumber, restricted, rate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class QueryNumberInformationImpl {\n");
    sb.append("    countryId: ").append(toIndentedString(countryId)).append("\n");
    sb.append("    numberType: ").append(toIndentedString(numberType)).append("\n");
    sb.append("    normalizedNumber: ").append(toIndentedString(normalizedNumber)).append("\n");
    sb.append("    restricted: ").append(toIndentedString(restricted)).append("\n");
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
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
  static class Builder implements QueryNumberInformation.Builder {
    OptionalValue<String> countryId = OptionalValue.empty();
    OptionalValue<NumberTypeEnum> numberType = OptionalValue.empty();
    OptionalValue<String> normalizedNumber = OptionalValue.empty();
    OptionalValue<Boolean> restricted = OptionalValue.empty();
    OptionalValue<Price> rate = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_COUNTRY_ID)
    public Builder setCountryId(String countryId) {
      this.countryId = OptionalValue.of(countryId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_NUMBER_TYPE)
    public Builder setNumberType(NumberTypeEnum numberType) {
      this.numberType = OptionalValue.of(numberType);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_NORMALIZED_NUMBER)
    public Builder setNormalizedNumber(String normalizedNumber) {
      this.normalizedNumber = OptionalValue.of(normalizedNumber);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_RESTRICTED)
    public Builder setRestricted(Boolean restricted) {
      this.restricted = OptionalValue.of(restricted);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_RATE)
    public Builder setRate(Price rate) {
      this.rate = OptionalValue.of(rate);
      return this;
    }

    public QueryNumberInformation build() {
      return new QueryNumberInformationImpl(
          countryId, numberType, normalizedNumber, restricted, rate);
    }
  }
}
