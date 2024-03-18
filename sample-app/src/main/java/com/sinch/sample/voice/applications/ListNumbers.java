package com.sinch.sample.voice.applications;

import com.sinch.sample.BaseApplication;
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

    LOGGER.info("Get assigned numbers");

    var response = client.voice().applications().listNumbers();

    LOGGER.info("Response: " + response);
  }
}
