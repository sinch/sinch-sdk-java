package com.sinch.sdk.domains.sms.adapters;

import com.sinch.sdk.core.exceptions.ApiException;
import com.sinch.sdk.core.http.HttpClient;
import com.sinch.sdk.core.http.HttpMapper;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.core.models.pagination.PageToken;
import com.sinch.sdk.core.utils.Pair;
import com.sinch.sdk.domains.sms.adapters.api.v1.BatchesApi;
import com.sinch.sdk.domains.sms.adapters.converters.BatchDtoConverter;
import com.sinch.sdk.domains.sms.adapters.converters.DryRunDtoConverter;
import com.sinch.sdk.domains.sms.models.BaseBatch;
import com.sinch.sdk.domains.sms.models.Batch;
import com.sinch.sdk.domains.sms.models.DryRun;
import com.sinch.sdk.domains.sms.models.dto.v1.ApiBatchListDto;
import com.sinch.sdk.domains.sms.models.requests.BatchesListRequestParameters;
import com.sinch.sdk.domains.sms.models.responses.BatchesListResponse;
import com.sinch.sdk.models.Configuration;
import java.time.Instant;
import java.util.Collection;

public class BatchesService implements com.sinch.sdk.domains.sms.BatchesService {

  private Configuration configuration;
  private BatchesApi api;

  public BatchesService() {}

  public BatchesService(Configuration configuration, HttpClient httpClient) {
    this.configuration = configuration;
    this.api = new BatchesApi(httpClient, configuration.getSmsServer(), new HttpMapper());
  }

  private BatchesApi getApi() {
    return this.api;
  }

  public <T extends Batch<?>> T get(String batchId) throws ApiException {
    return BatchDtoConverter.convert(
        getApi().getBatchMessage(configuration.getProjectId(), batchId));
  }

  public <T extends Batch<?>> T send(BaseBatch<?> batch) throws ApiException {
    return BatchDtoConverter.convert(
        getApi().sendSMS(configuration.getProjectId(), BatchDtoConverter.convert(batch)));
  }

  public DryRun dryRun(boolean perRecipient, int numberOfRecipient, BaseBatch<?> batch) {
    return DryRunDtoConverter.convert(
        getApi()
            .dryRun(
                configuration.getProjectId(),
                perRecipient,
                numberOfRecipient,
                BatchDtoConverter.convert(batch)));
  }

  public BatchesListResponse list(BatchesListRequestParameters parameters) throws ApiException {

    BatchesListRequestParameters guardParameters =
        null != parameters ? parameters : BatchesListRequestParameters.builder().build();

    ApiBatchListDto response =
        getApi()
            .listBatches(
                configuration.getProjectId(),
                guardParameters.getPage().orElse(null),
                guardParameters.getPageSize().orElse(null),
                guardParameters.getFrom().orElse(null),
                guardParameters.getStartDate().map(Instant::toString).orElse(null),
                guardParameters.getEndDate().map(Instant::toString).orElse(null),
                guardParameters.getClientReference().orElse(null));

    Pair<Collection<Batch<?>>, PageToken<Integer>> content = BatchDtoConverter.convert(response);

    return new BatchesListResponse(
        this, new Page<>(guardParameters, content.getLeft(), content.getRight()));
  }
}
