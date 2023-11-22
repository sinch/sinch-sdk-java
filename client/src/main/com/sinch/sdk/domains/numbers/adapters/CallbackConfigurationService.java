package com.sinch.sdk.domains.numbers.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.numbers.adapters.api.v1.CallbackConfigurationApi;
import com.sinch.sdk.domains.numbers.adapters.converters.CallbackConfigurationDtoConverter;
import com.sinch.sdk.domains.numbers.adapters.converters.CallbackConfigurationUpdateRequestParametersDtoConverter;
import com.sinch.sdk.domains.numbers.models.CallbackConfiguration;
import com.sinch.sdk.domains.numbers.models.dto.v1.CallbackConfigurationDto;
import com.sinch.sdk.domains.numbers.models.requests.CallbackConfigurationUpdateRequestParameters;
import com.sinch.sdk.models.Configuration;
import java.util.Map;

public class CallbackConfigurationService
    implements com.sinch.sdk.domains.numbers.CallbackConfigurationService {

  private Configuration configuration;
  private CallbackConfigurationApi api;

  public CallbackConfigurationService() {}

  public CallbackConfigurationService(
      Configuration configuration, HttpClient httpClient, Map<String, AuthManager> authManagers) {
    this.configuration = configuration;
    this.api =
        new CallbackConfigurationApi(
            httpClient, configuration.getNumbersServer(), authManagers, new HttpMapper());
  }

  private CallbackConfigurationApi getApi() {
    return this.api;
  }

  public CallbackConfiguration get() throws ApiException {
    CallbackConfigurationDto response =
        getApi().getCallbackConfiguration(configuration.getProjectId());
    return CallbackConfigurationDtoConverter.convert(response);
  }

  public CallbackConfiguration update(CallbackConfigurationUpdateRequestParameters parameters)
      throws ApiException {

    CallbackConfigurationDto response =
        getApi()
            .updateCallbackConfiguration(
                configuration.getProjectId(),
                CallbackConfigurationUpdateRequestParametersDtoConverter.convert(parameters));
    return CallbackConfigurationDtoConverter.convert(response);
  }
}
