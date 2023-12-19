package com.sinch.sdk.domains.voice.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.voice.adapters.api.v1.CalloutsApi;
import com.sinch.sdk.domains.voice.models.dto.v1.CalloutRequestDtoTest;
import com.sinch.sdk.domains.voice.models.dto.v1.CalloutResponseDtoTest;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersConferenceTest;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersCustomTest;
import com.sinch.sdk.domains.voice.models.requests.CalloutRequestParametersTTSTest;
import com.sinch.sdk.models.Configuration;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class CalloutsServiceTest extends BaseTest {

  @Mock CalloutsApi api;
  @Mock Configuration configuration;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;

  CalloutsService service;

  @BeforeEach
  public void initMocks() {
    service = spy(new CalloutsService(configuration, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void callConference() throws ApiException {

    when(api.callouts(eq(CalloutRequestDtoTest.conferenceRequestCalloutDto)))
        .thenReturn(CalloutResponseDtoTest.expectedCalloutResponseDto);

    String response =
        service.call(CalloutRequestParametersConferenceTest.conferenceRequestParameters);

    Assertions.assertThat(response)
        .isEqualTo(CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
  }

  @Test
  void callTTS() throws ApiException {

    when(api.callouts(eq(CalloutRequestDtoTest.ttsRequestDto)))
        .thenReturn(CalloutResponseDtoTest.expectedCalloutResponseDto);

    String response = service.call(CalloutRequestParametersTTSTest.ttsRequestParameters);

    Assertions.assertThat(response)
        .isEqualTo(CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
  }

  @Test
  void callCustom() throws ApiException {

    when(api.callouts(eq(CalloutRequestDtoTest.customRequestDto)))
        .thenReturn(CalloutResponseDtoTest.expectedCalloutResponseDto);

    String response = service.call(CalloutRequestParametersCustomTest.customRequestParameters);

    Assertions.assertThat(response)
        .isEqualTo(CalloutResponseDtoTest.expectedCalloutResponseDto.getCallId());
  }
}
