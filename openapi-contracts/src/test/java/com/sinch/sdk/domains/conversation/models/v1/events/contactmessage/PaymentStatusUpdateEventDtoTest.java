package com.sinch.sdk.domains.conversation.models.v1.events.contactmessage;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.events.contactmessage.internal.ContactMessageEventInternalImpl;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class PaymentStatusUpdateEventDtoTest extends ConversationBaseTest {

  @GivenJsonResource(
      "domains/conversation/v1/events/contactmessage/PaymentStatusUpdateEventDto.json")
  ContactMessageEventInternalImpl dtoPaymentStatusUpdateEventDto;

  @GivenTextResource(
      "domains/conversation/v1/events/contactmessage/PaymentStatusUpdateEventDto.json")
  String jsonPaymentStatusUpdateEventDto;

  public static PaymentStatusUpdateEvent expectedPaymentStatusUpdateEventDto =
      PaymentStatusUpdateEvent.builder()
          .setReferenceId("a reference id")
          .setPaymentStatus(PaymentStatus.CAPTURED)
          .setPaymentTransactionStatus(PaymentTransactionStatus.PENDING)
          .setPaymentTransactionId("a payment transaction id")
          .build();

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedPaymentStatusUpdateEventDto);
    JSONAssert.assertEquals(jsonPaymentStatusUpdateEventDto, serializedString, true);
  }

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(
        dtoPaymentStatusUpdateEventDto.getPaymentStatusUpdateEventImpl(),
        expectedPaymentStatusUpdateEventDto);
  }
}
