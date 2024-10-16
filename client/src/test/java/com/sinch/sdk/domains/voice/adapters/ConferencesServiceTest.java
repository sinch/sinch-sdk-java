package com.sinch.sdk.domains.voice.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.voice.adapters.converters.ConferencesDtoConverterTest;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersConferenceTest;
import com.sinch.sdk.domains.voice.models.requests.ConferenceManageParticipantRequestParametersTest;
import com.sinch.sdk.domains.voice.models.response.ConferenceParticipant;
import com.sinch.sdk.domains.voice.models.v1.callouts.CalloutRequestDtoTest;
import com.sinch.sdk.domains.voice.models.v1.callouts.CalloutResponseDtoTest;
import com.sinch.sdk.domains.voice.models.v1.conferences.request.ConferencesRequestDtoTest;
import com.sinch.sdk.domains.voice.models.v1.conferences.request.ManageConferenceParticipantRequest;
import com.sinch.sdk.domains.voice.models.v1.conferences.response.ConferencesResponseDtoTest;
import java.util.Collection;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;

@TestWithResources
public class ConferencesServiceTest extends BaseTest {

  @Mock com.sinch.sdk.domains.voice.api.v1.ConferencesService v1;

  @Captor ArgumentCaptor<String> conferenceIdCaptor;
  @Captor ArgumentCaptor<String> callIdCaptor;
  @Captor ArgumentCaptor<ManageConferenceParticipantRequest> participantCaptor;
  ConferencesService service;

  @BeforeEach
  public void initMocks() {
    service = spy(new ConferencesService(v1));
  }

  @Test
  void call() throws ApiException {

    when(v1.call(eq(CalloutRequestDtoTest.conferenceRequestCalloutDto)))
        .thenReturn(CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());

    String response =
        service.call(CalloutRequestParametersConferenceTest.conferenceRequestParameters);

    Assertions.assertThat(response)
        .isEqualTo(CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
  }

  @Test
  void get() throws ApiException {

    when(v1.get(eq(CalloutRequestDtoTest.conferenceRequestCalloutDto.getConferenceId())))
        .thenReturn(ConferencesResponseDtoTest.expectedGetConferenceInfoResponseDto);

    Collection<ConferenceParticipant> response =
        service.get(CalloutRequestDtoTest.conferenceRequestCalloutDto.getConferenceId());

    TestHelpers.recursiveEquals(
        response, ConferencesDtoConverterTest.expectedConferenceGetInfoResponse);
  }

  @Test
  void kickParticipant() throws ApiException {
    service.kickParticipant(
        CalloutRequestDtoTest.conferenceRequestCalloutDto.getConferenceId(),
        CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
    verify(v1).kickParticipant(conferenceIdCaptor.capture(), callIdCaptor.capture());

    String parameter = callIdCaptor.getValue();
    Assertions.assertThat(parameter)
        .isEqualTo(CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
    parameter = conferenceIdCaptor.getValue();
    Assertions.assertThat(parameter)
        .isEqualTo(CalloutRequestDtoTest.conferenceRequestCalloutDto.getConferenceId());
  }

  @Test
  void kickAll() throws ApiException {

    service.kickAll(CalloutRequestDtoTest.conferenceRequestCalloutDto.getConferenceId());
    verify(v1).kickAll(conferenceIdCaptor.capture());

    String parameter = conferenceIdCaptor.getValue();
    Assertions.assertThat(parameter)
        .isEqualTo(CalloutRequestDtoTest.conferenceRequestCalloutDto.getConferenceId());
  }

  @Test
  void manageParticipant() throws ApiException {

    service.manageParticipant(
        CalloutRequestDtoTest.conferenceRequestCalloutDto.getConferenceId(),
        CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId(),
        ConferenceManageParticipantRequestParametersTest
            .conferenceManageParticipantRequestParameters);

    verify(v1)
        .manageParticipant(
            conferenceIdCaptor.capture(), callIdCaptor.capture(), participantCaptor.capture());

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
