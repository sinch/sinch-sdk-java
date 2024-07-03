package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.domains.numbers.models.requests.AvailableNumberRentRequestParameters;
import com.sinch.sdk.domains.numbers.models.v1.SmsConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.VoiceConfigurationRTC;
import com.sinch.sdk.domains.numbers.models.v1.available.request.AvailableNumberRentRequest;

public class AvailableRentRequestParametersDtoConverter {

  public static AvailableNumberRentRequest convert(
      AvailableNumberRentRequestParameters parameters) {

    AvailableNumberRentRequest.Builder dto = AvailableNumberRentRequest.builder();

    parameters
        .getSmsConfiguration()
        .ifPresent(
            value -> {
              SmsConfiguration.Builder config = SmsConfiguration.builder();
              value.getServicePlanId().ifPresent(config::setServicePlanId);
              value.getCampaignId().ifPresent(config::setCampaignId);
              dto.setSmsConfiguration(config.build());
            });

    parameters
        .getVoiceConfiguration()
        .ifPresent(
            value -> {
              VoiceConfigurationRTC.Builder config = VoiceConfigurationRTC.builder();
              value.getAppId().ifPresent(config::setAppId);
              dto.setVoiceConfiguration(config.build());
            });

    parameters.getCallBackUrl().ifPresent(dto::setCallbackUrl);
    return dto.build();
  }
}
