package com.sinch.sample.numbers.active;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.numbers.api.v1.NumbersService;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
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

    NumbersService service = client.numbers().v1();

    LOGGER.info("Release for: " + virtualPhoneNumber);

    ActiveNumber value = service.release(virtualPhoneNumber);

    LOGGER.info("Response: " + value);
  }
}
