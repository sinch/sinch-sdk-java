package com.sinch.sdk.domains.voice.models.v1.svaml.instruction;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionPlayFilesDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionPlayFilesDto.NameEnum;
import java.util.Collections;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class InstructionPlayFilesDtoTest extends BaseTest {

  public static SvamlInstructionPlayFilesDto dto =
      new SvamlInstructionPlayFilesDto()
          .name(NameEnum.PLAYFILES.getValue())
          .ids(Collections.singletonList("[Welcome]"))
          .locale("en");

  @GivenTextResource("/domains/voice/v1/svaml/instruction/InstructionPlayFilesDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(json, serializedString, true);
  }
}
