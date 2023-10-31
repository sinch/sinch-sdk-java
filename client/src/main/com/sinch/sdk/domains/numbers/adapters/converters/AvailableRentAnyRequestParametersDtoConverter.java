package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.domains.numbers.models.NumberPattern;
import com.sinch.sdk.domains.numbers.models.dto.v1.RentAnyNumberRequestDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.RentAnyNumberRequestSmsConfigurationDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.RentAnyNumberRequestVoiceConfigurationDto;
import com.sinch.sdk.domains.numbers.models.dto.v1.SearchPatternDto;
import com.sinch.sdk.domains.numbers.models.requests.AvailableNumberRentAnyRequestParameters;
import java.util.Optional;
import java.util.stream.Collectors;

public class AvailableRentAnyRequestParametersDtoConverter {
  public static RentAnyNumberRequestDto convert(
      AvailableNumberRentAnyRequestParameters parameters) {

    RentAnyNumberRequestDto dto =
        new RentAnyNumberRequestDto()
            .regionCode(parameters.getRegionCode())
            .type(parameters.getType().value());

    Optional<NumberPattern> pattern = parameters.getNumberPattern();
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
            value ->
                dto.smsConfiguration(
                    new RentAnyNumberRequestSmsConfigurationDto()
                        .campaignId(value.getCampaignId().orElse(null))
                        .servicePlanId(value.getServicePlanId())));
    parameters
        .getVoiceConfiguration()
        .ifPresent(
            value ->
                dto.voiceConfiguration(
                    new RentAnyNumberRequestVoiceConfigurationDto().appId(value.getAppId())));

    parameters.getCallBackUrl().ifPresent(dto::callbackUrl);
    return dto;
  }
}
