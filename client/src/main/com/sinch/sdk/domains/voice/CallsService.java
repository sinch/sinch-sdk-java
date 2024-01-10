package com.sinch.sdk.domains.voice;

import com.sinch.sdk.domains.voice.models.requests.CallUpdateRequestParameters;
import com.sinch.sdk.domains.voice.models.response.CallInformation;

public interface CallsService {

  CallInformation get(String callId);

  void update(String callId, CallUpdateRequestParameters parameters);

  // void manageWithCallLeg(String conferenceId, String callId);
}
