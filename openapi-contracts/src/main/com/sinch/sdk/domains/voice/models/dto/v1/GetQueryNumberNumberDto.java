/*
 * Voice API | Sinch
 * The Voice API exposes calling- and conference-related functionality in the Sinch Voice Platform.
 *
 * The version of the OpenAPI document: 1.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.voice.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/** The number item object. */
@JsonPropertyOrder({
  GetQueryNumberNumberDto.JSON_PROPERTY_COUNTRY_ID,
  GetQueryNumberNumberDto.JSON_PROPERTY_NUMBER_TYPE,
  GetQueryNumberNumberDto.JSON_PROPERTY_NORMALIZED_NUMBER,
  GetQueryNumberNumberDto.JSON_PROPERTY_RESTRICTED,
  GetQueryNumberNumberDto.JSON_PROPERTY_RATE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class GetQueryNumberNumberDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_COUNTRY_ID = "countryId";
  private String countryId;
  private boolean countryIdDefined = false;

  /** The type of the number. */
  public enum NumberTypeEnum {
    UNKNOWN("Unknown"),

    FIXED("Fixed"),

    MOBILE("Mobile"),

    OTHER("Other"),

    UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

    private String value;

    NumberTypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static NumberTypeEnum fromValue(String value) {
      for (NumberTypeEnum b : NumberTypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return UNKNOWN_DEFAULT_OPEN_API;
    }
  }

  public static final String JSON_PROPERTY_NUMBER_TYPE = "numberType";
  private String numberType;
  private boolean numberTypeDefined = false;

  public static final String JSON_PROPERTY_NORMALIZED_NUMBER = "normalizedNumber";
  private String normalizedNumber;
  private boolean normalizedNumberDefined = false;

  public static final String JSON_PROPERTY_RESTRICTED = "restricted";
  private Boolean restricted;
  private boolean restrictedDefined = false;

  public static final String JSON_PROPERTY_RATE = "rate";
  private PriceDto rate;
  private boolean rateDefined = false;

  public GetQueryNumberNumberDto() {}

  public GetQueryNumberNumberDto countryId(String countryId) {
    this.countryId = countryId;
    this.countryIdDefined = true;
    return this;
  }

  /**
   * The ISO 3166-1 formatted country code.
   *
   * @return countryId
   */
  @JsonProperty(JSON_PROPERTY_COUNTRY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCountryId() {
    return countryId;
  }

  @JsonIgnore
  public boolean getCountryIdDefined() {
    return countryIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_COUNTRY_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCountryId(String countryId) {
    this.countryId = countryId;
    this.countryIdDefined = true;
  }

  public GetQueryNumberNumberDto numberType(String numberType) {
    this.numberType = numberType;
    this.numberTypeDefined = true;
    return this;
  }

  /**
   * The type of the number.
   *
   * @return numberType
   */
  @JsonProperty(JSON_PROPERTY_NUMBER_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getNumberType() {
    return numberType;
  }

  @JsonIgnore
  public boolean getNumberTypeDefined() {
    return numberTypeDefined;
  }

  @JsonProperty(JSON_PROPERTY_NUMBER_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNumberType(String numberType) {
    this.numberType = numberType;
    this.numberTypeDefined = true;
  }

  public GetQueryNumberNumberDto normalizedNumber(String normalizedNumber) {
    this.normalizedNumber = normalizedNumber;
    this.normalizedNumberDefined = true;
    return this;
  }

  /**
   * The number in E.164 format.
   *
   * @return normalizedNumber
   */
  @JsonProperty(JSON_PROPERTY_NORMALIZED_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getNormalizedNumber() {
    return normalizedNumber;
  }

  @JsonIgnore
  public boolean getNormalizedNumberDefined() {
    return normalizedNumberDefined;
  }

  @JsonProperty(JSON_PROPERTY_NORMALIZED_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNormalizedNumber(String normalizedNumber) {
    this.normalizedNumber = normalizedNumber;
    this.normalizedNumberDefined = true;
  }

  public GetQueryNumberNumberDto restricted(Boolean restricted) {
    this.restricted = restricted;
    this.restrictedDefined = true;
    return this;
  }

  /**
   * Concerns whether the call is restricted or not.
   *
   * @return restricted
   */
  @JsonProperty(JSON_PROPERTY_RESTRICTED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Boolean getRestricted() {
    return restricted;
  }

  @JsonIgnore
  public boolean getRestrictedDefined() {
    return restrictedDefined;
  }

  @JsonProperty(JSON_PROPERTY_RESTRICTED)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRestricted(Boolean restricted) {
    this.restricted = restricted;
    this.restrictedDefined = true;
  }

  public GetQueryNumberNumberDto rate(PriceDto rate) {
    this.rate = rate;
    this.rateDefined = true;
    return this;
  }

  /**
   * Get rate
   *
   * @return rate
   */
  @JsonProperty(JSON_PROPERTY_RATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public PriceDto getRate() {
    return rate;
  }

  @JsonIgnore
  public boolean getRateDefined() {
    return rateDefined;
  }

  @JsonProperty(JSON_PROPERTY_RATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setRate(PriceDto rate) {
    this.rate = rate;
    this.rateDefined = true;
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
    GetQueryNumberNumberDto getQueryNumberNumber = (GetQueryNumberNumberDto) o;
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
    sb.append("class GetQueryNumberNumberDto {\n");
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
}
