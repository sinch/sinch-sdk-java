package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionParkDto;
import com.sinch.sdk.domains.voice.models.dto.v1.SvamlActionParkDto.NameEnum;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ActionParkDtoTest extends BaseTest {

  public static SvamlActionParkDto dto =
      new SvamlActionParkDto()
          .name(NameEnum.PARK.getValue())
          .locale("en")
          .introPrompt("intro prompt")
          .holdPrompt("hold prompt")
          .maxDuration(456);

  @GivenTextResource("/domains/voice/v1/svaml/action/ActionParkDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(json, serializedString, true);
  }
}
