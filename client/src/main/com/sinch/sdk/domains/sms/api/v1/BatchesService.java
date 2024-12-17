package com.sinch.sdk.domains.sms.api.v1;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.sms.models.v1.batches.request.BatchRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.request.ListBatchesRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.request.SendDeliveryFeedbackRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.request.UpdateBatchRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.response.BatchResponse;
import com.sinch.sdk.domains.sms.models.v1.batches.response.DryRunResponse;
import com.sinch.sdk.domains.sms.models.v1.batches.response.ListBatchesResponse;

public interface BatchesService {

  BatchResponse send(BatchRequest batch) throws ApiException;

  ListBatchesResponse list(ListBatchesRequest parameters) throws ApiException;

  DryRunResponse dryRun(boolean perRecipient, int numberOfRecipient, BatchRequest batch);

  BatchResponse get(String batchId) throws ApiException;

  BatchResponse replace(String batchId, BatchRequest batch) throws ApiException;

  BatchResponse cancel(String batchId) throws ApiException;

  void sendDeliveryFeedback(String batchId, SendDeliveryFeedbackRequest recipients)
      throws ApiException;

  BatchResponse update(String batchId, UpdateBatchRequest request) throws ApiException;
}
