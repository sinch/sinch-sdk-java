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
import com.sinch.sdk.domains.voice.adapters.api.v1.CallsApi;
import com.sinch.sdk.domains.voice.adapters.converters.CallsDtoConverterTest;
import com.sinch.sdk.domains.voice.models.dto.v1.CallsResponseDtoTest;
import com.sinch.sdk.domains.voice.models.response.CallInformation;
import com.sinch.sdk.models.Configuration;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class CallServiceTest extends BaseTest {

  @Mock CallsApi api;
  @Mock Configuration configuration;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;

  CallsService service;

  @BeforeEach
  public void initMocks() {
    service = spy(new CallsService(configuration, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void callConference() throws ApiException {

    when(api.callingGetCallResult(
            eq(CallsResponseDtoTest.expectedCallsGetInformationResponseDto.getCallId())))
        .thenReturn(CallsResponseDtoTest.expectedCallsGetInformationResponseDto);

    CallInformation response =
        service.get(CallsResponseDtoTest.expectedCallsGetInformationResponseDto.getCallId());

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(CallsDtoConverterTest.expectedCallInformation);
  }
}
