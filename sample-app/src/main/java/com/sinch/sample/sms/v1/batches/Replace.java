package com.sinch.sample.sms.v1.batches;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.api.v1.BatchesService;
import com.sinch.sdk.domains.sms.models.v1.batches.request.TextRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.response.Batch;
import java.io.IOException;
import java.util.Collections;
import java.util.logging.Logger;

public class Replace extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(Replace.class.getName());

  public Replace() throws IOException {}

  public static void main(String[] args) {
    try {
      new Replace().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    BatchesService service = client.sms().v1().batches();

    LOGGER.info("Replace batch" + batchId);
    Batch value =
        service.replace(
            batchId,
            TextRequest.builder()
                .setTo(Collections.singletonList("+33745149803"))
                .setBody("the body")
                .setClientReference("a client reference")
                .setFrom("+33123456789")
                .build());

    LOGGER.info("Response: " + value);
  }
}
