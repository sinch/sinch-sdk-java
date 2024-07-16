package com.sinch.sdk.domains.numbers.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.numbers.adapters.converters.CallbackConfigurationDtoConverter;
import com.sinch.sdk.domains.numbers.adapters.converters.CallbackConfigurationUpdateRequestParametersDtoConverter;
import com.sinch.sdk.domains.numbers.models.CallbackConfiguration;
import com.sinch.sdk.domains.numbers.models.requests.CallbackConfigurationUpdateRequestParameters;

public class CallbackConfigurationService
    implements com.sinch.sdk.domains.numbers.CallbackConfigurationService {

  com.sinch.sdk.domains.numbers.api.v1.CallbackConfigurationService v1;

  public CallbackConfigurationService(
      com.sinch.sdk.domains.numbers.api.v1.CallbackConfigurationService v1) {
    this.v1 = v1;
  }

  public CallbackConfiguration get() throws ApiException {
    return CallbackConfigurationDtoConverter.convert(v1.get());
  }

  public CallbackConfiguration update(CallbackConfigurationUpdateRequestParameters parameters)
      throws ApiException {

    return CallbackConfigurationDtoConverter.convert(
        v1.update(CallbackConfigurationUpdateRequestParametersDtoConverter.convert(parameters)));
  }
}
