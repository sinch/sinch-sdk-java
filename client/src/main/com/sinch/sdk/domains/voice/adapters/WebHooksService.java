package com.sinch.sdk.domains.voice.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.utils.MapUtils;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.voice.adapters.converters.CallsDtoConverter;
import com.sinch.sdk.domains.voice.adapters.converters.WebhooksEventDtoConverter;
import com.sinch.sdk.domains.voice.models.dto.v1.SVAMLRequestBodyDto;
import com.sinch.sdk.domains.voice.models.dto.v1.WebhooksEventDto;
import com.sinch.sdk.domains.voice.models.svaml.SVAMLControl;
import com.sinch.sdk.domains.voice.models.webhooks.WebhooksEvent;
import java.util.Map;
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
  public WebhooksEvent unserializeWebhooksEvent(String jsonPayload) throws ApiMappingException {
    try {
      WebhooksEventDto o = Mapper.getInstance().readValue(jsonPayload, WebhooksEventDto.class);
      return WebhooksEventDtoConverter.convert(o);
    } catch (JsonProcessingException e) {
      throw new ApiMappingException(jsonPayload, e);
    }
  }

  @Override
  public String serializeWebhooksResponse(SVAMLControl response) throws ApiMappingException {
    SVAMLRequestBodyDto dto = CallsDtoConverter.convert(response);
    try {
      return Mapper.getInstance().writeValueAsString(dto);
    } catch (JsonProcessingException e) {
      throw new ApiMappingException(response.toString(), e);
    }
  }
}
