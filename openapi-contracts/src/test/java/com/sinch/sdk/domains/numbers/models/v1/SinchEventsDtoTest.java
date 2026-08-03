package com.sinch.sdk.domains.numbers.models.v1;

import static org.assertj.core.api.Assertions.assertThat;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.utils.DateUtil;
import com.sinch.sdk.domains.numbers.api.v1.adapters.NumbersBaseTest;
import com.sinch.sdk.domains.numbers.models.v1.sinchevents.NumberSinchEvent;
import com.sinch.sdk.domains.numbers.models.v1.sinchevents.NumberSinchEvent.EventTypeEnum;
import com.sinch.sdk.domains.numbers.models.v1.sinchevents.NumberSinchEvent.FailureCodeEnum;
import com.sinch.sdk.domains.numbers.models.v1.sinchevents.NumberSinchEvent.StatusEnum;
import com.sinch.sdk.domains.numbers.models.v1.sinchevents.ResourceType;
import org.junit.jupiter.api.Test;

@TestWithResources
public class SinchEventsDtoTest extends NumbersBaseTest {

  @GivenTextResource("/domains/numbers/v1/sinchevents/active-number-sinch-event.json")
  String activeNumberEventJSON;

  public static NumberSinchEvent activeNumberSinchEvent =
      NumberSinchEvent.builder()
          .setEventId("abcd1234efghijklmnop567890")
          .setTimestamp(DateUtil.failSafeTimeStampToInstant("2023-06-06T07:45:27.78789"))
          .setProjectId("abcd12ef-ab12-ab12-bc34-abcdef123456")
          .setResourceId("+12345612345")
          .setResourceType(ResourceType.ACTIVE_NUMBER)
          .setEventType(EventTypeEnum.PROVISIONING_TO_CAMPAIGN)
          .setStatus(StatusEnum.FAILED)
          .setFailureCode(FailureCodeEnum.CAMPAIGN_NOT_AVAILABLE)
          .setInternalFailureCode("CRS0018")
          .build();

  @GivenTextResource("/domains/numbers/v1/sinchevents/number-order-sinch-event.json")
  String numberOrderEventJSON;

  public static NumberSinchEvent numberOrderEvent =
      NumberSinchEvent.builder()
          .setEventId("abcd1234efghijklmnop567890")
          .setTimestamp(DateUtil.failSafeTimeStampToInstant("2023-06-06T07:45:27.78789"))
          .setProjectId("abcd12ef-ab12-ab12-bc34-abcdef123456")
          .setResourceId("01jgkbb8xywmz3hhahd76menqf")
          .setResourceType(ResourceType.NUMBER_ORDER)
          .setEventType(EventTypeEnum.NUMBER_ORDER_PROCESSING)
          .setStatus(StatusEnum.IN_REVIEW)
          .build();

  @Test
  void deserializeActiveNumberEvent() throws JsonProcessingException {

    NumberSinchEvent deserializedString =
        objectMapper.readValue(activeNumberEventJSON, NumberSinchEvent.class);

    TestHelpers.recursiveEquals(activeNumberSinchEvent, deserializedString);
  }

  @Test
  void deserializeNumberOrderEvent() throws JsonProcessingException {

    NumberSinchEvent deserializedString =
        objectMapper.readValue(numberOrderEventJSON, NumberSinchEvent.class);

    TestHelpers.recursiveEquals(numberOrderEvent, deserializedString);
  }

  @Test
  void activeNumberEventIsReadableThroughTheCommonType() throws JsonProcessingException {

    NumberSinchEvent event = objectMapper.readValue(activeNumberEventJSON, NumberSinchEvent.class);

    assertThat(event.getResourceType()).isEqualTo(ResourceType.ACTIVE_NUMBER);
    assertThat(event.getEventType()).isEqualTo(EventTypeEnum.PROVISIONING_TO_CAMPAIGN);
    assertThat(event.getStatus()).isEqualTo(StatusEnum.FAILED);
    assertThat(event.getResourceId()).isEqualTo("+12345612345");
    assertThat(event.getFailureCode()).isEqualTo(FailureCodeEnum.CAMPAIGN_NOT_AVAILABLE);
    assertThat(event.getInternalFailureCode()).isEqualTo("CRS0018");
  }
}
