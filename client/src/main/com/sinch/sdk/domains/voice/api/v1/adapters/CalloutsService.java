package com.sinch.sdk.domains.voice.api.v1.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.voice.api.v1.adapters.mapper.CalloutRequestCustomMapper;
import com.sinch.sdk.domains.voice.api.v1.internal.CalloutsApi;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequest;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestConference;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestCustom;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestTTS;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.internal.CalloutRequestInternalImpl;
import com.sinch.sdk.domains.voice.models.v1.callouts.response.CalloutResponse;
import com.sinch.sdk.models.VoiceContext;
import java.util.Map;

public class CalloutsService implements com.sinch.sdk.domains.voice.api.v1.CalloutsService {

  private final CalloutsApi api;

  static {
    LocalLazyInit.init();
  }

  public CalloutsService(
      VoiceContext context, HttpClient httpClient, Map<String, AuthManager> authManagers) {
    this.api =
        new CalloutsApi(httpClient, context.getVoiceServer(), authManagers, new HttpMapper());
  }

  protected CalloutsApi getApi() {
    return this.api;
  }

  public String textToSpeech(CalloutRequestTTS parameters) {

    return call(parameters);
  }

  public String conference(CalloutRequestConference parameters) {

    return call(parameters);
  }

  public String custom(CalloutRequestCustom parameters) {

    return call(parameters);
  }

  public String call(CalloutRequest parameters) {

    CalloutRequestInternalImpl request = new CalloutRequestInternalImpl();
    request.setActualInstance(parameters);
    CalloutResponse response = getApi().callouts(request);
    if (null == response) {
      return null;
    }
    return response.getCallId();
  }

  public static final class LocalLazyInit {

    private LocalLazyInit() {
      CalloutRequestCustomMapper.initMapper();
    }

    public static LocalLazyInit init() {
      return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {

      public static final LocalLazyInit INSTANCE = new LocalLazyInit();
    }
  }
}
