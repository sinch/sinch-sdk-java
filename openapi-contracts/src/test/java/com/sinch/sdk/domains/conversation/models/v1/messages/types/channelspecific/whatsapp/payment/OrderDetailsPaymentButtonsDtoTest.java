package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.OrderDetailsPaymentButtonDynamicPix.KeyTypeEnum;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class OrderDetailsPaymentButtonsDtoTest extends ConversationBaseTest {

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/whatsapp/payment/OrderDetailsPaymentButtonDynamicPixDto.json")
  static String orderDetailsPaymentButtonPixDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/whatsapp/payment/OrderDetailsPaymentButtonLinkDto.json")
  static String orderDetailsPaymentButtonPaymentLinkDto;

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/whatsapp/payment/OrderDetailsPaymentButtonBoletoDto.json")
  static String orderDetailsPaymentButtonBoletoDto;

  public static OrderDetailsPaymentButtonDynamicPix dynamicPix =
      OrderDetailsPaymentButtonDynamicPix.builder()
          .setCode("code value")
          .setKey("key value")
          .setKeyType(KeyTypeEnum.CNPJ)
          .setMerchantName("merchant name")
          .build();

  public static OrderDetailsPaymentButtonPaymentLink paymentLink =
      OrderDetailsPaymentButtonPaymentLink.builder().setUri("https://payment.link/abc123").build();

  public static OrderDetailsPaymentButtonBoleto boleto =
      OrderDetailsPaymentButtonBoleto.builder()
          .setDigitableLine("00190.00009 01234.567890 12345.678901 7 89010000012345")
          .build();

  @Test
  void deserializeDynamicPix() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(orderDetailsPaymentButtonPixDto, WhatsAppPaymentButton.class);

    TestHelpers.recursiveEquals(deserialized, dynamicPix);
  }

  @Test
  void serializeDynamicPix() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dynamicPix);

    JSONAssert.assertEquals(orderDetailsPaymentButtonPixDto, serializedString, true);
  }

  @Test
  void deserializePaymentLink() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(
            orderDetailsPaymentButtonPaymentLinkDto, WhatsAppPaymentButton.class);

    TestHelpers.recursiveEquals(deserialized, paymentLink);
  }

  @Test
  void serializePaymentLink() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(paymentLink);

    JSONAssert.assertEquals(orderDetailsPaymentButtonPaymentLinkDto, serializedString, true);
  }

  @Test
  void deserializeBoleto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(orderDetailsPaymentButtonBoletoDto, WhatsAppPaymentButton.class);

    TestHelpers.recursiveEquals(deserialized, boleto);
  }

  @Test
  void serializeBoleto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(boleto);

    JSONAssert.assertEquals(orderDetailsPaymentButtonBoletoDto, serializedString, true);
  }
}
