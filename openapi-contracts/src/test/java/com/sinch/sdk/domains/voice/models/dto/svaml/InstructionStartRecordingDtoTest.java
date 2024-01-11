package com.sinch.sdk.domains.voice.models.dto.svaml;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionStartRecordingDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionStartRecordingDto.NameEnum;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionStartRecordingOptionsDto;
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
                  .notificationEvents(true));

  @GivenTextResource("/domains/voice/svaml/InstructionStartRecordingDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(json, serializedString, true);
  }
}
