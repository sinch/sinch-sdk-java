package com.sinch.sdk.domains.numbers.adapters.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.Region;
import com.sinch.sdk.domains.numbers.models.dto.v1.AvailableRegionDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.ListAvailableRegionsResponseDto;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RegionsDtoConverterTest {

  AvailableRegionDto dtoItem;

  public static void compareWithDto(Region client, AvailableRegionDto dto) {
    assertEquals(dto.getRegionCode(), client.getRegionCode());
    assertEquals(dto.getRegionName(), client.getRegionName());
    assertEquals(
        null == dto.getTypes() ? null : dto.getTypes(),
        null == client.getTypes()
            ? null
            : client.getTypes().stream().map(NumberType::valueOf).collect(Collectors.toList()));
  }

  @Test
  void convertListAvailableRegionsResponseDto() {
    ListAvailableRegionsResponseDto dto = new ListAvailableRegionsResponseDto();
    dto.setAvailableRegions(Collections.singletonList(dtoItem));

    Collection<Region> converted = AvailableRegionsDtoConverter.convert(dto);

    assertEquals(dto.getAvailableRegions().size(), converted.size());
  }

  @Test
  void convertEmptyListAvailableRegionsResponseDto() {
    ListAvailableRegionsResponseDto dto = new ListAvailableRegionsResponseDto();
    Collection<Region> converted = AvailableRegionsDtoConverter.convert(dto);

    assertEquals(converted.size(), 0);
  }

  @Test
  void convertAvailableNumberDto() {
    AvailableRegionDto dto = dtoItem;
    Region converted = AvailableRegionsDtoConverter.convert(dtoItem);
    compareWithDto(converted, dto);
  }

  @BeforeEach
  void setUp() {
    dtoItem = new AvailableRegionDto("region code", "region name", Arrays.asList("MOBILE", "foo"));
  }
}
