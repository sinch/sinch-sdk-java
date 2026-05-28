package com.sinch.sdk.domains.number_lookup.models.v2.errors;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class LookupErrorDtoTest extends BaseTest {

  public static LookupError lookupErrorDto =
      LookupError.builder()
          .setStatus(100)
          .setTitle("Feature Disabled")
          .setDetail("VoIPDetection feature is currently disabled.")
          .setType("validation_error")
          .build();

  public static LookupError lookupErrorEmptyDto = LookupError.builder().build();

  @GivenTextResource("/domains/number_lookup/v2/errors/LookupErrorDto.json")
  String jsonLookupErrorDto;

  @GivenTextResource("/domains/number_lookup/v2/errors/LookupErrorEmptyDto.json")
  String jsonLookupErrorEmptyDto;

  @Test
  void serializeDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(lookupErrorDto);

    JSONAssert.assertEquals(jsonLookupErrorDto, serializedString, true);
  }

  @Test
  void deserializeDto() throws JsonProcessingException {
    LookupError deserialized = objectMapper.readValue(jsonLookupErrorDto, LookupError.class);

    TestHelpers.recursiveEquals(deserialized, lookupErrorDto);
  }

  @Test
  void deserializeEmptyDto() throws JsonProcessingException {
    LookupError deserialized = objectMapper.readValue(jsonLookupErrorEmptyDto, LookupError.class);

    TestHelpers.recursiveEquals(deserialized, lookupErrorEmptyDto);
  }
}
