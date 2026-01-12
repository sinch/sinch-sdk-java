package com.sinch.sdk.domains.numbers.models.v1.numberorder.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import java.util.Objects;

@JsonPropertyOrder({
  LookupNumberRequirementsRequestImpl.JSON_PROPERTY_REGION_CODE,
  LookupNumberRequirementsRequestImpl.JSON_PROPERTY_NUMBER_TYPE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class LookupNumberRequirementsRequestImpl implements LookupNumberRequirementsRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_REGION_CODE = "regionCode";

  private OptionalValue<String> regionCode;

  public static final String JSON_PROPERTY_NUMBER_TYPE = "numberType";

  private OptionalValue<NumberType> numberType;

  public LookupNumberRequirementsRequestImpl() {}

  protected LookupNumberRequirementsRequestImpl(
      OptionalValue<String> regionCode, OptionalValue<NumberType> numberType) {
    this.regionCode = regionCode;
    this.numberType = numberType;
  }

  @JsonIgnore
  public String getRegionCode() {
    return regionCode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REGION_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> regionCode() {
    return regionCode;
  }

  @JsonIgnore
  public NumberType getNumberType() {
    return numberType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NUMBER_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<NumberType> numberType() {
    return numberType;
  }

  /** Return true if this LookupNumberRequirementsRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LookupNumberRequirementsRequestImpl lookupNumberRequirementsRequest =
        (LookupNumberRequirementsRequestImpl) o;
    return Objects.equals(this.regionCode, lookupNumberRequirementsRequest.regionCode)
        && Objects.equals(this.numberType, lookupNumberRequirementsRequest.numberType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(regionCode, numberType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LookupNumberRequirementsRequestImpl {\n");
    sb.append("    regionCode: ").append(toIndentedString(regionCode)).append("\n");
    sb.append("    numberType: ").append(toIndentedString(numberType)).append("\n");
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
  static class Builder implements LookupNumberRequirementsRequest.Builder {
    OptionalValue<String> regionCode = OptionalValue.empty();
    OptionalValue<NumberType> numberType = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_REGION_CODE)
    public Builder setRegionCode(String regionCode) {
      this.regionCode = OptionalValue.of(regionCode);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_NUMBER_TYPE)
    public Builder setNumberType(NumberType numberType) {
      this.numberType = OptionalValue.of(numberType);
      return this;
    }

    public LookupNumberRequirementsRequest build() {
      return new LookupNumberRequirementsRequestImpl(regionCode, numberType);
    }
  }
}
