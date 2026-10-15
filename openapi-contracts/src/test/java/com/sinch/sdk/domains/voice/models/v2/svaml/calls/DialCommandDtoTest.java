package com.sinch.sdk.domains.voice.models.v2.svaml.calls;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.models.v2.destination.PhoneDtoTest;
import com.sinch.sdk.domains.voice.models.v2.destination.SipDtoTest;
import com.sinch.sdk.domains.voice.models.v2.destination.SipFromDtoTest;
import com.sinch.sdk.domains.voice.models.v2.destination.StreamDtoTest;
import com.sinch.sdk.domains.voice.models.v2.destination.VoiceRelayDtoTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class DialCommandDtoTest extends BaseTest {

  public static final DialCommand expectedDialCommand =
      DialCommand.builder()
          .setCallName("origin")
          .setFrom(PhoneDtoTest.expectedPhone)
          .setTo(PhoneDtoTest.expectedPhone)
          .setDialTimeoutDurationSeconds(30)
          .setMaxCallDurationSeconds(3600)
          .setEvents(CallEventsDtoTest.expectedCallEvents)
          .build();

  public static final DialCommand expectedDialCommandSip =
      DialCommand.builder()
          .setCallName("origin")
          .setFrom(SipFromDtoTest.expectedSipFrom)
          .setTo(SipDtoTest.expectedSip)
          .build();

  public static final DialCommand expectedDialCommandStream =
      DialCommand.builder().setTo(StreamDtoTest.expectedStream).build();

  public static final DialCommand expectedDialCommandVoiceRelay =
      DialCommand.builder().setTo(VoiceRelayDtoTest.expectedVoiceRelay).build();

  @GivenTextResource("/domains/voice/v2/svaml/calls/DialCommandDto.json")
  String jsonDialCommand;

  @GivenTextResource("/domains/voice/v2/svaml/calls/DialCommandSipDto.json")
  String jsonDialCommandSip;

  @GivenTextResource("/domains/voice/v2/svaml/calls/DialCommandStreamDto.json")
  String jsonDialCommandStream;

  @GivenTextResource("/domains/voice/v2/svaml/calls/DialCommandVoiceRelayDto.json")
  String jsonDialCommandVoiceRelay;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedDialCommand);

    JSONAssert.assertEquals(jsonDialCommand, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    DialCommand deserialized = objectMapper.readValue(jsonDialCommand, DialCommand.class);

    TestHelpers.recursiveEquals(deserialized, expectedDialCommand);
  }

  @Test
  void serializeSip() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedDialCommandSip);

    JSONAssert.assertEquals(jsonDialCommandSip, serializedString, true);
  }

  @Test
  void deserializeSip() throws JsonProcessingException {
    DialCommand deserialized = objectMapper.readValue(jsonDialCommandSip, DialCommand.class);

    TestHelpers.recursiveEquals(deserialized, expectedDialCommandSip);
  }

  @Test
  void serializeStream() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedDialCommandStream);

    JSONAssert.assertEquals(jsonDialCommandStream, serializedString, true);
  }

  @Test
  void deserializeStream() throws JsonProcessingException {
    DialCommand deserialized = objectMapper.readValue(jsonDialCommandStream, DialCommand.class);

    TestHelpers.recursiveEquals(deserialized, expectedDialCommandStream);
  }

  @Test
  void serializeVoiceRelay() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedDialCommandVoiceRelay);

    JSONAssert.assertEquals(jsonDialCommandVoiceRelay, serializedString, true);
  }

  @Test
  void deserializeVoiceRelay() throws JsonProcessingException {
    DialCommand deserialized = objectMapper.readValue(jsonDialCommandVoiceRelay, DialCommand.class);

    TestHelpers.recursiveEquals(deserialized, expectedDialCommandVoiceRelay);
  }
}
