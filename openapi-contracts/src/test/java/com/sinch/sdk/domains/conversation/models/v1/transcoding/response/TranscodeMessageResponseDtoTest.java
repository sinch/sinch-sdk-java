package com.sinch.sdk.domains.conversation.models.v1.transcoding.response;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.domains.conversation.api.v1.adapters.ConversationBaseTest;
import com.sinch.sdk.domains.conversation.models.v1.ConversationChannel;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class TranscodeMessageResponseDtoTest extends ConversationBaseTest {

  @GivenTextResource(
      "domains/conversation/v1/transcoding/response/TranscodeMessageResponseDto.json")
  String jsonTranscodeMessageResponseDto;

  public static TranscodeMessageResponse expectedTranscodeMessageResponseDto =
      TranscodeMessageResponse.builder()
          .setTranscodedMessage(
              Collections.singletonMap(
                  ConversationChannel.WHATSAPP,
                  "{\"messaging_product\":\"whatsapp\",\"biz_opaque_callback_data\":null,\"to\":\"to"
                      + " value\",\"type\":\"location\",\"recipient_type\":\"individual\",\"location\":{\"longitude\":\"-2.822915\",\"latitude\":\"47.62798\",\"name\":\"Coordinates"
                      + " title\"}}"))
          .build();

  @Test
  void deserializeDto() throws JsonProcessingException {
    Object deserialized =
        objectMapper.readValue(jsonTranscodeMessageResponseDto, TranscodeMessageResponse.class);

    Assertions.assertThat(deserialized)
        .usingRecursiveComparison()
        .isEqualTo(expectedTranscodeMessageResponseDto);
  }
}
