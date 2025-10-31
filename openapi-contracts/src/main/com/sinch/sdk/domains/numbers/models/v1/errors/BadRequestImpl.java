package com.sinch.sdk.domains.numbers.models.v1.errors;

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
  BadRequestImpl.JSON_PROPERTY_TYPE,
  BadRequestImpl.JSON_PROPERTY_FIELD_VIOLATIONS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class BadRequestImpl implements BadRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_FIELD_VIOLATIONS = "fieldViolations";

  private OptionalValue<List<FieldViolation>> fieldViolations;

  public BadRequestImpl() {}

  protected BadRequestImpl(
      OptionalValue<TypeEnum> type, OptionalValue<List<FieldViolation>> fieldViolations) {
    this.type = type;
    this.fieldViolations = fieldViolations;
  }

  @JsonIgnore
  public TypeEnum getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<TypeEnum> type() {
    return type;
  }

  @JsonIgnore
  public List<FieldViolation> getFieldViolations() {
    return fieldViolations.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FIELD_VIOLATIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<FieldViolation>> fieldViolations() {
    return fieldViolations;
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
    BadRequestImpl badRequest = (BadRequestImpl) o;
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
    sb.append("class BadRequestImpl {\n");
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

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements BadRequest.Builder {
    OptionalValue<TypeEnum> type = OptionalValue.of(TypeEnum.BAD_REQUEST);
    OptionalValue<List<FieldViolation>> fieldViolations = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TYPE)
    Builder setType(TypeEnum type) {
      if (!Objects.equals(type, TypeEnum.BAD_REQUEST)) {
        throw new IllegalArgumentException(
            String.format("'type' must be '%s' (is '%s')", TypeEnum.BAD_REQUEST, type));
      }
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FIELD_VIOLATIONS)
    public Builder setFieldViolations(List<FieldViolation> fieldViolations) {
      this.fieldViolations = OptionalValue.of(fieldViolations);
      return this;
    }

    public BadRequest build() {
      return new BadRequestImpl(type, fieldViolations);
    }
  }
}
