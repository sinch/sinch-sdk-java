package com.sinch.sample.sms.v1.batches;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.api.v1.BatchesService;
import com.sinch.sdk.domains.sms.models.v1.batches.request.UpdateTextRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.response.Batch;
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

    BatchesService service = client.sms().v1().batches();

    LOGGER.info("Updating batch: " + batchId);

    UpdateTextRequest.Builder builder =
        UpdateTextRequest.builder()
            .setToRemove(Collections.singletonList("+33745149803"))
            .setToAdd(Collections.singletonList("+33745149803"))
            .setBody("the body updated")
            .setFrom("+33123456789");

    webhooksSmsPath.ifPresent(builder::setCallbackUrl);

    Batch value = service.update(batchId, builder.build());

    LOGGER.info("Response: " + value);
  }
}
