package com.sinch.sdk.domains.voice.models.v2.calls.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.DialCommandDtoTest;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class StartCallRequestDtoTest extends BaseTest {

  public static final StartCallRequest expectedStartCallRequest =
      StartCallRequest.builder()
          .setCommands(Arrays.asList(DialCommandDtoTest.expectedDialCommand))
          .setServiceId("6e124178-c29d-46a5-943c-5c2ae544aade")
          .setIdempotencyKey("3f1c7a52-8d3e-4b9a-9c0e-2f6d1b7a4e21")
          .build();

  @GivenTextResource("/domains/voice/v2/calls/request/StartCallRequestDto.json")
  String jsonStartCallRequest;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedStartCallRequest);

    JSONAssert.assertEquals(jsonStartCallRequest, serializedString, true);
  }

  @Test
  void toStringMasksRecordingCredentials() {
    String string = expectedStartCallRequest.toString();

    Assertions.assertFalse(string.contains("access-key:secret-key"), string);
    Assertions.assertTrue(string.contains("credentials: ***"), string);
  }
}
