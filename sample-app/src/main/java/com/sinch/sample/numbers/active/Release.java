package com.sinch.sample.numbers.active;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.numbers.models.ActiveNumber;
import java.io.IOException;
import java.util.logging.Logger;

public class Release extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(Release.class.getName());

  public Release() throws IOException {}

  public static void main(String[] args) {
    try {
      new Release().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info("Get for :" + phoneNumber);

    ActiveNumber value = client.numbers().active().release(phoneNumber);

    LOGGER.info("Response :" + value);
  }
}
