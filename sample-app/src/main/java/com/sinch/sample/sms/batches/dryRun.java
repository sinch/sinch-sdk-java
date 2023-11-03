package com.sinch.sample.sms.batches;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.models.DryRun;
import com.sinch.sdk.domains.sms.models.requests.SendSmsBatchTextRequest;
import java.io.IOException;
import java.util.Collections;
import java.util.logging.Logger;

public class dryRun extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(dryRun.class.getName());

  public dryRun() throws IOException {}

  public static void main(String[] args) {
    try {
      new dryRun().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info("DryRun TextRequest");

    DryRun value =
        client
            .sms()
            .batches()
            .dryRun(
                true,
                3,
                SendSmsBatchTextRequest.builder()
                    .setTo(Collections.singletonList("+foo number"))
                    .setBody("the body")
                    .build());

    LOGGER.info("Response :" + value);
  }
}
