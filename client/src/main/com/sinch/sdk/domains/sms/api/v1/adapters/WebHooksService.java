package com.sinch.sdk.domains.sms.api.v1.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.auth.HmacAuthenticationValidation;
import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.sms.models.v1.webhooks.SmsEvent;
import java.util.Map;

public class WebHooksService implements com.sinch.sdk.domains.sms.api.v1.WebHooksService {

  private final HmacAuthenticationValidation authenticationChecker;

  public WebHooksService(HmacAuthenticationValidation authenticationChecker) {
    this.authenticationChecker = authenticationChecker;
  }

  public SmsEvent parseEvent(String jsonPayload) throws ApiMappingException {

    try {
      return Mapper.getInstance().readValue(jsonPayload, SmsEvent.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  public boolean validateAuthenticationHeader(
      String secret, Map<String, String> headers, String jsonPayload) {

    return authenticationChecker.validateAuthenticationHeader(secret, headers, jsonPayload);
  }
}
