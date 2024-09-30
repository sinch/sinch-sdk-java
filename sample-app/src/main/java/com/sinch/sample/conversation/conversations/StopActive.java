package com.sinch.sample.conversation.conversations;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.ConversationsService;
import java.io.IOException;
import java.util.logging.Logger;

public class StopActive extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(StopActive.class.getName());

  public StopActive() throws IOException {}

  public static void main(String[] args) {
    try {
      new StopActive().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    ConversationsService service = client.conversation().v1().conversations();

    LOGGER.info("Stop conversation: " + conversationId);

    service.stopActive(conversationId);
  }
}
