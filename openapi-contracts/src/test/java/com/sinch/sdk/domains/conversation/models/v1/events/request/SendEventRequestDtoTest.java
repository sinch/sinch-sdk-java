package com.sinch.sdk.domains.conversation.models.v1.events.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentities;
import com.sinch.sdk.domains.conversation.models.v1.ChannelRecipientIdentity;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.events.types.ComposingEndEvent;
import com.sinch.sdk.domains.conversation.models.v1.messages.request.MessageQueue;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class SendEventRequestDtoTest extends ConversationBaseTest {

  public static SendEventRequest sendEventDto =
      SendEventRequest.builder()
          .setAppId("an app id")
          .setEvent(ComposingEndEvent.EMPTY)
          .setRecipient(
              ChannelRecipientIdentities.of(
                  ChannelRecipientIdentity.builder()
                      .setChannel(ConversationChannel.RCS)
                      .setIdentity("+123456789")
                      .build()))
          .setCallbackUrl("foo URL")
          .setChannelPriorityOrder(Arrays.asList(ConversationChannel.RCS))
          .setEventMetadata("event metadata value")
          .setQueue(MessageQueue.NORMAL_PRIORITY)
          .build();

  @GivenTextResource("/domains/conversation/v1/events/request/SendEventRequestDto.json")
  static String jsonSendEventDto;

  @Test
  void serializeDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(sendEventDto);

    JSONAssert.assertEquals(jsonSendEventDto, serializedString, true);
  }
}
