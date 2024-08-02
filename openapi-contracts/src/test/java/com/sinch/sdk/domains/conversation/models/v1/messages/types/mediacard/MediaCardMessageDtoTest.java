package com.sinch.sdk.domains.conversation.models.v1.messages.types.mediacard;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import org.assertj.core.api.Assertions;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class MediaCardMessageDtoTest extends BaseTest {

  public static MediaCardMessage mediaCardMessageDto =
      MediaCardMessage.builder().setCaption("caption value").setUrl("an url value").build();

  @GivenTextResource("/domains/conversation/v1/messages/types/mediacard/MediaCardMessageDto.json")
  String jsonMediaCardMessageDto;

  @Test
  void serializeMessageDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(mediaCardMessageDto);

    JSONAssert.assertEquals(jsonMediaCardMessageDto, serializedString, true);
  }

  @Test
  void deserializeMessageDto() throws JsonProcessingException {
    Object deserialized = objectMapper.readValue(jsonMediaCardMessageDto, MediaCardMessage.class);

    Assertions.assertThat(deserialized).usingRecursiveComparison().isEqualTo(mediaCardMessageDto);
  }
}
