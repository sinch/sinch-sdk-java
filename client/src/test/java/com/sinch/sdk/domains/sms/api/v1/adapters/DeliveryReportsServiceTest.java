package com.sinch.sdk.domains.sms.api.v1.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.sms.api.v1.internal.DeliveryReportsApi;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.BatchDeliveryReport;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.DeliveryReceiptErrorCode;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.DeliveryStatus;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.EncodingType;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.RecipientDeliveryReport;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.RecipientDeliveryReportMMS;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.RecipientDeliveryReportSMS;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.request.BatchDeliveryReportQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.request.ListDeliveryReportsQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.request.QueryReportType;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.response.ListDeliveryReportsResponse;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.response.internal.DeliveryReportList;
import com.sinch.sdk.models.SmsContext;
import java.time.Instant;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
class DeliveryReportsServiceTest extends BaseTest {

  @Mock SmsContext context;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;

  @Mock DeliveryReportsApi api;
  DeliveryReportsService service;
  String uriPartID = "foovalue";

  @GivenJsonResource("/domains/sms/v1/deliveryreports/BatchDeliveryReportSMSDto.json")
  BatchDeliveryReport deliveryReportBatchSMSDto;

  @GivenJsonResource("/domains/sms/v1/deliveryreports/BatchDeliveryReportMMSDto.json")
  BatchDeliveryReport deliveryReportBatchMMSDto;

  @GivenJsonResource("/domains/sms/v1/deliveryreports/RecipientDeliveryReportSMSDto.json")
  RecipientDeliveryReport deliveryReportRecipientSMSDto;

  @GivenJsonResource("/domains/sms/v1/deliveryreports/RecipientDeliveryReportMMSDto.json")
  RecipientDeliveryReport deliveryReportRecipientMMSDto;

  @GivenJsonResource(
      "/domains/sms/v1/deliveryreports/response/ListDeliveryReportResponseDtoPage0.json")
  DeliveryReportList listDeliveryReportResponseDtoPage0;

  @GivenJsonResource(
      "/domains/sms/v1/deliveryreports/response/ListDeliveryReportResponseDtoPage1.json")
  DeliveryReportList listDeliveryReportResponseDtoPage1;

  @GivenJsonResource(
      "/domains/sms/v1/deliveryreports/response/ListDeliveryReportResponseDtoPage2.json")
  DeliveryReportList listDeliveryReportResponseDtoPage2;

  @BeforeEach
  public void initMocks() {
    service = spy(new DeliveryReportsService(uriPartID, context, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void getSimplifiedDeliveryReport() throws ApiException {

    when(api.get(eq("foo binary batch id"))).thenReturn(deliveryReportBatchSMSDto);

    BatchDeliveryReport response = service.get("foo binary batch id");

    TestHelpers.recursiveEquals(response, deliveryReportBatchSMSDto);
  }

  @Test
  void getBatchDeliveryReportSMS() throws ApiException {

    BatchDeliveryReportQueryParameters queryParameters =
        BatchDeliveryReportQueryParameters.builder()
            .setCode(
                Arrays.asList(
                    DeliveryReceiptErrorCode.from(456), DeliveryReceiptErrorCode.from(789)))
            .setStatus(Arrays.asList(DeliveryStatus.from("foo status1"), DeliveryStatus.CANCELLED))
            .setType(QueryReportType.from("foo type"))
            .build();

    when(api.get(eq("foo binary batch id"), eq(queryParameters)))
        .thenReturn(deliveryReportBatchSMSDto);

    BatchDeliveryReport response = service.get("foo binary batch id", queryParameters);

    TestHelpers.recursiveEquals(response, deliveryReportBatchSMSDto);
  }

  @Test
  void getBatchDeliveryReportMMS() throws ApiException {

    BatchDeliveryReportQueryParameters queryParameters =
        BatchDeliveryReportQueryParameters.builder()
            .setCode(
                Arrays.asList(
                    DeliveryReceiptErrorCode.from(456), DeliveryReceiptErrorCode.from(789)))
            .setStatus(Arrays.asList(DeliveryStatus.from("foo status1"), DeliveryStatus.CANCELLED))
            .setType(QueryReportType.from("foo type"))
            .build();

    when(api.get(eq("foo binary batch id"), eq(queryParameters)))
        .thenReturn(deliveryReportBatchMMSDto);

    BatchDeliveryReport response = service.get("foo binary batch id", queryParameters);

    TestHelpers.recursiveEquals(response, deliveryReportBatchMMSDto);
  }

  @Test
  void getRecipientDeliveryReportSMS() throws ApiException {

    when(api.getForNumber(eq("foo binary batch id"), eq("foo number")))
        .thenReturn(deliveryReportRecipientSMSDto);

    RecipientDeliveryReport response = service.getForNumber("foo binary batch id", "foo number");

    TestHelpers.recursiveEquals(response, deliveryReportRecipientSMSDto);
  }

  @Test
  void getRecipientDeliveryReportMMS() throws ApiException {

    when(api.getForNumber(eq("foo binary batch id"), eq("foo number")))
        .thenReturn(deliveryReportRecipientMMSDto);

    RecipientDeliveryReport response = service.getForNumber("foo binary batch id", "foo number");

    TestHelpers.recursiveEquals(response, deliveryReportRecipientMMSDto);
  }

  @Test
  void list() throws ApiException {

    ListDeliveryReportsQueryParameters page1 =
        ListDeliveryReportsQueryParameters.builder().setPage(1).build();
    ListDeliveryReportsQueryParameters page2 =
        ListDeliveryReportsQueryParameters.builder().setPage(2).build();

    when(api.list(eq(null))).thenReturn(listDeliveryReportResponseDtoPage0);
    when(api.list(eq(page1))).thenReturn(listDeliveryReportResponseDtoPage1);
    when(api.list(eq(page2))).thenReturn(listDeliveryReportResponseDtoPage2);

    ListDeliveryReportsResponse response = service.list(null);

    Iterator<RecipientDeliveryReport> iterator = response.iterator();
    RecipientDeliveryReport item = iterator.next();
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);

    TestHelpers.recursiveEquals(
        item,
        RecipientDeliveryReportSMS.builder()
            .setBatchId("01FC66621XXXXX119Z8PMV1QPQ")
            .setRecipient("+44231235674")
            .setCode(DeliveryReceiptErrorCode.DISPATCHED)
            .setStatus(DeliveryStatus.DISPATCHED)
            .setCreatedAt(Instant.parse("2022-08-30T08:16:08.930Z"))
            .setOperator("operator")
            .setAppliedOriginator("applied originator")
            .setClientReference("client reference")
            .setEncoding(EncodingType.from("encoding"))
            .setNumberOfMessageParts(123)
            .setOperatorStatusAt(Instant.parse("2022-08-30T08:16:08.150Z"))
            .build());

    item = iterator.next();
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);
    TestHelpers.recursiveEquals(
        item,
        RecipientDeliveryReportMMS.builder()
            .setBatchId("01FC66621XXXXX119Z8PMV1QPQ")
            .setRecipient("+44231235674")
            .setCode(DeliveryReceiptErrorCode.DISPATCHED)
            .setStatus(DeliveryStatus.DISPATCHED)
            .setCreatedAt(Instant.parse("2022-08-30T08:16:08.930Z"))
            .setOperator("operator")
            .setAppliedOriginator("applied originator")
            .setClientReference("client reference")
            .setEncoding(EncodingType.from("encoding"))
            .setNumberOfMessageParts(123)
            .setOperatorStatusAt(Instant.parse("2022-08-30T08:16:08.150Z"))
            .build());

    item = iterator.next();
    Assertions.assertThat(iterator.hasNext()).isEqualTo(false);
    TestHelpers.recursiveEquals(
        item,
        RecipientDeliveryReportSMS.builder()
            .setBatchId("01FC66621XXXXX119Z8PMV1QPQ")
            .setRecipient("+44231235674")
            .setCode(DeliveryReceiptErrorCode.from(401))
            .setStatus(DeliveryStatus.DISPATCHED)
            .setCreatedAt(Instant.parse("2022-08-30T08:16:08.930Z"))
            .setOperator("operator")
            .setAppliedOriginator("applied originator")
            .setClientReference("client reference")
            .setEncoding(EncodingType.from("encoding"))
            .setNumberOfMessageParts(123)
            .setOperatorStatusAt(Instant.parse("2022-08-30T08:16:08.150Z"))
            .build());
  }
}
