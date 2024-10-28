package com.sinch.sdk.domains.voice.adapters;

import com.sinch.sdk.domains.voice.adapters.converters.ApplicationsDtoConverter;
import com.sinch.sdk.domains.voice.models.CallbackUrls;
import com.sinch.sdk.domains.voice.models.NumberInformation;
import com.sinch.sdk.domains.voice.models.requests.ApplicationsAssignNumbersRequestParameters;
import com.sinch.sdk.domains.voice.models.response.AssignedNumbers;
import com.sinch.sdk.models.E164PhoneNumber;

public class ApplicationsService implements com.sinch.sdk.domains.voice.ApplicationsService {

  private final com.sinch.sdk.domains.voice.api.v1.ApplicationsService v1;

  public ApplicationsService(com.sinch.sdk.domains.voice.api.v1.ApplicationsService v1) {
    this.v1 = v1;
  }

  public AssignedNumbers listNumbers() {
    return ApplicationsDtoConverter.convert(v1.listNumbers());
  }

  public CallbackUrls getCallbackUrls(String applicationKey) {
    return ApplicationsDtoConverter.convert(v1.getCallbackUrls(applicationKey));
  }

  public void updateCallbackUrls(String applicationKey, CallbackUrls parameters) {
    v1.updateCallbackUrls(applicationKey, ApplicationsDtoConverter.convert(parameters));
  }

  public NumberInformation queryNumber(E164PhoneNumber number) {
    return ApplicationsDtoConverter.convert(v1.queryNumber(number.stringValue()));
  }

  public void assignNumbers(ApplicationsAssignNumbersRequestParameters parameters) {
    v1.assignNumbers(ApplicationsDtoConverter.convert(parameters));
  }

  public void unassignNumber(E164PhoneNumber phoneNumber, String applicationKey) {
    v1.unassignNumber(ApplicationsDtoConverter.convert(phoneNumber, applicationKey));
  }
}
