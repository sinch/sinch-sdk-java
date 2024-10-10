package com.sinch.sdk.domains.voice.api.v1.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.utils.MapUtils;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.voice.models.v1.svaml.SvamlControl;
import com.sinch.sdk.domains.voice.models.v1.webhooks.VoiceWebhookEvent;
import com.sinch.sdk.domains.voice.models.v1.webhooks.internal.WebhooksEventInternalImpl;
import java.util.Map;
import java.util.logging.Logger;

public class WebHooksService implements com.sinch.sdk.domains.voice.api.v1.WebHooksService {
  private static final Logger LOGGER = Logger.getLogger(WebHooksService.class.getName());

  private final Map<String, AuthManager> authManagers;

  public WebHooksService(Map<String, AuthManager> authManagers) {
    this.authManagers = authManagers;
  }

  public boolean validateAuthenticationHeader(
      String method, String path, Map<String, String> headers, String jsonPayload) {

    // convert header keys to use case-insensitive map keys
    Map<String, String> caseInsensitiveHeaders = MapUtils.getCaseInsensitiveMap(headers);

    String authorizationHeader = caseInsensitiveHeaders.get("Authorization");

    // no authorization required
    if (null == authorizationHeader) {
      return true;
    }

    String[] split = authorizationHeader.split(" ");
    String authorizationKeyword = split.length > 0 ? split[0] : "";

    AuthManager authManager = authManagers.get(authorizationKeyword);
    if (null == authManager) {
      // unknown auth manager
      LOGGER.severe(
          String.format("Auth manager for authorization '%s' not found", authorizationKeyword));
      return false;
    }
    return authManager.validateAuthenticatedRequest(method, path, headers, jsonPayload);
  }

  @Override
  public VoiceWebhookEvent parseEvent(String jsonPayload) throws ApiMappingException {
    try {
      WebhooksEventInternalImpl o =
          Mapper.getInstance().readValue(jsonPayload, WebhooksEventInternalImpl.class);
      return (VoiceWebhookEvent) o.getActualInstance();
    } catch (JsonProcessingException e) {
      throw new ApiMappingException(jsonPayload, e);
    }
  }

  @Override
  public String serializeResponse(SvamlControl response) throws ApiMappingException {
    try {
      return Mapper.getInstance().writeValueAsString(response);
    } catch (JsonProcessingException e) {
      throw new ApiMappingException(response.toString(), e);
    }
  }
}
