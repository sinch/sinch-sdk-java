package com.sinch.sdk.domains.mailgun.api.v1.adapters;

import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.domains.mailgun.api.v1.internal.EmailsApi;
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.SendEmailRequest;
import com.sinch.sdk.domains.mailgun.models.v1.emails.request.SendMimeEmailRequest;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.GetStoredEmailResponse;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.SendEmailResponse;
import com.sinch.sdk.domains.mailgun.models.v1.emails.response.SendingQueuesStatusResponse;
import com.sinch.sdk.models.MailgunContext;
import java.util.Map;

public class EmailsService implements com.sinch.sdk.domains.mailgun.api.v1.EmailsService {

  private final EmailsApi api;

  public EmailsService(
      MailgunContext context, HttpClient httpClient, Map<String, AuthManager> authManagers) {
    this.api = new EmailsApi(httpClient, context.getServer(), authManagers, new HttpMapper());
  }

  protected EmailsApi getApi() {
    return this.api;
  }

  public SendEmailResponse sendEmail(String domain, SendEmailRequest request) {
    return getApi().sendEmail(domain, request);
  }

  public SendEmailResponse sendMimeEmail(String domain, SendMimeEmailRequest request) {
    return getApi().sendMimeEmail(domain, request);
  }

  public GetStoredEmailResponse getStoredEmail(String domain, String storageKey) {
    return getApi().getStoredEmail(domain, storageKey);
  }

  public SendingQueuesStatusResponse getSendingQueuesStatus(String domain) {
    return getApi().getSendingQueuesStatus(domain);
  }

  public void purgeSendingQueue(String domainName, String storageURL) {
    getApi().purgeSendingQueue(domainName, storageURL);
  }
}
