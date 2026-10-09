package com.sinch.sdk.domains.voice.models.v2.calls.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.HangupCommandDtoTest;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.MessagesCommandDtoTest;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class CallPatchRequestDtoTest extends BaseTest {

  public static final CallPatchRequest expectedCallPatchRequest =
      CallPatchRequest.builder()
          .setCommands(
              Arrays.asList(
                  MessagesCommandDtoTest.expectedMessagesCommand,
                  HangupCommandDtoTest.expectedHangupCommand))
          .setIdempotencyKey("7b2e9d41-5c8a-4f3e-a1d6-0e4b8c2f9a17")
          .build();

  @GivenTextResource("/domains/voice/v2/calls/request/CallPatchRequestDto.json")
  String jsonCallPatchRequest;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedCallPatchRequest);

    JSONAssert.assertEquals(jsonCallPatchRequest, serializedString, true);
  }
}
