package com.sinch.sdk.domains.voice.api.v1.adapters;

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
import com.sinch.sdk.core.http.URLPathUtils;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.voice.api.v1.CallsService;
import com.sinch.sdk.domains.voice.models.v1.calls.CallInformationTest;
import com.sinch.sdk.domains.voice.models.v1.calls.request.CallLeg;
import com.sinch.sdk.domains.voice.models.v1.calls.response.CallInformation;
import com.sinch.sdk.domains.voice.models.v1.svaml.SvamlControlTest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class CallsServiceTest extends BaseTest {

  @GivenTextResource("/domains/voice/v1/calls/GetCallInformationResponseDto.json")
  String getCallInformationResponseDto;

  @GivenTextResource("/domains/voice/v1/svaml/SvamlControlDto.json")
  String svamlControlDto;

  static final Collection<String> AUTH_NAMES = Arrays.asList("Basic", "Signed");

  @Mock ServerConfiguration serverConfiguration;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  CallsService service;

  @BeforeEach
  public void initMocks() {
    service =
        new CallsServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance());
  }

  @Test
  void get() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/calling/v1/calls/id/"
                + URLPathUtils.encodePathSegment(
                    CallInformationTest.expectedCallsGetInformationResponseDto.getCallId()),
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), getCallInformationResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    CallInformation response =
        service.get(CallInformationTest.expectedCallsGetInformationResponseDto.getCallId());

    TestHelpers.recursiveEquals(
        response, CallInformationTest.expectedCallsGetInformationResponseDto);
  }

  @Test
  void update() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/calling/v1/calls/id/" + URLPathUtils.encodePathSegment("call/id"),
            HttpMethod.PATCH,
            Collections.emptyList(),
            svamlControlDto,
            Collections.emptyMap(),
            Collections.emptyList(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse = new HttpResponse(204, null, Collections.emptyMap(), null);

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    service.update("call/id", SvamlControlTest.expectedSvamlControl);
  }

  @Test
  void manageWithCallLeg() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/calling/v1/calls/id/" + URLPathUtils.encodePathSegment("call/id") + "/leg/both",
            HttpMethod.PATCH,
            Collections.emptyList(),
            svamlControlDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse = new HttpResponse(200, null, Collections.emptyMap(), null);

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    service.manageWithCallLeg("call/id", CallLeg.BOTH, SvamlControlTest.expectedSvamlControl);
  }
}
