package com.sinch.sdk.domains.voice.api.v1.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.voice.api.v1.internal.ConferencesApi;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestConference;
import com.sinch.sdk.domains.voice.models.v1.conferences.request.ManageConferenceParticipant;
import com.sinch.sdk.domains.voice.models.v1.conferences.response.GetConferenceInfoResponse;
import com.sinch.sdk.models.VoiceContext;
import java.util.Map;

public class ConferencesService implements com.sinch.sdk.domains.voice.api.v1.ConferencesService {

  private final ConferencesApi api;
  private final CalloutsService calloutsService;

  public ConferencesService(
      VoiceContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers,
      CalloutsService calloutsService) {
    this.api =
        new ConferencesApi(httpClient, context.getVoiceServer(), authManagers, new HttpMapper());
    this.calloutsService = calloutsService;
  }

  protected ConferencesApi getApi() {
    return this.api;
  }

  public String call(CalloutRequestConference parameters) {
    return calloutsService.conference(parameters);
  }

  public GetConferenceInfoResponse get(String conferenceId) {
    return getApi().callingGetConferenceInfo(conferenceId);
  }

  public void kickAll(String conferenceId) {
    getApi().callingKickConferenceAll(conferenceId);
  }

  public void kickParticipant(String conferenceId, String callId) {
    getApi().callingKickConferenceParticipant(callId, conferenceId);
  }

  public void manageParticipant(
      String conferenceId, String callId, ManageConferenceParticipant parameters) {
    getApi().callingManageConferenceParticipant(callId, conferenceId, parameters);
  }
}
