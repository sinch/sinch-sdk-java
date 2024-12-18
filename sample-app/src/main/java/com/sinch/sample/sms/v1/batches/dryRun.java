package com.sinch.sample.sms.v1.batches;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.api.v1.BatchesService;
import com.sinch.sdk.domains.sms.models.v1.batches.request.DryRunQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.batches.request.TextRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.response.DryRunResponse;
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

    BatchesService service = client.sms().v1().batches();
    LOGGER.info("DryRun Request");

    DryRunQueryParameters queryParameters =
        DryRunQueryParameters.builder().setPerRecipient(true).setNumberOfRecipients(3).build();

    DryRunResponse value =
        service.dryRun(
            queryParameters,
            TextRequest.builder()
                .setTo(Collections.singletonList(phoneNumber))
                .setBody("the body")
                .build());

    LOGGER.info("Response: " + value);
  }
}
