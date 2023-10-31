package com.sinch.sdk.domains.numbers.adapters.converters;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.sinch.sdk.domains.numbers.models.VoiceConfiguration;
import com.sinch.sdk.domains.numbers.models.dto.v1.ProvisioningStatusDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.ScheduledVoiceProvisioningDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.VoiceConfigurationDto;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Test;

class VoiceConfigurationDtoConverterTest {

  public static void compareWithDto(VoiceConfiguration client, VoiceConfigurationDto dto) {
    if (null == client && null == dto) {
      return;
    }
    assertEquals(dto.getAppId(), client.getAppId());
    assertEquals(dto.getLastUpdatedTime().toInstant(), client.getLastUpdatedTime().get());
    ScheduledVoiceProvisioningDtoConverterTest.compareWithDto(
        client.getScheduledVoiceProvisioning().get(), dto.getScheduledVoiceProvisioning());
  }

  @Test
  void convert() {
    VoiceConfigurationDto dto =
        new VoiceConfigurationDto(OffsetDateTime.now())
            .appId("app id")
            .scheduledVoiceProvisioning(
                new ScheduledVoiceProvisioningDto("app id", OffsetDateTime.now())
                    .status(ProvisioningStatusDto.WAITING));

    VoiceConfiguration converted = VoiceConfigurationDtoConverter.convert(dto);
    compareWithDto(converted, dto);
  }
}
