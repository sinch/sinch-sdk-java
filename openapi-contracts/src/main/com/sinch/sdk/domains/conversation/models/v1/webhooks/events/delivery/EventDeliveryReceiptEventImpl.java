package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.delivery;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.time.Instant;
import java.util.Objects;

@JsonPropertyOrder({
  EventDeliveryReceiptEventImpl.JSON_PROPERTY_APP_ID,
  EventDeliveryReceiptEventImpl.JSON_PROPERTY_ACCEPTED_TIME,
  EventDeliveryReceiptEventImpl.JSON_PROPERTY_EVENT_TIME,
  EventDeliveryReceiptEventImpl.JSON_PROPERTY_PROJECT_ID,
  EventDeliveryReceiptEventImpl.JSON_PROPERTY_MESSAGE_METADATA,
  EventDeliveryReceiptEventImpl.JSON_PROPERTY_CORRELATION_ID,
  EventDeliveryReceiptEventImpl.JSON_PROPERTY_EVENT_DELIVERY_REPORT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class EventDeliveryReceiptEventImpl
    implements EventDeliveryReceiptEvent,
        com.sinch.sdk.domains.conversation.models.v1.webhooks.events.ConversationWebhookEvent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_APP_ID = "app_id";

  private OptionalValue<String> appId;

  public static final String JSON_PROPERTY_ACCEPTED_TIME = "accepted_time";

  private OptionalValue<Instant> acceptedTime;

  public static final String JSON_PROPERTY_EVENT_TIME = "event_time";

  private OptionalValue<Instant> eventTime;

  public static final String JSON_PROPERTY_PROJECT_ID = "project_id";

  private OptionalValue<String> projectId;

  public static final String JSON_PROPERTY_MESSAGE_METADATA = "message_metadata";

  private OptionalValue<String> messageMetadata;

  public static final String JSON_PROPERTY_CORRELATION_ID = "correlation_id";

  private OptionalValue<String> correlationId;

  public static final String JSON_PROPERTY_EVENT_DELIVERY_REPORT = "event_delivery_report";

  private OptionalValue<EventDeliveryReport> report;

  public EventDeliveryReceiptEventImpl() {}

  protected EventDeliveryReceiptEventImpl(
      OptionalValue<String> appId,
      OptionalValue<Instant> acceptedTime,
      OptionalValue<Instant> eventTime,
      OptionalValue<String> projectId,
      OptionalValue<String> messageMetadata,
      OptionalValue<String> correlationId,
      OptionalValue<EventDeliveryReport> report) {
    this.appId = appId;
    this.acceptedTime = acceptedTime;
    this.eventTime = eventTime;
    this.projectId = projectId;
    this.messageMetadata = messageMetadata;
    this.correlationId = correlationId;
    this.report = report;
  }

  @JsonIgnore
  public String getAppId() {
    return appId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_APP_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> appId() {
    return appId;
  }

  @JsonIgnore
  public Instant getAcceptedTime() {
    return acceptedTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ACCEPTED_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> acceptedTime() {
    return acceptedTime;
  }

  @JsonIgnore
  public Instant getEventTime() {
    return eventTime.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EVENT_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> eventTime() {
    return eventTime;
  }

  @JsonIgnore
  public String getProjectId() {
    return projectId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PROJECT_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> projectId() {
    return projectId;
  }

  @JsonIgnore
  public String getMessageMetadata() {
    return messageMetadata.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MESSAGE_METADATA)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> messageMetadata() {
    return messageMetadata;
  }

  @JsonIgnore
  public String getCorrelationId() {
    return correlationId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CORRELATION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> correlationId() {
    return correlationId;
  }

  @JsonIgnore
  public EventDeliveryReport getReport() {
    return report.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EVENT_DELIVERY_REPORT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<EventDeliveryReport> report() {
    return report;
  }

  /** Return true if this EventDelivery object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EventDeliveryReceiptEventImpl eventDelivery = (EventDeliveryReceiptEventImpl) o;
    return Objects.equals(this.appId, eventDelivery.appId)
        && Objects.equals(this.acceptedTime, eventDelivery.acceptedTime)
        && Objects.equals(this.eventTime, eventDelivery.eventTime)
        && Objects.equals(this.projectId, eventDelivery.projectId)
        && Objects.equals(this.messageMetadata, eventDelivery.messageMetadata)
        && Objects.equals(this.correlationId, eventDelivery.correlationId)
        && Objects.equals(this.report, eventDelivery.report);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        appId, acceptedTime, eventTime, projectId, messageMetadata, correlationId, report);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EventDeliveryReceiptEventImpl {\n");
    sb.append("    appId: ").append(toIndentedString(appId)).append("\n");
    sb.append("    acceptedTime: ").append(toIndentedString(acceptedTime)).append("\n");
    sb.append("    eventTime: ").append(toIndentedString(eventTime)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    messageMetadata: ").append(toIndentedString(messageMetadata)).append("\n");
    sb.append("    correlationId: ").append(toIndentedString(correlationId)).append("\n");
    sb.append("    report: ").append(toIndentedString(report)).append("\n");
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
  static class Builder implements EventDeliveryReceiptEvent.Builder {
    OptionalValue<String> appId = OptionalValue.empty();
    OptionalValue<Instant> acceptedTime = OptionalValue.empty();
    OptionalValue<Instant> eventTime = OptionalValue.empty();
    OptionalValue<String> projectId = OptionalValue.empty();
    OptionalValue<String> messageMetadata = OptionalValue.empty();
    OptionalValue<String> correlationId = OptionalValue.empty();
    OptionalValue<EventDeliveryReport> report = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_APP_ID)
    public Builder setAppId(String appId) {
      this.appId = OptionalValue.of(appId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ACCEPTED_TIME)
    public Builder setAcceptedTime(Instant acceptedTime) {
      this.acceptedTime = OptionalValue.of(acceptedTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_EVENT_TIME)
    public Builder setEventTime(Instant eventTime) {
      this.eventTime = OptionalValue.of(eventTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PROJECT_ID)
    public Builder setProjectId(String projectId) {
      this.projectId = OptionalValue.of(projectId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MESSAGE_METADATA)
    public Builder setMessageMetadata(String messageMetadata) {
      this.messageMetadata = OptionalValue.of(messageMetadata);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CORRELATION_ID)
    public Builder setCorrelationId(String correlationId) {
      this.correlationId = OptionalValue.of(correlationId);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_EVENT_DELIVERY_REPORT, required = true)
    public Builder setReport(EventDeliveryReport report) {
      this.report = OptionalValue.of(report);
      return this;
    }

    public EventDeliveryReceiptEvent build() {
      return new EventDeliveryReceiptEventImpl(
          appId, acceptedTime, eventTime, projectId, messageMetadata, correlationId, report);
    }
  }
}
