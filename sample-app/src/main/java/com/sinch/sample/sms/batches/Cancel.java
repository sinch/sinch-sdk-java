package com.sinch.sample.sms.batches;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.models.BatchText;
import java.io.IOException;
import java.util.logging.Logger;

public class Cancel extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(Cancel.class.getName());

  public Cancel() throws IOException {}

  public static void main(String[] args) {
    try {
      new Cancel().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info("Cancelling batch: " + batchId);
    BatchText value = client.sms().batches().cancel(batchId);

    LOGGER.info("Response: " + value);
  }
}
