package com.sinch.sdk.domains.mailgun.adapters;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.conversation.api.templates.adapters.TemplatesService;
import com.sinch.sdk.models.MailgunContext;
import com.sinch.sdk.models.MailgunCredentials;

public class MailgunService implements com.sinch.sdk.domains.mailgun.MailgunService {

  private final MailgunCredentials credentials;
  private final MailgunContext context;
  private final HttpClient httpClient;

  private com.sinch.sdk.domains.mailgun.api.v1.MailgunService mailgunV1;
  private TemplatesService templates;

  public MailgunService(
      MailgunCredentials credentials, MailgunContext context, HttpClient httpClient) {
    this.credentials = credentials;
    this.context = context;
    this.httpClient = httpClient;
  }

  public com.sinch.sdk.domains.mailgun.api.v1.MailgunService v1() {
    if (null == this.mailgunV1) {
      this.mailgunV1 =
          new com.sinch.sdk.domains.mailgun.api.v1.adapters.MailgunService(
              credentials, context, httpClient);
    }
    return this.mailgunV1;
  }
}
