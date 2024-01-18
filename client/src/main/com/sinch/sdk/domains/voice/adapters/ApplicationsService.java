package com.sinch.sdk.domains.voice.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.voice.adapters.api.v1.ApplicationsApi;
import com.sinch.sdk.domains.voice.adapters.converters.ApplicationsDtoConverter;
import com.sinch.sdk.domains.voice.models.CallbackUrls;
import com.sinch.sdk.domains.voice.models.NumberInformation;
import com.sinch.sdk.domains.voice.models.requests.ApplicationsUpdateNumbersRequestParameters;
import com.sinch.sdk.domains.voice.models.response.AssignedNumbers;
import com.sinch.sdk.models.Configuration;
import com.sinch.sdk.models.E164PhoneNumber;
import java.util.Map;

public class ApplicationsService implements com.sinch.sdk.domains.voice.ApplicationsService {

  private final ApplicationsApi api;

  public ApplicationsService(
      Configuration configuration, HttpClient httpClient, Map<String, AuthManager> authManagers) {
    this.api =
        new ApplicationsApi(
            httpClient,
            configuration.getVoiceApplicationManagementServer(),
            authManagers,
            new HttpMapper());
  }

  protected ApplicationsApi getApi() {
    return this.api;
  }

  public AssignedNumbers getNumbers() {

    return ApplicationsDtoConverter.convert(getApi().configurationGetNumbers());
  }

  public CallbackUrls getCallbackUrls(String applicationKey) {

    return ApplicationsDtoConverter.convert(getApi().configurationGetCallbackURLs(applicationKey));
  }

  public void updateCallbackUrls(String applicationKey, CallbackUrls parameters) {
    getApi()
        .configurationUpdateCallbackURLs(
            applicationKey, ApplicationsDtoConverter.convert(parameters));
  }

  public NumberInformation queryNumber(E164PhoneNumber number) {
    return ApplicationsDtoConverter.convert(getApi().callingQueryNumber(number.stringValue()));
  }

  public void updateNumbers(ApplicationsUpdateNumbersRequestParameters parameters) {
    getApi().configurationUpdateNumbers(ApplicationsDtoConverter.convert(parameters));
  }

  public void unassignNumber(E164PhoneNumber phoneNumber, String applicationKey) {

    getApi()
        .configurationUnassignNumber(ApplicationsDtoConverter.convert(phoneNumber, applicationKey));
  }
}
