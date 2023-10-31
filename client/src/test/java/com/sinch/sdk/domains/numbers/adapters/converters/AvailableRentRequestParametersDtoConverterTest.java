package com.sinch.sdk.domains.numbers.adapters.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import com.sinch.sdk.domains.numbers.models.dto.v1.RentNumberRequestDto;
import com.sinch.sdk.domains.numbers.models.requests.AvailableNumberRentRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.RentSMSConfigurationRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.RentVoiceConfigurationRequestParameters;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AvailableRentRequestParametersDtoConverterTest {
  AvailableNumberRentRequestParameters item;

  public static void compareWithDto(
      AvailableNumberRentRequestParameters client, RentNumberRequestDto dto) {

    if (null == dto.getSmsConfiguration()) {
      assertFalse(client.getSmsConfiguration().isPresent());
    } else {
      assertEquals(
          dto.getSmsConfiguration().getCampaignId(),
          client.getSmsConfiguration().get().getCampaignId().get());
      assertEquals(
          dto.getSmsConfiguration().getServicePlanId(),
          client.getSmsConfiguration().get().getServicePlanId());
    }
    if (null == dto.getVoiceConfiguration()) {
      assertFalse(client.getVoiceConfiguration().isPresent());
    } else {
      assertEquals(
          dto.getVoiceConfiguration().getAppId(), client.getVoiceConfiguration().get().getAppId());
    }
    if (null == dto.getCallbackUrl()) {
      assertFalse(client.getCallBackUrl().isPresent());
    } else {
      assertEquals(dto.getCallbackUrl(), client.getCallBackUrl().get());
    }
  }

  @Test
  void convert() {
    RentNumberRequestDto converted = AvailableRentRequestParametersDtoConverter.convert(item);
    compareWithDto(item, converted);
  }

  @BeforeEach
  void setUp() {
    item =
        AvailableNumberRentRequestParameters.builder()
            .setSmsConfiguration(
                new RentSMSConfigurationRequestParameters("campaign id", ("service plan")))
            .setVoiceConfiguration(new RentVoiceConfigurationRequestParameters("app id"))
            .setCallbackUrl("callback url")
            .build();
  }
}
