package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.opting;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.opting.OptInEventNotification.StatusEnum;
import java.time.Instant;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class OptInEventDtoTest extends ConversationBaseTest {

  @GivenJsonResource("domains/conversation/v1/webhooks/events/opting/OptInEventDto.json")
  OptInEvent messageOptInEventDto;

  @GivenTextResource("domains/conversation/v1/webhooks/events/opting/OptInEventDto.json")
  String jsonOptInEventDto;

  public static OptInEvent expectedOptInEvent =
      OptInEvent.builder()
          .setAppId("app id value")
          .setAcceptedTime(Instant.parse("2020-11-17T16:05:51.724083Z"))
          .setEventTime(Instant.parse("2020-11-17T16:05:45Z"))
          .setMessageMetadata("metadata value")
          .setProjectId("project id value")
          .setCorrelationId("correlation id value")
          .setNotification(
              OptInEventNotification.builder()
                  .setRequestId("request id")
                  .setContactId("contact id")
                  .setChannel(ConversationChannel.WHATSAPP)
                  .setStatus(StatusEnum.FAILED)
                  .setErrorDetails(
                      OptInEventNotificationErrorDetails.builder()
                          .setDescription("Error description value")
                          .build())
                  .setProcessingMode(ProcessingMode.DISPATCH)
                  .build())
          .build();

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedOptInEvent);
    JSONAssert.assertEquals(jsonOptInEventDto, serializedString, true);
  }

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(messageOptInEventDto, expectedOptInEvent);
  }
}
