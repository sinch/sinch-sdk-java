package com.sinch.sample.sms.inbounds;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.models.Inbound;
import java.io.IOException;
import java.util.logging.Logger;

public class Get extends BaseApplication {
  private static final Logger LOGGER =
      Logger.getLogger(com.sinch.sample.sms.deliveryReports.Get.class.getName());

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

    String inboundId = "foo id";
    LOGGER.info("Get for: " + inboundId);

    Inbound<?> response = client.sms().inbounds().get(inboundId);

    LOGGER.info("Response :" + response);
  }
}
