package com.sinch.sdk.domains.conversation.models.v1.conversations;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.conversation.Conversation;
import java.time.Instant;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ConversationDtoTest extends ConversationBaseTest {

  @GivenTextResource("domains/conversation/v1/conversations/ConversationDto.json")
  String jsonConversation;

  public static Conversation conversation =
      Conversation.builder()
          .setActive(true)
          .setActiveChannel(ConversationChannel.WHATSAPP)
          .setAppId("conversation app Id")
          .setContactId("contact ID")
          .setId("a conversation id")
          .setLastReceived(Instant.parse("2020-11-17T15:00:00Z"))
          .setMetadata("metadata value")
          .setMetadataJson(Collections.singletonMap("metadata_json_key", "metadata json value"))
          .setCorrelationId("correlation id value")
          .build();

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(conversation);

    JSONAssert.assertEquals(jsonConversation, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonConversation, Conversation.class);

    TestHelpers.recursiveEquals(deserialized, conversation);
  }
}
