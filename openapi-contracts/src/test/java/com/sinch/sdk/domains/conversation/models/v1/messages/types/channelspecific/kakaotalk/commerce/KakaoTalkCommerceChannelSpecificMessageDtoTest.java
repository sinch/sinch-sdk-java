package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.commerce;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.buttons.KakaoTalkButtonDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.coupons.KakaoTalkCouponDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.image.KakaoTalkImageDtoTest;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class KakaoTalkCommerceChannelSpecificMessageDtoTest extends ConversationBaseTest {

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/kakaotalk/commerce/KakaoTalkCommerceChannelSpecificMessageDto.json")
  static String jsonKakaoTalkCommerceChannelSpecificMessageDto;

  public static KakaoTalkCommerceChannelSpecificMessage kakaoTalkCommerceChannelSpecificMessageDto =
      KakaoTalkCommerceChannelSpecificMessage.builder()
          .setPushAlarm(true)
          .setAdult(true)
          .setButtons(
              Arrays.asList(
                  KakaoTalkButtonDtoTest.webLinkButtonDto, KakaoTalkButtonDtoTest.appLinkButtonDto))
          .setAdditionalContent("additional content")
          .setImage(KakaoTalkImageDtoTest.imageDto)
          .setCommerce(KakaoTalkCommerceDtoTest.regularPriceCommerceDto)
          .setCoupon(KakaoTalkCouponDtoTest.discountRateCouponDto)
          .build();

  @Test
  void deserializeKakaoTalkCommerceChannelSpecificMessage() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(
            jsonKakaoTalkCommerceChannelSpecificMessageDto,
            KakaoTalkCommerceChannelSpecificMessage.class);

    TestHelpers.recursiveEquals(deserialized, kakaoTalkCommerceChannelSpecificMessageDto);
  }

  @Test
  void serializeKakaoTalkCommerceChannelSpecificMessage()
      throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(kakaoTalkCommerceChannelSpecificMessageDto);

    JSONAssert.assertEquals(jsonKakaoTalkCommerceChannelSpecificMessageDto, serializedString, true);
  }
}
