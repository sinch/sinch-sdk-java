package com.sinch.sdk.domains.sms.models.responses;

import com.sinch.sdk.core.models.pagination.ListResponse;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.domains.sms.BatchesService;
import com.sinch.sdk.domains.sms.models.Batch;
import com.sinch.sdk.domains.sms.models.requests.BatchesListRequestParameters;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Lists batches response
 *
 * @since 1.0
 */
public class BatchesListResponse extends ListResponse<Batch<?>> {

  private final Page<BatchesListRequestParameters, Batch<?>, Integer> page;
  private final BatchesService service;

  public BatchesListResponse(
      BatchesService service, Page<BatchesListRequestParameters, Batch<?>, Integer> page) {
    this.service = service;
    this.page = page;
  }

  public boolean hasNextPage() {
    return (null != page.getNextPageToken() && null != page.getNextPageToken().getToken());
  }

  public BatchesListResponse nextPage() {
    if (!hasNextPage()) {
      throw new NoSuchElementException("Reached the last page of the API response");
    }
    BatchesListRequestParameters.Builder newParameters =
        BatchesListRequestParameters.builder(page.getParameters());
    Integer nextToken = page.getNextPageToken().getToken();
    newParameters.setPage(nextToken);
    return service.list(newParameters.build());
  }

  public Collection<Batch<?>> getContent() {
    return page.getEntities();
  }

  @Override
  public String toString() {
    return "ActiveNumberListResponse{" + "page=" + page + '}';
  }
}
