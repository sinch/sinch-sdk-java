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
import com.sinch.sdk.domains.sms.api.v1.BatchesService;
import com.sinch.sdk.domains.sms.models.v1.batches.request.DryRunQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.batches.request.ListBatchesQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.batches.request.SendDeliveryFeedbackRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.request.TextRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.request.UpdateTextRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.response.BatchResponse;
import com.sinch.sdk.domains.sms.models.v1.batches.response.DryRunResponse;
import com.sinch.sdk.domains.sms.models.v1.batches.response.ListBatchesResponse;
import com.sinch.sdk.domains.sms.models.v1.batches.response.internal.ApiBatchList;
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
public class BatchesServiceTest extends BaseTest {

  static final String SMS_AUTH_NAMES = "BearerAuth";

  static final String SERVICE_PLAN_ID = "foo value";
  static final String BATCH_ID = "foo batchID";

  @GivenJsonResource("/domains/sms/v1/batches/request/TextRequestDto.json")
  TextRequest textRequestDto;

  @GivenTextResource("/domains/sms/v1/batches/response/TextResponseDto.json")
  String jsonTextResponseDto;

  @GivenJsonResource("/domains/sms/v1/batches/response/TextResponseDto.json")
  BatchResponse textResponseDto;

  @GivenTextResource("/domains/sms/v1/batches/response/DryRunResponseDto.json")
  String jsonDryRunResponseDto;

  @GivenJsonResource("/domains/sms/v1/batches/response/DryRunResponseDto.json")
  DryRunResponse dryRunResponseDto;

  @GivenTextResource("/domains/sms/v1/batches/response/ListBatchesResponseDtoPage0.json")
  String jsonBatchesResponseDtoPage0;

  @GivenJsonResource("/domains/sms/v1/batches/response/ListBatchesResponseDtoPage0.json")
  ApiBatchList listBatchesResponseDtoPage0;

  @GivenTextResource("/domains/sms/v1/batches/response/ListBatchesResponseDtoPage1.json")
  String jsonBatchesResponseDtoPage1;

  @GivenJsonResource("/domains/sms/v1/batches/response/ListBatchesResponseDtoPage1.json")
  ApiBatchList listBatchesResponseDtoPage1;

  @GivenTextResource("/domains/sms/v1/batches/response/ListBatchesResponseDtoPage2.json")
  String jsonBatchesResponseDtoPage2;

  @GivenJsonResource("/domains/sms/v1/batches/request/UpdateTextRequestDto.json")
  UpdateTextRequest updateTextRequestDto;

  @GivenJsonResource("/domains/sms/v1/batches/request/SendDeliveryFeedbackRequestDto.json")
  SendDeliveryFeedbackRequest sendDeliveryFeedbackRequestDto;

  @Mock HttpClient httpClient;
  @Mock ServerConfiguration serverConfiguration;
  @Mock Map<String, AuthManager> authManagers;

  BatchesService service;

  @BeforeEach
  public void initMocks() {
    service =
        new BatchesServiceImpl(
            httpClient,
            serverConfiguration,
            authManagers,
            HttpMapper.getInstance(),
            SERVICE_PLAN_ID);
  }

  @Test
  void get() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/"
                + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID)
                + "/batches/"
                + URLPathUtils.encodePathSegment(BATCH_ID),
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonTextResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    BatchResponse response = service.get(BATCH_ID);

    TestHelpers.recursiveEquals(response, textResponseDto);
  }

  @Test
  void send() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/" + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID) + "/batches",
            HttpMethod.POST,
            Collections.emptyList(),
            HttpMapper.getInstance()
                .serialize(
                    Collections.singletonList(HttpContentType.APPLICATION_JSON), textRequestDto),
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonTextResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    BatchResponse response = service.send(textRequestDto);

    TestHelpers.recursiveEquals(response, textResponseDto);
  }

  @Test
  void dryRunDefault() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/" + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID) + "/batches/dry_run",
            HttpMethod.POST,
            Collections.emptyList(),
            HttpMapper.getInstance()
                .serialize(
                    Collections.singletonList(HttpContentType.APPLICATION_JSON), textRequestDto),
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonDryRunResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    DryRunResponse response = service.dryRun(textRequestDto);

    TestHelpers.recursiveEquals(response, dryRunResponseDto);
  }

  @Test
  void dryRun() throws ApiException {

    DryRunQueryParameters queryParameters =
        DryRunQueryParameters.builder().setPerRecipient(true).setNumberOfRecipients(456).build();

    Collection<URLParameter> urlParameters =
        Arrays.asList(
            new URLParameter("per_recipient", true, STYLE.FORM, true),
            new URLParameter("number_of_recipients", 456, STYLE.FORM, true));

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/" + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID) + "/batches/dry_run",
            HttpMethod.POST,
            urlParameters,
            HttpMapper.getInstance()
                .serialize(
                    Collections.singletonList(HttpContentType.APPLICATION_JSON), textRequestDto),
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonDryRunResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    DryRunResponse response = service.dryRun(queryParameters, textRequestDto);

    TestHelpers.recursiveEquals(response, dryRunResponseDto);
  }

  @Test
  void listDefault() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/" + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID) + "/batches",
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonBatchesResponseDtoPage0.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    ListBatchesResponse response = service.list();

    TestHelpers.recursiveEquals(response.getContent(), listBatchesResponseDtoPage0.getItems());
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
            "from",
            Arrays.asList("+1234567890"),
            STYLE.FORM,
            false,
            "client_reference",
            "client reference",
            STYLE.FORM,
            true);

    Collection<URLParameter> urlParametersPage0 =
        PaginationFillerHelper.parametersFiller("page", 0, STYLE.FORM, true, commonParameters);
    Collection<URLParameter> urlParametersPage1 =
        PaginationFillerHelper.parametersFiller("page", 1, STYLE.FORM, true, commonParameters);
    Collection<URLParameter> urlParametersPage2 =
        PaginationFillerHelper.parametersFiller("page", 2, STYLE.FORM, true, commonParameters);

    HttpRequest httpRequest0 =
        new HttpRequest(
            "/xms/v1/" + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID) + "/batches",
            HttpMethod.GET,
            urlParametersPage0,
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(SMS_AUTH_NAMES));

    HttpRequest httpRequest1 =
        new HttpRequest(
            "/xms/v1/" + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID) + "/batches",
            HttpMethod.GET,
            urlParametersPage1,
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(SMS_AUTH_NAMES));

    HttpRequest httpRequest2 =
        new HttpRequest(
            "/xms/v1/" + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID) + "/batches",
            HttpMethod.GET,
            urlParametersPage2,
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(SMS_AUTH_NAMES));

    HttpResponse httpResponse0 =
        new HttpResponse(200, null, Collections.emptyMap(), jsonBatchesResponseDtoPage0.getBytes());
    HttpResponse httpResponse1 =
        new HttpResponse(200, null, Collections.emptyMap(), jsonBatchesResponseDtoPage1.getBytes());
    HttpResponse httpResponse2 =
        new HttpResponse(200, null, Collections.emptyMap(), jsonBatchesResponseDtoPage2.getBytes());

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

    ListBatchesQueryParameters initialRequest =
        ListBatchesQueryParameters.builder()
            .setPage(0)
            .setPageSize(2)
            .setFrom(Arrays.asList("+1234567890"))
            .setClientReference("client reference")
            .setStartDate(Instant.parse("2023-11-03T15:21:21.113Z"))
            .setEndDate(Instant.parse("2023-12-12T15:54:21.321Z"))
            .build();

    ListBatchesResponse response = service.list(initialRequest);

    Iterator<BatchResponse> iterator = response.iterator();

    BatchResponse item = iterator.next();
    TestHelpers.recursiveEquals(item, listBatchesResponseDtoPage0.getItems().get(0));
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);

    item = iterator.next();
    TestHelpers.recursiveEquals(item, listBatchesResponseDtoPage0.getItems().get(1));
    Assertions.assertThat(iterator.hasNext()).isEqualTo(true);

    item = iterator.next();
    TestHelpers.recursiveEquals(item, listBatchesResponseDtoPage1.getItems().get(0));

    Assertions.assertThat(iterator.hasNext()).isEqualTo(false);
  }

  @Test
  void update() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/"
                + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID)
                + "/batches/"
                + URLPathUtils.encodePathSegment(BATCH_ID),
            HttpMethod.POST,
            Collections.emptyList(),
            HttpMapper.getInstance()
                .serialize(
                    Collections.singletonList(HttpContentType.APPLICATION_JSON),
                    updateTextRequestDto),
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonTextResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    BatchResponse response = service.update(BATCH_ID, updateTextRequestDto);

    TestHelpers.recursiveEquals(response, textResponseDto);
  }

  @Test
  void replace() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/"
                + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID)
                + "/batches/"
                + URLPathUtils.encodePathSegment(BATCH_ID),
            HttpMethod.PUT,
            Collections.emptyList(),
            HttpMapper.getInstance()
                .serialize(
                    Collections.singletonList(HttpContentType.APPLICATION_JSON), textRequestDto),
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonTextResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    BatchResponse response = service.replace(BATCH_ID, textRequestDto);

    TestHelpers.recursiveEquals(response, textResponseDto);
  }

  @Test
  void cancel() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/"
                + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID)
                + "/batches/"
                + URLPathUtils.encodePathSegment(BATCH_ID),
            HttpMethod.DELETE,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonTextResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    BatchResponse response = service.cancel(BATCH_ID);

    TestHelpers.recursiveEquals(response, textResponseDto);
  }

  @Test
  void sendDeliveryFeedback() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/"
                + URLPathUtils.encodePathSegment(SERVICE_PLAN_ID)
                + "/batches/"
                + URLPathUtils.encodePathSegment(BATCH_ID)
                + "/delivery_feedback",
            HttpMethod.POST,
            Collections.emptyList(),
            HttpMapper.getInstance()
                .serialize(
                    Collections.singletonList(HttpContentType.APPLICATION_JSON),
                    sendDeliveryFeedbackRequestDto),
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpResponse httpResponse = new HttpResponse(200, null, Collections.emptyMap(), null);

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    service.sendDeliveryFeedback(BATCH_ID, sendDeliveryFeedbackRequestDto);
  }
}
