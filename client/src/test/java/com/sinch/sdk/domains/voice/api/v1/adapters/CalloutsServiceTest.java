package com.sinch.sdk.domains.voice.api.v1.adapters;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
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
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.voice.adapters.VoiceBaseTest;
import com.sinch.sdk.domains.voice.api.v1.CalloutsService;
import com.sinch.sdk.domains.voice.models.v1.callouts.CalloutRequestDtoTest;
import com.sinch.sdk.domains.voice.models.v1.callouts.CalloutResponseDtoTest;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class CalloutsServiceTest extends VoiceBaseTest {

  @GivenTextResource("/domains/voice/v1/callouts/CalloutResponseDto.json")
  String calloutResponseDto;

  @GivenTextResource("/domains/voice/v1/callouts/CalloutRequestConferenceDto.json")
  String calloutRequestConferenceDto;

  @GivenTextResource("/domains/voice/v1/callouts/CalloutRequestTtsDto.json")
  String calloutRequestTtsDto;

  @GivenTextResource("/domains/voice/v1/callouts/CalloutRequestCustomDto.json")
  String calloutRequestCustomDto;

  static final Collection<String> AUTH_NAMES = Arrays.asList("Basic", "Signed");

  @Mock ServerConfiguration serverConfiguration;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  CalloutsService service;

  @BeforeEach
  public void initMocks() {
    service =
        new CalloutsServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance());
  }

  @Test
  void conference() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/calling/v1/callouts",
            HttpMethod.POST,
            Collections.emptyList(),
            calloutRequestConferenceDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), calloutResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    String response = service.conference(CalloutRequestDtoTest.conferenceRequestCalloutDto);

    TestHelpers.recursiveEquals(
        response, CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
  }

  @Test
  void textToSpeech() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/calling/v1/callouts",
            HttpMethod.POST,
            Collections.emptyList(),
            calloutRequestTtsDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), calloutResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    String response = service.textToSpeech(CalloutRequestDtoTest.ttsRequestDto);

    TestHelpers.recursiveEquals(
        response, CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
  }

  @Test
  void custom() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/calling/v1/callouts",
            HttpMethod.POST,
            Collections.emptyList(),
            calloutRequestCustomDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), calloutResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    String response = service.custom(CalloutRequestDtoTest.customRequestDto);

    TestHelpers.recursiveEquals(
        response, CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
  }

  @Test
  void call() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/calling/v1/callouts",
            HttpMethod.POST,
            Collections.emptyList(),
            calloutRequestCustomDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), calloutResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    String response = service.call(CalloutRequestDtoTest.customRequestDto);

    TestHelpers.recursiveEquals(
        response, CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
  }
}
