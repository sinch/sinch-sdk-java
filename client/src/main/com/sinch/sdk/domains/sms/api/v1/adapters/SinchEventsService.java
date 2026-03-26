package com.sinch.sdk.domains.sms.api.v1.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.auth.HmacAuthenticationValidation;
import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.sms.models.v1.sinchevents.SmsSinchEvent;
import java.util.Map;

public class SinchEventsService implements com.sinch.sdk.domains.sms.api.v1.SinchEventsService {

  private final HmacAuthenticationValidation authenticationChecker;

  public SinchEventsService(HmacAuthenticationValidation authenticationChecker) {
    this.authenticationChecker = authenticationChecker;
  }

  @Override
  public SmsSinchEvent parseEvent(String jsonPayload) throws ApiMappingException {

    try {
      return Mapper.getInstance().readValue(jsonPayload, SmsSinchEvent.class);
    } catch (JsonProcessingException e) {
      throw new ApiMappingException(jsonPayload, e);
    }
  }

  @Override
  public boolean validateAuthenticationHeader(
      String secret, Map<String, String> headers, String jsonPayload) {

    return authenticationChecker.validateAuthenticationHeader(secret, headers, jsonPayload);
  }
}
