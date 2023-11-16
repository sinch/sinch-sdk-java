package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.core.models.pagination.TokenPageNavigator;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.numbers.models.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.Capability;
import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.dto.v1.ActiveNumberDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.ActiveNumbersResponseDto;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ActiveNumberDtoConverter {

  public static Pair<Collection<ActiveNumber>, TokenPageNavigator> convert(
      ActiveNumbersResponseDto dto) {
    String nextPageToken = dto.getNextPageToken();
    List<ActiveNumberDto> list = dto.getActiveNumbers();
    Collection<ActiveNumber> pageContent = Collections.emptyList();
    if (null != list) {
      pageContent =
          list.stream().map(ActiveNumberDtoConverter::convert).collect(Collectors.toList());
    }
    return new Pair<>(pageContent, new TokenPageNavigator(nextPageToken));
  }

  public static ActiveNumber convert(ActiveNumberDto dto) {

    return new ActiveNumber(
        dto.getPhoneNumber(),
        dto.getProjectId(),
        dto.getDisplayName(),
        dto.getRegionCode(),
        NumberType.from(dto.getType()),
        null != dto.getCapability()
            ? dto.getCapability().stream().map(Capability::from).collect(Collectors.toList())
            : null,
        MoneyDtoConverter.convert(dto.getMoney()),
        dto.getPaymentIntervalMonths(),
        dto.getNextChargeDate().toInstant(),
        null != dto.getExpireAt() ? dto.getExpireAt().toInstant() : null,
        SmsConfigurationDtoConverter.convert(dto.getSmsConfiguration()),
        VoiceConfigurationDtoConverter.convert(dto.getVoiceConfiguration()),
        dto.getCallbackUrl());
  }
}
