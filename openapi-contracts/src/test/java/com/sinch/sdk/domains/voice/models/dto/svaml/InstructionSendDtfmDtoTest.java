package com.sinch.sdk.domains.voice.models.dto.svaml;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionSendDtmfDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionSendDtmfDto.NameEnum;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class InstructionSendDtfmDtoTest extends BaseTest {

  public static SvamlInstructionSendDtmfDto dto =
      new SvamlInstructionSendDtmfDto().name(NameEnum.SENDDTMF.getValue()).value("ww123#");

  @GivenTextResource("/domains/voice/svaml/InstructionSendDtfmDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(json, serializedString, true);
  }
}
