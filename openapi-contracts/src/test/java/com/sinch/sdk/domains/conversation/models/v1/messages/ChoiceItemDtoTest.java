package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ChoiceItemDtoTest extends ConversationBaseTest {

  public static ChoiceItem choiceItemDto =
      ChoiceItem.builder()
          .setTitle("choice title")
          .setDescription("description value")
          .setMedia(MediaMessageDtoTest.mediaMessageDto)
          .setPostbackData("description value")
          .build();

  @GivenTextResource("/domains/conversation/v1/messages/ChoiceItemDto.json")
  String jsonChoiceItemDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(choiceItemDto);

    JSONAssert.assertEquals(jsonChoiceItemDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonChoiceItemDto, ChoiceItem.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(choiceItemDto);
  }
}
