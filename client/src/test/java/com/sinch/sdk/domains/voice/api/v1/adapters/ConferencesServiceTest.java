package com.sinch.sdk.domains.voice.api.v1.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.voice.api.v1.internal.ConferencesApi;
import com.sinch.sdk.domains.voice.models.v1.callouts.CalloutRequestDtoTest;
import com.sinch.sdk.domains.voice.models.v1.callouts.CalloutResponseDtoTest;
import com.sinch.sdk.domains.voice.models.v1.conferences.request.ConferencesRequestDtoTest;
import com.sinch.sdk.domains.voice.models.v1.conferences.request.ManageConferenceParticipantRequest;
import com.sinch.sdk.domains.voice.models.v1.conferences.response.ConferencesResponseDtoTest;
import com.sinch.sdk.domains.voice.models.v1.conferences.response.GetConferenceInfoResponse;
import com.sinch.sdk.models.VoiceContext;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;

@TestWithResources
public class ConferencesServiceTest extends BaseTest {

  @Mock ConferencesApi api;
  @Mock VoiceContext context;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  @Mock CalloutsService calloutsService;
  @Captor ArgumentCaptor<String> conferenceIdCaptor;
  @Captor ArgumentCaptor<String> callIdCaptor;
  @Captor ArgumentCaptor<ManageConferenceParticipantRequest> participantCaptor;
  static ConferencesService service;

  @BeforeEach
  public void initMocks() {
    service = spy(new ConferencesService(context, httpClient, authManagers, calloutsService));
  }

  @Test
  void call() throws ApiException {

    when(calloutsService.conference(eq(CalloutRequestDtoTest.conferenceRequestCalloutDto)))
        .thenReturn(CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());

    String response = service.call(CalloutRequestDtoTest.conferenceRequestCalloutDto);

    TestHelpers.recursiveEquals(
        response, CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
  }

  @Test
  void get() throws ApiException {
    doReturn(api).when(service).getApi();

    when(api.callingGetConferenceInfo(
            eq(CalloutRequestDtoTest.conferenceRequestCalloutDto.getConferenceId())))
        .thenReturn(ConferencesResponseDtoTest.expectedGetConferenceInfoResponseDto);

    GetConferenceInfoResponse response =
        service.get(CalloutRequestDtoTest.conferenceRequestCalloutDto.getConferenceId());

    TestHelpers.recursiveEquals(
        response, ConferencesResponseDtoTest.expectedGetConferenceInfoResponseDto);
  }

  @Test
  void kickParticipant() throws ApiException {
    doReturn(api).when(service).getApi();
    service.kickParticipant(
        CalloutRequestDtoTest.conferenceRequestCalloutDto.getConferenceId(),
        CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
    verify(api)
        .callingKickConferenceParticipant(callIdCaptor.capture(), conferenceIdCaptor.capture());

    String parameter = callIdCaptor.getValue();
    Assertions.assertThat(parameter)
        .isEqualTo(CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
    parameter = conferenceIdCaptor.getValue();
    Assertions.assertThat(parameter)
        .isEqualTo(CalloutRequestDtoTest.conferenceRequestCalloutDto.getConferenceId());
  }

  @Test
  void kickAll() throws ApiException {
    doReturn(api).when(service).getApi();

    service.kickAll(CalloutRequestDtoTest.conferenceRequestCalloutDto.getConferenceId());
    verify(api).callingKickConferenceAll(conferenceIdCaptor.capture());

    String parameter = conferenceIdCaptor.getValue();
    Assertions.assertThat(parameter)
        .isEqualTo(CalloutRequestDtoTest.conferenceRequestCalloutDto.getConferenceId());
  }

  @Test
  void manageParticipant() throws ApiException {

    doReturn(api).when(service).getApi();

    service.manageParticipant(
        CalloutRequestDtoTest.conferenceRequestCalloutDto.getConferenceId(),
        CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId(),
        ConferencesRequestDtoTest.manageConferenceParticipantRequestDto);

    verify(api)
        .callingManageConferenceParticipant(
            callIdCaptor.capture(), conferenceIdCaptor.capture(), participantCaptor.capture());

    String parameter = callIdCaptor.getValue();
    Assertions.assertThat(parameter)
        .isEqualTo(CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
    parameter = conferenceIdCaptor.getValue();
    Assertions.assertThat(parameter)
        .isEqualTo(CalloutRequestDtoTest.conferenceRequestCalloutDto.getConferenceId());

    ManageConferenceParticipantRequest participant = participantCaptor.getValue();
    Assertions.assertThat(participant)
        .isEqualTo(ConferencesRequestDtoTest.manageConferenceParticipantRequestDto);
  }
}
