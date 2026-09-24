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
public class StreamDtoTest extends BaseTest {

  public static final Stream expectedStream =
      Stream.builder().setStream(StreamDetailsDtoTest.expectedStreamDetails).build();

  @GivenTextResource("/domains/voice/v2/destination/StreamDto.json")
  String jsonStream;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedStream);

    JSONAssert.assertEquals(jsonStream, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    Stream deserialized = objectMapper.readValue(jsonStream, Stream.class);

    TestHelpers.recursiveEquals(deserialized, expectedStream);
  }
}
