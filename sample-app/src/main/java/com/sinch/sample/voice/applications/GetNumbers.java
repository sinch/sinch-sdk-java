package com.sinch.sample.voice.applications;

import com.sinch.sample.BaseApplication;
import java.io.IOException;
import java.util.logging.Logger;

public class GetNumbers extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(GetNumbers.class.getName());

  public GetNumbers() throws IOException {}

  public static void main(String[] args) {
    try {
      new GetNumbers().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info("Get assigned numbers");

    var response = client.voice().applications().getNumbers();

    LOGGER.info("Response: " + response);
  }
}
