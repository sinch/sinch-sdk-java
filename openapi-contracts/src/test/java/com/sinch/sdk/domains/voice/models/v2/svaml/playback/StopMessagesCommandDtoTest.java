package com.sinch.sdk.domains.voice.models.v2.svaml.playback;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class StopMessagesCommandDtoTest extends BaseTest {

  public static final StopMessagesCommand expectedStopMessagesCommand =
      StopMessagesCommand.builder().setMessagesName("my-messages").build();

  @GivenTextResource("/domains/voice/v2/svaml/playback/StopMessagesCommandDto.json")
  String jsonStopMessagesCommand;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedStopMessagesCommand);

    JSONAssert.assertEquals(jsonStopMessagesCommand, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    StopMessagesCommand deserialized =
        objectMapper.readValue(jsonStopMessagesCommand, StopMessagesCommand.class);

    TestHelpers.recursiveEquals(deserialized, expectedStopMessagesCommand);
  }
}
