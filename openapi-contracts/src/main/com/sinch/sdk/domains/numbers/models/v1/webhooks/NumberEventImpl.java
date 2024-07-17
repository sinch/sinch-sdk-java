package com.sinch.sdk.domains.numbers.models.v1.webhooks;

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
  NumberEventImpl.JSON_PROPERTY_EVENT_ID,
  NumberEventImpl.JSON_PROPERTY_TIMESTAMP,
  NumberEventImpl.JSON_PROPERTY_PROJECT_ID,
  NumberEventImpl.JSON_PROPERTY_RESOURCE_ID,
  NumberEventImpl.JSON_PROPERTY_RESOURCE_TYPE,
  NumberEventImpl.JSON_PROPERTY_EVENT_TYPE,
  NumberEventImpl.JSON_PROPERTY_STATUS,
  NumberEventImpl.JSON_PROPERTY_FAILURE_CODE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class NumberEventImpl implements NumberEvent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_EVENT_ID = "eventId";

  private OptionalValue<String> eventId;

  public static final String JSON_PROPERTY_TIMESTAMP = "timestamp";

  private OptionalValue<Instant> timestamp;

  public static final String JSON_PROPERTY_PROJECT_ID = "projectId";

  private OptionalValue<String> projectId;

  public static final String JSON_PROPERTY_RESOURCE_ID = "resourceId";

  private OptionalValue<String> resourceId;

  public static final String JSON_PROPERTY_RESOURCE_TYPE = "resourceType";

  private OptionalValue<ResourceType> resourceType;

  public static final String JSON_PROPERTY_EVENT_TYPE = "eventType";

  private OptionalValue<EventTypeEnum> eventType;

  public static final String JSON_PROPERTY_STATUS = "status";

  private OptionalValue<StatusEnum> status;

  public static final String JSON_PROPERTY_FAILURE_CODE = "failureCode";

  private OptionalValue<FailureCodeEnum> failureCode;

  public NumberEventImpl() {}

  protected NumberEventImpl(
      OptionalValue<String> eventId,
      OptionalValue<Instant> timestamp,
      OptionalValue<String> projectId,
      OptionalValue<String> resourceId,
      OptionalValue<ResourceType> resourceType,
      OptionalValue<EventTypeEnum> eventType,
      OptionalValue<StatusEnum> status,
      OptionalValue<FailureCodeEnum> failureCode) {
    this.eventId = eventId;
    this.timestamp = timestamp;
    this.projectId = projectId;
    this.resourceId = resourceId;
    this.resourceType = resourceType;
    this.eventType = eventType;
    this.status = status;
    this.failureCode = failureCode;
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
  public Instant getTimestamp() {
    return timestamp.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TIMESTAMP)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> timestamp() {
    return timestamp;
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
  public String getResourceId() {
    return resourceId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RESOURCE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> resourceId() {
    return resourceId;
  }

  @JsonIgnore
  public ResourceType getResourceType() {
    return resourceType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RESOURCE_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ResourceType> resourceType() {
    return resourceType;
  }

  @JsonIgnore
  public EventTypeEnum getEventType() {
    return eventType.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EVENT_TYPE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<EventTypeEnum> eventType() {
    return eventType;
  }

  @JsonIgnore
  public StatusEnum getStatus() {
    return status.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<StatusEnum> status() {
    return status;
  }

  @JsonIgnore
  public FailureCodeEnum getFailureCode() {
    return failureCode.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_FAILURE_CODE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<FailureCodeEnum> failureCode() {
    return failureCode;
  }

  /** Return true if this CallbackPayload object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    NumberEventImpl callbackPayload = (NumberEventImpl) o;
    return Objects.equals(this.eventId, callbackPayload.eventId)
        && Objects.equals(this.timestamp, callbackPayload.timestamp)
        && Objects.equals(this.projectId, callbackPayload.projectId)
        && Objects.equals(this.resourceId, callbackPayload.resourceId)
        && Objects.equals(this.resourceType, callbackPayload.resourceType)
        && Objects.equals(this.eventType, callbackPayload.eventType)
        && Objects.equals(this.status, callbackPayload.status)
        && Objects.equals(this.failureCode, callbackPayload.failureCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        eventId, timestamp, projectId, resourceId, resourceType, eventType, status, failureCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class NumberEventImpl {\n");
    sb.append("    eventId: ").append(toIndentedString(eventId)).append("\n");
    sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
    sb.append("    projectId: ").append(toIndentedString(projectId)).append("\n");
    sb.append("    resourceId: ").append(toIndentedString(resourceId)).append("\n");
    sb.append("    resourceType: ").append(toIndentedString(resourceType)).append("\n");
    sb.append("    eventType: ").append(toIndentedString(eventType)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    failureCode: ").append(toIndentedString(failureCode)).append("\n");
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
  static class Builder implements NumberEvent.Builder {
    OptionalValue<String> eventId = OptionalValue.empty();
    OptionalValue<Instant> timestamp = OptionalValue.empty();
    OptionalValue<String> projectId = OptionalValue.empty();
    OptionalValue<String> resourceId = OptionalValue.empty();
    OptionalValue<ResourceType> resourceType = OptionalValue.empty();
    OptionalValue<EventTypeEnum> eventType = OptionalValue.empty();
    OptionalValue<StatusEnum> status = OptionalValue.empty();
    OptionalValue<FailureCodeEnum> failureCode = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_EVENT_ID)
    public Builder setEventId(String eventId) {
      this.eventId = OptionalValue.of(eventId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TIMESTAMP)
    public Builder setTimestamp(Instant timestamp) {
      this.timestamp = OptionalValue.of(timestamp);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PROJECT_ID)
    public Builder setProjectId(String projectId) {
      this.projectId = OptionalValue.of(projectId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_RESOURCE_ID)
    public Builder setResourceId(String resourceId) {
      this.resourceId = OptionalValue.of(resourceId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_RESOURCE_TYPE)
    public Builder setResourceType(ResourceType resourceType) {
      this.resourceType = OptionalValue.of(resourceType);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_EVENT_TYPE)
    public Builder setEventType(EventTypeEnum eventType) {
      this.eventType = OptionalValue.of(eventType);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_STATUS)
    public Builder setStatus(StatusEnum status) {
      this.status = OptionalValue.of(status);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_FAILURE_CODE)
    public Builder setFailureCode(FailureCodeEnum failureCode) {
      this.failureCode = OptionalValue.of(failureCode);
      return this;
    }

    public NumberEvent build() {
      return new NumberEventImpl(
          eventId, timestamp, projectId, resourceId, resourceType, eventType, status, failureCode);
    }
  }
}
