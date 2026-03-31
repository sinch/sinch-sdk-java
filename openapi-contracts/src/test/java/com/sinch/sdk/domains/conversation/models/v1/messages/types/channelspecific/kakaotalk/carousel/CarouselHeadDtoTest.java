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
public class CarouselHeadDtoTest extends ConversationBaseTest {

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/kakaotalk/carousel/CarouselHeadDto.json")
  static String jsonCarouselHeadDto;

  public static CarouselHead carouselHeadDto =
      CarouselHead.builder()
          .setHeader("header text")
          .setContent("content text")
          .setImageUrl("https://example.com/assets/image/image-product-123.jpg")
          .setLinkMo("https://link.sample/mo")
          .setLinkPc("https://link.sample/pc")
          .setSchemeIos("alimtalk=coupon://ios/...")
          .setSchemeAndroid("alimtalk=coupon://android/...")
          .build();

  @Test
  void deserializeCarouselHeadDtoo() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonCarouselHeadDto, CarouselHead.class);

    TestHelpers.recursiveEquals(deserialized, carouselHeadDto);
  }

  @Test
  void serializeCarouselHeadDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(carouselHeadDto);

    JSONAssert.assertEquals(jsonCarouselHeadDto, serializedString, true);
  }
}
