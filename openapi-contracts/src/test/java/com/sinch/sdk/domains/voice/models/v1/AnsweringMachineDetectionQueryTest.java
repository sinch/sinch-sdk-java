package com.sinch.sdk.domains.voice.models.v1;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class AnsweringMachineDetectionQueryTest extends BaseTest {

  public static AnsweringMachineDetectionQuery dto =
      AnsweringMachineDetectionQuery.builder().setEnabled(true).setAsync(true).build();

  @GivenTextResource("/domains/voice/v1/AnsweringMachineDetectionQueryDto.json")
  String json;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(dto);

    JSONAssert.assertEquals(json, serializedString, true);
  }
}
