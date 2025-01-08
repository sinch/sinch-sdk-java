package com.sinch.sdk.domains.sms.api.v1;

public interface SMSService {

  BatchesService batches();

  InboundsService inbounds();

  DeliveryReportsService deliveryReports();

  WebHooksService webhooks();
}
