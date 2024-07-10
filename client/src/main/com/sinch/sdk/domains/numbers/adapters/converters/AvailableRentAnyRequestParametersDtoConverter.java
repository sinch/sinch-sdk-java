package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.domains.numbers.models.requests.AvailableNumberRentAnyRequestParameters;
import com.sinch.sdk.domains.numbers.models.v1.Capability;
import com.sinch.sdk.domains.numbers.models.v1.NumberType;
import com.sinch.sdk.domains.numbers.models.v1.SmsConfiguration;
import com.sinch.sdk.domains.numbers.models.v1.VoiceConfigurationRTC;
import com.sinch.sdk.domains.numbers.models.v1.request.AvailableNumberRentAnyRequest;
import com.sinch.sdk.domains.numbers.models.v1.request.SearchPosition;
import java.util.stream.Collectors;

public class AvailableRentAnyRequestParametersDtoConverter {
  public static AvailableNumberRentAnyRequest convert(
      AvailableNumberRentAnyRequestParameters parameters) {

    AvailableNumberRentAnyRequest.Builder dto = AvailableNumberRentAnyRequest.builder();

    parameters.getRegionCode().ifPresent(dto::setRegionCode);
    parameters.getType().ifPresent(f -> dto.setType(NumberType.from(f.value())));

    parameters
        .getNumberPattern()
        .ifPresent(
            f -> {
              com.sinch.sdk.domains.numbers.models.v1.request.SearchPattern.Builder spBuilder =
                  com.sinch.sdk.domains.numbers.models.v1.request.SearchPattern.builder();
              com.sinch.sdk.domains.numbers.models.v1.request.SearchPattern.builder();
              spBuilder.setPattern(f.getPattern());
              spBuilder.setPosition(
                  null != f.getSearchPattern()
                      ? SearchPosition.from(f.getSearchPattern().value())
                      : null);
              dto.setNumberPattern(spBuilder.build());
            });

    parameters
        .getCapabilities()
        .ifPresent(
            f ->
                dto.setCapabilities(
                    f.stream().map(c -> Capability.from(c.value())).collect(Collectors.toList())));

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
