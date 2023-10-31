package com.sinch.sdk.domains.numbers.adapters.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sinch.sdk.domains.numbers.models.ScheduledVoiceProvisioning;
import com.sinch.sdk.domains.numbers.models.dto.v1.ProvisioningStatusDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.ScheduledVoiceProvisioningDto;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;

class ScheduledVoiceProvisioningDtoConverterTest {

  public static void compareWithDto(
      ScheduledVoiceProvisioning client, ScheduledVoiceProvisioningDto dto) {
    if (null == client && null == dto) {
      return;
    }
    assertEquals(dto.getAppId(), client.getAppId());
    assertEquals(dto.getLastUpdatedTime().toInstant(), client.getLastUpdatedTime());
    assertEquals(dto.getStatus().getValue(), client.getStatus().value());
  }

  @Test
  void convert() {
    ScheduledVoiceProvisioningDto dto =
        new ScheduledVoiceProvisioningDto("app id", OffsetDateTime.now())
            .status(ProvisioningStatusDto.WAITING);

    ScheduledVoiceProvisioning converted = ScheduledVoiceProvisioningDtoConverter.convert(dto);
    compareWithDto(converted, dto);
  }
}
