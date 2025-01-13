package com.sinch.sdk.domains.sms.api.v1.adapters;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.BatchDeliveryReportDtoTest;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.RecipientDeliveryReportDtoTest;
import com.sinch.sdk.domains.sms.models.v1.inbounds.InboundMessageDtoTest;
import com.sinch.sdk.domains.sms.models.v1.webhooks.SmsEvent;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

@TestWithResources
public class WebHooksServiceTest extends BaseTest {

  @GivenTextResource("/domains/sms/v1/inbounds/InboundBinaryDto.json")
  String loadedInboundBinaryEvent;

  @GivenTextResource("/domains/sms/v1/inbounds/InboundTextDto.json")
  String loadedInboundTextEvent;

  @GivenTextResource("/domains/sms/v1/inbounds/InboundMediaDto.json")
  String loadedInboundMediaEvent;

  @GivenTextResource("/domains/sms/v1/deliveryreports/BatchDeliveryReportSMSDto.json")
  String loadedBatchDeliveryReportSMSEvent;

  @GivenTextResource("/domains/sms/v1/deliveryreports/BatchDeliveryReportMMSDto.json")
  String loadedBatchDeliveryReportMMSEvent;

  @GivenTextResource("/domains/sms/v1/deliveryreports/RecipientDeliveryReportSMSDto.json")
  String loadedRecipientDeliveryReportSMSEvent;

  @GivenTextResource("/domains/sms/v1/deliveryreports/RecipientDeliveryReportMMSDto.json")
  String loadedRecipientDeliveryReportMMSEvent;

  @InjectMocks WebHooksService service;

  @Test
  void incomingSMSBinary() throws ApiException {

    SmsEvent response = service.parseEvent(loadedInboundBinaryEvent);

    TestHelpers.recursiveEquals(InboundMessageDtoTest.binaryDTO, response);
  }

  @Test
  void incomingSMSText() throws ApiException {

    SmsEvent response = service.parseEvent(loadedInboundTextEvent);

    TestHelpers.recursiveEquals(InboundMessageDtoTest.textDTO, response);
  }

  @Test
  void incomingSMSMedia() throws ApiException {

    SmsEvent response = service.parseEvent(loadedInboundMediaEvent);

    TestHelpers.recursiveEquals(InboundMessageDtoTest.mediaDTO, response);
  }

  @Test
  void deliveryReportRecipientDeliveryReportSms() throws ApiException {

    SmsEvent response = service.parseEvent(loadedRecipientDeliveryReportSMSEvent);

    TestHelpers.recursiveEquals(
        RecipientDeliveryReportDtoTest.deliveryReportRecipientSMS, response);
  }

  @Test
  void deliveryReportRecipientDeliveryReportMms() throws ApiException {

    SmsEvent response = service.parseEvent(loadedRecipientDeliveryReportMMSEvent);

    TestHelpers.recursiveEquals(
        RecipientDeliveryReportDtoTest.deliveryReportRecipientMMS, response);
  }

  @Test
  void deliveryReportBatchDeliveryReportSms() throws ApiException {

    SmsEvent response = service.parseEvent(loadedBatchDeliveryReportSMSEvent);

    TestHelpers.recursiveEquals(BatchDeliveryReportDtoTest.deliveryReportBatchSMS, response);
  }

  @Test
  void deliveryReportBatchDeliveryReportMms() throws ApiException {

    SmsEvent response = service.parseEvent(loadedBatchDeliveryReportMMSEvent);

    TestHelpers.recursiveEquals(BatchDeliveryReportDtoTest.deliveryReportBatchMMS, response);
  }
}
