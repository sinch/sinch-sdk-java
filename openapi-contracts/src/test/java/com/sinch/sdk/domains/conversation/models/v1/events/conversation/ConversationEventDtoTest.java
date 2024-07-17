package com.sinch.sdk.domains.conversation.models.v1.events.conversation;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ConversationDirection;
import com.sinch.sdk.domains.conversation.models.v1.ProcessingMode;
import com.sinch.sdk.domains.conversation.models.v1.events.EventGenericDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.ChannelIdentityDtoTest;
import java.time.Instant;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ConversationEventDtoTest extends ConversationBaseTest {

  @GivenJsonResource(
      "domains/conversation/v1/events/conversation/ConversationEventContactEventDto.json")
  ConversationEvent dtoEventContact;

  @GivenTextResource(
      "domains/conversation/v1/events/conversation/ConversationEventContactEventDto.json")
  String jsonEventContact;

  public static ConversationEvent expectedEventContactEventDto =
      ConversationEvent.builder()
          .setDirection(ConversationDirection.TO_APP)
          .setEvent(EventGenericDtoTest.expectedDto)
          .setId("event id")
          .setConversationId("conversation id")
          .setContactId("contact id")
          .setChannelIdentity(ChannelIdentityDtoTest.expectedDto)
          .setAcceptTime(Instant.parse("2020-11-17T16:07:15Z"))
          .setProcessingMode(ProcessingMode.DISPATCH)
          .build();

  @Test
  void serializeEventContact() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedEventContactEventDto);
    JSONAssert.assertEquals(jsonEventContact, serializedString, true);
  }

  @Test
  void deserializeEventContact() {
    TestHelpers.recursiveEquals(dtoEventContact, expectedEventContactEventDto);
  }
}
