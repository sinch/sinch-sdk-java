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
import com.sinch.sdk.domains.verification.models.v1.SmsCodeType;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonPropertyOrder({
  VerificationStartResponseSmsContentImpl.JSON_PROPERTY_TEMPLATE,
  VerificationStartResponseSmsContentImpl.JSON_PROPERTY_INTERCEPTION_TIMEOUT,
  VerificationStartResponseSmsContentImpl.JSON_PROPERTY_CODE_TYPE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationStartResponseSmsContentImpl
    implements VerificationStartResponseSmsContent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TEMPLATE = "template";

  private OptionalValue<String> template;

  public static final String JSON_PROPERTY_INTERCEPTION_TIMEOUT = "interceptionTimeout";

  private OptionalValue<Integer> interceptionTimeout;

  public static final String JSON_PROPERTY_CODE_TYPE = "codeType";

  private OptionalValue<SmsCodeType> codeType;

  /**
   * A container for additional, undeclared properties. This is a holder for any undeclared
   * properties as specified with the 'additionalProperties' keyword in the OAS document.
   */
  private OptionalValue<Map<String, Object>> additionalProperties;

  public VerificationStartResponseSmsContentImpl() {}

  protected VerificationStartResponseSmsContentImpl(
      OptionalValue<String> template,
      OptionalValue<Integer> interceptionTimeout,
      OptionalValue<SmsCodeType> codeType,
      OptionalValue<Map<String, Object>> additionalProperties) {
    this.template = template;
    this.interceptionTimeout = interceptionTimeout;
    this.codeType = codeType;
    this.additionalProperties = additionalProperties;
  }

  @JsonIgnore
  public String getTemplate() {
    return template.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TEMPLATE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> template() {
    return template;
  }

  @JsonIgnore
  public Integer getInterceptionTimeout() {
    return interceptionTimeout.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_INTERCEPTION_TIMEOUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> interceptionTimeout() {
    return interceptionTimeout;
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

  /** Return true if this VerificationStartResponseSms_allOf_sms object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationStartResponseSmsContentImpl verificationStartResponseSmsAllOfSms =
        (VerificationStartResponseSmsContentImpl) o;
    return Objects.equals(this.template, verificationStartResponseSmsAllOfSms.template)
        && Objects.equals(
            this.interceptionTimeout, verificationStartResponseSmsAllOfSms.interceptionTimeout)
        && Objects.equals(this.codeType, verificationStartResponseSmsAllOfSms.codeType)
        && Objects.equals(
            this.additionalProperties, verificationStartResponseSmsAllOfSms.additionalProperties)
        && super.equals(o);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        template, interceptionTimeout, codeType, super.hashCode(), additionalProperties);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationStartResponseSmsContentImpl {\n");
    sb.append("    ").append(toIndentedString(super.toString())).append("\n");
    sb.append("    template: ").append(toIndentedString(template)).append("\n");
    sb.append("    interceptionTimeout: ")
        .append(toIndentedString(interceptionTimeout))
        .append("\n");
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
  static class Builder implements VerificationStartResponseSmsContent.Builder {
    OptionalValue<String> template = OptionalValue.empty();
    OptionalValue<Integer> interceptionTimeout = OptionalValue.empty();
    OptionalValue<SmsCodeType> codeType = OptionalValue.empty();
    OptionalValue<Map<String, Object>> additionalProperties = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_TEMPLATE)
    public Builder setTemplate(String template) {
      this.template = OptionalValue.of(template);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_INTERCEPTION_TIMEOUT)
    public Builder setInterceptionTimeout(Integer interceptionTimeout) {
      this.interceptionTimeout = OptionalValue.of(interceptionTimeout);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CODE_TYPE)
    public Builder setCodeType(SmsCodeType codeType) {
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

    public VerificationStartResponseSmsContent build() {
      return new VerificationStartResponseSmsContentImpl(
          template, interceptionTimeout, codeType, additionalProperties);
    }
  }
}
