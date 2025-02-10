package com.sinch.sdk.domains.conversation.api.v1.adapters;

import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.conversation.api.v1.internal.WebhooksApi;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.Webhook;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.WebhookImpl;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.events.ConversationWebhookEvent;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.internal.CreateWebhookRequestInternal;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.response.ListWebhooksResponse;
import com.sinch.sdk.models.ConversationContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class WebHooksApiService
    implements com.sinch.sdk.domains.conversation.api.v1.WebHooksService {

  private final String uriUUID;
  private final WebhooksApi api;

  public WebHooksApiService(
      String uriUUID,
      ConversationContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers) {
    this.uriUUID = uriUUID;
    this.api = new WebhooksApi(httpClient, context.getServer(), authManagers, new HttpMapper());
  }

  protected WebhooksApi getApi() {
    return this.api;
  }

  public Collection<Webhook> list(String appId) {

    ListWebhooksResponse response = getApi().webhooksListWebhooks(uriUUID, appId);

    if (null == response) {
      return Collections.emptyList();
    }
    return response.getWebhooks();
  }

  public Webhook get(String webhookId) {
    return getApi().webhooksGetWebhook(uriUUID, webhookId);
  }

  public Webhook create(Webhook _webhook) {

    WebhookImpl webhook = (WebhookImpl) _webhook;
    CreateWebhookRequestInternal.Builder builder = CreateWebhookRequestInternal.builder();

    webhook.appId().ifPresent(builder::setAppId);
    webhook.clientCredentials().ifPresent(builder::setClientCredentials);
    webhook.secret().ifPresent(builder::setSecret);
    webhook.target().ifPresent(builder::setTarget);
    webhook.targetType().ifPresent(builder::setTargetType);
    webhook.triggers().ifPresent(builder::setTriggers);

    return getApi().webhooksCreateWebhook(uriUUID, builder.build());
  }

  public Webhook update(String webhookId, Webhook _webhook) {

    List<String> mask = new ArrayList<>();

    WebhookImpl webhook = (WebhookImpl) _webhook;
    webhook.appId().ifPresent(_unused -> mask.add(WebhookImpl.JSON_PROPERTY_APP_ID));
    webhook
        .clientCredentials()
        .ifPresent(_unused -> mask.add(WebhookImpl.JSON_PROPERTY_CLIENT_CREDENTIALS));
    webhook.target().ifPresent(_unused -> mask.add(WebhookImpl.JSON_PROPERTY_TARGET));
    webhook.targetType().ifPresent(_unused -> mask.add(WebhookImpl.JSON_PROPERTY_TARGET_TYPE));
    webhook.triggers().ifPresent(_unused -> mask.add(WebhookImpl.JSON_PROPERTY_TRIGGERS));
    webhook.secret().ifPresent(_unused -> mask.add(WebhookImpl.JSON_PROPERTY_SECRET));

    return getApi().webhooksUpdateWebhook(uriUUID, webhookId, _webhook, mask);
  }

  public void delete(String webhookId) {
    getApi().webhooksDeleteWebhook(uriUUID, webhookId);
  }

  public boolean validateAuthenticationHeader(
      String secret, Map<String, String> headers, String jsonPayload) {
    throw new UnsupportedOperationException();
  }

  @Override
  public ConversationWebhookEvent parseEvent(String jsonPayload) throws ApiMappingException {
    throw new UnsupportedOperationException();
  }
}
