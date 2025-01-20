package com.sinch.sdk.domains.sms.api.v1.adapters;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpContentType;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpRequestTest.HttpRequestMatcher;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.http.URLParameter;
import com.sinch.sdk.core.http.URLParameter.STYLE;
import com.sinch.sdk.core.http.URLPathUtils;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.PaginationFillerHelper;
import com.sinch.sdk.domains.sms.api.v1.DeliveryReportsService;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.BatchDeliveryReport;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.DeliveryReceiptErrorCode;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.DeliveryStatus;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.RecipientDeliveryReport;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.request.ListDeliveryReportsQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.response.ListDeliveryReportsResponse;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.response.internal.DeliveryReportList;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
class DeliveryReportsServiceTest extends BaseTest {
  static final String SMS_AUTH_NAMES = "BearerAuth";
  static final String SERVICE_PLAN_ID = "foo value";
  static final String BATCH_ID = "foo batchID";

  @GivenTextResource("/domains/sms/v1/deliveryreports/BatchDeliveryReportSMSDto.json")
  String jsonBatchDeliveryReportSMSDto;

  @GivenJsonResource("/domains/sms/v1/deliveryreports/BatchDeliveryReportSMSDto.json")
  BatchDeliveryReport batchDeliveryReportSMSDto;

  @GivenTextResource("/domains/sms/v1/deliveryreports/RecipientDeliveryReportMMSDto.json")
  String jsonRecipientDeliveryReportMMSDto;

  @GivenJsonResource("/domains/sms/v1/deliveryreports/RecipientDeliveryReportMMSDto.json")
  RecipientDeliveryReport recipientDeliveryReportMMSDto;

  @GivenTextResource(
      "/domains/sms/v1/deliveryreports/response/ListDeliveryReportResponseDtoPage0.json")
  String jsonListDeliveryReportResponseDtoPage0;

  @GivenJsonResource(
      "/domains/sms/v1/deliveryreports/response/ListDeliveryReportResponseDtoPage0.json")
  DeliveryReportList listDeliveryReportResponseDtoPage0;

  @GivenTextResource(
      "/domains/sms/v1/deliveryreports/response/ListDeliveryReportResponseDtoPage1.json")
  String jsonListDeliveryReportResponseDtoPage1;

  @GivenJsonResource(
      "/domains/sms/v1/deliveryreports/response/ListDeliveryReportResponseDtoPage1.json")
  DeliveryReportList listDeliveryReportResponseDtoPage1;

  @GivenTextResource(
      "/domains/sms/v1/deliveryreports/response/ListDeliveryReportResponseDtoPage2.json")
  String jsonListDeliveryReportResponseDtoPage2;

  @Mock ServerConfiguration serverConfiguration;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;

  DeliveryReportsService service;

  @BeforeEach
  public void initMocks() {
    service =
        new DeliveryReportsServiceImpl(
            httpClient,
            serverConfiguration,
            authManagers,
            HttpMapper.getInstance(),
            SERVICE_PLAN_ID);
  }

  @Test
  void getBatchDeliveryReport() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/"
                + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID)
                + "/batches/"
                + URLPathUtils.encodePathSegment(BATCH_ID)
                + "/delivery_report",
            HttpMethod.GET,
            Collections.emptyList(),
            null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonBatchDeliveryReportSMSDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    BatchDeliveryReport response = service.get(BATCH_ID);

    TestHelpers.recursiveEquals(response, batchDeliveryReportSMSDto);
  }

  @Test
  void getRecipientDeliveryReport() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/"
                + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID)
                + "/batches/"
                + URLPathUtils.encodePathSegment(BATCH_ID)
                + "/delivery_report/"
                + URLPathUtils.encodePathSegment("+1234567890"),
            HttpMethod.GET,
            Collections.emptyList(),
            null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonRecipientDeliveryReportMMSDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    RecipientDeliveryReport response = service.getForNumber(BATCH_ID, "+1234567890");

    TestHelpers.recursiveEquals(response, recipientDeliveryReportMMSDto);
  }

  @Test
  void listDefault() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/" + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID) + "/delivery_reports",
            HttpMethod.GET,
            Collections.emptyList(),
            null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonListDeliveryReportResponseDtoPage0.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    ListDeliveryReportsResponse response = service.list();
    TestHelpers.recursiveEquals(
        response.getContent(), listDeliveryReportResponseDtoPage0.getItems());
  }

  @Test
  void list() throws ApiException {

    List<Object> commonParameters =
        Arrays.asList(
            "page_size",
            2,
            STYLE.FORM,
            true,
            "start_date",
            "2023-11-03T15:21:21.113Z",
            STYLE.FORM,
            true,
            "end_date",
            "2023-12-12T15:54:21.321Z",
            STYLE.FORM,
            true,
            "status",
            Arrays.asList(DeliveryStatus.QUEUED, DeliveryStatus.DISPATCHED),
            STYLE.FORM,
            false,
            "code",
            Arrays.asList(
                DeliveryReceiptErrorCode.DISPATCHED, DeliveryReceiptErrorCode.UNPROVISIONED_REGION),
            STYLE.FORM,
            false,
            "client_reference",
            "client reference",
            STYLE.FORM,
            true);

    Collection<URLParameter> urlParameters0 =
        PaginationFillerHelper.parametersFiller("page", 0, STYLE.FORM, true, commonParameters);
    Collection<URLParameter> urlParameters1 =
        PaginationFillerHelper.parametersFiller("page", 1, STYLE.FORM, true, commonParameters);
    Collection<URLParameter> urlParameters2 =
        PaginationFillerHelper.parametersFiller("page", 2, STYLE.FORM, true, commonParameters);

    HttpRequest httpRequest0 =
        new HttpRequest(
            "/xms/v1/" + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID) + "/delivery_reports",
            HttpMethod.GET,
            urlParameters0,
            null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpRequest httpRequest1 =
        new HttpRequest(
            "/xms/v1/" + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID) + "/delivery_reports",
            HttpMethod.GET,
            urlParameters1,
            null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpRequest httpRequest2 =
        new HttpRequest(
            "/xms/v1/" + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID) + "/delivery_reports",
            HttpMethod.GET,
            urlParameters2,
            null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpResponse httpResponse0 =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonListDeliveryReportResponseDtoPage0.getBytes());
    HttpResponse httpResponse1 =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonListDeliveryReportResponseDtoPage1.getBytes());
    HttpResponse httpResponse2 =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonListDeliveryReportResponseDtoPage2.getBytes());
    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest0))))
        .thenReturn(httpResponse0);
    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest1))))
        .thenReturn(httpResponse1);
    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest2))))
        .thenReturn(httpResponse2);

    ListDeliveryReportsQueryParameters initialRequest =
        ListDeliveryReportsQueryParameters.builder()
            .setPage(0)
            .setPageSize(2)
            .setStartDate(Instant.parse("2023-11-03T15:21:21.113Z"))
            .setEndDate(Instant.parse("2023-12-12T15:54:21.321Z"))
            .setStatus(Arrays.asList(DeliveryStatus.QUEUED, DeliveryStatus.DISPATCHED))
            .setCode(
                Arrays.asList(
                    DeliveryReceiptErrorCode.DISPATCHED,
                    DeliveryReceiptErrorCode.UNPROVISIONED_REGION))
            .setClientReference("client reference")
            .build();

    ListDeliveryReportsResponse response = service.list(initialRequest);

    Iterator<RecipientDeliveryReport> iterator = response.iterator();

    RecipientDeliveryReport item = iterator.next();
    TestHelpers.recursiveEquals(item, listDeliveryReportResponseDtoPage0.getItems().get(0));
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);

    item = iterator.next();
    TestHelpers.recursiveEquals(item, listDeliveryReportResponseDtoPage0.getItems().get(1));
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);

    item = iterator.next();
    TestHelpers.recursiveEquals(item, listDeliveryReportResponseDtoPage1.getItems().get(0));

    Assertions.assertThat(iterator.hasNext()).isEqualTo(false);
  }
}
