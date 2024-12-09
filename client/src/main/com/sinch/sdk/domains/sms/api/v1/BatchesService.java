package com.sinch.sdk.domains.sms.api.v1;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.domains.sms.models.v1.batches.request.BatchRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.request.ListBatchesRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.request.SendDeliveryFeedbackRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.response.Batch;
import com.sinch.sdk.domains.sms.models.v1.batches.response.DryRunResponse;
import com.sinch.sdk.domains.sms.models.v1.batches.response.ListBatchesResponse;

public interface BatchesService {

  Batch send(BatchRequest batch) throws ApiException;

  ListBatchesResponse list(ListBatchesRequest parameters) throws ApiException;

  DryRunResponse dryRun(boolean perRecipient, int numberOfRecipient, BatchRequest batch);

  Batch get(String batchId) throws ApiException;

  Batch replace(String batchId, BatchRequest batch) throws ApiException;

  Batch cancel(String batchId) throws ApiException;

  void sendDeliveryFeedback(String batchId, SendDeliveryFeedbackRequest recipients)
      throws ApiException;
}
