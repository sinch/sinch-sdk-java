package com.sinch.sdk.domains.voice.models.v1.svaml.instruction;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionStartRecordingDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionStartRecordingDto.NameEnum;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionStartRecordingOptionsDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionStartRecordingOptionsTranscriptionOptionsDto;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class InstructionStartRecordingDtoTest extends BaseTest {

  public static SvamlInstructionStartRecordingDto dto =
      new SvamlInstructionStartRecordingDto()
          .name(NameEnum.STARTRECORDING.getValue())
          .options(
              new SvamlInstructionStartRecordingOptionsDto()
                  .credentials("credential value")
                  .destinationUrl("destination value")
                  .format("mp3")
                  .notificationEvents(true)
                  .transcriptionOptions(
                      new SvamlInstructionStartRecordingOptionsTranscriptionOptionsDto()
                          .enabled(true)
                          .locale("en-US")));

  @GivenTextResource("/domains/voice/v1/svaml/instruction/InstructionStartRecordingDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(json, serializedString, true);
  }
}
