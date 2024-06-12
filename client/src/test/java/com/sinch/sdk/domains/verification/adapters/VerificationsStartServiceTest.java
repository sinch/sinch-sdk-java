package com.sinch.sdk.domains.verification.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.verification.adapters.converters.VerificationsDtoConverterTest;
import com.sinch.sdk.domains.verification.models.dto.v1.start.StartVerificationResponseTest;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseCallout;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseFlashCall;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSMS;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSeamless;
import com.sinch.sdk.domains.verification.models.v1.start.request.internal.StartVerificationRequestInternal;
import com.sinch.sdk.domains.verification.models.v1.start.request.internal.StartVerificationRequestInternalImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class VerificationsStartServiceTest extends VerificationBaseTest {

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationPhoneCallRequestDto.json")
  public StartVerificationRequestInternal startVerificationPhoneCallRequestDto;

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationFlashCallRequestDto.json")
  public StartVerificationRequestInternal startVerificationFlashCallRequestDto;

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationDataRequestDto.json")
  public StartVerificationRequestInternal startVerificationDataRequestDto;

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationSmsRequestDto.json")
  public StartVerificationRequestInternal startVerificationSmsRequestDto;

  @Mock com.sinch.sdk.domains.verification.api.v1.VerificationStartService v1;

  VerificationsStartService service;

  @BeforeEach
  public void initMocks() {
    service = spy(new VerificationsStartService(v1));
  }

  @Test
  void startSms() throws ApiException {

    when(v1.startSms(
            eq(
                ((StartVerificationRequestInternalImpl) startVerificationSmsRequestDto)
                    .getStartVerificationSmsRequestImpl())))
        .thenReturn(
            StartVerificationResponseTest.expectedStartVerificationSmsDto
                .getStartVerificationResponseSmsImpl());

    StartVerificationResponseSMS response =
        service.startSms(VerificationsDtoConverterTest.startVerificationSmsRequest);

    TestHelpers.recursiveEquals(
        response, VerificationsDtoConverterTest.expectedStartVerificationSmsResponse);
  }

  @Test
  void startFlashCall() throws ApiException {

    when(v1.startFlashCall(
            eq(
                ((StartVerificationRequestInternalImpl) startVerificationFlashCallRequestDto)
                    .getStartVerificationFlashCallRequestImpl())))
        .thenReturn(
            StartVerificationResponseTest.expectedStartVerificationFlashCallDto
                .getStartVerificationResponseFlashCallImpl());

    StartVerificationResponseFlashCall response =
        service.startFlashCall(VerificationsDtoConverterTest.startVerificationFlashCallRequest);

    TestHelpers.recursiveEquals(
        response, VerificationsDtoConverterTest.expectedStartVerificationFlashCallResponse);
  }

  @Test
  void startPhoneCall() throws ApiException {

    when(v1.startPhoneCall(
            eq(
                ((StartVerificationRequestInternalImpl) startVerificationPhoneCallRequestDto)
                    .getStartVerificationPhoneCallRequestImpl())))
        .thenReturn(
            StartVerificationResponseTest.expectedStartVerificationPhoneCallDto
                .getStartVerificationResponsePhoneCallImpl());

    StartVerificationResponseCallout response =
        service.startCallout(VerificationsDtoConverterTest.startVerificationPhoneCallRequest);

    TestHelpers.recursiveEquals(
        response, VerificationsDtoConverterTest.expectedStartVerificationPhoneCallResponse);
  }

  @Test
  void startData() throws ApiException {

    when(v1.startData(
            eq(
                ((StartVerificationRequestInternalImpl) startVerificationDataRequestDto)
                    .getStartVerificationDataRequestImpl())))
        .thenReturn(
            StartVerificationResponseTest.expectedStartVerificationDataDto
                .getStartVerificationResponseDataImpl());

    StartVerificationResponseSeamless response =
        service.startSeamless(VerificationsDtoConverterTest.startVerificationDataRequest);

    TestHelpers.recursiveEquals(
        response, VerificationsDtoConverterTest.expectedStartVerificationDataResponse);
  }
}
