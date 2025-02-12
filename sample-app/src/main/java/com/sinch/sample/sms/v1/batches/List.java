package com.sinch.sample.sms.v1.batches;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.api.v1.BatchesService;
import com.sinch.sdk.domains.sms.models.v1.batches.request.ListBatchesQueryParameters;
import java.io.IOException;
import java.time.Instant;
import java.time.Period;
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

    BatchesService service = client.sms().v1().batches();
    LOGGER.info("List batches");

    LOGGER.info("Response:");
    service
        .list(
            ListBatchesQueryParameters.builder()
                // .setFrom(phoneNumber)
                // .setPage(15)
                .setPageSize(2)
                // .setClientReference("a client reference")
                .setStartDate(Instant.now().minus(Period.ofWeeks(3)))
                .build())
        .iterator()
        .forEachRemaining(f -> LOGGER.info(f.toString()));
  }
}
