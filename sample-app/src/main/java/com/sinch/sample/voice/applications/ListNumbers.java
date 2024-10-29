package com.sinch.sample.voice.applications;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.voice.api.v1.ApplicationsService;
import java.io.IOException;
import java.util.logging.Logger;

public class ListNumbers extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(ListNumbers.class.getName());

  public ListNumbers() throws IOException {}

  public static void main(String[] args) {
    try {
      new ListNumbers().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    ApplicationsService service = client.voice().v1().applications();

    LOGGER.info("Get assigned numbers");

    var response = service.listNumbers();

    LOGGER.info("Response: " + response);
  }
}
