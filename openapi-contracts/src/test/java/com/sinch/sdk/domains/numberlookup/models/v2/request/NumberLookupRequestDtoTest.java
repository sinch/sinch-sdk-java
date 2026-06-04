package com.sinch.sdk.domains.numberlookup.models.v2.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import java.time.LocalDate;
import java.util.Arrays;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class NumberLookupRequestDtoTest extends BaseTest {

  public static NumberLookupRequest numberLookupRequestMinimalDto =
      NumberLookupRequest.builder().setNumber("+15551234567").build();

  public static NumberLookupRequest numberLookupRequestWithFeaturesDto =
      NumberLookupRequest.builder()
          .setNumber("+15552345678")
          .setFeatures(
              Arrays.asList(
                  LookupFeatureType.LINE_TYPE,
                  LookupFeatureType.SIM_SWAP,
                  LookupFeatureType.VO_IP_DETECTION))
          .build();

  public static NumberLookupRequest numberLookupRequestWithRndOptionsDto =
      NumberLookupRequest.builder()
          .setNumber("+15553456789")
          .setFeatures(Arrays.asList(LookupFeatureType.RND))
          .setRndFeatureOptions(
              RndFeatureOptions.builder().setContactDate(LocalDate.parse("2025-01-01")).build())
          .build();

  public static NumberLookupRequest numberLookupRequestAllFeaturesDto =
      NumberLookupRequest.builder()
          .setNumber("+15554567890")
          .setFeatures(
              Arrays.asList(
                  LookupFeatureType.LINE_TYPE,
                  LookupFeatureType.SIM_SWAP,
                  LookupFeatureType.VO_IP_DETECTION,
                  LookupFeatureType.RND))
          .build();

  @GivenTextResource("/domains/numberlookup/v2/request/NumberLookupRequestMinimalDto.json")
  String jsonNumberLookupRequestMinimalDto;

  @GivenTextResource("/domains/numberlookup/v2/request/NumberLookupRequestWithFeaturesDto.json")
  String jsonNumberLookupRequestWithFeaturesDto;

  @GivenTextResource("/domains/numberlookup/v2/request/NumberLookupRequestWithRndOptionsDto.json")
  String jsonNumberLookupRequestWithRndOptionsDto;

  @GivenTextResource("/domains/numberlookup/v2/request/NumberLookupRequestAllFeaturesDto.json")
  String jsonNumberLookupRequestAllFeaturesDto;

  @Test
  void serializeMinimalDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(numberLookupRequestMinimalDto);

    JSONAssert.assertEquals(jsonNumberLookupRequestMinimalDto, serializedString, true);
  }

  @Test
  void deserializeMinimalDto() throws JsonProcessingException {
    NumberLookupRequest deserialized =
        objectMapper.readValue(jsonNumberLookupRequestMinimalDto, NumberLookupRequest.class);

    TestHelpers.recursiveEquals(deserialized, numberLookupRequestMinimalDto);
  }

  @Test
  void serializeWithFeaturesDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(numberLookupRequestWithFeaturesDto);

    JSONAssert.assertEquals(jsonNumberLookupRequestWithFeaturesDto, serializedString, true);
  }

  @Test
  void deserializeWithFeaturesDto() throws JsonProcessingException {
    NumberLookupRequest deserialized =
        objectMapper.readValue(jsonNumberLookupRequestWithFeaturesDto, NumberLookupRequest.class);

    TestHelpers.recursiveEquals(deserialized, numberLookupRequestWithFeaturesDto);
  }

  @Test
  void serializeWithRndOptionsDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(numberLookupRequestWithRndOptionsDto);

    JSONAssert.assertEquals(jsonNumberLookupRequestWithRndOptionsDto, serializedString, true);
  }

  @Test
  void deserializeWithRndOptionsDto() throws JsonProcessingException {
    NumberLookupRequest deserialized =
        objectMapper.readValue(jsonNumberLookupRequestWithRndOptionsDto, NumberLookupRequest.class);

    TestHelpers.recursiveEquals(deserialized, numberLookupRequestWithRndOptionsDto);
  }

  @Test
  void serializeAllFeaturesDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(numberLookupRequestAllFeaturesDto);

    JSONAssert.assertEquals(jsonNumberLookupRequestAllFeaturesDto, serializedString, true);
  }

  @Test
  void deserializeAllFeaturesDto() throws JsonProcessingException {
    NumberLookupRequest deserialized =
        objectMapper.readValue(jsonNumberLookupRequestAllFeaturesDto, NumberLookupRequest.class);

    TestHelpers.recursiveEquals(deserialized, numberLookupRequestAllFeaturesDto);
  }
}
