package com.sinch.sdk.domains.voice.adapters;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersConferenceTest;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersCustomTest;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersTTSTest;
import com.sinch.sdk.domains.voice.models.v1.callouts.CalloutResponseDtoTest;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequest;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestConference;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestCustom;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.CalloutRequestTTS;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class CalloutsServiceTest extends VoiceBaseTest {

  @Mock com.sinch.sdk.domains.voice.api.v1.CalloutsService v1;
  CalloutsService service;

  @BeforeEach
  public void initMocks() {
    service = spy(new CalloutsService(v1));
  }

  @Test
  void conference() throws ApiException {

    when(v1.conference(any(CalloutRequestConference.class)))
        .thenReturn(CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());

    String response =
        service.conference(CalloutRequestParametersConferenceTest.conferenceRequestParameters);

    Assertions.assertThat(response)
        .isEqualTo(CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
  }

  @Test
  void textToSpeech() throws ApiException {

    when(v1.textToSpeech(any(CalloutRequestTTS.class)))
        .thenReturn(CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());

    String response = service.textToSpeech(CalloutRequestParametersTTSTest.ttsRequestParameters);

    Assertions.assertThat(response)
        .isEqualTo(CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
  }

  @Test
  void custom() throws ApiException {

    when(v1.custom(any(CalloutRequestCustom.class)))
        .thenReturn(CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());

    String response = service.custom(CalloutRequestParametersCustomTest.customRequestParameters);

    Assertions.assertThat(response)
        .isEqualTo(CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
  }

  @Test
  void call() throws ApiException {

    when(v1.call(any(CalloutRequest.class)))
        .thenReturn(CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());

    String response = service.call(CalloutRequestParametersCustomTest.customRequestParameters);

    Assertions.assertThat(response)
        .isEqualTo(CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
  }
}
