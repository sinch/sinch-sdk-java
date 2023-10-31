package com.sinch.sample.numbers.available;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.numbers.models.AvailableNumber;
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

    LOGGER.info("Get for :" + phoneNumber);

    AvailableNumber value = client.numbers().available().get(phoneNumber);

    LOGGER.info("Response :" + value);
  }
}
