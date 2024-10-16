package com.sinch.sdk.domains.voice.adapters;

import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.domains.voice.adapters.converters.ControlDtoConverter;
import com.sinch.sdk.domains.voice.adapters.converters.WebhooksEventDtoConverter;
import com.sinch.sdk.domains.voice.models.svaml.SVAMLControl;
import com.sinch.sdk.domains.voice.models.webhooks.WebhooksEvent;
import java.util.Map;

public class WebHooksService implements com.sinch.sdk.domains.voice.WebHooksService {

  private final com.sinch.sdk.domains.voice.api.v1.WebHooksService v1;

  public WebHooksService(com.sinch.sdk.domains.voice.api.v1.WebHooksService v1) {
    this.v1 = v1;
  }

  public boolean validateAuthenticatedRequest(
      String method, String path, Map<String, String> headers, String jsonPayload) {

    return v1.validateAuthenticationHeader(method, path, headers, jsonPayload);
  }

  @Override
  public WebhooksEvent unserializeWebhooksEvent(String jsonPayload) throws ApiMappingException {
    return WebhooksEventDtoConverter.convert(v1.parseEvent(jsonPayload));
  }

  @Override
  public String serializeWebhooksResponse(SVAMLControl response) throws ApiMappingException {
    return v1.serializeResponse(ControlDtoConverter.convertControl(response));
  }
}
