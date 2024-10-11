package com.sinch.sample.voice.conferences;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.voice.api.v1.ConferencesService;
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

    ConferencesService service = client.voice().v1().conferences();

    LOGGER.info("Get conference info for conference '%s'".formatted(conferenceId));

    var response = service.get(conferenceId);

    LOGGER.info("Response: " + response);
  }
}
