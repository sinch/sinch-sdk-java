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

/** The request body of a Prompt Input Event. */
@JsonPropertyOrder({
  PieRequestDto.JSON_PROPERTY_EVENT,
  PieRequestDto.JSON_PROPERTY_CALL_ID,
  PieRequestDto.JSON_PROPERTY_TIMESTAMP,
  PieRequestDto.JSON_PROPERTY_MENU_RESULT,
  PieRequestDto.JSON_PROPERTY_VERSION,
  PieRequestDto.JSON_PROPERTY_APPLICATION_KEY
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class PieRequestDto {
  public static final String JSON_PROPERTY_EVENT = "event";
  private String event;
  private boolean eventDefined = false;

  public static final String JSON_PROPERTY_CALL_ID = "callId";
  private String callId;
  private boolean callIdDefined = false;

  public static final String JSON_PROPERTY_TIMESTAMP = "timestamp";
  private String timestamp;
  private boolean timestampDefined = false;

  public static final String JSON_PROPERTY_MENU_RESULT = "menuResult";
  private PieRequestMenuResultDto menuResult;
  private boolean menuResultDefined = false;

  public static final String JSON_PROPERTY_VERSION = "version";
  private Integer version;
  private boolean versionDefined = false;

  public static final String JSON_PROPERTY_APPLICATION_KEY = "applicationKey";
  private String applicationKey;
  private boolean applicationKeyDefined = false;

  public PieRequestDto() {}

  public PieRequestDto event(String event) {
    this.event = event;
    this.eventDefined = true;
    return this;
  }

  /**
   * Must have the value &#x60;pie&#x60;.
   *
   * @return event
   */
  @JsonProperty(JSON_PROPERTY_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getEvent() {
    return event;
  }

  @JsonIgnore
  public boolean getEventDefined() {
    return eventDefined;
  }

  @JsonProperty(JSON_PROPERTY_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEvent(String event) {
    this.event = event;
    this.eventDefined = true;
  }

  public PieRequestDto callId(String callId) {
    this.callId = callId;
    this.callIdDefined = true;
    return this;
  }

  /**
   * The unique ID assigned to this call.
   *
   * @return callId
   */
  @JsonProperty(JSON_PROPERTY_CALL_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCallId() {
    return callId;
  }

  @JsonIgnore
  public boolean getCallIdDefined() {
    return callIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_CALL_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCallId(String callId) {
    this.callId = callId;
    this.callIdDefined = true;
  }

  public PieRequestDto timestamp(String timestamp) {
    this.timestamp = timestamp;
    this.timestampDefined = true;
    return this;
  }

  /**
   * The timestamp in UTC format.
   *
   * @return timestamp
   */
  @JsonProperty(JSON_PROPERTY_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getTimestamp() {
    return timestamp;
  }

  @JsonIgnore
  public boolean getTimestampDefined() {
    return timestampDefined;
  }

  @JsonProperty(JSON_PROPERTY_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
    this.timestampDefined = true;
  }

  public PieRequestDto menuResult(PieRequestMenuResultDto menuResult) {
    this.menuResult = menuResult;
    this.menuResultDefined = true;
    return this;
  }

  /**
   * Get menuResult
   *
   * @return menuResult
   */
  @JsonProperty(JSON_PROPERTY_MENU_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public PieRequestMenuResultDto getMenuResult() {
    return menuResult;
  }

  @JsonIgnore
  public boolean getMenuResultDefined() {
    return menuResultDefined;
  }

  @JsonProperty(JSON_PROPERTY_MENU_RESULT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMenuResult(PieRequestMenuResultDto menuResult) {
    this.menuResult = menuResult;
    this.menuResultDefined = true;
  }

  public PieRequestDto version(Integer version) {
    this.version = version;
    this.versionDefined = true;
    return this;
  }

  /**
   * The current API version.
   *
   * @return version
   */
  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getVersion() {
    return version;
  }

  @JsonIgnore
  public boolean getVersionDefined() {
    return versionDefined;
  }

  @JsonProperty(JSON_PROPERTY_VERSION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setVersion(Integer version) {
    this.version = version;
    this.versionDefined = true;
  }

  public PieRequestDto applicationKey(String applicationKey) {
    this.applicationKey = applicationKey;
    this.applicationKeyDefined = true;
    return this;
  }

  /**
   * The unique application key. You can find it in the Sinch
   * [dashboard](https://dashboard.sinch.com/voice/apps).
   *
   * @return applicationKey
   */
  @JsonProperty(JSON_PROPERTY_APPLICATION_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getApplicationKey() {
    return applicationKey;
  }

  @JsonIgnore
  public boolean getApplicationKeyDefined() {
    return applicationKeyDefined;
  }

  @JsonProperty(JSON_PROPERTY_APPLICATION_KEY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setApplicationKey(String applicationKey) {
    this.applicationKey = applicationKey;
    this.applicationKeyDefined = true;
  }

  /** Return true if this pieRequest object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PieRequestDto pieRequest = (PieRequestDto) o;
    return Objects.equals(this.event, pieRequest.event)
        && Objects.equals(this.callId, pieRequest.callId)
        && Objects.equals(this.timestamp, pieRequest.timestamp)
        && Objects.equals(this.menuResult, pieRequest.menuResult)
        && Objects.equals(this.version, pieRequest.version)
        && Objects.equals(this.applicationKey, pieRequest.applicationKey);
  }

  @Override
  public int hashCode() {
    return Objects.hash(event, callId, timestamp, menuResult, version, applicationKey);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PieRequestDto {\n");
    sb.append("    event: ").append(toIndentedString(event)).append("\n");
    sb.append("    callId: ").append(toIndentedString(callId)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    menuResult: ").append(toIndentedString(menuResult)).append("\n");
    sb.append("    version: ").append(toIndentedString(version)).append("\n");
    sb.append("    applicationKey: ").append(toIndentedString(applicationKey)).append("\n");
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
