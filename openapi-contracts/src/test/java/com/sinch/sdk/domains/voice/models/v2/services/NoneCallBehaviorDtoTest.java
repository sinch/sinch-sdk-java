package com.sinch.sdk.domains.voice.models.v2.services;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class NoneCallBehaviorDtoTest extends BaseTest {

  public static final NoneCallBehavior expectedNoneCallBehavior =
      NoneCallBehavior.NONE_CALL_BEHAVIOR;

  @GivenTextResource("/domains/voice/v2/services/NoneCallBehaviorDto.json")
  String jsonNoneCallBehavior;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedNoneCallBehavior);

    JSONAssert.assertEquals(jsonNoneCallBehavior, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    NoneCallBehavior deserialized =
        objectMapper.readValue(jsonNoneCallBehavior, NoneCallBehavior.class);

    TestHelpers.recursiveEquals(deserialized, expectedNoneCallBehavior);
  }

  @Test
  void deserializeAsCallBehavior() throws JsonProcessingException {
    CallBehavior deserialized = objectMapper.readValue(jsonNoneCallBehavior, CallBehavior.class);

    TestHelpers.recursiveEquals(deserialized, expectedNoneCallBehavior);
  }
}
