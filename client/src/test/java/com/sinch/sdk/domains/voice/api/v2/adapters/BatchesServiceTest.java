package com.sinch.sdk.domains.voice.api.v2.adapters;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
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
import com.sinch.sdk.domains.voice.api.v2.BatchesService;
import com.sinch.sdk.domains.voice.models.v2.batches.request.StartBatchQueryParameters;
import com.sinch.sdk.domains.voice.models.v2.batches.request.StartBatchRequestDtoTest;
import com.sinch.sdk.domains.voice.models.v2.batches.response.BatchDetails;
import com.sinch.sdk.domains.voice.models.v2.batches.response.BatchDetailsDtoTest;
import com.sinch.sdk.domains.voice.models.v2.batches.response.BatchStopResponse;
import com.sinch.sdk.domains.voice.models.v2.batches.response.BatchStopResponseDtoTest;
import com.sinch.sdk.domains.voice.models.v2.batches.response.BatchSummary;
import com.sinch.sdk.domains.voice.models.v2.batches.response.BatchSummaryDtoTest;
import com.sinch.sdk.domains.voice.models.v2.batches.response.StartBatchResponse;
import com.sinch.sdk.domains.voice.models.v2.batches.response.StartBatchResponseDtoTest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class BatchesServiceTest extends BaseTest {

  @Mock HttpClient httpClient;
  @Mock ServerConfiguration serverConfiguration;
  @Mock Map<String, AuthManager> authManagers;

  static final String PROJECT_ID = "test_project_id";
  static final String BATCH_ID = "01BX5ZZKBKACTAV9WEVGEMMVRC";
  static final Collection<String> AUTH_NAMES = Arrays.asList("BasicAuth", "SinchOAuth2");
  static final Collection<String> ACCEPTS =
      Arrays.asList(HttpContentType.APPLICATION_JSON, "application/problem+json");

  BatchesService service;

  @GivenTextResource("/domains/voice/v2/batches/request/StartBatchRequestDto.json")
  String jsonStartBatchRequestDto;

  @GivenTextResource("/domains/voice/v2/batches/response/StartBatchResponseDto.json")
  String jsonStartBatchResponseDto;

  @GivenTextResource("/domains/voice/v2/batches/response/BatchSummaryDto.json")
  String jsonBatchSummaryDto;

  @GivenTextResource("/domains/voice/v2/batches/response/BatchDetailsDto.json")
  String jsonBatchDetailsDto;

  @GivenTextResource("/domains/voice/v2/batches/response/BatchStopResponseDto.json")
  String jsonBatchStopResponseDto;

  @BeforeEach
  public void initMocks() {
    service =
        new BatchesServiceImpl(
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
            jsonStartBatchRequestDto,
            Collections.singletonMap(
                "Idempotency-Key",
                StartBatchRequestDtoTest.expectedStartBatchRequest.getIdempotencyKey()),
            ACCEPTS,
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(201, null, Collections.emptyMap(), jsonStartBatchResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    StartBatchResponse response =
        service.start(
            StartBatchQueryParameters.builder()
                .setServiceId("6e124178-c29d-46a5-943c-5c2ae544aade")
                .build(),
            StartBatchRequestDtoTest.expectedStartBatchRequest);

    TestHelpers.recursiveEquals(response, StartBatchResponseDtoTest.expectedStartBatchResponse);
  }

  @Test
  void startMissingRequestThrows() {

    ApiException thrown = Assertions.assertThrows(ApiException.class, () -> service.start(null));

    Assertions.assertEquals(400, thrown.getCode());
  }

  @Test
  void startMissingProjectIdThrows() {

    BatchesService serviceWithoutProjectId =
        new BatchesServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), null);

    ApiException thrown =
        Assertions.assertThrows(
            ApiException.class,
            () ->
                serviceWithoutProjectId.start(StartBatchRequestDtoTest.expectedStartBatchRequest));

    Assertions.assertEquals(400, thrown.getCode());
  }

  @Test
  void get() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v2/projects/"
                + URLPathUtils.encodePathSegment(PROJECT_ID)
                + "/batches/"
                + URLPathUtils.encodePathSegment(BATCH_ID),
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            ACCEPTS,
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonBatchSummaryDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    BatchSummary response = service.get(BATCH_ID);

    TestHelpers.recursiveEquals(response, BatchSummaryDtoTest.expectedBatchSummary);
  }

  @Test
  void getMissingBatchIdThrows() {

    ApiException thrown = Assertions.assertThrows(ApiException.class, () -> service.get(null));

    Assertions.assertEquals(400, thrown.getCode());
  }

  @Test
  void getMissingProjectIdThrows() {

    BatchesService serviceWithoutProjectId =
        new BatchesServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), null);

    ApiException thrown =
        Assertions.assertThrows(ApiException.class, () -> serviceWithoutProjectId.get(BATCH_ID));

    Assertions.assertEquals(400, thrown.getCode());
  }

  @Test
  void getDetails() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v2/projects/"
                + URLPathUtils.encodePathSegment(PROJECT_ID)
                + "/batches/"
                + URLPathUtils.encodePathSegment(BATCH_ID)
                + "/details",
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            ACCEPTS,
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonBatchDetailsDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    BatchDetails response = service.getDetails(BATCH_ID);

    TestHelpers.recursiveEquals(response, BatchDetailsDtoTest.expectedBatchDetails);
  }

  @Test
  void getDetailsMissingBatchIdThrows() {

    ApiException thrown =
        Assertions.assertThrows(ApiException.class, () -> service.getDetails(null));

    Assertions.assertEquals(400, thrown.getCode());
  }

  @Test
  void getDetailsMissingProjectIdThrows() {

    BatchesService serviceWithoutProjectId =
        new BatchesServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), null);

    ApiException thrown =
        Assertions.assertThrows(
            ApiException.class, () -> serviceWithoutProjectId.getDetails(BATCH_ID));

    Assertions.assertEquals(400, thrown.getCode());
  }

  @Test
  void stop() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v2/projects/"
                + URLPathUtils.encodePathSegment(PROJECT_ID)
                + "/batches/"
                + URLPathUtils.encodePathSegment(BATCH_ID),
            HttpMethod.DELETE,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            ACCEPTS,
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(202, null, Collections.emptyMap(), jsonBatchStopResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    BatchStopResponse response = service.stop(BATCH_ID);

    TestHelpers.recursiveEquals(response, BatchStopResponseDtoTest.expectedBatchStopResponse);
  }

  @Test
  void stopMissingBatchIdThrows() {

    ApiException thrown = Assertions.assertThrows(ApiException.class, () -> service.stop(null));

    Assertions.assertEquals(400, thrown.getCode());
  }

  @Test
  void stopMissingProjectIdThrows() {

    BatchesService serviceWithoutProjectId =
        new BatchesServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance(), null);

    ApiException thrown =
        Assertions.assertThrows(ApiException.class, () -> serviceWithoutProjectId.stop(BATCH_ID));

    Assertions.assertEquals(400, thrown.getCode());
  }
}
