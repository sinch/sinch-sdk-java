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
import com.sinch.sdk.domains.verification.api.v1.internal.VerificationsReportApi;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationReportCallout;
import com.sinch.sdk.domains.verification.models.VerificationReportFlashCall;
import com.sinch.sdk.domains.verification.models.VerificationReportSMS;
import com.sinch.sdk.domains.verification.models.dto.v1.report.VerificationReportResponseDtoTest;
import com.sinch.sdk.domains.verification.models.v1.report.request.internal.VerificationReportRequestParametersInternal;
import com.sinch.sdk.models.VerificationContext;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class VerificationsReportServiceTest extends BaseTest {

  @GivenJsonResource("/domains/verification/v1/report/VerificationReportPhoneCallRequestDto.json")
  public VerificationReportRequestParametersInternal verificationReportPhoneCallRequestDto;

  @GivenJsonResource("/domains/verification/v1/report/VerificationReportFlashCallRequestDto.json")
  public VerificationReportRequestParametersInternal verificationReportFlashCallRequestDto;

  @GivenJsonResource("/domains/verification/v1/report/VerificationReportSmsRequestDto.json")
  public VerificationReportRequestParametersInternal verificationReportSmsRequestDto;

  @Mock VerificationsReportApi api;
  @Mock VerificationContext context;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;

  VerificationsReportService service;

  @BeforeEach
  public void initMocks() {
    service = spy(new VerificationsReportService(context, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void reportSmsByIdentity() throws ApiException {

    when(api.reportVerificationByIdentity(
            eq("endpoint string"), eq(verificationReportSmsRequestDto)))
        .thenReturn(VerificationReportResponseDtoTest.verificationReportSmsDto);

    VerificationReportSMS response =
        service.reportSmsByIdentity(
            NumberIdentity.builder().setEndpoint("endpoint string").build(),
            VerificationsDtoConverterTest.verificationReportSmsRequest);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(VerificationsDtoConverterTest.expectedVerificationStatusSmsResponse);
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
        .isEqualTo(VerificationsDtoConverterTest.expectedVerificationStatusFlashCallResponse);
  }

  @Test
  void reportPhoneCallByIdentity() throws ApiException {

    when(api.reportVerificationByIdentity(
            eq("endpoint string"), eq(verificationReportPhoneCallRequestDto)))
        .thenReturn(VerificationReportResponseDtoTest.verificationReportPhoneCallDto);

    VerificationReportCallout response =
        service.reportCalloutByIdentity(
            NumberIdentity.builder().setEndpoint("endpoint string").build(),
            VerificationsDtoConverterTest.verificationReportPhoneCallRequest);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(VerificationsDtoConverterTest.expectedVerificationStatusPhoneCallResponse);
  }

  @Test
  void reportSmsById() throws ApiException {

    when(api.reportVerificationById(eq("the id"), eq(verificationReportSmsRequestDto)))
        .thenReturn(VerificationReportResponseDtoTest.verificationReportSmsDto);

    VerificationReportSMS response =
        service.reportSmsById(
            VerificationId.valueOf("the id"),
            VerificationsDtoConverterTest.verificationReportSmsRequest);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(VerificationsDtoConverterTest.expectedVerificationStatusSmsResponse);
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
        .isEqualTo(VerificationsDtoConverterTest.expectedVerificationStatusFlashCallResponse);
  }

  @Test
  void reportPhoneCallById() throws ApiException {

    when(api.reportVerificationById(eq("the id"), eq(verificationReportPhoneCallRequestDto)))
        .thenReturn(VerificationReportResponseDtoTest.verificationReportPhoneCallDto);

    VerificationReportCallout response =
        service.reportCalloutById(
            VerificationId.valueOf("the id"),
            VerificationsDtoConverterTest.verificationReportPhoneCallRequest);

    Assertions.assertThat(response)
        .usingRecursiveComparison()
        .isEqualTo(VerificationsDtoConverterTest.expectedVerificationStatusPhoneCallResponse);
  }
}
