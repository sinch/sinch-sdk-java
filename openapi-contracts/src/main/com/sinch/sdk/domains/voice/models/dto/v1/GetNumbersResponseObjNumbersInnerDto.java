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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;

/** GetNumbersResponseObjNumbersInnerDto */
@JsonPropertyOrder({
  GetNumbersResponseObjNumbersInnerDto.JSON_PROPERTY_NUMBER,
  GetNumbersResponseObjNumbersInnerDto.JSON_PROPERTY_APPLICATIONKEY,
  GetNumbersResponseObjNumbersInnerDto.JSON_PROPERTY_CAPABILITY
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class GetNumbersResponseObjNumbersInnerDto {
  public static final String JSON_PROPERTY_NUMBER = "number";
  private String number;
  private boolean numberDefined = false;

  public static final String JSON_PROPERTY_APPLICATIONKEY = "applicationkey";
  private String applicationkey;
  private boolean applicationkeyDefined = false;

  /**
   * indicates the DID capability that needs to be assigned to the chosen application. Valid values
   * are &#39;voice&#39; and &#39;sms&#39;. Please note that the DID needs to support the selected
   * capability.
   */
  public enum CapabilityEnum {
    VOICE("voice"),

    SMS("sms"),

    UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

    private String value;

    CapabilityEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static CapabilityEnum fromValue(String value) {
      for (CapabilityEnum b : CapabilityEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return UNKNOWN_DEFAULT_OPEN_API;
    }
  }

  public static final String JSON_PROPERTY_CAPABILITY = "capability";
  private String capability;
  private boolean capabilityDefined = false;

  public GetNumbersResponseObjNumbersInnerDto() {}

  public GetNumbersResponseObjNumbersInnerDto number(String number) {
    this.number = number;
    this.numberDefined = true;
    return this;
  }

  /**
   * Numbers that you own in E.164 format.
   *
   * @return number
   */
  @JsonProperty(JSON_PROPERTY_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getNumber() {
    return number;
  }

  @JsonIgnore
  public boolean getNumberDefined() {
    return numberDefined;
  }

  @JsonProperty(JSON_PROPERTY_NUMBER)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNumber(String number) {
    this.number = number;
    this.numberDefined = true;
  }

  public GetNumbersResponseObjNumbersInnerDto applicationkey(String applicationkey) {
    this.applicationkey = applicationkey;
    this.applicationkeyDefined = true;
    return this;
  }

  /**
   * Indicates the application where the number(s) will be assigned. If no number is assigned the
   * applicationkey will not be returned.
   *
   * @return applicationkey
   */
  @JsonProperty(JSON_PROPERTY_APPLICATIONKEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getApplicationkey() {
    return applicationkey;
  }

  @JsonIgnore
  public boolean getApplicationkeyDefined() {
    return applicationkeyDefined;
  }

  @JsonProperty(JSON_PROPERTY_APPLICATIONKEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setApplicationkey(String applicationkey) {
    this.applicationkey = applicationkey;
    this.applicationkeyDefined = true;
  }

  public GetNumbersResponseObjNumbersInnerDto capability(String capability) {
    this.capability = capability;
    this.capabilityDefined = true;
    return this;
  }

  /**
   * indicates the DID capability that needs to be assigned to the chosen application. Valid values
   * are &#39;voice&#39; and &#39;sms&#39;. Please note that the DID needs to support the selected
   * capability.
   *
   * @return capability
   */
  @JsonProperty(JSON_PROPERTY_CAPABILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCapability() {
    return capability;
  }

  @JsonIgnore
  public boolean getCapabilityDefined() {
    return capabilityDefined;
  }

  @JsonProperty(JSON_PROPERTY_CAPABILITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCapability(String capability) {
    this.capability = capability;
    this.capabilityDefined = true;
  }

  /** Return true if this getNumbersResponseObj_numbers_inner object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetNumbersResponseObjNumbersInnerDto getNumbersResponseObjNumbersInner =
        (GetNumbersResponseObjNumbersInnerDto) o;
    return Objects.equals(this.number, getNumbersResponseObjNumbersInner.number)
        && Objects.equals(this.applicationkey, getNumbersResponseObjNumbersInner.applicationkey)
        && Objects.equals(this.capability, getNumbersResponseObjNumbersInner.capability);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, applicationkey, capability);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetNumbersResponseObjNumbersInnerDto {\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    applicationkey: ").append(toIndentedString(applicationkey)).append("\n");
    sb.append("    capability: ").append(toIndentedString(capability)).append("\n");
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