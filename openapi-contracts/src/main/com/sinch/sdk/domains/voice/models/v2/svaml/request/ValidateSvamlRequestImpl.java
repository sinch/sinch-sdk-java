package com.sinch.sdk.domains.voice.models.v2.svaml.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlInput;
import java.util.Objects;

@JsonPropertyOrder({
  ValidateSvamlRequestImpl.JSON_PROPERTY_SVAML,
  ValidateSvamlRequestImpl.JSON_PROPERTY_VALIDATION_TYPE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ValidateSvamlRequestImpl implements ValidateSvamlRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_SVAML = "svaml";

  private OptionalValue<SvamlInput> svaml;

  public static final String JSON_PROPERTY_VALIDATION_TYPE = "validationType";

  private OptionalValue<ValidationTypeEnum> validationType;

  public ValidateSvamlRequestImpl() {}

  protected ValidateSvamlRequestImpl(
      OptionalValue<SvamlInput> svaml, OptionalValue<ValidationTypeEnum> validationType) {
    this.svaml = svaml;
    this.validationType = validationType;
  }

  @JsonIgnore
  public SvamlInput getSvaml() {
    return svaml.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SVAML)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<SvamlInput> svaml() {
    return svaml;
  }

  @JsonIgnore
  public ValidationTypeEnum getValidationType() {
    return validationType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_VALIDATION_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ValidationTypeEnum> validationType() {
    return validationType;
  }

  /** Return true if this ValidateSvamlRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ValidateSvamlRequestImpl validateSvamlRequest = (ValidateSvamlRequestImpl) o;
    return Objects.equals(this.svaml, validateSvamlRequest.svaml)
        && Objects.equals(this.validationType, validateSvamlRequest.validationType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(svaml, validationType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ValidateSvamlRequestImpl {\n");
    sb.append("    svaml: ").append(toIndentedString(svaml)).append("\n");
    sb.append("    validationType: ").append(toIndentedString(validationType)).append("\n");
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
  static class Builder implements ValidateSvamlRequest.Builder {
    OptionalValue<SvamlInput> svaml = OptionalValue.empty();
    OptionalValue<ValidationTypeEnum> validationType = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_SVAML, required = true)
    public Builder setSvaml(SvamlInput svaml) {
      this.svaml = OptionalValue.of(svaml);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_VALIDATION_TYPE)
    public Builder setValidationType(ValidationTypeEnum validationType) {
      this.validationType = OptionalValue.of(validationType);
      return this;
    }

    public ValidateSvamlRequest build() {
      return new ValidateSvamlRequestImpl(svaml, validationType);
    }
  }
}
