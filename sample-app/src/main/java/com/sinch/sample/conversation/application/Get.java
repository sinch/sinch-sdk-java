package com.sinch.sample.conversation.application;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.conversation.api.v1.AppService;
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

    AppService service = client.conversation().v1().app();

    LOGGER.info("Get conversation App details: " + conversationAppId);

    var result = service.get(conversationAppId);

    LOGGER.info("Response: " + result);
  }
}
