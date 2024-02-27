package com.sinch.sample.sms.batches;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.models.BatchText;
import com.sinch.sdk.domains.sms.models.DeliveryReportType;
import com.sinch.sdk.domains.sms.models.requests.SendSmsBatchTextRequest;
import java.io.IOException;
import java.util.Collections;
import java.util.logging.Logger;

public class Send extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(Send.class.getName());

  public Send() throws IOException {}

  public static void main(String[] args) {
    try {
      new Send().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info("Send Text to " + phoneNumber);

    SendSmsBatchTextRequest.Builder builder =
        SendSmsBatchTextRequest.builder()
            .setTo(Collections.singletonList(phoneNumber))
            .setBody("the body")
            .setClientReference("a client reference")
            .setFrom("+33123456789")
            .setDeliveryReport(DeliveryReportType.FULL);

    // Overload default dashboard webhooks URL if defined
    if (null != webhooksSmsPath) {
      builder.setCallbackUrl(webhooksSmsPath);
    }

    BatchText value = client.sms().batches().send(builder.build());

    LOGGER.info("Response: " + value);
  }
}
