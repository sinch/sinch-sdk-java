package com.sinch.sdk.domains.sms.api.v1.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.domains.sms.api.v1.internal.BatchesApi;
import com.sinch.sdk.domains.sms.models.v1.batches.internal.SMSCursorPageNavigator;
import com.sinch.sdk.domains.sms.models.v1.batches.request.BatchRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.request.DryRunQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.batches.request.ListBatchesQueryParameters;
import com.sinch.sdk.domains.sms.models.v1.batches.request.SendDeliveryFeedbackRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.request.UpdateBatchRequest;
import com.sinch.sdk.domains.sms.models.v1.batches.response.BatchResponse;
import com.sinch.sdk.domains.sms.models.v1.batches.response.DryRunResponse;
import com.sinch.sdk.domains.sms.models.v1.batches.response.ListBatchesResponse;
import com.sinch.sdk.domains.sms.models.v1.batches.response.internal.ApiBatchList;
import com.sinch.sdk.models.SmsContext;
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

  public BatchResponse send(BatchRequest batch) throws ApiException {
    return getApi().send(batch);
  }

  public ListBatchesResponse list(ListBatchesQueryParameters parameters) throws ApiException {

    ListBatchesQueryParameters guardParameters =
        null != parameters ? parameters : ListBatchesQueryParameters.builder().build();

    ApiBatchList response = getApi().list(parameters);

    SMSCursorPageNavigator navigator =
        new SMSCursorPageNavigator(response.getPage(), response.getPageSize());

    return new ListBatchesResponse(
        this, new Page<>(guardParameters, response.getBatches(), navigator));
  }

  public DryRunResponse dryRun(DryRunQueryParameters queryParameters, BatchRequest batch) {
    return getApi().dryRun(queryParameters, batch);
  }

  public BatchResponse get(String batchId) throws ApiException {
    return getApi().get(batchId);
  }

  public BatchResponse replace(String batchId, BatchRequest batch) throws ApiException {
    return getApi().replace(batchId, batch);
  }

  public BatchResponse cancel(String batchId) throws ApiException {
    return getApi().cancel(batchId);
  }

  public void sendDeliveryFeedback(String batchId, SendDeliveryFeedbackRequest request)
      throws ApiException {
    getApi().sendDeliveryFeedback(batchId, request);
  }

  public BatchResponse update(String batchId, UpdateBatchRequest request) throws ApiException {
    return getApi().update(batchId, request);
  }
}
