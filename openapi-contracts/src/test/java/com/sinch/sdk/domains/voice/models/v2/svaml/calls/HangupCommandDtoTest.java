package com.sinch.sdk.domains.voice.models.v2.svaml.calls;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class HangupCommandDtoTest extends BaseTest {

  public static final HangupCommand expectedHangupCommand =
      HangupCommand.builder().setCallName("origin").build();

  @GivenTextResource("/domains/voice/v2/svaml/calls/HangupCommandDto.json")
  String jsonHangupCommand;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedHangupCommand);

    JSONAssert.assertEquals(jsonHangupCommand, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    HangupCommand deserialized = objectMapper.readValue(jsonHangupCommand, HangupCommand.class);

    TestHelpers.recursiveEquals(deserialized, expectedHangupCommand);
  }
}
