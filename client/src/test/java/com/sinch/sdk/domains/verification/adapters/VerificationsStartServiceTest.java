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

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationCalloutRequestDto.json")
  public StartVerificationRequestParameters startVerificationCalloutRequestDto;

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationFlashCallRequestDto.json")
  public StartVerificationRequestParameters startVerificationFlashCallRequestDto;

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationSeamlessRequestDto.json")
  public StartVerificationRequestParameters startVerificationSeamlessRequestDto;

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationSmsRequestDto.json")
  public StartVerificationRequestParameters startVerificationSMSRequestDto;

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

    when(api.startVerification(eq(startVerificationSMSRequestDto), eq(null)))
        .thenReturn(StartVerificationResponseTest.expectedStartVerificationSmsDto);

    StartVerificationResponseSMS response =
        service.startSms(VerificationsDtoConverterTest.startVerificationSMSRequest);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(VerificationsDtoConverterTest.expectedStartVerificationSMSResponse);
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
  void startCallout() throws ApiException {

    when(api.startVerification(eq(startVerificationCalloutRequestDto), eq(null)))
        .thenReturn(StartVerificationResponseTest.expectedStartVerificationCalloutDto);

    StartVerificationResponseCallout response =
        service.startCallout(VerificationsDtoConverterTest.startVerificationCalloutRequest);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(VerificationsDtoConverterTest.expectedStartVerificationCalloutResponse);
  }

  @Test
  void startSeamless() throws ApiException {

    when(api.startVerification(eq(startVerificationSeamlessRequestDto), eq(null)))
        .thenReturn(StartVerificationResponseTest.expectedStartVerificationSeamlessDto);

    StartVerificationResponseSeamless response =
        service.startSeamless(VerificationsDtoConverterTest.startVerificationSeamlessRequest);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(VerificationsDtoConverterTest.expectedStartVerificationSeamlessResponse);
  }
}
