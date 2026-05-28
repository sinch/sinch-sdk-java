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
public class VoIPDetectionResponseDtoTest extends BaseTest {

  public static VoIPDetectionResponse voIPDetectionResponseDto =
      VoIPDetectionResponse.builder().setProbability(VoIPProbabilityType.HIGH).build();

  public static VoIPDetectionResponse voIPDetectionResponseEmptyDto =
      VoIPDetectionResponse.builder().build();

  @GivenTextResource("/domains/number_lookup/v2/response/VoIPDetectionResponseDto.json")
  String jsonVoIPDetectionResponseDto;

  @GivenTextResource("/domains/number_lookup/v2/response/VoIPDetectionResponseEmptyDto.json")
  String jsonVoIPDetectionResponseEmptyDto;

  @Test
  void serializeDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(voIPDetectionResponseDto);

    JSONAssert.assertEquals(jsonVoIPDetectionResponseDto, serializedString, true);
  }

  @Test
  void deserializeDto() throws JsonProcessingException {
    VoIPDetectionResponse deserialized =
        objectMapper.readValue(jsonVoIPDetectionResponseDto, VoIPDetectionResponse.class);

    TestHelpers.recursiveEquals(deserialized, voIPDetectionResponseDto);
  }

  @Test
  void deserializeEmptyDto() throws JsonProcessingException {
    VoIPDetectionResponse deserialized =
        objectMapper.readValue(jsonVoIPDetectionResponseEmptyDto, VoIPDetectionResponse.class);

    TestHelpers.recursiveEquals(deserialized, voIPDetectionResponseEmptyDto);
  }
}
