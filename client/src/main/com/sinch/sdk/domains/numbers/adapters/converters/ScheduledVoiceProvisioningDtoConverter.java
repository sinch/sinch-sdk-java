package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.domains.common.adapters.converters.EnumDynamicConverter;
import com.sinch.sdk.domains.numbers.models.ProvisioningStatus;
import com.sinch.sdk.domains.numbers.models.ScheduledVoiceProvisioning;

public class ScheduledVoiceProvisioningDtoConverter {

  public static ScheduledVoiceProvisioning convert(
      com.sinch.sdk.domains.numbers.models.v1.ScheduledVoiceProvisioning dto) {

    if (null == dto) {
      return null;
    }
    return new ScheduledVoiceProvisioning(
        dto.getAppId(),
        null == dto.getStatus() ? null : ProvisioningStatus.from(dto.getStatus().value()),
        dto.getLastUpdatedTime());
  }

  public static com.sinch.sdk.domains.numbers.models.v1.ScheduledVoiceProvisioning convert(
      ScheduledVoiceProvisioning provisioning) {

    if (null == provisioning) {
      return null;
    }

    com.sinch.sdk.domains.numbers.models.v1.ScheduledVoiceProvisioning.Builder dto =
        com.sinch.sdk.domains.numbers.models.v1.ScheduledVoiceProvisioning.builder();

    dto.setAppId(provisioning.getAppId());
    dto.setLastUpdatedTime(provisioning.getLastUpdatedTime());
    if (null != provisioning.getStatus()) {
      dto.setStatus(
          com.sinch.sdk.domains.numbers.models.v1.ProvisioningStatus.from(
              EnumDynamicConverter.convert(provisioning.getStatus())));
    }
    return dto.build();
  }
}
