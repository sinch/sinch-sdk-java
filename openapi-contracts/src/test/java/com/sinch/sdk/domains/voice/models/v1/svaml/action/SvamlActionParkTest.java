package com.sinch.sdk.domains.voice.models.v1.svaml.action;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class SvamlActionParkTest extends BaseTest {

  public static SvamlActionPark dto =
      SvamlActionPark.builder()
          .setLocale("en")
          .setIntroPrompt("intro prompt")
          .setHoldPrompt("hold prompt")
          .setMaxDuration(456)
          .build();

  @GivenTextResource("/domains/voice/v1/svaml/action/SvamlActionParkDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(json, serializedString, true);
  }
}
