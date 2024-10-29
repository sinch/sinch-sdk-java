package com.sinch.sdk.domains.voice.adapters;

import com.sinch.sdk.domains.voice.adapters.converters.CalloutsDtoConverter;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParameters;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersConference;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersCustom;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersTTS;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestConference;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestCustom;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestTTS;

public class CalloutsService implements com.sinch.sdk.domains.voice.CalloutsService {

  private final com.sinch.sdk.domains.voice.api.v1.CalloutsService v1;

  public CalloutsService(com.sinch.sdk.domains.voice.api.v1.CalloutsService v1) {
    this.v1 = v1;
  }

  public String textToSpeech(CalloutRequestParametersTTS parameters) {

    return v1.textToSpeech((CalloutRequestTTS) CalloutsDtoConverter.convert(parameters));
  }

  public String conference(CalloutRequestParametersConference parameters) {

    return v1.conference((CalloutRequestConference) CalloutsDtoConverter.convert(parameters));
  }

  public String custom(CalloutRequestParametersCustom parameters) {

    return v1.custom((CalloutRequestCustom) CalloutsDtoConverter.convert(parameters));
  }

  public String call(CalloutRequestParameters parameters) {

    return v1.call(CalloutsDtoConverter.convert(parameters));
  }
}
