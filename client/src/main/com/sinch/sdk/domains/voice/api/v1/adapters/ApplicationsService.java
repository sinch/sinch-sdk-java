package com.sinch.sdk.domains.voice.api.v1.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.voice.api.v1.internal.ApplicationsApi;
import com.sinch.sdk.domains.voice.models.v1.applications.Callbacks;
import com.sinch.sdk.domains.voice.models.v1.applications.request.UnAssignNumberRequest;
import com.sinch.sdk.domains.voice.models.v1.applications.request.UpdateNumbersRequest;
import com.sinch.sdk.domains.voice.models.v1.applications.response.OwnedNumbersResponse;
import com.sinch.sdk.domains.voice.models.v1.applications.response.QueryNumberResponse;
import com.sinch.sdk.models.VoiceContext;
import java.util.Map;

public class ApplicationsService implements com.sinch.sdk.domains.voice.api.v1.ApplicationsService {

  private final ApplicationsApi api;

  public ApplicationsService(
      VoiceContext context, HttpClient httpClient, Map<String, AuthManager> authManagers) {
    this.api =
        new ApplicationsApi(
            httpClient,
            context.getVoiceApplicationManagementServer(),
            authManagers,
            HttpMapper.getInstance());
  }

  protected ApplicationsApi getApi() {
    return this.api;
  }

  public OwnedNumbersResponse listNumbers() {
    return getApi().configurationGetNumbers();
  }

  public Callbacks getCallbackUrls(String applicationKey) {
    return getApi().configurationGetCallbackURLs(applicationKey);
  }

  public void updateCallbackUrls(String applicationKey, Callbacks parameters) {

    getApi().configurationUpdateCallbackURLs(applicationKey, parameters);
  }

  public QueryNumberResponse queryNumber(String number) {
    return getApi().callingQueryNumber(number);
  }

  public void assignNumbers(UpdateNumbersRequest parameters) {
    getApi().configurationUpdateNumbers(parameters);
  }

  public void unassignNumber(UnAssignNumberRequest parameters) {
    getApi().configurationUnassignNumber(parameters);
  }
}
