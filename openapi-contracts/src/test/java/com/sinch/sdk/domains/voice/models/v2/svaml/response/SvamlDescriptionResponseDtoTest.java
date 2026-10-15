package com.sinch.sdk.domains.voice.models.v2.svaml.response;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import org.junit.jupiter.api.Test;

@TestWithResources
public class SvamlDescriptionResponseDtoTest extends BaseTest {

  public static final SvamlDescriptionResponse expectedSvamlDescriptionResponse =
      SvamlDescriptionResponse.builder()
          .setDescription("The call is answered and a TTS message is played using the voice Emma.")
          .build();

  @GivenTextResource("/domains/voice/v2/svaml/response/SvamlDescriptionResponseDto.json")
  String jsonSvamlDescriptionResponse;

  @Test
  void deserialize() throws JsonProcessingException {
    SvamlDescriptionResponse deserialized =
        objectMapper.readValue(jsonSvamlDescriptionResponse, SvamlDescriptionResponse.class);

    TestHelpers.recursiveEquals(deserialized, expectedSvamlDescriptionResponse);
  }
}
