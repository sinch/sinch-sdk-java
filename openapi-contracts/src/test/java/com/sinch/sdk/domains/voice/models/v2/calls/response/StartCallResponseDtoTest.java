package com.sinch.sdk.domains.voice.models.v2.calls.response;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class StartCallResponseDtoTest extends BaseTest {

  public static final StartCallResponse expectedStartCallResponse =
      StartCallResponse.builder()
          .setProjectId("5c5bf2b1-35ae-4825-ab89-457e07bb60e6")
          .setServiceId("6e124178-c29d-46a5-943c-5c2ae544aade")
          .setSessionId("01BX5ZZKBKACTAV9WEVGEMMVRB")
          .build();

  @GivenTextResource("/domains/voice/v2/calls/response/StartCallResponseDto.json")
  String jsonStartCallResponse;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedStartCallResponse);

    JSONAssert.assertEquals(jsonStartCallResponse, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    StartCallResponse deserialized =
        objectMapper.readValue(jsonStartCallResponse, StartCallResponse.class);

    TestHelpers.recursiveEquals(deserialized, expectedStartCallResponse);
  }
}
