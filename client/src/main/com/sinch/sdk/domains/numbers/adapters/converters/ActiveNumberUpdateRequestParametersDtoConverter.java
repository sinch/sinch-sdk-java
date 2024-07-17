package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberUpdateRequestParameters;
import com.sinch.sdk.domains.numbers.models.v1.request.ActiveNumberUpdateRequest;

public class ActiveNumberUpdateRequestParametersDtoConverter {

  public static ActiveNumberUpdateRequest convert(ActiveNumberUpdateRequestParameters parameters) {
    ActiveNumberUpdateRequest.Builder dto = ActiveNumberUpdateRequest.builder();
    parameters.getDisplayName().ifPresent(dto::setDisplayName);
    parameters
        .getSmsConfiguration()
        .ifPresent(value -> dto.setSmsConfiguration(SmsConfigurationDtoConverter.convert(value)));
    parameters
        .getVoiceConfiguration()
        .ifPresent(
            value -> dto.setVoiceConfiguration(VoiceConfigurationDtoConverter.convert(value)));
    parameters.getCallback().ifPresent(dto::setCallbackUrl);
    return dto.build();
  }
}
