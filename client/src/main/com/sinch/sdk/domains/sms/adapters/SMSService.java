package com.sinch.sdk.domains.sms.adapters;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.sms.BatchesService;
import com.sinch.sdk.domains.sms.WebHooksService;
import com.sinch.sdk.models.Configuration;

public class SMSService implements com.sinch.sdk.domains.sms.SMSService {

  private final Configuration configuration;
  private final HttpClient httpClient;
  private BatchesService batches;
  private WebHooksService webHooks;

  public SMSService(Configuration configuration, HttpClient httpClient) {
    this.configuration = configuration;
    this.httpClient = httpClient;
  }

  @Override
  public BatchesService batches() {
    if (null == this.batches) {
      this.batches =
          new com.sinch.sdk.domains.sms.adapters.BatchesService(configuration, httpClient);
    }
    return this.batches;
  }

  @Override
  public WebHooksService webHooks() {
    if (null == this.webHooks) {
      this.webHooks = new com.sinch.sdk.domains.sms.adapters.WebHooksService();
    }
    return this.webHooks;
  }
}
