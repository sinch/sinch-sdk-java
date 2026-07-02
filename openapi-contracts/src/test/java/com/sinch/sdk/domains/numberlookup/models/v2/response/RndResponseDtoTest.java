package com.sinch.sdk.domains.numberlookup.models.v2.response;

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

  public static Rnd rndResponseDto = Rnd.builder().setDisconnected(true).build();

  public static Rnd rndResponseEmptyDto = Rnd.builder().build();

  @GivenTextResource("/domains/numberlookup/v2/response/RndResponseDto.json")
  String jsonRndResponseDto;

  @GivenTextResource("/domains/numberlookup/v2/response/RndResponseEmptyDto.json")
  String jsonRndResponseEmptyDto;

  @Test
  void serializeDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(rndResponseDto);

    JSONAssert.assertEquals(jsonRndResponseDto, serializedString, true);
  }

  @Test
  void deserializeDto() throws JsonProcessingException {
    Rnd deserialized = objectMapper.readValue(jsonRndResponseDto, Rnd.class);

    TestHelpers.recursiveEquals(deserialized, rndResponseDto);
  }

  @Test
  void deserializeEmptyDto() throws JsonProcessingException {
    Rnd deserialized = objectMapper.readValue(jsonRndResponseEmptyDto, Rnd.class);

    TestHelpers.recursiveEquals(deserialized, rndResponseEmptyDto);
  }
}
