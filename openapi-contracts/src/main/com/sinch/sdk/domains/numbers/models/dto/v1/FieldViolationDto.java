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

/** FieldViolationDto */
@JsonPropertyOrder({
  FieldViolationDto.JSON_PROPERTY_FIELD,
  FieldViolationDto.JSON_PROPERTY_DESCRIPTION
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class FieldViolationDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_FIELD = "field";
  private String field;
  private boolean fieldDefined = false;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";
  private String description;
  private boolean descriptionDefined = false;

  public FieldViolationDto() {}

  public FieldViolationDto field(String field) {
    this.field = field;
    this.fieldDefined = true;
    return this;
  }

  /**
   * Get field
   *
   * @return field
   */
  @JsonProperty(JSON_PROPERTY_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getField() {
    return field;
  }

  @JsonIgnore
  public boolean getFieldDefined() {
    return fieldDefined;
  }

  @JsonProperty(JSON_PROPERTY_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setField(String field) {
    this.field = field;
    this.fieldDefined = true;
  }

  public FieldViolationDto description(String description) {
    this.description = description;
    this.descriptionDefined = true;
    return this;
  }

  /**
   * Get description
   *
   * @return description
   */
  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getDescription() {
    return description;
  }

  @JsonIgnore
  public boolean getDescriptionDefined() {
    return descriptionDefined;
  }

  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDescription(String description) {
    this.description = description;
    this.descriptionDefined = true;
  }

  /** Return true if this FieldViolation object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FieldViolationDto fieldViolation = (FieldViolationDto) o;
    return Objects.equals(this.field, fieldViolation.field)
        && Objects.equals(this.description, fieldViolation.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(field, description);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FieldViolationDto {\n");
    sb.append("    field: ").append(toIndentedString(field)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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
