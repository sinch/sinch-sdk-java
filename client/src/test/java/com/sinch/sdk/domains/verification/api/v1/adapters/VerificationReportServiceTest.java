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
import com.sinch.sdk.domains.verification.api.v1.internal.VerificationsReportApi;
import com.sinch.sdk.domains.verification.models.dto.v1.report.VerificationReportRequestDtoTest;
import com.sinch.sdk.domains.verification.models.dto.v1.report.VerificationReportResponseDtoTest;
import com.sinch.sdk.domains.verification.models.v1.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.report.request.internal.VerificationReportRequestInternal;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseSms;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseWhatsApp;
import com.sinch.sdk.models.VerificationContext;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class VerificationReportServiceTest extends VerificationBaseTest {

  @GivenJsonResource("/domains/verification/v1/report/VerificationReportRequestPhoneCallDto.json")
  public VerificationReportRequestInternal verificationReportPhoneCallRequestDto;

  @GivenJsonResource("/domains/verification/v1/report/VerificationReportRequestFlashCallDto.json")
  public VerificationReportRequestInternal verificationReportFlashCallRequestDto;

  @GivenJsonResource("/domains/verification/v1/report/VerificationReportRequestSmsDto.json")
  public VerificationReportRequestInternal verificationReportSmsRequestDto;

  @GivenJsonResource("/domains/verification/v1/report/VerificationReportRequestWhatsAppDto.json")
  public VerificationReportRequestInternal verificationReportWhatsAppRequestDto;

  @Mock VerificationsReportApi api;
  @Mock VerificationContext context;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;

  VerificationReportService service;

  @BeforeEach
  public void initMocks() {
    VerificationReportService v1 = new VerificationReportService(context, httpClient, authManagers);
    service = spy(v1);
    doReturn(api).when(service).getApi();
  }

  @Test
  void reportSmsByIdentity() throws ApiException {

    when(api.reportVerificationByIdentity(
            eq("endpoint string"), eq(verificationReportSmsRequestDto)))
        .thenReturn(VerificationReportResponseDtoTest.verificationReportSmsDto);

    VerificationReportResponseSms response =
        service.reportSmsByIdentity(
            NumberIdentity.builder().setEndpoint("endpoint string").build(),
            VerificationReportRequestDtoTest.verificationReportSmsDto
                .getVerificationReportRequestSmsImpl());

    TestHelpers.recursiveEquals(
        response,
        VerificationReportResponseDtoTest.verificationReportSmsDto
            .getVerificationReportResponseSmsImpl());
  }

  @Test
  void reportFlashCallByIdentity() throws ApiException {

    when(api.reportVerificationByIdentity(
            eq("endpoint string"), eq(verificationReportFlashCallRequestDto)))
        .thenReturn(VerificationReportResponseDtoTest.verificationReportFlashCallDto);

    VerificationReportResponseFlashCall response =
        service.reportFlashCallByIdentity(
            NumberIdentity.builder().setEndpoint("endpoint string").build(),
            VerificationReportRequestDtoTest.verificationReportFlashCallDto
                .getVerificationReportRequestFlashCallImpl());

    TestHelpers.recursiveEquals(
        response,
        VerificationReportResponseDtoTest.verificationReportFlashCallDto
            .getVerificationReportResponseFlashCallImpl());
  }

  @Test
  void reportPhoneCallByIdentity() throws ApiException {

    when(api.reportVerificationByIdentity(
            eq("endpoint string"), eq(verificationReportPhoneCallRequestDto)))
        .thenReturn(VerificationReportResponseDtoTest.verificationReportPhoneCallDto);

    VerificationReportResponsePhoneCall response =
        service.reportPhoneCallByIdentity(
            NumberIdentity.builder().setEndpoint("endpoint string").build(),
            VerificationReportRequestDtoTest.verificationReportPhoneCallDto
                .getVerificationReportRequestPhoneCallImpl());

    TestHelpers.recursiveEquals(
        response,
        VerificationReportResponseDtoTest.verificationReportPhoneCallDto
            .getVerificationReportResponsePhoneCallImpl());
  }

  @Test
  void reportWhatsAppByIdentity() throws ApiException {

    when(api.reportVerificationByIdentity(
            eq("endpoint string"), eq(verificationReportWhatsAppRequestDto)))
        .thenReturn(VerificationReportResponseDtoTest.verificationReportWhatsAppDto);

    VerificationReportResponseWhatsApp response =
        service.reportWhatsAppByIdentity(
            NumberIdentity.builder().setEndpoint("endpoint string").build(),
            VerificationReportRequestDtoTest.verificationReportWhatsAppDto
                .getVerificationReportRequestWhatsAppImpl());

    TestHelpers.recursiveEquals(
        response,
        VerificationReportResponseDtoTest.verificationReportWhatsAppDto
            .getVerificationReportResponseWhatsAppImpl());
  }

  @Test
  void reportSmsById() throws ApiException {

    when(api.reportVerificationById(eq("the id"), eq(verificationReportSmsRequestDto)))
        .thenReturn(VerificationReportResponseDtoTest.verificationReportSmsDto);

    VerificationReportResponseSms response =
        service.reportSmsById(
            "the id",
            VerificationReportRequestDtoTest.verificationReportSmsDto
                .getVerificationReportRequestSmsImpl());

    TestHelpers.recursiveEquals(
        response,
        VerificationReportResponseDtoTest.verificationReportSmsDto
            .getVerificationReportResponseSmsImpl());
  }

  @Test
  void reportFlashCallById() throws ApiException {

    when(api.reportVerificationById(eq("the id"), eq(verificationReportFlashCallRequestDto)))
        .thenReturn(VerificationReportResponseDtoTest.verificationReportFlashCallDto);

    VerificationReportResponseFlashCall response =
        service.reportFlashCallById(
            "the id",
            VerificationReportRequestDtoTest.verificationReportFlashCallDto
                .getVerificationReportRequestFlashCallImpl());

    TestHelpers.recursiveEquals(
        response,
        VerificationReportResponseDtoTest.verificationReportFlashCallDto
            .getVerificationReportResponseFlashCallImpl());
  }

  @Test
  void reportPhoneCallById() throws ApiException {

    when(api.reportVerificationById(eq("the id"), eq(verificationReportPhoneCallRequestDto)))
        .thenReturn(VerificationReportResponseDtoTest.verificationReportPhoneCallDto);

    VerificationReportResponsePhoneCall response =
        service.reportPhoneCallById(
            "the id",
            VerificationReportRequestDtoTest.verificationReportPhoneCallDto
                .getVerificationReportRequestPhoneCallImpl());

    TestHelpers.recursiveEquals(
        response,
        VerificationReportResponseDtoTest.verificationReportPhoneCallDto
            .getVerificationReportResponsePhoneCallImpl());
  }

  @Test
  void reportWhatsAppById() throws ApiException {

    when(api.reportVerificationById(eq("the id"), eq(verificationReportWhatsAppRequestDto)))
        .thenReturn(VerificationReportResponseDtoTest.verificationReportWhatsAppDto);

    VerificationReportResponseWhatsApp response =
        service.reportWhatsAppById(
            "the id",
            VerificationReportRequestDtoTest.verificationReportWhatsAppDto
                .getVerificationReportRequestWhatsAppImpl());

    TestHelpers.recursiveEquals(
        response,
        VerificationReportResponseDtoTest.verificationReportWhatsAppDto
            .getVerificationReportResponseWhatsAppImpl());
  }
}
