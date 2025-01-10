package com.sinch.sdk.domains.sms.api.v1;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.BatchDeliveryReport;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.RecipientDeliveryReport;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.request.BatchDeliveryReportQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.request.ListDeliveryReportsQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.response.ListDeliveryReportsResponse;

public interface DeliveryReportsService {

  BatchDeliveryReport get(String batchId) throws ApiException;

  BatchDeliveryReport get(String batchId, BatchDeliveryReportQueryParameters parameters)
      throws ApiException;

  RecipientDeliveryReport getForNumber(String batchId, String recipient) throws ApiException;

  ListDeliveryReportsResponse list() throws ApiException;

  ListDeliveryReportsResponse list(ListDeliveryReportsQueryParameters parameters)
      throws ApiException;
}
