package com.sinch.sdk.domains.sms.api.v1.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.domains.sms.api.v1.internal.BatchesApi;
import com.sinch.sdk.domains.sms.models.v1.batches.internal.SMSCursorPageNavigator;
import com.sinch.sdk.domains.sms.models.v1.batches.request.BatchRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.request.ListBatchesRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.request.SendDeliveryFeedbackRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.request.UpdateBatchRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.response.Batch;
import com.sinch.sdk.domains.sms.models.v1.batches.response.DryRunResponse;
import com.sinch.sdk.domains.sms.models.v1.batches.response.ListBatchesResponse;
import com.sinch.sdk.domains.sms.models.v1.batches.response.internal.ApiBatchList;
import com.sinch.sdk.models.SmsContext;
import java.time.Instant;
import java.util.Map;

public class BatchesService implements com.sinch.sdk.domains.sms.api.v1.BatchesService {

  private final BatchesApi api;

  public BatchesService(
      String uriUUID,
      SmsContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers) {
    this.api =
        new BatchesApi(httpClient, context.getSmsServer(), authManagers, new HttpMapper(), uriUUID);
  }

  protected BatchesApi getApi() {
    return this.api;
  }

  public Batch send(BatchRequest batch) throws ApiException {
    return getApi().send(batch);
  }

  public ListBatchesResponse list(ListBatchesRequest parameters) throws ApiException {

    ListBatchesRequest guardParameters =
        null != parameters ? parameters : ListBatchesRequest.builder().build();

    ApiBatchList response =
        getApi()
            .list(
                guardParameters.getPage().orElse(null),
                guardParameters.getPageSize().orElse(null),
                guardParameters.getFrom().orElse(null),
                guardParameters.getStartDate().map(Instant::toString).orElse(null),
                guardParameters.getEndDate().map(Instant::toString).orElse(null),
                guardParameters.getClientReference().orElse(null));

    SMSCursorPageNavigator navigator =
        new SMSCursorPageNavigator(response.getPage(), response.getPageSize());

    return new ListBatchesResponse(
        this, new Page<>(guardParameters, response.getBatches(), navigator));
  }

  public DryRunResponse dryRun(boolean perRecipient, int numberOfRecipient, BatchRequest batch) {
    return getApi().dryRun(perRecipient, numberOfRecipient, batch);
  }

  public Batch get(String batchId) throws ApiException {
    return getApi().get(batchId);
  }

  public Batch replace(String batchId, BatchRequest batch) throws ApiException {
    return getApi().replace(batchId, batch);
  }

  public Batch cancel(String batchId) throws ApiException {
    return getApi().cancel(batchId);
  }

  public void sendDeliveryFeedback(String batchId, SendDeliveryFeedbackRequest request)
      throws ApiException {
    getApi().sendDeliveryFeedback(batchId, request);
  }

  public Batch update(String batchId, UpdateBatchRequest request) throws ApiException {
    return getApi().update(batchId, request);
  }
}
