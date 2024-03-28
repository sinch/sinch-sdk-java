package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class TextMessageDtoTest extends BaseTest {

  public static TextMessage textMessageDto =
      TextMessage.builder().setText("This is a text message.").build();

  @GivenTextResource("/domains/conversation/v1/messages/TextMessageDto.json")
  String jsonTextMessageDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(textMessageDto);

    JSONAssert.assertEquals(jsonTextMessageDto, serializedString, true);
  }
}
