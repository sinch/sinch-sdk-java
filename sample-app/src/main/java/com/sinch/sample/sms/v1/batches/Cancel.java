package com.sinch.sample.sms.v1.batches;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.api.v1.BatchesService;
import com.sinch.sdk.domains.sms.models.v1.batches.response.Batch;
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

    BatchesService service = client.sms().v1().batches();

    LOGGER.info("Cancelling batch: " + batchId);
    Batch value = service.cancel(batchId);

    LOGGER.info("Response: " + value);
  }
}
