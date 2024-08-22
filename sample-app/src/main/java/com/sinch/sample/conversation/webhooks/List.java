package com.sinch.sample.conversation.webhooks;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.WebHooksService;
import java.io.IOException;
import java.util.logging.Logger;

public class List extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(List.class.getName());

  public List() throws IOException {}

  public static void main(String[] args) {
    try {
      new List().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    WebHooksService service = client.conversation().v1().webhooks();

    LOGGER.info("List");

    var result = service.list(conversationAppId);

    LOGGER.info("Response: ");
    result.iterator().forEachRemaining(f -> LOGGER.info(String.format("- %s: %s", f.getId(), f)));
  }
}
