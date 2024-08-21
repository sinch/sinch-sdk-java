package com.sinch.sdk.domains.conversation.models.v1.conversations.response;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.conversation.response.ConversationRecentMessage;
import com.sinch.sdk.domains.conversation.models.v1.conversations.ConversationDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.ConversationMessageDtoTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ConversationRecentMessageDtoTest extends ConversationBaseTest {

  @GivenTextResource(
      "domains/conversation/v1/conversations/response/ConversationRecentMessageDto.json")
  String jsonConversationRecentMessageDto;

  public static ConversationRecentMessage conversationRecentMessage =
      ConversationRecentMessage.builder()
          .setConversation(ConversationDtoTest.conversation)
          .setLastMessage(ConversationMessageDtoTest.contactConversationMessage)
          .build();

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(conversationRecentMessage);

    JSONAssert.assertEquals(jsonConversationRecentMessageDto, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonConversationRecentMessageDto, ConversationRecentMessage.class);

    TestHelpers.recursiveEquals(deserialized, conversationRecentMessage);
  }
}
