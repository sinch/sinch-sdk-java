package com.sinch.sdk.domains.numbers.models.v1;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.utils.DateUtil;
import com.sinch.sdk.domains.numbers.api.v1.adapters.NumbersBaseTest;
import com.sinch.sdk.domains.numbers.models.v1.webhooks.NumberEvent;
import com.sinch.sdk.domains.numbers.models.v1.webhooks.NumberEvent.EventTypeEnum;
import com.sinch.sdk.domains.numbers.models.v1.webhooks.NumberEvent.FailureCodeEnum;
import com.sinch.sdk.domains.numbers.models.v1.webhooks.NumberEvent.StatusEnum;
import com.sinch.sdk.domains.numbers.models.v1.webhooks.ResourceType;
import org.junit.jupiter.api.Test;

@TestWithResources
public class WebhooksDtoTest extends NumbersBaseTest {

  @GivenTextResource("/domains/numbers/v1/webhooks/number-event.json")
  String numberEventJSON;

  public static NumberEvent numberEvent =
      NumberEvent.builder()
          .setEventId("abcd1234efghijklmnop567890")
          .setTimestamp(DateUtil.failSafeTimeStampToInstant("2023-06-06T07:45:27.78789"))
          .setProjectId("abcd12ef-ab12-ab12-bc34-abcdef123456")
          .setResourceId("+12345612345")
          .setResourceType(ResourceType.ACTIVE_NUMBER)
          .setEventType(EventTypeEnum.PROVISIONING_TO_CAMPAIGN)
          .setStatus(StatusEnum.FAILED)
          .setFailureCode(FailureCodeEnum.CAMPAIGN_NOT_AVAILABLE)
          .build();

  @Test
  void deserialize() throws JsonProcessingException {

    NumberEvent deserializedString = objectMapper.readValue(numberEventJSON, NumberEvent.class);

    TestHelpers.recursiveEquals(numberEvent, deserializedString);
  }
}
