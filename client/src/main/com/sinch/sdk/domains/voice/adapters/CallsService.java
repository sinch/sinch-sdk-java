package com.sinch.sdk.domains.voice.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.voice.adapters.api.v1.CallsApi;
import com.sinch.sdk.domains.voice.adapters.converters.CallsDtoConverter;
import com.sinch.sdk.domains.voice.models.CallLegType;
import com.sinch.sdk.domains.voice.models.requests.CallUpdateRequestParameters;
import com.sinch.sdk.domains.voice.models.response.CallInformation;
import com.sinch.sdk.models.Configuration;
import java.util.Map;

public class CallsService implements com.sinch.sdk.domains.voice.CallsService {

  private final CallsApi api;

  public CallsService(
      Configuration configuration, HttpClient httpClient, Map<String, AuthManager> authManagers) {
    this.api =
        new CallsApi(httpClient, configuration.getVoiceServer(), authManagers, new HttpMapper());
  }

  protected CallsApi getApi() {
    return this.api;
  }

  public CallInformation get(String callId) {

    return CallsDtoConverter.convert(getApi().callingGetCallResult(callId));
  }

  public void update(String callId, CallUpdateRequestParameters parameters) {
    getApi().callingUpdateCall(callId, CallsDtoConverter.convert(parameters));
  }

  public void manageWithCallLeg(
      String callId, CallLegType callLeg, CallUpdateRequestParameters parameters) {
    getApi()
        .callingManageCallWithCallLeg(
            callId, callLeg.value(), CallsDtoConverter.convert(parameters));
  }
}
