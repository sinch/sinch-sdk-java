package com.sinch.sdk.domains.conversation.models.v1.transcoding.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import com.sinch.sdk.domains.conversation.models.v1.messages.AppMessageDtoTest;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class TranscodeMessageRequestDtoTest extends ConversationBaseTest {

  public static TranscodeMessageRequest transcodeMessageRequestDto =
      TranscodeMessageRequest.builder()
          .setAppId("an app id")
          .setAppMessage(AppMessageDtoTest.appLocationMessageDto)
          .setChannels(Arrays.asList(ConversationChannel.WHATSAPP))
          .setFrom("from value")
          .setTo("to value")
          .build();

  @GivenTextResource("/domains/conversation/v1/transcoding/request/TranscodeMessageRequestDto.json")
  String jsonTranscodeMessageRequestDto;

  @Test
  void serializeDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(transcodeMessageRequestDto);

    JSONAssert.assertEquals(jsonTranscodeMessageRequestDto, serializedString, true);
  }
}
