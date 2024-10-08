package com.sinch.sdk.domains.voice.models.v1.svaml.instruction;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class SvamlInstructionStartRecordingTest extends BaseTest {

  public static SvamlInstructionStartRecording dto =
      SvamlInstructionStartRecording.builder()
          .setOptions(
              StartRecordingOptions.builder()
                  .setCredentials("credential value")
                  .setDestinationUrl("destination value")
                  .setFormat("mp3")
                  .setNotificationEvents(true)
                  .setTranscriptionOptions(
                      TranscriptionOptions.builder().setEnabled(true).setLocale("en-US").build())
                  .build())
          .build();

  @GivenTextResource("/domains/voice/v1/svaml/instruction/SvamlInstructionStartRecordingDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(json, serializedString, true);
  }
}
