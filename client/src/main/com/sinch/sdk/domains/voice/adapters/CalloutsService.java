package com.sinch.sdk.domains.voice.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.voice.adapters.api.v1.CalloutsApi;
import com.sinch.sdk.domains.voice.adapters.converters.CalloutsDtoConverter;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParameters;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersConference;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersCustom;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersTTS;
import com.sinch.sdk.models.Configuration;
import java.util.Map;

public class CalloutsService implements com.sinch.sdk.domains.voice.CalloutsService {

  private final CalloutsApi api;

  public CalloutsService(
      Configuration configuration, HttpClient httpClient, Map<String, AuthManager> authManagers) {
    this.api =
        new CalloutsApi(httpClient, configuration.getVoiceServer(), authManagers, new HttpMapper());
  }

  protected CalloutsApi getApi() {
    return this.api;
  }

  public String textToSpeech(CalloutRequestParametersTTS parameters) {

    return call(parameters);
  }

  public String conference(CalloutRequestParametersConference parameters) {

    return call(parameters);
  }

  public String custom(CalloutRequestParametersCustom parameters) {

    return call(parameters);
  }

  public String call(CalloutRequestParameters parameters) {

    return CalloutsDtoConverter.convert(
        getApi().callouts(CalloutsDtoConverter.convert(parameters)));
  }
}
