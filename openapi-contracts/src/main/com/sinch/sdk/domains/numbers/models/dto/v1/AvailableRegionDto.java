/*
 * Numbers | Sinch
 * An API service for getting, listing and managing Sinch virtual numbers.
 *
 * The version of the OpenAPI document: 1.0.2
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.numbers.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.List;
import java.util.Objects;

/** A region for which numbers are provided. */
@JsonPropertyOrder({
  AvailableRegionDto.JSON_PROPERTY_REGION_CODE,
  AvailableRegionDto.JSON_PROPERTY_REGION_NAME,
  AvailableRegionDto.JSON_PROPERTY_TYPES
})
// @javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class AvailableRegionDto {
  public static final String JSON_PROPERTY_REGION_CODE = "regionCode";
  private String regionCode;

  public static final String JSON_PROPERTY_REGION_NAME = "regionName";
  private String regionName;

  public static final String JSON_PROPERTY_TYPES = "types";
  private List<String> types;

  public AvailableRegionDto() {}

  @JsonCreator
  public AvailableRegionDto(
      @JsonProperty(JSON_PROPERTY_REGION_CODE) String regionCode,
      @JsonProperty(JSON_PROPERTY_REGION_NAME) String regionName,
      @JsonProperty(JSON_PROPERTY_TYPES) List<String> types) {
    this();
    this.regionCode = regionCode;
    this.regionName = regionName;
    this.types = types;
  }

  /**
   * ISO 3166-1 alpha-2 region code. Examples: &#x60;US&#x60;, &#x60;GB&#x60; or &#x60;SE&#x60;.
   *
   * @return regionCode
   */
  @JsonProperty(JSON_PROPERTY_REGION_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getRegionCode() {
    return regionCode;
  }

  /**
   * Display name of the region. Examples: United States, United Kingdom or Sweden.
   *
   * @return regionName
   */
  @JsonProperty(JSON_PROPERTY_REGION_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getRegionName() {
    return regionName;
  }

  /**
   * A list of the different number types available. Examples: &#x60;MOBILE&#x60; or
   * &#x60;LOCAL&#x60;.
   *
   * @return types
   */
  @JsonProperty(JSON_PROPERTY_TYPES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<String> getTypes() {
    return types;
  }

  /** Return true if this AvailableRegion object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AvailableRegionDto availableRegion = (AvailableRegionDto) o;
    return Objects.equals(this.regionCode, availableRegion.regionCode)
        && Objects.equals(this.regionName, availableRegion.regionName)
        && Objects.equals(this.types, availableRegion.types);
  }

  @Override
  public int hashCode() {
    return Objects.hash(regionCode, regionName, types);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AvailableRegionDto {\n");
    sb.append("    regionCode: ").append(toIndentedString(regionCode)).append("\n");
    sb.append("    regionName: ").append(toIndentedString(regionName)).append("\n");
    sb.append("    types: ").append(toIndentedString(types)).append("\n");
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
