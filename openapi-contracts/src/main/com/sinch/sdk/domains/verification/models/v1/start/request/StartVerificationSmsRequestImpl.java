package com.sinch.sdk.domains.verification.models.v1.start.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.Identity;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.start.request.internal.StartVerificationSmsOptions;
import com.sinch.sdk.domains.verification.models.v1.start.request.internal.StartVerificationSmsOptionsImpl;
import java.util.Objects;

@JsonPropertyOrder({
  StartVerificationSmsRequestImpl.JSON_PROPERTY_IDENTITY,
  StartVerificationSmsRequestImpl.JSON_PROPERTY_METHOD,
  StartVerificationSmsRequestImpl.JSON_PROPERTY_REFERENCE,
  StartVerificationSmsRequestImpl.JSON_PROPERTY_CUSTOM,
  StartVerificationSmsRequestImpl.JSON_PROPERTY_SMS_OPTIONS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class StartVerificationSmsRequestImpl
    implements StartVerificationSmsRequest,
        com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_IDENTITY = "identity";

  private OptionalValue<Identity> identity;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<VerificationMethod> method;

  public static final String JSON_PROPERTY_REFERENCE = "reference";

  private OptionalValue<String> reference;

  public static final String JSON_PROPERTY_CUSTOM = "custom";

  private OptionalValue<String> custom;

  public static final String JSON_PROPERTY_SMS_OPTIONS = "smsOptions";

  private OptionalValue<StartVerificationSmsOptions> smsOptions;

  public StartVerificationSmsRequestImpl() {}

  protected StartVerificationSmsRequestImpl(
      OptionalValue<Identity> identity,
      OptionalValue<VerificationMethod> method,
      OptionalValue<String> reference,
      OptionalValue<String> custom,
      OptionalValue<StartVerificationSmsOptions> smsOptions) {
    this.identity = identity;
    this.method = method;
    this.reference = reference;
    this.custom = custom;
    this.smsOptions = smsOptions;
  }

  @JsonIgnore
  public Identity getIdentity() {
    return identity.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Identity> identity() {
    return identity;
  }

  @JsonIgnore
  public VerificationMethod getMethod() {
    return method.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<VerificationMethod> method() {
    return method;
  }

  @JsonIgnore
  public String getReference() {
    return reference.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> reference() {
    return reference;
  }

  @JsonIgnore
  public String getCustom() {
    return custom.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CUSTOM)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> custom() {
    return custom;
  }

  @JsonIgnore
  public StartVerificationSmsOptions getSmsOptions() {
    return smsOptions.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SMS_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<StartVerificationSmsOptions> smsOptions() {
    return smsOptions;
  }

  @JsonIgnore
  public String getExpiry() {
    if (null == smsOptions || !smsOptions.isPresent() || null == smsOptions.get().getExpiry()) {
      return null;
    }
    return smsOptions.get().getExpiry();
  }

  public OptionalValue<String> expiry() {
    return null != smsOptions
        ? smsOptions.map(StartVerificationSmsOptions::getExpiry)
        : OptionalValue.empty();
  }

  @JsonIgnore
  public CodeTypeEnum getCodeType() {
    if (null == smsOptions || !smsOptions.isPresent() || null == smsOptions.get().getCodeType()) {
      return null;
    }
    return CodeTypeEnum.from(smsOptions.get().getCodeType().value());
  }

  public OptionalValue<CodeTypeEnum> codeType() {
    return null != smsOptions
        ? smsOptions.map(f -> CodeTypeEnum.from(smsOptions.get().getCodeType().value()))
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getTemplate() {
    if (null == smsOptions || !smsOptions.isPresent() || null == smsOptions.get().getTemplate()) {
      return null;
    }
    return smsOptions.get().getTemplate();
  }

  public OptionalValue<String> template() {
    return null != smsOptions
        ? smsOptions.map(StartVerificationSmsOptions::getTemplate)
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getAcceptLanguage() {
    if (null == smsOptions
        || !smsOptions.isPresent()
        || null == smsOptions.get().getAcceptLanguage()) {
      return null;
    }
    return smsOptions.get().getAcceptLanguage();
  }

  public OptionalValue<String> acceptLanguage() {
    return null != smsOptions
        ? smsOptions.map(StartVerificationSmsOptions::getAcceptLanguage)
        : OptionalValue.empty();
  }

  /** Return true if this StartVerificationSmsRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    StartVerificationSmsRequestImpl startVerificationSmsRequest =
        (StartVerificationSmsRequestImpl) o;
    return Objects.equals(this.identity, startVerificationSmsRequest.identity)
        && Objects.equals(this.method, startVerificationSmsRequest.method)
        && Objects.equals(this.reference, startVerificationSmsRequest.reference)
        && Objects.equals(this.custom, startVerificationSmsRequest.custom)
        && Objects.equals(this.smsOptions, startVerificationSmsRequest.smsOptions);
  }

  @Override
  public int hashCode() {
    return Objects.hash(identity, method, reference, custom, smsOptions);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class StartVerificationSmsRequestImpl {\n");
    sb.append("    identity: ").append(toIndentedString(identity)).append("\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    reference: ").append(toIndentedString(reference)).append("\n");
    sb.append("    custom: ").append(toIndentedString(custom)).append("\n");
    sb.append("    smsOptions: ").append(toIndentedString(smsOptions)).append("\n");
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
  static class Builder implements StartVerificationSmsRequest.Builder {
    OptionalValue<Identity> identity = OptionalValue.empty();
    OptionalValue<VerificationMethod> method = OptionalValue.of(VerificationMethod.SMS);
    OptionalValue<String> reference = OptionalValue.empty();
    OptionalValue<String> custom = OptionalValue.empty();
    OptionalValue<StartVerificationSmsOptions> smsOptions = OptionalValue.empty();

    StartVerificationSmsOptions.Builder _delegatedBuilder = null;

    @JsonProperty(JSON_PROPERTY_IDENTITY)
    public Builder setIdentity(Identity identity) {
      this.identity = OptionalValue.of(identity);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REFERENCE)
    public Builder setReference(String reference) {
      this.reference = OptionalValue.of(reference);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CUSTOM)
    public Builder setCustom(String custom) {
      this.custom = OptionalValue.of(custom);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SMS_OPTIONS)
    public Builder setSmsOptions(StartVerificationSmsOptions smsOptions) {
      this.smsOptions = OptionalValue.of(smsOptions);
      return this;
    }

    @JsonIgnore
    public Builder setExpiry(String expiry) {
      getDelegatedBuilder().setExpiry(expiry);
      return this;
    }

    @JsonIgnore
    public Builder setCodeType(CodeTypeEnum codeType) {
      getDelegatedBuilder()
          .setCodeType(
              null != codeType
                  ? StartVerificationSmsOptionsImpl.CodeTypeEnum.from(codeType.value())
                  : null);
      return this;
    }

    @JsonIgnore
    public Builder setTemplate(String template) {
      getDelegatedBuilder().setTemplate(template);
      return this;
    }

    @JsonIgnore
    public Builder setAcceptLanguage(String acceptLanguage) {
      getDelegatedBuilder().setAcceptLanguage(acceptLanguage);
      return this;
    }

    private StartVerificationSmsOptions.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = StartVerificationSmsOptions.builder();
      }
      return this._delegatedBuilder;
    }

    public StartVerificationSmsRequest build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.smsOptions = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new StartVerificationSmsRequestImpl(identity, method, reference, custom, smsOptions);
    }
  }
}
