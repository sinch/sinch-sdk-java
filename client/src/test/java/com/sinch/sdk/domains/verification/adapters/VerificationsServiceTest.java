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
import com.sinch.sdk.domains.verification.api.v1.internal.VerificationsApi;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationReportCallout;
import com.sinch.sdk.domains.verification.models.VerificationReportFlashCall;
import com.sinch.sdk.domains.verification.models.VerificationReportSMS;
import com.sinch.sdk.domains.verification.models.dto.v1.report.VerificationReportResponseDtoTest;
import com.sinch.sdk.domains.verification.models.dto.v1.start.StartVerificationResponseTest;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseCallout;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseFlashCall;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSMS;
import com.sinch.sdk.domains.verification.models.response.StartVerificationResponseSeamless;
import com.sinch.sdk.domains.verification.models.v1.report.request.internal.VerificationReportRequestParametersInternal;
import com.sinch.sdk.domains.verification.models.v1.start.request.StartVerificationRequestParameters;
import com.sinch.sdk.models.VerificationContext;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class VerificationsServiceTest extends BaseTest {

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationCalloutRequestDto.json")
  public StartVerificationRequestParameters startVerificationCalloutRequestDto;

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationFlashCallRequestDto.json")
  public StartVerificationRequestParameters startVerificationFlashCallRequestDto;

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationSeamlessRequestDto.json")
  public StartVerificationRequestParameters startVerificationSeamlessRequestDto;

  @GivenJsonResource("/domains/verification/v1/start/StartVerificationSMSRequestDto.json")
  public StartVerificationRequestParameters startVerificationSMSRequestDto;

  @GivenJsonResource("/domains/verification/v1/report/VerificationReportCalloutRequestDto.json")
  public VerificationReportRequestParametersInternal verificationReportCalloutRequestDto;

  @GivenJsonResource("/domains/verification/v1/report/VerificationReportFlashCallRequestDto.json")
  public VerificationReportRequestParametersInternal verificationReportFlashCallRequestDto;

  @GivenJsonResource("/domains/verification/v1/report/VerificationReportSMSRequestDto.json")
  public VerificationReportRequestParametersInternal verificationReportSMSRequestDto;

  @Mock VerificationsApi api;
  @Mock VerificationContext context;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;

  VerificationsService service;

  @BeforeEach
  public void initMocks() {
    service = spy(new VerificationsService(context, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void startSms() throws ApiException {

    when(api.startVerification(eq(startVerificationSMSRequestDto), eq(null)))
        .thenReturn(StartVerificationResponseTest.expectedStartVerificationSMSDto);

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

  @Test
  void reportSmsByIdentity() throws ApiException {

    when(api.reportVerificationByIdentity(
            eq("endpoint string"), eq(verificationReportSMSRequestDto)))
        .thenReturn(VerificationReportResponseDtoTest.verificationReportSMSDto);

    VerificationReportSMS response =
        service.reportSmsByIdentity(
            NumberIdentity.builder().setEndpoint("endpoint string").build(),
            VerificationsDtoConverterTest.verificationReportSMSRequest);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(VerificationsDtoConverterTest.expectedVerificationStatusSMSResponse);
  }

  @Test
  void reportFlashCallByIdentity() throws ApiException {

    when(api.reportVerificationByIdentity(
            eq("endpoint string"), eq(verificationReportFlashCallRequestDto)))
        .thenReturn(VerificationReportResponseDtoTest.verificationReportFlashCallDto);

    VerificationReportFlashCall response =
        service.reportFlashCallByIdentity(
            NumberIdentity.builder().setEndpoint("endpoint string").build(),
            VerificationsDtoConverterTest.verificationReportFlashCallRequest);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(VerificationsDtoConverterTest.expectedVerificationReportFlashCallResponse);
  }

  @Test
  void reportCalloutByIdentity() throws ApiException {

    when(api.reportVerificationByIdentity(
            eq("endpoint string"), eq(verificationReportCalloutRequestDto)))
        .thenReturn(VerificationReportResponseDtoTest.verificationReportCalloutDto);

    VerificationReportCallout response =
        service.reportCalloutByIdentity(
            NumberIdentity.builder().setEndpoint("endpoint string").build(),
            VerificationsDtoConverterTest.verificationReportCalloutRequest);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(VerificationsDtoConverterTest.expectedVerificationReportCalloutResponse);
  }

  @Test
  void reportSmsById() throws ApiException {

    when(api.reportVerificationById(eq("the id"), eq(verificationReportSMSRequestDto)))
        .thenReturn(VerificationReportResponseDtoTest.verificationReportSMSDto);

    VerificationReportSMS response =
        service.reportSmsById(
            VerificationId.valueOf("the id"),
            VerificationsDtoConverterTest.verificationReportSMSRequest);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(VerificationsDtoConverterTest.expectedVerificationStatusSMSResponse);
  }

  @Test
  void reportFlashCallById() throws ApiException {

    when(api.reportVerificationById(eq("the id"), eq(verificationReportFlashCallRequestDto)))
        .thenReturn(VerificationReportResponseDtoTest.verificationReportFlashCallDto);

    VerificationReportFlashCall response =
        service.reportFlashCallById(
            VerificationId.valueOf("the id"),
            VerificationsDtoConverterTest.verificationReportFlashCallRequest);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(VerificationsDtoConverterTest.expectedVerificationReportFlashCallResponse);
  }

  @Test
  void reportCalloutById() throws ApiException {

    when(api.reportVerificationById(eq("the id"), eq(verificationReportCalloutRequestDto)))
        .thenReturn(VerificationReportResponseDtoTest.verificationReportCalloutDto);

    VerificationReportCallout response =
        service.reportCalloutById(
            VerificationId.valueOf("the id"),
            VerificationsDtoConverterTest.verificationReportCalloutRequest);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(VerificationsDtoConverterTest.expectedVerificationReportCalloutResponse);
  }
}
