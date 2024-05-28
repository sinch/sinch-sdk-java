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

/** SMSRequestEventResponseDto */
@JsonPropertyOrder({
  SMSRequestEventResponseDto.JSON_PROPERTY_ACTION,
  SMSRequestEventResponseDto.JSON_PROPERTY_SMS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SMSRequestEventResponseDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_ACTION = "action";
  private VerificationEventResponseActionDto action;
  private boolean actionDefined = false;

  public static final String JSON_PROPERTY_SMS = "sms";
  private SMSRequestEventResponseSmsDto sms;
  private boolean smsDefined = false;

  public SMSRequestEventResponseDto() {}

  public SMSRequestEventResponseDto action(VerificationEventResponseActionDto action) {
    this.action = action;
    this.actionDefined = true;
    return this;
  }

  /**
   * Get action
   *
   * @return action
   */
  @JsonProperty(JSON_PROPERTY_ACTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public VerificationEventResponseActionDto getAction() {
    return action;
  }

  @JsonIgnore
  public boolean getActionDefined() {
    return actionDefined;
  }

  @JsonProperty(JSON_PROPERTY_ACTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAction(VerificationEventResponseActionDto action) {
    this.action = action;
    this.actionDefined = true;
  }

  public SMSRequestEventResponseDto sms(SMSRequestEventResponseSmsDto sms) {
    this.sms = sms;
    this.smsDefined = true;
    return this;
  }

  /**
   * Get sms
   *
   * @return sms
   */
  @JsonProperty(JSON_PROPERTY_SMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public SMSRequestEventResponseSmsDto getSms() {
    return sms;
  }

  @JsonIgnore
  public boolean getSmsDefined() {
    return smsDefined;
  }

  @JsonProperty(JSON_PROPERTY_SMS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSms(SMSRequestEventResponseSmsDto sms) {
    this.sms = sms;
    this.smsDefined = true;
  }

  /** Return true if this SMSRequestEventResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SMSRequestEventResponseDto smSRequestEventResponse = (SMSRequestEventResponseDto) o;
    return Objects.equals(this.action, smSRequestEventResponse.action)
        && Objects.equals(this.sms, smSRequestEventResponse.sms);
  }

  @Override
  public int hashCode() {
    return Objects.hash(action, sms);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SMSRequestEventResponseDto {\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
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
}
