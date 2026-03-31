package com.sinch.sdk.domains.conversation.models.v1.messages.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class UpdateMessageDtoTest extends ConversationBaseTest {

  @GivenTextResource("/domains/conversation/v1/messages/request/MessageUpdateRequestDto.json")
  String jsonMessageUpdateRequestDto;

  public static MessageUpdateRequest updateMessageRequestDto =
      MessageUpdateRequest.builder().setMetadata("metadata value").build();

  @Test
  void serializeMessageUpdateRequestDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(updateMessageRequestDto);

    JSONAssert.assertEquals(jsonMessageUpdateRequestDto, serializedString, true);
  }
}
