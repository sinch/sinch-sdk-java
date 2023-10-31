package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.domains.numbers.models.ProvisioningStatus;
import com.sinch.sdk.domains.numbers.models.ScheduledSmsProvisioning;
import com.sinch.sdk.domains.numbers.models.SmsErrorCode;
import com.sinch.sdk.domains.numbers.models.dto.v1.ScheduledProvisioningDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.SmsErrorCodeDto;
import java.time.ZoneOffset;
import java.util.stream.Collectors;

public class ScheduledSmsProvisioningDtoConverter {

  public static ScheduledSmsProvisioning convert(ScheduledProvisioningDto dto) {

    if (null == dto) {
      return null;
    }
    return new ScheduledSmsProvisioning(
        dto.getServicePlanId(),
        dto.getCampaignId(),
        ProvisioningStatus.from(dto.getStatus().getValue()),
        dto.getLastUpdatedTime().toInstant(),
        dto.getErrorCodes().stream()
            .map(e -> SmsErrorCode.from(e.getValue()))
            .collect(Collectors.toList()));
  }

  public static ScheduledProvisioningDto convert(ScheduledSmsProvisioning provisioning) {

    if (null == provisioning) {
      return null;
    }

    return new ScheduledProvisioningDto(
        provisioning.getServicePlanId(),
        provisioning.getCampaignId(),
        provisioning.getLastUpdatedTime().atOffset(ZoneOffset.UTC),
        provisioning.getErrorCodes().stream()
            .map(e -> SmsErrorCodeDto.fromValue(e.value()))
            .collect(Collectors.toList()));
  }
}
