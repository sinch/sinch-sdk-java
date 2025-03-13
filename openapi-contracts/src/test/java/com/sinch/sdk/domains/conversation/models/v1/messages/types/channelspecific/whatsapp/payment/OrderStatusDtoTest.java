package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.WhatsAppInteractiveBody;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.WhatsAppInteractiveFooter;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.flows.WhatsAppInteractiveHeaderDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment.OrderStatusPaymentDetails.StatusEnum;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class OrderStatusDtoTest extends ConversationBaseTest {

  @GivenTextResource(
      "/domains/conversation/v1/messages/types/channelspecific/whatsapp/payment/OrderStatusDto.json")
  static String jsonOrderStatusDto;

  public static OrderStatus ORDER_STATUS_DTO =
      OrderStatus.builder()
          .setHeader(WhatsAppInteractiveHeaderDtoTest.headerDocument)
          .setBody(WhatsAppInteractiveBody.builder().setText("Flow message body").build())
          .setFooter(WhatsAppInteractiveFooter.builder().setText("Flow message footer").build())
          .setPayment(
              OrderStatusPayment.builder()
                  .setReferenceId("order status reference id")
                  .setOrder(
                      OrderStatusPaymentDetails.builder()
                          .setStatus(StatusEnum.CANCELED)
                          .setDescription("Order cancelled")
                          .build())
                  .build())
          .build();

  @Test
  void deserializeOrderStatusDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonOrderStatusDto, OrderStatus.class);

    TestHelpers.recursiveEquals(deserialized, ORDER_STATUS_DTO);
  }

  @Test
  void serializeOrderStatusDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(ORDER_STATUS_DTO);

    JSONAssert.assertEquals(jsonOrderStatusDto, serializedString, true);
  }
}
