package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.TextMessageDtoTest;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class TextMessageFieldInternalDtoTest extends ConversationBaseTest {

  public static TextMessageFieldInternal textMessageDto =
      TextMessageFieldInternal.builder().setTextMessage(TextMessageDtoTest.textMessageDto).build();

  @GivenTextResource("/domains/conversation/v1/messages/internal/TextMessageFieldInternalDto.json")
  String jsonUrlMessageDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(textMessageDto);

    JSONAssert.assertEquals(jsonUrlMessageDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonUrlMessageDto, textMessageDto.getClass());

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(textMessageDto);
  }
}
