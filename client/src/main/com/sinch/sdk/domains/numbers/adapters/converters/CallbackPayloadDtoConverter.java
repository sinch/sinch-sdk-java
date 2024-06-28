package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.domains.numbers.models.SmsErrorCode;
import com.sinch.sdk.domains.numbers.models.v1.webhooks.NumberEvent;
import com.sinch.sdk.domains.numbers.models.webhooks.EventNotification;
import com.sinch.sdk.domains.numbers.models.webhooks.EventStatus;
import com.sinch.sdk.domains.numbers.models.webhooks.EventType;
import com.sinch.sdk.domains.numbers.models.webhooks.ResourceType;
import java.time.Instant;

public class CallbackPayloadDtoConverter {

  public static EventNotification convert(NumberEvent dto) {

    String eventId = dto.getEventId();
    Instant timestamp = dto.getTimestamp();
    String projectId = dto.getProjectId();
    String resourceId = dto.getResourceId();
    ResourceType resourceType =
        null == dto.getResourceType() ? null : ResourceType.from(dto.getResourceType().value());
    EventType eventType =
        null == dto.getEventType() ? null : EventType.from(dto.getEventType().value());
    EventStatus status = null == dto.getStatus() ? null : EventStatus.from(dto.getStatus().value());
    SmsErrorCode failureCode =
        null == dto.getFailureCode() ? null : SmsErrorCode.from(dto.getFailureCode().value());

    return new EventNotification(
        eventId, timestamp, projectId, resourceId, resourceType, eventType, status, failureCode);
  }
}
