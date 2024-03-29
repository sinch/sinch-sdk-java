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

/**
 * Connects an incoming call to a conference. Available to use in a response to an [Incoming Call
 * Event](../../voice/tag/Callbacks/#tag/Callbacks/operation/ice) callback.
 */
@JsonPropertyOrder({
  SvamlActionConnectConfDto.JSON_PROPERTY_NAME,
  SvamlActionConnectConfDto.JSON_PROPERTY_CONFERENCE_ID,
  SvamlActionConnectConfDto.JSON_PROPERTY_CONFERENCE_DTMF_OPTIONS,
  SvamlActionConnectConfDto.JSON_PROPERTY_MOH
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SvamlActionConnectConfDto {
  private static final long serialVersionUID = 1L;

  /** The name property. Must have the value &#x60;connectConf&#x60;. */
  public enum NameEnum {
    CONNECTCONF("connectConf"),

    UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

    private String value;

    NameEnum(String value) {
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
    public static NameEnum fromValue(String value) {
      for (NameEnum b : NameEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return UNKNOWN_DEFAULT_OPEN_API;
    }
  }

  public static final String JSON_PROPERTY_NAME = "name";
  private String name;
  private boolean nameDefined = false;

  public static final String JSON_PROPERTY_CONFERENCE_ID = "conferenceId";
  private String conferenceId;
  private boolean conferenceIdDefined = false;

  public static final String JSON_PROPERTY_CONFERENCE_DTMF_OPTIONS = "conferenceDtmfOptions";
  private SvamlActionConnectConfConferenceDtmfOptionsDto conferenceDtmfOptions;
  private boolean conferenceDtmfOptionsDefined = false;

  public static final String JSON_PROPERTY_MOH = "moh";
  private String moh;
  private boolean mohDefined = false;

  public SvamlActionConnectConfDto() {}

  public SvamlActionConnectConfDto name(String name) {
    this.name = name;
    this.nameDefined = true;
    return this;
  }

  /**
   * The name property. Must have the value &#x60;connectConf&#x60;.
   *
   * @return name
   */
  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getName() {
    return name;
  }

  @JsonIgnore
  public boolean getNameDefined() {
    return nameDefined;
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setName(String name) {
    this.name = name;
    this.nameDefined = true;
  }

  public SvamlActionConnectConfDto conferenceId(String conferenceId) {
    this.conferenceId = conferenceId;
    this.conferenceIdDefined = true;
    return this;
  }

  /**
   * The unique identifier of the conference. Shouldn&#39;t exceed 64 characters.
   *
   * @return conferenceId
   */
  @JsonProperty(JSON_PROPERTY_CONFERENCE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getConferenceId() {
    return conferenceId;
  }

  @JsonIgnore
  public boolean getConferenceIdDefined() {
    return conferenceIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_CONFERENCE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setConferenceId(String conferenceId) {
    this.conferenceId = conferenceId;
    this.conferenceIdDefined = true;
  }

  public SvamlActionConnectConfDto conferenceDtmfOptions(
      SvamlActionConnectConfConferenceDtmfOptionsDto conferenceDtmfOptions) {
    this.conferenceDtmfOptions = conferenceDtmfOptions;
    this.conferenceDtmfOptionsDefined = true;
    return this;
  }

  /**
   * Get conferenceDtmfOptions
   *
   * @return conferenceDtmfOptions
   */
  @JsonProperty(JSON_PROPERTY_CONFERENCE_DTMF_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public SvamlActionConnectConfConferenceDtmfOptionsDto getConferenceDtmfOptions() {
    return conferenceDtmfOptions;
  }

  @JsonIgnore
  public boolean getConferenceDtmfOptionsDefined() {
    return conferenceDtmfOptionsDefined;
  }

  @JsonProperty(JSON_PROPERTY_CONFERENCE_DTMF_OPTIONS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setConferenceDtmfOptions(
      SvamlActionConnectConfConferenceDtmfOptionsDto conferenceDtmfOptions) {
    this.conferenceDtmfOptions = conferenceDtmfOptions;
    this.conferenceDtmfOptionsDefined = true;
  }

  public SvamlActionConnectConfDto moh(String moh) {
    this.moh = moh;
    this.mohDefined = true;
    return this;
  }

  /**
   * Means \&quot;music on hold\&quot;. If this optional parameter is included, plays music to the
   * first participant in a conference while they&#39;re alone and waiting for other participants to
   * join. If &#x60;moh&#x60; isn&#39;t specified, the user will only hear silence while alone in
   * the conference.
   *
   * @return moh
   */
  @JsonProperty(JSON_PROPERTY_MOH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getMoh() {
    return moh;
  }

  @JsonIgnore
  public boolean getMohDefined() {
    return mohDefined;
  }

  @JsonProperty(JSON_PROPERTY_MOH)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMoh(String moh) {
    this.moh = moh;
    this.mohDefined = true;
  }

  /** Return true if this svaml.action.connectConf object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SvamlActionConnectConfDto svamlActionConnectConf = (SvamlActionConnectConfDto) o;
    return Objects.equals(this.name, svamlActionConnectConf.name)
        && Objects.equals(this.conferenceId, svamlActionConnectConf.conferenceId)
        && Objects.equals(this.conferenceDtmfOptions, svamlActionConnectConf.conferenceDtmfOptions)
        && Objects.equals(this.moh, svamlActionConnectConf.moh);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, conferenceId, conferenceDtmfOptions, moh);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SvamlActionConnectConfDto {\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    conferenceId: ").append(toIndentedString(conferenceId)).append("\n");
    sb.append("    conferenceDtmfOptions: ")
        .append(toIndentedString(conferenceDtmfOptions))
        .append("\n");
    sb.append("    moh: ").append(toIndentedString(moh)).append("\n");
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
