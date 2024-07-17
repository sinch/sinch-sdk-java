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
public class ReactionEventDtoTest extends ConversationBaseTest {

  @GivenJsonResource("domains/conversation/v1/events/contactmessage/ReactionEventDto.json")
  ContactMessageEventInternalImpl dtoReactionEventEventDto;

  @GivenTextResource("domains/conversation/v1/events/contactmessage/ReactionEventDto.json")
  String jsonReactionEventDto;

  public static ReactionEvent expectedReactionEventDto =
      ReactionEvent.builder()
          .setEmoji("\uD83D\uDD25 Java SDK")
          .setAction(ReactionAction.REACT)
          .setMessageId("message id value")
          .setReactionCategory("reaction category")
          .build();

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedReactionEventDto);
    JSONAssert.assertEquals(jsonReactionEventDto, serializedString, true);
  }

  @Test
  void deserialize() {
    TestHelpers.recursiveEquals(
        dtoReactionEventEventDto.getReactionEventImpl(), expectedReactionEventDto);
  }
}
