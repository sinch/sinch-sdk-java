package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.carousel;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.commerce.KakaoTalkCommerceMessageDtoTest;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class CarouselDtoTest extends ConversationBaseTest {

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/kakaotalk/carousel/CarouselDto.json")
  static String jsonCarouselDto;

  public static Carousel carouselDto =
      Carousel.builder()
          .setHead(CarouselHeadDtoTest.carouselHeadDto)
          .setList(
              Collections.singletonList(
                  KakaoTalkCommerceMessageDtoTest.kakaoTalkCommerceMessageDto))
          .setTail(CarouselTailDtoTest.carouselTailDto)
          .build();

  @Test
  void deserializeCarouselDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonCarouselDto, Carousel.class);

    TestHelpers.recursiveEquals(deserialized, carouselDto);
  }

  @Test
  void serializeCarouselDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(carouselDto);

    JSONAssert.assertEquals(jsonCarouselDto, serializedString, true);
  }
}
