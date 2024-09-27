package com.sinch.sdk.domains.conversation.models.v1.conversations.response;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.conversation.response.ConversationRecentMessage;
import com.sinch.sdk.domains.conversation.models.v1.conversations.ConversationDtoTest;
import com.sinch.sdk.domains.conversation.models.v1.messages.ConversationMessageDtoTest;
import org.junit.jupiter.api.Test;

@TestWithResources
public class ConversationRecentMessageDtoTest extends ConversationBaseTest {

  @GivenTextResource(
      "domains/conversation/v1/conversations/response/ConversationRecentMessageDto.json")
  String jsonConversationRecentMessageDto;

  public static ConversationRecentMessage conversationRecentMessage =
      ConversationRecentMessage.builder()
          .setConversation(ConversationDtoTest.conversationResponse)
          .setLastMessage(ConversationMessageDtoTest.contactConversationMessageResponse)
          .build();

  @Test
  void deserialize() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonConversationRecentMessageDto, ConversationRecentMessage.class);

    TestHelpers.recursiveEquals(deserialized, conversationRecentMessage);
  }
}
