package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.kakaotalk.commerce;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class KakaoTalkCommerceDtoTest extends ConversationBaseTest {

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/kakaotalk/commerce/DiscountFixedCommerceDto.json")
  static String jsonDiscountFixedCommerceDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/kakaotalk/commerce/DiscountRateCommerceDto.json")
  static String jsonDiscountRateCommerceDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/kakaotalk/commerce/RegularPriceCommerceDto.json")
  static String jsonRegularPriceCommerceDto;

  public static KakaoTalkCommerce discountFixedCommerceDto =
      DiscountFixedCommerce.builder()
          .setTitle("Special Discounted Product")
          .setRegularPrice(1000)
          .setDiscountPrice(500)
          .setDiscountFixed(400)
          .build();

  public static KakaoTalkCommerce discountRateCommerceDto =
      DiscountRateCommerce.builder()
          .setTitle("Special Discounted Product")
          .setRegularPrice(1000)
          .setDiscountPrice(500)
          .setDiscountRate(40)
          .build();

  public static KakaoTalkCommerce regularPriceCommerceDto =
      RegularPriceCommerce.builder()
          .setTitle("Special Discounted Product")
          .setRegularPrice(1000)
          .build();

  @Test
  void deserializeDiscountFixedCommerceDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonDiscountFixedCommerceDto, KakaoTalkCommerce.class);

    TestHelpers.recursiveEquals(deserialized, discountFixedCommerceDto);
  }

  @Test
  void serializeDiscountFixedCommerceDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(discountFixedCommerceDto);

    JSONAssert.assertEquals(jsonDiscountFixedCommerceDto, serializedString, true);
  }

  @Test
  void deserializeDiscountRateCommerceDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonDiscountRateCommerceDto, KakaoTalkCommerce.class);

    TestHelpers.recursiveEquals(deserialized, discountRateCommerceDto);
  }

  @Test
  void serializeDiscountRateCommerceDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(discountRateCommerceDto);

    JSONAssert.assertEquals(jsonDiscountRateCommerceDto, serializedString, true);
  }

  @Test
  void deserializeRegularPriceCommerceDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonRegularPriceCommerceDto, KakaoTalkCommerce.class);

    TestHelpers.recursiveEquals(deserialized, regularPriceCommerceDto);
  }

  @Test
  void serializeRegularPriceCommerceDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(regularPriceCommerceDto);

    JSONAssert.assertEquals(jsonRegularPriceCommerceDto, serializedString, true);
  }
}
