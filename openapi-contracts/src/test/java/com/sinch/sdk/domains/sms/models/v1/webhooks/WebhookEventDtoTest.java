package com.sinch.sdk.domains.sms.models.v1.webhooks;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.BatchDeliveryReportDtoTest;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.RecipientDeliveryReportDtoTest;
import com.sinch.sdk.domains.sms.models.v1.inbounds.InboundMessageDtoTest;
import org.junit.jupiter.api.Test;

@TestWithResources
public class WebhookEventDtoTest extends BaseTest {

  @GivenJsonResource("/domains/sms/v1/inbounds/InboundBinaryDto.json")
  SmsEvent loadedInboundBinaryEvent;

  @GivenJsonResource("/domains/sms/v1/inbounds/InboundTextDto.json")
  SmsEvent loadedInboundTextEvent;

  @GivenJsonResource("/domains/sms/v1/inbounds/InboundMediaDto.json")
  SmsEvent loadedInboundMediaEvent;

  @GivenJsonResource("/domains/sms/v1/deliveryreports/BatchDeliveryReportSMSDto.json")
  SmsEvent loadedBatchDeliveryReportSMSEvent;

  @GivenJsonResource("/domains/sms/v1/deliveryreports/BatchDeliveryReportMMSDto.json")
  SmsEvent loadedBatchDeliveryReportMMSEvent;

  @GivenJsonResource("/domains/sms/v1/deliveryreports/RecipientDeliveryReportSMSDto.json")
  SmsEvent loadedRecipientDeliveryReportSMSEvent;

  @GivenJsonResource("/domains/sms/v1/deliveryreports/RecipientDeliveryReportMMSDto.json")
  SmsEvent loadedRecipientDeliveryReportMMSEvent;

  @Test
  void deserializeBinaryMessage() {

    TestHelpers.recursiveEquals(InboundMessageDtoTest.binaryDTO, loadedInboundBinaryEvent);
  }

  @Test
  void deserializeTextMessage() {

    TestHelpers.recursiveEquals(InboundMessageDtoTest.textDTO, loadedInboundTextEvent);
  }

  @Test
  void deserializeMediaMessage() {

    TestHelpers.recursiveEquals(InboundMessageDtoTest.mediaDTO, loadedInboundMediaEvent);
  }

  @Test
  void deserializeBatchDeliveryReportSMS() {
    TestHelpers.recursiveEquals(
        BatchDeliveryReportDtoTest.deliveryReportBatchSMS, loadedBatchDeliveryReportSMSEvent);
  }

  @Test
  void deserializeBatchDeliveryReportMMS() {
    TestHelpers.recursiveEquals(
        BatchDeliveryReportDtoTest.deliveryReportBatchMMS, loadedBatchDeliveryReportMMSEvent);
  }

  @Test
  void deserializeDeliveryReportRecipientSMS() {
    TestHelpers.recursiveEquals(
        RecipientDeliveryReportDtoTest.deliveryReportRecipientSMS,
        loadedRecipientDeliveryReportSMSEvent);
  }

  @Test
  void deserializeDeliveryReportRecipientMMS() {
    TestHelpers.recursiveEquals(
        RecipientDeliveryReportDtoTest.deliveryReportRecipientMMS,
        loadedRecipientDeliveryReportMMSEvent);
  }
}
