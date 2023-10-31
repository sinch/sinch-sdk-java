package com.sinch.sdk.domains.numbers.adapters.converters;

import com.sinch.sdk.domains.numbers.models.dto.v1.CallbackConfigurationUpdateDto;
import com.sinch.sdk.domains.numbers.models.requests.CallbackConfigurationUpdateRequestParameters;

public class CallbackConfigurationUpdateRequestParametersDtoConverter {

  public static CallbackConfigurationUpdateDto convert(
      CallbackConfigurationUpdateRequestParameters parameters) {

    if (null == parameters) {
      return null;
    }
    return new CallbackConfigurationUpdateDto().hmacSecret(parameters.getHMACSecret());
  }
}
