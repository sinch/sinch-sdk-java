package com.sinch.sample.sms.batches;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.models.requests.BatchesListRequestParameters;
import java.io.IOException;
import java.util.logging.Logger;

public class List extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(List.class.getName());

  public List() throws IOException {}

  public static void main(String[] args) {
    try {
      new List().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info("List batches");

    LOGGER.info("Response:");
    client
        .sms()
        .batches()
        .list(
            BatchesListRequestParameters.builder()
                // .setFrom(phoneNumber)
                // .setPage(15)
                .setPageSize(2)
                // .setClientReference("a client reference")
                // .setStartDate(Instant.now())
                .build())
        .autoPageIter()
        .forEachRemaining(f -> LOGGER.info(f.toString()));
  }
}
