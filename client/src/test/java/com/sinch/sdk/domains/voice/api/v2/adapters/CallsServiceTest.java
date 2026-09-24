package com.sinch.sdk.domains.voice.api.v2.adapters;

import static org.mockito.ArgumentMatchers.any;
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
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallRequest;
import com.sinch.sdk.domains.voice.models.v2.calls.request.StartCallRequestDtoTest;
import com.sinch.sdk.domains.voice.models.v2.calls.response.StartCallResponse;
import com.sinch.sdk.domains.voice.models.v2.calls.response.StartCallResponseDtoTest;
import com.sinch.sdk.domains.voice.models.v2.svaml.DialCommandDtoTest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;

@TestWithResources
public class CallsServiceTest extends BaseTest {

  @Mock HttpClient httpClient;
  @Mock ServerConfiguration serverConfiguration;
  @Mock Map<String, AuthManager> authManagers;

  static final String PROJECT_ID = "test_project_id";
  static final Collection<String> AUTH_NAMES = Arrays.asList("BasicAuth", "SinchOAuth2");
  static final Collection<String> ACCEPTS =
      Arrays.asList(HttpContentType.APPLICATION_JSON, "application/problem+json");

  CallsService service;

  @GivenTextResource("/domains/voice/v2/calls/request/StartCallRequestDto.json")
  String jsonStartCallRequestDto;

  @GivenTextResource("/domains/voice/v2/calls/response/StartCallResponseDto.json")
  String jsonStartCallResponseDto;

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
                    "serviceId",
                    StartCallRequestDtoTest.expectedStartCallRequest.getServiceId(),
                    URLParameter.form,
                    true)),
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

    StartCallResponse response = service.start(StartCallRequestDtoTest.expectedStartCallRequest);

    TestHelpers.recursiveEquals(response, StartCallResponseDtoTest.expectedStartCallResponse);
  }

  @Test
  void startWithoutIdempotencyKeyGeneratesOne() throws ApiException {

    HttpResponse httpResponse =
        new HttpResponse(201, null, Collections.emptyMap(), jsonStartCallResponseDto.getBytes());

    when(httpClient.invokeAPI(eq(serverConfiguration), eq(authManagers), any(HttpRequest.class)))
        .thenReturn(httpResponse);

    StartCallResponse response =
        service.start(
            StartCallRequest.builder()
                .setCommands(Arrays.asList(DialCommandDtoTest.expectedDialCommand))
                .build());

    ArgumentCaptor<HttpRequest> sent = ArgumentCaptor.forClass(HttpRequest.class);
    verify(httpClient).invokeAPI(eq(serverConfiguration), eq(authManagers), sent.capture());

    String idempotencyKey = sent.getValue().getHeaderParams().get("Idempotency-Key");
    Assertions.assertDoesNotThrow(
        () -> UUID.fromString(idempotencyKey), "generated key is not a UUID: " + idempotencyKey);

    HttpRequest expected =
        new HttpRequest(
            "/v2/projects/" + URLPathUtils.encodePathSegment(PROJECT_ID) + "/calls",
            HttpMethod.POST,
            Collections.emptyList(),
            jsonStartCallRequestDto,
            Collections.singletonMap("Idempotency-Key", idempotencyKey),
            ACCEPTS,
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    Assertions.assertTrue(new HttpRequestMatcher(expected).matches(sent.getValue()));

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
}
