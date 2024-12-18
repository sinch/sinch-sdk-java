package com.sinch.sdk.domains.sms.api.v1.internal;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;
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
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.sms.models.v1.batches.request.DryRunQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.batches.request.ListBatchesQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.batches.request.SendDeliveryFeedbackRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.request.TextRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.request.UpdateTextRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.response.BatchResponse;
import com.sinch.sdk.domains.sms.models.v1.batches.response.DryRunResponse;
import com.sinch.sdk.domains.sms.models.v1.batches.response.internal.ApiBatchList;
import java.time.Instant;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class BatchesApiTest extends BaseTest {

  static final String SMS_AUTH_NAMES = "BearerAuth";

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

  @GivenJsonResource("/domains/sms/v1/batches/request/UpdateTextRequestDto.json")
  UpdateTextRequest updateTextRequestDto;

  @GivenJsonResource("/domains/sms/v1/batches/request/SendDeliveryFeedbackRequestDto.json")
  SendDeliveryFeedbackRequest sendDeliveryFeedbackRequestDto;

  @Mock HttpClient httpClient;
  @Mock ServerConfiguration serverConfiguration;

  HttpMapper httpMapper = new HttpMapper();
  @Mock Map<String, AuthManager> authManagers;
  BatchesApi api;
  String uriPartID = "foovalue";

  @BeforeEach
  public void initMocks() {
    api = spy(new BatchesApi(httpClient, serverConfiguration, authManagers, httpMapper, uriPartID));
  }

  @Test
  void get() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/foovalue/batches/foo%20binary%20batch%20id",
            HttpMethod.GET,
            Collections.emptyList(),
            null,
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

    BatchResponse response = api.get("foo binary batch id");

    TestHelpers.recursiveEquals(response, textResponseDto);
  }

  @Test
  void send() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/foovalue/batches",
            HttpMethod.POST,
            Collections.emptyList(),
            httpMapper.serialize(
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

    BatchResponse response = api.send(textRequestDto);

    TestHelpers.recursiveEquals(response, textResponseDto);
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
            "/xms/v1/foovalue/batches/dry_run",
            HttpMethod.POST,
            urlParameters,
            httpMapper.serialize(
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

    DryRunResponse response = api.dryRun(queryParameters, textRequestDto);

    TestHelpers.recursiveEquals(response, dryRunResponseDto);
  }

  @Test
  void list() throws ApiException {

    Collection<URLParameter> urlParameters =
        Arrays.asList(
            new URLParameter("page", 1, STYLE.FORM, true),
            new URLParameter("page_size", 2, STYLE.FORM, true),
            new URLParameter("from", "+1234567890", STYLE.FORM, true),
            new URLParameter("start_date", "2023-11-03T15:21:21.113Z", STYLE.FORM, true),
            new URLParameter("end_date", "2023-12-12T15:54:21.321Z", STYLE.FORM, true),
            new URLParameter("client_reference", "client reference", STYLE.FORM, true));

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/foovalue/batches",
            HttpMethod.GET,
            urlParameters,
            null,
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

    ListBatchesQueryParameters initialRequest =
        ListBatchesQueryParameters.builder()
            .setPage(1)
            .setPageSize(2)
            .setFrom("+1234567890")
            .setClientReference("client reference")
            .setStartDate(Instant.parse("2023-11-03T15:21:21.113Z"))
            .setEndDate(Instant.parse("2023-12-12T15:54:21.321Z"))
            .build();

    ApiBatchList response = api.list(initialRequest);

    TestHelpers.recursiveEquals(response, listBatchesResponseDtoPage0);
  }

  @Test
  void update() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/foovalue/batches/foo%20text%20batch%20id",
            HttpMethod.POST,
            Collections.emptyList(),
            httpMapper.serialize(
                Collections.singletonList(HttpContentType.APPLICATION_JSON), updateTextRequestDto),
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

    BatchResponse response = api.update("foo text batch id", updateTextRequestDto);

    TestHelpers.recursiveEquals(response, textResponseDto);
  }

  @Test
  void replace() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/foovalue/batches/foo%20text%20batch%20id",
            HttpMethod.PUT,
            Collections.emptyList(),
            httpMapper.serialize(
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

    BatchResponse response = api.replace("foo text batch id", textRequestDto);

    TestHelpers.recursiveEquals(response, textResponseDto);
  }

  @Test
  void cancel() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/foovalue/batches/foo%20text%20batch%20id",
            HttpMethod.DELETE,
            Collections.emptyList(),
            null,
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

    BatchResponse response = api.cancel("foo text batch id");

    TestHelpers.recursiveEquals(response, textResponseDto);
  }

  @Test
  void sendDeliveryFeedback() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/xms/v1/foovalue/batches/foo%20text%20batch%20id/delivery_feedback",
            HttpMethod.POST,
            Collections.emptyList(),
            httpMapper.serialize(
                Collections.singletonList(HttpContentType.APPLICATION_JSON),
                sendDeliveryFeedbackRequestDto),
            Collections.emptyMap(),
            Collections.emptyList(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(SMS_AUTH_NAMES));
    HttpResponse httpResponse = new HttpResponse(200, null, Collections.emptyMap(), null);

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    api.sendDeliveryFeedback("foo text batch id", sendDeliveryFeedbackRequestDto);
  }
}
