package com.sinch.sdk.domains.conversation.api.v1.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.auth.HmacAuthenticationValidation;
import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.ConversationSinchEvent;
import com.sinch.sdk.domains.conversation.models.v1.sinchevents.internal.ConversationSinchEventInternalImpl;
import java.util.Map;

public class SinchEventsService
    implements com.sinch.sdk.domains.conversation.api.v1.SinchEventsService {

  private final HmacAuthenticationValidation authenticationChecker;

  public SinchEventsService(HmacAuthenticationValidation authenticationChecker) {
    this.authenticationChecker = authenticationChecker;
  }

  @Override
  public boolean validateAuthenticationHeader(
      String secret, Map<String, String> headers, String jsonPayload) {

    return authenticationChecker.validateAuthenticationHeader(secret, headers, jsonPayload);
  }

  @Override
  public ConversationSinchEvent parseEvent(String jsonPayload) throws ApiMappingException {
    try {
      ConversationSinchEventInternalImpl dto =
          Mapper.getInstance().readValue(jsonPayload, ConversationSinchEventInternalImpl.class);
      return (ConversationSinchEvent) dto.getActualInstance();
    } catch (JsonProcessingException e) {
      throw new ApiMappingException(jsonPayload, e);
    }
  }
}
