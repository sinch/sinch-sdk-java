package com.sinch.sdk.domains.sms.adapters;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.exceptions.ApiMappingException;
import com.sinch.sdk.domains.sms.adapters.converters.DeliveryReportDtoConverter;
import com.sinch.sdk.domains.sms.adapters.converters.InboundsDtoConverter;
import com.sinch.sdk.domains.sms.models.DeliveryReportBatchMMS;
import com.sinch.sdk.domains.sms.models.DeliveryReportBatchSMS;
import com.sinch.sdk.domains.sms.models.DeliveryReportRecipientMMS;
import com.sinch.sdk.domains.sms.models.DeliveryReportRecipientSMS;
import com.sinch.sdk.domains.sms.models.InboundBinary;
import com.sinch.sdk.domains.sms.models.InboundText;
import com.sinch.sdk.domains.sms.models.dto.v1.DeliveryReportBatchDtoTest;
import com.sinch.sdk.domains.sms.models.dto.v1.DeliveryReportRecipientDtoTest;
import com.sinch.sdk.domains.sms.models.dto.v1.MOBinaryDtoTest;
import com.sinch.sdk.domains.sms.models.dto.v1.MOTextDtoTest;
import com.sinch.sdk.domains.sms.models.webhooks.WebhooksEvent;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

@TestWithResources
public class WebHooksServiceTest extends BaseTest {

  @GivenTextResource("/domains/sms/v1/inbounds/InboundBinaryDto.json")
  String incomingSMSBinaryJsonString;

  @GivenTextResource("/domains/sms/v1/inbounds/InboundTextDto.json")
  String incomingSMSTextJsonString;

  @GivenTextResource("/domains/sms/v1/deliveryreports/RecipientDeliveryReportSMSDto.json")
  String deliveryReportRecipientSMSJsonString;

  @GivenTextResource("/domains/sms/v1/deliveryreports/RecipientDeliveryReportMMSDto.json")
  String deliveryReportRecipientMMSJsonString;

  @GivenTextResource("/domains/sms/v1/deliveryreports/BatchDeliveryReportSMSDto.json")
  String deliveryReportBatchSMSJsonString;

  @GivenTextResource("/domains/sms/v1/deliveryreports/BatchDeliveryReportMMSDto.json")
  String deliveryReportBatchMMSJsonString;

  @InjectMocks WebHooksService service;

  @Test
  void incomingSMSBinary() throws ApiException {

    WebhooksEvent response = service.parse(incomingSMSBinaryJsonString);

    Assertions.assertThat(response).isInstanceOf(InboundBinary.class);
    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(InboundsDtoConverter.convert(MOBinaryDtoTest.dto));
  }

  @Test
  void incomingSMSText() throws ApiException {

    WebhooksEvent response = service.parse(incomingSMSTextJsonString);

    Assertions.assertThat(response).isInstanceOf(InboundText.class);
    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(InboundsDtoConverter.convert(MOTextDtoTest.dto));
  }

  @Test
  void handleExceptionIncomingSMS() throws ApiException {

    String jsonPayload = incomingSMSBinaryJsonString.replace("mo_binary", "foo type");
    ApiMappingException thrown =
        assertThrows(ApiMappingException.class, () -> service.parse(jsonPayload));
    assertTrue(thrown.getMessage().contains(jsonPayload));
  }

  @Test
  void deliveryReportRecipientDeliveryReportSms() throws ApiException {

    WebhooksEvent response = service.parse(deliveryReportRecipientSMSJsonString);

    Assertions.assertThat(response).isInstanceOf(DeliveryReportRecipientSMS.class);
    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(
            DeliveryReportDtoConverter.convert(
                DeliveryReportRecipientDtoTest.deliveryReportRecipientSMS));
  }

  @Test
  void deliveryReportRecipientDeliveryReportMms() throws ApiException {

    WebhooksEvent response = service.parse(deliveryReportRecipientMMSJsonString);

    Assertions.assertThat(response).isInstanceOf(DeliveryReportRecipientMMS.class);
    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(
            DeliveryReportDtoConverter.convert(
                DeliveryReportRecipientDtoTest.deliveryReportRecipientMMS));
  }

  @Test
  void deliveryReportBatchDeliveryReportSms() throws ApiException {

    WebhooksEvent response = service.parse(deliveryReportBatchSMSJsonString);

    Assertions.assertThat(response).isInstanceOf(DeliveryReportBatchSMS.class);
    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(
            DeliveryReportDtoConverter.convert(DeliveryReportBatchDtoTest.deliveryReportBatchSMS));
  }

  @Test
  void deliveryReportBatchDeliveryReportMms() throws ApiException {

    WebhooksEvent response = service.parse(deliveryReportBatchMMSJsonString);

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
        assertThrows(ApiMappingException.class, () -> service.parse(jsonPayload));
    assertTrue(thrown.getMessage().contains(jsonPayload));
  }
}
