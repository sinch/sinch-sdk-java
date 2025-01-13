package com.sinch.sdk.domains.sms.api.v1;

public interface SMSService {

  BatchesService batches();

  InboundsService inbounds();

  DeliveryReportsService deliveryReports();

  GroupsService groups();

  WebHooksService webhooks();
}
