package com.sinch.sdk.domains.conversation.models.v1.messages.types.choiceresponse;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ChoiceResponseMessageDtoTest extends ConversationBaseTest {

  public static ChoiceResponseMessage choiceResponseMessageDto =
      ChoiceResponseMessage.builder()
          .setMessageId("message id value")
          .setPostbackData("postback data value")
          .build();

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/choiceresponse/ChoiceResponseMessageDto.json")
  String jsonChoiceResponseMessageDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(choiceResponseMessageDto);

    JSONAssert.assertEquals(jsonChoiceResponseMessageDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonChoiceResponseMessageDto, ChoiceResponseMessage.class);

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(choiceResponseMessageDto);
  }
}
