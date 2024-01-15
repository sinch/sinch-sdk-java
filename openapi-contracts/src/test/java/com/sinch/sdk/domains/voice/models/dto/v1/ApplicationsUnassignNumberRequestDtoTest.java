package com.sinch.sdk.domains.voice.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ApplicationsUnassignNumberRequestDtoTest extends BaseTest {

  @GivenTextResource("/domains/voice/v1/ApplicationsUnassignNumberRequestDto.json")
  String jsonRequest;

  public static UnassignNumbersDto unassignNumberDto =
      new UnassignNumbersDto().number("+12073091712").applicationkey("an app key");

  @Test
  void serializeUnassignNumbersDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(unassignNumberDto);

    JSONAssert.assertEquals(jsonRequest, serializedString, true);
  }
}
