package com.sinch.sdk.domains.conversation.api.v1.adapters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.sinch.sdk.auth.HmacAuthenticationValidation;
import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.core.utils.databind.Mapper;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.Webhook;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.ConversationWebhookEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.internal.ConversationEventInternalImpl;
import java.util.Collection;
import java.util.Map;

public class WebHooksCallbackService
    implements com.sinch.sdk.domains.conversation.api.v1.WebHooksService {

  private final HmacAuthenticationValidation authenticationChecker;

  public WebHooksCallbackService(HmacAuthenticationValidation authenticationChecker) {
    this.authenticationChecker = authenticationChecker;
  }

  public Collection<Webhook> list(String appId) {
    throw new UnsupportedOperationException();
  }

  public Webhook get(String webhookId) {
    throw new UnsupportedOperationException();
  }

  public Webhook create(Webhook _webhook) {
    throw new UnsupportedOperationException();
  }

  public Webhook update(String webhookId, Webhook _webhook) {
    throw new UnsupportedOperationException();
  }

  public void delete(String webhookId) {
    throw new UnsupportedOperationException();
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
