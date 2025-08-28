package com.sinch.sdk.domains.verification.models.v1.webhooks.internal;

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
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({
  VerificationRequestEventResponseWhatsAppContentImpl.JSON_PROPERTY_CODE_TYPE,
  VerificationRequestEventResponseWhatsAppContentImpl.JSON_PROPERTY_ACCEPT_LANGUAGE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationRequestEventResponseWhatsAppContentImpl
    implements VerificationRequestEventResponseWhatsAppContent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CODE_TYPE = "codeType";

  private OptionalValue<WhatsAppCodeType> codeType;

  public static final String JSON_PROPERTY_ACCEPT_LANGUAGE = "acceptLanguage";

  private OptionalValue<List<String>> acceptLanguage;

  /**
   * A container for additional, undeclared properties. This is a holder for any undeclared
   * properties as specified with the 'additionalProperties' keyword in the OAS document.
   */
  private OptionalValue<Map<String, Object>> additionalProperties;

  public VerificationRequestEventResponseWhatsAppContentImpl() {}

  protected VerificationRequestEventResponseWhatsAppContentImpl(
      OptionalValue<WhatsAppCodeType> codeType,
      OptionalValue<List<String>> acceptLanguage,
      OptionalValue<Map<String, Object>> additionalProperties) {
    this.codeType = codeType;
    this.acceptLanguage = acceptLanguage;
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
  public List<String> getAcceptLanguage() {
    return acceptLanguage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ACCEPT_LANGUAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<List<String>> acceptLanguage() {
    return acceptLanguage;
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
   * Return true if this VerificationRequestEventResponseWhatsApp_allOf_whatsapp object is equal to
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
    VerificationRequestEventResponseWhatsAppContentImpl
        verificationRequestEventResponseWhatsAppAllOfWhatsapp =
            (VerificationRequestEventResponseWhatsAppContentImpl) o;
    return Objects.equals(
            this.codeType, verificationRequestEventResponseWhatsAppAllOfWhatsapp.codeType)
        && Objects.equals(
            this.acceptLanguage,
            verificationRequestEventResponseWhatsAppAllOfWhatsapp.acceptLanguage)
        && Objects.equals(
            this.additionalProperties,
            verificationRequestEventResponseWhatsAppAllOfWhatsapp.additionalProperties)
        && super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codeType, acceptLanguage, super.hashCode(), additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationRequestEventResponseWhatsAppContentImpl {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    codeType: ").append(toIndentedString(codeType)).append("\n");
    sb.append("    acceptLanguage: ").append(toIndentedString(acceptLanguage)).append("\n");
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
  static class Builder implements VerificationRequestEventResponseWhatsAppContent.Builder {
    OptionalValue<WhatsAppCodeType> codeType = OptionalValue.empty();
    OptionalValue<List<String>> acceptLanguage = OptionalValue.empty();
    OptionalValue<Map<String, Object>> additionalProperties = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CODE_TYPE)
    public Builder setCodeType(WhatsAppCodeType codeType) {
      this.codeType = OptionalValue.of(codeType);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ACCEPT_LANGUAGE)
    public Builder setAcceptLanguage(List<String> acceptLanguage) {
      this.acceptLanguage = OptionalValue.of(acceptLanguage);
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

    public VerificationRequestEventResponseWhatsAppContent build() {
      return new VerificationRequestEventResponseWhatsAppContentImpl(
          codeType, acceptLanguage, additionalProperties);
    }
  }
}
