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
import com.sinch.sdk.domains.verification.api.v1.VerificationsStatusService;
import com.sinch.sdk.domains.verification.models.dto.v1.status.VerificationStatusResponseTest;
import com.sinch.sdk.domains.verification.models.v1.NumberIdentity;
import com.sinch.sdk.domains.verification.models.v1.VerificationMethod;
import com.sinch.sdk.domains.verification.models.v1.status.response.VerificationStatusResponse;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
public class VerificationStatusServiceTest extends VerificationBaseTest {

  @GivenTextResource("/domains/verification/v1/status/VerificationStatusResponseSmsDto.json")
  String verificationStatusResponseSmsDto;

  @GivenTextResource("/domains/verification/v1/status/VerificationStatusResponsePhoneCallDto.json")
  String verificationStatusResponsePhoneCallDto;

  @GivenTextResource("/domains/verification/v1/status/VerificationStatusResponseFlashCallDto.json")
  String verificationStatusResponseFlashCallDto;

  static final Collection<String> AUTH_NAMES = Arrays.asList("Basic", "Application");

  @Mock ServerConfiguration serverConfiguration;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  VerificationsStatusService service;

  @BeforeEach
  public void initMocks() {
    service =
        new VerificationsStatusServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance());
  }

  @Test
  void getByIdentity() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/verification/v1/verifications/"
                + URLPathUtils.encodePathSegment(VerificationMethod.SMS.toString())
                + "/number/"
                + URLPathUtils.encodePathSegment("endpoint string"),
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), verificationStatusResponseSmsDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    VerificationStatusResponse response =
        service.getByIdentity(
            NumberIdentity.builder().setEndpoint("endpoint string").build(),
            VerificationMethod.SMS);

    TestHelpers.recursiveEquals(
        response, VerificationStatusResponseTest.expectedVerificationSmsDto);
  }

  @Test
  void getById() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/verification/v1/verifications/id/" + URLPathUtils.encodePathSegment("the id"),
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), verificationStatusResponsePhoneCallDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    VerificationStatusResponse response = service.getById("the id");

    TestHelpers.recursiveEquals(
        response, VerificationStatusResponseTest.expectedVerificationPhoneCallDto);
  }

  @Test
  void getByReference() throws ApiException {

    HttpRequest httpRequest =
        new HttpRequest(
            "/verification/v1/verifications/reference/"
                + URLPathUtils.encodePathSegment("the reference"),
            HttpMethod.GET,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            AUTH_NAMES);
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), verificationStatusResponseFlashCallDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    VerificationStatusResponse response = service.getByReference("the reference");

    TestHelpers.recursiveEquals(
        response, VerificationStatusResponseTest.expectedVerificationFlashCallDto);
  }
}
