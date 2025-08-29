package com.sinch.sdk.domains.verification.models.v1.start.request.internal;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.v1.WhatsAppCodeType;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({VerificationStartWhatsAppOptionsImpl.JSON_PROPERTY_CODE_TYPE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationStartWhatsAppOptionsImpl implements VerificationStartWhatsAppOptions {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CODE_TYPE = "codeType";

  private OptionalValue<WhatsAppCodeType> codeType;

  /**
   * A container for additional, undeclared properties. This is a holder for any undeclared
   * properties as specified with the 'additionalProperties' keyword in the OAS document.
   */
  private OptionalValue<Map<String, Object>> additionalProperties;

  public VerificationStartWhatsAppOptionsImpl() {}

  protected VerificationStartWhatsAppOptionsImpl(
      OptionalValue<WhatsAppCodeType> codeType,
      OptionalValue<Map<String, Object>> additionalProperties) {
    this.codeType = codeType;
    this.additionalProperties = additionalProperties;
  }

  @JsonIgnore
  public WhatsAppCodeType getCodeType() {
    return codeType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CODE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<WhatsAppCodeType> codeType() {
    return codeType;
  }

  @JsonIgnore
  public Object get(String key) {

    if (null == this.additionalProperties || !additionalProperties.isPresent()) {
      return null;
    }
    return this.additionalProperties.get().get(key);
  }

  @JsonAnyGetter
  public Map<String, Object> additionalProperties() {
    if (null == this.additionalProperties || !additionalProperties.isPresent()) {
      return null;
    }
    return additionalProperties.get();
  }

  /**
   * Return true if this VerificationStartRequestWhatsApp_allOf_whatsappOptions object is equal to
   * o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationStartWhatsAppOptionsImpl verificationStartRequestWhatsAppAllOfWhatsappOptions =
        (VerificationStartWhatsAppOptionsImpl) o;
    return Objects.equals(
            this.codeType, verificationStartRequestWhatsAppAllOfWhatsappOptions.codeType)
        && Objects.equals(
            this.additionalProperties,
            verificationStartRequestWhatsAppAllOfWhatsappOptions.additionalProperties)
        && super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codeType, super.hashCode(), additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationStartWhatsAppOptionsImpl {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    codeType: ").append(toIndentedString(codeType)).append("\n");
    sb.append("    additionalProperties: ")
        .append(toIndentedString(additionalProperties))
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

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements VerificationStartWhatsAppOptions.Builder {
    OptionalValue<WhatsAppCodeType> codeType = OptionalValue.empty();
    OptionalValue<Map<String, Object>> additionalProperties = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CODE_TYPE)
    public Builder setCodeType(WhatsAppCodeType codeType) {
      this.codeType = OptionalValue.of(codeType);
      return this;
    }

    @JsonAnySetter
    public Builder put(String key, Object value) {
      if (!this.additionalProperties.isPresent()) {
        this.additionalProperties = OptionalValue.of(new HashMap<String, Object>());
      }
      this.additionalProperties.get().put(key, value);
      return this;
    }

    public VerificationStartWhatsAppOptions build() {
      return new VerificationStartWhatsAppOptionsImpl(codeType, additionalProperties);
    }
  }
}
