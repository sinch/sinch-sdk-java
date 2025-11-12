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
import com.sinch.sdk.domains.verification.models.v1.SmsCodeType;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({
  VerificationStartSmsOptionsImpl.JSON_PROPERTY_CODE_TYPE,
  VerificationStartSmsOptionsImpl.JSON_PROPERTY_EXPIRY
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationStartSmsOptionsImpl implements VerificationStartSmsOptions {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CODE_TYPE = "codeType";

  private OptionalValue<SmsCodeType> codeType;

  public static final String JSON_PROPERTY_EXPIRY = "expiry";

  private OptionalValue<String> expiry;

  private OptionalValue<String> acceptLanguage;

  /**
   * A container for additional, undeclared properties. This is a holder for any undeclared
   * properties as specified with the 'additionalProperties' keyword in the OAS document.
   */
  private OptionalValue<Map<String, Object>> additionalProperties;

  public VerificationStartSmsOptionsImpl() {}

  protected VerificationStartSmsOptionsImpl(
      OptionalValue<SmsCodeType> codeType,
      OptionalValue<String> expiry,
      OptionalValue<String> acceptLanguage,
      OptionalValue<Map<String, Object>> additionalProperties) {
    this.codeType = codeType;
    this.expiry = expiry;
    this.acceptLanguage = acceptLanguage;
    this.additionalProperties = additionalProperties;
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
  public String getAcceptLanguage() {
    return acceptLanguage.orElse(null);
  }

  public OptionalValue<String> acceptLanguage() {
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

  /** Return true if this VerificationStartRequestSms_allOf_smsOptions object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationStartSmsOptionsImpl verificationStartRequestSmsAllOfSmsOptions =
        (VerificationStartSmsOptionsImpl) o;
    return Objects.equals(this.codeType, verificationStartRequestSmsAllOfSmsOptions.codeType)
        && Objects.equals(this.expiry, verificationStartRequestSmsAllOfSmsOptions.expiry)
        && Objects.equals(
            this.acceptLanguage, verificationStartRequestSmsAllOfSmsOptions.acceptLanguage)
        && Objects.equals(
            this.additionalProperties,
            verificationStartRequestSmsAllOfSmsOptions.additionalProperties);
  }

  @Override
  public int hashCode() {
    return Objects.hash(codeType, expiry, acceptLanguage, additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationStartSmsOptionsImpl {\n");
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
  static class Builder implements VerificationStartSmsOptions.Builder {
    OptionalValue<SmsCodeType> codeType = OptionalValue.empty();
    OptionalValue<String> expiry = OptionalValue.empty();
    OptionalValue<String> acceptLanguage = OptionalValue.empty();
    OptionalValue<Map<String, Object>> additionalProperties = OptionalValue.empty();

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

    @JsonIgnore
    public Builder setAcceptLanguage(String acceptLanguage) {
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

    public VerificationStartSmsOptions build() {
      return new VerificationStartSmsOptionsImpl(
          codeType, expiry, acceptLanguage, additionalProperties);
    }
  }
}
