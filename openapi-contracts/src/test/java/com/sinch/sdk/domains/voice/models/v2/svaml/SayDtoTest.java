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
public class SayDtoTest extends BaseTest {

  public static final Say expectedSay =
      Say.builder()
          .setText("Hello, your call is now connected.")
          .setFormat(Say.FormatEnum.TEXT)
          .setVoiceName("Emma")
          .build();

  @GivenTextResource("/domains/voice/v2/svaml/SayDto.json")
  String jsonSay;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedSay);

    JSONAssert.assertEquals(jsonSay, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    Say deserialized = objectMapper.readValue(jsonSay, Say.class);

    TestHelpers.recursiveEquals(deserialized, expectedSay);
  }
}
