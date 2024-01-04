package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.numbers.models.dto.v1.RentAnyNumberRequestSmsConfigurationDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.RentAnyNumberRequestVoiceConfigurationDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.RentNumberRequestDto;
import com.sinch.sdk.domains.numbers.models.requests.AvailableNumberRentRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.RentSMSConfigurationRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.RentVoiceConfigurationRequestParameters;

public class AvailableRentRequestParametersDtoConverter {

  public static RentNumberRequestDto convert(AvailableNumberRentRequestParameters parameters) {

    OptionalValue<RentSMSConfigurationRequestParameters> sms = parameters.getSmsConfiguration();
    OptionalValue<RentVoiceConfigurationRequestParameters> voice =
        parameters.getVoiceConfiguration();
    OptionalValue<String> callbackUrl = parameters.getCallBackUrl();

    RentNumberRequestDto dto = new RentNumberRequestDto();

    sms.ifPresent(
        value -> {
          RentAnyNumberRequestSmsConfigurationDto config =
              new RentAnyNumberRequestSmsConfigurationDto();
          value.getServicePlanId().ifPresent(config::setServicePlanId);
          value.getCampaignId().ifPresent(config::setCampaignId);
          dto.smsConfiguration(config);
        });

    voice.ifPresent(
        value -> {
          RentAnyNumberRequestVoiceConfigurationDto config =
              new RentAnyNumberRequestVoiceConfigurationDto();
          value.getAppId().ifPresent(config::setAppId);
          dto.voiceConfiguration(config);
        });

    callbackUrl.ifPresent(dto::callbackUrl);
    return dto;
  }
}
