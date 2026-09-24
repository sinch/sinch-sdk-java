package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class CallEventsDtoTest extends BaseTest {

  public static final CallEvents expectedCallEvents =
      CallEvents.builder()
          .setOnAnswer(
              Arrays.asList(
                  AnswerCommandDtoTest.expectedAnswerCommand,
                  AmdCommandDtoTest.expectedAmdCommand,
                  StartRecordingCommandDtoTest.expectedStartRecordingCommand,
                  MenuCommandDtoTest.expectedMenuCommand,
                  BridgeCallCommandDtoTest.expectedBridgeCallCommand,
                  CustomEventCommandDtoTest.expectedCustomEventCommand,
                  StopMessagesCommandDtoTest.expectedStopMessagesCommand))
          .setOnBusy(Arrays.asList(HangupCommandDtoTest.expectedHangupCommand))
          .setOnReject(Arrays.asList(HangupCommandDtoTest.expectedHangupCommand))
          .setOnTimeout(Arrays.asList(HangupCommandDtoTest.expectedHangupCommand))
          .setOnHangup(
              Arrays.asList(
                  StopRecordingCommandDtoTest.expectedStopRecordingCommand,
                  HangupCommandDtoTest.expectedHangupCommand))
          .setOnFailure(Arrays.asList(HangupCommandDtoTest.expectedHangupCommand))
          .build();

  @GivenTextResource("/domains/voice/v2/svaml/CallEventsDto.json")
  String jsonCallEvents;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedCallEvents);

    JSONAssert.assertEquals(jsonCallEvents, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    CallEvents deserialized = objectMapper.readValue(jsonCallEvents, CallEvents.class);

    TestHelpers.recursiveEquals(deserialized, expectedCallEvents);
  }
}
