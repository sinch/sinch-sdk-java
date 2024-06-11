package com.sinch.sdk.domains.verification.models.v1.start.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  StartVerificationSmsOptionsImpl.JSON_PROPERTY_EXPIRY,
  StartVerificationSmsOptionsImpl.JSON_PROPERTY_CODE_TYPE,
  StartVerificationSmsOptionsImpl.JSON_PROPERTY_TEMPLATE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StartVerificationSmsOptionsImpl implements StartVerificationSmsOptions {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_EXPIRY = "expiry";

  private OptionalValue<String> expiry;

  public static final String JSON_PROPERTY_CODE_TYPE = "codeType";

  private OptionalValue<CodeTypeEnum> codeType;

  public static final String JSON_PROPERTY_TEMPLATE = "template";

  private OptionalValue<String> template;

  private OptionalValue<String> acceptLanguage;

  public StartVerificationSmsOptionsImpl() {}

  protected StartVerificationSmsOptionsImpl(
      OptionalValue<String> expiry,
      OptionalValue<CodeTypeEnum> codeType,
      OptionalValue<String> template,
      OptionalValue<String> acceptLanguage) {
    this.expiry = expiry;
    this.codeType = codeType;
    this.template = template;
    this.acceptLanguage = acceptLanguage;
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
  public CodeTypeEnum getCodeType() {
    return codeType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CODE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<CodeTypeEnum> codeType() {
    return codeType;
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
  public String getAcceptLanguage() {
    return acceptLanguage.orElse(null);
  }

  public OptionalValue<String> acceptLanguage() {
    return acceptLanguage;
  }

  /** Return true if this StartVerificationSmsRequest_allOf_smsOptions object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartVerificationSmsOptionsImpl startVerificationSmsRequestAllOfSmsOptions =
        (StartVerificationSmsOptionsImpl) o;
    return Objects.equals(this.expiry, startVerificationSmsRequestAllOfSmsOptions.expiry)
        && Objects.equals(this.codeType, startVerificationSmsRequestAllOfSmsOptions.codeType)
        && Objects.equals(this.template, startVerificationSmsRequestAllOfSmsOptions.template)
        && Objects.equals(
            this.acceptLanguage, startVerificationSmsRequestAllOfSmsOptions.acceptLanguage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(expiry, codeType, template, acceptLanguage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartVerificationSmsOptionsImpl {\n");
    sb.append("    expiry: ").append(toIndentedString(expiry)).append("\n");
    sb.append("    codeType: ").append(toIndentedString(codeType)).append("\n");
    sb.append("    template: ").append(toIndentedString(template)).append("\n");
    sb.append("    acceptLanguage: ").append(toIndentedString(acceptLanguage)).append("\n");
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
  static class Builder implements StartVerificationSmsOptions.Builder {
    OptionalValue<String> expiry = OptionalValue.empty();
    OptionalValue<CodeTypeEnum> codeType = OptionalValue.empty();
    OptionalValue<String> template = OptionalValue.empty();
    OptionalValue<String> acceptLanguage = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_EXPIRY)
    public Builder setExpiry(String expiry) {
      this.expiry = OptionalValue.of(expiry);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CODE_TYPE)
    public Builder setCodeType(CodeTypeEnum codeType) {
      this.codeType = OptionalValue.of(codeType);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TEMPLATE)
    public Builder setTemplate(String template) {
      this.template = OptionalValue.of(template);
      return this;
    }

    @JsonIgnore
    public Builder setAcceptLanguage(String acceptLanguage) {
      this.acceptLanguage = OptionalValue.of(acceptLanguage);
      return this;
    }

    public StartVerificationSmsOptions build() {
      return new StartVerificationSmsOptionsImpl(expiry, codeType, template, acceptLanguage);
    }
  }
}
