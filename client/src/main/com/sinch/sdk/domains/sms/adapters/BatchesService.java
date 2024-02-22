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
import com.sinch.sdk.models.UnifiedCredentials;
import java.time.Instant;
import java.util.Collection;
import java.util.Map;

public class BatchesService implements com.sinch.sdk.domains.sms.BatchesService {

  private final UnifiedCredentials credentials;
  private final BatchesApi api;

  public BatchesService(
      UnifiedCredentials credentials,
      SmsContext context,
      HttpClient httpClient,
      Map<String, AuthManager> authManagers) {
    this.credentials = credentials;
    this.api = new BatchesApi(httpClient, context.getSmsServer(), authManagers, new HttpMapper());
  }

  protected BatchesApi getApi() {
    return this.api;
  }

  public <T extends Batch<?>> T get(String batchId) throws ApiException {
    return BatchDtoConverter.convert(getApi().getBatchMessage(credentials.getProjectId(), batchId));
  }

  public <T extends Batch<?>> T send(BaseBatch<?> batch) throws ApiException {
    return BatchDtoConverter.convert(
        getApi().sendSMS(credentials.getProjectId(), BatchDtoConverter.convert(batch)));
  }

  public DryRun dryRun(boolean perRecipient, int numberOfRecipient, BaseBatch<?> batch) {
    return DryRunDtoConverter.convert(
        getApi()
            .dryRun(
                credentials.getProjectId(),
                perRecipient,
                numberOfRecipient,
                BatchDtoConverter.convert(batch)));
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
                credentials.getProjectId(),
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
        getApi()
            .updateBatchMessage(
                credentials.getProjectId(), batchId, BatchDtoConverter.convert(batch)));
  }

  public <T extends Batch<?>> T replace(String batchId, BaseBatch<?> batch) throws ApiException {
    return BatchDtoConverter.convert(
        getApi()
            .replaceBatch(credentials.getProjectId(), batchId, BatchDtoConverter.convert(batch)));
  }

  public <T extends Batch<?>> T cancel(String batchId) throws ApiException {
    return BatchDtoConverter.convert(
        getApi().cancelBatchMessage(credentials.getProjectId(), batchId));
  }

  public void sendDeliveryFeedback(String batchId, Collection<String> recipients)
      throws ApiException {
    getApi()
        .deliveryFeedback(
            credentials.getProjectId(), batchId, BatchDtoConverter.convert(recipients));
  }
}
