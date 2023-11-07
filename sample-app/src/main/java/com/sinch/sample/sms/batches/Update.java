package com.sinch.sample.sms.batches;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.models.BatchText;
import com.sinch.sdk.domains.sms.models.requests.UpdateSmsBatchTextRequest;
import java.io.IOException;
import java.util.Collections;
import java.util.logging.Logger;

public class Update extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(Update.class.getName());

  public Update() throws IOException {}

  public static void main(String[] args) {
    try {
      new Update().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info("Updating batch: " + batchId);
    BatchText value =
        client
            .sms()
            .batches()
            .update(
                batchId,
                UpdateSmsBatchTextRequest.builder()
                    .setToRemove(Collections.singletonList("+33745149803"))
                    .setToAdd(Collections.singletonList("+33745149803"))
                    .setBody("the body updated")
                    .setFrom("+33123456789")
                    .build());

    LOGGER.info("Response: " + value);
  }
}
