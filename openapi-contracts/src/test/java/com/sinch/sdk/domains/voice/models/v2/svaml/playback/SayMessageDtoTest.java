package com.sinch.sdk.domains.voice.models.v2.svaml.playback;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class SayMessageDtoTest extends BaseTest {

  public static final SayMessage expectedSayMessage =
      SayMessage.builder().setSay(SayDtoTest.expectedSay).build();

  @GivenTextResource("/domains/voice/v2/svaml/playback/SayMessageDto.json")
  String jsonSayMessage;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedSayMessage);

    JSONAssert.assertEquals(jsonSayMessage, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    SayMessage deserialized = objectMapper.readValue(jsonSayMessage, SayMessage.class);

    TestHelpers.recursiveEquals(deserialized, expectedSayMessage);
  }
}
