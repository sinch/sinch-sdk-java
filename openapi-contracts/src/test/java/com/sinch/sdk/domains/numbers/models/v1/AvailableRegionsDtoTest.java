package com.sinch.sdk.domains.numbers.models.v1;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numbers.api.v1.adapters.NumbersBaseTest;
import com.sinch.sdk.domains.numbers.models.v1.regions.available.response.AvailableRegion;
import com.sinch.sdk.domains.numbers.models.v1.regions.available.response.internal.AvailableRegionListResponseInternal;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

@TestWithResources
public class AvailableRegionsDtoTest extends NumbersBaseTest {

  @GivenTextResource("/domains/numbers/v1/regions/available-regions-list.json")
  String availableListResponse;

  public static AvailableRegion availableRegion =
      AvailableRegion.builder()
          .setRegionCode("AU")
          .setRegionName("Australia")
          .setTypes(Arrays.asList(NumberType.MOBILE))
          .build();

  public static AvailableRegionListResponseInternal availableRegionList =
      AvailableRegionListResponseInternal.builder()
          .setAvailableRegions(new ArrayList<>(Arrays.asList(availableRegion)))
          .build();

  @Test
  void deserializeList() throws JsonProcessingException {

    AvailableRegionListResponseInternal deserializedString =
        objectMapper.readValue(availableListResponse, AvailableRegionListResponseInternal.class);

    TestHelpers.recursiveEquals(availableRegionList, deserializedString);
  }
}
