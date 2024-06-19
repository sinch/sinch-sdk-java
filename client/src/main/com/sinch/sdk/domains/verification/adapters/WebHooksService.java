package com.sinch.sdk.domains.verification.adapters;

import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.domains.verification.adapters.converters.WebHooksDtoConverter;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationEvent;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationResponse;
import java.util.Map;
import java.util.logging.Logger;

public class WebHooksService implements com.sinch.sdk.domains.verification.WebHooksService {

  private static final Logger LOGGER = Logger.getLogger(WebHooksService.class.getName());

  private final com.sinch.sdk.domains.verification.api.v1.WebHooksService v1;

  public WebHooksService(com.sinch.sdk.domains.verification.api.v1.WebHooksService v1) {
    this.v1 = v1;
  }

  public boolean validateAuthenticationHeader(
      String method, String path, Map<String, String> headers, String jsonPayload) {

    return v1.validateAuthenticationHeader(method, path, headers, jsonPayload);
  }

  @Override
  public VerificationEvent parseEvent(String jsonPayload) throws ApiMappingException {

    com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationEvent dto =
        v1.parseEvent(jsonPayload);

    return WebHooksDtoConverter.convert(dto);
  }

  @Override
  public String serializeResponse(VerificationResponse response) throws ApiMappingException {
    return v1.serializeResponse(WebHooksDtoConverter.convert(response));
  }
}
