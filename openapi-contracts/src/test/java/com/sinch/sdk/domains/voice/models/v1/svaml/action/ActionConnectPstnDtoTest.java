package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionConnectPstnAmdDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionConnectPstnDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionConnectPstnDto.NameEnum;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ActionConnectPstnDtoTest extends BaseTest {

  public static SvamlActionConnectPstnDto dto =
      new SvamlActionConnectPstnDto()
          .name(NameEnum.CONNECTPSTN.getValue())
          .number("+123456789")
          .locale("fr")
          .maxDuration(123)
          .dialTimeout(456)
          .cli("cli value")
          .suppressCallbacks(true)
          .dtmf("#w123")
          .indications("unknown value")
          .amd(new SvamlActionConnectPstnAmdDto().enabled(true));

  @GivenTextResource("/domains/voice/v1/svaml/action/ActionConnectPstnDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(json, serializedString, true);
  }
}
