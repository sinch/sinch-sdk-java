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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Request message for searching and renting in one go any number that matches the search criteria.
 */
@JsonPropertyOrder({
  RentAnyNumberRequestDto.JSON_PROPERTY_REGION_CODE,
  RentAnyNumberRequestDto.JSON_PROPERTY_TYPE,
  RentAnyNumberRequestDto.JSON_PROPERTY_NUMBER_PATTERN,
  RentAnyNumberRequestDto.JSON_PROPERTY_CAPABILITIES,
  RentAnyNumberRequestDto.JSON_PROPERTY_SMS_CONFIGURATION,
  RentAnyNumberRequestDto.JSON_PROPERTY_VOICE_CONFIGURATION,
  RentAnyNumberRequestDto.JSON_PROPERTY_CALLBACK_URL
})
// @javax.annotation.Generated(value = "org.openapitools.codegen.languages.JavaClientCodegen")
public class RentAnyNumberRequestDto {
  public static final String JSON_PROPERTY_REGION_CODE = "regionCode";
  private String regionCode;

  public static final String JSON_PROPERTY_TYPE = "type";
  private String type = "LOCAL";

  public static final String JSON_PROPERTY_NUMBER_PATTERN = "numberPattern";
  private SearchPatternDto numberPattern;

  public static final String JSON_PROPERTY_CAPABILITIES = "capabilities";
  private List<String> capabilities;

  public static final String JSON_PROPERTY_SMS_CONFIGURATION = "smsConfiguration";
  private RentAnyNumberRequestSmsConfigurationDto smsConfiguration;

  public static final String JSON_PROPERTY_VOICE_CONFIGURATION = "voiceConfiguration";
  private RentAnyNumberRequestVoiceConfigurationDto voiceConfiguration;

  public static final String JSON_PROPERTY_CALLBACK_URL = "callbackUrl";
  private String callbackUrl;

  public RentAnyNumberRequestDto() {}

  public RentAnyNumberRequestDto regionCode(String regionCode) {
    this.regionCode = regionCode;
    return this;
  }

  /**
   * Region code to filter by. ISO 3166-1 alpha-2 country code of the phone number. Example:
   * &#x60;US&#x60;, &#x60;GB&#x60; or &#x60;SE&#x60;.
   *
   * @return regionCode
   */
  @JsonProperty(JSON_PROPERTY_REGION_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getRegionCode() {
    return regionCode;
  }

  @JsonProperty(JSON_PROPERTY_REGION_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRegionCode(String regionCode) {
    this.regionCode = regionCode;
  }

  public RentAnyNumberRequestDto type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Number type to filter by. &#x60;MOBILE&#x60;, &#x60;LOCAL&#x60; or &#x60;TOLL_FREE&#x60;.
   *
   * @return type
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getType() {
    return type;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(String type) {
    this.type = type;
  }

  public RentAnyNumberRequestDto numberPattern(SearchPatternDto numberPattern) {
    this.numberPattern = numberPattern;
    return this;
  }

  /**
   * Get numberPattern
   *
   * @return numberPattern
   */
  @JsonProperty(JSON_PROPERTY_NUMBER_PATTERN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public SearchPatternDto getNumberPattern() {
    return numberPattern;
  }

  @JsonProperty(JSON_PROPERTY_NUMBER_PATTERN)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNumberPattern(SearchPatternDto numberPattern) {
    this.numberPattern = numberPattern;
  }

  public RentAnyNumberRequestDto capabilities(List<String> capabilities) {
    this.capabilities = capabilities;
    return this;
  }

  public RentAnyNumberRequestDto addCapabilitiesItem(String capabilitiesItem) {
    if (this.capabilities == null) {
      this.capabilities = new ArrayList<>();
    }
    this.capabilities.add(capabilitiesItem);
    return this;
  }

  /**
   * Number capabilities to filter by, &#x60;SMS&#x60; and/or &#x60;VOICE&#x60;.
   *
   * @return capabilities
   */
  @JsonProperty(JSON_PROPERTY_CAPABILITIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public List<String> getCapabilities() {
    return capabilities;
  }

  @JsonProperty(JSON_PROPERTY_CAPABILITIES)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCapabilities(List<String> capabilities) {
    this.capabilities = capabilities;
  }

  public RentAnyNumberRequestDto smsConfiguration(
      RentAnyNumberRequestSmsConfigurationDto smsConfiguration) {
    this.smsConfiguration = smsConfiguration;
    return this;
  }

  /**
   * Get smsConfiguration
   *
   * @return smsConfiguration
   */
  @JsonProperty(JSON_PROPERTY_SMS_CONFIGURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public RentAnyNumberRequestSmsConfigurationDto getSmsConfiguration() {
    return smsConfiguration;
  }

  @JsonProperty(JSON_PROPERTY_SMS_CONFIGURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setSmsConfiguration(RentAnyNumberRequestSmsConfigurationDto smsConfiguration) {
    this.smsConfiguration = smsConfiguration;
  }

  public RentAnyNumberRequestDto voiceConfiguration(
      RentAnyNumberRequestVoiceConfigurationDto voiceConfiguration) {
    this.voiceConfiguration = voiceConfiguration;
    return this;
  }

  /**
   * Get voiceConfiguration
   *
   * @return voiceConfiguration
   */
  @JsonProperty(JSON_PROPERTY_VOICE_CONFIGURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public RentAnyNumberRequestVoiceConfigurationDto getVoiceConfiguration() {
    return voiceConfiguration;
  }

  @JsonProperty(JSON_PROPERTY_VOICE_CONFIGURATION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVoiceConfiguration(RentAnyNumberRequestVoiceConfigurationDto voiceConfiguration) {
    this.voiceConfiguration = voiceConfiguration;
  }

  public RentAnyNumberRequestDto callbackUrl(String callbackUrl) {
    this.callbackUrl = callbackUrl;
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

  @JsonProperty(JSON_PROPERTY_CALLBACK_URL)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCallbackUrl(String callbackUrl) {
    this.callbackUrl = callbackUrl;
  }

  /** Return true if this RentAnyNumberRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RentAnyNumberRequestDto rentAnyNumberRequest = (RentAnyNumberRequestDto) o;
    return Objects.equals(this.regionCode, rentAnyNumberRequest.regionCode)
        && Objects.equals(this.type, rentAnyNumberRequest.type)
        && Objects.equals(this.numberPattern, rentAnyNumberRequest.numberPattern)
        && Objects.equals(this.capabilities, rentAnyNumberRequest.capabilities)
        && Objects.equals(this.smsConfiguration, rentAnyNumberRequest.smsConfiguration)
        && Objects.equals(this.voiceConfiguration, rentAnyNumberRequest.voiceConfiguration)
        && Objects.equals(this.callbackUrl, rentAnyNumberRequest.callbackUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        regionCode,
        type,
        numberPattern,
        capabilities,
        smsConfiguration,
        voiceConfiguration,
        callbackUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RentAnyNumberRequestDto {\n");
    sb.append("    regionCode: ").append(toIndentedString(regionCode)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    numberPattern: ").append(toIndentedString(numberPattern)).append("\n");
    sb.append("    capabilities: ").append(toIndentedString(capabilities)).append("\n");
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
