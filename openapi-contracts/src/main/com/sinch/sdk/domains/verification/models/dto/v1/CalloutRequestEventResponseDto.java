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

/** CalloutRequestEventResponseDto */
@JsonPropertyOrder({
  CalloutRequestEventResponseDto.JSON_PROPERTY_ACTION,
  CalloutRequestEventResponseDto.JSON_PROPERTY_CALLOUT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class CalloutRequestEventResponseDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_ACTION = "action";
  private VerificationEventResponseActionDto action;
  private boolean actionDefined = false;

  public static final String JSON_PROPERTY_CALLOUT = "callout";
  private CalloutRequestEventResponseCalloutDto callout;
  private boolean calloutDefined = false;

  public CalloutRequestEventResponseDto() {}

  public CalloutRequestEventResponseDto action(VerificationEventResponseActionDto action) {
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

  public CalloutRequestEventResponseDto callout(CalloutRequestEventResponseCalloutDto callout) {
    this.callout = callout;
    this.calloutDefined = true;
    return this;
  }

  /**
   * Get callout
   *
   * @return callout
   */
  @JsonProperty(JSON_PROPERTY_CALLOUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public CalloutRequestEventResponseCalloutDto getCallout() {
    return callout;
  }

  @JsonIgnore
  public boolean getCalloutDefined() {
    return calloutDefined;
  }

  @JsonProperty(JSON_PROPERTY_CALLOUT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCallout(CalloutRequestEventResponseCalloutDto callout) {
    this.callout = callout;
    this.calloutDefined = true;
  }

  /** Return true if this CalloutRequestEventResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CalloutRequestEventResponseDto calloutRequestEventResponse = (CalloutRequestEventResponseDto) o;
    return Objects.equals(this.action, calloutRequestEventResponse.action)
        && Objects.equals(this.callout, calloutRequestEventResponse.callout);
  }

  @Override
  public int hashCode() {
    return Objects.hash(action, callout);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CalloutRequestEventResponseDto {\n");
    sb.append("    action: ").append(toIndentedString(action)).append("\n");
    sb.append("    callout: ").append(toIndentedString(callout)).append("\n");
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
