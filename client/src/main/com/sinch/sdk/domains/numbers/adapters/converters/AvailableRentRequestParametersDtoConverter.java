package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.domains.numbers.models.dto.v1.RentAnyNumberRequestSmsConfigurationDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.RentAnyNumberRequestVoiceConfigurationDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.RentNumberRequestDto;
import com.sinch.sdk.domains.numbers.models.requests.AvailableNumberRentRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.RentSMSConfigurationRequestParameters;
import com.sinch.sdk.domains.numbers.models.requests.RentVoiceConfigurationRequestParameters;
import java.util.Optional;

public class AvailableRentRequestParametersDtoConverter {

  public static RentNumberRequestDto convert(AvailableNumberRentRequestParameters parameters) {

    Optional<RentSMSConfigurationRequestParameters> sms = parameters.getSmsConfiguration();
    Optional<RentVoiceConfigurationRequestParameters> voice = parameters.getVoiceConfiguration();
    Optional<String> callbackUrl = parameters.getCallBackUrl();

    RentNumberRequestDto dto = new RentNumberRequestDto();

    sms.ifPresent(
        value ->
            dto.smsConfiguration(
                new RentAnyNumberRequestSmsConfigurationDto()
                    .campaignId(value.getCampaignId().orElse(null))
                    .servicePlanId(value.getServicePlanId())));
    voice.ifPresent(
        value ->
            dto.voiceConfiguration(
                new RentAnyNumberRequestVoiceConfigurationDto().appId(value.getAppId())));
    callbackUrl.ifPresent(dto::callbackUrl);
    return dto;
  }
}
