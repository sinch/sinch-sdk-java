package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.domains.numbers.models.requests.CallbackConfigurationUpdateRequestParameters;
import com.sinch.sdk.domains.numbers.models.v1.callbacks.request.CallbackConfigurationUpdateRequest;

public class CallbackConfigurationUpdateRequestParametersDtoConverter {

  public static CallbackConfigurationUpdateRequest convert(
      CallbackConfigurationUpdateRequestParameters parameters) {

    if (null == parameters) {
      return null;
    }
    CallbackConfigurationUpdateRequest.Builder dto = CallbackConfigurationUpdateRequest.builder();
    parameters.getHMACSecret().ifPresent(dto::setHmacSecret);
    return dto.build();
  }
}
