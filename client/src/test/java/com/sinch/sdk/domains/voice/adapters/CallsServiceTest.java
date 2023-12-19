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
import com.sinch.sdk.domains.voice.adapters.api.v1.CallsApi;
import com.sinch.sdk.domains.voice.adapters.converters.CallsDtoConverterTest;
import com.sinch.sdk.domains.voice.models.CallLegType;
import com.sinch.sdk.domains.voice.models.dto.v1.CallsResponseDtoTest;
import com.sinch.sdk.domains.voice.models.dto.v1.SVAMLRequestBodyDto;
import com.sinch.sdk.domains.voice.models.response.CallInformation;
import com.sinch.sdk.domains.voice.models.svaml.SVAMLControlTest;
import com.sinch.sdk.models.Configuration;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;

@TestWithResources
public class CallsServiceTest extends BaseTest {

  @Mock CallsApi api;
  @Mock Configuration configuration;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;

  @Captor ArgumentCaptor<String> callIdCaptor;
  @Captor ArgumentCaptor<String> callLegCaptor;
  @Captor ArgumentCaptor<SVAMLRequestBodyDto> updateParametersCaptor;
  CallsService service;

  @BeforeEach
  public void initMocks() {
    service = spy(new CallsService(configuration, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void get() throws ApiException {

    when(api.callingGetCallResult(
            eq(CallsResponseDtoTest.expectedCallsGetInformationResponseDto.getCallId())))
        .thenReturn(CallsResponseDtoTest.expectedCallsGetInformationResponseDto);

    CallInformation response =
        service.get(CallsResponseDtoTest.expectedCallsGetInformationResponseDto.getCallId());

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(CallsDtoConverterTest.expectedCallInformation);
  }

  @Test
  void update() throws ApiException {

    service.update("call id", SVAMLControlTest.parameters);

    verify(api).callingUpdateCall(callIdCaptor.capture(), updateParametersCaptor.capture());

    String callId = callIdCaptor.getValue();
    Assertions.assertThat(callId).isEqualTo("call id");

    SVAMLRequestBodyDto body = updateParametersCaptor.getValue();
    Assertions.assertThat(body).isEqualTo(CallsDtoConverterTest.svamlRequestBodyDto);
  }

  @Test
  void manageWithCallLeg() throws ApiException {

    service.manageWithCallLeg("call id", CallLegType.BOTH, SVAMLControlTest.parameters);

    verify(api)
        .callingManageCallWithCallLeg(
            callIdCaptor.capture(), callLegCaptor.capture(), updateParametersCaptor.capture());

    String callId = callIdCaptor.getValue();
    Assertions.assertThat(callId).isEqualTo("call id");

    String legType = callLegCaptor.getValue();
    Assertions.assertThat(legType).isEqualTo("both");

    SVAMLRequestBodyDto body = updateParametersCaptor.getValue();
    Assertions.assertThat(body).isEqualTo(CallsDtoConverterTest.svamlRequestBodyDto);
  }
}
