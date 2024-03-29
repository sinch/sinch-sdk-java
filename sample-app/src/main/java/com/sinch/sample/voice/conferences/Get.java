package com.sinch.sample.voice.conferences;

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

    LOGGER.info("Get conference info for conference '%s'".formatted(conferenceId));

    var response = client.voice().conferences().get(conferenceId);

    LOGGER.info("Response: " + response);
  }
}
