package com.sinch.sample.sms.batches;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.models.Batch;
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

    LOGGER.info("Get for :" + batchId);

    Batch<?> value = client.sms().batches().get(batchId);

    LOGGER.info("Response :" + value);
  }
}
