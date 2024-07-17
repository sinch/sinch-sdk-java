package com.sinch.sdk.domains.numbers.adapters.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.Region;
import com.sinch.sdk.domains.numbers.models.v1.regions.available.response.AvailableRegion;
import com.sinch.sdk.domains.numbers.models.v1.regions.available.response.AvailableRegionListResponse;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegionsDtoConverterTest {

  AvailableRegion dtoItem;

  @Test
  void convertListAvailableRegionsResponseDto() {
    AvailableRegionListResponse dto =
        new AvailableRegionListResponse(Collections.singletonList(dtoItem));

    Collection<Region> converted = AvailableRegionsDtoConverter.convert(dto);

    assertEquals(dto.getContent().size(), converted.size());
  }

  @Test
  void convertEmptyListAvailableRegionsResponseDto() {
    AvailableRegionListResponse dto = new AvailableRegionListResponse(null);
    Collection<Region> converted = AvailableRegionsDtoConverter.convert(dto);

    assertEquals(converted.size(), 0);
  }

  @Test
  void convertAvailableNumberDto() {
    Region expected =
        Region.builder()
            .setRegionCode("region code")
            .setRegionName("region name")
            .setTypes(Arrays.asList(NumberType.MOBILE, NumberType.from("foo")))
            .build();

    Region converted = AvailableRegionsDtoConverter.convert(dtoItem);
    TestHelpers.recursiveEquals(converted, expected);
  }

  @BeforeEach
  void setUp() {
    dtoItem =
        AvailableRegion.builder()
            .setRegionCode("region code")
            .setRegionName("region name")
            .setTypes(
                Arrays.asList(
                    com.sinch.sdk.domains.numbers.models.v1.NumberType.MOBILE,
                    com.sinch.sdk.domains.numbers.models.v1.NumberType.from("foo")))
            .build();
  }
}
