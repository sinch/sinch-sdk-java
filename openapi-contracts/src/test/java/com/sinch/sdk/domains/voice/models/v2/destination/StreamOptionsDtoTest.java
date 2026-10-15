package com.sinch.sdk.domains.voice.models.v2.destination;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class StreamOptionsDtoTest extends BaseTest {

  public static final StreamOptions expectedStreamOptions =
      StreamOptions.builder()
          .setVersion(1)
          .setCodec(StreamOptions.CodecEnum.PCM)
          .setSampleRate(StreamOptions.SampleRateEnum.HZ_16000)
          .build();

  @GivenTextResource("/domains/voice/v2/destination/StreamOptionsDto.json")
  String jsonStreamOptions;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedStreamOptions);

    JSONAssert.assertEquals(jsonStreamOptions, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    StreamOptions deserialized = objectMapper.readValue(jsonStreamOptions, StreamOptions.class);

    TestHelpers.recursiveEquals(deserialized, expectedStreamOptions);
  }
}
