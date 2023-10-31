package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.Region;
import com.sinch.sdk.domains.numbers.models.dto.v1.AvailableRegionDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.ListAvailableRegionsResponseDto;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AvailableRegionsDtoConverter {

  public static Collection<Region> convert(ListAvailableRegionsResponseDto dto) {
    List<AvailableRegionDto> list = dto.getAvailableRegions();
    if (null == list) {
      return Collections.emptyList();
    }
    return list.stream().map(AvailableRegionsDtoConverter::convert).collect(Collectors.toList());
  }

  public static Region convert(AvailableRegionDto dto) {

    return Region.builder()
        .setRegionCode(dto.getRegionCode())
        .setRegionName(dto.getRegionName())
        .setTypes(
            null != dto.getTypes()
                ? dto.getTypes().stream().map(NumberType::from).collect(Collectors.toList())
                : null)
        .build();
  }
}
