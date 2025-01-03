package com.sinch.sample.sms.v1.batches;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.api.v1.BatchesService;
import com.sinch.sdk.domains.sms.models.v1.batches.request.SendDeliveryFeedbackRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

public class SendDeliveryFeedback extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(SendDeliveryFeedback.class.getName());

  public SendDeliveryFeedback() throws IOException {}

  public static void main(String[] args) {
    try {
      new SendDeliveryFeedback().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    BatchesService service = client.sms().v1().batches();

    LOGGER.info("Send Delivery Feedback for batch ID:" + batchId);

    SendDeliveryFeedbackRequest request =
        SendDeliveryFeedbackRequest.builder().setRecipients(Arrays.asList(phoneNumber)).build();
    service.sendDeliveryFeedback(batchId, request);
    LOGGER.info("Done");
  }
}
