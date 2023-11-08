package com.sinch.sdk.domains.sms.models.dto.v1.webhooks;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.domains.sms.models.DeliveryReportRecipientMMS;
import com.sinch.sdk.domains.sms.models.DeliveryReportRecipientSMS;
import java.time.OffsetDateTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

@TestWithResources
public class DeliveryReportRecipientDtoTest extends BaseTest {

  @GivenJsonResource("/domains/sms/v1/webhooks/DeliveryReportRecipientSMS.json")
  DeliveryReportRecipientSMS deliveryReportRecipientSMSClient;

  @GivenJsonResource("/domains/sms/v1/webhooks/DeliveryReportRecipientMMS.json")
  DeliveryReportRecipientMMS deliveryReportRecipientMMSClient;

  public static DeliveryReportRecipientSMS deliveryReportRecipientSMS =
      new DeliveryReportRecipientSMS(
          "01FC66621XXXXX119Z8PMV1QPQ",
          "client reference",
          OffsetDateTime.parse("2022-08-30T08:16:08.930Z"),
          401,
          "+44231235674",
          "Dispatched",
          "applied originator",
          "encoding",
          123,
          "operator",
          OffsetDateTime.parse("2022-08-30T08:16:08.150Z"));

  public static DeliveryReportRecipientMMS deliveryReportRecipientMMS =
      new DeliveryReportRecipientMMS(
          "01FC66621XXXXX119Z8PMV1QPQ",
          "client reference",
          OffsetDateTime.parse("2022-08-30T08:16:08.930Z"),
          401,
          "+44231235674",
          "Dispatched",
          "applied originator",
          "encoding",
          123,
          "operator",
          OffsetDateTime.parse("2022-08-30T08:16:08.150Z"));

  @Test
  void deserializeDeliveryReportRecipientSMS() {
    Assertions.assertThat(deliveryReportRecipientSMS)
        .usingRecursiveComparison()
        .isEqualTo(deliveryReportRecipientSMSClient);
  }

  @Test
  void deserializeDeliveryReportRecipientMMS() {
    Assertions.assertThat(deliveryReportRecipientMMS)
        .usingRecursiveComparison()
        .isEqualTo(deliveryReportRecipientMMSClient);
  }
}
