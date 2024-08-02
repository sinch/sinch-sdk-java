package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.message;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentityDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.message.MessageInboundEventMessage.DirectionEnum;
import java.time.Instant;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class MessageInboundEventDtoTest extends ConversationBaseTest {

  @GivenJsonResource("domains/conversation/v1/webhooks/events/message/MessageInboundEventDto.json")
  MessageInboundEvent messageInboundEventDto;

  @GivenTextResource("domains/conversation/v1/webhooks/events/message/MessageInboundEventDto.json")
  String jsonMessageInboundEventDto;

  public static MessageInboundEvent expectedMessageInboundEvent =
      MessageInboundEvent.builder()
          .setAppId("app id value")
          .setAcceptedTime(Instant.parse("2020-11-17T16:05:51.724083Z"))
          .setEventTime(Instant.parse("2020-11-17T16:05:45Z"))
          .setMessageMetadata("metadata value")
          .setProjectId("project id value")
          .setCorrelationId("correlation id value")
          .setMessage(
              MessageInboundEventMessage.builder()
                  .setId("event id")
                  .setDirection(DirectionEnum.TO_APP)
                  .setContactMessage(TextMessageDtoTest.textMessageDto)
                  .setChannelIdentity(ChannelIdentityDtoTest.expectedDto)
                  .setConversationId("conversation id")
                  .setContactId("contact ID")
                  .setMetadata("metadata value")
                  .setAcceptTime(Instant.parse("2020-11-17T16:07:15Z"))
                  .setSenderId("sender id value")
                  .setProcessingMode(ProcessingMode.DISPATCH)
                  .setInjected(true)
                  .build())
          .build();

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedMessageInboundEvent);
    JSONAssert.assertEquals(jsonMessageInboundEventDto, serializedString, true);
  }

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(messageInboundEventDto, expectedMessageInboundEvent);
  }
}
