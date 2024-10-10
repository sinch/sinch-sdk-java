package com.sinch.sdk.domains.voice.models.v1.svaml.instruction;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionAnswerDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionAnswerDto.NameEnum;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class InstructionAnswerDtoTest extends BaseTest {

  public static SvamlInstructionAnswerDto dto =
      new SvamlInstructionAnswerDto().name(NameEnum.ANSWER.getValue());

  @GivenTextResource("/domains/voice/v1/svaml/instruction/InstructionAnswerDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(json, serializedString, true);
  }
}
