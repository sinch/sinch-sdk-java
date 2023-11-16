package com.sinch.sample.sms.batches;

import com.sinch.sample.BaseApplication;
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

    LOGGER.info("Send Delivery Feedback for batch ID:" + batchId);
    client
        .sms()
        .batches()
        .sendDeliveryFeedback(batchId, Arrays.asList("foo number 1", "foo number 2"));
    LOGGER.info("Done");
  }
}
