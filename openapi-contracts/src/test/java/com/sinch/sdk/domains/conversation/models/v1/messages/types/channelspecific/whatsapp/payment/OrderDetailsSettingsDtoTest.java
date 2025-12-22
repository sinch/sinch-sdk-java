package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.OrderDetailsPaymentSettingsDynamicPix.KeyTypeEnum;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class OrderDetailsSettingsDtoTest extends ConversationBaseTest {

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/whatsapp/payment/OrderDetailsSettingsDynamicPixDto.json")
  static String jsonDynamicPixDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/whatsapp/payment/OrderDetailsSettingsPaymentLinkDto.json")
  static String jsonPaymentLinkDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/whatsapp/payment/OrderDetailsSettingsBoletoDto.json")
  static String jsonBoletoDto;

  public static OrderDetailsSettings dynamicPix =
      OrderDetailsPaymentSettingsDynamicPix.builder()
          .setCode("code value")
          .setKey("key value")
          .setKeyType(KeyTypeEnum.CNPJ)
          .setMerchantName("merchant name")
          .build();

  public static OrderDetailsSettings paymentLink =
      OrderDetailsPaymentSettingsPaymentLink.builder()
          .setUri("https://payment.link/abc123")
          .build();

  public static OrderDetailsSettings boleto =
      OrderDetailsPaymentSettingsBoleto.builder()
          .setDigitableLine("00190.00009 01234.567890 12345.678901 7 89010000012345")
          .build();

  @Test
  void deserializeDynamicPix() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonDynamicPixDto, OrderDetailsSettings.class);

    TestHelpers.recursiveEquals(deserialized, dynamicPix);
  }

  @Test
  void serializeDynamicPix() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dynamicPix);

    JSONAssert.assertEquals(jsonDynamicPixDto, serializedString, true);
  }

  @Test
  void deserializePaymentLink() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonPaymentLinkDto, OrderDetailsSettings.class);

    TestHelpers.recursiveEquals(deserialized, paymentLink);
  }

  @Test
  void serializePaymentLink() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(paymentLink);

    JSONAssert.assertEquals(jsonPaymentLinkDto, serializedString, true);
  }

  @Test
  void deserializeBoleto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonBoletoDto, OrderDetailsSettings.class);

    TestHelpers.recursiveEquals(deserialized, boleto);
  }

  @Test
  void serializeBoleto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(boleto);

    JSONAssert.assertEquals(jsonBoletoDto, serializedString, true);
  }
}
