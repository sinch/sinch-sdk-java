package com.sinch.sdk.domains.conversation.models.v1.events.types;

import static org.assertj.core.api.Assertions.assertThat;

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
public class ReadMessageEventDtoTest extends ConversationBaseTest {

  @GivenJsonResource("domains/conversation/v1/events/types/ReadMessageEventDto.json")
  ReadMessageEvent dto;

  @GivenTextResource("domains/conversation/v1/events/types/ReadMessageEventDto.json")
  String json;

  public static ReadMessageEvent expectedDto = ReadMessageEvent.READ_MESSAGE_EVENT;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedDto);
    JSONAssert.assertEquals(json, serializedString, true);
  }

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(dto, expectedDto);
  }

  @Test
  void serializeConstantKeepsEventKey() throws JsonProcessingException {
    assertThat(objectMapper.writeValueAsString(ReadMessageEvent.READ_MESSAGE_EVENT))
        .isEqualTo("{\"read_message_event\":{}}");
  }
}
