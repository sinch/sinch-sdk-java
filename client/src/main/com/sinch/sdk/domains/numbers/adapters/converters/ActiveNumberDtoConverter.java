package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.core.models.pagination.TokenPageNavigator;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.numbers.models.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.Capability;
import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.response.ActiveNumberListResponse;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class ActiveNumberDtoConverter {

  public static Pair<Collection<ActiveNumber>, TokenPageNavigator> convert(
      ActiveNumberListResponse dto) {
    String nextPageToken = dto.getNextPageToken();
    Collection<ActiveNumber> pageContent = Collections.emptyList();
    if (null != dto.getContent()) {
      pageContent =
          dto.getContent().stream()
              .map(ActiveNumberDtoConverter::convert)
              .collect(Collectors.toList());
    }
    return new Pair<>(pageContent, new TokenPageNavigator(nextPageToken));
  }

  public static ActiveNumber convert(com.sinch.sdk.domains.numbers.models.v1.ActiveNumber dto) {

    return new ActiveNumber(
        dto.getPhoneNumber(),
        dto.getProjectId(),
        dto.getDisplayName(),
        dto.getRegionCode(),
        null == dto.getType() ? null : NumberType.from(dto.getType().value()),
        null != dto.getCapability()
            ? dto.getCapability().stream()
                .map(f -> Capability.from(f.value()))
                .collect(Collectors.toList())
            : null,
        MoneyDtoConverter.convert(dto.getMoney()),
        dto.getPaymentIntervalMonths(),
        dto.getNextChargeDate(),
        dto.getExpireAt(),
        SmsConfigurationDtoConverter.convert(dto.getSmsConfiguration()),
        VoiceConfigurationDtoConverter.convert(dto.getVoiceConfiguration()),
        dto.getCallbackUrl());
  }
}
