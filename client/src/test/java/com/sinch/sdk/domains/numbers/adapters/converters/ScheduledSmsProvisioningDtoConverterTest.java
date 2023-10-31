package com.sinch.sdk.domains.numbers.adapters.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sinch.sdk.domains.numbers.models.ScheduledSmsProvisioning;
import com.sinch.sdk.domains.numbers.models.SmsErrorCode;
import com.sinch.sdk.domains.numbers.models.dto.v1.ProvisioningStatusDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.ScheduledProvisioningDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.SmsErrorCodeDto;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ScheduledSmsProvisioningDtoConverterTest {

  public static void compareWithDto(ScheduledSmsProvisioning client, ScheduledProvisioningDto dto) {
    if (null == client && null == dto) {
      return;
    }
    assertEquals(dto.getServicePlanId(), client.getServicePlanId());
    assertEquals(dto.getCampaignId(), client.getCampaignId());
    assertEquals(dto.getLastUpdatedTime().toInstant(), client.getLastUpdatedTime());
    assertEquals(dto.getStatus().getValue(), client.getStatus().value());
    Assertions.assertThat(dto.getErrorCodes().stream().map(Enum::name).collect(Collectors.toList()))
        .usingRecursiveComparison()
        .isEqualTo(
            client.getErrorCodes().stream()
                .map(SmsErrorCode::valueOf)
                .collect(Collectors.toList()));
  }

  @Test
  void convert() {
    ScheduledProvisioningDto dto =
        new ScheduledProvisioningDto(
                "service plan id",
                "campaign id",
                OffsetDateTime.now(),
                Collections.singletonList(SmsErrorCodeDto.ERROR_CODE_UNSPECIFIED))
            .status(ProvisioningStatusDto.WAITING);

    ScheduledSmsProvisioning converted = ScheduledSmsProvisioningDtoConverter.convert(dto);
    compareWithDto(converted, dto);
  }
}
