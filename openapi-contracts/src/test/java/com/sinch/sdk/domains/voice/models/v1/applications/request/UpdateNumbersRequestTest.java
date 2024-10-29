package com.sinch.sdk.domains.voice.models.v1.applications.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.v1.applications.Capability;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class UpdateNumbersRequestTest extends BaseTest {

  @GivenTextResource("/domains/voice/v1/applications/request/UpdateNumbersRequestDto.json")
  String jsonRequest;

  public static UpdateNumbersRequest updateNumbersDto =
      UpdateNumbersRequest.builder()
          .setNumbers(Arrays.asList("+12073091712"))
          .setApplicationKey("an app key")
          .setCapability(Capability.VOICE)
          .build();

  @Test
  void serializeUpdateNumbersRequest() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(updateNumbersDto);

    JSONAssert.assertEquals(jsonRequest, serializedString, true);
  }
}
