package com.sinch.sdk.domains.verification.models.v1.report.request;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  VerificationReportRequestParametersSMSImpl.JSON_PROPERTY_METHOD,
  VerificationReportRequestParametersSMSImpl.JSON_PROPERTY_SMS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationReportRequestParametersSMSImpl
    implements VerificationReportRequestParametersSMS {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_METHOD = "method";

  private OptionalValue<MethodEnum> method;

  public static final String JSON_PROPERTY_SMS = "sms";

  private OptionalValue<VerificationReportRequestParametersSMSOptions> sms;

  public VerificationReportRequestParametersSMSImpl() {}

  protected VerificationReportRequestParametersSMSImpl(
      OptionalValue<MethodEnum> method,
      OptionalValue<VerificationReportRequestParametersSMSOptions> sms) {
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
  public VerificationReportRequestParametersSMSOptions getSms() {
    return sms.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SMS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<VerificationReportRequestParametersSMSOptions> sms() {
    return sms;
  }

  /** Return true if this SmsVerificationReportRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationReportRequestParametersSMSImpl smsVerificationReportRequest =
        (VerificationReportRequestParametersSMSImpl) o;
    return Objects.equals(this.method, smsVerificationReportRequest.method)
        && Objects.equals(this.sms, smsVerificationReportRequest.sms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(method, sms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationReportRequestParametersSMSImpl {\n");
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
  static class Builder implements VerificationReportRequestParametersSMS.Builder {
    OptionalValue<MethodEnum> method = OptionalValue.empty();
    OptionalValue<VerificationReportRequestParametersSMSOptions> sms = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_METHOD)
    public Builder setMethod(MethodEnum method) {
      this.method = OptionalValue.of(method);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SMS)
    public Builder setSms(VerificationReportRequestParametersSMSOptions sms) {
      this.sms = OptionalValue.of(sms);
      return this;
    }

    public VerificationReportRequestParametersSMS build() {
      return new VerificationReportRequestParametersSMSImpl(method, sms);
    }
  }
}
