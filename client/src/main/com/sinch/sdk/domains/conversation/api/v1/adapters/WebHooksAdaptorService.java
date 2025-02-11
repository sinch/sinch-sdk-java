package com.sinch.sdk.domains.conversation.api.v1.adapters;

import com.sinch.sdk.auth.HmacAuthenticationValidation;
import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.Webhook;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.ConversationWebhookEvent;
import com.sinch.sdk.models.ConversationContext;
import java.util.Collection;
import java.util.Map;
import java.util.function.Supplier;

public class WebHooksAdaptorService
    implements com.sinch.sdk.domains.conversation.api.v1.WebHooksService {

  private final Runnable instanceLazyInit;
  private final Supplier<Map<String, AuthManager>> authManagersSupplier;
  private final String uriUUID;
  private final ConversationContext context;
  private final Supplier<HttpClient> httpClientSupplier;
  private volatile WebHooksApiService apiService;
  private volatile WebHooksCallbackService callbackService;

  public WebHooksAdaptorService(
      String uriUUID,
      ConversationContext context,
      Runnable instanceLazyInit,
      Supplier<HttpClient> httpClientSupplier,
      Supplier<Map<String, AuthManager>> authManagersSupplier) {
    this.uriUUID = uriUUID;
    this.context = context;
    this.instanceLazyInit = instanceLazyInit;
    this.httpClientSupplier = httpClientSupplier;
    this.authManagersSupplier = authManagersSupplier;
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

    if (null == this.apiService) {
      instanceLazyInit.run();
      this.apiService =
          new WebHooksApiService(
              uriUUID, context, httpClientSupplier.get(), authManagersSupplier.get());
    }
    return getApiService();
  }

  protected WebHooksApiService getApiService() {
    return this.apiService;
  }

  WebHooksCallbackService activateCallbackApiService() {

    if (null == this.callbackService) {
      this.callbackService = new WebHooksCallbackService(new HmacAuthenticationValidation());
    }
    return callbackService;
  }

  public boolean validateAuthenticationHeader(
      String secret, Map<String, String> headers, String jsonPayload) {
    return activateCallbackApiService().validateAuthenticationHeader(secret, headers, jsonPayload);
  }

  @Override
  public ConversationWebhookEvent parseEvent(String jsonPayload) throws ApiMappingException {
    return activateCallbackApiService().parseEvent(jsonPayload);
  }
}
