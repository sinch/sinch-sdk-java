package com.sinch.sdk.domains.number_lookup.models.v2.response;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import java.time.Instant;
import org.junit.jupiter.api.Test;

@TestWithResources
public class NumberLookupResponseDtoTest extends BaseTest {

  public static NumberLookupResponse numberLookupResponseMinimalDto =
      NumberLookupResponse.builder()
          .setNumber("+15551234567")
          .setCountryCode("US")
          .setTraceId("test-trace-id")
          .build();

  public static NumberLookupResponse numberLookupResponseFullDto =
      NumberLookupResponse.builder()
          .setLine(
              Line.builder()
                  .setCarrier("T-Mobile USA")
                  .setType(LineType.MOBILE)
                  .setMobileCountryCode("310")
                  .setMobileNetworkCode("260")
                  .setPorted(true)
                  .setPortingDate(Instant.parse("2024-08-20T10:15:30Z"))
                  .build())
          .setSimSwap(
              SimSwap.builder()
                  .setSwapped(true)
                  .setSwapPeriod(SwapPeriodType.SP24_H)
                  .build())
          .setVoIPDetection(
              VoipDetection.builder().setProbability(VoIPProbabilityType.HIGH).build())
          .setRnd(Rnd.builder().setDisconnected(true).build())
          .setCountryCode("US")
          .setTraceId("84c1fd4063c38d9f3900d06e56542d48")
          .setNumber("+15557890123")
          .build();

  @GivenTextResource("/domains/number_lookup/v2/response/NumberLookupResponseMinimalDto.json")
  String jsonNumberLookupResponseMinimalDto;

  @GivenTextResource("/domains/number_lookup/v2/response/NumberLookupResponseFullDto.json")
  String jsonNumberLookupResponseFullDto;

  @Test
  void deserializeMinimalDto() throws JsonProcessingException {
    NumberLookupResponse deserialized =
        objectMapper.readValue(jsonNumberLookupResponseMinimalDto, NumberLookupResponse.class);

    TestHelpers.recursiveEquals(deserialized, numberLookupResponseMinimalDto);
  }

  @Test
  void deserializeFullDto() throws JsonProcessingException {
    NumberLookupResponse deserialized =
        objectMapper.readValue(jsonNumberLookupResponseFullDto, NumberLookupResponse.class);

    TestHelpers.recursiveEquals(deserialized, numberLookupResponseFullDto);
  }
}
