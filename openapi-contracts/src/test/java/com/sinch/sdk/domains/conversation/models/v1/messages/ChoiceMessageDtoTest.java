package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.adapters.ConversationBaseTest;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ChoiceMessageDtoTest extends ConversationBaseTest {

  public static ChoiceMessage choiceMessageDto =
      ChoiceMessage.builder()
          .setTextMessage(TextMessageDtoTest.textMessageDto)
          .setChoices(
              Arrays.asList(
                  ChoiceCallMessage.builder()
                      .setMessage(CallMessageDtoTest.callMessageDto)
                      .setPostbackData("postback call_message data value")
                      .build(),
                  ChoiceLocationMessage.builder()
                      .setMessage(LocationMessageDtoTest.locationMessageDto)
                      .setPostbackData("postback location_message data value")
                      .build(),
                  ChoiceTextMessage.builder()
                      .setMessage(TextMessageDtoTest.textMessageDto)
                      .setPostbackData("postback text_message data value")
                      .build(),
                  ChoiceURLMessage.builder()
                      .setMessage(UrlMessageDtoTest.urlMessageDto)
                      .setPostbackData("postback url_message data value")
                      .build()))
          .build();

  @GivenTextResource("/domains/conversation/v1/messages/ChoiceMessageDto.json")
  String jsonChoiceMessageDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(choiceMessageDto);

    JSONAssert.assertEquals(jsonChoiceMessageDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonChoiceMessageDto, ChoiceMessage.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(choiceMessageDto);
  }
}
