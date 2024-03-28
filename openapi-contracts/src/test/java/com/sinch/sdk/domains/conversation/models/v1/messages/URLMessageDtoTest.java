package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class URLMessageDtoTest extends BaseTest {

  public static URLMessage urlMessageDto =
      URLMessage.builder().setTitle("title value").setUrl("an url value").build();

  @GivenTextResource("/domains/conversation/v1/messages/URLMessageDto.json")
  String jsonUrlMessageDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(urlMessageDto);

    JSONAssert.assertEquals(jsonUrlMessageDto, serializedString, true);
  }
}
