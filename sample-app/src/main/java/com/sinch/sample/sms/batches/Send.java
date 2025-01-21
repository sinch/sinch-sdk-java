package com.sinch.sample.sms.batches;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.sms.models.BatchText;
import com.sinch.sdk.domains.sms.models.DeliveryReportType;
import com.sinch.sdk.domains.sms.models.Parameters;
import com.sinch.sdk.domains.sms.models.requests.SendSmsBatchTextRequest;
import java.io.IOException;
import java.util.Arrays;
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
            .setBody("the body ${code}")
            .setClientReference("a client reference")
            .setFrom("+33123456789")
            .setParameters(
                new Parameters(
                    Arrays.asList(
                        new Parameters.Entry("name", new Pair<>("+12017777777", "John"), "there"),
                        new Parameters.Entry("name", new Pair<>("+12018888888", "Paul")),
                        new Parameters.Entry(
                            "code", new Pair<>(phoneNumber, "HALLOWEEN20 \uD83C\uDF83")))))
            .setDeliveryReport(DeliveryReportType.FULL);

    // Overload default dashboard webhooks URL if defined
    webhooksSmsPath.ifPresent(builder::setCallbackUrl);

    BatchText value = client.sms().batches().send(builder.build());

    LOGGER.info("Response: " + value);
  }
}
