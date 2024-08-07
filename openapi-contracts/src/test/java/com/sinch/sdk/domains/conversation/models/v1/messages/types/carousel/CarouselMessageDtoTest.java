package com.sinch.sdk.domains.conversation.models.v1.messages.types.carousel;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.card.CardMessageDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.choice.ChoiceMessageDtoTest;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class CarouselMessageDtoTest extends BaseTest {

  public static CarouselMessage carouselMessageDto =
      CarouselMessage.builder()
          .setCards(Collections.singletonList(CardMessageDtoTest.cardMessageDto))
          .setChoices(ChoiceMessageDtoTest.choiceMessageDto.getChoices())
          .build();

  @GivenTextResource("/domains/conversation/v1/messages/types/carousel/CarouselMessageDto.json")
  String jsonCarouselMessageDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(carouselMessageDto);

    JSONAssert.assertEquals(jsonCarouselMessageDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonCarouselMessageDto, CarouselMessage.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(carouselMessageDto);
  }
}
