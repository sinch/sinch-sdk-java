package com.sinch.sdk.domains.voice.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.voice.adapters.api.v1.CallsApi;
import com.sinch.sdk.domains.voice.adapters.converters.CallsDtoConverter;
import com.sinch.sdk.domains.voice.models.CallLegType;
import com.sinch.sdk.domains.voice.models.response.CallInformation;
import com.sinch.sdk.domains.voice.models.svaml.SVAMLControl;
import com.sinch.sdk.models.VoiceContext;
import java.util.Map;

public class CallsService implements com.sinch.sdk.domains.voice.CallsService {

  private final CallsApi api;

  public CallsService(
      VoiceContext context, HttpClient httpClient, Map<String, AuthManager> authManagers) {
    this.api = new CallsApi(httpClient, context.getVoiceServer(), authManagers, new HttpMapper());
  }

  protected CallsApi getApi() {
    return this.api;
  }

  public CallInformation get(String callId) {

    return CallsDtoConverter.convert(getApi().callingGetCallResult(callId));
  }

  public void update(String callId, SVAMLControl parameters) {
    getApi().callingUpdateCall(callId, CallsDtoConverter.convert(parameters));
  }

  public void manageWithCallLeg(String callId, CallLegType callLeg, SVAMLControl parameters) {
    getApi()
        .callingManageCallWithCallLeg(
            callId, callLeg.value(), CallsDtoConverter.convert(parameters));
  }
}
