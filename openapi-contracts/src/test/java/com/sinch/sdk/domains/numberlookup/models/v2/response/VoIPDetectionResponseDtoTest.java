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
public class VoIPDetectionResponseDtoTest extends BaseTest {

  public static VoIPDetection voIPDetectionResponseDto =
      VoIPDetection.builder().setProbability(VoIPProbabilityType.HIGH).build();

  public static VoIPDetection voIPDetectionResponseEmptyDto = VoIPDetection.builder().build();

  @GivenTextResource("/domains/numberlookup/v2/response/VoIPDetectionResponseDto.json")
  String jsonVoIPDetectionDto;

  @GivenTextResource("/domains/numberlookup/v2/response/VoIPDetectionResponseEmptyDto.json")
  String jsonVoIPDetectionEmptyDto;

  @Test
  void serializeDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(voIPDetectionResponseDto);

    JSONAssert.assertEquals(jsonVoIPDetectionDto, serializedString, true);
  }

  @Test
  void deserializeDto() throws JsonProcessingException {
    VoIPDetection deserialized = objectMapper.readValue(jsonVoIPDetectionDto, VoIPDetection.class);

    TestHelpers.recursiveEquals(deserialized, voIPDetectionResponseDto);
  }

  @Test
  void deserializeEmptyDto() throws JsonProcessingException {
    VoIPDetection deserialized =
        objectMapper.readValue(jsonVoIPDetectionEmptyDto, VoIPDetection.class);

    TestHelpers.recursiveEquals(deserialized, voIPDetectionResponseEmptyDto);
  }
}
