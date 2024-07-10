package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.domains.numbers.models.SmsErrorCode;
import com.sinch.sdk.domains.numbers.models.v1.WebhooksDtoTest;
import com.sinch.sdk.domains.numbers.models.webhooks.EventNotification;
import com.sinch.sdk.domains.numbers.models.webhooks.EventStatus;
import com.sinch.sdk.domains.numbers.models.webhooks.EventType;
import com.sinch.sdk.domains.numbers.models.webhooks.ResourceType;
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

    Assertions.assertThat(CallbackPayloadDtoConverter.convert(WebhooksDtoTest.numberEvent))
        .usingRecursiveComparison()
        .isEqualTo(client);
  }
}
