package com.sinch.sample.sms.deliveryReports;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.models.DeliveryReportRecipient;
import java.io.IOException;
import java.util.logging.Logger;

public class GetForNumber extends BaseApplication {
  private static final Logger LOGGER = Logger.getLogger(Get.class.getName());

  public GetForNumber() throws IOException {}

  public static void main(String[] args) {
    try {
      new GetForNumber().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info("Get for: " + phoneNumber);

    DeliveryReportRecipient response =
        client.sms().deliveryReports().getForNumber(batchId, phoneNumber);

    LOGGER.info("Response :" + response);
  }
}
