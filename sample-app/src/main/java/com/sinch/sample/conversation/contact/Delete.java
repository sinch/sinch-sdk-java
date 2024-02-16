package com.sinch.sample.conversation.contact;

import com.sinch.sample.BaseApplication;
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

    LOGGER.info("Delete conversation contact: " + conversationContactId);

    client.conversation().contact().delete(conversationContactId);
  }
}
