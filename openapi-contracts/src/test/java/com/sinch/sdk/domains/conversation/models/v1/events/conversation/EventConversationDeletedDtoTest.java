package com.sinch.sdk.domains.conversation.models.v1.events.conversation;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class EventConversationDeletedDtoTest extends ConversationBaseTest {

  @GivenJsonResource("domains/conversation/v1/events/conversation/EventConversationDeletedDto.json")
  EventConversationDeleted dto;

  @GivenTextResource("domains/conversation/v1/events/conversation/EventConversationDeletedDto.json")
  String json;

  public static EventConversationDeleted expectedDto = EventConversationDeleted.EMPTY;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedDto);
    JSONAssert.assertEquals(json, serializedString, true);
  }

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(dto, expectedDto);
  }
}
