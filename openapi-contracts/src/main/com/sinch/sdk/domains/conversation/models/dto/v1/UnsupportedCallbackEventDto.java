/*
 * Conversation API | Sinch
 * Send and receive messages globally over SMS, RCS, WhatsApp, Viber Business, Facebook messenger and other popular channels using the Sinch Conversation API.  The Conversation API endpoint uses built-in transcoding to give you the power of conversation across all supported channels and, if required, full control over channel specific features.
 *
 * The version of the OpenAPI document: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.LocalDate;
import java.util.Objects;

/**
 * Some of the callbacks received from the underlying channels might be specific to a single channel
 * or may not have a proper mapping in Conversation API yet.
 */
@JsonPropertyOrder({
  UnsupportedCallbackEventDto.JSON_PROPERTY_APP_ID,
  UnsupportedCallbackEventDto.JSON_PROPERTY_ACCEPTED_TIME,
  UnsupportedCallbackEventDto.JSON_PROPERTY_EVENT_TIME,
  UnsupportedCallbackEventDto.JSON_PROPERTY_PROJECT_ID,
  UnsupportedCallbackEventDto.JSON_PROPERTY_MESSAGE_METADATA,
  UnsupportedCallbackEventDto.JSON_PROPERTY_CORRELATION_ID,
  UnsupportedCallbackEventDto.JSON_PROPERTY_UNSUPPORTED_CALLBACK
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class UnsupportedCallbackEventDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_APP_ID = "app_id";
  private String appId;
  private boolean appIdDefined = false;

  public static final String JSON_PROPERTY_ACCEPTED_TIME = "accepted_time";
  private LocalDate acceptedTime;
  private boolean acceptedTimeDefined = false;

  public static final String JSON_PROPERTY_EVENT_TIME = "event_time";
  private LocalDate eventTime;
  private boolean eventTimeDefined = false;

  public static final String JSON_PROPERTY_PROJECT_ID = "project_id";
  private String projectId;
  private boolean projectIdDefined = false;

  public static final String JSON_PROPERTY_MESSAGE_METADATA = "message_metadata";
  private String messageMetadata;
  private boolean messageMetadataDefined = false;

  public static final String JSON_PROPERTY_CORRELATION_ID = "correlation_id";
  private String correlationId;
  private boolean correlationIdDefined = false;

  public static final String JSON_PROPERTY_UNSUPPORTED_CALLBACK = "unsupported_callback";
  private UnsupportedCallbackEventAllOfUnsupportedCallbackDto unsupportedCallback;
  private boolean unsupportedCallbackDefined = false;

  public UnsupportedCallbackEventDto() {}

  public UnsupportedCallbackEventDto appId(String appId) {
    this.appId = appId;
    this.appIdDefined = true;
    return this;
  }

  /**
   * Id of the subscribed app.
   *
   * @return appId
   */
  @JsonProperty(JSON_PROPERTY_APP_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getAppId() {
    return appId;
  }

  @JsonIgnore
  public boolean getAppIdDefined() {
    return appIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_APP_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAppId(String appId) {
    this.appId = appId;
    this.appIdDefined = true;
  }

  public UnsupportedCallbackEventDto acceptedTime(LocalDate acceptedTime) {
    this.acceptedTime = acceptedTime;
    this.acceptedTimeDefined = true;
    return this;
  }

  /**
   * Timestamp marking when the channel callback was accepted/received by the Conversation API.
   *
   * @return acceptedTime
   */
  @JsonProperty(JSON_PROPERTY_ACCEPTED_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public LocalDate getAcceptedTime() {
    return acceptedTime;
  }

  @JsonIgnore
  public boolean getAcceptedTimeDefined() {
    return acceptedTimeDefined;
  }

  @JsonProperty(JSON_PROPERTY_ACCEPTED_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAcceptedTime(LocalDate acceptedTime) {
    this.acceptedTime = acceptedTime;
    this.acceptedTimeDefined = true;
  }

  public UnsupportedCallbackEventDto eventTime(LocalDate eventTime) {
    this.eventTime = eventTime;
    this.eventTimeDefined = true;
    return this;
  }

  /**
   * Timestamp of the event as provided by the underlying channels.
   *
   * @return eventTime
   */
  @JsonProperty(JSON_PROPERTY_EVENT_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public LocalDate getEventTime() {
    return eventTime;
  }

  @JsonIgnore
  public boolean getEventTimeDefined() {
    return eventTimeDefined;
  }

  @JsonProperty(JSON_PROPERTY_EVENT_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEventTime(LocalDate eventTime) {
    this.eventTime = eventTime;
    this.eventTimeDefined = true;
  }

  public UnsupportedCallbackEventDto projectId(String projectId) {
    this.projectId = projectId;
    this.projectIdDefined = true;
    return this;
  }

  /**
   * The project ID of the app which has subscribed for the callback.
   *
   * @return projectId
   */
  @JsonProperty(JSON_PROPERTY_PROJECT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getProjectId() {
    return projectId;
  }

  @JsonIgnore
  public boolean getProjectIdDefined() {
    return projectIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_PROJECT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setProjectId(String projectId) {
    this.projectId = projectId;
    this.projectIdDefined = true;
  }

  public UnsupportedCallbackEventDto messageMetadata(String messageMetadata) {
    this.messageMetadata = messageMetadata;
    this.messageMetadataDefined = true;
    return this;
  }

  /**
   * Context-dependent metadata. Refer to specific callback&#39;s documentation for exact
   * information provided.
   *
   * @return messageMetadata
   */
  @JsonProperty(JSON_PROPERTY_MESSAGE_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getMessageMetadata() {
    return messageMetadata;
  }

  @JsonIgnore
  public boolean getMessageMetadataDefined() {
    return messageMetadataDefined;
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMessageMetadata(String messageMetadata) {
    this.messageMetadata = messageMetadata;
    this.messageMetadataDefined = true;
  }

  public UnsupportedCallbackEventDto correlationId(String correlationId) {
    this.correlationId = correlationId;
    this.correlationIdDefined = true;
    return this;
  }

  /**
   * The value provided in field correlation_id of a send message request.
   *
   * @return correlationId
   */
  @JsonProperty(JSON_PROPERTY_CORRELATION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getCorrelationId() {
    return correlationId;
  }

  @JsonIgnore
  public boolean getCorrelationIdDefined() {
    return correlationIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_CORRELATION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setCorrelationId(String correlationId) {
    this.correlationId = correlationId;
    this.correlationIdDefined = true;
  }

  public UnsupportedCallbackEventDto unsupportedCallback(
      UnsupportedCallbackEventAllOfUnsupportedCallbackDto unsupportedCallback) {
    this.unsupportedCallback = unsupportedCallback;
    this.unsupportedCallbackDefined = true;
    return this;
  }

  /**
   * Get unsupportedCallback
   *
   * @return unsupportedCallback
   */
  @JsonProperty(JSON_PROPERTY_UNSUPPORTED_CALLBACK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public UnsupportedCallbackEventAllOfUnsupportedCallbackDto getUnsupportedCallback() {
    return unsupportedCallback;
  }

  @JsonIgnore
  public boolean getUnsupportedCallbackDefined() {
    return unsupportedCallbackDefined;
  }

  @JsonProperty(JSON_PROPERTY_UNSUPPORTED_CALLBACK)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setUnsupportedCallback(
      UnsupportedCallbackEventAllOfUnsupportedCallbackDto unsupportedCallback) {
    this.unsupportedCallback = unsupportedCallback;
    this.unsupportedCallbackDefined = true;
  }

  /** Return true if this UnsupportedCallbackEvent object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    UnsupportedCallbackEventDto unsupportedCallbackEvent = (UnsupportedCallbackEventDto) o;
    return Objects.equals(this.appId, unsupportedCallbackEvent.appId)
        && Objects.equals(this.acceptedTime, unsupportedCallbackEvent.acceptedTime)
        && Objects.equals(this.eventTime, unsupportedCallbackEvent.eventTime)
        && Objects.equals(this.projectId, unsupportedCallbackEvent.projectId)
        && Objects.equals(this.messageMetadata, unsupportedCallbackEvent.messageMetadata)
        && Objects.equals(this.correlationId, unsupportedCallbackEvent.correlationId)
        && Objects.equals(this.unsupportedCallback, unsupportedCallbackEvent.unsupportedCallback);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        appId,
        acceptedTime,
        eventTime,
        projectId,
        messageMetadata,
        correlationId,
        unsupportedCallback);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class UnsupportedCallbackEventDto {\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    acceptedTime: ").append(toIndentedString(acceptedTime)).append("\n");
    sb.append("    eventTime: ").append(toIndentedString(eventTime)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    messageMetadata: ").append(toIndentedString(messageMetadata)).append("\n");
    sb.append("    correlationId: ").append(toIndentedString(correlationId)).append("\n");
    sb.append("    unsupportedCallback: ")
        .append(toIndentedString(unsupportedCallback))
        .append("\n");
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