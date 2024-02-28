package com.sinch.sdk.domains.sms.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.AuthManager;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.domains.sms.adapters.api.v1.BatchesApi;
import com.sinch.sdk.domains.sms.adapters.converters.BatchDtoConverter;
import com.sinch.sdk.domains.sms.adapters.converters.DryRunDtoConverter;
import com.sinch.sdk.domains.sms.models.BaseBatch;
import com.sinch.sdk.domains.sms.models.Batch;
import com.sinch.sdk.domains.sms.models.DryRun;
import com.sinch.sdk.domains.sms.models.SMSCursorPageNavigator;
import com.sinch.sdk.domains.sms.models.dto.v1.ApiBatchListDto;
import com.sinch.sdk.domains.sms.models.requests.BatchesListRequestParameters;
import com.sinch.sdk.domains.sms.models.requests.UpdateBaseBatchRequest;
import com.sinch.sdk.domains.sms.models.responses.BatchesListResponse;
import com.sinch.sdk.models.SmsContext;
import java.time.Instant;
import java.util.Collection;
import java.util.Map;

public class BatchesService implements com.sinch.sdk.domains.sms.BatchesService {

  private final String uriUUID;
  private final BatchesApi api;

  public BatchesService(
      String uriUUID,
      SmsContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers) {
    this.uriUUID = uriUUID;
    this.api = new BatchesApi(httpClient, context.getSmsServer(), authManagers, new HttpMapper());
  }

  protected BatchesApi getApi() {
    return this.api;
  }

  public <T extends Batch<?>> T get(String batchId) throws ApiException {
    return BatchDtoConverter.convert(getApi().getBatchMessage(uriUUID, batchId));
  }

  public <T extends Batch<?>> T send(BaseBatch<?> batch) throws ApiException {
    return BatchDtoConverter.convert(getApi().sendSMS(uriUUID, BatchDtoConverter.convert(batch)));
  }

  public DryRun dryRun(boolean perRecipient, int numberOfRecipient, BaseBatch<?> batch) {
    return DryRunDtoConverter.convert(
        getApi()
            .dryRun(uriUUID, perRecipient, numberOfRecipient, BatchDtoConverter.convert(batch)));
  }

  public BatchesListResponse list() throws ApiException {
    return this.list(null);
  }

  public BatchesListResponse list(BatchesListRequestParameters parameters) throws ApiException {

    BatchesListRequestParameters guardParameters =
        null != parameters ? parameters : BatchesListRequestParameters.builder().build();

    ApiBatchListDto response =
        getApi()
            .listBatches(
                uriUUID,
                guardParameters.getPage().orElse(null),
                guardParameters.getPageSize().orElse(null),
                guardParameters.getFrom().orElse(null),
                guardParameters.getStartDate().map(Instant::toString).orElse(null),
                guardParameters.getEndDate().map(Instant::toString).orElse(null),
                guardParameters.getClientReference().orElse(null));

    Collection<Batch<?>> content = BatchDtoConverter.convert(response);
    SMSCursorPageNavigator navigator =
        new SMSCursorPageNavigator(response.getPage(), response.getPageSize());

    return new BatchesListResponse(this, new Page<>(guardParameters, content, navigator));
  }

  public <T extends Batch<?>> T update(String batchId, UpdateBaseBatchRequest<?> batch)
      throws ApiException {
    return BatchDtoConverter.convert(
        getApi().updateBatchMessage(uriUUID, batchId, BatchDtoConverter.convert(batch)));
  }

  public <T extends Batch<?>> T replace(String batchId, BaseBatch<?> batch) throws ApiException {
    return BatchDtoConverter.convert(
        getApi().replaceBatch(uriUUID, batchId, BatchDtoConverter.convert(batch)));
  }

  public <T extends Batch<?>> T cancel(String batchId) throws ApiException {
    return BatchDtoConverter.convert(getApi().cancelBatchMessage(uriUUID, batchId));
  }

  public void sendDeliveryFeedback(String batchId, Collection<String> recipients)
      throws ApiException {
    getApi().deliveryFeedback(uriUUID, batchId, BatchDtoConverter.convert(recipients));
  }
}
