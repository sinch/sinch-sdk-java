package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ReplyToDtoTest extends BaseTest {

  public static ReplyTo replyToDto = ReplyTo.builder().setMessageId("message id value").build();

  @GivenTextResource("/domains/conversation/v1/messages/ReplyToDto.json")
  String jsonReplyToMessageDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(replyToDto);

    JSONAssert.assertEquals(jsonReplyToMessageDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonReplyToMessageDto, ReplyTo.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(replyToDto);
  }
}
