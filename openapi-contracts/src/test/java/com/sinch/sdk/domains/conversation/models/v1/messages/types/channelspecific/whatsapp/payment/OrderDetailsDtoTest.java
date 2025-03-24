package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.WhatsAppInteractiveBody;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.WhatsAppInteractiveFooter;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.WhatsAppInteractiveHeaderDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.OrderDetailsPayment.TypeEnum;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.OrderDetailsPayment.TypeOfGoodsEnum;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.OrderDetailsPaymentSettingsDynamicPix.KeyTypeEnum;
import java.time.Instant;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class OrderDetailsDtoTest extends ConversationBaseTest {

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/whatsapp/payment/OrderDetailsDto.json")
  static String jsonOrderDetailsDto;

  public static OrderDetails ORDER_DETAILS_DTO =
      OrderDetails.builder()
          .setHeader(WhatsAppInteractiveHeaderDtoTest.headerDocument)
          .setBody(WhatsAppInteractiveBody.builder().setText("Flow message body").build())
          .setFooter(WhatsAppInteractiveFooter.builder().setText("Flow message footer").build())
          .setPayment(
              OrderDetailsPayment.builder()
                  .setOrder(
                      OrderDetailsPaymentOrder.builder()
                          .setCatalogId("catalog id")
                          .setDiscountDescription("discount description")
                          .setDiscountProgramName("discount program name")
                          .setDiscountValue(1000)
                          .setExpirationDescription("expiration description")
                          .setExpirationTime(Instant.parse("2025-03-14T06:43:47Z"))
                          .setItems(
                              Arrays.asList(
                                  OrderDetailsPaymentOrderItems.builder()
                                      .setAmountValue(2000)
                                      .setName("item name")
                                      .setQuantity(3000)
                                      .setRetailerId("item retailer id")
                                      .setSaleAmountValue(4000)
                                      .build()))
                          .setShippingDescription("shipping description")
                          .setShippingValue(5000)
                          .setSubtotalValue(6000)
                          .setTaxDescription("tax description")
                          .setTaxValue(7000)
                          .build())
                  .setPaymentSettings(
                      OrderDetailsPaymentSettings.builder()
                          .setDynamicPix(
                              OrderDetailsPaymentSettingsDynamicPix.builder()
                                  .setCode("code value")
                                  .setKey("key value")
                                  .setKeyType(KeyTypeEnum.CNPJ)
                                  .setMerchantName("merchant name")
                                  .build())
                          .build())
                  .setReferenceId("a reference ID")
                  .setTotalAmountValue(1200)
                  .setType(TypeEnum.BR)
                  .setTypeOfGoods(TypeOfGoodsEnum.DIGITAL_GOODS)
                  .build())
          .build();

  @Test
  void deserializeOrderDetailsDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonOrderDetailsDto, OrderDetails.class);

    TestHelpers.recursiveEquals(deserialized, ORDER_DETAILS_DTO);
  }

  @Test
  void serializeOrderDetailsDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(ORDER_DETAILS_DTO);

    JSONAssert.assertEquals(jsonOrderDetailsDto, serializedString, true);
  }
}
