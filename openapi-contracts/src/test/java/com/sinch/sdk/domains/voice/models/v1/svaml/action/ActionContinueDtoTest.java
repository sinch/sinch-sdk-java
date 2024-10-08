package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionContinueDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionContinueDto.NameEnum;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ActionContinueDtoTest extends BaseTest {

  public static SvamlActionContinueDto dto =
      new SvamlActionContinueDto().name(NameEnum.CONTINUE.getValue());

  @GivenTextResource("/domains/voice/v1/svaml/action/ActionContinueDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(json, serializedString, true);
  }
}
