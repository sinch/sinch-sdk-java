package com.sinch.sdk.domains.numbers.adapters.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.sinch.sdk.domains.numbers.models.Capability;
import com.sinch.sdk.domains.numbers.models.NumberPattern;
import com.sinch.sdk.domains.numbers.models.NumberType;
import com.sinch.sdk.domains.numbers.models.SearchPattern;
import com.sinch.sdk.domains.numbers.models.dto.v1.RentAnyNumberRequestDto;
import com.sinch.sdk.domains.numbers.models.requests.AvailableNumberRentAnyRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.RentSMSConfigurationRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.RentVoiceConfigurationRequestParameters;
import java.util.Collections;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AvailableRentAnyRequestParametersDtoConverterTest {

  AvailableNumberRentAnyRequestParameters item;

  public static void compareWithDto(
      AvailableNumberRentAnyRequestParameters client, RentAnyNumberRequestDto dto) {
    assertEquals(dto.getRegionCode(), client.getRegionCode().get());
    assertEquals(dto.getType(), NumberType.valueOf(client.getType().get()));
    if (null == dto.getNumberPattern()) {
      assertFalse(client.getNumberPattern().isPresent());
    } else {
      assertEquals(
          dto.getNumberPattern().getPattern(), client.getNumberPattern().get().getPattern());
      assertEquals(
          dto.getNumberPattern().getSearchPattern(),
          client.getNumberPattern().get().getSearchPattern().value());
    }
    if (null == dto.getCapabilities()) {
      assertFalse(client.getCapabilities().isPresent());
    } else {
      assertEquals(
          dto.getCapabilities(),
          client.getCapabilities().get().stream()
              .map(Capability::valueOf)
              .collect(Collectors.toList()));
    }
    if (null == dto.getSmsConfiguration()) {
      assertFalse(client.getSmsConfiguration().isPresent());
    } else {
      assertEquals(
          dto.getSmsConfiguration().getCampaignId(),
          client.getSmsConfiguration().get().getCampaignId().get());
      assertEquals(
          dto.getSmsConfiguration().getServicePlanId(),
          client.getSmsConfiguration().get().getServicePlanId().get());
    }
    if (null == dto.getVoiceConfiguration()) {
      assertFalse(client.getVoiceConfiguration().isPresent());
    } else {
      assertEquals(
          dto.getVoiceConfiguration().getAppId(),
          client.getVoiceConfiguration().get().getAppId().get());
    }
    if (null == dto.getCallbackUrl()) {
      assertFalse(client.getCallBackUrl().isPresent());
    } else {
      assertEquals(dto.getCallbackUrl(), client.getCallBackUrl().get());
    }
  }

  @Test
  void convert() {
    RentAnyNumberRequestDto converted = AvailableRentAnyRequestParametersDtoConverter.convert(item);
    compareWithDto(item, converted);
  }

  @BeforeEach
  void setUp() {
    item =
        AvailableNumberRentAnyRequestParameters.builder()
            .setRegionCode("region code")
            .setType(NumberType.from("foo type"))
            .setNumberPattern(
                NumberPattern.builder()
                    .setPattern("pattern")
                    .setSearchPattern(SearchPattern.CONTAINS)
                    .build())
            .setCapabilities(Collections.singletonList(Capability.SMS))
            .setSmsConfiguration(
                RentSMSConfigurationRequestParameters.builder()
                    .setCampaignId("campaign id")
                    .setServicePlanId("service plan")
                    .build())
            .setVoiceConfiguration(
                RentVoiceConfigurationRequestParameters.builder().setAppId("app id").build())
            .setCallbackUrl("callback url")
            .build();
  }
}
