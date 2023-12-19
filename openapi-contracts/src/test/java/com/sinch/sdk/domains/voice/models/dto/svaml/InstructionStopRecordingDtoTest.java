package com.sinch.sdk.domains.voice.models.dto.svaml;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionStopRecordingDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionStopRecordingDto.NameEnum;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class InstructionStopRecordingDtoTest extends BaseTest {

  public static SvamlInstructionStopRecordingDto dto =
      new SvamlInstructionStopRecordingDto().name(NameEnum.STOPRECORDING.getValue());

  @GivenTextResource("/domains/voice/svaml/InstructionStopRecordingDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(json, serializedString, true);
  }
}
