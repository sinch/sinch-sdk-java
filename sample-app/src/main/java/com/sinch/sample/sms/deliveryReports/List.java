package com.sinch.sample.sms.deliveryReports;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.models.DeliveryReportErrorCode;
import com.sinch.sdk.domains.sms.models.requests.DeliveryReportListRequestParameters;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Logger;

public class List extends BaseApplication {

  private static final Logger LOGGER = Logger.getLogger(List.class.getName());

  public List() throws IOException {}

  public static void main(String[] args) {
    try {
      new List().run();
    } catch (Exception e) {
      LOGGER.severe(e.getMessage());
      e.printStackTrace();
    }
  }

  public void run() {

    LOGGER.info("List Delivery Reports");

    LOGGER.info("Response:");
    client
        .sms()
        .deliveryReports()
        .list(
            DeliveryReportListRequestParameters.builder()
                .setCodes(
                    Arrays.asList(
                        DeliveryReportErrorCode.from(0), DeliveryReportErrorCode.DISPATCHED))
                .build())
        .iterator()
        .forEachRemaining(f -> LOGGER.info(f.toString()));
  }
}
