package com.sinch.sdk.domains.verification.models.v1.report.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.verification.models.v1.report.request.internal.VerificationReportRequestSmsOptions;
import java.util.Objects;

@JsonPropertyOrder({
  VerificationReportRequestSmsImpl.JSON_PROPERTY_METHOD,
  VerificationReportRequestSmsImpl.JSON_PROPERTY_SMS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationReportRequestSmsImpl
    implements VerificationReportRequestSms,
        com.sinch.sdk.domains.verification.models.v1.report.request.VerificationReportRequest {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<MethodEnum> method;

  public static final String JSON_PROPERTY_SMS = "sms";

  private OptionalValue<VerificationReportRequestSmsOptions> sms;

  public VerificationReportRequestSmsImpl() {}

  protected VerificationReportRequestSmsImpl(
      OptionalValue<MethodEnum> method, OptionalValue<VerificationReportRequestSmsOptions> sms) {
    this.method = method;
    this.sms = sms;
  }

  @JsonIgnore
  public MethodEnum getMethod() {
    return method.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METHOD)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<MethodEnum> method() {
    return method;
  }

  @JsonIgnore
  public VerificationReportRequestSmsOptions getSms() {
    return sms.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SMS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<VerificationReportRequestSmsOptions> sms() {
    return sms;
  }

  @JsonIgnore
  public String getCode() {
    if (null == sms || !sms.isPresent() || null == sms.get().getCode()) {
      return null;
    }
    return sms.get().getCode();
  }

  public OptionalValue<String> code() {
    return null != sms
        ? sms.map(VerificationReportRequestSmsOptions::getCode)
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getCli() {
    if (null == sms || !sms.isPresent() || null == sms.get().getCli()) {
      return null;
    }
    return sms.get().getCli();
  }

  public OptionalValue<String> cli() {
    return null != sms
        ? sms.map(VerificationReportRequestSmsOptions::getCli)
        : OptionalValue.empty();
  }

  /** Return true if this VerificationReportRequestSms object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationReportRequestSmsImpl verificationReportRequestSms =
        (VerificationReportRequestSmsImpl) o;
    return Objects.equals(this.method, verificationReportRequestSms.method)
        && Objects.equals(this.sms, verificationReportRequestSms.sms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(method, sms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationReportRequestSmsImpl {\n");
    sb.append("    method: ").append(toIndentedString(method)).append("\n");
    sb.append("    sms: ").append(toIndentedString(sms)).append("\n");
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
  static class Builder implements VerificationReportRequestSms.Builder {
    OptionalValue<MethodEnum> method = OptionalValue.of(MethodEnum.SMS);
    OptionalValue<VerificationReportRequestSmsOptions> sms = OptionalValue.empty();

    VerificationReportRequestSmsOptions.Builder _delegatedBuilder = null;

    @JsonProperty(JSON_PROPERTY_SMS)
    public Builder setSms(VerificationReportRequestSmsOptions sms) {
      this.sms = OptionalValue.of(sms);
      return this;
    }

    @JsonIgnore
    public Builder setCode(String code) {
      getDelegatedBuilder().setCode(code);
      return this;
    }

    @JsonIgnore
    public Builder setCli(String cli) {
      getDelegatedBuilder().setCli(cli);
      return this;
    }

    private VerificationReportRequestSmsOptions.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = VerificationReportRequestSmsOptions.builder();
      }
      return this._delegatedBuilder;
    }

    public VerificationReportRequestSms build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.sms = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new VerificationReportRequestSmsImpl(method, sms);
    }
  }
}
