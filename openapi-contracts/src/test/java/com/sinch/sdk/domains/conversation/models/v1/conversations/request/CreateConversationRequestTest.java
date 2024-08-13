package com.sinch.sdk.domains.conversation.models.v1.conversations.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.conversation.request.CreateConversationRequest;
import com.sinch.sdk.domains.conversation.models.v1.messages.types.text.TextMessage;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class CreateConversationRequestTest extends ConversationBaseTest {

  public static CreateConversationRequest createConversationRequestDto =
      CreateConversationRequest.<TextMessage>builder()
          .setActive(true)
          .setActiveChannel(ConversationChannel.WHATSAPP)
          .setAppId("conversation app Id")
          .setContactId("contact ID")
          .setMetadata("metadata value")
          .setMetadataJson(Collections.singletonMap("metadata_json_key", "metadata json value"))
          .setCorrelationId("correlation id value")
          .build();

  @GivenTextResource(
      "/domains/conversation/v1/conversations/request/CreateConversationRequestDto.json")
  static String jsonCreateConversationRequestDto;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(createConversationRequestDto);

    JSONAssert.assertEquals(jsonCreateConversationRequestDto, serializedString, true);
  }
}
