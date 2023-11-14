package com.sinch.sdk.domains.sms.adapters;

import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.domains.sms.BatchesService;
import com.sinch.sdk.domains.sms.DeliveryReportsService;
import com.sinch.sdk.domains.sms.InboundsService;
import com.sinch.sdk.domains.sms.WebHooksService;
import com.sinch.sdk.models.Configuration;

public class SMSService implements com.sinch.sdk.domains.sms.SMSService {

  private final Configuration configuration;
  private final HttpClient httpClient;
  private BatchesService batches;
  private WebHooksService webHooks;
  private DeliveryReportsService deliveryReports;
  private InboundsService inbounds;
  private GroupsService groups;

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

  @Override
  public DeliveryReportsService deliveryReports() {
    if (null == this.deliveryReports) {
      this.deliveryReports =
          new com.sinch.sdk.domains.sms.adapters.DeliveryReportsService(configuration, httpClient);
    }
    return this.deliveryReports;
  }

  @Override
  public InboundsService inbounds() {
    if (null == this.inbounds) {
      this.inbounds =
          new com.sinch.sdk.domains.sms.adapters.InboundsService(configuration, httpClient);
    }
    return this.inbounds;
  }

  @Override
  public GroupsService groups() {
    if (null == this.groups) {
      this.groups = new com.sinch.sdk.domains.sms.adapters.GroupsService(configuration, httpClient);
    }
    return this.groups;
  }
}
