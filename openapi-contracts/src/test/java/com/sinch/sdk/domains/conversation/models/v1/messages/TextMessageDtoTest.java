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
public class TextMessageDtoTest extends ConversationBaseTest {

  public static TextMessage textMessageDto =
      TextMessage.builder().setText("This is a text message.").build();

  @GivenTextResource("/domains/conversation/v1/messages/TextMessageDto.json")
  String jsonUrlMessageDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(textMessageDto);

    JSONAssert.assertEquals(jsonUrlMessageDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonUrlMessageDto, TextMessage.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(textMessageDto);
  }
}
