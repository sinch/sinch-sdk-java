package com.sinch.sdk.domains.voice.models.v2.svaml;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class PauseCommandDtoTest extends BaseTest {

  public static final PauseCommand expectedPauseCommand =
      PauseCommand.builder().setDurationMilliseconds(1500).build();

  @GivenTextResource("/domains/voice/v2/svaml/PauseCommandDto.json")
  String jsonPauseCommand;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedPauseCommand);

    JSONAssert.assertEquals(jsonPauseCommand, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    PauseCommand deserialized = objectMapper.readValue(jsonPauseCommand, PauseCommand.class);

    TestHelpers.recursiveEquals(deserialized, expectedPauseCommand);
  }
}
