package com.sinch.sdk.domains.sms.adapters;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.domains.sms.adapters.converters.DeliveryReportDtoConverter;
import com.sinch.sdk.domains.sms.models.BaseDeliveryReport;
import com.sinch.sdk.domains.sms.models.DeliveryReportBatchMMS;
import com.sinch.sdk.domains.sms.models.DeliveryReportBatchSMS;
import com.sinch.sdk.domains.sms.models.DeliveryReportRecipientMMS;
import com.sinch.sdk.domains.sms.models.DeliveryReportRecipientSMS;
import com.sinch.sdk.domains.sms.models.dto.v1.DeliveryReportBatchDtoTest;
import com.sinch.sdk.domains.sms.models.dto.v1.DeliveryReportRecipientDtoTest;
import com.sinch.sdk.domains.sms.models.dto.v1.webhooks.IncomingSMSBinaryDtoTest;
import com.sinch.sdk.domains.sms.models.dto.v1.webhooks.IncomingSMSTextDtoTest;
import com.sinch.sdk.domains.sms.models.webhooks.BaseIncomingSMS;
import com.sinch.sdk.domains.sms.models.webhooks.IncomingSMSBinary;
import com.sinch.sdk.domains.sms.models.webhooks.IncomingSMSText;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

@TestWithResources
public class WebHooksServiceTest extends BaseTest {

  @GivenTextResource("/domains/sms/v1/webhooks/IncomingSMSBinary.json")
  String incomingSMSBinaryJsonString;

  @GivenTextResource("/domains/sms/v1/webhooks/IncomingSMSText.json")
  String incomingSMSTextJsonString;

  @GivenTextResource("/domains/sms/v1/DeliveryReportRecipientSMSDto.json")
  String deliveryReportRecipientSMSJsonString;

  @GivenTextResource("/domains/sms/v1/DeliveryReportRecipientMMSDto.json")
  String deliveryReportRecipientMMSJsonString;

  @GivenTextResource("/domains/sms/v1/DeliveryReportBatchSMSDto.json")
  String deliveryReportBatchSMSJsonString;

  @GivenTextResource("/domains/sms/v1/DeliveryReportBatchMMSDto.json")
  String deliveryReportBatchMMSJsonString;

  @InjectMocks WebHooksService service;

  @Test
  void incomingSMSBinary() throws ApiException {

    BaseIncomingSMS<?> response = service.incomingSMS(incomingSMSBinaryJsonString);

    Assertions.assertThat(response).isInstanceOf(IncomingSMSBinary.class);
    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(IncomingSMSBinaryDtoTest.incomingSMSBinary);
  }

  @Test
  void incomingSMSText() throws ApiException {

    BaseIncomingSMS<?> response = service.incomingSMS(incomingSMSTextJsonString);

    Assertions.assertThat(response).isInstanceOf(IncomingSMSText.class);
    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(IncomingSMSTextDtoTest.incomingSMSText);
  }

  @Test
  void handleExceptionIncomingSMS() throws ApiException {

    String jsonPayload = incomingSMSBinaryJsonString.replace("mo_binary", "foo type");
    ApiMappingException thrown =
        assertThrows(ApiMappingException.class, () -> service.incomingSMS(jsonPayload));
    assertTrue(thrown.getMessage().contains(jsonPayload));
  }

  @Test
  void deliveryReportRecipientDeliveryReportSms() throws ApiException {

    BaseDeliveryReport response = service.deliveryReport(deliveryReportRecipientSMSJsonString);

    Assertions.assertThat(response).isInstanceOf(DeliveryReportRecipientSMS.class);
    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(
            DeliveryReportDtoConverter.convert(
                DeliveryReportRecipientDtoTest.deliveryReportRecipientSMS));
  }

  @Test
  void deliveryReportRecipientDeliveryReportMms() throws ApiException {

    BaseDeliveryReport response = service.deliveryReport(deliveryReportRecipientMMSJsonString);

    Assertions.assertThat(response).isInstanceOf(DeliveryReportRecipientMMS.class);
    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(
            DeliveryReportDtoConverter.convert(
                DeliveryReportRecipientDtoTest.deliveryReportRecipientMMS));
  }

  @Test
  void deliveryReportBatchDeliveryReportSms() throws ApiException {

    BaseDeliveryReport response = service.deliveryReport(deliveryReportBatchSMSJsonString);

    Assertions.assertThat(response).isInstanceOf(DeliveryReportBatchSMS.class);
    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(
            DeliveryReportDtoConverter.convert(DeliveryReportBatchDtoTest.deliveryReportBatchSMS));
  }

  @Test
  void deliveryReportBatchDeliveryReportMms() throws ApiException {

    BaseDeliveryReport response = service.deliveryReport(deliveryReportBatchMMSJsonString);

    Assertions.assertThat(response).isInstanceOf(DeliveryReportBatchMMS.class);
    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(
            DeliveryReportDtoConverter.convert(DeliveryReportBatchDtoTest.deliveryReportBatchMMS));
  }

  @Test
  void handleExceptionDeliveryReport() throws ApiException {

    String jsonPayload =
        deliveryReportRecipientMMSJsonString.replace("recipient_delivery_report_mms", "foo type");
    ApiMappingException thrown =
        assertThrows(ApiMappingException.class, () -> service.deliveryReport(jsonPayload));
    assertTrue(thrown.getMessage().contains(jsonPayload));
  }
}
