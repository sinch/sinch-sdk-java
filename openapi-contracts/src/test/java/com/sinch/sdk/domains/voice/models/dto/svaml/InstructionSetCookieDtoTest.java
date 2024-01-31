package com.sinch.sdk.domains.voice.models.dto.svaml;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionSetCookieDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlInstructionSetCookieDto.NameEnum;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class InstructionSetCookieDtoTest extends BaseTest {

  public static SvamlInstructionSetCookieDto dto =
      new SvamlInstructionSetCookieDto()
          .name(NameEnum.SETCOOKIE.getValue())
          .key("a key")
          .value("a value");

  @GivenTextResource("/domains/voice/svaml/InstructionSetCookieDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(json, serializedString, true);
  }
}
