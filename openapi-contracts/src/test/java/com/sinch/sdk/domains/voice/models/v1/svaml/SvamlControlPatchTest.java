package com.sinch.sdk.domains.voice.models.v1.svaml;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.v1.calls.request.SvamlControlPatch;
import com.sinch.sdk.domains.voice.models.v1.svaml.action.SvamlActionHangup;
import com.sinch.sdk.domains.voice.models.v1.svaml.instruction.SvamlInstructionSay;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class SvamlControlPatchTest extends BaseTest {

  public static SvamlControlPatch expectedSvamlControlPatch =
      SvamlControlPatch.builder()
          .setAction(SvamlActionHangup.SVAML_ACTION_HANGUP)
          .setInstructions(
              Arrays.asList(
                  SvamlInstructionSay.builder()
                      .setText("Sorry, the conference has been cancelled. The call will end now.")
                      .setLocale("en-US")
                      .build()))
          .build();

  @GivenTextResource("/domains/voice/v1/svaml/SvamlControlPatchDto.json")
  String jsonSvamlControlPatchDto;

  @Test
  void serializeSVAMLResponse() throws JsonProcessingException, JSONException {

    String serializedString = objectMapper.writeValueAsString(expectedSvamlControlPatch);

    JSONAssert.assertEquals(jsonSvamlControlPatchDto, serializedString, true);
  }
}
