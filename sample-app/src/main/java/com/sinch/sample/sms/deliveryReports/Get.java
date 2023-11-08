package com.sinch.sample.sms.deliveryReports;

import com.sinch.sample.BaseApplication;
import java.io.IOException;
import java.util.logging.Logger;

public class Get extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(Get.class.getName());

  public Get() throws IOException {}

  public static void main(String[] args) {
    try {
      new Get().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info("Get for :" + batchId);

    com.sinch.sdk.domains.sms.models.webhooks.DeliveryReport response =
        client.sms().deliveryReports().get(batchId, null, null, null);
    // DeliveryReport.FULL,
    // Arrays.asList(DeliveryReportStatus.ABORTED, DeliveryReportStatus.CANCELLED),
    // Arrays.asList(401, 402));

    LOGGER.info("Response :" + response);
  }
}
