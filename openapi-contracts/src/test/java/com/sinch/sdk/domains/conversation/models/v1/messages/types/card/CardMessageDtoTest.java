package com.sinch.sdk.domains.conversation.models.v1.messages.types.card;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.call.CallMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceCallMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceLocationMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceTextMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceURLMessage;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.location.LocationMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.media.MediaMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.url.UrlMessageDtoTest;
import java.util.Arrays;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class CardMessageDtoTest extends ConversationBaseTest {

  public static CardMessage cardMessageDto =
      CardMessage.builder()
          .setTitle("title value")
          .setDescription("description value")
          .setMedia(MediaMessageDtoTest.mediaMessageDto)
          .setHeight(CardHeight.MEDIUM)
          .setChoices(
              Arrays.asList(
                  ChoiceTextMessage.builder()
                      .setMessage(TextMessageDtoTest.textMessageDto)
                      .setPostbackData("postback_data text")
                      .build(),
                  ChoiceCallMessage.builder()
                      .setMessage(CallMessageDtoTest.callMessageDto)
                      .setPostbackData("postback_data call")
                      .build(),
                  ChoiceLocationMessage.builder()
                      .setMessage(LocationMessageDtoTest.locationMessageDto)
                      .setPostbackData("postback_data location")
                      .build(),
                  ChoiceURLMessage.builder()
                      .setMessage(UrlMessageDtoTest.urlMessageDto)
                      .setPostbackData("postback_data url")
                      .build()))
          .build();

  @GivenTextResource("/domains/conversation/v1/messages/types/card/CardMessageDto.json")
  String jsonCardMessageDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(cardMessageDto);

    JSONAssert.assertEquals(jsonCardMessageDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonCardMessageDto, CardMessage.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(cardMessageDto);
  }
}
