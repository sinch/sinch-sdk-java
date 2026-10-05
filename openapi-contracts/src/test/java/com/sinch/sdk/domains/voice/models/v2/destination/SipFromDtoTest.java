package com.sinch.sdk.domains.voice.models.v2.destination;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class SipFromDtoTest extends BaseTest {

  public static final SipFrom expectedSipFrom =
      SipFrom.builder().setEndpoint("sip:alice@sip.example.com").setDisplayName("Alice").build();

  @GivenTextResource("/domains/voice/v2/destination/SipFromDto.json")
  String jsonSipFrom;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedSipFrom);

    JSONAssert.assertEquals(jsonSipFrom, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    SipFrom deserialized = objectMapper.readValue(jsonSipFrom, SipFrom.class);

    TestHelpers.recursiveEquals(deserialized, expectedSipFrom);
  }
}
