package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.domains.numbers.models.SmsErrorCode;
import com.sinch.sdk.domains.numbers.models.dto.v1.CallbackPayloadDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.CallbackPayloadDtoTest;
import com.sinch.sdk.domains.numbers.models.webhooks.EventNotification;
import com.sinch.sdk.domains.numbers.models.webhooks.EventStatus;
import com.sinch.sdk.domains.numbers.models.webhooks.EventType;
import com.sinch.sdk.domains.numbers.models.webhooks.ResourceType;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CallbackPayloadDtoConverterTest {

  @Test
  void convertCallbackPayloadDtoWithLocalDate() {

    EventNotification client =
        new EventNotification(
            "abcd1234efghijklmnop567890",
            LocalDateTime.parse("2023-06-06T07:45:27.78789").toInstant(ZoneOffset.UTC),
            "abcd12ef-ab12-ab12-bc34-abcdef123456",
            "+12345612345",
            ResourceType.ACTIVE_NUMBER,
            EventType.PROVISIONING_TO_CAMPAIGN,
            EventStatus.FAILED,
            SmsErrorCode.CAMPAIGN_NOT_AVAILABLE);

    Assertions.assertThat(
            CallbackPayloadDtoConverter.convert(
                CallbackPayloadDtoTest.expectedCallbackPayloadDtoDto))
        .usingRecursiveComparison()
        .isEqualTo(client);
  }

  @Test
  void convertCallbackPayloadDtoWithTimeZone() {

    // patch timestamp with a timezone compliant value
    CallbackPayloadDto dto =
        new CallbackPayloadDto()
            .eventId(CallbackPayloadDtoTest.expectedCallbackPayloadDtoDto.getEventId())
            // adding a time zone
            .timestamp(CallbackPayloadDtoTest.expectedCallbackPayloadDtoDto.getTimestamp() + "Z")
            .projectId(CallbackPayloadDtoTest.expectedCallbackPayloadDtoDto.getProjectId())
            .resourceId(CallbackPayloadDtoTest.expectedCallbackPayloadDtoDto.getResourceId())
            .resourceType(CallbackPayloadDtoTest.expectedCallbackPayloadDtoDto.getResourceType())
            .eventType(CallbackPayloadDtoTest.expectedCallbackPayloadDtoDto.getEventType())
            .status(CallbackPayloadDtoTest.expectedCallbackPayloadDtoDto.getStatus())
            .failureCode(CallbackPayloadDtoTest.expectedCallbackPayloadDtoDto.getFailureCode());

    EventNotification client =
        new EventNotification(
            "abcd1234efghijklmnop567890",
            Instant.parse("2023-06-06T07:45:27.78789Z"),
            "abcd12ef-ab12-ab12-bc34-abcdef123456",
            "+12345612345",
            ResourceType.ACTIVE_NUMBER,
            EventType.PROVISIONING_TO_CAMPAIGN,
            EventStatus.FAILED,
            SmsErrorCode.CAMPAIGN_NOT_AVAILABLE);

    Assertions.assertThat(CallbackPayloadDtoConverter.convert(dto))
        .usingRecursiveComparison()
        .isEqualTo(client);
  }
}
