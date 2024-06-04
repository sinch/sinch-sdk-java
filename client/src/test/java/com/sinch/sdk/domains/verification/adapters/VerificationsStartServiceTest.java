package com.sinch.sdk.domains.verification.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.verification.adapters.converters.VerificationsDtoConverterTest;
import com.sinch.sdk.domains.verification.api.v1.internal.VerificationsStartApi;
import com.sinch.sdk.domains.verification.models.dto.v1.start.StartVerificationResponseTest;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseCallout;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseFlashCall;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSMS;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSeamless;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationRequestParameters;
import com.sinch.sdk.models.VerificationContext;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class VerificationsStartServiceTest extends BaseTest {

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationPhoneCallRequestDto.json")
  public StartVerificationRequestParameters startVerificationPhoneCallRequestDto;

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationFlashCallRequestDto.json")
  public StartVerificationRequestParameters startVerificationFlashCallRequestDto;

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationDataRequestDto.json")
  public StartVerificationRequestParameters startVerificationDataRequestDto;

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationSmsRequestDto.json")
  public StartVerificationRequestParameters startVerificationSmsRequestDto;

  @Mock VerificationsStartApi api;
  @Mock VerificationContext context;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;

  VerificationsStartService service;

  @BeforeEach
  public void initMocks() {
    service = spy(new VerificationsStartService(context, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void startSms() throws ApiException {

    when(api.startVerification(eq(startVerificationSmsRequestDto), eq(null)))
        .thenReturn(StartVerificationResponseTest.expectedStartVerificationSmsDto);

    StartVerificationResponseSMS response =
        service.startSms(VerificationsDtoConverterTest.startVerificationSmsRequest);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(VerificationsDtoConverterTest.expectedStartVerificationSmsResponse);
  }

  @Test
  void startFlashCall() throws ApiException {

    when(api.startVerification(eq(startVerificationFlashCallRequestDto), eq(null)))
        .thenReturn(StartVerificationResponseTest.expectedStartVerificationFlashCallDto);

    StartVerificationResponseFlashCall response =
        service.startFlashCall(VerificationsDtoConverterTest.startVerificationFlashCallRequest);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(VerificationsDtoConverterTest.expectedStartVerificationFlashCallResponse);
  }

  @Test
  void startPhoneCall() throws ApiException {

    when(api.startVerification(eq(startVerificationPhoneCallRequestDto), eq(null)))
        .thenReturn(StartVerificationResponseTest.expectedStartVerificationPhoneCallDto);

    StartVerificationResponseCallout response =
        service.startCallout(VerificationsDtoConverterTest.startVerificationPhoneCallRequest);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(VerificationsDtoConverterTest.expectedStartVerificationPhoneCallResponse);
  }

  @Test
  void startData() throws ApiException {

    when(api.startVerification(eq(startVerificationDataRequestDto), eq(null)))
        .thenReturn(StartVerificationResponseTest.expectedStartVerificationDataDto);

    StartVerificationResponseSeamless response =
        service.startSeamless(VerificationsDtoConverterTest.startVerificationDataRequest);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(VerificationsDtoConverterTest.expectedStartVerificationDataResponse);
  }
}