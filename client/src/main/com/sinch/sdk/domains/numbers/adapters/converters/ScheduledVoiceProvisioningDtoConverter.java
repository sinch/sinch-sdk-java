package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.domains.common.adapters.converters.EnumDynamicConverter;
import com.sinch.sdk.domains.numbers.models.ProvisioningStatus;
import com.sinch.sdk.domains.numbers.models.ScheduledVoiceProvisioning;
import com.sinch.sdk.domains.numbers.models.dto.v1.ProvisioningStatusDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.ScheduledVoiceProvisioningDto;
import java.time.ZoneOffset;

public class ScheduledVoiceProvisioningDtoConverter {

  public static ScheduledVoiceProvisioning convert(ScheduledVoiceProvisioningDto dto) {

    if (null == dto) {
      return null;
    }
    return new ScheduledVoiceProvisioning(
        dto.getAppId(),
        ProvisioningStatus.from(dto.getStatus().getValue()),
        dto.getLastUpdatedTime().toInstant());
  }

  public static ScheduledVoiceProvisioningDto convert(ScheduledVoiceProvisioning provisioning) {

    if (null == provisioning) {
      return null;
    }

    ScheduledVoiceProvisioningDto dto =
        new ScheduledVoiceProvisioningDto(
            provisioning.getAppId(), provisioning.getLastUpdatedTime().atOffset(ZoneOffset.UTC));
    dto.status(
        ProvisioningStatusDto.fromValue(EnumDynamicConverter.convert(provisioning.getStatus())));
    return dto;
  }
}
