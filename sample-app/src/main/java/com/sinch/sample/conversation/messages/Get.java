package com.sinch.sample.conversation.messages;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.MessagesService;
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

    MessagesService service = client.conversation().v1().messages();

    LOGGER.info("Get message");

    var result = service.get(conversationMessageId);

    LOGGER.info("Response: " + result);
  }
}
