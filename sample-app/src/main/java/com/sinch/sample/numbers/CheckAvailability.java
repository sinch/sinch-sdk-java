package com.sinch.sample.numbers.available;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.numbers.api.v1.NumbersService;
import com.sinch.sdk.domains.numbers.models.v1.available.response.AvailableNumber;
import java.io.IOException;
import java.util.logging.Logger;

public class CheckAvailability extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(CheckAvailability.class.getName());

  public CheckAvailability() throws IOException {}

  public static void main(String[] args) {
    try {
      new CheckAvailability().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    NumbersService service = client.numbers().v1();

    LOGGER.info("CheckAvailability for: " + virtualPhoneNumber);

    AvailableNumber value = service.checkAvailability(virtualPhoneNumber);

    LOGGER.info("Response: " + value);
  }
}
