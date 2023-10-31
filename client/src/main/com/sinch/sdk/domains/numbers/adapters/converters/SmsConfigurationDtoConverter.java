package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.domains.numbers.models.SMSConfiguration;
import com.sinch.sdk.domains.numbers.models.dto.v1.SMSConfigurationDto;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberUpdateSMSConfigurationRequestParameters;

public class SmsConfigurationDtoConverter {

  public static SMSConfiguration convert(SMSConfigurationDto dto) {

    if (null == dto) {
      return null;
    }
    return new SMSConfiguration(
        dto.getServicePlanId(),
        dto.getCampaignId(),
        ScheduledSmsProvisioningDtoConverter.convert(dto.getScheduledProvisioning()));
  }

  public static SMSConfigurationDto convert(
      ActiveNumberUpdateSMSConfigurationRequestParameters configuration) {

    if (null == configuration) {
      return null;
    }
    SMSConfigurationDto dto = new SMSConfigurationDto();
    dto.servicePlanId(configuration.getServicePlanId());
    configuration.getCampaignId().ifPresent(dto::campaignId);
    return dto;
  }
}
