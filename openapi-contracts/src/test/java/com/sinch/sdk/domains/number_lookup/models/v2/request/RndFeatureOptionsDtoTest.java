package com.sinch.sdk.domains.number_lookup.models.v2.request;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import java.time.LocalDate;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

@TestWithResources
public class RndFeatureOptionsDtoTest extends BaseTest {

  public static RndFeatureOptions rndFeatureOptionsDto =
      RndFeatureOptions.builder().setContactDate(LocalDate.parse("2025-01-15")).build();

  @GivenTextResource("/domains/number_lookup/v2/request/RndFeatureOptionsDto.json")
  String jsonRndFeatureOptionsDto;

  @Test
  void serializeDto() throws JsonProcessingException, JSONException {
    String serializedString = objectMapper.writeValueAsString(rndFeatureOptionsDto);

    JSONAssert.assertEquals(jsonRndFeatureOptionsDto, serializedString, true);
  }

  @Test
  void deserializeDto() throws JsonProcessingException {
    RndFeatureOptions deserialized =
        objectMapper.readValue(jsonRndFeatureOptionsDto, RndFeatureOptions.class);

    TestHelpers.recursiveEquals(deserialized, rndFeatureOptionsDto);
  }
}
