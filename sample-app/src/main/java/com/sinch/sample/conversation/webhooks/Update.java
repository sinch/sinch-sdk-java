package com.sinch.sample.conversation.webhooks;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.WebHooksService;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.Webhook;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.WebhookTargetType;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.WebhookTrigger;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

public class Update extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Update.class.getName());

  public Update() throws IOException {}

  public static void main(String[] args) {
    try {
      new Update().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    WebHooksService service = client.conversation().v1().webhooks();

    LOGGER.info("Current webhook: " + service.get(conversationWebhookId));

    Webhook webhookRequest =
        Webhook.builder()
            .setAppId(conversationAppId)
            .setTarget("https://foo.com/url4")
            .setTriggers(Arrays.asList(WebhookTrigger.CAPABILITY, WebhookTrigger.CHANNEL_EVENT))
            .setTargetType(WebhookTargetType.HTTP)
            .build();
    LOGGER.info("Update request: " + webhookRequest);

    Webhook response = service.update(conversationWebhookId, webhookRequest);

    LOGGER.info("Response: " + response);
  }
}
