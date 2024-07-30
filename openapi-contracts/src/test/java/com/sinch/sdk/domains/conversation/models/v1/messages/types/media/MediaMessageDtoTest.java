package com.sinch.sdk.domains.conversation.models.v1.messages.types.media;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class MediaMessageDtoTest extends BaseTest {

  public static MediaMessage mediaMessageDto =
      MediaMessage.builder()
          .setUrl("an url value")
          .setThumbnailUrl("another url")
          .setFilenameOverride("filename override value")
          .build();

  @GivenTextResource("/domains/conversation/v1/messages/types/media/MediaMessageDto.json")
  String jsonMediaMessageDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(mediaMessageDto);

    JSONAssert.assertEquals(jsonMediaMessageDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonMediaMessageDto, MediaMessage.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(mediaMessageDto);
  }
}
