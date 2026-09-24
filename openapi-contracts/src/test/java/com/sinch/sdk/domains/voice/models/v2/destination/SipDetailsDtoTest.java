package com.sinch.sdk.domains.voice.models.v2.destination;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class SipDetailsDtoTest extends BaseTest {

  public static final SipDetails expectedSipDetails =
      SipDetails.builder()
          .setEndpoint("sips:bob@sip.example.com")
          .setTransport(SipDetails.TransportEnum.TLS)
          .setCallHeaders(Arrays.asList(SipCallHeaderDtoTest.expectedSipCallHeader))
          .build();

  @GivenTextResource("/domains/voice/v2/destination/SipDetailsDto.json")
  String jsonSipDetails;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedSipDetails);

    JSONAssert.assertEquals(jsonSipDetails, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    SipDetails deserialized = objectMapper.readValue(jsonSipDetails, SipDetails.class);

    TestHelpers.recursiveEquals(deserialized, expectedSipDetails);
  }
}
