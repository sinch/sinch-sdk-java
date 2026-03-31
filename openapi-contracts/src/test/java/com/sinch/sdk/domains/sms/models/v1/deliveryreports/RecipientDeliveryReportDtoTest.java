package com.sinch.sdk.domains.sms.models.v1.deliveryreports;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import java.time.Instant;
import org.junit.jupiter.api.Test;

@TestWithResources
public class RecipientDeliveryReportDtoTest extends BaseTest {

  @GivenJsonResource("/domains/sms/v1/deliveryreports/RecipientDeliveryReportSMSDto.json")
  RecipientDeliveryReport RecipientDeliveryReportSMSDto;

  @GivenJsonResource("/domains/sms/v1/deliveryreports/RecipientDeliveryReportMMSDto.json")
  RecipientDeliveryReport RecipientDeliveryReportMMSDto;

  public static RecipientDeliveryReportSMS deliveryReportRecipientSMS =
      RecipientDeliveryReportSMS.builder()
          .setBatchId("01FC66621XXXXX119Z8PMV1QPQ")
          .setClientReference("client reference")
          .setCreatedAt(Instant.parse("2022-08-30T08:16:08.930Z"))
          .setCode(DeliveryReceiptStatusCode.DISPATCHED)
          .setRecipient("+44231235674")
          .setStatus(DeliveryStatus.DISPATCHED)
          .setAppliedOriginator("applied originator")
          .setEncoding(EncodingType.from("encoding"))
          .setNumberOfMessageParts(123)
          .setOperator("operator")
          .setOperatorStatusAt(Instant.parse("2022-08-30T08:16:08.150Z"))
          .build();

  public static RecipientDeliveryReportMMS deliveryReportRecipientMMS =
      RecipientDeliveryReportMMS.builder()
          .setBatchId("01FC66621XXXXX119Z8PMV1QPQ")
          .setClientReference("client reference")
          .setCreatedAt(Instant.parse("2022-08-30T08:16:08.930Z"))
          .setCode(DeliveryReceiptStatusCode.DISPATCHED)
          .setRecipient("+44231235674")
          .setStatus(DeliveryStatus.DISPATCHED)
          .setAppliedOriginator("applied originator")
          .setEncoding(EncodingType.from("encoding"))
          .setNumberOfMessageParts(123)
          .setOperator("operator")
          .setOperatorStatusAt(Instant.parse("2022-08-30T08:16:08.150Z"))
          .build();

  @Test
  void deserializeDeliveryReportRecipientSMS() {
    TestHelpers.recursiveEquals(deliveryReportRecipientSMS, RecipientDeliveryReportSMSDto);
  }

  @Test
  void deserializeDeliveryReportRecipientMMS() {
    TestHelpers.recursiveEquals(deliveryReportRecipientMMS, RecipientDeliveryReportMMSDto);
  }
}
