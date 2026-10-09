package com.sinch.sdk.domains.voice.models.v2.svaml.response;

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
  ValidateSvamlResponseImpl.JSON_PROPERTY_IS_VALID,
  ValidateSvamlResponseImpl.JSON_PROPERTY_ERRORS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ValidateSvamlResponseImpl implements ValidateSvamlResponse {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_IS_VALID = "isValid";

  private OptionalValue<Boolean> isValid;

  public static final String JSON_PROPERTY_ERRORS = "errors";

  private OptionalValue<List<String>> errors;

  public ValidateSvamlResponseImpl() {}

  protected ValidateSvamlResponseImpl(
      OptionalValue<Boolean> isValid, OptionalValue<List<String>> errors) {
    this.isValid = isValid;
    this.errors = errors;
  }

  @JsonIgnore
  public Boolean getIsValid() {
    return isValid.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IS_VALID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Boolean> isValid() {
    return isValid;
  }

  @JsonIgnore
  public List<String> getErrors() {
    return errors.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ERRORS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<String>> errors() {
    return errors;
  }

  /** Return true if this ValidateSvamlResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValidateSvamlResponseImpl validateSvamlResponse = (ValidateSvamlResponseImpl) o;
    return Objects.equals(this.isValid, validateSvamlResponse.isValid)
        && Objects.equals(this.errors, validateSvamlResponse.errors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(isValid, errors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidateSvamlResponseImpl {\n");
    sb.append("    isValid: ").append(toIndentedString(isValid)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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
  static class Builder implements ValidateSvamlResponse.Builder {
    OptionalValue<Boolean> isValid = OptionalValue.empty();
    OptionalValue<List<String>> errors = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_IS_VALID, required = true)
    public Builder setIsValid(Boolean isValid) {
      this.isValid = OptionalValue.of(isValid);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ERRORS)
    public Builder setErrors(List<String> errors) {
      this.errors = OptionalValue.of(errors);
      return this;
    }

    public ValidateSvamlResponse build() {
      return new ValidateSvamlResponseImpl(isValid, errors);
    }
  }
}
