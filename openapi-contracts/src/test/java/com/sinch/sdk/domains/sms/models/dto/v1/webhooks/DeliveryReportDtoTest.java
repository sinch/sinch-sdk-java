package com.sinch.sdk.domains.sms.models.dto.v1.webhooks;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.sms.models.webhooks.DeliveryReportMMS;
import com.sinch.sdk.domains.sms.models.webhooks.DeliveryReportSMS;
import com.sinch.sdk.domains.sms.models.webhooks.DeliveryReportStatusDetails;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class DeliveryReportDtoTest extends BaseTest {

  @GivenJsonResource("/domains/sms/v1/webhooks/DeliveryReportSMS.json")
  DeliveryReportSMS deliveryReportSMSClient;

  @GivenJsonResource("/domains/sms/v1/webhooks/DeliveryReportMMS.json")
  DeliveryReportMMS deliveryReportMMSClient;

  public static DeliveryReportSMS deliveryReportSMS =
      new DeliveryReportSMS(
          "01FC66621XXXXX119Z8PMV1QPQ",
          null,
          Collections.singletonList(
              new DeliveryReportStatusDetails(
                  0, 1, Collections.singletonList("44231235674"), "Delivered")),
          1);

  public static DeliveryReportMMS deliveryReportMMS =
      new DeliveryReportMMS(
          "01FC66621XXXXX119Z8PMV1QPQ",
          null,
          Collections.singletonList(
              new DeliveryReportStatusDetails(
                  0, 1, Collections.singletonList("44231235674"), "Delivered")),
          1);

  @Test
  void deserializeDeliveryReportRecipientSMS() {
    Assertions.assertThat(deliveryReportSMS)
        .usingRecursiveComparison()
        .isEqualTo(deliveryReportSMSClient);
  }

  @Test
  void deserializeDeliveryReportRecipientMMS() {
    Assertions.assertThat(deliveryReportMMS)
        .usingRecursiveComparison()
        .isEqualTo(deliveryReportMMSClient);
  }
}
