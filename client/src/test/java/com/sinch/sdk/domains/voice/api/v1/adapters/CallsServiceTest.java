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
import com.sinch.sdk.domains.voice.api.v1.internal.CallsApi;
import com.sinch.sdk.domains.voice.models.v1.calls.CallInformationTest;
import com.sinch.sdk.domains.voice.models.v1.calls.request.CallLeg;
import com.sinch.sdk.domains.voice.models.v1.calls.response.CallInformation;
import com.sinch.sdk.domains.voice.models.v1.svaml.SvamlControl;
import com.sinch.sdk.domains.voice.models.v1.svaml.SvamlControlTest;
import com.sinch.sdk.models.VoiceContext;
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
  @Mock VoiceContext context;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;

  @Captor ArgumentCaptor<String> callIdCaptor;
  @Captor ArgumentCaptor<String> callLegCaptor;
  @Captor ArgumentCaptor<SvamlControl> updateParametersCaptor;
  CallsService service;

  @BeforeEach
  public void initMocks() {
    service = spy(new CallsService(context, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void get() throws ApiException {
    when(api.callingGetCallResult(
            eq(CallInformationTest.expectedCallsGetInformationResponseDto.getCallId())))
        .thenReturn(CallInformationTest.expectedCallsGetInformationResponseDto);

    CallInformation response =
        service.get(CallInformationTest.expectedCallsGetInformationResponseDto.getCallId());

    TestHelpers.recursiveEquals(
        response, CallInformationTest.expectedCallsGetInformationResponseDto);
  }

  @Test
  void update() throws ApiException {
    service.update("call id", SvamlControlTest.expectedSvamlControl);

    verify(api).callingUpdateCall(callIdCaptor.capture(), updateParametersCaptor.capture());

    String callId = callIdCaptor.getValue();
    Assertions.assertThat(callId).isEqualTo("call id");

    SvamlControl body = updateParametersCaptor.getValue();
    TestHelpers.recursiveEquals(body, SvamlControlTest.expectedSvamlControl);
  }

  @Test
  void manageWithCallLeg() throws ApiException {

    service.manageWithCallLeg("call id", CallLeg.BOTH, SvamlControlTest.expectedSvamlControl);

    verify(api)
        .callingManageCallWithCallLeg(
            callIdCaptor.capture(), callLegCaptor.capture(), updateParametersCaptor.capture());

    String callId = callIdCaptor.getValue();
    Assertions.assertThat(callId).isEqualTo("call id");

    String legType = callLegCaptor.getValue();
    Assertions.assertThat(legType).isEqualTo("both");

    SvamlControl body = updateParametersCaptor.getValue();
    TestHelpers.recursiveEquals(body, SvamlControlTest.expectedSvamlControl);
  }
}
