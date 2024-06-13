package com.sinch.sdk.domains.verification.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenJsonResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.verification.adapters.converters.VerificationsDtoConverterTest;
import com.sinch.sdk.domains.verification.models.NumberIdentity;
import com.sinch.sdk.domains.verification.models.VerificationId;
import com.sinch.sdk.domains.verification.models.VerificationReportCallout;
import com.sinch.sdk.domains.verification.models.VerificationReportFlashCall;
import com.sinch.sdk.domains.verification.models.VerificationReportSMS;
import com.sinch.sdk.domains.verification.models.dto.v1.report.VerificationReportResponseDtoTest;
import com.sinch.sdk.domains.verification.models.v1.report.request.internal.VerificationReportRequestInternalImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class VerificationsReportServiceTest extends VerificationBaseTest {

  @GivenJsonResource("/domains/verification/v1/report/VerificationReportPhoneCallRequestDto.json")
  public VerificationReportRequestInternalImpl verificationReportPhoneCallRequestDto;

  @GivenJsonResource("/domains/verification/v1/report/VerificationReportFlashCallRequestDto.json")
  public VerificationReportRequestInternalImpl verificationReportFlashCallRequestDto;

  @GivenJsonResource("/domains/verification/v1/report/VerificationReportSmsRequestDto.json")
  public VerificationReportRequestInternalImpl verificationReportSmsRequestDto;

  @Mock com.sinch.sdk.domains.verification.api.v1.VerificationReportService v1;
  VerificationsReportService service;

  @BeforeEach
  public void initMocks() {
    service = spy(new VerificationsReportService(v1));
  }

  @Test
  void reportSmsByIdentity() throws ApiException {

    when(v1.reportSmsByIdentity(
            eq(NumberIdentity.valueOf("endpoint string")),
            eq(verificationReportSmsRequestDto.getVerificationReportRequestSmsImpl())))
        .thenReturn(
            VerificationReportResponseDtoTest.verificationReportSmsDto
                .getVerificationReportResponseSmsImpl());

    VerificationReportSMS response =
        service.reportSmsByIdentity(
            NumberIdentity.builder().setEndpoint("endpoint string").build(),
            VerificationsDtoConverterTest.verificationReportSmsRequest);

    TestHelpers.recursiveEquals(
        response, VerificationsDtoConverterTest.expectedVerificationReportSmsResponse);
  }

  @Test
  void reportFlashCallByIdentity() throws ApiException {

    when(v1.reportFlashCallByIdentity(
            eq(NumberIdentity.valueOf("endpoint string")),
            eq(verificationReportFlashCallRequestDto.getVerificationReportRequestFlashCallImpl())))
        .thenReturn(
            VerificationReportResponseDtoTest.verificationReportFlashCallDto
                .getVerificationReportResponseFlashCallImpl());

    VerificationReportFlashCall response =
        service.reportFlashCallByIdentity(
            NumberIdentity.builder().setEndpoint("endpoint string").build(),
            VerificationsDtoConverterTest.verificationReportFlashCallRequest);

    TestHelpers.recursiveEquals(
        response, VerificationsDtoConverterTest.expectedVerificationReportFlashCallResponse);
  }

  @Test
  void reportPhoneCallByIdentity() throws ApiException {

    when(v1.reportPhoneCallByIdentity(
            eq(NumberIdentity.valueOf("endpoint string")),
            eq(verificationReportPhoneCallRequestDto.getVerificationReportRequestPhoneCallImpl())))
        .thenReturn(
            VerificationReportResponseDtoTest.verificationReportPhoneCallDto
                .getVerificationReportResponsePhoneCallImpl());

    VerificationReportCallout response =
        service.reportCalloutByIdentity(
            NumberIdentity.builder().setEndpoint("endpoint string").build(),
            VerificationsDtoConverterTest.verificationReportPhoneCallRequest);

    TestHelpers.recursiveEquals(
        response, VerificationsDtoConverterTest.expectedVerificationReportPhoneCallResponse);
  }

  @Test
  void reportSmsById() throws ApiException {

    when(v1.reportSmsById(
            eq("the id"),
            eq(verificationReportSmsRequestDto.getVerificationReportRequestSmsImpl())))
        .thenReturn(
            VerificationReportResponseDtoTest.verificationReportSmsDto
                .getVerificationReportResponseSmsImpl());

    VerificationReportSMS response =
        service.reportSmsById(
            VerificationId.valueOf("the id"),
            VerificationsDtoConverterTest.verificationReportSmsRequest);

    TestHelpers.recursiveEquals(
        response, VerificationsDtoConverterTest.expectedVerificationReportSmsResponse);
  }

  @Test
  void reportFlashCallById() throws ApiException {

    when(v1.reportFlashCallById(
            eq("the id"),
            eq(verificationReportFlashCallRequestDto.getVerificationReportRequestFlashCallImpl())))
        .thenReturn(
            VerificationReportResponseDtoTest.verificationReportFlashCallDto
                .getVerificationReportResponseFlashCallImpl());

    VerificationReportFlashCall response =
        service.reportFlashCallById(
            VerificationId.valueOf("the id"),
            VerificationsDtoConverterTest.verificationReportFlashCallRequest);

    TestHelpers.recursiveEquals(
        response, VerificationsDtoConverterTest.expectedVerificationReportFlashCallResponse);
  }

  @Test
  void reportPhoneCallById() throws ApiException {

    when(v1.reportPhoneCallById(
            eq("the id"),
            eq(verificationReportPhoneCallRequestDto.getVerificationReportRequestPhoneCallImpl())))
        .thenReturn(
            VerificationReportResponseDtoTest.verificationReportPhoneCallDto
                .getVerificationReportResponsePhoneCallImpl());

    VerificationReportCallout response =
        service.reportCalloutById(
            VerificationId.valueOf("the id"),
            VerificationsDtoConverterTest.verificationReportPhoneCallRequest);

    TestHelpers.recursiveEquals(
        response, VerificationsDtoConverterTest.expectedVerificationReportPhoneCallResponse);
  }
}
