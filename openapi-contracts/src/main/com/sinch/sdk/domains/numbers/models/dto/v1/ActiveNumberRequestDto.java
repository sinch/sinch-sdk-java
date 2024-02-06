/*
 * Numbers | Sinch
 * An API service for getting, listing and managing Sinch virtual numbers.
 *
 * The version of the OpenAPI document: 1.0.2
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.numbers.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.Objects;

/** The phone number that has been rented by a customer and assigned to a project. */
@JsonPropertyOrder({
  ActiveNumberRequestDto.JSON_PROPERTY_DISPLAY_NAME,
  ActiveNumberRequestDto.JSON_PROPERTY_SMS_CONFIGURATION,
  ActiveNumberRequestDto.JSON_PROPERTY_VOICE_CONFIGURATION,
  ActiveNumberRequestDto.JSON_PROPERTY_CALLBACK_URL
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ActiveNumberRequestDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_DISPLAY_NAME = "displayName";
  private String displayName;
  private boolean displayNameDefined = false;

  public static final String JSON_PROPERTY_SMS_CONFIGURATION = "smsConfiguration";
  private SMSConfigurationDto smsConfiguration;
  private boolean smsConfigurationDefined = false;

  public static final String JSON_PROPERTY_VOICE_CONFIGURATION = "voiceConfiguration";
  private VoiceConfigurationDto voiceConfiguration;
  private boolean voiceConfigurationDefined = false;

  public static final String JSON_PROPERTY_CALLBACK_URL = "callbackUrl";
  private String callbackUrl;
  private boolean callbackUrlDefined = false;

  public ActiveNumberRequestDto() {}

  public ActiveNumberRequestDto displayName(String displayName) {
    this.displayName = displayName;
    this.displayNameDefined = true;
    return this;
  }

  /**
   * User supplied name for the phone number.
   *
   * @return displayName
   */
  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getDisplayName() {
    return displayName;
  }

  @JsonIgnore
  public boolean getDisplayNameDefined() {
    return displayNameDefined;
  }

  @JsonProperty(JSON_PROPERTY_DISPLAY_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
    this.displayNameDefined = true;
  }

  public ActiveNumberRequestDto smsConfiguration(SMSConfigurationDto smsConfiguration) {
    this.smsConfiguration = smsConfiguration;
    this.smsConfigurationDefined = true;
    return this;
  }

  /**
   * Get smsConfiguration
   *
   * @return smsConfiguration
   */
  @JsonProperty(JSON_PROPERTY_SMS_CONFIGURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public SMSConfigurationDto getSmsConfiguration() {
    return smsConfiguration;
  }

  @JsonIgnore
  public boolean getSmsConfigurationDefined() {
    return smsConfigurationDefined;
  }

  @JsonProperty(JSON_PROPERTY_SMS_CONFIGURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSmsConfiguration(SMSConfigurationDto smsConfiguration) {
    this.smsConfiguration = smsConfiguration;
    this.smsConfigurationDefined = true;
  }

  public ActiveNumberRequestDto voiceConfiguration(VoiceConfigurationDto voiceConfiguration) {
    this.voiceConfiguration = voiceConfiguration;
    this.voiceConfigurationDefined = true;
    return this;
  }

  /**
   * Get voiceConfiguration
   *
   * @return voiceConfiguration
   */
  @JsonProperty(JSON_PROPERTY_VOICE_CONFIGURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public VoiceConfigurationDto getVoiceConfiguration() {
    return voiceConfiguration;
  }

  @JsonIgnore
  public boolean getVoiceConfigurationDefined() {
    return voiceConfigurationDefined;
  }

  @JsonProperty(JSON_PROPERTY_VOICE_CONFIGURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVoiceConfiguration(VoiceConfigurationDto voiceConfiguration) {
    this.voiceConfiguration = voiceConfiguration;
    this.voiceConfigurationDefined = true;
  }

  public ActiveNumberRequestDto callbackUrl(String callbackUrl) {
    this.callbackUrl = callbackUrl;
    this.callbackUrlDefined = true;
    return this;
  }

  /**
   * The active number&#39;s callback URL to be called for provisioning / deprovisioning updates
   *
   * @return callbackUrl
   */
  @JsonProperty(JSON_PROPERTY_CALLBACK_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCallbackUrl() {
    return callbackUrl;
  }

  @JsonIgnore
  public boolean getCallbackUrlDefined() {
    return callbackUrlDefined;
  }

  @JsonProperty(JSON_PROPERTY_CALLBACK_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCallbackUrl(String callbackUrl) {
    this.callbackUrl = callbackUrl;
    this.callbackUrlDefined = true;
  }

  /** Return true if this ActiveNumberRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ActiveNumberRequestDto activeNumberRequest = (ActiveNumberRequestDto) o;
    return Objects.equals(this.displayName, activeNumberRequest.displayName)
        && Objects.equals(this.smsConfiguration, activeNumberRequest.smsConfiguration)
        && Objects.equals(this.voiceConfiguration, activeNumberRequest.voiceConfiguration)
        && Objects.equals(this.callbackUrl, activeNumberRequest.callbackUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(displayName, smsConfiguration, voiceConfiguration, callbackUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ActiveNumberRequestDto {\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    smsConfiguration: ").append(toIndentedString(smsConfiguration)).append("\n");
    sb.append("    voiceConfiguration: ").append(toIndentedString(voiceConfiguration)).append("\n");
    sb.append("    callbackUrl: ").append(toIndentedString(callbackUrl)).append("\n");
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
