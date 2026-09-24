package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class PlayMessageDtoTest extends BaseTest {

  public static final PlayMessage expectedPlayMessage =
      PlayMessage.builder().setPlay(PlayDtoTest.expectedPlay).build();

  @GivenTextResource("/domains/voice/v2/svaml/PlayMessageDto.json")
  String jsonPlayMessage;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedPlayMessage);

    JSONAssert.assertEquals(jsonPlayMessage, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    PlayMessage deserialized = objectMapper.readValue(jsonPlayMessage, PlayMessage.class);

    TestHelpers.recursiveEquals(deserialized, expectedPlayMessage);
  }
}
