package com.sinch.sdk.domains.voice.api.v2.adapters;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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
import com.sinch.sdk.core.http.URLPathUtils;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.voice.api.v2.CallsService;
import com.sinch.sdk.domains.voice.models.v2.Call;
import com.sinch.sdk.domains.voice.models.v2.CallDtoTest;
import com.sinch.sdk.domains.voice.models.v2.CallReason;
import com.sinch.sdk.domains.voice.models.v2.CallResult;
import com.sinch.sdk.domains.voice.models.v2.CallType;
import com.sinch.sdk.domains.voice.models.v2.calls.request.CallPatchRequestDtoTest;
import com.sinch.sdk.domains.voice.models.v2.calls.request.ListCallsQueryParameters;
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallQueryParameters;
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallRequestDtoTest;
import com.sinch.sdk.domains.voice.models.v2.calls.response.CallsListResponse;
import com.sinch.sdk.domains.voice.models.v2.calls.response.StartCallResponse;
import com.sinch.sdk.domains.voice.models.v2.calls.response.StartCallResponseDtoTest;
import com.sinch.sdk.domains.voice.models.v2.calls.response.internal.CallsListResponseInternalDtoTest;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class CallsServiceTest extends BaseTest {

  @Mock HttpClient httpClient;
  @Mock ServerConfiguration serverConfiguration;
  @Mock Map<String, AuthManager> authManagers;

  static final String PROJECT_ID = "test_project_id";
  static final String CONFIGURED_SERVER_URL = "https://configured.server.com";
  static final Collection<String> AUTH_NAMES = Arrays.asList("BasicAuth", "SinchOAuth2");
  static final Collection<String> ACCEPTS =
      Arrays.asList(HttpContentType.APPLICATION_JSON, "application/problem+json");

  CallsService service;

  @GivenTextResource("/domains/voice/v2/calls/request/StartCallRequestDto.json")
  String jsonStartCallRequestDto;

  @GivenTextResource("/domains/voice/v2/calls/request/CallPatchRequestDto.json")
  String jsonCallPatchRequestDto;

  @GivenTextResource("/domains/voice/v2/calls/response/StartCallResponseDto.json")
  String jsonStartCallResponseDto;

  @GivenTextResource("/domains/voice/v2/CallDto.json")
  String jsonCallDto;

  @GivenTextResource("/domains/voice/v2/calls/response/internal/CallsListResponseInternalDto.json")
  String jsonCallsListResponseDto;

  @GivenTextResource(
      "/domains/voice/v2/calls/response/internal/CallsListResponseInternalLastPageDto.json")
  String jsonCallsListLastPageResponseDto;

  @BeforeEach
  public void initMocks() {
    service =
        new CallsServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), PROJECT_ID);
  }

  @Test
  void start() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v2/projects/" + URLPathUtils.encodePathSegment(PROJECT_ID) + "/calls",
            HttpMethod.POST,
            Collections.singletonList(
                new URLParameter(
                    "serviceId", "6e124178-c29d-46a5-943c-5c2ae544aade", URLParameter.form, true)),
            jsonStartCallRequestDto,
            Collections.singletonMap(
                "Idempotency-Key",
                StartCallRequestDtoTest.expectedStartCallRequest.getIdempotencyKey()),
            ACCEPTS,
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(201, null, Collections.emptyMap(), jsonStartCallResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    StartCallResponse response =
        service.start(
            StartCallQueryParameters.builder()
                .setServiceId("6e124178-c29d-46a5-943c-5c2ae544aade")
                .build(),
            StartCallRequestDtoTest.expectedStartCallRequest);

    TestHelpers.recursiveEquals(response, StartCallResponseDtoTest.expectedStartCallResponse);
  }

  @Test
  void startMissingRequestThrows() {

    ApiException thrown = Assertions.assertThrows(ApiException.class, () -> service.start(null));

    Assertions.assertEquals(400, thrown.getCode());
  }

  @Test
  void startMissingProjectIdThrows() {

    CallsService serviceWithoutProjectId =
        new CallsServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), null);

    ApiException thrown =
        Assertions.assertThrows(
            ApiException.class,
            () -> serviceWithoutProjectId.start(StartCallRequestDtoTest.expectedStartCallRequest));

    Assertions.assertEquals(400, thrown.getCode());
  }

  @Test
  void get() throws ApiException {

    String callId = "01ARZ3NDEKTSV4RRFFQ69G5FAA";
    HttpRequest httpRequest =
        new HttpRequest(
            "/v2/projects/"
                + URLPathUtils.encodePathSegment(PROJECT_ID)
                + "/calls/"
                + URLPathUtils.encodePathSegment(callId),
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            ACCEPTS,
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonCallDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    Call response = service.get(callId);

    TestHelpers.recursiveEquals(response, CallDtoTest.expectedCall);
  }

  @Test
  void getMissingCallIdThrows() {

    ApiException thrown = Assertions.assertThrows(ApiException.class, () -> service.get(null));

    Assertions.assertEquals(400, thrown.getCode());
  }

  @Test
  void getMissingProjectIdThrows() {

    CallsService serviceWithoutProjectId =
        new CallsServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), null);

    ApiException thrown =
        Assertions.assertThrows(
            ApiException.class, () -> serviceWithoutProjectId.get("01ARZ3NDEKTSV4RRFFQ69G5FAA"));

    Assertions.assertEquals(400, thrown.getCode());
  }

  @Test
  void list() throws ApiException {

    List<URLParameter> commonParameters =
        Arrays.asList(
            new URLParameter(
                "serviceId", "6e124178-c29d-46a5-943c-5c2ae544aade", URLParameter.form, true),
            new URLParameter("from", "+15551234567", URLParameter.form, true),
            new URLParameter("to", "+15551234568", URLParameter.form, true),
            new URLParameter("callType", CallType.PHONE, URLParameter.form, true),
            new URLParameter("startTime", "2025-02-01T14:00:00Z", URLParameter.form, true),
            new URLParameter("endTime", "2025-03-01T14:00:00Z", URLParameter.form, true),
            new URLParameter("callResult", CallResult.COMPLETED, URLParameter.form, true),
            new URLParameter("callReason", CallReason.CALLEE_HANGUP, URLParameter.form, true),
            new URLParameter("pageSize", 2, URLParameter.form, true));

    List<URLParameter> urlParameters = new ArrayList<>(commonParameters);
    urlParameters.add(new URLParameter("page", 1, URLParameter.form, true));

    mockListPage(urlParameters, jsonCallsListResponseDto);
    mockNextListPage(jsonCallsListLastPageResponseDto);

    ListCallsQueryParameters queryParameters =
        ListCallsQueryParameters.builder()
            .setServiceId("6e124178-c29d-46a5-943c-5c2ae544aade")
            .setFrom("+15551234567")
            .setTo("+15551234568")
            .setCallType(CallType.PHONE)
            .setStartTime(Instant.parse("2025-02-01T14:00:00Z"))
            .setEndTime(Instant.parse("2025-03-01T14:00:00Z"))
            .setCallResult(CallResult.COMPLETED)
            .setCallReason(CallReason.CALLEE_HANGUP)
            .setPageSize(2)
            .setPage(1)
            .build();

    CallsListResponse response = service.list(queryParameters);

    TestHelpers.recursiveEquals(
        new ArrayList<>(response.getContent()),
        new ArrayList<>(CallsListResponseInternalDtoTest.expectedCallsListResponse.getCalls()));
    Assertions.assertTrue(response.hasNextPage());

    CallsListResponse nextResponse = response.nextPage();

    TestHelpers.recursiveEquals(
        new ArrayList<>(nextResponse.getContent()),
        new ArrayList<>(
            CallsListResponseInternalDtoTest.expectedCallsListLastPageResponse.getCalls()));
    Assertions.assertFalse(nextResponse.hasNextPage());
  }

  @Test
  void listIteratesOverAllPages() throws ApiException {

    mockListPage(Collections.emptyList(), jsonCallsListResponseDto);
    mockNextListPage(jsonCallsListLastPageResponseDto);

    CallsListResponse response = service.list();

    List<Call> calls = new ArrayList<>();
    response.iterator().forEachRemaining(calls::add);

    List<Call> expected =
        new ArrayList<>(CallsListResponseInternalDtoTest.expectedCallsListResponse.getCalls());
    expected.addAll(CallsListResponseInternalDtoTest.expectedCallsListLastPageResponse.getCalls());
    TestHelpers.recursiveEquals(calls, expected);
  }

  @Test
  void listMissingProjectIdThrows() {

    CallsService serviceWithoutProjectId =
        new CallsServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), null);

    ApiException thrown =
        Assertions.assertThrows(ApiException.class, () -> serviceWithoutProjectId.list());

    Assertions.assertEquals(400, thrown.getCode());
  }

  // The "next" link served by the fixture targets https://voice.api.sinch.com: its path and query
  // are expected to be sent to the configured server instead
  private void mockNextListPage(String jsonResponse) {
    when(serverConfiguration.getUrl()).thenReturn(CONFIGURED_SERVER_URL);

    HttpRequest httpRequest =
        new HttpRequest(
            CONFIGURED_SERVER_URL
                + "/v2/projects/5c5bf2b1-35ae-4825-ab89-457e07bb60e6/calls?page=2&pageSize=2",
            HttpMethod.GET,
            (String) null,
            Collections.emptyMap(),
            ACCEPTS,
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonResponse.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);
  }

  private void mockListPage(List<URLParameter> urlParameters, String jsonResponse) {
    HttpRequest httpRequest =
        new HttpRequest(
            "/v2/projects/" + URLPathUtils.encodePathSegment(PROJECT_ID) + "/calls",
            HttpMethod.GET,
            urlParameters,
            (String) null,
            Collections.emptyMap(),
            ACCEPTS,
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonResponse.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);
  }

  @Test
  void interactByCallId() throws ApiException {

    String callId = "01ARZ3NDEKTSV4RRFFQ69G5FAA";
    HttpRequest httpRequest =
        new HttpRequest(
            "/v2/projects/"
                + URLPathUtils.encodePathSegment(PROJECT_ID)
                + "/calls/"
                + URLPathUtils.encodePathSegment(callId),
            HttpMethod.PATCH,
            Collections.emptyList(),
            jsonCallPatchRequestDto,
            Collections.singletonMap(
                "Idempotency-Key",
                CallPatchRequestDtoTest.expectedCallPatchRequest.getIdempotencyKey()),
            ACCEPTS,
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse = new HttpResponse(202, null, Collections.emptyMap(), null);

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    service.interactByCallId(callId, CallPatchRequestDtoTest.expectedCallPatchRequest);

    verify(httpClient)
        .invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest)));
  }

  @Test
  void interactByCallIdMissingCallIdThrows() {

    ApiException thrown =
        Assertions.assertThrows(
            ApiException.class,
            () -> service.interactByCallId(null, CallPatchRequestDtoTest.expectedCallPatchRequest));

    Assertions.assertEquals(400, thrown.getCode());
  }

  @Test
  void interactByCallIdMissingRequestThrows() {

    ApiException thrown =
        Assertions.assertThrows(
            ApiException.class, () -> service.interactByCallId("01ARZ3NDEKTSV4RRFFQ69G5FAA", null));

    Assertions.assertEquals(400, thrown.getCode());
  }

  @Test
  void interactByCallIdMissingProjectIdThrows() {

    CallsService serviceWithoutProjectId =
        new CallsServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), null);

    ApiException thrown =
        Assertions.assertThrows(
            ApiException.class,
            () ->
                serviceWithoutProjectId.interactByCallId(
                    "01ARZ3NDEKTSV4RRFFQ69G5FAA",
                    CallPatchRequestDtoTest.expectedCallPatchRequest));

    Assertions.assertEquals(400, thrown.getCode());
  }
}
