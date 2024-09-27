package com.sinch.sdk.domains.conversation.models.v1.events;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.events.internal.ContactMessageEventInternalImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.types.PaymentStatusUpdateEventDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.events.types.PaymentStatusUpdateEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.types.ReactionEventDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.events.types.ReactionEventImpl;
import com.sinch.sdk.domains.conversation.models.v1.events.types.ShortLinkActivatedEventDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.events.types.ShortLinkActivatedEventImpl;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ContactMessageEventDtoTest extends ConversationBaseTest {

  @GivenJsonResource("domains/conversation/v1/events/types/PaymentStatusUpdateEventDto.json")
  ContactMessageEventInternalImpl dtoPaymentStatusUpdateEvent;

  @GivenTextResource("domains/conversation/v1/events/types/PaymentStatusUpdateEventDto.json")
  String jsonPaymentStatusUpdateEvent;

  @GivenJsonResource("domains/conversation/v1/events/types/ShortLinkActivatedEventDto.json")
  ContactMessageEventInternalImpl dtoShortLinkActivatedEvent;

  @GivenTextResource("domains/conversation/v1/events/types/ShortLinkActivatedEventDto.json")
  String jsonShortLinkActivatedEvent;

  @GivenJsonResource("domains/conversation/v1/events/types/ReactionEventDto.json")
  ContactMessageEventInternalImpl dtoReactionEvent;

  @GivenTextResource("domains/conversation/v1/events/types/ReactionEventDto.json")
  String jsonReactionEvent;

  public static ContactMessageEventInternalImpl expectedPaymentStatusUpdateEventDto =
      new ContactMessageEventInternalImpl(
          (PaymentStatusUpdateEventImpl)
              PaymentStatusUpdateEventDtoTest.expectedPaymentStatusUpdateEventDto);

  public static ContactMessageEventInternalImpl expectedShortLinkActivatedEventDto =
      new ContactMessageEventInternalImpl(
          (ShortLinkActivatedEventImpl)
              ShortLinkActivatedEventDtoTest.expectedShortLinkActivatedEventDto);

  public static ContactMessageEventInternalImpl expectedReactionEventDto =
      new ContactMessageEventInternalImpl(
          (ReactionEventImpl) ReactionEventDtoTest.expectedReactionEventDto);

  @Test
  void serializePaymentStatusUpdateEventDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedPaymentStatusUpdateEventDto);
    JSONAssert.assertEquals(jsonPaymentStatusUpdateEvent, serializedString, true);
  }

  @Test
  void deserializePaymentStatusUpdateEventDto() {
    TestHelpers.recursiveEquals(dtoPaymentStatusUpdateEvent, expectedPaymentStatusUpdateEventDto);
  }

  @Test
  void serializeShortLinkActivatedEventDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedShortLinkActivatedEventDto);
    JSONAssert.assertEquals(jsonShortLinkActivatedEvent, serializedString, true);
  }

  @Test
  void deserializeShortLinkActivatedEventDto() {
    TestHelpers.recursiveEquals(dtoShortLinkActivatedEvent, expectedShortLinkActivatedEventDto);
  }

  @Test
  void serializeReactionEventDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedReactionEventDto);
    JSONAssert.assertEquals(jsonReactionEvent, serializedString, true);
  }

  @Test
  void deserializeReactionEventDto() {
    TestHelpers.recursiveEquals(dtoReactionEvent, expectedReactionEventDto);
  }
}
