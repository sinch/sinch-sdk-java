package com.sinch.sdk.domains.voice.models.v2.svaml.recording;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class StartRecordingCommandDtoTest extends BaseTest {

  public static final StartRecordingCommand expectedStartRecordingCommand =
      StartRecordingCommand.builder()
          .setRecordingName("my-recording")
          .setRecordingOptions(RecordingOptionsDtoTest.expectedRecordingOptions)
          .setEvents(RecordingEventsDtoTest.expectedRecordingEvents)
          .build();

  @GivenTextResource("/domains/voice/v2/svaml/recording/StartRecordingCommandDto.json")
  String jsonStartRecordingCommand;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedStartRecordingCommand);

    JSONAssert.assertEquals(jsonStartRecordingCommand, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    StartRecordingCommand deserialized =
        objectMapper.readValue(jsonStartRecordingCommand, StartRecordingCommand.class);

    TestHelpers.recursiveEquals(deserialized, expectedStartRecordingCommand);
  }
}
