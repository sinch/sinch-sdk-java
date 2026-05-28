package com.sinch.sdk.domains.number_lookup.models.v2.response;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.number_lookup.models.v2.errors.LookupError;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class SimSwapResponseDtoTest extends BaseTest {

  public static SimSwapResponse simSwapResponseDto =
      SimSwapResponse.builder().setSwapped(true).setSwapPeriod(SwapPeriodType.SP24_H).build();

  public static SimSwapResponse simSwapResponseWithErrorDto =
      SimSwapResponse.builder()
          .setError(
              LookupError.builder()
                  .setStatus(100)
                  .setTitle("Feature Disabled")
                  .setDetail("SimSwap feature is currently disabled.")
                  .build())
          .build();

  @GivenTextResource("/domains/number_lookup/v2/response/SimSwapResponseDto.json")
  String jsonSimSwapResponseDto;

  @GivenTextResource("/domains/number_lookup/v2/response/SimSwapResponseWithErrorDto.json")
  String jsonSimSwapResponseWithErrorDto;

  @Test
  void serializeDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(simSwapResponseDto);

    JSONAssert.assertEquals(jsonSimSwapResponseDto, serializedString, true);
  }

  @Test
  void deserializeDto() throws JsonProcessingException {
    SimSwapResponse deserialized =
        objectMapper.readValue(jsonSimSwapResponseDto, SimSwapResponse.class);

    TestHelpers.recursiveEquals(deserialized, simSwapResponseDto);
  }

  @Test
  void serializeWithErrorDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(simSwapResponseWithErrorDto);

    JSONAssert.assertEquals(jsonSimSwapResponseWithErrorDto, serializedString, true);
  }

  @Test
  void deserializeWithErrorDto() throws JsonProcessingException {
    SimSwapResponse deserialized =
        objectMapper.readValue(jsonSimSwapResponseWithErrorDto, SimSwapResponse.class);

    TestHelpers.recursiveEquals(deserialized, simSwapResponseWithErrorDto);
  }
}
