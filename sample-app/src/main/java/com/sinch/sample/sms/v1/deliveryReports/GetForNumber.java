package com.sinch.sample.sms.v1.deliveryReports;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.api.v1.DeliveryReportsService;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.RecipientDeliveryReport;
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

    DeliveryReportsService service = client.sms().v1().deliveryReports();

    LOGGER.info("Get for: " + phoneNumber);

    RecipientDeliveryReport response = service.getForNumber(batchId, phoneNumber);

    LOGGER.info("Response :" + response);
  }
}
