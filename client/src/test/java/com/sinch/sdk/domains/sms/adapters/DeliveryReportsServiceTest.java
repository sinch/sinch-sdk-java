package com.sinch.sdk.domains.sms.adapters;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.sms.adapters.api.v1.DeliveryReportsApi;
import com.sinch.sdk.domains.sms.adapters.converters.DeliveryReportDtoConverter;
import com.sinch.sdk.domains.sms.models.DeliveryReportBatch;
import com.sinch.sdk.domains.sms.models.DeliveryReportBatchMMS;
import com.sinch.sdk.domains.sms.models.DeliveryReportBatchSMS;
import com.sinch.sdk.domains.sms.models.DeliveryReportRecipient;
import com.sinch.sdk.domains.sms.models.DeliveryReportRecipientMMS;
import com.sinch.sdk.domains.sms.models.DeliveryReportRecipientSMS;
import com.sinch.sdk.domains.sms.models.DeliveryReportStatus;
import com.sinch.sdk.domains.sms.models.DeliveryReportType;
import com.sinch.sdk.domains.sms.models.dto.v1.DeliveryReportDto;
import com.sinch.sdk.domains.sms.models.dto.v1.RecipientDeliveryReportDto;
import com.sinch.sdk.models.Configuration;
import java.util.Collections;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

@TestWithResources
class DeliveryReportsServiceTest extends BaseTest {
  @Mock Configuration configuration;
  @Mock DeliveryReportsApi api;
  @InjectMocks DeliveryReportsService service;

  @GivenJsonResource("/domains/sms/v1/DeliveryReportBatchSMSDto.json")
  DeliveryReportDto deliveryReportBatchSMSDto;

  @GivenJsonResource("/domains/sms/v1/DeliveryReportBatchMMSDto.json")
  DeliveryReportDto deliveryReportBatchMMSDto;

  @GivenJsonResource("/domains/sms/v1/DeliveryReportRecipientSMSDto.json")
  RecipientDeliveryReportDto deliveryReportRecipientSMSDto;

  @GivenJsonResource("/domains/sms/v1/DeliveryReportRecipientMMSDto.json")
  RecipientDeliveryReportDto deliveryReportRecipientMMSDto;

  @Test
  void getDeliveryReportBatchSMS() throws ApiException {

    when(api.getDeliveryReportByBatchId(
            eq(configuration.getProjectId()),
            eq("foo binary batch id"),
            eq("foo type"),
            eq("foo statuses"),
            eq("456")))
        .thenReturn(deliveryReportBatchSMSDto);

    DeliveryReportBatch response =
        service.get(
            "foo binary batch id",
            DeliveryReportType.from("foo type"),
            Collections.singletonList(DeliveryReportStatus.from("foo statuses")),
            Collections.singletonList(456));

    assertInstanceOf(DeliveryReportBatchSMS.class, response);
    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(DeliveryReportDtoConverter.convert(deliveryReportBatchSMSDto));
  }

  @Test
  void getDeliveryReportBatchMMS() throws ApiException {

    when(api.getDeliveryReportByBatchId(
            eq(configuration.getProjectId()),
            eq("foo binary batch id"),
            eq("foo type"),
            eq("foo statuses"),
            eq("456")))
        .thenReturn(deliveryReportBatchMMSDto);

    DeliveryReportBatch response =
        service.get(
            "foo binary batch id",
            DeliveryReportType.from("foo type"),
            Collections.singletonList(DeliveryReportStatus.from("foo statuses")),
            Collections.singletonList(456));

    assertInstanceOf(DeliveryReportBatchMMS.class, response);
    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(DeliveryReportDtoConverter.convert(deliveryReportBatchMMSDto));
  }

  @Test
  void getDeliveryReportRecipientSMS() throws ApiException {

    when(api.getDeliveryReportByPhoneNumber(
            eq(configuration.getProjectId()), eq("foo binary batch id"), eq("foo number")))
        .thenReturn(deliveryReportRecipientSMSDto);

    DeliveryReportRecipient response = service.getForNumber("foo binary batch id", "foo number");

    assertInstanceOf(DeliveryReportRecipientSMS.class, response);
    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(DeliveryReportDtoConverter.convert(deliveryReportRecipientSMSDto));
  }

  @Test
  void getDeliveryReportRecipientMMS() throws ApiException {

    when(api.getDeliveryReportByPhoneNumber(
            eq(configuration.getProjectId()), eq("foo binary batch id"), eq("foo number")))
        .thenReturn(deliveryReportRecipientMMSDto);

    DeliveryReportRecipient response = service.getForNumber("foo binary batch id", "foo number");

    assertInstanceOf(DeliveryReportRecipientMMS.class, response);
    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(DeliveryReportDtoConverter.convert(deliveryReportRecipientMMSDto));
  }
}
