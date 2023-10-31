package com.sinch.sample.numbers.callback;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.numbers.models.CallbackConfiguration;
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

    LOGGER.info("Get");

    CallbackConfiguration value = client.numbers().callback().get();

    LOGGER.info("Response :" + value);
  }
}
