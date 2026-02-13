package com.sinch.sdk.domains.verification.api.v1.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.utils.MapUtils;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationEvent;
import com.sinch.sdk.domains.verification.models.v1.webhooks.VerificationRequestEventResponse;
import com.sinch.sdk.domains.verification.models.v1.webhooks.internal.VerificationEventInternalImpl;
import java.util.Map;
import java.util.logging.Logger;

public class WebhooksService implements com.sinch.sdk.domains.verification.api.v1.WebhooksService {

  private static final Logger LOGGER = Logger.getLogger(WebhooksService.class.getName());

  private final Map<String, AuthManager> authManagers;

  public WebhooksService(Map<String, AuthManager> authManagers) {
    this.authManagers = authManagers;
  }

  @Override
  public boolean validateAuthenticationHeader(
      String method, String path, Map<String, String> headers, String jsonPayload) {

    // convert header keys to use case-insensitive map keys
    String authorizationHeader = MapUtils.getCaseInsensitiveMap(headers).get("Authorization");

    // no authorization required
    if (StringUtil.isEmpty(authorizationHeader)) {
      return false;
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
  public VerificationEvent parseEvent(String jsonPayload) throws ApiMappingException {
    try {
      VerificationEventInternalImpl dto =
          Mapper.getInstance().readValue(jsonPayload, VerificationEventInternalImpl.class);
      return (VerificationEvent) dto.getActualInstance();
    } catch (JsonProcessingException e) {
      throw new ApiMappingException(jsonPayload, e);
    }
  }

  @Override
  public String serializeResponse(VerificationRequestEventResponse response)
      throws ApiMappingException {
    try {
      return Mapper.getInstance().writeValueAsString(response);
    } catch (JsonProcessingException e) {
      throw new ApiMappingException(response.toString(), e);
    }
  }
}
