package com.sinch.sdk.domains.conversation.models.v1.messages.internal;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.CallMessageDtoTest;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class CallMessageFieldInternalDtoTest extends ConversationBaseTest {

  public static CallMessageFieldInternal callMessageDto =
      CallMessageFieldInternal.builder().setCallMessage(CallMessageDtoTest.callMessageDto).build();

  @GivenTextResource("/domains/conversation/v1/messages/internal/CallMessageFieldInternalDto.json")
  String jsonCallMessageDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(callMessageDto);

    JSONAssert.assertEquals(jsonCallMessageDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonCallMessageDto, callMessageDto.getClass());

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(callMessageDto);
  }
}
