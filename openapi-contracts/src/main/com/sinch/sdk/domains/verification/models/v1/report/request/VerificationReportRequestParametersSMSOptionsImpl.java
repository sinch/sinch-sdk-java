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
  VerificationReportRequestParametersSMSOptionsImpl.JSON_PROPERTY_CODE,
  VerificationReportRequestParametersSMSOptionsImpl.JSON_PROPERTY_CLI
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class VerificationReportRequestParametersSMSOptionsImpl
    implements VerificationReportRequestParametersSMSOptions {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CODE = "code";

  private OptionalValue<String> code;

  public static final String JSON_PROPERTY_CLI = "cli";

  private OptionalValue<String> cli;

  public VerificationReportRequestParametersSMSOptionsImpl() {}

  protected VerificationReportRequestParametersSMSOptionsImpl(
      OptionalValue<String> code, OptionalValue<String> cli) {
    this.code = code;
    this.cli = cli;
  }

  @JsonIgnore
  public String getCode() {
    return code.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> code() {
    return code;
  }

  @JsonIgnore
  public String getCli() {
    return cli.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CLI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> cli() {
    return cli;
  }

  /** Return true if this SmsVerificationReportRequest_sms object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    VerificationReportRequestParametersSMSOptionsImpl smsVerificationReportRequestSms =
        (VerificationReportRequestParametersSMSOptionsImpl) o;
    return Objects.equals(this.code, smsVerificationReportRequestSms.code)
        && Objects.equals(this.cli, smsVerificationReportRequestSms.cli);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, cli);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class VerificationReportRequestParametersSMSOptionsImpl {\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    cli: ").append(toIndentedString(cli)).append("\n");
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
  static class Builder implements VerificationReportRequestParametersSMSOptions.Builder {
    OptionalValue<String> code = OptionalValue.empty();
    OptionalValue<String> cli = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CODE)
    public Builder setCode(String code) {
      this.code = OptionalValue.of(code);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CLI)
    public Builder setCli(String cli) {
      this.cli = OptionalValue.of(cli);
      return this;
    }

    public VerificationReportRequestParametersSMSOptions build() {
      return new VerificationReportRequestParametersSMSOptionsImpl(code, cli);
    }
  }
}
