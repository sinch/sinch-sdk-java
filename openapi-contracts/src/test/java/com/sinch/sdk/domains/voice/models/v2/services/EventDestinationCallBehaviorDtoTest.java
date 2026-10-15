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
public class EventDestinationCallBehaviorDtoTest extends BaseTest {

  public static final EventDestinationCallBehavior expectedEventDestinationCallBehavior =
      EventDestinationCallBehavior.builder()
          .setEventDestination(
              EventDestinationConfigurationDtoTest.expectedEventDestinationConfiguration)
          .build();

  @GivenTextResource("/domains/voice/v2/services/EventDestinationCallBehaviorDto.json")
  String jsonEventDestinationCallBehavior;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedEventDestinationCallBehavior);

    JSONAssert.assertEquals(jsonEventDestinationCallBehavior, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    EventDestinationCallBehavior deserialized =
        objectMapper.readValue(
            jsonEventDestinationCallBehavior, EventDestinationCallBehavior.class);

    TestHelpers.recursiveEquals(deserialized, expectedEventDestinationCallBehavior);
  }

  @Test
  void deserializeAsCallBehavior() throws JsonProcessingException {
    CallBehavior deserialized =
        objectMapper.readValue(jsonEventDestinationCallBehavior, CallBehavior.class);

    TestHelpers.recursiveEquals(deserialized, expectedEventDestinationCallBehavior);
  }
}
