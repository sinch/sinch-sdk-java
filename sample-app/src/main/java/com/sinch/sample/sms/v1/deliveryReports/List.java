package com.sinch.sample.sms.v1.deliveryReports;

import com.sinch.sample.BaseApplication;
import com.sinch.sdk.domains.sms.api.v1.DeliveryReportsService;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.DeliveryReceiptErrorCode;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.DeliveryStatus;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.request.ListDeliveryReportsQueryParameters;
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

    DeliveryReportsService service = client.sms().v1().deliveryReports();

    LOGGER.info("List Delivery Reports");

    LOGGER.info("Response:");
    service
        .list(
            ListDeliveryReportsQueryParameters.builder()
                .setStatus(Arrays.asList(DeliveryStatus.CANCELLED, DeliveryStatus.FAILED))
                .setCode(
                    Arrays.asList(
                        DeliveryReceiptErrorCode.from(0), DeliveryReceiptErrorCode.DISPATCHED))
                .build())
        .iterator()
        .forEachRemaining(f -> LOGGER.info(f.toString()));
  }
}
