package com.sinch.sdk.domains.numbers.api.v1.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.numbers.models.v1.sinchevents.NumberSinchEvent;
import java.util.Map;

public class SinchEventsService implements com.sinch.sdk.domains.numbers.api.v1.SinchEventsService {
  private final SinchEventsAuthenticationValidation authenticationChecker;

  public SinchEventsService(SinchEventsAuthenticationValidation authenticationChecker) {
    this.authenticationChecker = authenticationChecker;
  }

  @Override
  public boolean validateAuthenticationHeader(
      String secret, Map<String, String> headers, String jsonPayload) {
    return authenticationChecker.validateAuthenticationHeader(secret, headers, jsonPayload);
  }

  @Override
  public NumberSinchEvent parseEvent(String jsonPayload) throws ApiMappingException {

    try {
      return Mapper.getInstance().readValue(jsonPayload, NumberSinchEvent.class);
    } catch (JsonProcessingException e) {
      throw new ApiMappingException(jsonPayload, e);
    }
  }
}
