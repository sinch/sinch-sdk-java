package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.coupons;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class KakaoTalkCouponDtoTest extends ConversationBaseTest {

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/kakaotalk/coupons/DiscountFixedCouponDto.json")
  static String jsonDiscountFixedCouponDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/kakaotalk/coupons/DiscountRateCouponDto.json")
  static String jsonDiscountRateCouponDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/kakaotalk/coupons/DiscountShippingCouponDto.json")
  static String jsonDiscountShippingCouponDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/kakaotalk/coupons/FreeCouponDto.json")
  static String jsonFreeCouponDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/kakaotalk/coupons/UpCouponDto.json")
  static String jsonUpCouponDto;

  public static KakaoTalkCoupon discountFixedCouponDto =
      DiscountFixedCoupon.builder()
          .setDiscountFixed(1000)
          .setDescription("description")
          .setLinkMo("https://example.com/mobile")
          .setLinkPc("https://example.com/desktop")
          .setSchemeIos("alimtalk=coupon://ios/...")
          .setSchemeAndroid("alimtalk=coupon://android/...")
          .build();

  public static KakaoTalkCoupon discountRateCouponDto =
      DiscountRateCoupon.builder()
          .setDiscountRate(10)
          .setDescription("description")
          .setLinkMo("https://example.com/mobile")
          .setLinkPc("https://example.com/desktop")
          .setSchemeIos("alimtalk=coupon://ios/...")
          .setSchemeAndroid("alimtalk=coupon://android/...")
          .build();

  public static KakaoTalkCoupon discountShippingCouponDto =
      DiscountShippingCoupon.builder()
          .setDescription("description")
          .setLinkMo("https://example.com/mobile")
          .setLinkPc("https://example.com/desktop")
          .setSchemeIos("alimtalk=coupon://ios/...")
          .setSchemeAndroid("alimtalk=coupon://android/...")
          .build();

  public static KakaoTalkCoupon freeCouponDto =
      FreeCoupon.builder()
          .setTitle("title value")
          .setDescription("description")
          .setLinkMo("https://example.com/mobile")
          .setLinkPc("https://example.com/desktop")
          .setSchemeIos("alimtalk=coupon://ios/...")
          .setSchemeAndroid("alimtalk=coupon://android/...")
          .build();

  public static KakaoTalkCoupon upCouponDto =
      UpCoupon.builder()
          .setTitle("title value")
          .setDescription("description")
          .setLinkMo("https://example.com/mobile")
          .setLinkPc("https://example.com/desktop")
          .setSchemeIos("alimtalk=coupon://ios/...")
          .setSchemeAndroid("alimtalk=coupon://android/...")
          .build();

  @Test
  void deserializeFixedDiscountCouponDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonDiscountFixedCouponDto, KakaoTalkCoupon.class);

    TestHelpers.recursiveEquals(deserialized, discountFixedCouponDto);
  }

  @Test
  void serializeFixedDiscountCouponDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(discountFixedCouponDto);

    JSONAssert.assertEquals(jsonDiscountFixedCouponDto, serializedString, true);
  }

  @Test
  void deserializeDiscountRateCouponDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonDiscountRateCouponDto, KakaoTalkCoupon.class);

    TestHelpers.recursiveEquals(deserialized, discountRateCouponDto);
  }

  @Test
  void serializeDiscountRateCouponDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(discountRateCouponDto);

    JSONAssert.assertEquals(jsonDiscountRateCouponDto, serializedString, true);
  }

  @Test
  void deserializeShippingDiscountCouponDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonDiscountShippingCouponDto, KakaoTalkCoupon.class);

    TestHelpers.recursiveEquals(deserialized, discountShippingCouponDto);
  }

  @Test
  void serializesShippingDiscountCouponDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(discountShippingCouponDto);

    JSONAssert.assertEquals(jsonDiscountShippingCouponDto, serializedString, true);
  }

  @Test
  void deserializeFreeCouponDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonFreeCouponDto, KakaoTalkCoupon.class);

    TestHelpers.recursiveEquals(deserialized, freeCouponDto);
  }

  @Test
  void serializeFreeCouponDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(freeCouponDto);

    JSONAssert.assertEquals(jsonFreeCouponDto, serializedString, true);
  }

  @Test
  void deserializeUpCouponDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonUpCouponDto, KakaoTalkCoupon.class);

    TestHelpers.recursiveEquals(deserialized, upCouponDto);
  }

  @Test
  void serializeUpCouponDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(upCouponDto);

    JSONAssert.assertEquals(jsonUpCouponDto, serializedString, true);
  }
}
