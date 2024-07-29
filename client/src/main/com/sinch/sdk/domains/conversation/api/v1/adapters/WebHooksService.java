package com.sinch.sdk.domains.conversation.api.v1.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.ConversationWebhookEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.internal.ConversationEventInternalImpl;
import java.util.Map;

public class WebHooksService implements com.sinch.sdk.domains.conversation.api.v1.WebHooksService {

  private final ConversationWebhooksAuthenticationValidation authenticationChecker;

  public WebHooksService(ConversationWebhooksAuthenticationValidation authenticationChecker) {
    this.authenticationChecker = authenticationChecker;
  }

  public boolean validateAuthenticationHeader(
      String secret, Map<String, String> headers, String jsonPayload) {

    return authenticationChecker.validateAuthenticationHeader(secret, headers, jsonPayload);
  }

  @Override
  public ConversationWebhookEvent parseEvent(String jsonPayload) throws ApiMappingException {
    try {
      ConversationEventInternalImpl dto =
          Mapper.getInstance().readValue(jsonPayload, ConversationEventInternalImpl.class);
      return (ConversationWebhookEvent) dto.getActualInstance();
    } catch (JsonProcessingException e) {
      throw new ApiMappingException(jsonPayload, e);
    }
  }
}
