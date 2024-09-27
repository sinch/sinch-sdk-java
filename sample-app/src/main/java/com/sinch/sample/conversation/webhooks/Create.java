package com.sinch.sample.conversation.webhooks;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.WebHooksService;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.Webhook;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.WebhookTrigger;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

public class Create extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Create.class.getName());

  public Create() throws IOException {}

  public static void main(String[] args) {
    try {
      new Create().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    WebHooksService service = client.conversation().v1().webhooks();

    Webhook webhookRequest =
        Webhook.builder()
            .setAppId(conversationAppId)
            .setTarget("https://foo.com/url25")
            .setTriggers(Arrays.asList(WebhookTrigger.CAPABILITY))
            .build();

    LOGGER.info("Create webhook: " + webhookRequest);

    Webhook response = service.create(webhookRequest);

    LOGGER.info("Response: " + response);
  }
}
