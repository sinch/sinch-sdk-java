package com.sinch.sample.conversation.webhooks;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.WebHooksService;
import java.io.IOException;
import java.util.logging.Logger;

public class Delete extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(Delete.class.getName());

  public Delete() throws IOException {}

  public static void main(String[] args) {
    try {
      new Delete().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    WebHooksService service = client.conversation().v1().webhooks();

    LOGGER.info("Deleting webhook: " + conversationWebhookId);

    service.delete(conversationWebhookId);

    LOGGER.info("Done");
  }
}
