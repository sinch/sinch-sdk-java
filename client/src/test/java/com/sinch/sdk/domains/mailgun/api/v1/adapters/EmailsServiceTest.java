package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.GivenTextResource;
import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
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
import com.sinch.sdk.core.models.ServerConfigurationTest.ServerConfigurationMatcher;
import com.sinch.sdk.domains.mailgun.api.v1.EmailsService;
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.ResendRequestTest;
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.SendEmailRequestTest;
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.SendMimeEmailRequestTest;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.GetStoredEmailResponse;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.GetStoredEmailResponseTest;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.SendEmailResponse;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.SendEmailResponseTest;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.SendingQueuesStatusResponse;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.SendingQueuesStatusResponseTest;
import java.util.Collections;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

@TestWithResources
class EmailsServiceTest extends BaseTest {

  static final String AUTH_NAME = "basicAuth";

  @GivenTextResource("/domains/mailgun/v1/emails/response/GetStoredEmailResponseDto.json")
  String jsonGetEmailResponseDto;

  @GivenTextResource("/domains/mailgun/v1/emails/response/SendingQueuesStatusResponseDto.json")
  String jsonSendingQueuesStatusResponseDto;

  @GivenTextResource("/domains/mailgun/v1/emails/response/SendEmailResponseDto.json")
  String jsonSendEmailResponseDto;

  @Mock ServerConfiguration serverConfiguration;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;

  EmailsService service;

  String domainName = "foo Domain";
  String storageKey = "foo StorageKey";

  @BeforeEach
  public void initMocks() {
    service =
        new EmailsServiceImpl(
            httpClient, serverConfiguration, authManagers, HttpMapper.getInstance());
  }

  @Test
  void send() {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v3/" + URLPathUtils.encodePathSegment(domainName) + "/messages",
            HttpMethod.POST,
            Collections.emptyList(),
            SendEmailRequestTest.expectedEmailHtmlInline,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.MULTIPART_FORM_DATA),
            Collections.singletonList(AUTH_NAME));
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonSendEmailResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    SendEmailResponse response =
        service.sendEmail(domainName, SendEmailRequestTest.sendEmailHtmlInlineRequest);

    TestHelpers.recursiveEquals(response, SendEmailResponseTest.expectedSendEmailResponse);
  }

  @Test
  void sendMime() {
    HttpRequest httpRequest =
        new HttpRequest(
            "/v3/" + URLPathUtils.encodePathSegment(domainName) + "/messages.mime",
            HttpMethod.POST,
            Collections.emptyList(),
            SendMimeEmailRequestTest.expected,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.MULTIPART_FORM_DATA),
            Collections.singletonList(AUTH_NAME));
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonSendEmailResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    SendEmailResponse response =
        service.sendMimeEmail(domainName, SendMimeEmailRequestTest.sendMimEmailRequest);

    TestHelpers.recursiveEquals(response, SendEmailResponseTest.expectedSendEmailResponse);
  }

  @Test
  void resend() {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v3/domains/"
                + URLPathUtils.encodePathSegment(domainName)
                + "/messages/foo%20StorageKey",
            HttpMethod.POST,
            Collections.emptyList(),
            ResendRequestTest.expectedResendRequest,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.singletonList(HttpContentType.MULTIPART_FORM_DATA),
            Collections.singletonList(AUTH_NAME));
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonSendEmailResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    SendEmailResponse response =
        service.resend(domainName, storageKey, ResendRequestTest.resentRequest);

    TestHelpers.recursiveEquals(response, SendEmailResponseTest.expectedSendEmailResponse);
  }

  @Test
  void get() {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v3/domains/"
                + URLPathUtils.encodePathSegment(domainName)
                + "/messages/foo%20StorageKey",
            HttpMethod.GET,
            Collections.emptyList(),
            (Map) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(AUTH_NAME));
    HttpResponse httpResponse =
        new HttpResponse(200, null, Collections.emptyMap(), jsonGetEmailResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    GetStoredEmailResponse response = service.getStoredEmail(domainName, storageKey);

    TestHelpers.recursiveEquals(response, GetStoredEmailResponseTest.expectedGetEmailResponse);
  }

  @Test
  void getSendingQueuesStatus() {
    HttpRequest httpRequest =
        new HttpRequest(
            "/v3/domains/" + URLPathUtils.encodePathSegment(domainName) + "/sending_queues",
            HttpMethod.GET,
            Collections.emptyList(),
            (Map) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(AUTH_NAME));
    HttpResponse httpResponse =
        new HttpResponse(
            200, null, Collections.emptyMap(), jsonSendingQueuesStatusResponseDto.getBytes());

    when(httpClient.invokeAPI(
            eq(serverConfiguration),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    SendingQueuesStatusResponse response = service.getSendingQueuesStatus(domainName);

    TestHelpers.recursiveEquals(
        response, SendingQueuesStatusResponseTest.expectedSendingQueuesStatusResponse);
  }

  @Test
  void purgeSendingQueue() {

    HttpRequest httpRequest =
        new HttpRequest(
            "/v3/" + URLPathUtils.encodePathSegment(domainName) + "/envelopes",
            HttpMethod.DELETE,
            Collections.emptyList(),
            (String) null,
            Collections.emptyMap(),
            Collections.singletonList(HttpContentType.APPLICATION_JSON),
            Collections.emptyList(),
            Collections.singletonList(AUTH_NAME));
    HttpResponse httpResponse = new HttpResponse(200, null, Collections.emptyMap(), null);

    when(httpClient.invokeAPI(
            argThat(new ServerConfigurationMatcher(new ServerConfiguration("my foo URL"))),
            eq(authManagers),
            argThat(new HttpRequestMatcher(httpRequest))))
        .thenReturn(httpResponse);

    service.purgeSendingQueue(domainName, "my foo URL");
  }
}
