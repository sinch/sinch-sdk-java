package com.sinch.sdk.domains.numbers.models.webhooks;

import com.sinch.sdk.domains.numbers.models.SmsErrorCode;
import java.time.Instant;

/** A notification of an event sent to your configured callback URL. */
public class EventNotification {

  private final String eventId;
  private final Instant timestamp;
  private final String projectId;
  private final String resourceId;
  private final ResourceType resourceType;
  private final EventType eventType;
  private final EventStatus status;
  private final SmsErrorCode failureCode;

  /**
   * @param eventId The ID of the event
   * @param timestamp The date and time when the callback was created and added to the callbacks
   *     queue
   * @param projectId The ID of the project to which the event belongs
   * @param resourceId The unique identifier of the resource, depending on the resource type. For
   *     example, a phone number, a hosting order ID, or a brand ID.
   * @param resourceType The type of the resource
   * @param eventType The type of the event
   * @param status The status of the event
   * @param failureCode If the status is FAILED, a failure code will be provided. For numbers
   *     provisioning to SMS platform, there won't be any extra failureCode, as the result is
   *     binary. For campaign provisioning-related failures, refer to the list for the possible
   *     values.
   */
  public EventNotification(
      String eventId,
      Instant timestamp,
      String projectId,
      String resourceId,
      ResourceType resourceType,
      EventType eventType,
      EventStatus status,
      SmsErrorCode failureCode) {
    this.eventId = eventId;
    this.timestamp = timestamp;
    this.projectId = projectId;
    this.resourceId = resourceId;
    this.resourceType = resourceType;
    this.eventType = eventType;
    this.status = status;
    this.failureCode = failureCode;
  }

  public String getEventId() {
    return eventId;
  }

  public Instant getTimestamp() {
    return timestamp;
  }

  public String getProjectId() {
    return projectId;
  }

  public String getResourceId() {
    return resourceId;
  }

  public ResourceType getResourceType() {
    return resourceType;
  }

  public EventType getEventType() {
    return eventType;
  }

  public EventStatus getStatus() {
    return status;
  }

  public SmsErrorCode getFailureCode() {
    return failureCode;
  }

  @Override
  public String toString() {
    return "EventNotification{"
        + "eventId='"
        + eventId
        + '\''
        + ", timestamp="
        + timestamp
        + ", projectId='"
        + projectId
        + '\''
        + ", resourceId='"
        + resourceId
        + '\''
        + ", resourceType="
        + resourceType
        + ", eventType="
        + eventType
        + ", status="
        + status
        + ", failureCode="
        + failureCode
        + '}';
  }
}
