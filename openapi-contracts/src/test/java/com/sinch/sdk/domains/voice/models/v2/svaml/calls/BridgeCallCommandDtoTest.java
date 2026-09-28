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
public class BridgeCallCommandDtoTest extends BaseTest {

  public static final BridgeCallCommand expectedBridgeCallCommand =
      BridgeCallCommand.builder().setBridgeName("bridge").build();

  @GivenTextResource("/domains/voice/v2/svaml/calls/BridgeCallCommandDto.json")
  String jsonBridgeCallCommand;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedBridgeCallCommand);

    JSONAssert.assertEquals(jsonBridgeCallCommand, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    BridgeCallCommand deserialized =
        objectMapper.readValue(jsonBridgeCallCommand, BridgeCallCommand.class);

    TestHelpers.recursiveEquals(deserialized, expectedBridgeCallCommand);
  }

  @Test
  void of() {
    TestHelpers.recursiveEquals(BridgeCallCommand.of("bridge"), expectedBridgeCallCommand);
  }
}
