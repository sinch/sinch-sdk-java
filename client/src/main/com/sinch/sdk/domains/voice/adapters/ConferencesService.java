package com.sinch.sdk.domains.voice.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.voice.adapters.api.v1.ConferencesApi;
import com.sinch.sdk.domains.voice.adapters.converters.CalloutsDtoConverter;
import com.sinch.sdk.domains.voice.adapters.converters.ConferencesDtoConverter;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersConference;
import com.sinch.sdk.domains.voice.models.requests.ConferenceManageParticipantRequestParameters;
import com.sinch.sdk.domains.voice.models.response.ConferenceParticipant;
import com.sinch.sdk.models.VoiceContext;
import java.util.Collection;
import java.util.Map;

public class ConferencesService implements com.sinch.sdk.domains.voice.ConferencesService {

  private final ConferencesApi api;

  public ConferencesService(
      VoiceContext context, HttpClient httpClient, Map<String, AuthManager> authManagers) {
    this.api =
        new ConferencesApi(httpClient, context.getVoiceServer(), authManagers, new HttpMapper());
  }

  protected ConferencesApi getApi() {
    return this.api;
  }

  public String call(CalloutRequestParametersConference parameters) {
    return CalloutsDtoConverter.convert(
        getApi().callouts(CalloutsDtoConverter.convert(parameters)));
  }

  public Collection<ConferenceParticipant> get(String conferenceId) {
    return ConferencesDtoConverter.convert(getApi().callingGetConferenceInfo(conferenceId));
  }

  public void kickAll(String conferenceId) {
    getApi().callingKickConferenceAll(conferenceId);
  }

  public void kickParticipant(String conferenceId, String callId) {
    getApi().callingKickConferenceParticipant(callId, conferenceId);
  }

  public void manageParticipant(
      String conferenceId, String callId, ConferenceManageParticipantRequestParameters parameters) {
    getApi()
        .callingManageConferenceParticipant(
            callId, conferenceId, ConferencesDtoConverter.convert(parameters));
  }
}
