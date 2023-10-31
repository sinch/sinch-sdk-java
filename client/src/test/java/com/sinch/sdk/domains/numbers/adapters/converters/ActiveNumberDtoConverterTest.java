package com.sinch.sdk.domains.numbers.adapters.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sinch.sdk.core.models.pagination.PageToken;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.numbers.models.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.Capability;
import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.dto.v1.ActiveNumberDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.ActiveNumbersResponseDto;
import java.time.OffsetDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ActiveNumberDtoConverterTest {

  static final OffsetDateTime offset1 = OffsetDateTime.now();
  ActiveNumberDto dtoItem;

  public static void compareWithDto(ActiveNumber client, ActiveNumberDto dto) {
    assertEquals(dto.getPhoneNumber(), client.getPhoneNumber());
    assertEquals(dto.getProjectId(), client.getProjectId());
    assertEquals(dto.getDisplayName(), client.getDisplayName());
    assertEquals(dto.getRegionCode(), client.getRegionCode());
    assertEquals(dto.getType(), NumberType.valueOf(client.getType()));
    assertEquals(
        null == dto.getCapability() ? null : dto.getCapability(),
        null == client.getCapability()
            ? null
            : client.getCapability().stream()
                .map(Capability::valueOf)
                .collect(Collectors.toList()));
    MoneyDtoConverterTest.compareWithDto(client.getMoney(), dto.getMoney());
    assertEquals(dto.getPaymentIntervalMonths(), client.getPaymentIntervalMonths());
    assertEquals(dto.getNextChargeDate().toInstant(), client.getNextChargeDate());
    assertEquals(dto.getExpireAt().toInstant(), client.getExpireAt());
    SmsConfigurationDtoConverterTest.compareWithDto(
        client.getSmsConfiguration(), dto.getSmsConfiguration());
    VoiceConfigurationDtoConverterTest.compareWithDto(
        client.getVoiceConfiguration(), dto.getVoiceConfiguration());
    assertEquals(dto.getCallbackUrl(), client.getCallbackUrl());
  }

  @Test
  void convertActiveNumbersResponseDto() {
    ActiveNumbersResponseDto dto = new ActiveNumbersResponseDto();
    dto.setActiveNumbers(Collections.singletonList(dtoItem));

    Pair<Collection<ActiveNumber>, PageToken<String>> converted =
        ActiveNumberDtoConverter.convert(dto);

    assertEquals(dto.getActiveNumbers().size(), converted.getLeft().size());
    assertEquals(dto.getNextPageToken(), converted.getRight().getToken());
    compareWithDto(converted.getLeft().stream().findFirst().get(), dto.getActiveNumbers().get(0));
  }

  @Test
  void convertActiveNumberDto() {
    ActiveNumberDto dto = dtoItem;
    ActiveNumber converted = ActiveNumberDtoConverter.convert(dtoItem);
    compareWithDto(converted, dto);
  }

  @BeforeEach
  void setUp() {
    dtoItem = new ActiveNumberDto("phoneNumber", 4, offset1, OffsetDateTime.MAX);
  }
}
