package com.sinch.sample.conversation.conversations;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.ConversationsService;
import com.sinch.sdk.domains.conversation.models.v1.conversation.Conversation;
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

    ConversationsService service = client.conversation().v1().conversations();

    LOGGER.info("Get conversation: " + conversationId);

    Conversation result = service.get(conversationId);

    LOGGER.info("Response: " + result);
  }
}
