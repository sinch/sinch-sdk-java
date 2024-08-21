package com.sinch.sdk.domains.conversation.models.v1.conversations.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ChannelIdentityDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.InjectEventRequest;
import com.sinch.sdk.domains.conversation.models.v1.events.types.GenericEventDtoTest;
import java.time.Instant;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class InjectEventDtoTest extends ConversationBaseTest {

  public static InjectEventRequest injectEvent =
      InjectEventRequest.builder()
          .setAcceptTime(Instant.parse("2024-08-18T14:18:18.117563Z"))
          .setAppEvent(GenericEventDtoTest.expectedDto)
          .setChannelIdentity(ChannelIdentityDtoTest.expectedDto)
          .setConversationId("a conversation Id")
          .setProcessingMode(ProcessingMode.CONVERSATION)
          .build();

  @GivenTextResource("/domains/conversation/v1/conversations/request/InjectEventRequestDto.json")
  static String jsonInjectEventRequestDto;

  @Test
  void serializeInjectEventRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(injectEvent);

    JSONAssert.assertEquals(jsonInjectEventRequestDto, serializedString, true);
  }
}
