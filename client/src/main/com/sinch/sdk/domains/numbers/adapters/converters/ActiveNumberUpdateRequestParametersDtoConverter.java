package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.domains.numbers.models.dto.v1.ActiveNumberRequestDto;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberUpdateRequestParameters;

public class ActiveNumberUpdateRequestParametersDtoConverter {

  public static ActiveNumberRequestDto convert(ActiveNumberUpdateRequestParameters parameters) {
    ActiveNumberRequestDto dto = new ActiveNumberRequestDto();
    parameters.getDisplayName().ifPresent(dto::setDisplayName);
    parameters
        .getSmsConfiguration()
        .ifPresent(value -> dto.setSmsConfiguration(SmsConfigurationDtoConverter.convert(value)));
    parameters
        .getVoiceConfiguration()
        .ifPresent(
            value -> dto.setVoiceConfiguration(VoiceConfigurationDtoConverter.convert(value)));
    parameters.getCallback().ifPresent(dto::setCallbackUrl);
    return dto;
  }
}
