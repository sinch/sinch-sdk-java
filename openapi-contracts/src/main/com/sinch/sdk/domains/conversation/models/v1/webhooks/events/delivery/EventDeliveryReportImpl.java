package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.delivery;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.Reason;
import java.util.Objects;

@JsonPropertyOrder({
  EventDeliveryReportImpl.JSON_PROPERTY_EVENT_ID,
  EventDeliveryReportImpl.JSON_PROPERTY_STATUS,
  EventDeliveryReportImpl.JSON_PROPERTY_CHANNEL_IDENTITY,
  EventDeliveryReportImpl.JSON_PROPERTY_CONTACT_ID,
  EventDeliveryReportImpl.JSON_PROPERTY_REASON,
  EventDeliveryReportImpl.JSON_PROPERTY_METADATA,
  EventDeliveryReportImpl.JSON_PROPERTY_PROCESSING_MODE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class EventDeliveryReportImpl implements EventDeliveryReport {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_EVENT_ID = "event_id";

  private OptionalValue<String> eventId;

  public static final String JSON_PROPERTY_STATUS = "status";

  private OptionalValue<DeliveryStatus> status;

  public static final String JSON_PROPERTY_CHANNEL_IDENTITY = "channel_identity";

  private OptionalValue<ChannelIdentity> channelIdentity;

  public static final String JSON_PROPERTY_CONTACT_ID = "contact_id";

  private OptionalValue<String> contactId;

  public static final String JSON_PROPERTY_REASON = "reason";

  private OptionalValue<Reason> reason;

  public static final String JSON_PROPERTY_METADATA = "metadata";

  private OptionalValue<String> metadata;

  public static final String JSON_PROPERTY_PROCESSING_MODE = "processing_mode";

  private OptionalValue<ProcessingMode> processingMode;

  public EventDeliveryReportImpl() {}

  protected EventDeliveryReportImpl(
      OptionalValue<String> eventId,
      OptionalValue<DeliveryStatus> status,
      OptionalValue<ChannelIdentity> channelIdentity,
      OptionalValue<String> contactId,
      OptionalValue<Reason> reason,
      OptionalValue<String> metadata,
      OptionalValue<ProcessingMode> processingMode) {
    this.eventId = eventId;
    this.status = status;
    this.channelIdentity = channelIdentity;
    this.contactId = contactId;
    this.reason = reason;
    this.metadata = metadata;
    this.processingMode = processingMode;
  }

  @JsonIgnore
  public String getEventId() {
    return eventId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EVENT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> eventId() {
    return eventId;
  }

  @JsonIgnore
  public DeliveryStatus getStatus() {
    return status.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<DeliveryStatus> status() {
    return status;
  }

  @JsonIgnore
  public ChannelIdentity getChannelIdentity() {
    return channelIdentity.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHANNEL_IDENTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ChannelIdentity> channelIdentity() {
    return channelIdentity;
  }

  @JsonIgnore
  public String getContactId() {
    return contactId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CONTACT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> contactId() {
    return contactId;
  }

  @JsonIgnore
  public Reason getReason() {
    return reason.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REASON)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Reason> reason() {
    return reason;
  }

  @JsonIgnore
  public String getMetadata() {
    return metadata.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> metadata() {
    return metadata;
  }

  @JsonIgnore
  public ProcessingMode getProcessingMode() {
    return processingMode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PROCESSING_MODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ProcessingMode> processingMode() {
    return processingMode;
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
    EventDeliveryReportImpl eventDeliveryAllOfEventDeliveryReport = (EventDeliveryReportImpl) o;
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
    sb.append("class EventDeliveryReportImpl {\n");
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

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements EventDeliveryReport.Builder {
    OptionalValue<String> eventId = OptionalValue.empty();
    OptionalValue<DeliveryStatus> status = OptionalValue.empty();
    OptionalValue<ChannelIdentity> channelIdentity = OptionalValue.empty();
    OptionalValue<String> contactId = OptionalValue.empty();
    OptionalValue<Reason> reason = OptionalValue.empty();
    OptionalValue<String> metadata = OptionalValue.empty();
    OptionalValue<ProcessingMode> processingMode = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_EVENT_ID)
    public Builder setEventId(String eventId) {
      this.eventId = OptionalValue.of(eventId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_STATUS)
    public Builder setStatus(DeliveryStatus status) {
      this.status = OptionalValue.of(status);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CHANNEL_IDENTITY)
    public Builder setChannelIdentity(ChannelIdentity channelIdentity) {
      this.channelIdentity = OptionalValue.of(channelIdentity);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CONTACT_ID)
    public Builder setContactId(String contactId) {
      this.contactId = OptionalValue.of(contactId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_REASON)
    public Builder setReason(Reason reason) {
      this.reason = OptionalValue.of(reason);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_METADATA)
    public Builder setMetadata(String metadata) {
      this.metadata = OptionalValue.of(metadata);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PROCESSING_MODE)
    public Builder setProcessingMode(ProcessingMode processingMode) {
      this.processingMode = OptionalValue.of(processingMode);
      return this;
    }

    public EventDeliveryReport build() {
      return new EventDeliveryReportImpl(
          eventId, status, channelIdentity, contactId, reason, metadata, processingMode);
    }
  }
}
