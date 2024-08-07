package com.sinch.sdk.domains.conversation.models.v1.messages.types.choice;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.call.CallMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.call.CallMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.url.UrlMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.url.UrlMessageDtoTest;
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
                  Choice.<CallMessage>builder()
                      .setMessage(CallMessageDtoTest.callMessageDto)
                      .setPostbackData("postback call_message data value")
                      .build(),
                  Choice.<LocationMessage>builder()
                      .setMessage(LocationMessageDtoTest.locationMessageDto)
                      .setPostbackData("postback location_message data value")
                      .build(),
                  Choice.<TextMessage>builder()
                      .setMessage(TextMessageDtoTest.textMessageDto)
                      .setPostbackData("postback text_message data value")
                      .build(),
                  Choice.<UrlMessage>builder()
                      .setMessage(UrlMessageDtoTest.urlMessageDto)
                      .setPostbackData("postback url_message data value")
                      .build()))
          .build();

  @GivenTextResource("/domains/conversation/v1/messages/types/choice/ChoiceMessageDto.json")
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
