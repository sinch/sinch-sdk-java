package com.sinch.sdk.domains.numbers.adapters.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sinch.sdk.domains.numbers.models.AvailableNumber;
import com.sinch.sdk.domains.numbers.models.Capability;
import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.dto.v1.AvailableNumberDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.AvailableNumbersResponseDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.MoneyDto;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AvailableNumberDtoConverterTest {

  AvailableNumberDto dtoItem;

  public static void compareWithDto(AvailableNumber client, AvailableNumberDto dto) {
    assertEquals(dto.getPhoneNumber(), client.getPhoneNumber());
    assertEquals(dto.getRegionCode(), client.getRegionCode());
    assertEquals(dto.getType(), NumberType.valueOf(client.getType()));
    assertEquals(
        null == dto.getCapability() ? null : dto.getCapability(),
        null == client.getCapability()
            ? null
            : client.getCapability().stream()
                .map(Capability::valueOf)
                .collect(Collectors.toList()));
    MoneyDtoConverterTest.compareWithDto(client.getSetupPrice(), dto.getSetupPrice());
    MoneyDtoConverterTest.compareWithDto(client.getMonthlyPrice(), dto.getMonthlyPrice());
    assertEquals(dto.getPaymentIntervalMonths(), client.getPaymentIntervalMonths());
    assertEquals(
        dto.getSupportingDocumentationRequired(), client.getSupportingDocumentationRequired());
  }

  @Test
  void convertAvailableNumbersResponseDto() {
    AvailableNumbersResponseDto dto = new AvailableNumbersResponseDto();
    dto.setAvailableNumbers(Collections.singletonList(dtoItem));

    Collection<AvailableNumber> converted = AvailableNumberDtoConverter.convert(dto);

    assertEquals(dto.getAvailableNumbers().size(), converted.size());
  }

  @Test
  void convertEmptyAvailableNumbersResponseDto() {
    AvailableNumbersResponseDto dto = new AvailableNumbersResponseDto();
    Collection<AvailableNumber> converted = AvailableNumberDtoConverter.convert(dto);

    assertEquals(converted.size(), 0);
  }

  @Test
  void convertAvailableNumberDto() {
    AvailableNumberDto dto = dtoItem;
    AvailableNumber converted = AvailableNumberDtoConverter.convert(dtoItem);
    compareWithDto(converted, dto);
  }

  @Test
  void convertAvailableNumberDtoWithUnknownType() {
    dtoItem =
        new AvailableNumberDto("phoneNumber", "regionCode", 4, true)
            .type("foo")
            .addCapabilityItem(Capability.SMS.value())
            .addCapabilityItem(Capability.VOICE.value())
            .setupPrice(new MoneyDto().currencyCode("EU").amount(".8"))
            .monthlyPrice(new MoneyDto().currencyCode("EU").amount(".15"));
    AvailableNumber converted = AvailableNumberDtoConverter.convert(dtoItem);
    compareWithDto(converted, dtoItem);
  }

  @BeforeEach
  void setUp() {
    dtoItem = new AvailableNumberDto("phoneNumber", "regionCode", 4, true);
  }
}
