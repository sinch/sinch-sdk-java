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
public class CarouselTailDtoTest extends ConversationBaseTest {

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/kakaotalk/carousel/CarouselTailDto.json")
  static String jsonCarouselTailDto;

  public static CarouselTail carouselTailDto =
      CarouselTail.builder()
          .setLinkMo("https://link.sample/mo")
          .setLinkPc("https://link.sample/pc")
          .setSchemeIos("alimtalk=coupon://ios/...")
          .setSchemeAndroid("alimtalk=coupon://android/...")
          .build();

  @Test
  void deserializeCarouselTailDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonCarouselTailDto, CarouselTail.class);

    TestHelpers.recursiveEquals(deserialized, carouselTailDto);
  }

  @Test
  void serializeCarouselTailDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(carouselTailDto);

    JSONAssert.assertEquals(jsonCarouselTailDto, serializedString, true);
  }
}
