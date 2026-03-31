package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.carousel;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class KakaoTalkCarouselCommerceChannelSpecificMessageDtoTest extends ConversationBaseTest {

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/kakaotalk/carousel/KakaoTalkCarouselCommerceChannelSpecificMessageDto.json")
  static String jsonKakaoTalkCarouselCommerceChannelSpecificMessageDto;

  public static KakaoTalkCarouselCommerceChannelSpecificMessage
      kakaoTalkCarouselCommerceChannelSpecificMessageDto =
          KakaoTalkCarouselCommerceChannelSpecificMessage.builder()
              .setPushAlarm(true)
              .setAdult(true)
              .setCarousel(CarouselDtoTest.carouselDto)
              .build();

  @Test
  void deserializeKakaoTalkCarouselCommerceChannelSpecificMessage() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(
            jsonKakaoTalkCarouselCommerceChannelSpecificMessageDto,
            KakaoTalkCarouselCommerceChannelSpecificMessage.class);

    TestHelpers.recursiveEquals(deserialized, kakaoTalkCarouselCommerceChannelSpecificMessageDto);
  }

  @Test
  void serializeKakaoTalkCarouselCommerceChannelSpecificMessage()
      throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(kakaoTalkCarouselCommerceChannelSpecificMessageDto);

    JSONAssert.assertEquals(
        jsonKakaoTalkCarouselCommerceChannelSpecificMessageDto, serializedString, true);
  }
}
