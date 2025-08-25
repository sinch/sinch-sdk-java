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
import com.sinch.sdk.domains.verification.models.v1.SmsCodeType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({
  VerificationRequestEventResponseSmsContentImpl.JSON_PROPERTY_CODE,
  VerificationRequestEventResponseSmsContentImpl.JSON_PROPERTY_CODE_TYPE,
  VerificationRequestEventResponseSmsContentImpl.JSON_PROPERTY_EXPIRY,
  VerificationRequestEventResponseSmsContentImpl.JSON_PROPERTY_ACCEPT_LANGUAGE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationRequestEventResponseSmsContentImpl
    implements VerificationRequestEventResponseSmsContent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CODE = "code";

  private OptionalValue<String> code;

  public static final String JSON_PROPERTY_CODE_TYPE = "codeType";

  private OptionalValue<SmsCodeType> codeType;

  public static final String JSON_PROPERTY_EXPIRY = "expiry";

  private OptionalValue<String> expiry;

  public static final String JSON_PROPERTY_ACCEPT_LANGUAGE = "acceptLanguage";

  private OptionalValue<List<String>> acceptLanguage;

  /**
   * A container for additional, undeclared properties. This is a holder for any undeclared
   * properties as specified with the 'additionalProperties' keyword in the OAS document.
   */
  private OptionalValue<Map<String, Object>> additionalProperties;

  public VerificationRequestEventResponseSmsContentImpl() {}

  protected VerificationRequestEventResponseSmsContentImpl(
      OptionalValue<String> code,
      OptionalValue<SmsCodeType> codeType,
      OptionalValue<String> expiry,
      OptionalValue<List<String>> acceptLanguage,
      OptionalValue<Map<String, Object>> additionalProperties) {
    this.code = code;
    this.codeType = codeType;
    this.expiry = expiry;
    this.acceptLanguage = acceptLanguage;
    this.additionalProperties = additionalProperties;
  }

  @JsonIgnore
  public String getCode() {
    return code.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> code() {
    return code;
  }

  @JsonIgnore
  public SmsCodeType getCodeType() {
    return codeType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CODE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<SmsCodeType> codeType() {
    return codeType;
  }

  @JsonIgnore
  public String getExpiry() {
    return expiry.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EXPIRY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> expiry() {
    return expiry;
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

  /** Return true if this VerificationRequestEventResponseSms_allOf_sms object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationRequestEventResponseSmsContentImpl verificationRequestEventResponseSmsAllOfSms =
        (VerificationRequestEventResponseSmsContentImpl) o;
    return Objects.equals(this.code, verificationRequestEventResponseSmsAllOfSms.code)
        && Objects.equals(this.codeType, verificationRequestEventResponseSmsAllOfSms.codeType)
        && Objects.equals(this.expiry, verificationRequestEventResponseSmsAllOfSms.expiry)
        && Objects.equals(
            this.acceptLanguage, verificationRequestEventResponseSmsAllOfSms.acceptLanguage)
        && Objects.equals(
            this.additionalProperties,
            verificationRequestEventResponseSmsAllOfSms.additionalProperties)
        && super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        code, codeType, expiry, acceptLanguage, super.hashCode(), additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationRequestEventResponseSmsContentImpl {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    codeType: ").append(toIndentedString(codeType)).append("\n");
    sb.append("    expiry: ").append(toIndentedString(expiry)).append("\n");
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
  static class Builder implements VerificationRequestEventResponseSmsContent.Builder {
    OptionalValue<String> code = OptionalValue.empty();
    OptionalValue<SmsCodeType> codeType = OptionalValue.empty();
    OptionalValue<String> expiry = OptionalValue.empty();
    OptionalValue<List<String>> acceptLanguage = OptionalValue.empty();
    OptionalValue<Map<String, Object>> additionalProperties = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CODE)
    public Builder setCode(String code) {
      this.code = OptionalValue.of(code);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CODE_TYPE)
    public Builder setCodeType(SmsCodeType codeType) {
      this.codeType = OptionalValue.of(codeType);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_EXPIRY)
    public Builder setExpiry(String expiry) {
      this.expiry = OptionalValue.of(expiry);
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

    public VerificationRequestEventResponseSmsContent build() {
      return new VerificationRequestEventResponseSmsContentImpl(
          code, codeType, expiry, acceptLanguage, additionalProperties);
    }
  }
}
