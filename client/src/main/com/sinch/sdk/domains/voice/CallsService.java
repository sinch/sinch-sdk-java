package com.sinch.sdk.domains.voice;

import com.sinch.sdk.domains.voice.models.response.CallInformation;

public interface CallsService {

  // void update(String callId);

  CallInformation get(String callId);

  // void manageWithCallLeg(String conferenceId, String callId);
}
