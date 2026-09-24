package com.sinch.sdk.domains.voice.models.v2.destination;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class StreamDetailsDtoTest extends BaseTest {

  public static final StreamDetails expectedStreamDetails =
      StreamDetails.builder()
          .setEndpoint("wss://myapp.example.com/audio")
          .setStreamOptions(StreamOptionsDtoTest.expectedStreamOptions)
          .setCallHeaders(Arrays.asList(CallHeaderDtoTest.expectedCallHeader))
          .build();

  @GivenTextResource("/domains/voice/v2/destination/StreamDetailsDto.json")
  String jsonStreamDetails;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedStreamDetails);

    JSONAssert.assertEquals(jsonStreamDetails, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    StreamDetails deserialized = objectMapper.readValue(jsonStreamDetails, StreamDetails.class);

    TestHelpers.recursiveEquals(deserialized, expectedStreamDetails);
  }
}
