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
import com.sinch.sdk.core.models.ServerConfiguration;
import com.sinch.sdk.domains.verification.adapters.VerificationBaseTest;
import com.sinch.sdk.domains.verification.api.v1.VerificationsStartService;
import com.sinch.sdk.domains.verification.models.dto.v1.start.request.VerificationStartRequestTest;
import com.sinch.sdk.domains.verification.models.dto.v1.start.response.VerificationStartResponseTest;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseData;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseFlashCall;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponsePhoneCall;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseSms;
import com.sinch.sdk.domains.verification.models.v1.start.response.VerificationStartResponseWhatsApp;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class VerificationStartServiceTest extends VerificationBaseTest {

  @GivenTextResource(
      "/domains/verification/v1/start/request/VerificationStartRequestPhoneCallDto.json")
  String startVerificationPhoneCallRequestDto;

  @GivenTextResource(
      "/domains/verification/v1/start/response/VerificationStartResponsePhoneCallDto.json")
  String startVerificationStartResponsePhoneCallDto;

  @GivenTextResource(
      "/domains/verification/v1/start/request/VerificationStartRequestFlashCallDto.json")
  String startVerificationFlashCallRequestDto;

  @GivenTextResource(
      "/domains/verification/v1/start/response/VerificationStartResponseFlashCallDto.json")
  String startVerificationFlashCallResponseDto;

  @GivenTextResource("/domains/verification/v1/start/request/VerificationStartRequestDataDto.json")
  String startVerificationDataRequestDto;

  @GivenTextResource(
      "/domains/verification/v1/start/response/VerificationStartResponseDataDto.json")
  String startVerificationDataResponseDto;

  @GivenTextResource("/domains/verification/v1/start/request/VerificationStartRequestSmsDto.json")
  String startVerificationSmsRequestDto;

  @GivenTextResource("/domains/verification/v1/start/response/VerificationStartResponseSmsDto.json")
  String startVerificationSmsResponseDto;

  @GivenTextResource(
      "/domains/verification/v1/start/request/VerificationStartRequestWhatsAppDto.json")
  public String startVerificationWhatsAppRequestDto;

  @GivenTextResource(
      "/domains/verification/v1/start/response/VerificationStartResponseWhatsAppDto.json")
  public String startVerificationWhatsAppResponseDto;

  static final Collection<String> AUTH_NAMES = Arrays.asList("Basic", "Application");

  @Mock ServerConfiguration serverConfiguration;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  VerificationsStartService service;

  @BeforeEach
  public void initMocks() {
    service =
        new VerificationsStartServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance());
  }

  @Test
  void startSms() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/verification/v1/verifications",
            HttpMethod.POST,
            Collections.emptyList(),
            startVerificationSmsRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), startVerificationSmsResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    VerificationStartResponseSms response =
        service.startSms(VerificationStartRequestTest.startVerificationSmsDto);

    TestHelpers.recursiveEquals(
        response, VerificationStartResponseTest.expectedStartVerificationSmsDto);
  }

  @Test
  void startSmsWithAcceptLanguage() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/verification/v1/verifications",
            HttpMethod.POST,
            Collections.emptyList(),
            startVerificationSmsRequestDto,
            Collections.singletonMap("Accept-Language", "es-ES"),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), startVerificationSmsResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    VerificationStartResponseSms response =
        service.startSms(VerificationStartRequestTest.startVerificationSmsDtoWithAcceptLanguage);

    TestHelpers.recursiveEquals(
        response, VerificationStartResponseTest.expectedStartVerificationSmsDto);
  }

  @Test
  void startFlashCall() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/verification/v1/verifications",
            HttpMethod.POST,
            Collections.emptyList(),
            startVerificationFlashCallRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), startVerificationFlashCallResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    VerificationStartResponseFlashCall response =
        service.startFlashCall(VerificationStartRequestTest.startVerificationFlashCallDto);

    TestHelpers.recursiveEquals(
        response, VerificationStartResponseTest.expectedStartVerificationFlashCallDto);
  }

  @Test
  void startPhoneCall() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/verification/v1/verifications",
            HttpMethod.POST,
            Collections.emptyList(),
            startVerificationPhoneCallRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200,
            null,
            Collections.emptyMap(),
            startVerificationStartResponsePhoneCallDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    VerificationStartResponsePhoneCall response =
        service.startPhoneCall(VerificationStartRequestTest.startVerificationPhoneCallDto);

    TestHelpers.recursiveEquals(
        response, VerificationStartResponseTest.expectedStartVerificationPhoneCallDto);
  }

  @Test
  void startData() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/verification/v1/verifications",
            HttpMethod.POST,
            Collections.emptyList(),
            startVerificationDataRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), startVerificationDataResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    VerificationStartResponseData response =
        service.startData(VerificationStartRequestTest.startVerificationDataDto);

    TestHelpers.recursiveEquals(
        response, VerificationStartResponseTest.expectedStartVerificationDataDto);
  }

  @Test
  void startWhatsApp() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/verification/v1/verifications",
            HttpMethod.POST,
            Collections.emptyList(),
            startVerificationWhatsAppRequestDto,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), startVerificationWhatsAppResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    VerificationStartResponseWhatsApp response =
        service.startWhatsApp(
            VerificationStartRequestTest.startVerificationWhatsAppDto
                .getVerificationStartRequestWhatsAppImpl());

    TestHelpers.recursiveEquals(
        response, VerificationStartResponseTest.expectedStartVerificationWhatsAppDto);
  }
}
