package com.sinch.sdk.domains.voice.models.v2.destination;

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
public class VoiceRelayDetailsDtoTest extends BaseTest {

  public static final VoiceRelayDetails expectedVoiceRelayDetails =
      VoiceRelayDetails.builder()
          .setEndpoint("wss://relay.example.com/agent")
          .setEnableInterruptions(false)
          .setTtsVoice("Emma")
          .setSttLanguage("en-US")
          .setCallHeaders(Arrays.asList(CallHeaderDtoTest.expectedCallHeader))
          .build();

  @GivenTextResource("/domains/voice/v2/destination/VoiceRelayDetailsDto.json")
  String jsonVoiceRelayDetails;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedVoiceRelayDetails);

    JSONAssert.assertEquals(jsonVoiceRelayDetails, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    VoiceRelayDetails deserialized =
        objectMapper.readValue(jsonVoiceRelayDetails, VoiceRelayDetails.class);

    TestHelpers.recursiveEquals(deserialized, expectedVoiceRelayDetails);
  }
}
