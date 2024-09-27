package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.record;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentityDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.ReasonDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.record.RecordNotificationEventNotification.RecordStatusEnum;
import java.time.Instant;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class RecordNotificationEventDtoTest extends ConversationBaseTest {

  @GivenJsonResource(
      "domains/conversation/v1/webhooks/events/record/RecordNotificationEventDto.json")
  RecordNotificationEvent recordNotificationEventDto;

  @GivenTextResource(
      "domains/conversation/v1/webhooks/events/record/RecordNotificationEventDto.json")
  String jsonRecordNotificationEventDto;

  public static RecordNotificationEvent expectedOptInEvent =
      RecordNotificationEvent.builder()
          .setAppId("app id value")
          .setAcceptedTime(Instant.parse("2020-11-17T16:05:51.724083Z"))
          .setEventTime(Instant.parse("2020-11-17T16:05:45Z"))
          .setMessageMetadata("metadata value")
          .setProjectId("project id value")
          .setCorrelationId("correlation id value")
          .setNotification(
              RecordNotificationEventNotification.builder()
                  .setEntityId("entity id")
                  .setRecordStatus(RecordStatusEnum.EVENT_RECORD_STORED)
                  .setChannelIdentity(ChannelIdentityDtoTest.expectedDto)
                  .setContactId("contact id")
                  .setConversationId("conversation id")
                  .setReason(ReasonDtoTest.expectedDto)
                  .setProcessingMode(ProcessingMode.DISPATCH)
                  .build())
          .build();

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedOptInEvent);
    JSONAssert.assertEquals(jsonRecordNotificationEventDto, serializedString, true);
  }

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(recordNotificationEventDto, expectedOptInEvent);
  }
}
