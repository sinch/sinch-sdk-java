package com.sinch.sdk.domains.voice.adapters;

import com.sinch.sdk.domains.voice.adapters.converters.CalloutsDtoConverter;
import com.sinch.sdk.domains.voice.adapters.converters.ConferencesDtoConverter;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersConference;
import com.sinch.sdk.domains.voice.models.requests.ConferenceManageParticipantRequestParameters;
import com.sinch.sdk.domains.voice.models.response.ConferenceParticipant;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestConference;
import java.util.Collection;

public class ConferencesService implements com.sinch.sdk.domains.voice.ConferencesService {

  private final com.sinch.sdk.domains.voice.api.v1.ConferencesService v1;

  public ConferencesService(com.sinch.sdk.domains.voice.api.v1.ConferencesService v1) {
    this.v1 = v1;
  }

  public String call(CalloutRequestParametersConference parameters) {
    return v1.call((CalloutRequestConference) CalloutsDtoConverter.convert(parameters));
  }

  public Collection<ConferenceParticipant> get(String conferenceId) {
    return ConferencesDtoConverter.convert(v1.get(conferenceId));
  }

  public void kickAll(String conferenceId) {
    v1.kickAll(conferenceId);
  }

  public void kickParticipant(String conferenceId, String callId) {
    v1.kickParticipant(conferenceId, callId);
  }

  public void manageParticipant(
      String conferenceId, String callId, ConferenceManageParticipantRequestParameters parameters) {
    v1.manageParticipant(conferenceId, callId, ConferencesDtoConverter.convert(parameters));
  }
}
