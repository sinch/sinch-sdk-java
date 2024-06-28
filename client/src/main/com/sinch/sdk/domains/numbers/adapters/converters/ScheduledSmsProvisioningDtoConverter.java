package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.domains.common.adapters.converters.EnumDynamicConverter;
import com.sinch.sdk.domains.numbers.models.ProvisioningStatus;
import com.sinch.sdk.domains.numbers.models.ScheduledSmsProvisioning;
import com.sinch.sdk.domains.numbers.models.SmsErrorCode;
import java.util.stream.Collectors;

public class ScheduledSmsProvisioningDtoConverter {

  public static ScheduledSmsProvisioning convert(
      com.sinch.sdk.domains.numbers.models.v1.ScheduledSmsProvisioning dto) {

    if (null == dto) {
      return null;
    }
    return new ScheduledSmsProvisioning(
        dto.getServicePlanId(),
        dto.getCampaignId(),
        null == dto.getStatus() ? null : ProvisioningStatus.from(dto.getStatus().value()),
        dto.getLastUpdatedTime(),
        dto.getErrorCodes().stream()
            .map(e -> SmsErrorCode.from(e.value()))
            .collect(Collectors.toList()));
  }

  public static com.sinch.sdk.domains.numbers.models.v1.ScheduledSmsProvisioning convert(
      ScheduledSmsProvisioning provisioning) {

    if (null == provisioning) {
      return null;
    }

    com.sinch.sdk.domains.numbers.models.v1.ScheduledSmsProvisioning.Builder builder =
        com.sinch.sdk.domains.numbers.models.v1.ScheduledSmsProvisioning.builder();

    if (null != provisioning.getServicePlanId()) {
      builder.setServicePlanId(provisioning.getServicePlanId());
    }
    if (null != provisioning.getCampaignId()) {
      builder.setCampaignId(provisioning.getCampaignId());
    }
    if (null != provisioning.getLastUpdatedTime()) {
      builder.setLastUpdatedTime(provisioning.getLastUpdatedTime());
    }
    if (null != provisioning.getErrorCodes()) {
      builder.setErrorCodes(
          provisioning.getErrorCodes().stream()
              .map(
                  e ->
                      com.sinch.sdk.domains.numbers.models.v1.SmsErrorCode.from(
                          EnumDynamicConverter.convert(e)))
              .collect(Collectors.toList()));
    }
    return builder.build();
  }
}
