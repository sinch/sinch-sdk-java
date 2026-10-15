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
public class SipCallHeaderDtoTest extends BaseTest {

  public static final SipCallHeader expectedSipCallHeader =
      SipCallHeader.builder().setKey("X-Custom-Header").setValue("custom-value").build();

  @GivenTextResource("/domains/voice/v2/destination/SipCallHeaderDto.json")
  String jsonSipCallHeader;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedSipCallHeader);

    JSONAssert.assertEquals(jsonSipCallHeader, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    SipCallHeader deserialized = objectMapper.readValue(jsonSipCallHeader, SipCallHeader.class);

    TestHelpers.recursiveEquals(deserialized, expectedSipCallHeader);
  }
}
