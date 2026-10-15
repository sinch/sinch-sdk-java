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
public class CallHeaderDtoTest extends BaseTest {

  public static final CallHeader expectedCallHeader =
      CallHeader.builder().setKey("customer-id").setValue("12345").build();

  @GivenTextResource("/domains/voice/v2/destination/CallHeaderDto.json")
  String jsonCallHeader;

  @Test
  void serialize() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(expectedCallHeader);

    JSONAssert.assertEquals(jsonCallHeader, serializedString, true);
  }

  @Test
  void deserialize() throws JsonProcessingException {
    CallHeader deserialized = objectMapper.readValue(jsonCallHeader, CallHeader.class);

    TestHelpers.recursiveEquals(deserialized, expectedCallHeader);
  }
}
