package com.sinch.sdk.domains.conversation.api.v1.adapters;

import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.Webhook;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.ConversationWebhookEvent;
import java.util.Collection;
import java.util.Map;

public class WebHooksAdaptorService
    implements com.sinch.sdk.domains.conversation.api.v1.WebHooksService {

  private final WebHooksApiService apiService;
  private final WebHooksCallbackService callbackService;
  private final Runnable credentialValidation;

  public WebHooksAdaptorService(
      Runnable credentialValidation,
      WebHooksApiService apiService,
      WebHooksCallbackService callbackService) {
    this.credentialValidation = credentialValidation;
    this.apiService = apiService;
    this.callbackService = callbackService;
  }

  public Collection<Webhook> list(String appId) {
    return activateApiService().list(appId);
  }

  public Webhook get(String webhookId) {
    return activateApiService().get(webhookId);
  }

  public Webhook create(Webhook _webhook) {
    return activateApiService().create(_webhook);
  }

  public Webhook update(String webhookId, Webhook _webhook) {
    return activateApiService().update(webhookId, _webhook);
  }

  public void delete(String webhookId) {
    activateApiService().delete(webhookId);
  }

  WebHooksApiService activateApiService() {
    validateCredentials();
    return apiService;
  }

  public boolean validateAuthenticationHeader(
      String secret, Map<String, String> headers, String jsonPayload) {
    return callbackService.validateAuthenticationHeader(secret, headers, jsonPayload);
  }

  @Override
  public ConversationWebhookEvent parseEvent(String jsonPayload) throws ApiMappingException {
    return callbackService.parseEvent(jsonPayload);
  }

  private void validateCredentials() {
    credentialValidation.run();
  }
}
