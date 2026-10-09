package com.sinch.sdk.domains.voice.models.v2.services;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.voice.models.v2.svaml.SvamlInputDtoTest;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class StaticCallBehaviorDtoTest extends BaseTest {

  public static final StaticCallBehavior expectedStaticCallBehavior =
      StaticCallBehavior.builder().setStatic(SvamlInputDtoTest.expectedSvamlInput).build();

  @GivenTextResource("/domains/voice/v2/services/StaticCallBehaviorDto.json")
  String jsonStaticCallBehavior;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedStaticCallBehavior);

    JSONAssert.assertEquals(jsonStaticCallBehavior, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    StaticCallBehavior deserialized =
        objectMapper.readValue(jsonStaticCallBehavior, StaticCallBehavior.class);

    TestHelpers.recursiveEquals(deserialized, expectedStaticCallBehavior);
  }

  @Test
  void deserializeAsCallBehavior() throws JsonProcessingException {
    CallBehavior deserialized = objectMapper.readValue(jsonStaticCallBehavior, CallBehavior.class);

    TestHelpers.recursiveEquals(deserialized, expectedStaticCallBehavior);
  }
}
