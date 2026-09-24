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
public class StopRecordingCommandDtoTest extends BaseTest {

  public static final StopRecordingCommand expectedStopRecordingCommand =
      StopRecordingCommand.builder().setRecordingName("my-recording").build();

  @GivenTextResource("/domains/voice/v2/svaml/StopRecordingCommandDto.json")
  String jsonStopRecordingCommand;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedStopRecordingCommand);

    JSONAssert.assertEquals(jsonStopRecordingCommand, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    StopRecordingCommand deserialized =
        objectMapper.readValue(jsonStopRecordingCommand, StopRecordingCommand.class);

    TestHelpers.recursiveEquals(deserialized, expectedStopRecordingCommand);
  }
}
