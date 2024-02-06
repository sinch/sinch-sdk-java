/*
 * Voice API | Sinch
 * The Voice API exposes calling- and conference-related functionality in the Sinch Voice Platform.
 *
 * The version of the OpenAPI document: 1.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.voice.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/**
 * Options to control how DTMF signals are used by the participant in the conference. For
 * information on how to use this feature, read more [here](../../../conference-dtmf).
 */
@JsonPropertyOrder({
  ConferenceCalloutRequestConferenceDtmfOptionsDto.JSON_PROPERTY_MODE,
  ConferenceCalloutRequestConferenceDtmfOptionsDto.JSON_PROPERTY_MAX_DIGITS,
  ConferenceCalloutRequestConferenceDtmfOptionsDto.JSON_PROPERTY_TIMEOUT_MILLS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ConferenceCalloutRequestConferenceDtmfOptionsDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_MODE = "mode";
  private String mode;
  private boolean modeDefined = false;

  public static final String JSON_PROPERTY_MAX_DIGITS = "maxDigits";
  private Integer maxDigits;
  private boolean maxDigitsDefined = false;

  public static final String JSON_PROPERTY_TIMEOUT_MILLS = "timeoutMills";
  private Integer timeoutMills;
  private boolean timeoutMillsDefined = false;

  public ConferenceCalloutRequestConferenceDtmfOptionsDto() {}

  public ConferenceCalloutRequestConferenceDtmfOptionsDto mode(String mode) {
    this.mode = mode;
    this.modeDefined = true;
    return this;
  }

  /**
   * Determines what DTMF mode the participant will use in the call.
   *
   * @return mode
   */
  @JsonProperty(JSON_PROPERTY_MODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getMode() {
    return mode;
  }

  @JsonIgnore
  public boolean getModeDefined() {
    return modeDefined;
  }

  @JsonProperty(JSON_PROPERTY_MODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMode(String mode) {
    this.mode = mode;
    this.modeDefined = true;
  }

  public ConferenceCalloutRequestConferenceDtmfOptionsDto maxDigits(Integer maxDigits) {
    this.maxDigits = maxDigits;
    this.maxDigitsDefined = true;
    return this;
  }

  /**
   * The maximum number of accepted digits before sending the collected input via a PIE callback.
   * The default value is &#x60;1&#x60;. If the value is greater than &#x60;1&#x60;, the PIE
   * callback is triggered by one of the three following events: - No additional digit is entered
   * before the &#x60;timeoutMills&#x60; timeout period has elapsed. - The &#x60;#&#x60; character
   * is entered. - The maximum number of digits has been entered.
   *
   * @return maxDigits
   */
  @JsonProperty(JSON_PROPERTY_MAX_DIGITS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getMaxDigits() {
    return maxDigits;
  }

  @JsonIgnore
  public boolean getMaxDigitsDefined() {
    return maxDigitsDefined;
  }

  @JsonProperty(JSON_PROPERTY_MAX_DIGITS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMaxDigits(Integer maxDigits) {
    this.maxDigits = maxDigits;
    this.maxDigitsDefined = true;
  }

  public ConferenceCalloutRequestConferenceDtmfOptionsDto timeoutMills(Integer timeoutMills) {
    this.timeoutMills = timeoutMills;
    this.timeoutMillsDefined = true;
    return this;
  }

  /**
   * The number of milliseconds that the system will wait between entered digits before triggering
   * the PIE callback. The default value is &#x60;3000&#x60;.
   *
   * @return timeoutMills
   */
  @JsonProperty(JSON_PROPERTY_TIMEOUT_MILLS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getTimeoutMills() {
    return timeoutMills;
  }

  @JsonIgnore
  public boolean getTimeoutMillsDefined() {
    return timeoutMillsDefined;
  }

  @JsonProperty(JSON_PROPERTY_TIMEOUT_MILLS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTimeoutMills(Integer timeoutMills) {
    this.timeoutMills = timeoutMills;
    this.timeoutMillsDefined = true;
  }

  /** Return true if this conferenceCalloutRequest_conferenceDtmfOptions object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConferenceCalloutRequestConferenceDtmfOptionsDto conferenceCalloutRequestConferenceDtmfOptions =
        (ConferenceCalloutRequestConferenceDtmfOptionsDto) o;
    return Objects.equals(this.mode, conferenceCalloutRequestConferenceDtmfOptions.mode)
        && Objects.equals(this.maxDigits, conferenceCalloutRequestConferenceDtmfOptions.maxDigits)
        && Objects.equals(
            this.timeoutMills, conferenceCalloutRequestConferenceDtmfOptions.timeoutMills);
  }

  @Override
  public int hashCode() {
    return Objects.hash(mode, maxDigits, timeoutMills);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConferenceCalloutRequestConferenceDtmfOptionsDto {\n");
    sb.append("    mode: ").append(toIndentedString(mode)).append("\n");
    sb.append("    maxDigits: ").append(toIndentedString(maxDigits)).append("\n");
    sb.append("    timeoutMills: ").append(toIndentedString(timeoutMills)).append("\n");
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
