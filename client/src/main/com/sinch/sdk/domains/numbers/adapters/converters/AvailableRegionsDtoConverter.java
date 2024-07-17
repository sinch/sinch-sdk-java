package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.Region;
import com.sinch.sdk.domains.numbers.models.v1.regions.available.response.AvailableRegion;
import com.sinch.sdk.domains.numbers.models.v1.regions.available.response.AvailableRegionListResponse;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class AvailableRegionsDtoConverter {

  public static Collection<Region> convert(AvailableRegionListResponse dto) {
    Collection<AvailableRegion> list = dto.getContent();
    if (null == list) {
      return Collections.emptyList();
    }
    return list.stream().map(AvailableRegionsDtoConverter::convert).collect(Collectors.toList());
  }

  public static Region convert(AvailableRegion dto) {

    return Region.builder()
        .setRegionCode(dto.getRegionCode())
        .setRegionName(dto.getRegionName())
        .setTypes(
            null != dto.getTypes()
                ? dto.getTypes().stream()
                    .map(f -> NumberType.from(f.value()))
                    .collect(Collectors.toList())
                : null)
        .build();
  }
}
