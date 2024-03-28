package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class CarouselMessageDtoTest extends BaseTest {

  public static CarouselMessage carouselMessageDto =
      CarouselMessage.builder()
          .setCards(
              Collections.singletonList(
                  CardMessageItem.builder()
                      .setCardMessage(CardMessageDtoTest.cardMessageDto)
                      .build()))
          .setChoices(
              Collections.singletonList(
                  Choice.builder().setCallMessage(CallMessageDtoTest.callMessageDto).build()))
          .build();

  @GivenTextResource("/domains/conversation/v1/messages/CarouselMessageDto.json")
  String jsonCarouselMessageDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(carouselMessageDto);

    JSONAssert.assertEquals(jsonCarouselMessageDto, serializedString, true);
  }
}
