package com.sinch.sdk.domains.voice.models.v2.svaml.amd;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.HangupCommandDtoTest;
import com.sinch.sdk.domains.voice.models.v2.svaml.calls.PauseCommandDtoTest;
import com.sinch.sdk.domains.voice.models.v2.svaml.playback.MessagesCommandDtoTest;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class AmdEventsDtoTest extends BaseTest {

  public static final AmdEvents expectedAmdEvents =
      AmdEvents.builder()
          .setOnHuman(Arrays.asList(MessagesCommandDtoTest.expectedMessagesCommand))
          .setOnMachine(Arrays.asList(HangupCommandDtoTest.expectedHangupCommand))
          .setOnBeep(Arrays.asList(PauseCommandDtoTest.expectedPauseCommand))
          .setOnUnknown(Arrays.asList(HangupCommandDtoTest.expectedHangupCommand))
          .build();

  @GivenTextResource("/domains/voice/v2/svaml/amd/AmdEventsDto.json")
  String jsonAmdEvents;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedAmdEvents);

    JSONAssert.assertEquals(jsonAmdEvents, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    AmdEvents deserialized = objectMapper.readValue(jsonAmdEvents, AmdEvents.class);

    TestHelpers.recursiveEquals(deserialized, expectedAmdEvents);
  }
}
