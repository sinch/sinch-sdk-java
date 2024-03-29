package com.sinch.sdk.domains.numbers.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.numbers.adapters.api.v1.CallbacksApi;
import com.sinch.sdk.domains.numbers.adapters.converters.CallbackConfigurationDtoConverter;
import com.sinch.sdk.domains.numbers.adapters.converters.CallbackConfigurationUpdateRequestParametersDtoConverter;
import com.sinch.sdk.domains.numbers.models.CallbackConfiguration;
import com.sinch.sdk.domains.numbers.models.dto.v1.CallbackConfigurationDto;
import com.sinch.sdk.domains.numbers.models.requests.CallbackConfigurationUpdateRequestParameters;
import com.sinch.sdk.models.NumbersContext;
import java.util.Map;

public class CallbackConfigurationService
    implements com.sinch.sdk.domains.numbers.CallbackConfigurationService {

  private final String uriUUID;
  private final CallbacksApi api;

  public CallbackConfigurationService(
      String uriUUID,
      NumbersContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers) {
    this.uriUUID = uriUUID;
    this.api =
        new CallbacksApi(httpClient, context.getNumbersServer(), authManagers, new HttpMapper());
  }

  protected CallbacksApi getApi() {
    return this.api;
  }

  public CallbackConfiguration get() throws ApiException {
    CallbackConfigurationDto response = getApi().getCallbackConfiguration(uriUUID);
    return CallbackConfigurationDtoConverter.convert(response);
  }

  public CallbackConfiguration update(CallbackConfigurationUpdateRequestParameters parameters)
      throws ApiException {

    CallbackConfigurationDto response =
        getApi()
            .updateCallbackConfiguration(
                uriUUID,
                CallbackConfigurationUpdateRequestParametersDtoConverter.convert(parameters));
    return CallbackConfigurationDtoConverter.convert(response);
  }
}
