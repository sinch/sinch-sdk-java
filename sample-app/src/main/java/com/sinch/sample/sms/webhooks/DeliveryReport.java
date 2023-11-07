package com.sinch.sample.sms.webhooks;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.models.webhooks.BaseDeliveryReport;
import java.io.IOException;
import java.util.logging.Logger;

public class DeliveryReport extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(DeliveryReport.class.getName());

  public DeliveryReport() throws IOException {}

  public static void main(String[] args) {
    try {
      new DeliveryReport().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    String payload =
        "{\n"
            + "  \"type\": \"delivery_report_sms\",\n"
            + "  \"batch_id\": \"01FC66621XXXXX119Z8PMV1QPQ\",\n"
            + "  \"statuses\": [\n"
            + "    {\n"
            + "      \"code\": 0,\n"
            + "      \"count\": 1,\n"
            + "      \"recipients\": [\n"
            + "        \"44231235674\"\n"
            + "      ],\n"
            + "      \"status\": \"Delivered\"\n"
            + "    }\n"
            + "  ],\n"
            + "  \"total_message_count\": 1\n"
            + "}";
    LOGGER.info("Convert payload" + payload);

    BaseDeliveryReport value = client.sms().webHooks().deliveryReport(payload);

    LOGGER.info("Conversion result: " + value);
  }
}
