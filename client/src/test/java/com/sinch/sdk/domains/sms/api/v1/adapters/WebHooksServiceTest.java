package com.sinch.sdk.domains.sms.api.v1.adapters;

import static org.junit.jupiter.api.Assertions.assertTrue;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.SinchClient;
import com.sinch.sdk.auth.HmacAuthenticationValidation;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.sms.api.v1.WebHooksService;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.BatchDeliveryReportDtoTest;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.RecipientDeliveryReportDtoTest;
import com.sinch.sdk.domains.sms.models.v1.inbounds.InboundMessageDtoTest;
import com.sinch.sdk.domains.sms.models.v1.webhooks.SmsEvent;
import com.sinch.sdk.models.Configuration;
import java.util.AbstractMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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

  WebHooksService service;

  @BeforeEach
  public void setUp() {

    Configuration configuration =
        Configuration.builder()
            .setProjectId("unused")
            .setKeyId("unused")
            .setKeySecret("unused")
            .build();
    service = new SinchClient(configuration).sms().v1().webhooks();
  }

  @Test
  void checkApplicationAuthentication() throws ApiException {

    Map<String, String> headers =
        Stream.of(
                new AbstractMap.SimpleEntry<>(
                    HmacAuthenticationValidation.SIGNATURE_HEADER,
                    "ZoHei66PPN/kZjw7hFVfGhJOnml3iGNCMWoyQVcE5o0="),
                new AbstractMap.SimpleEntry<>(
                    HmacAuthenticationValidation.ALGORITHM_HEADER, "HmacSHA256"),
                new AbstractMap.SimpleEntry<>(
                    HmacAuthenticationValidation.NONCE_HEADER, "01JHFFHWYY7HSS4FWTMDTQEK8V"),
                new AbstractMap.SimpleEntry<>(
                    HmacAuthenticationValidation.TIMESTAMP_HEADER, "1736760161"))
            .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

    boolean authenticationResult =
        service.validateAuthenticationHeader(
            "SMSWebhooksSecret",
            headers,
            "{\"at\":\"2025-01-13T09:22:40.914Z\",\"batch_id\":\"01JHFFHQ0P99JPPNQPJDV7JTBP\",\"client_reference\":\"a"
                + " client"
                + " reference\",\"code\":0,\"operator_status_at\":\"2025-01-13T09:22:00Z\",\"recipient\":\"33662162466\",\"status\":\"Delivered\",\"type\":\"recipient_delivery_report_sms\"}");

    assertTrue(authenticationResult);
  }

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
