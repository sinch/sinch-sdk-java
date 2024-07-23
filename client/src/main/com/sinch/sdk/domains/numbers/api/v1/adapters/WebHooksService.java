package com.sinch.sdk.domains.numbers.api.v1.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.numbers.models.v1.webhooks.NumberEvent;
import java.util.Map;

public class WebHooksService implements com.sinch.sdk.domains.numbers.api.v1.WebHooksService {
  private final NumbersWebhooksAuthenticationValidation authenticationChecker;

  public WebHooksService(NumbersWebhooksAuthenticationValidation authenticationChecker) {
    this.authenticationChecker = authenticationChecker;
  }

  public boolean validateAuthenticationHeader(
      String secret, Map<String, String> headers, String jsonPayload) {
    return authenticationChecker.validateAuthenticationHeader(secret, headers, jsonPayload);
  }

  @Override
  public NumberEvent parseEvent(String jsonPayload) throws ApiMappingException {

    try {
      return Mapper.getInstance().readValue(jsonPayload, NumberEvent.class);
    } catch (JsonProcessingException e) {
      throw new ApiMappingException(jsonPayload, e);
    }
  }
}
