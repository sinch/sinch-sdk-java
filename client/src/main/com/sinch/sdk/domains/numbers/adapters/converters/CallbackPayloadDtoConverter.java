package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.domains.numbers.models.SmsErrorCode;
import com.sinch.sdk.domains.numbers.models.dto.v1.CallbackPayloadDto;
import com.sinch.sdk.domains.numbers.models.webhooks.EventNotification;
import com.sinch.sdk.domains.numbers.models.webhooks.EventStatus;
import com.sinch.sdk.domains.numbers.models.webhooks.EventType;
import com.sinch.sdk.domains.numbers.models.webhooks.ResourceType;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeParseException;

public class CallbackPayloadDtoConverter {

  public static EventNotification convert(CallbackPayloadDto dto) {

    String eventId = dto.getEventId();
    // FIXME: Currently Numbers API return a string without timezone
    // Workaround:
    // 1. try to parse as ISO8601 (with timezone)
    // 2. If failure: fallback to a local date time in UTC time zoe
    Instant timestamp = null;
    if (null != dto.getTimestamp()) {
      try {
        timestamp = Instant.parse(dto.getTimestamp());
      } catch (DateTimeParseException e) {
        timestamp = LocalDateTime.parse(dto.getTimestamp()).toInstant(ZoneOffset.UTC);
      }
    }
    String projectId = dto.getProjectId();
    String resourceId = dto.getResourceId();
    ResourceType resourceType = ResourceType.from(dto.getResourceType());
    EventType eventType = EventType.from(dto.getEventType());
    EventStatus status = EventStatus.from(dto.getStatus());
    SmsErrorCode failureCode = SmsErrorCode.from(dto.getFailureCode());

    return new EventNotification(
        eventId, timestamp, projectId, resourceId, resourceType, eventType, status, failureCode);
  }
}
