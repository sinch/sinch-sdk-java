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
public class SipFromDetailsDtoTest extends BaseTest {

  public static final SipFromDetails expectedSipFromDetails =
      SipFromDetails.builder()
          .setEndpoint("sip:alice@sip.example.com")
          .setDisplayName("Alice")
          .build();

  @GivenTextResource("/domains/voice/v2/destination/SipFromDetailsDto.json")
  String jsonSipFromDetails;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedSipFromDetails);

    JSONAssert.assertEquals(jsonSipFromDetails, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    SipFromDetails deserialized = objectMapper.readValue(jsonSipFromDetails, SipFromDetails.class);

    TestHelpers.recursiveEquals(deserialized, expectedSipFromDetails);
  }
}
