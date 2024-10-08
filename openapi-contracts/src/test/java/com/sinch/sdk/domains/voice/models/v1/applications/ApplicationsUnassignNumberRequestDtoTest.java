package com.sinch.sdk.domains.voice.models.v1.applications;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.v1.applications.request.UnAssignNumberRequest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class ApplicationsUnassignNumberRequestDtoTest extends BaseTest {

  @GivenTextResource("/domains/voice/v1/applications/ApplicationsUnassignNumberRequestDto.json")
  String jsonRequest;


  public static UnAssignNumberRequest unAssignNumberDto =
      UnAssignNumberRequest.builder()
          .setNumber("+12073091712")
          .setApplicationKey("an app key")
          .build();

  @Test
  void serializeUnassignNumbersDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(unAssignNumberDto);

    JSONAssert.assertEquals(jsonRequest, serializedString, true);
  }
}
