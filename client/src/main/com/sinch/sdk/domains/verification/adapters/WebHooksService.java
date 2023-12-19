package com.sinch.sdk.domains.verification.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationEvent;
import com.sinch.sdk.domains.verification.models.webhooks.VerificationResponse;
import java.util.Map;
import java.util.TreeMap;
import java.util.logging.Logger;

public class WebHooksService implements com.sinch.sdk.domains.verification.WebHooksService {

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
  public VerificationEvent unserializeVerificationEvent(String jsonPayload)
      throws ApiMappingException {
    try {
      return Mapper.getInstance().readValue(jsonPayload, VerificationEvent.class);
    } catch (JsonProcessingException e) {
      throw new ApiMappingException(jsonPayload, e);
    }
  }

  @Override
  public String serializeVerificationResponse(VerificationResponse response)
      throws ApiMappingException {
    try {
      return Mapper.getInstance().writeValueAsString(response);
    } catch (JsonProcessingException e) {
      throw new ApiMappingException(response.toString(), e);
    }
  }
}
