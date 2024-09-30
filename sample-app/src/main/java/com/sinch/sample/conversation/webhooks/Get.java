package com.sinch.sample.conversation.webhooks;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.WebHooksService;
import com.sinch.sdk.domains.conversation.models.v1.webhooks.Webhook;
import java.io.IOException;
import java.util.logging.Logger;

public class Get extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Get.class.getName());

  public Get() throws IOException {}

  public static void main(String[] args) {
    try {
      new Get().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    WebHooksService service = client.conversation().v1().webhooks();

    LOGGER.info("GET webhook Id");

    Webhook response = service.get(conversationWebhookId);

    LOGGER.info("Response: " + response);
  }
}
