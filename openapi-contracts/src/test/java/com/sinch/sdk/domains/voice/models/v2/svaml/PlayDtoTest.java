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
public class PlayDtoTest extends BaseTest {

  public static final Play expectedPlay =
      Play.builder().setUrl("https://example.com/audio/welcome.mp3").build();

  @GivenTextResource("/domains/voice/v2/svaml/PlayDto.json")
  String jsonPlay;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedPlay);

    JSONAssert.assertEquals(jsonPlay, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    Play deserialized = objectMapper.readValue(jsonPlay, Play.class);

    TestHelpers.recursiveEquals(deserialized, expectedPlay);
  }
}
