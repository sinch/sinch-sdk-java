package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.message;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentityDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageDtoTest;
import java.time.Instant;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class MessageSubmitEventDtoTest extends ConversationBaseTest {

  @GivenJsonResource("domains/conversation/v1/webhooks/events/message/MessageSubmitEventDto.json")
  MessageSubmitEvent messageSubmitEventDto;

  @GivenTextResource("domains/conversation/v1/webhooks/events/message/MessageSubmitEventDto.json")
  String jsonMessageInboundEventDto;

  public static MessageSubmitEvent expectedMessageInboundEvent =
      MessageSubmitEvent.builder()
          .setAppId("app id value")
          .setAcceptedTime(Instant.parse("2020-11-17T16:05:51.724083Z"))
          .setEventTime(Instant.parse("2020-11-17T16:05:45Z"))
          .setMessageMetadata("metadata value")
          .setProjectId("project id value")
          .setCorrelationId("correlation id value")
          .setMessage(
              MessageSubmitEventMessage.builder()
                  .setMessageId("message id")
                  .setConversationId("conversation id")
                  .setChannelIdentity(ChannelIdentityDtoTest.expectedDto)
                  .setContactId("contact ID")
                  .setSubmittedMessage(AppMessageDtoTest.appTextMessageDto)
                  .setMetadata("metadata value")
                  .setProcessingMode(ProcessingMode.DISPATCH)
                  .build())
          .build();

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedMessageInboundEvent);
    JSONAssert.assertEquals(jsonMessageInboundEventDto, serializedString, true);
  }

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(messageSubmitEventDto, expectedMessageInboundEvent);
  }
}
