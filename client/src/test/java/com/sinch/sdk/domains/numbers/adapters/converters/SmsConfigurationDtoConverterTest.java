package com.sinch.sdk.domains.numbers.adapters.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sinch.sdk.domains.numbers.models.SMSConfiguration;
import com.sinch.sdk.domains.numbers.models.dto.v1.ProvisioningStatusDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.SMSConfigurationDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.ScheduledProvisioningDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.SmsErrorCodeDto;
import java.time.OffsetDateTime;
import java.util.Collections;
import org.junit.jupiter.api.Test;

class SmsConfigurationDtoConverterTest {

  public static void compareWithDto(SMSConfiguration client, SMSConfigurationDto dto) {
    if (null == client && null == dto) {
      return;
    }
    assertEquals(dto.getServicePlanId(), client.getServicePlanId());
    assertEquals(dto.getCampaignId(), client.getCampaignId().get());
    ScheduledSmsProvisioningDtoConverterTest.compareWithDto(
        client.getScheduledSmsProvisioning().get(), dto.getScheduledProvisioning());
  }

  @Test
  void convert() {
    SMSConfigurationDto dto =
        new SMSConfigurationDto()
            .servicePlanId("service plan id")
            .campaignId("campaign id")
            .scheduledProvisioning(
                new ScheduledProvisioningDto(
                        "service plan id",
                        "campaign id",
                        OffsetDateTime.now(),
                        Collections.singletonList(SmsErrorCodeDto.ERROR_CODE_UNSPECIFIED))
                    .status(ProvisioningStatusDto.WAITING));

    SMSConfiguration converted = SmsConfigurationDtoConverter.convert(dto);
    compareWithDto(converted, dto);
  }
}
