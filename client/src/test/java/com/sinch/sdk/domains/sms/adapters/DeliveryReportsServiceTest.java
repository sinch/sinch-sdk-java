package com.sinch.sdk.domains.sms.adapters;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.sms.adapters.api.v1.DeliveryReportsApi;
import com.sinch.sdk.domains.sms.adapters.converters.DeliveryReportDtoConverter;
import com.sinch.sdk.domains.sms.models.DeliveryReportBatch;
import com.sinch.sdk.domains.sms.models.DeliveryReportBatchMMS;
import com.sinch.sdk.domains.sms.models.DeliveryReportBatchSMS;
import com.sinch.sdk.domains.sms.models.DeliveryReportErrorCode;
import com.sinch.sdk.domains.sms.models.DeliveryReportRecipient;
import com.sinch.sdk.domains.sms.models.DeliveryReportRecipientEncoding;
import com.sinch.sdk.domains.sms.models.DeliveryReportRecipientMMS;
import com.sinch.sdk.domains.sms.models.DeliveryReportRecipientSMS;
import com.sinch.sdk.domains.sms.models.DeliveryReportStatus;
import com.sinch.sdk.domains.sms.models.DeliveryReportType;
import com.sinch.sdk.domains.sms.models.dto.v1.DeliveryReportDto;
import com.sinch.sdk.domains.sms.models.dto.v1.DeliveryReportListDto;
import com.sinch.sdk.domains.sms.models.dto.v1.RecipientDeliveryReportDto;
import com.sinch.sdk.domains.sms.models.requests.DeliveryReportBatchGetRequestParameters;
import com.sinch.sdk.domains.sms.models.responses.DeliveryReportsListResponse;
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

  @GivenJsonResource("/domains/sms/v1/DeliveryReportBatchSMSDto.json")
  DeliveryReportDto deliveryReportBatchSMSDto;

  @GivenJsonResource("/domains/sms/v1/DeliveryReportBatchMMSDto.json")
  DeliveryReportDto deliveryReportBatchMMSDto;

  @GivenJsonResource("/domains/sms/v1/DeliveryReportRecipientSMSDto.json")
  RecipientDeliveryReportDto deliveryReportRecipientSMSDto;

  @GivenJsonResource("/domains/sms/v1/DeliveryReportRecipientMMSDto.json")
  RecipientDeliveryReportDto deliveryReportRecipientMMSDto;

  @GivenJsonResource("/domains/sms/v1/ListDeliveryReportResponseDtoPage0.json")
  DeliveryReportListDto listDeliveryReportResponseDtoPage0;

  @GivenJsonResource("/domains/sms/v1/ListDeliveryReportResponseDtoPage1.json")
  DeliveryReportListDto listDeliveryReportResponseDtoPage1;

  @GivenJsonResource("/domains/sms/v1/ListDeliveryReportResponseDtoPage2.json")
  DeliveryReportListDto listDeliveryReportResponseDtoPage2;

  @BeforeEach
  public void initMocks() {
    service = spy(new DeliveryReportsService(uriPartID, context, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void getDeliveryReportBatchSMS() throws ApiException {

    when(api.getDeliveryReportByBatchId(
            eq(uriPartID),
            eq("foo binary batch id"),
            eq("foo type"),
            eq("foo status1,Cancelled"),
            eq("456,789")))
        .thenReturn(deliveryReportBatchSMSDto);

    DeliveryReportBatch response =
        service.get(
            "foo binary batch id",
            DeliveryReportBatchGetRequestParameters.builder()
                .setType(DeliveryReportType.from("foo type"))
                .setStatuses(
                    Arrays.asList(
                        DeliveryReportStatus.from("foo status1"), DeliveryReportStatus.CANCELLED))
                .setCodes(Arrays.asList(456, 789))
                .build());

    assertInstanceOf(DeliveryReportBatchSMS.class, response);
    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(DeliveryReportDtoConverter.convert(deliveryReportBatchSMSDto));
  }

  @Test
  void getDeliveryReportBatchMMS() throws ApiException {

    when(api.getDeliveryReportByBatchId(
            eq(uriPartID),
            eq("foo binary batch id"),
            eq("foo type"),
            eq("foo status1,Cancelled"),
            eq("456,789")))
        .thenReturn(deliveryReportBatchMMSDto);

    DeliveryReportBatch response =
        service.get(
            "foo binary batch id",
            DeliveryReportBatchGetRequestParameters.builder()
                .setType(DeliveryReportType.from("foo type"))
                .setStatuses(
                    Arrays.asList(
                        DeliveryReportStatus.from("foo status1"), DeliveryReportStatus.CANCELLED))
                .setCodes(Arrays.asList(456, 789))
                .build());

    assertInstanceOf(DeliveryReportBatchMMS.class, response);
    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(DeliveryReportDtoConverter.convert(deliveryReportBatchMMSDto));
  }

  @Test
  void getDeliveryReportRecipientSMS() throws ApiException {

    when(api.getDeliveryReportByPhoneNumber(
            eq(uriPartID), eq("foo binary batch id"), eq("foo number")))
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
            eq(uriPartID), eq("foo binary batch id"), eq("foo number")))
        .thenReturn(deliveryReportRecipientMMSDto);

    DeliveryReportRecipient response = service.getForNumber("foo binary batch id", "foo number");

    assertInstanceOf(DeliveryReportRecipientMMS.class, response);
    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(DeliveryReportDtoConverter.convert(deliveryReportRecipientMMSDto));
  }

  @Test
  void list() throws ApiException {

    when(api.getDeliveryReports(
            eq(uriPartID), eq(null), eq(null), eq(null), eq(null), eq(null), eq(null), eq(null)))
        .thenReturn(listDeliveryReportResponseDtoPage0);
    when(api.getDeliveryReports(
            eq(uriPartID), eq(1), eq(null), eq(null), eq(null), eq(null), eq(null), eq(null)))
        .thenReturn(listDeliveryReportResponseDtoPage1);
    when(api.getDeliveryReports(
            eq(uriPartID), eq(2), eq(null), eq(null), eq(null), eq(null), eq(null), eq(null)))
        .thenReturn(listDeliveryReportResponseDtoPage2);
    DeliveryReportsListResponse response = service.list(null);

    Iterator<DeliveryReportRecipient> iterator = response.iterator();
    DeliveryReportRecipient item = iterator.next();
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);

    assertInstanceOf(DeliveryReportRecipientSMS.class, item);
    Assertions.assertThat(item)
        .usingRecursiveComparison()
        .isEqualTo(
            DeliveryReportRecipientSMS.builder()
                .setBatchId("01FC66621XXXXX119Z8PMV1QPQ")
                .setRecipient("+44231235674")
                .setCode(DeliveryReportErrorCode.from(401))
                .setStatus(DeliveryReportStatus.DISPATCHED)
                .setAt(Instant.parse("2022-08-30T08:16:08.930Z"))
                .setOperator("operator")
                .setAppliedOriginator("applied originator")
                .setClientReference("client reference")
                .setEncoding(DeliveryReportRecipientEncoding.from("encoding"))
                .setNumberOfMessageParts(123)
                .setOperatorStatusAt(Instant.parse("2022-08-30T08:16:08.150Z"))
                .build());

    item = iterator.next();
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);
    assertInstanceOf(DeliveryReportRecipientMMS.class, item);
    Assertions.assertThat(item)
        .usingRecursiveComparison()
        .isEqualTo(
            DeliveryReportRecipientMMS.builder()
                .setBatchId("01FC66621XXXXX119Z8PMV1QPQ")
                .setRecipient("+44231235674")
                .setCode(DeliveryReportErrorCode.DISPATCHED)
                .setStatus(DeliveryReportStatus.DISPATCHED)
                .setAt(Instant.parse("2022-08-30T08:16:08.930Z"))
                .setOperator("operator")
                .setAppliedOriginator("applied originator")
                .setClientReference("client reference")
                .setEncoding(DeliveryReportRecipientEncoding.from("encoding"))
                .setNumberOfMessageParts(123)
                .setOperatorStatusAt(Instant.parse("2022-08-30T08:16:08.150Z"))
                .build());

    item = iterator.next();
    Assertions.assertThat(iterator.hasNext()).isEqualTo(false);
    assertInstanceOf(DeliveryReportRecipientSMS.class, item);
    Assertions.assertThat(item)
        .usingRecursiveComparison()
        .isEqualTo(
            DeliveryReportRecipientSMS.builder()
                .setBatchId("01FC66621XXXXX119Z8PMV1QPQ")
                .setRecipient("+44231235674")
                .setCode(DeliveryReportErrorCode.from(401))
                .setStatus(DeliveryReportStatus.DISPATCHED)
                .setAt(Instant.parse("2022-08-30T08:16:08.930Z"))
                .setOperator("operator")
                .setAppliedOriginator("applied originator")
                .setClientReference("client reference")
                .setEncoding(DeliveryReportRecipientEncoding.from("encoding"))
                .setNumberOfMessageParts(123)
                .setOperatorStatusAt(Instant.parse("2022-08-30T08:16:08.150Z"))
                .build());
  }
}
