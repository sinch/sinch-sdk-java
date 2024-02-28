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
import java.util.Objects;

/** EventDeliveryAllOfEventDeliveryReportDto */
@JsonPropertyOrder({
  EventDeliveryAllOfEventDeliveryReportDto.JSON_PROPERTY_EVENT_ID,
  EventDeliveryAllOfEventDeliveryReportDto.JSON_PROPERTY_STATUS,
  EventDeliveryAllOfEventDeliveryReportDto.JSON_PROPERTY_CHANNEL_IDENTITY,
  EventDeliveryAllOfEventDeliveryReportDto.JSON_PROPERTY_CONTACT_ID,
  EventDeliveryAllOfEventDeliveryReportDto.JSON_PROPERTY_REASON,
  EventDeliveryAllOfEventDeliveryReportDto.JSON_PROPERTY_METADATA,
  EventDeliveryAllOfEventDeliveryReportDto.JSON_PROPERTY_PROCESSING_MODE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class EventDeliveryAllOfEventDeliveryReportDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_EVENT_ID = "event_id";
  private String eventId;
  private boolean eventIdDefined = false;

  public static final String JSON_PROPERTY_STATUS = "status";
  private DeliveryStatusDto status;
  private boolean statusDefined = false;

  public static final String JSON_PROPERTY_CHANNEL_IDENTITY = "channel_identity";
  private ChannelIdentityDto channelIdentity;
  private boolean channelIdentityDefined = false;

  public static final String JSON_PROPERTY_CONTACT_ID = "contact_id";
  private String contactId;
  private boolean contactIdDefined = false;

  public static final String JSON_PROPERTY_REASON = "reason";
  private ReasonDto reason;
  private boolean reasonDefined = false;

  public static final String JSON_PROPERTY_METADATA = "metadata";
  private String metadata;
  private boolean metadataDefined = false;

  public static final String JSON_PROPERTY_PROCESSING_MODE = "processing_mode";
  private ProcessingModeDto processingMode;
  private boolean processingModeDefined = false;

  public EventDeliveryAllOfEventDeliveryReportDto() {}

  public EventDeliveryAllOfEventDeliveryReportDto eventId(String eventId) {
    this.eventId = eventId;
    this.eventIdDefined = true;
    return this;
  }

  /**
   * The ID of the app event.
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

  @JsonProperty(JSON_PROPERTY_EVENT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEventId(String eventId) {
    this.eventId = eventId;
    this.eventIdDefined = true;
  }

  public EventDeliveryAllOfEventDeliveryReportDto status(DeliveryStatusDto status) {
    this.status = status;
    this.statusDefined = true;
    return this;
  }

  /**
   * Get status
   *
   * @return status
   */
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public DeliveryStatusDto getStatus() {
    return status;
  }

  @JsonIgnore
  public boolean getStatusDefined() {
    return statusDefined;
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setStatus(DeliveryStatusDto status) {
    this.status = status;
    this.statusDefined = true;
  }

  public EventDeliveryAllOfEventDeliveryReportDto channelIdentity(
      ChannelIdentityDto channelIdentity) {
    this.channelIdentity = channelIdentity;
    this.channelIdentityDefined = true;
    return this;
  }

  /**
   * Get channelIdentity
   *
   * @return channelIdentity
   */
  @JsonProperty(JSON_PROPERTY_CHANNEL_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public ChannelIdentityDto getChannelIdentity() {
    return channelIdentity;
  }

  @JsonIgnore
  public boolean getChannelIdentityDefined() {
    return channelIdentityDefined;
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setChannelIdentity(ChannelIdentityDto channelIdentity) {
    this.channelIdentity = channelIdentity;
    this.channelIdentityDefined = true;
  }

  public EventDeliveryAllOfEventDeliveryReportDto contactId(String contactId) {
    this.contactId = contactId;
    this.contactIdDefined = true;
    return this;
  }

  /**
   * The ID of the contact. Will be empty if processing_mode is DISPATCH.
   *
   * @return contactId
   */
  @JsonProperty(JSON_PROPERTY_CONTACT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getContactId() {
    return contactId;
  }

  @JsonIgnore
  public boolean getContactIdDefined() {
    return contactIdDefined;
  }

  @JsonProperty(JSON_PROPERTY_CONTACT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setContactId(String contactId) {
    this.contactId = contactId;
    this.contactIdDefined = true;
  }

  public EventDeliveryAllOfEventDeliveryReportDto reason(ReasonDto reason) {
    this.reason = reason;
    this.reasonDefined = true;
    return this;
  }

  /**
   * Get reason
   *
   * @return reason
   */
  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public ReasonDto getReason() {
    return reason;
  }

  @JsonIgnore
  public boolean getReasonDefined() {
    return reasonDefined;
  }

  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setReason(ReasonDto reason) {
    this.reason = reason;
    this.reasonDefined = true;
  }

  public EventDeliveryAllOfEventDeliveryReportDto metadata(String metadata) {
    this.metadata = metadata;
    this.metadataDefined = true;
    return this;
  }

  /**
   * Metadata specified when sending the event if any.
   *
   * @return metadata
   */
  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getMetadata() {
    return metadata;
  }

  @JsonIgnore
  public boolean getMetadataDefined() {
    return metadataDefined;
  }

  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setMetadata(String metadata) {
    this.metadata = metadata;
    this.metadataDefined = true;
  }

  public EventDeliveryAllOfEventDeliveryReportDto processingMode(ProcessingModeDto processingMode) {
    this.processingMode = processingMode;
    this.processingModeDefined = true;
    return this;
  }

  /**
   * Get processingMode
   *
   * @return processingMode
   */
  @JsonProperty(JSON_PROPERTY_PROCESSING_MODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public ProcessingModeDto getProcessingMode() {
    return processingMode;
  }

  @JsonIgnore
  public boolean getProcessingModeDefined() {
    return processingModeDefined;
  }

  @JsonProperty(JSON_PROPERTY_PROCESSING_MODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setProcessingMode(ProcessingModeDto processingMode) {
    this.processingMode = processingMode;
    this.processingModeDefined = true;
  }

  /** Return true if this EventDelivery_allOf_event_delivery_report object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventDeliveryAllOfEventDeliveryReportDto eventDeliveryAllOfEventDeliveryReport =
        (EventDeliveryAllOfEventDeliveryReportDto) o;
    return Objects.equals(this.eventId, eventDeliveryAllOfEventDeliveryReport.eventId)
        && Objects.equals(this.status, eventDeliveryAllOfEventDeliveryReport.status)
        && Objects.equals(
            this.channelIdentity, eventDeliveryAllOfEventDeliveryReport.channelIdentity)
        && Objects.equals(this.contactId, eventDeliveryAllOfEventDeliveryReport.contactId)
        && Objects.equals(this.reason, eventDeliveryAllOfEventDeliveryReport.reason)
        && Objects.equals(this.metadata, eventDeliveryAllOfEventDeliveryReport.metadata)
        && Objects.equals(
            this.processingMode, eventDeliveryAllOfEventDeliveryReport.processingMode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        eventId, status, channelIdentity, contactId, reason, metadata, processingMode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventDeliveryAllOfEventDeliveryReportDto {\n");
    sb.append("    eventId: ").append(toIndentedString(eventId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    channelIdentity: ").append(toIndentedString(channelIdentity)).append("\n");
    sb.append("    contactId: ").append(toIndentedString(contactId)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
    sb.append("    metadata: ").append(toIndentedString(metadata)).append("\n");
    sb.append("    processingMode: ").append(toIndentedString(processingMode)).append("\n");
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