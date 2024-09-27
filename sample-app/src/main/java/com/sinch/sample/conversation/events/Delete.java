package com.sinch.sample.conversation.events;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.EventsService;
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

    EventsService service = client.conversation().v1().events();

    LOGGER.info("Deleting event: " + conversationEventId);

    service.delete(conversationEventId);

    LOGGER.info("Done");
  }
}
