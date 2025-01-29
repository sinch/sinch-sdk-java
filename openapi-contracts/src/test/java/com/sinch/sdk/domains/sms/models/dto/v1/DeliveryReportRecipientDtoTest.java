package com.sinch.sdk.domains.sms.models.dto.v1;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import java.time.OffsetDateTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class DeliveryReportRecipientDtoTest extends BaseTest {

  @GivenJsonResource("/domains/sms/v1/deliveryreports/RecipientDeliveryReportSMSDto.json")
  RecipientDeliveryReportDto deliveryReportRecipientSMSDto;

  @GivenJsonResource("/domains/sms/v1/deliveryreports/RecipientDeliveryReportMMSDto.json")
  RecipientDeliveryReportDto deliveryReportRecipientMMSDto;

  public static RecipientDeliveryReportDto deliveryReportRecipientSMS =
      new RecipientDeliveryReportDto("01FC66621XXXXX119Z8PMV1QPQ")
          .type("recipient_delivery_report_sms")
          .clientReference("client reference")
          .at(OffsetDateTime.parse("2022-08-30T08:16:08.930Z"))
          .code(401)
          .recipient("+44231235674")
          .status("Dispatched")
          .appliedOriginator("applied originator")
          .encoding("encoding")
          .numberOfMessageParts(123)
          .operator("operator")
          .operatorStatusAt(OffsetDateTime.parse("2022-08-30T08:16:08.150Z"));

  public static RecipientDeliveryReportDto deliveryReportRecipientMMS =
      new RecipientDeliveryReportDto("01FC66621XXXXX119Z8PMV1QPQ")
          .type("recipient_delivery_report_mms")
          .clientReference("client reference")
          .at(OffsetDateTime.parse("2022-08-30T08:16:08.930Z"))
          .code(401)
          .recipient("+44231235674")
          .status("Dispatched")
          .appliedOriginator("applied originator")
          .encoding("encoding")
          .numberOfMessageParts(123)
          .operator("operator")
          .operatorStatusAt(OffsetDateTime.parse("2022-08-30T08:16:08.150Z"));

  @Test
  void deserializeDeliveryReportRecipientSMS() {
    Assertions.assertThat(deliveryReportRecipientSMS)
        .usingRecursiveComparison()
        .isEqualTo(deliveryReportRecipientSMSDto);
  }

  @Test
  void deserializeDeliveryReportRecipientMMS() {
    Assertions.assertThat(deliveryReportRecipientMMS)
        .usingRecursiveComparison()
        .isEqualTo(deliveryReportRecipientMMSDto);
  }
}
