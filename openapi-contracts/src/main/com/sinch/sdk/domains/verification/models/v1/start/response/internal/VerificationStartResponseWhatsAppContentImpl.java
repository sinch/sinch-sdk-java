package com.sinch.sdk.domains.verification.models.v1.start.response.internal;

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

@JsonPropertyOrder({VerificationStartResponseWhatsAppContentImpl.JSON_PROPERTY_CODE_TYPE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationStartResponseWhatsAppContentImpl
    implements VerificationStartResponseWhatsAppContent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CODE_TYPE = "codeType";

  private OptionalValue<WhatsAppCodeType> codeType;

  /**
   * A container for additional, undeclared properties. This is a holder for any undeclared
   * properties as specified with the 'additionalProperties' keyword in the OAS document.
   */
  private OptionalValue<Map<String, Object>> additionalProperties;

  public VerificationStartResponseWhatsAppContentImpl() {}

  protected VerificationStartResponseWhatsAppContentImpl(
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

  /** Return true if this VerificationStartResponseWhatsApp_allOf_whatsapp object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationStartResponseWhatsAppContentImpl verificationStartResponseWhatsAppAllOfWhatsapp =
        (VerificationStartResponseWhatsAppContentImpl) o;
    return Objects.equals(this.codeType, verificationStartResponseWhatsAppAllOfWhatsapp.codeType)
        && Objects.equals(
            this.additionalProperties,
            verificationStartResponseWhatsAppAllOfWhatsapp.additionalProperties)
        && super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codeType, super.hashCode(), additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationStartResponseWhatsAppContentImpl {\n");
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
  static class Builder implements VerificationStartResponseWhatsAppContent.Builder {
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

    public VerificationStartResponseWhatsAppContent build() {
      return new VerificationStartResponseWhatsAppContentImpl(codeType, additionalProperties);
    }
  }
}
