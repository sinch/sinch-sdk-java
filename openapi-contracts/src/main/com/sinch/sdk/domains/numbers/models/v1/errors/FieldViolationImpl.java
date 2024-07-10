package com.sinch.sdk.domains.numbers.models.v1.errors;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  FieldViolationImpl.JSON_PROPERTY_FIELD,
  FieldViolationImpl.JSON_PROPERTY_DESCRIPTION
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class FieldViolationImpl implements FieldViolation {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_FIELD = "field";

  private OptionalValue<String> field;

  public static final String JSON_PROPERTY_DESCRIPTION = "description";

  private OptionalValue<String> description;

  public FieldViolationImpl() {}

  protected FieldViolationImpl(OptionalValue<String> field, OptionalValue<String> description) {
    this.field = field;
    this.description = description;
  }

  @JsonIgnore
  public String getField() {
    return field.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FIELD)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> field() {
    return field;
  }

  @JsonIgnore
  public String getDescription() {
    return description.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> description() {
    return description;
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
    FieldViolationImpl fieldViolation = (FieldViolationImpl) o;
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
    sb.append("class FieldViolationImpl {\n");
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

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements FieldViolation.Builder {
    OptionalValue<String> field = OptionalValue.empty();
    OptionalValue<String> description = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_FIELD)
    public Builder setField(String field) {
      this.field = OptionalValue.of(field);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DESCRIPTION)
    public Builder setDescription(String description) {
      this.description = OptionalValue.of(description);
      return this;
    }

    public FieldViolation build() {
      return new FieldViolationImpl(field, description);
    }
  }
}
