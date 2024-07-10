package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.domains.numbers.models.SMSConfiguration;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberUpdateSMSConfigurationRequestParameters;
import com.sinch.sdk.domains.numbers.models.v1.SmsConfiguration;

public class SmsConfigurationDtoConverter {

  public static SMSConfiguration convert(
      com.sinch.sdk.domains.numbers.models.v1.SmsConfiguration dto) {

    if (null == dto) {
      return null;
    }
    return new SMSConfiguration(
        dto.getServicePlanId(),
        dto.getCampaignId(),
        ScheduledSmsProvisioningDtoConverter.convert(dto.getScheduledProvisioning()));
  }

  public static com.sinch.sdk.domains.numbers.models.v1.SmsConfiguration convert(
      ActiveNumberUpdateSMSConfigurationRequestParameters configuration) {

    if (null == configuration) {
      return null;
    }
    SmsConfiguration.Builder dto = SmsConfiguration.builder();
    configuration.getServicePlanId().ifPresent(dto::setServicePlanId);
    configuration.getCampaignId().ifPresent(dto::setCampaignId);
    return dto.build();
  }
}
