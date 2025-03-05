package com.sinch.sdk.domains.numbers.api.v1.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.numbers.api.v1.internal.CallbacksApi;
import com.sinch.sdk.domains.numbers.models.v1.callbacks.request.CallbackConfigurationUpdateRequest;
import com.sinch.sdk.domains.numbers.models.v1.callbacks.response.CallbackConfigurationResponse;
import com.sinch.sdk.models.NumbersContext;
import java.util.Map;
import java.util.function.Supplier;

public class CallbackConfigurationService
    implements com.sinch.sdk.domains.numbers.api.v1.CallbackConfigurationService {

  private final String uriUUID;
  private final CallbacksApi api;

  public CallbackConfigurationService(
      String uriUUID,
      NumbersContext context,
      Supplier<HttpClient> httpClientSupplier,
      Map<String, AuthManager> authManagers) {
    this.uriUUID = uriUUID;
    this.api =
        new CallbacksApi(
            httpClientSupplier.get(),
            context.getNumbersServer(),
            authManagers,
            HttpMapper.getInstance());
  }

  protected CallbacksApi getApi() {
    return this.api;
  }

  public CallbackConfigurationResponse get() throws ApiException {
    return getApi().getCallbackConfiguration(uriUUID);
  }

  public CallbackConfigurationResponse update(CallbackConfigurationUpdateRequest parameters)
      throws ApiException {

    return getApi().updateCallbackConfiguration(uriUUID, parameters);
  }
}
