package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.adapters.ConversationBaseTest;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class UrlMessageDtoTest extends ConversationBaseTest {

  public static UrlMessage urlMessageDto =
      UrlMessage.builder().setTitle("title value").setUrl("an url value").build();

  @GivenTextResource("/domains/conversation/v1/messages/UrlMessageDto.json")
  String jsonUrlMessageDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(urlMessageDto);

    JSONAssert.assertEquals(jsonUrlMessageDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonUrlMessageDto, UrlMessage.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(urlMessageDto);
  }
}
