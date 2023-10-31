package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.domains.numbers.models.AvailableNumber;
import com.sinch.sdk.domains.numbers.models.Capability;
import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.dto.v1.AvailableNumberDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.AvailableNumbersResponseDto;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AvailableNumberDtoConverter {

  public static Collection<AvailableNumber> convert(AvailableNumbersResponseDto dto) {
    List<AvailableNumberDto> list = dto.getAvailableNumbers();
    if (null == list) {
      return Collections.emptyList();
    }
    return list.stream().map(AvailableNumberDtoConverter::convert).collect(Collectors.toList());
  }

  public static AvailableNumber convert(AvailableNumberDto dto) {

    return new AvailableNumber(
        dto.getPhoneNumber(),
        dto.getRegionCode(),
        NumberType.from(dto.getType()),
        null != dto.getCapability()
            ? dto.getCapability().stream().map(Capability::from).collect(Collectors.toList())
            : null,
        MoneyDtoConverter.convert(dto.getSetupPrice()),
        MoneyDtoConverter.convert(dto.getMonthlyPrice()),
        dto.getPaymentIntervalMonths(),
        dto.getSupportingDocumentationRequired());
  }
}
