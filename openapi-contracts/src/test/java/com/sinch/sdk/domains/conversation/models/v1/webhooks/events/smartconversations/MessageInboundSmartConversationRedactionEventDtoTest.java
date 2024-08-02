package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.smartconversations;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentityDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.message.MessageInboundEventMessage;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.message.MessageInboundEventMessage.DirectionEnum;
import java.time.Instant;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class MessageInboundSmartConversationRedactionEventDtoTest extends ConversationBaseTest {

  static MessageInboundEventMessage message =
      MessageInboundEventMessage.builder()
          .setId("id")
          .setDirection(DirectionEnum.TO_APP)
          .setContactMessage(MediaMessageDtoTest.mediaMessageDto)
          .setChannelIdentity(ChannelIdentityDtoTest.expectedDto)
          .setConversationId("conversation id")
          .setContactId("contact id")
          .setMetadata("metadata value")
          .setAcceptTime(Instant.parse("2020-11-17T16:05:51.724083Z"))
          .setSenderId("sender id")
          .setProcessingMode(ProcessingMode.DISPATCH)
          .setInjected(true)
          .build();
  public static MessageInboundSmartConversationRedactionEvent
      expectedMessageInboundSmartConversationRedactionEvent =
          MessageInboundSmartConversationRedactionEvent.builder()
              .setAppId("app id value")
              .setAcceptedTime(Instant.parse("2020-11-17T16:05:51.724083Z"))
              .setEventTime(Instant.parse("2020-11-17T16:05:45Z"))
              .setMessageMetadata("metadata value")
              .setProjectId("project id value")
              .setCorrelationId("correlation id value")
              .setMessage(message)
              .build();

  @GivenJsonResource(
      "domains/conversation/v1/webhooks/events/smartconversations/MessageInboundSmartConversationRedactionEventDto.json")
  MessageInboundSmartConversationRedactionEvent messageInboundSmartConversationRedactionEventDto;

  @GivenTextResource(
      "domains/conversation/v1/webhooks/events/smartconversations/MessageInboundSmartConversationRedactionEventDto.json")
  String jsonMessageInboundSmartConversationRedactionEventDto;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(expectedMessageInboundSmartConversationRedactionEvent);
    JSONAssert.assertEquals(
        jsonMessageInboundSmartConversationRedactionEventDto, serializedString, true);
  }

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(
        messageInboundSmartConversationRedactionEventDto,
        expectedMessageInboundSmartConversationRedactionEvent);
  }
}
