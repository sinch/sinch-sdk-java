package com.sinch.sdk.domains.sms.models.dto.v1.webhooks;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.sms.models.dto.v1.DeliveryReportDto;
import com.sinch.sdk.domains.sms.models.dto.v1.MessageDeliveryStatusDto;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class DeliveryReportDtoTest extends BaseTest {

  @GivenJsonResource("/domains/sms/v1/webhooks/DeliveryReportSMS.json")
  DeliveryReportDto deliveryReportSMSClient;

  @GivenJsonResource("/domains/sms/v1/webhooks/DeliveryReportMMS.json")
  DeliveryReportDto deliveryReportMMSClient;

  public static DeliveryReportDto deliveryReportSMS =
      new DeliveryReportDto("01FC66621XXXXX119Z8PMV1QPQ")
          .type("delivery_report_sms")
          .statuses(
              Collections.singletonList(
                  new MessageDeliveryStatusDto()
                      .code(0)
                      .count(1)
                      .addRecipientsItem("44231235674")
                      .status("Delivered")))
          .totalMessageCount(1);

  public static DeliveryReportDto deliveryReportMMS =
      new DeliveryReportDto("01FC66621XXXXX119Z8PMV1QPQ")
          .type("delivery_report_mms")
          .statuses(
              Collections.singletonList(
                  new MessageDeliveryStatusDto()
                      .code(0)
                      .count(1)
                      .addRecipientsItem("44231235674")
                      .status("Delivered")))
          .totalMessageCount(1);

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
