package com.sinch.sdk.domains.sms.models.v1.deliveryreports;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import java.util.Collections;
import org.junit.jupiter.api.Test;

@TestWithResources
public class BatchDeliveryReportDtoTest extends BaseTest {

  @GivenJsonResource("/domains/sms/v1/deliveryreports/BatchDeliveryReportSMSDto.json")
  BatchDeliveryReport deliveryReportBatchSMSDto;

  @GivenJsonResource("/domains/sms/v1/deliveryreports/BatchDeliveryReportMMSDto.json")
  BatchDeliveryReport deliveryReportBatchMMSDto;

  public static BatchDeliveryReportSMS deliveryReportBatchSMS =
      BatchDeliveryReportSMS.builder()
          .setBatchId("01FC66621XXXXX119Z8PMV1QPQ")
          .setStatuses(
              Collections.singletonList(
                  MessageDeliveryStatus.builder()
                      .setCode(DeliveryReceiptStatusCode.from(0))
                      .setCount(1)
                      .setRecipients(Collections.singleton("44231235674"))
                      .setStatus(DeliveryStatus.DELIVERED)
                      .build()))
          .setTotalMessageCount(1)
          .setClientReference("a client reference")
          .build();

  public static BatchDeliveryReportMMS deliveryReportBatchMMS =
      BatchDeliveryReportMMS.builder()
          .setBatchId("01FC66621XXXXX119Z8PMV1QPQ")
          .setStatuses(
              Collections.singletonList(
                  MessageDeliveryStatus.builder()
                      .setCode(DeliveryReceiptStatusCode.from(0))
                      .setCount(1)
                      .setRecipients(Collections.singleton("44231235674"))
                      .setStatus(DeliveryStatus.DELIVERED)
                      .build()))
          .setTotalMessageCount(1)
          .setClientReference("a client reference")
          .build();

  @Test
  void deserializeBatchDeliveryReportSMS() {
    TestHelpers.recursiveEquals(deliveryReportBatchSMS, deliveryReportBatchSMSDto);
  }

  @Test
  void deserializeBatchDeliveryReportMMS() {
    TestHelpers.recursiveEquals(deliveryReportBatchMMS, deliveryReportBatchMMSDto);
  }
}
