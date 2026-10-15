package com.sinch.sdk.domains.voice.models.v2.svaml.recording;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.HangupCommandDtoTest;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class RecordingEventsDtoTest extends BaseTest {

  public static final RecordingEvents expectedRecordingEvents =
      RecordingEvents.builder()
          .setOnFinish(Arrays.asList(HangupCommandDtoTest.expectedHangupCommand))
          .setOnFailure(Arrays.asList(HangupCommandDtoTest.expectedHangupCommand))
          .build();

  @GivenTextResource("/domains/voice/v2/svaml/recording/RecordingEventsDto.json")
  String jsonRecordingEvents;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedRecordingEvents);

    JSONAssert.assertEquals(jsonRecordingEvents, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    RecordingEvents deserialized =
        objectMapper.readValue(jsonRecordingEvents, RecordingEvents.class);

    TestHelpers.recursiveEquals(deserialized, expectedRecordingEvents);
  }
}
