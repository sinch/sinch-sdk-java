package com.sinch.sdk.domains.number_lookup.models.v2.response;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import java.time.Instant;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class LineResponseDtoTest extends BaseTest {

  public static LineResponse lineResponseDto =
      LineResponse.builder()
          .setCarrier("T-Mobile USA")
          .setType(LineType.MOBILE)
          .setMobileCountryCode("310")
          .setMobileNetworkCode("260")
          .setPorted(true)
          .setPortingDate(Instant.parse("2024-06-15T14:30:00Z"))
          .build();

  public static LineResponse lineResponseEmptyDto = LineResponse.builder().build();

  @GivenTextResource("/domains/number_lookup/v2/response/LineResponseDto.json")
  String jsonLineResponseDto;

  @GivenTextResource("/domains/number_lookup/v2/response/LineResponseEmptyDto.json")
  String jsonLineResponseEmptyDto;

  @Test
  void serializeDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(lineResponseDto);

    JSONAssert.assertEquals(jsonLineResponseDto, serializedString, true);
  }

  @Test
  void deserializeDto() throws JsonProcessingException {
    LineResponse deserialized = objectMapper.readValue(jsonLineResponseDto, LineResponse.class);

    TestHelpers.recursiveEquals(deserialized, lineResponseDto);
  }

  @Test
  void deserializeEmptyDto() throws JsonProcessingException {
    LineResponse deserialized =
        objectMapper.readValue(jsonLineResponseEmptyDto, LineResponse.class);

    TestHelpers.recursiveEquals(deserialized, lineResponseEmptyDto);
  }
}
