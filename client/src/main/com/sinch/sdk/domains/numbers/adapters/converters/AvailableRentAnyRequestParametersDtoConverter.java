package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.domains.numbers.models.NumberPattern;
import com.sinch.sdk.domains.numbers.models.dto.v1.RentAnyNumberRequestDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.RentAnyNumberRequestSmsConfigurationDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.RentAnyNumberRequestVoiceConfigurationDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.SearchPatternDto;
import com.sinch.sdk.domains.numbers.models.requests.AvailableNumberRentAnyRequestParameters;
import java.util.stream.Collectors;

public class AvailableRentAnyRequestParametersDtoConverter {
  public static RentAnyNumberRequestDto convert(
      AvailableNumberRentAnyRequestParameters parameters) {

    RentAnyNumberRequestDto dto =
        new RentAnyNumberRequestDto()
            .regionCode(parameters.getRegionCode().get())
            .type(parameters.getType().get().value());

    OptionalValue<NumberPattern> pattern = parameters.getNumberPattern();
    if (pattern.isPresent()) {
      NumberPattern p = pattern.get();
      String patternPattern = p.getPattern();
      String searchPattern = p.getSearchPattern().value();
      SearchPatternDto spDto = new SearchPatternDto();
      spDto.pattern(patternPattern);
      spDto.searchPattern(searchPattern);
      dto.numberPattern(spDto);
    }

    parameters
        .getCapabilities()
        .ifPresent(
            value ->
                dto.capabilities(
                    value.stream().map(EnumDynamic::value).collect(Collectors.toList())));
    parameters
        .getSmsConfiguration()
        .ifPresent(
            value -> {
              RentAnyNumberRequestSmsConfigurationDto config =
                  new RentAnyNumberRequestSmsConfigurationDto();
              value.getServicePlanId().ifPresent(config::setServicePlanId);
              value.getCampaignId().ifPresent(config::setCampaignId);
              dto.smsConfiguration(config);
            });
    parameters
        .getVoiceConfiguration()
        .ifPresent(
            value -> {
              RentAnyNumberRequestVoiceConfigurationDto config =
                  new RentAnyNumberRequestVoiceConfigurationDto();
              value.getAppId().ifPresent(config::setAppId);
              dto.voiceConfiguration(config);
            });
    parameters.getCallBackUrl().ifPresent(dto::callbackUrl);
    return dto;
  }
}
