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
import com.sinch.sdk.domains.sms.models.DeliveryReportStatus;
import com.sinch.sdk.domains.sms.models.DeliveryReportType;
import com.sinch.sdk.domains.sms.models.dto.v1.DeliveryReportDto;
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
  DeliveryReportDto deliveryReportSMSDto;

  @GivenJsonResource("/domains/sms/v1/DeliveryReportBatchMMSDto.json")
  DeliveryReportDto deliveryReportMMSDto;

  @Test
  void getDeliveryReportSMS() throws ApiException {

    when(api.getDeliveryReportByBatchId(
            eq(configuration.getProjectId()),
            eq("foo binary batch id"),
            eq("foo type"),
            eq("foo statuses"),
            eq("456")))
        .thenReturn(deliveryReportSMSDto);

    DeliveryReportBatch response =
        service.get(
            "foo binary batch id",
            DeliveryReportType.from("foo type"),
            Collections.singletonList(DeliveryReportStatus.from("foo statuses")),
            Collections.singletonList(456));

    assertInstanceOf(DeliveryReportBatchSMS.class, response);
    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(DeliveryReportDtoConverter.convert(deliveryReportSMSDto));
  }

  @Test
  void getDeliveryReportMMS() throws ApiException {

    when(api.getDeliveryReportByBatchId(
            eq(configuration.getProjectId()),
            eq("foo binary batch id"),
            eq("foo type"),
            eq("foo statuses"),
            eq("456")))
        .thenReturn(deliveryReportMMSDto);

    DeliveryReportBatch response =
        service.get(
            "foo binary batch id",
            DeliveryReportType.from("foo type"),
            Collections.singletonList(DeliveryReportStatus.from("foo statuses")),
            Collections.singletonList(456));

    assertInstanceOf(DeliveryReportBatchMMS.class, response);
    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(DeliveryReportDtoConverter.convert(deliveryReportMMSDto));
  }
}
