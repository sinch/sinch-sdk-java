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

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/**
 * Search pattern to apply. Options include, &#x60;START&#x60;, &#x60;CONTAIN&#x60;, and
 * &#x60;END&#x60;.
 */
@JsonPropertyOrder({NumberPatternSearchPatternDto.JSON_PROPERTY_NUMBER_PATTERN_SEARCH_PATTERN})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class NumberPatternSearchPatternDto {
  public static final String JSON_PROPERTY_NUMBER_PATTERN_SEARCH_PATTERN =
      "NumberPatternSearchPattern";
  private String numberPatternSearchPattern;
  private boolean numberPatternSearchPatternDefined = false;

  public NumberPatternSearchPatternDto() {}

  public NumberPatternSearchPatternDto numberPatternSearchPattern(
      String numberPatternSearchPattern) {
    this.numberPatternSearchPattern = numberPatternSearchPattern;
    this.numberPatternSearchPatternDefined = true;
    return this;
  }

  /**
   * The pattern to apply to searches. Options include, &#x60;START&#x60;, &#x60;CONTAIN&#x60;, and
   * &#x60;END&#x60;.
   *
   * @return numberPatternSearchPattern
   */
  @JsonProperty(JSON_PROPERTY_NUMBER_PATTERN_SEARCH_PATTERN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getNumberPatternSearchPattern() {
    return numberPatternSearchPattern;
  }

  @JsonIgnore
  public boolean getNumberPatternSearchPatternDefined() {
    return numberPatternSearchPatternDefined;
  }

  @JsonProperty(JSON_PROPERTY_NUMBER_PATTERN_SEARCH_PATTERN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNumberPatternSearchPattern(String numberPatternSearchPattern) {
    this.numberPatternSearchPattern = numberPatternSearchPattern;
    this.numberPatternSearchPatternDefined = true;
  }

  /** Return true if this numberPattern.searchPattern object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NumberPatternSearchPatternDto numberPatternSearchPattern = (NumberPatternSearchPatternDto) o;
    return Objects.equals(
        this.numberPatternSearchPattern, numberPatternSearchPattern.numberPatternSearchPattern);
  }

  @Override
  public int hashCode() {
    return Objects.hash(numberPatternSearchPattern);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NumberPatternSearchPatternDto {\n");
    sb.append("    numberPatternSearchPattern: ")
        .append(toIndentedString(numberPatternSearchPattern))
        .append("\n");
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
