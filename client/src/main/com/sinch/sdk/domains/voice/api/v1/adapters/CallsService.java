package com.sinch.sdk.domains.voice.api.v1.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.voice.api.v1.adapters.mapper.CallInformationMapper;
import com.sinch.sdk.domains.voice.api.v1.internal.CallsApi;
import com.sinch.sdk.domains.voice.models.v1.calls.request.CallLeg;
import com.sinch.sdk.domains.voice.models.v1.calls.response.CallInformation;
import com.sinch.sdk.domains.voice.models.v1.svaml.SvamlControl;
import com.sinch.sdk.models.VoiceContext;
import java.util.Map;

public class CallsService implements com.sinch.sdk.domains.voice.api.v1.CallsService {

  private final CallsApi api;

  static {
    LocalLazyInit.init();
  }

  public CallsService(
      VoiceContext context, HttpClient httpClient, Map<String, AuthManager> authManagers) {
    this.api = new CallsApi(httpClient, context.getVoiceServer(), authManagers, new HttpMapper());
  }

  protected CallsApi getApi() {
    return this.api;
  }

  public CallInformation get(String callId) {
    return getApi().callingGetCallResult(callId);
  }

  public void update(String callId, SvamlControl parameters) {
    getApi().callingUpdateCall(callId, parameters);
  }

  public void manageWithCallLeg(String callId, CallLeg callLeg, SvamlControl parameters) {
    getApi().callingManageCallWithCallLeg(callId, callLeg.value(), parameters);
  }

  public static final class LocalLazyInit {

    private LocalLazyInit() {
      CallInformationMapper.initMapper();
    }

    public static CallsService.LocalLazyInit init() {
      return CallsService.LocalLazyInit.LazyHolder.INSTANCE;
    }

    private static class LazyHolder {

      public static final CallsService.LocalLazyInit INSTANCE = new LocalLazyInit();
    }
  }
}
