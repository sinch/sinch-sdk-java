package com.sinch.sdk.domains.number_lookup.models.v2.response;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class RndResponseDtoTest extends BaseTest {

  public static RndResponse rndResponseDto = RndResponse.builder().setDisconnected(true).build();

  public static RndResponse rndResponseEmptyDto = RndResponse.builder().build();

  @GivenTextResource("/domains/number_lookup/v2/response/RndResponseDto.json")
  String jsonRndResponseDto;

  @GivenTextResource("/domains/number_lookup/v2/response/RndResponseEmptyDto.json")
  String jsonRndResponseEmptyDto;

  @Test
  void serializeDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(rndResponseDto);

    JSONAssert.assertEquals(jsonRndResponseDto, serializedString, true);
  }

  @Test
  void deserializeDto() throws JsonProcessingException {
    RndResponse deserialized = objectMapper.readValue(jsonRndResponseDto, RndResponse.class);

    TestHelpers.recursiveEquals(deserialized, rndResponseDto);
  }

  @Test
  void deserializeEmptyDto() throws JsonProcessingException {
    RndResponse deserialized = objectMapper.readValue(jsonRndResponseEmptyDto, RndResponse.class);

    TestHelpers.recursiveEquals(deserialized, rndResponseEmptyDto);
  }
}
