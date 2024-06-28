package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.domains.numbers.models.AvailableNumber;
import com.sinch.sdk.domains.numbers.models.Capability;
import com.sinch.sdk.domains.numbers.models.NumberType;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class AvailableNumberDtoConverter {

  public static Collection<AvailableNumber> convert(
      com.sinch.sdk.domains.numbers.models.v1.available.response.AvailableNumberListResponse dto) {
    Collection<com.sinch.sdk.domains.numbers.models.v1.available.response.AvailableNumber> list =
        dto.getContent();
    if (null == list) {
      return Collections.emptyList();
    }
    return list.stream().map(AvailableNumberDtoConverter::convert).collect(Collectors.toList());
  }

  public static AvailableNumber convert(
      com.sinch.sdk.domains.numbers.models.v1.available.response.AvailableNumber dto) {

    return new AvailableNumber(
        dto.getPhoneNumber(),
        dto.getRegionCode(),
        null == dto.getType() ? null : NumberType.from(dto.getType().value()),
        null != dto.getCapability()
            ? dto.getCapability().stream()
                .map(f -> Capability.from(f.value()))
                .collect(Collectors.toList())
            : null,
        MoneyDtoConverter.convert(dto.getSetupPrice()),
        MoneyDtoConverter.convert(dto.getMonthlyPrice()),
        dto.getPaymentIntervalMonths(),
        dto.getSupportingDocumentationRequired());
  }
}
