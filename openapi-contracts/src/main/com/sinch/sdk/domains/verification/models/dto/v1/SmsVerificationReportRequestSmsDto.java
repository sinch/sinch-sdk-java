/*
 * Verification | Sinch
 * Verify users with SMS, flash calls (missed calls), a regular call, or data verification.
 *
 * The version of the OpenAPI document: 2.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.verification.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/** A configuration object containing settings specific to SMS verifications. */
@JsonPropertyOrder({
  SmsVerificationReportRequestSmsDto.JSON_PROPERTY_CODE,
  SmsVerificationReportRequestSmsDto.JSON_PROPERTY_CLI
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SmsVerificationReportRequestSmsDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_CODE = "code";
  private String code;
  private boolean codeDefined = false;

  public static final String JSON_PROPERTY_CLI = "cli";
  private String cli;
  private boolean cliDefined = false;

  public SmsVerificationReportRequestSmsDto() {}

  public SmsVerificationReportRequestSmsDto code(String code) {
    this.code = code;
    this.codeDefined = true;
    return this;
  }

  /**
   * The code which was received by the user submitting the SMS verification.
   *
   * @return code
   */
  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getCode() {
    return code;
  }

  @JsonIgnore
  public boolean getCodeDefined() {
    return codeDefined;
  }

  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCode(String code) {
    this.code = code;
    this.codeDefined = true;
  }

  public SmsVerificationReportRequestSmsDto cli(String cli) {
    this.cli = cli;
    this.cliDefined = true;
    return this;
  }

  /**
   * The sender ID of the SMS.
   *
   * @return cli
   */
  @JsonProperty(JSON_PROPERTY_CLI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCli() {
    return cli;
  }

  @JsonIgnore
  public boolean getCliDefined() {
    return cliDefined;
  }

  @JsonProperty(JSON_PROPERTY_CLI)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCli(String cli) {
    this.cli = cli;
    this.cliDefined = true;
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
    SmsVerificationReportRequestSmsDto smsVerificationReportRequestSms =
        (SmsVerificationReportRequestSmsDto) o;
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
    sb.append("class SmsVerificationReportRequestSmsDto {\n");
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
}
