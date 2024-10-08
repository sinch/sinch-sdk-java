package com.sinch.sdk.domains.voice.models.v1.svaml.instruction;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionSayDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionSayDto.NameEnum;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class InstructionSayDtoTest extends BaseTest {

  public static SvamlInstructionSayDto dto =
      new SvamlInstructionSayDto().name(NameEnum.SAY.getValue()).text("[Welcome]").locale("en");

  @GivenTextResource("/domains/voice/v1/svaml/instruction/InstructionSayDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(json, serializedString, true);
  }
}
