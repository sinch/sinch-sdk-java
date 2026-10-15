package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.HangupCommandDtoTest;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class IncomingCallResponseEventsDtoTest extends BaseTest {

  public static final IncomingCallResponseEvents expectedIncomingCallResponseEvents =
      IncomingCallResponseEvents.builder()
          .setOnHangup(Arrays.asList(HangupCommandDtoTest.expectedHangupCommand))
          .build();

  @GivenTextResource("/domains/voice/v2/svaml/IncomingCallResponseEventsDto.json")
  String jsonIncomingCallResponseEvents;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedIncomingCallResponseEvents);

    JSONAssert.assertEquals(jsonIncomingCallResponseEvents, serializedString, true);
  }
}
