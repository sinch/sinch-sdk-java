package com.sinch.sample.conversation.events;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.EventsService;
import com.sinch.sdk.domains.conversation.models.v1.events.ConversationEvent;
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

    EventsService service = client.conversation().v1().events();

    LOGGER.info("Get event: " + conversationEventId);

    ConversationEvent result = service.get(conversationEventId);

    LOGGER.info("Response: " + result);
  }
}
