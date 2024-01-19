package com.sinch.sdk.domains.voice.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.voice.adapters.converters.WebhooksEventDtoConverter;
import com.sinch.sdk.domains.voice.models.dto.v1.WebhooksEventDto;
import com.sinch.sdk.domains.voice.models.webhooks.CallEvent;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

public class WebHooksService implements com.sinch.sdk.domains.voice.WebHooksService {
  private static final Logger LOGGER = Logger.getLogger(WebHooksService.class.getName());

  private final Map<String, AuthManager> authManagers;

  public WebHooksService(Map<String, AuthManager> authManagers) {
    this.authManagers = authManagers;
  }

  public boolean validateAuthenticatedRequest(
      String method, String path, Map<String, String> headers, String jsonPayload) {

    // convert header keys to use case-insensitive map keys
    Map<String, String> caseInsensitiveHeaders = new TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    caseInsensitiveHeaders.putAll(headers);

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
  public CallEvent unserializeWebhooksEvent(String jsonPayload) throws ApiMappingException {
    try {
      WebhooksEventDto o = Mapper.getInstance().readValue(jsonPayload, WebhooksEventDto.class);
      return WebhooksEventDtoConverter.convert(o);
    } catch (JsonProcessingException e) {
      throw new ApiMappingException(jsonPayload, e);
    }
  }
}
