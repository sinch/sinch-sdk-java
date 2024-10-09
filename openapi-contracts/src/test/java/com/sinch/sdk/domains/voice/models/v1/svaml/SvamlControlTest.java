package com.sinch.sdk.domains.voice.models.v1.svaml;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionConnectConference;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.StartRecordingOptions;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionSay;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionStartRecording;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.TranscriptionOptions;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
class SvamlControlTest extends BaseTest {

  public static SvamlControl expectedSvamlControl =
      SvamlControl.builder()
          .setAction(
              SvamlActionConnectConference.builder().setConferenceId("My Conference Id").build())
          .setInstructions(
              Arrays.asList(
                  SvamlInstructionSay.builder().setText("Hello from instruction").build(),
                  SvamlInstructionStartRecording.builder()
                      .setOptions(
                          StartRecordingOptions.builder()
                              .setDestinationUrl("s3://my-bucket/")
                              .setCredentials(
                                  "AKIAIOSFODNN7EXAMPLE:wJalrXUtnFEMI/K7MDENG/bPxRfiCYEXAMPLEKEY:eu-central-1")
                              .setNotificationEvents(true)
                              .setTranscriptionOptions(
                                  TranscriptionOptions.builder().setEnabled(true).build())
                              .build())
                      .build()))
          .build();

  @GivenTextResource("/domains/voice/v1/svaml/SvamlControlDto.json")
  String jsonSvamlControlDto;

  @Test
  void serializeSVAMLResponse() throws JsonProcessingException, JSONException {

    String serializedString = objectMapper.writeValueAsString(expectedSvamlControl);

    JSONAssert.assertEquals(jsonSvamlControlDto, serializedString, true);
  }
}
