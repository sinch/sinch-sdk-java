package com.sinch.sdk.domains.voice.api.v1.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.utils.MapUtils;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.voice.models.v1.sinchevents.VoiceSinchEvent;
import com.sinch.sdk.domains.voice.models.v1.sinchevents.internal.SinchEventInternalImpl;
import com.sinch.sdk.domains.voice.models.v1.svaml.SvamlControl;
import java.util.Map;
import java.util.logging.Logger;

public class SinchEventsService implements com.sinch.sdk.domains.voice.api.v1.SinchEventsService {
  private static final Logger LOGGER = Logger.getLogger(SinchEventsService.class.getName());

  private final Map<String, AuthManager> authManagers;

  public SinchEventsService(Map<String, AuthManager> authManagers) {
    this.authManagers = authManagers;
  }

  public boolean validateAuthenticationHeader(
      String method, String path, Map<String, String> headers, String jsonPayload) {

    // convert header keys to use case-insensitive map keys
    Map<String, String> caseInsensitiveHeaders = MapUtils.getCaseInsensitiveMap(headers);

    String authorizationHeader = caseInsensitiveHeaders.get("Authorization");

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
  public VoiceSinchEvent parseEvent(String jsonPayload) throws ApiMappingException {
    try {
      SinchEventInternalImpl o =
          Mapper.getInstance().readValue(jsonPayload, SinchEventInternalImpl.class);
      return (VoiceSinchEvent) o.getActualInstance();
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
