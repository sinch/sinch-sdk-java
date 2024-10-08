package com.sinch.sdk.domains.voice.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.voice.adapters.api.v1.ConferencesApi;
import com.sinch.sdk.domains.voice.adapters.converters.ConferencesDtoConverterTest;
import com.sinch.sdk.domains.voice.models.dto.v1.ManageConferenceParticipantRequestDto;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersConferenceTest;
import com.sinch.sdk.domains.voice.models.requests.ConferenceManageParticipantRequestParametersTest;
import com.sinch.sdk.domains.voice.models.response.ConferenceParticipant;
import com.sinch.sdk.domains.voice.models.v1.callouts.CalloutRequestDtoTest;
import com.sinch.sdk.domains.voice.models.v1.callouts.CalloutResponseDtoTest;
import com.sinch.sdk.domains.voice.models.v1.conferences.ConferencesRequestDtoTest;
import com.sinch.sdk.domains.voice.models.v1.conferences.ConferencesResponseDtoTest;
import com.sinch.sdk.models.VoiceContext;
import java.util.Collection;
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

  @Captor ArgumentCaptor<String> conferenceIdCaptor;
  @Captor ArgumentCaptor<String> callIdCaptor;
  @Captor ArgumentCaptor<ManageConferenceParticipantRequestDto> participantCaptor;
  ConferencesService service;

  @BeforeEach
  public void initMocks() {
    service = spy(new ConferencesService(context, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void call() throws ApiException {

    when(api.callouts(eq(CalloutRequestDtoTest.conferenceRequestCalloutDto)))
        .thenReturn(CalloutResponseDtoTest.expectedCalloutResponseDto);

    String response =
        service.call(CalloutRequestParametersConferenceTest.conferenceRequestParameters);

    Assertions.assertThat(response)
        .isEqualTo(CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
  }

  @Test
  void get() throws ApiException {

    when(api.callingGetConferenceInfo(
            eq(
                CalloutRequestDtoTest.conferenceRequestCalloutDto
                    .getConferenceCallout()
                    .getConferenceId())))
        .thenReturn(ConferencesResponseDtoTest.expectedGetConferenceInfoResponseDto);

    Collection<ConferenceParticipant> response =
        service.get(
            CalloutRequestDtoTest.conferenceRequestCalloutDto
                .getConferenceCallout()
                .getConferenceId());

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(ConferencesDtoConverterTest.expectedConferenceGetInfoResponse);
  }

  @Test
  void kickParticipant() throws ApiException {

    service.kickParticipant(
        CalloutRequestDtoTest.conferenceRequestCalloutDto.getConferenceCallout().getConferenceId(),
        CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
    verify(api)
        .callingKickConferenceParticipant(callIdCaptor.capture(), conferenceIdCaptor.capture());

    String parameter = callIdCaptor.getValue();
    Assertions.assertThat(parameter)
        .isEqualTo(CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
    parameter = conferenceIdCaptor.getValue();
    Assertions.assertThat(parameter)
        .isEqualTo(
            CalloutRequestDtoTest.conferenceRequestCalloutDto
                .getConferenceCallout()
                .getConferenceId());
  }

  @Test
  void kickAll() throws ApiException {

    service.kickAll(
        CalloutRequestDtoTest.conferenceRequestCalloutDto.getConferenceCallout().getConferenceId());
    verify(api).callingKickConferenceAll(conferenceIdCaptor.capture());

    String parameter = conferenceIdCaptor.getValue();
    Assertions.assertThat(parameter)
        .isEqualTo(
            CalloutRequestDtoTest.conferenceRequestCalloutDto
                .getConferenceCallout()
                .getConferenceId());
  }

  @Test
  void manageParticipant() throws ApiException {

    service.manageParticipant(
        CalloutRequestDtoTest.conferenceRequestCalloutDto.getConferenceCallout().getConferenceId(),
        CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId(),
        ConferenceManageParticipantRequestParametersTest
            .conferenceManageParticipantRequestParameters);

    verify(api)
        .callingManageConferenceParticipant(
            callIdCaptor.capture(), conferenceIdCaptor.capture(), participantCaptor.capture());

    String parameter = callIdCaptor.getValue();
    Assertions.assertThat(parameter)
        .isEqualTo(CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
    parameter = conferenceIdCaptor.getValue();
    Assertions.assertThat(parameter)
        .isEqualTo(
            CalloutRequestDtoTest.conferenceRequestCalloutDto
                .getConferenceCallout()
                .getConferenceId());

    ManageConferenceParticipantRequestDto participant = participantCaptor.getValue();
    Assertions.assertThat(participant)
        .isEqualTo(ConferencesRequestDtoTest.manageConferenceParticipantRequestDto);
  }
}
