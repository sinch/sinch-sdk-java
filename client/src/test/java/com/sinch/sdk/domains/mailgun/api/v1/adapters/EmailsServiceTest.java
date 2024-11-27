package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.adelean.inject.resources.junit.jupiter.TestWithResources;
import com.sinch.sdk.BaseTest;
import com.sinch.sdk.core.TestHelpers;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.mailgun.api.v1.internal.EmailsApi;
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.SendEmailRequestTest;
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.SendMimeEmailRequestTest;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.GetStoredEmailResponse;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.GetStoredEmailResponseTest;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.SendEmailResponse;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.SendEmailResponseTest;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.SendingQueuesStatusResponse;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.SendingQueuesStatusResponseTest;
import com.sinch.sdk.models.MailgunContext;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;

@TestWithResources
class EmailsServiceTest extends BaseTest {

  @Mock MailgunContext context;
  @Mock EmailsApi api;
  @Mock HttpClient httpClient;
  @Mock Map<String, AuthManager> authManagers;
  @Captor ArgumentCaptor<String> domainNameCaptor;

  EmailsService service;

  String domainName = "fooDomain";
  String storageKey = "fooStorageKey";

  @BeforeEach
  public void initMocks() {
    service = spy(new EmailsService(context, httpClient, authManagers));
    doReturn(api).when(service).getApi();
  }

  @Test
  void send() {
    when(api.sendEmail(eq(domainName), eq(SendEmailRequestTest.sendEmailRequest)))
        .thenReturn(SendEmailResponseTest.expectedSendEmailResponse);

    SendEmailResponse response = service.send(domainName, SendEmailRequestTest.sendEmailRequest);

    TestHelpers.recursiveEquals(response, SendEmailResponseTest.expectedSendEmailResponse);
  }

  @Test
  void sendMime() {
    when(api.sendMimeEmail(eq(domainName), eq(SendMimeEmailRequestTest.sendMimEmailRequest)))
        .thenReturn(SendEmailResponseTest.expectedSendEmailResponse);

    SendEmailResponse response =
        service.sendMime(domainName, SendMimeEmailRequestTest.sendMimEmailRequest);

    TestHelpers.recursiveEquals(response, SendEmailResponseTest.expectedSendEmailResponse);
  }

  @Test
  void get() {
    when(api.getStoredEmail(eq(domainName), eq(storageKey)))
        .thenReturn(GetStoredEmailResponseTest.expectedGetEmailResponse);

    GetStoredEmailResponse response = service.get(domainName, storageKey);

    TestHelpers.recursiveEquals(response, GetStoredEmailResponseTest.expectedGetEmailResponse);
  }

  @Test
  void getSendingQueuesStatus() {
    when(api.getSendingQueuesStatus(eq(domainName)))
        .thenReturn(SendingQueuesStatusResponseTest.expectedSendingQueuesStatusResponse);

    SendingQueuesStatusResponse response = service.getSendingQueuesStatus(domainName);

    TestHelpers.recursiveEquals(
        response, SendingQueuesStatusResponseTest.expectedSendingQueuesStatusResponse);
  }

  @Test
  void purgeDomainQueues() {

    service.purgeDomainQueues(domainName);

    verify(api).purgeDomainQueues(domainNameCaptor.capture());

    Assertions.assertThat(domainNameCaptor.getValue()).isEqualTo(domainName);
  }
}
