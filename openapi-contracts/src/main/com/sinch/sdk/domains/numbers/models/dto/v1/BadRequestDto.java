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
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/** BadRequestDto */
@JsonPropertyOrder({BadRequestDto.JSON_PROPERTY_TYPE, BadRequestDto.JSON_PROPERTY_FIELD_VIOLATIONS})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class BadRequestDto {
  private static final long serialVersionUID = 1L;

  /** Gets or Sets type */
  public enum TypeEnum {
    BADREQUEST("BadRequest"),

    UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

    private String value;

    TypeEnum(String value) {
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
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return UNKNOWN_DEFAULT_OPEN_API;
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;
  private boolean typeDefined = false;

  public static final String JSON_PROPERTY_FIELD_VIOLATIONS = "fieldViolations";
  private List<FieldViolationDto> fieldViolations;
  private boolean fieldViolationsDefined = false;

  public BadRequestDto() {}

  public BadRequestDto type(String type) {
    this.type = type;
    this.typeDefined = true;
    return this;
  }

  /**
   * Get type
   *
   * @return type
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getType() {
    return type;
  }

  @JsonIgnore
  public boolean getTypeDefined() {
    return typeDefined;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setType(String type) {
    this.type = type;
    this.typeDefined = true;
  }

  public BadRequestDto fieldViolations(List<FieldViolationDto> fieldViolations) {
    this.fieldViolations = fieldViolations;
    this.fieldViolationsDefined = true;
    return this;
  }

  public BadRequestDto addFieldViolationsItem(FieldViolationDto fieldViolationsItem) {
    if (this.fieldViolations == null) {
      this.fieldViolations = new ArrayList<>();
    }
    this.fieldViolationsDefined = true;
    this.fieldViolations.add(fieldViolationsItem);
    return this;
  }

  /**
   * Get fieldViolations
   *
   * @return fieldViolations
   */
  @JsonProperty(JSON_PROPERTY_FIELD_VIOLATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<FieldViolationDto> getFieldViolations() {
    return fieldViolations;
  }

  @JsonIgnore
  public boolean getFieldViolationsDefined() {
    return fieldViolationsDefined;
  }

  @JsonProperty(JSON_PROPERTY_FIELD_VIOLATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setFieldViolations(List<FieldViolationDto> fieldViolations) {
    this.fieldViolations = fieldViolations;
    this.fieldViolationsDefined = true;
  }

  /** Return true if this BadRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    BadRequestDto badRequest = (BadRequestDto) o;
    return Objects.equals(this.type, badRequest.type)
        && Objects.equals(this.fieldViolations, badRequest.fieldViolations);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, fieldViolations);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class BadRequestDto {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    fieldViolations: ").append(toIndentedString(fieldViolations)).append("\n");
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
