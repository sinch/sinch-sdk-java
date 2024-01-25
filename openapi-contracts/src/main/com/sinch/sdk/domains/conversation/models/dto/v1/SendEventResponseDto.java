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

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.time.OffsetDateTime;
import java.util.Objects;

/** SendEventResponseDto */
@JsonPropertyOrder({
  SendEventResponseDto.JSON_PROPERTY_ACCEPTED_TIME,
  SendEventResponseDto.JSON_PROPERTY_EVENT_ID
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class SendEventResponseDto {
  public static final String JSON_PROPERTY_ACCEPTED_TIME = "accepted_time";
  private OffsetDateTime acceptedTime;
  private boolean acceptedTimeDefined = false;

  public static final String JSON_PROPERTY_EVENT_ID = "event_id";
  private String eventId;
  private boolean eventIdDefined = false;

  public SendEventResponseDto() {}

  @JsonCreator
  public SendEventResponseDto(
      @JsonProperty(JSON_PROPERTY_ACCEPTED_TIME) OffsetDateTime acceptedTime,
      @JsonProperty(JSON_PROPERTY_EVENT_ID) String eventId) {
    this();
    this.acceptedTime = acceptedTime;
    this.acceptedTimeDefined = true;
    this.eventId = eventId;
    this.eventIdDefined = true;
  }

  /**
   * Accepted timestamp.
   *
   * @return acceptedTime
   */
  @JsonProperty(JSON_PROPERTY_ACCEPTED_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OffsetDateTime getAcceptedTime() {
    return acceptedTime;
  }

  @JsonIgnore
  public boolean getAcceptedTimeDefined() {
    return acceptedTimeDefined;
  }

  /**
   * Event id.
   *
   * @return eventId
   */
  @JsonProperty(JSON_PROPERTY_EVENT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getEventId() {
    return eventId;
  }

  @JsonIgnore
  public boolean getEventIdDefined() {
    return eventIdDefined;
  }

  /** Return true if this SendEventResponse object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    SendEventResponseDto sendEventResponse = (SendEventResponseDto) o;
    return Objects.equals(this.acceptedTime, sendEventResponse.acceptedTime)
        && Objects.equals(this.eventId, sendEventResponse.eventId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(acceptedTime, eventId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class SendEventResponseDto {\n");
    sb.append("    acceptedTime: ").append(toIndentedString(acceptedTime)).append("\n");
    sb.append("    eventId: ").append(toIndentedString(eventId)).append("\n");
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
