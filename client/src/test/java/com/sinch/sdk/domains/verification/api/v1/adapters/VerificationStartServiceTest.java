package com.sinch.sdk.domains.verification.api.v1.adapters;

import static org.mockito.ArgumentMatchers.argThat;
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
import com.sinch.sdk.core.models.ModelArgMatcher;
import com.sinch.sdk.domains.verification.adapters.VerificationBaseTest;
import com.sinch.sdk.domains.verification.api.v1.internal.VerificationsStartApi;
import com.sinch.sdk.domains.verification.models.dto.v1.start.request.VerificationStartRequestTest;
import com.sinch.sdk.domains.verification.models.dto.v1.start.response.VerificationStartResponseTest;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequest;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestSms;
import com.sinch.sdk.domains.verification.models.v1.start.request.VerificationStartRequestSmsImpl;
import com.sinch.sdk.domains.verification.models.v1.start.request.internal.VerificationStartRequestInternal;
import com.sinch.sdk.domains.verification.models.v1.start.request.internal.VerificationStartRequestInternalImpl;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseData;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseSms;
import com.sinch.sdk.models.VerificationContext;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class VerificationStartServiceTest extends VerificationBaseTest {

  @GivenJsonResource(
      "/domains/verification/v1/start/request/VerificationStartRequestPhoneCallDto.json")
  public VerificationStartRequestInternal startVerificationPhoneCallRequestDto;

  @GivenJsonResource(
      "/domains/verification/v1/start/request/VerificationStartRequestFlashCallDto.json")
  public VerificationStartRequestInternal startVerificationFlashCallRequestDto;

  @GivenJsonResource("/domains/verification/v1/start/request/VerificationStartRequestDataDto.json")
  public VerificationStartRequestInternal startVerificationDataRequestDto;

  @GivenJsonResource("/domains/verification/v1/start/request/VerificationStartRequestSmsDto.json")
  public VerificationStartRequestInternal startVerificationSmsRequestDto;

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

    when(api.startVerification(
            argThat(new ModelArgMatcher<>(startVerificationSmsRequestDto)), eq(null)))
        .thenReturn(VerificationStartResponseTest.expectedStartVerificationSmsDto);

    VerificationStartResponseSms response =
        service.startSms(
            VerificationStartRequestTest.startVerificationSmsDto
                .getVerificationStartRequestSmsImpl());

    TestHelpers.recursiveEquals(
        response,
        VerificationStartResponseTest.expectedStartVerificationSmsDto.getActualInstance());
  }

  @Test
  void startSmsWithAcceptLanguage() throws ApiException {

    VerificationStartRequestSmsImpl startVerificationSmsRequestDtoImpl =
        ((VerificationStartRequestInternalImpl) startVerificationSmsRequestDto)
            .getVerificationStartRequestSmsImpl();
    VerificationStartRequest withAcceptLanguage =
        VerificationStartRequestSms.builder()
            .setIdentity(startVerificationSmsRequestDtoImpl.getIdentity())
            .setReference(startVerificationSmsRequestDtoImpl.getReference())
            .setCustom(startVerificationSmsRequestDtoImpl.getCustom())
            .setExpiry(startVerificationSmsRequestDtoImpl.getExpiry())
            .setCodeType(startVerificationSmsRequestDtoImpl.getCodeType())
            .setTemplate(startVerificationSmsRequestDtoImpl.getTemplate())
            .setAcceptLanguage("es-ES")
            .putExtraOption("my key", startVerificationSmsRequestDtoImpl.getExtraOption("my key"))
            .build();
    VerificationStartRequestInternalImpl internalWithAcceptLanguage =
        new VerificationStartRequestInternalImpl();
    internalWithAcceptLanguage.setActualInstance(withAcceptLanguage);

    when(api.startVerification(
            argThat(new ModelArgMatcher<>(internalWithAcceptLanguage)), eq("es-ES")))
        .thenReturn(VerificationStartResponseTest.expectedStartVerificationSmsDto);

    VerificationStartResponseSms response =
        service.startSms(
            VerificationStartRequestTest.startVerificationSmsDtoWithAcceptLanguage
                .getVerificationStartRequestSmsImpl());

    TestHelpers.recursiveEquals(
        response,
        VerificationStartResponseTest.expectedStartVerificationSmsDto
            .getVerificationStartResponseSmsImpl());
  }

  @Test
  void startFlashCall() throws ApiException {

    when(api.startVerification(
            argThat(new ModelArgMatcher<>(startVerificationFlashCallRequestDto)), eq(null)))
        .thenReturn(VerificationStartResponseTest.expectedStartVerificationFlashCallDto);

    VerificationStartResponseFlashCall response =
        service.startFlashCall(
            VerificationStartRequestTest.startVerificationFlashCallDto
                .getVerificationStartRequestFlashCallImpl());

    TestHelpers.recursiveEquals(
        response,
        VerificationStartResponseTest.expectedStartVerificationFlashCallDto
            .getVerificationStartResponseFlashCallImpl());
  }

  @Test
  void startPhoneCall() throws ApiException {

    when(api.startVerification(
            argThat(new ModelArgMatcher<>(startVerificationPhoneCallRequestDto)), eq(null)))
        .thenReturn(VerificationStartResponseTest.expectedStartVerificationPhoneCallDto);

    VerificationStartResponsePhoneCall response =
        service.startPhoneCall(
            VerificationStartRequestTest.startVerificationPhoneCallDto
                .getVerificationStartRequestPhoneCallImpl());

    TestHelpers.recursiveEquals(
        response,
        VerificationStartResponseTest.expectedStartVerificationPhoneCallDto
            .getVerificationStartResponsePhoneCallImpl());
  }

  @Test
  void startData() throws ApiException {

    when(api.startVerification(eq(startVerificationDataRequestDto), eq(null)))
        .thenReturn(VerificationStartResponseTest.expectedStartVerificationDataDto);

    VerificationStartResponseData response =
        service.startData(
            VerificationStartRequestTest.startVerificationDataDto
                .getVerificationStartRequestDataImpl());

    TestHelpers.recursiveEquals(
        response,
        VerificationStartResponseTest.expectedStartVerificationDataDto
            .getVerificationStartResponseDataImpl());
  }
}
