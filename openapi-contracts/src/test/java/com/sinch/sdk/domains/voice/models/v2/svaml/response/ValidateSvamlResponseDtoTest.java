package com.sinch.sdk.domains.voice.models.v2.svaml.response;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@TestWithResources
public class ValidateSvamlResponseDtoTest extends BaseTest {

  public static final ValidateSvamlResponse expectedValidateSvamlResponse =
      ValidateSvamlResponse.builder()
          .setIsValid(false)
          .setErrors(
              Arrays.asList(
                  "Invalid dial command. Missing destination.",
                  "Invalid say command. Missing voice name."))
          .build();

  @GivenTextResource("/domains/voice/v2/svaml/response/ValidateSvamlResponseDto.json")
  String jsonValidateSvamlResponse;

  @Test
  void deserialize() throws JsonProcessingException {
    ValidateSvamlResponse deserialized =
        objectMapper.readValue(jsonValidateSvamlResponse, ValidateSvamlResponse.class);

    TestHelpers.recursiveEquals(deserialized, expectedValidateSvamlResponse);
  }
}
