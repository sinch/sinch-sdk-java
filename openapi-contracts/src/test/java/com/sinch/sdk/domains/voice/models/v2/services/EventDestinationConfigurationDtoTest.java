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
public class EventDestinationConfigurationDtoTest extends BaseTest {

  public static final EventDestinationConfiguration expectedEventDestinationConfiguration =
      EventDestinationConfiguration.builder()
          .setUrl("https://example.com/webhook")
          .setFallbackUrl("https://example.com/fallback")
          .build();

  @GivenTextResource("/domains/voice/v2/services/EventDestinationConfigurationDto.json")
  String jsonEventDestinationConfiguration;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString =
        objectMapper.writeValueAsString(expectedEventDestinationConfiguration);

    JSONAssert.assertEquals(jsonEventDestinationConfiguration, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    EventDestinationConfiguration deserialized =
        objectMapper.readValue(
            jsonEventDestinationConfiguration, EventDestinationConfiguration.class);

    TestHelpers.recursiveEquals(deserialized, expectedEventDestinationConfiguration);
  }
}
