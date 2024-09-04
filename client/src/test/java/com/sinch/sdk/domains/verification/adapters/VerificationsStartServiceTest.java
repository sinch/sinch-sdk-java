package com.sinch.sdk.domains.verification.adapters;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.verification.adapters.converters.VerificationsDtoConverterTest;
import com.sinch.sdk.domains.verification.models.dto.v1.start.response.VerificationStartResponseTest;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseCallout;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseFlashCall;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSMS;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSeamless;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestSms;
import com.sinch.sdk.domains.verification.models.v1.start.request.internal.VerificationStartRequestInternalImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class VerificationsStartServiceTest extends VerificationBaseTest {

  @GivenJsonResource(
      "/domains/verification/v1/start/request/VerificationStartRequestPhoneCallDto.json")
  public VerificationStartRequestInternalImpl startVerificationPhoneCallRequestDto;

  @GivenJsonResource(
      "/domains/verification/v1/start/request/VerificationStartRequestFlashCallDto.json")
  public VerificationStartRequestInternalImpl startVerificationFlashCallRequestDto;

  @GivenJsonResource("/domains/verification/v1/start/request/VerificationStartRequestDataDto.json")
  public VerificationStartRequestInternalImpl startVerificationDataRequestDto;

  @GivenJsonResource("/domains/verification/v1/start/request/VerificationStartRequestSmsDto.json")
  public VerificationStartRequestInternalImpl startVerificationSmsRequestDto;

  @Mock com.sinch.sdk.domains.verification.api.v1.VerificationStartService v1;

  VerificationsStartService service;

  @BeforeEach
  public void initMocks() {
    service = spy(new VerificationsStartService(v1));
  }

  @Test
  void startSms() throws ApiException {

    when(v1.startSms(any(VerificationStartRequestSms.class)))
        .thenReturn(
            VerificationStartResponseTest.expectedStartVerificationSmsDto
                .getVerificationStartResponseSmsImpl());

    StartVerificationResponseSMS response =
        service.startSms(VerificationsDtoConverterTest.startVerificationSmsRequest);

    TestHelpers.recursiveEquals(
        response, VerificationsDtoConverterTest.expectedStartVerificationSmsResponse);
  }

  @Test
  void startFlashCall() throws ApiException {

    when(v1.startFlashCall(
            eq(startVerificationFlashCallRequestDto.getVerificationStartRequestFlashCallImpl())))
        .thenReturn(
            VerificationStartResponseTest.expectedStartVerificationFlashCallDto
                .getVerificationStartResponseFlashCallImpl());

    StartVerificationResponseFlashCall response =
        service.startFlashCall(VerificationsDtoConverterTest.startVerificationFlashCallRequest);

    TestHelpers.recursiveEquals(
        response, VerificationsDtoConverterTest.expectedStartVerificationFlashCallResponse);
  }

  @Test
  void startPhoneCall() throws ApiException {

    when(v1.startPhoneCall(
            eq(startVerificationPhoneCallRequestDto.getVerificationStartRequestPhoneCallImpl())))
        .thenReturn(
            VerificationStartResponseTest.expectedStartVerificationPhoneCallDto
                .getVerificationStartResponsePhoneCallImpl());

    StartVerificationResponseCallout response =
        service.startCallout(VerificationsDtoConverterTest.startVerificationPhoneCallRequest);

    TestHelpers.recursiveEquals(
        response, VerificationsDtoConverterTest.expectedStartVerificationPhoneCallResponse);
  }

  @Test
  void startData() throws ApiException {

    when(v1.startData(eq(startVerificationDataRequestDto.getVerificationStartRequestDataImpl())))
        .thenReturn(
            VerificationStartResponseTest.expectedStartVerificationDataDto
                .getVerificationStartResponseDataImpl());

    StartVerificationResponseSeamless response =
        service.startSeamless(VerificationsDtoConverterTest.startVerificationDataRequest);

    TestHelpers.recursiveEquals(
        response, VerificationsDtoConverterTest.expectedStartVerificationDataResponse);
  }
}
