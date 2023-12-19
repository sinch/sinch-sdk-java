package com.sinch.sample.voice.applications;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.models.E164PhoneNumber;
import java.io.IOException;
import java.util.logging.Logger;

public class UnassignNumber extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(UnassignNumber.class.getName());

  public UnassignNumber() throws IOException {}

  public static void main(String[] args) {
    try {
      new UnassignNumber().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info(
        "Un-assign number '%s' from application '%s'".formatted(phoneNumber, applicationKey));

    client
        .voice()
        .applications()
        .unassignNumber(E164PhoneNumber.valueOf(phoneNumber), applicationKey);
  }
}
