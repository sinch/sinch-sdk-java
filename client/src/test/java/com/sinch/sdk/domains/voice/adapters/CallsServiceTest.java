package com.sinch.sdk.domains.voice.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.voice.adapters.converters.CallsDtoConverterTest;
import com.sinch.sdk.domains.voice.models.CallLegType;
import com.sinch.sdk.domains.voice.models.response.CallInformation;
import com.sinch.sdk.domains.voice.models.svaml.SVAMLControlTest;
import com.sinch.sdk.domains.voice.models.v1.calls.CallInformationTest;
import com.sinch.sdk.domains.voice.models.v1.calls.request.CallLeg;
import com.sinch.sdk.domains.voice.models.v1.svaml.SvamlControl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;

@TestWithResources
public class CallsServiceTest extends BaseTest {

  @Mock com.sinch.sdk.domains.voice.api.v1.CallsService v1;

  @Captor ArgumentCaptor<String> callIdCaptor;
  @Captor ArgumentCaptor<CallLeg> callLegCaptor;
  @Captor ArgumentCaptor<SvamlControl> updateParametersCaptor;
  CallsService service;

  @BeforeEach
  public void initMocks() {
    service = spy(new CallsService(v1));
  }

  @Test
  void get() throws ApiException {
    when(v1.get(eq(CallInformationTest.expectedCallsGetInformationResponseDto.getCallId())))
        .thenReturn(CallInformationTest.expectedCallsGetInformationResponseDto);

    CallInformation response =
        service.get(CallInformationTest.expectedCallsGetInformationResponseDto.getCallId());

    TestHelpers.recursiveEquals(response, CallsDtoConverterTest.expectedCallInformation);
  }

  @Test
  void update() throws ApiException {
    service.update("call id", SVAMLControlTest.parameters);

    verify(v1).update(callIdCaptor.capture(), updateParametersCaptor.capture());

    String callId = callIdCaptor.getValue();
    Assertions.assertThat(callId).isEqualTo("call id");

    SvamlControl body = updateParametersCaptor.getValue();
    TestHelpers.recursiveEquals(body, CallsDtoConverterTest.svamlControlDto);
  }

  @Test
  void manageWithCallLeg() throws ApiException {

    service.manageWithCallLeg("call id", CallLegType.BOTH, SVAMLControlTest.parameters);

    verify(v1)
        .manageWithCallLeg(
            callIdCaptor.capture(), callLegCaptor.capture(), updateParametersCaptor.capture());

    String callId = callIdCaptor.getValue();
    Assertions.assertThat(callId).isEqualTo("call id");

    CallLeg legType = callLegCaptor.getValue();
    Assertions.assertThat(legType).isEqualTo(CallLeg.BOTH);

    SvamlControl body = updateParametersCaptor.getValue();
    Assertions.assertThat(body).isEqualTo(CallsDtoConverterTest.svamlControlDto);
  }
}
