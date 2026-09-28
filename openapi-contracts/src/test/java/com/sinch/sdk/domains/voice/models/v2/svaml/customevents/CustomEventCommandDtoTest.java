package com.sinch.sdk.domains.voice.models.v2.svaml.customevents;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class CustomEventCommandDtoTest extends BaseTest {

  public static final CustomEventCommand expectedCustomEventCommand =
      CustomEventCommand.builder()
          .setCustomEventName("my.custom.event")
          .setUrl("https://example.com/events")
          .setFallbackUrl("https://fallback.example.com/events")
          .build();

  @GivenTextResource("/domains/voice/v2/svaml/customevents/CustomEventCommandDto.json")
  String jsonCustomEventCommand;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedCustomEventCommand);

    JSONAssert.assertEquals(jsonCustomEventCommand, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    CustomEventCommand deserialized =
        objectMapper.readValue(jsonCustomEventCommand, CustomEventCommand.class);

    TestHelpers.recursiveEquals(deserialized, expectedCustomEventCommand);
  }
}
