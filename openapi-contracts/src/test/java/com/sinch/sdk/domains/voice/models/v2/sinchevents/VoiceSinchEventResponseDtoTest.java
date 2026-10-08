package com.sinch.sdk.domains.voice.models.v2.sinchevents;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.v2.svaml.IncomingCallResponseEventsDtoTest;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.HangupCommandDtoTest;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class VoiceSinchEventResponseDtoTest extends BaseTest {

  public static final VoiceSinchEventResponse expectedVoiceSinchEventResponse =
      VoiceSinchEventResponse.builder()
          .setCommands(Arrays.asList(HangupCommandDtoTest.expectedHangupCommand))
          .setCallName("incoming")
          .setEvents(IncomingCallResponseEventsDtoTest.expectedIncomingCallResponseEvents)
          .build();

  @GivenTextResource("/domains/voice/v2/sinchevents/VoiceSinchEventResponseDto.json")
  String jsonVoiceSinchEventResponse;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedVoiceSinchEventResponse);

    JSONAssert.assertEquals(jsonVoiceSinchEventResponse, serializedString, true);
  }
}
