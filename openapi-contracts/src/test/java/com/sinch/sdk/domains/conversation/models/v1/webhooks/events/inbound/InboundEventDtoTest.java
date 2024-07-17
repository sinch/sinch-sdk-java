package com.sinch.sdk.domains.conversation.models.v1.webhooks.events.inbound;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.events.EventComposingDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.events.contactmessage.ReactionEventDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.ChannelIdentityDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.inbound.Event.DirectionEnum;
import java.time.Instant;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class InboundEventDtoTest extends ConversationBaseTest {

  @GivenJsonResource("domains/conversation/v1/webhooks/events/inbound/InboundContactEventDto.json")
  InboundEvent inboundContactEventDto;

  @GivenTextResource("domains/conversation/v1/webhooks/events/inbound/InboundContactEventDto.json")
  String jsonInboundContactEventDto;

  @GivenJsonResource(
      "domains/conversation/v1/webhooks/events/inbound/InboundContactMessageEventDto.json")
  InboundEvent inboundContactMessageEventDto;

  @GivenTextResource(
      "domains/conversation/v1/webhooks/events/inbound/InboundContactMessageEventDto.json")
  String jsonInboundContactMessageEventDto;

  public static InboundEvent expectedInboundContactEventDto =
      InboundEvent.builder()
          .setAppId("app id value")
          .setAcceptedTime(Instant.parse("2020-11-17T16:05:51.724083Z"))
          .setEventTime(Instant.parse("2020-11-17T16:05:45Z"))
          .setMessageMetadata("metadata value")
          .setProjectId("project id value")
          .setCorrelationId("correlation id value")
          .setEvent(
              Event.builder()
                  .setId("event id")
                  .setDirection(DirectionEnum.TO_APP)
                  .setContactEvent(EventComposingDtoTest.expectedDto)
                  .setChannelIdentity(ChannelIdentityDtoTest.expectedDto)
                  .setContactId("contact ID")
                  .setConversationId("conversation id")
                  .setAcceptTime(Instant.parse("2020-11-17T16:07:15Z"))
                  .setProcessingMode(ProcessingMode.DISPATCH)
                  .build())
          .build();

  public static InboundEvent expectedInboundContactMessageEventDto =
      InboundEvent.builder()
          .setAppId("app id value")
          .setAcceptedTime(Instant.parse("2020-11-17T16:05:51.724083Z"))
          .setEventTime(Instant.parse("2020-11-17T16:05:45Z"))
          .setMessageMetadata("metadata value")
          .setProjectId("project id value")
          .setCorrelationId("correlation id value")
          .setEvent(
              Event.builder()
                  .setId("event id")
                  .setDirection(DirectionEnum.TO_APP)
                  .setContactMessageEvent(ReactionEventDtoTest.expectedReactionEventDto)
                  .setChannelIdentity(ChannelIdentityDtoTest.expectedDto)
                  .setContactId("contact ID")
                  .setConversationId("conversation id")
                  .setAcceptTime(Instant.parse("2020-11-17T16:07:15Z"))
                  .setProcessingMode(ProcessingMode.DISPATCH)
                  .build())
          .build();

  @Test
  void serializeContactEvent() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedInboundContactEventDto);
    JSONAssert.assertEquals(jsonInboundContactEventDto, serializedString, true);
  }

  @Test
  void deserializeContactEvent() {
    TestHelpers.recursiveEquals(inboundContactEventDto, expectedInboundContactEventDto);
  }

  @Test
  void serializeContactMessageEvent() throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(expectedInboundContactMessageEventDto);
    JSONAssert.assertEquals(jsonInboundContactMessageEventDto, serializedString, true);
  }

  @Test
  void deserializeContactMessageEvent() {
    TestHelpers.recursiveEquals(
        inboundContactMessageEventDto, expectedInboundContactMessageEventDto);
  }
}
