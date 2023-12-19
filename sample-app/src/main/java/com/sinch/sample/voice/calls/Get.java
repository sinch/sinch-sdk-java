package com.sinch.sample.voice.calls;

import com.sinch.sample.BaseApplication;
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

    LOGGER.info("Getting call information for '%s'".formatted(callId));

    var response = client.voice().calls().get(callId);

    LOGGER.info("Response: " + response);
  }
}
