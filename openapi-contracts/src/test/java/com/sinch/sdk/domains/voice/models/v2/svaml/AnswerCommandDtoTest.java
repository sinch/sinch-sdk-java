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
public class AnswerCommandDtoTest extends BaseTest {

  public static final AnswerCommand expectedAnswerCommand = AnswerCommand.ANSWER_COMMAND;

  @GivenTextResource("/domains/voice/v2/svaml/AnswerCommandDto.json")
  String jsonAnswerCommand;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedAnswerCommand);

    JSONAssert.assertEquals(jsonAnswerCommand, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    AnswerCommand deserialized = objectMapper.readValue(jsonAnswerCommand, AnswerCommand.class);

    TestHelpers.recursiveEquals(deserialized, expectedAnswerCommand);
  }
}
