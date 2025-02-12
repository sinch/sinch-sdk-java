package com.sinch.sample.sms.v1.inbounds;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.api.v1.InboundsService;
import com.sinch.sdk.domains.sms.models.v1.inbounds.InboundMessage;
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

    InboundsService service = client.sms().v1().inbounds();

    String inboundId = "01JFFMTMJ1AY6TAYEPDR4CYG3S";
    LOGGER.info("Get for: " + inboundId);

    InboundMessage response = service.get(inboundId);

    LOGGER.info("Response :" + response);
  }
}
