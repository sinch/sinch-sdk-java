package com.sinch.sdk.domains.sms.adapters;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.sms.BatchesService;
import com.sinch.sdk.models.Configuration;

public class SMSService implements com.sinch.sdk.domains.sms.SMSService {

  private final Configuration configuration;
  private final HttpClient httpClient;
  private BatchesService batches;

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
}
