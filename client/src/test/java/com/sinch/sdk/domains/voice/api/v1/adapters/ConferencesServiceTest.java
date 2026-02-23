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
import com.sinch.sdk.domains.voice.api.v1.ConferencesService;
import com.sinch.sdk.domains.voice.models.v1.callouts.CalloutRequestDtoTest;
import com.sinch.sdk.domains.voice.models.v1.callouts.CalloutResponseDtoTest;
import com.sinch.sdk.domains.voice.models.v1.conferences.request.ConferencesRequestDtoTest;
import com.sinch.sdk.domains.voice.models.v1.conferences.response.ConferencesResponseDtoTest;
import com.sinch.sdk.domains.voice.models.v1.conferences.response.GetConferenceInfoResponse;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class ConferencesServiceTest extends BaseTest {

  @GivenTextResource("/domains/voice/v1/callouts/CalloutResponseDto.json")
  String calloutResponseDto;

  @GivenTextResource("/domains/voice/v1/callouts/CalloutRequestConferenceDto.json")
  String calloutRequestConferenceDto;

  @GivenTextResource("/domains/voice/v1/conferences/response/ConferenceGetResponseDto.json")
  String conferenceGetResponseDto;

  @GivenTextResource(
      "/domains/voice/v1/conferences/request/ConferenceManageParticipantRequestDto.json")
  String conferenceManageParticipantRequestDto;

  static final Collection<String> AUTH_NAMES = Arrays.asList("Basic", "Signed");

  @Mock ServerConfiguration serverConfiguration;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  ConferencesService service;

  @BeforeEach
  public void initMocks() {
    service =
        new ConferencesServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance());
  }

  @Test
  void call() throws ApiException {

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

    String response = service.call(CalloutRequestDtoTest.conferenceRequestCalloutDto);

    TestHelpers.recursiveEquals(
        response, CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
  }

  @Test
  void get() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/calling/v1/conferences/id/"
                + URLPathUtils.encodePathSegment(
                    CalloutRequestDtoTest.conferenceRequestCalloutDto.getConferenceId()),
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), conferenceGetResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    GetConferenceInfoResponse response =
        service.get(CalloutRequestDtoTest.conferenceRequestCalloutDto.getConferenceId());

    TestHelpers.recursiveEquals(
        response, ConferencesResponseDtoTest.expectedGetConferenceInfoResponseDto);
  }

  @Test
  void kickParticipant() throws ApiException {
    HttpRequest httpRequest =
        new HttpRequest(
            "/calling/v1/conferences/id/"
                + URLPathUtils.encodePathSegment(
                    CalloutRequestDtoTest.conferenceRequestCalloutDto.getConferenceId())
                + "/"
                + URLPathUtils.encodePathSegment(
                    CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId()),
            HttpMethod.DELETE,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse = new HttpResponse(200, null, Collections.emptyMap(), null);

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    service.kickParticipant(
        CalloutRequestDtoTest.conferenceRequestCalloutDto.getConferenceId(),
        CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
  }

  @Test
  void kickAll() throws ApiException {
    HttpRequest httpRequest =
        new HttpRequest(
            "/calling/v1/conferences/id/"
                + URLPathUtils.encodePathSegment(
                    CalloutRequestDtoTest.conferenceRequestCalloutDto.getConferenceId()),
            HttpMethod.DELETE,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.emptyList(),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse = new HttpResponse(204, null, Collections.emptyMap(), null);

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    service.kickAll(CalloutRequestDtoTest.conferenceRequestCalloutDto.getConferenceId());
  }

  @Test
  void manageParticipant() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/calling/v1/conferences/id/"
                + URLPathUtils.encodePathSegment(
                    CalloutRequestDtoTest.conferenceRequestCalloutDto.getConferenceId())
                + "/"
                + URLPathUtils.encodePathSegment(
                    CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId()),
            HttpMethod.PATCH,
            Collections.emptyList(),
            conferenceManageParticipantRequestDto,
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

    service.manageParticipant(
        CalloutRequestDtoTest.conferenceRequestCalloutDto.getConferenceId(),
        CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId(),
        ConferencesRequestDtoTest.manageConferenceParticipantRequestDto);
  }
}
