package com.sinch.sample.conversation.application;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.AppService;
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

    AppService service = client.conversation().v1().app();

    LOGGER.info("Delete conversation App: " + conversationAppId);

    service.delete(conversationAppId);
  }
}
