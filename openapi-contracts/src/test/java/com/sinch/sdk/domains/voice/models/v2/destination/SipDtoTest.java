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
public class SipDtoTest extends BaseTest {

  public static final Sip expectedSip =
      Sip.builder()
          .setEndpoint("sips:bob@sip.example.com")
          .setTransport(Sip.TransportEnum.TLS)
          .setCallHeaders(Arrays.asList(SipCallHeaderDtoTest.expectedSipCallHeader))
          .build();

  @GivenTextResource("/domains/voice/v2/destination/SipDto.json")
  String jsonSip;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedSip);

    JSONAssert.assertEquals(jsonSip, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    Sip deserialized = objectMapper.readValue(jsonSip, Sip.class);

    TestHelpers.recursiveEquals(deserialized, expectedSip);
  }
}
