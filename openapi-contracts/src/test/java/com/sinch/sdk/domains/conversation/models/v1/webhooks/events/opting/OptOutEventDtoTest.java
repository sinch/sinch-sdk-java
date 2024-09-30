package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.opting;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.opting.OptOutEventNotification.StatusEnum;
import java.time.Instant;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class OptOutEventDtoTest extends ConversationBaseTest {

  @GivenJsonResource("domains/conversation/v1/webhooks/events/opting/OptOutEventDto.json")
  OptOutEvent messageOptOutEventDto;

  @GivenTextResource("domains/conversation/v1/webhooks/events/opting/OptOutEventDto.json")
  String jsonOptOutEventDto;

  public static OptOutEvent expectedOptInEvent =
      OptOutEvent.builder()
          .setAppId("app id value")
          .setAcceptedTime(Instant.parse("2020-11-17T16:05:51.724083Z"))
          .setEventTime(Instant.parse("2020-11-17T16:05:45Z"))
          .setMessageMetadata("metadata value")
          .setProjectId("project id value")
          .setCorrelationId("correlation id value")
          .setNotification(
              OptOutEventNotification.builder()
                  .setRequestId("request id")
                  .setContactId("contact id")
                  .setChannel(ConversationChannel.WHATSAPP)
                  .setStatus(StatusEnum.FAILED)
                  .setErrorDetails(
                      OptOutEventNotificationErrorDetails.builder()
                          .setDescription("Error description value")
                          .build())
                  .setProcessingMode(ProcessingMode.DISPATCH)
                  .build())
          .build();

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedOptInEvent);
    JSONAssert.assertEquals(jsonOptOutEventDto, serializedString, true);
  }

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(messageOptOutEventDto, expectedOptInEvent);
  }
}
