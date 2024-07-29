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
public class CallMessageDtoTest extends ConversationBaseTest {

  public static CallMessage callMessageDto =
      CallMessage.builder().setTitle("title value").setPhoneNumber("phone number value").build();

  @GivenTextResource("/domains/conversation/v1/messages/CallMessageDto.json")
  String jsonCallMessageDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(callMessageDto);

    JSONAssert.assertEquals(jsonCallMessageDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonCallMessageDto, CallMessage.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(callMessageDto);
  }
}
