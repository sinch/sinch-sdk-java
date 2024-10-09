package com.sinch.sdk.domains.voice.api.v1.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.voice.api.v1.internal.CalloutsApi;
import com.sinch.sdk.domains.voice.models.v1.callouts.CalloutRequestDtoTest;
import com.sinch.sdk.domains.voice.models.v1.callouts.CalloutResponseDtoTest;
import com.sinch.sdk.domains.voice.models.v1.callouts.request.internal.CalloutRequestInternalImpl;
import com.sinch.sdk.models.VoiceContext;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class CalloutsServiceTest extends BaseTest {

  @Mock CalloutsApi api;
  @Mock VoiceContext context;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;

  CalloutsService service;

  @BeforeEach
  public void initMocks() {
    service = spy(new CalloutsService(context, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void conference() throws ApiException {

    CalloutRequestInternalImpl request = new CalloutRequestInternalImpl();
    request.setActualInstance(CalloutRequestDtoTest.conferenceRequestCalloutDto);

    when(api.callouts(eq(request))).thenReturn(CalloutResponseDtoTest.expectedCalloutResponseDto);

    String response = service.conference(CalloutRequestDtoTest.conferenceRequestCalloutDto);

    Assertions.assertThat(response)
        .isEqualTo(CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
  }

  @Test
  void textToSpeech() throws ApiException {

    CalloutRequestInternalImpl request = new CalloutRequestInternalImpl();
    request.setActualInstance(CalloutRequestDtoTest.ttsRequestDto);

    when(api.callouts(eq(request))).thenReturn(CalloutResponseDtoTest.expectedCalloutResponseDto);

    String response = service.textToSpeech(CalloutRequestDtoTest.ttsRequestDto);

    Assertions.assertThat(response)
        .isEqualTo(CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
  }

  @Test
  void custom() throws ApiException {

    CalloutRequestInternalImpl request = new CalloutRequestInternalImpl();
    request.setActualInstance(CalloutRequestDtoTest.customRequestDto);

    when(api.callouts(eq(request))).thenReturn(CalloutResponseDtoTest.expectedCalloutResponseDto);

    String response = service.custom(CalloutRequestDtoTest.customRequestDto);

    Assertions.assertThat(response)
        .isEqualTo(CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
  }

  @Test
  void call() throws ApiException {

    CalloutRequestInternalImpl request = new CalloutRequestInternalImpl();
    request.setActualInstance(CalloutRequestDtoTest.customRequestDto);

    when(api.callouts(eq(request))).thenReturn(CalloutResponseDtoTest.expectedCalloutResponseDto);

    String response = service.call(CalloutRequestDtoTest.customRequestDto);

    Assertions.assertThat(response)
        .isEqualTo(CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
  }
}
