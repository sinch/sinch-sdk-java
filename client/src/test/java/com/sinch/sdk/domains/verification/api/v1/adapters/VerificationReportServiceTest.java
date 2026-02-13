package com.sinch.sdk.domains.verification.api.v1.adapters;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpContentType;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.http.HttpMethod;
import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.http.HttpRequestTest.HttpRequestMatcher;
import com.sinch.sdk.core.http.HttpResponse;
import com.sinch.sdk.core.http.URLPathUtils;
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.verification.adapters.VerificationBaseTest;
import com.sinch.sdk.domains.verification.api.v1.VerificationsReportService;
import com.sinch.sdk.domains.verification.models.dto.v1.report.VerificationReportRequestDtoTest;
import com.sinch.sdk.domains.verification.models.dto.v1.report.VerificationReportResponseDtoTest;
import com.sinch.sdk.domains.verification.models.v1.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseSms;
import com.sinch.sdk.domains.verification.models.v1.report.response.VerificationReportResponseWhatsApp;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class VerificationReportServiceTest extends VerificationBaseTest {

  @GivenTextResource("/domains/verification/v1/report/VerificationReportRequestPhoneCallDto.json")
  public String verificationReportPhoneCallRequestDto;

  @GivenTextResource("/domains/verification/v1/report/VerificationReportResponsePhoneCallDto.json")
  public String verificationReportPhoneCallResponseDto;

  @GivenTextResource("/domains/verification/v1/report/VerificationReportRequestFlashCallDto.json")
  public String verificationReportFlashCallRequestDto;

  @GivenTextResource("/domains/verification/v1/report/VerificationReportResponseFlashCallDto.json")
  public String verificationReportFlashCallResponseDto;

  @GivenTextResource("/domains/verification/v1/report/VerificationReportRequestSmsDto.json")
  public String verificationReportSmsRequestDto;

  @GivenTextResource("/domains/verification/v1/report/VerificationReportResponseSmsDto.json")
  public String verificationReportSmsResponseDto;

  @GivenTextResource("/domains/verification/v1/report/VerificationReportRequestWhatsAppDto.json")
  public String verificationReportWhatsAppRequestDto;

  @GivenTextResource("/domains/verification/v1/report/VerificationReportResponseWhatsAppDto.json")
  public String verificationReportWhatsAppResponseDto;

  static final Collection<String> AUTH_NAMES = Arrays.asList("Basic", "Application");

  @Mock ServerConfiguration serverConfiguration;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  VerificationsReportService service;

  @BeforeEach
  public void initMocks() {
    service =
        new VerificationsReportServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance());
  }

  @Test
  void reportSmsByIdentity() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/verification/v1/verifications/number/"
                + URLPathUtils.encodePathSegment("endpoint string"),
            HttpMethod.PUT,
            Collections.emptyList(),
            verificationReportSmsRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), verificationReportSmsResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    VerificationReportResponseSms response =
        service.reportSmsByIdentity(
            NumberIdentity.builder().setEndpoint("endpoint string").build(),
            VerificationReportRequestDtoTest.verificationReportSmsDto);

    TestHelpers.recursiveEquals(
        response, VerificationReportResponseDtoTest.verificationReportSmsDto);
  }

  @Test
  void reportFlashCallByIdentity() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/verification/v1/verifications/number/"
                + URLPathUtils.encodePathSegment("endpoint string"),
            HttpMethod.PUT,
            Collections.emptyList(),
            verificationReportFlashCallRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), verificationReportFlashCallResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    VerificationReportResponseFlashCall response =
        service.reportFlashCallByIdentity(
            NumberIdentity.builder().setEndpoint("endpoint string").build(),
            VerificationReportRequestDtoTest.verificationReportFlashCallDto);

    TestHelpers.recursiveEquals(
        response, VerificationReportResponseDtoTest.verificationReportFlashCallDto);
  }

  @Test
  void reportPhoneCallByIdentity() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/verification/v1/verifications/number/"
                + URLPathUtils.encodePathSegment("endpoint string"),
            HttpMethod.PUT,
            Collections.emptyList(),
            verificationReportPhoneCallRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), verificationReportPhoneCallResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    VerificationReportResponsePhoneCall response =
        service.reportPhoneCallByIdentity(
            NumberIdentity.builder().setEndpoint("endpoint string").build(),
            VerificationReportRequestDtoTest.verificationReportPhoneCallDto);

    TestHelpers.recursiveEquals(
        response, VerificationReportResponseDtoTest.verificationReportPhoneCallDto);
  }

  @Test
  void reportWhatsAppByIdentity() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/verification/v1/verifications/number/"
                + URLPathUtils.encodePathSegment("endpoint string"),
            HttpMethod.PUT,
            Collections.emptyList(),
            verificationReportWhatsAppRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), verificationReportWhatsAppResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    VerificationReportResponseWhatsApp response =
        service.reportWhatsAppByIdentity(
            NumberIdentity.builder().setEndpoint("endpoint string").build(),
            VerificationReportRequestDtoTest.verificationReportWhatsAppDto);

    TestHelpers.recursiveEquals(
        response, VerificationReportResponseDtoTest.verificationReportWhatsAppDto);
  }

  @Test
  void reportSmsById() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/verification/v1/verifications/id/" + URLPathUtils.encodePathSegment("the id"),
            HttpMethod.PUT,
            Collections.emptyList(),
            verificationReportSmsRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), verificationReportSmsResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    VerificationReportResponseSms response =
        service.reportSmsById("the id", VerificationReportRequestDtoTest.verificationReportSmsDto);

    TestHelpers.recursiveEquals(
        response, VerificationReportResponseDtoTest.verificationReportSmsDto);
  }

  @Test
  void reportFlashCallById() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/verification/v1/verifications/id/" + URLPathUtils.encodePathSegment("the id"),
            HttpMethod.PUT,
            Collections.emptyList(),
            verificationReportFlashCallRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), verificationReportFlashCallResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    VerificationReportResponseFlashCall response =
        service.reportFlashCallById(
            "the id", VerificationReportRequestDtoTest.verificationReportFlashCallDto);

    TestHelpers.recursiveEquals(
        response, VerificationReportResponseDtoTest.verificationReportFlashCallDto);
  }

  @Test
  void reportPhoneCallById() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/verification/v1/verifications/id/" + URLPathUtils.encodePathSegment("the id"),
            HttpMethod.PUT,
            Collections.emptyList(),
            verificationReportPhoneCallRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), verificationReportPhoneCallResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    VerificationReportResponsePhoneCall response =
        service.reportPhoneCallById(
            "the id", VerificationReportRequestDtoTest.verificationReportPhoneCallDto);

    TestHelpers.recursiveEquals(
        response, VerificationReportResponseDtoTest.verificationReportPhoneCallDto);
  }

  @Test
  void reportWhatsAppById() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/verification/v1/verifications/id/" + URLPathUtils.encodePathSegment("the id"),
            HttpMethod.PUT,
            Collections.emptyList(),
            verificationReportWhatsAppRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), verificationReportWhatsAppResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    VerificationReportResponseWhatsApp response =
        service.reportWhatsAppById(
            "the id", VerificationReportRequestDtoTest.verificationReportWhatsAppDto);

    TestHelpers.recursiveEquals(
        response, VerificationReportResponseDtoTest.verificationReportWhatsAppDto);
  }
}
