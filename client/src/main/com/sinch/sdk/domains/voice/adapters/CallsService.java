package com.sinch.sdk.domains.voice.adapters;

import com.sinch.sdk.domains.voice.adapters.converters.CallsDtoConverter;
import com.sinch.sdk.domains.voice.adapters.converters.ControlDtoConverter;
import com.sinch.sdk.domains.voice.models.CallLegType;
import com.sinch.sdk.domains.voice.models.response.CallInformation;
import com.sinch.sdk.domains.voice.models.svaml.SVAMLControl;
import com.sinch.sdk.domains.voice.models.v1.calls.request.CallLeg;

public class CallsService implements com.sinch.sdk.domains.voice.CallsService {

  private final com.sinch.sdk.domains.voice.api.v1.CallsService v1;

  public CallsService(com.sinch.sdk.domains.voice.api.v1.CallsService v1) {
    this.v1 = v1;
  }

  public CallInformation get(String callId) {
    return CallsDtoConverter.convert(v1.get(callId));
  }

  public void update(String callId, SVAMLControl parameters) {
    v1.update(callId, ControlDtoConverter.convertControl(parameters));
  }

  public void manageWithCallLeg(String callId, CallLegType callLeg, SVAMLControl parameters) {
    v1.manageWithCallLeg(
        callId, CallLeg.from(callLeg.value()), ControlDtoConverter.convertControl(parameters));
  }
}
