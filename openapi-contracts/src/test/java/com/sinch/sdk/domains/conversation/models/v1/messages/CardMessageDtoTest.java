package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class CardMessageDtoTest extends BaseTest {

  public static CardMessage cardMessageDto =
      CardMessage.builder()
          .setTitle("title value")
          .setDescription("description value")
          .setMediaMessage(CardMessageMediaMessage.builder().setUrl("url value").build())
          .setHeight(CardHeight.MEDIUM)
          .setChoices(
              Arrays.asList(
                  Choice.builder()
                      .setTextMessage(TextMessageDtoTest.textMessageDto)
                      .setPostbackData("postback_data text")
                      .build(),
                  Choice.builder()
                      .setCallMessage(CallMessageDtoTest.callMessageDto)
                      .setPostbackData("postback_data call")
                      .build(),
                  Choice.builder()
                      .setLocationMessage(LocationMessageDtoTest.locationMessageDto)
                      .setPostbackData("postback_data location")
                      .build(),
                  Choice.builder()
                      .setUrlMessage(URLMessageDtoTest.urlMessageDto)
                      .setPostbackData("postback_data url")
                      .build()))
          .build();

  @GivenTextResource("/domains/conversation/v1/messages/CardMessageDto.json")
  String jsonCardMessageDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(cardMessageDto);

    JSONAssert.assertEquals(jsonCardMessageDto, serializedString, true);
  }
}
