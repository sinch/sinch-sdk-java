package com.sinch.sdk.domains.verification.api.v1.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.verification.adapters.VerificationBaseTest;
import com.sinch.sdk.domains.verification.api.v1.internal.VerificationsStartApi;
import com.sinch.sdk.domains.verification.models.dto.v1.start.StartVerificationRequestTest;
import com.sinch.sdk.domains.verification.models.dto.v1.start.StartVerificationResponseTest;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationRequest;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationSmsRequest;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationSmsRequestImpl;
import com.sinch.sdk.domains.verification.models.v1.start.request.internal.StartVerificationRequestInternal;
import com.sinch.sdk.domains.verification.models.v1.start.request.internal.StartVerificationRequestInternalImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseData;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.start.response.StartVerificationResponseSms;
import com.sinch.sdk.models.VerificationContext;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class VerificationStartServiceTest extends VerificationBaseTest {

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationPhoneCallRequestDto.json")
  public StartVerificationRequestInternal startVerificationPhoneCallRequestDto;

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationFlashCallRequestDto.json")
  public StartVerificationRequestInternal startVerificationFlashCallRequestDto;

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationDataRequestDto.json")
  public StartVerificationRequestInternal startVerificationDataRequestDto;

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationSmsRequestDto.json")
  public StartVerificationRequestInternal startVerificationSmsRequestDto;

  @Mock VerificationsStartApi api;
  @Mock VerificationContext context;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;

  VerificationStartService service;

  @BeforeEach
  public void initMocks() {
    VerificationStartService v1 = new VerificationStartService(context, httpClient, authManagers);
    service = spy(v1);
    doReturn(api).when(service).getApi();
  }

  @Test
  void startSms() throws ApiException {

    when(api.startVerification(eq(startVerificationSmsRequestDto), eq(null)))
        .thenReturn(StartVerificationResponseTest.expectedStartVerificationSmsDto);

    StartVerificationResponseSms response =
        service.startSms(
            StartVerificationRequestTest.startVerificationSmsDto
                .getStartVerificationSmsRequestImpl());

    TestHelpers.recursiveEquals(
        response,
        StartVerificationResponseTest.expectedStartVerificationSmsDto.getActualInstance());
  }

  @Test
  void startSmsWithAcceptLanguage() throws ApiException {

    StartVerificationSmsRequestImpl startVerificationSmsRequestDtoImpl =
        ((StartVerificationRequestInternalImpl) startVerificationSmsRequestDto)
            .getStartVerificationSmsRequestImpl();
    StartVerificationRequest withAcceptLanguage =
        StartVerificationSmsRequest.builder()
            .setIdentity(startVerificationSmsRequestDtoImpl.getIdentity())
            .setReference(startVerificationSmsRequestDtoImpl.getReference())
            .setCustom(startVerificationSmsRequestDtoImpl.getCustom())
            .setExpiry(startVerificationSmsRequestDtoImpl.getExpiry())
            .setCodeType(startVerificationSmsRequestDtoImpl.getCodeType())
            .setTemplate(startVerificationSmsRequestDtoImpl.getTemplate())
            .setAcceptLanguage("es-ES")
            .build();
    StartVerificationRequestInternalImpl internalWithAcceptLanguage =
        new StartVerificationRequestInternalImpl();
    internalWithAcceptLanguage.setActualInstance(withAcceptLanguage);

    when(api.startVerification(eq(internalWithAcceptLanguage), eq("es-ES")))
        .thenReturn(StartVerificationResponseTest.expectedStartVerificationSmsDto);

    StartVerificationResponseSms response =
        service.startSms(
            StartVerificationRequestTest.startVerificationSmsDtoWithAcceptLanguage
                .getStartVerificationSmsRequestImpl());

    TestHelpers.recursiveEquals(
        response,
        StartVerificationResponseTest.expectedStartVerificationSmsDto.getActualInstance());
  }

  @Test
  void startFlashCall() throws ApiException {

    when(api.startVerification(eq(startVerificationFlashCallRequestDto), eq(null)))
        .thenReturn(StartVerificationResponseTest.expectedStartVerificationFlashCallDto);

    StartVerificationResponseFlashCall response =
        service.startFlashCall(
            StartVerificationRequestTest.startVerificationFlashCallDto
                .getStartVerificationFlashCallRequestImpl());

    TestHelpers.recursiveEquals(
        response,
        StartVerificationResponseTest.expectedStartVerificationFlashCallDto.getActualInstance());
  }

  @Test
  void startPhoneCall() throws ApiException {

    when(api.startVerification(eq(startVerificationPhoneCallRequestDto), eq(null)))
        .thenReturn(StartVerificationResponseTest.expectedStartVerificationPhoneCallDto);

    StartVerificationResponsePhoneCall response =
        service.startPhoneCall(
            StartVerificationRequestTest.startVerificationPhoneCallDto
                .getStartVerificationPhoneCallRequestImpl());

    TestHelpers.recursiveEquals(
        response,
        StartVerificationResponseTest.expectedStartVerificationPhoneCallDto
            .getStartVerificationResponsePhoneCallImpl());
  }

  @Test
  void startData() throws ApiException {

    when(api.startVerification(eq(startVerificationDataRequestDto), eq(null)))
        .thenReturn(StartVerificationResponseTest.expectedStartVerificationDataDto);

    StartVerificationResponseData response =
        service.startData(
            StartVerificationRequestTest.startVerificationDataDto
                .getStartVerificationDataRequestImpl());

    TestHelpers.recursiveEquals(
        response,
        StartVerificationResponseTest.expectedStartVerificationDataDto
            .getStartVerificationResponseDataImpl());
  }
}
