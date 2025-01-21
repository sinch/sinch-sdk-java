package com.sinch.sdk.domains.sms.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class DeliveryReportBatchDtoTest extends BaseTest {

  @GivenJsonResource("/domains/sms/v1/deliveryreports/BatchDeliveryReportSMSDto.json")
  DeliveryReportDto deliveryReportBatchSMSDto;

  @GivenJsonResource("/domains/sms/v1/deliveryreports/BatchDeliveryReportMMSDto.json")
  DeliveryReportDto deliveryReportBatchMMSDto;

  public static DeliveryReportDto deliveryReportBatchSMS =
      new DeliveryReportDto("01FC66621XXXXX119Z8PMV1QPQ")
          .type("delivery_report_sms")
          .statuses(
              Collections.singletonList(
                  new MessageDeliveryStatusDto()
                      .code(0)
                      .count(1)
                      .addRecipientsItem("44231235674")
                      .status("Delivered")))
          .totalMessageCount(1)
          .clientReference("a client reference");

  public static DeliveryReportDto deliveryReportBatchMMS =
      new DeliveryReportDto("01FC66621XXXXX119Z8PMV1QPQ")
          .type("delivery_report_mms")
          .statuses(
              Collections.singletonList(
                  new MessageDeliveryStatusDto()
                      .code(0)
                      .count(1)
                      .addRecipientsItem("44231235674")
                      .status("Delivered")))
          .totalMessageCount(1)
          .clientReference("a client reference");

  @Test
  void deserializeDeliveryReportBatchSMS() {
    Assertions.assertThat(deliveryReportBatchSMS)
        .usingRecursiveComparison()
        .isEqualTo(deliveryReportBatchSMSDto);
  }

  @Test
  void deserializeDeliveryReportBatchMMS() {
    Assertions.assertThat(deliveryReportBatchMMS)
        .usingRecursiveComparison()
        .isEqualTo(deliveryReportBatchMMSDto);
  }
}
