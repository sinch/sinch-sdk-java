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
public class AmdCommandDtoTest extends BaseTest {

  public static final AmdCommand expectedAmdCommand =
      AmdCommand.builder().setEvents(AmdEventsDtoTest.expectedAmdEvents).build();

  @GivenTextResource("/domains/voice/v2/svaml/AmdCommandDto.json")
  String jsonAmdCommand;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedAmdCommand);

    JSONAssert.assertEquals(jsonAmdCommand, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    AmdCommand deserialized = objectMapper.readValue(jsonAmdCommand, AmdCommand.class);

    TestHelpers.recursiveEquals(deserialized, expectedAmdCommand);
  }
}
