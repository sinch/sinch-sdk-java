package com.sinch.sdk.domains.voice.models.v1.calls.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionHangup;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionSay;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class CallUpdateRequestTest extends BaseTest {

  public static CallUpdateRequest expectedCallUpdateRequest =
      CallUpdateRequest.builder()
          .setAction(SvamlActionHangup.SVAML_ACTION_HANGUP)
          .setInstructions(
              Arrays.asList(
                  SvamlInstructionSay.builder()
                      .setText("Sorry, the conference has been cancelled. The call will end now.")
                      .setLocale("en-US")
                      .build()))
          .build();

  @GivenTextResource("/domains/voice/v1/calls/request/CallUpdateRequestDto.json")
  String jsonCallUpdateRequestDto;

  @Test
  void serializeCallUpdateRequest() throws JsonProcessingException, JSONException {

    String serializedString = objectMapper.writeValueAsString(expectedCallUpdateRequest);

    JSONAssert.assertEquals(jsonCallUpdateRequestDto, serializedString, true);
  }
}
