package com.sinch.sdk.domains.conversation.models.v1.messages.types.replyto;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;

@TestWithResources
public class ReplyToMessageDtoTest extends BaseTest {

  /*
    TODO Temporary removed: waiting for https://tickets.sinch.com/browse/CACORE-2200 status

  public static ReplyToMessage replyToMessageDto =
      ReplyToMessage.builder().setMessageId("message id value").build();

  @GivenTextResource("/domains/conversation/v1/messages/types/replyto/ReplyToMessageDto.json")
  String jsonReplyToMessageDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(replyToMessageDto);

    JSONAssert.assertEquals(jsonReplyToMessageDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonReplyToMessageDto, ReplyToMessage.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(replyToMessageDto);
  }*/
}
