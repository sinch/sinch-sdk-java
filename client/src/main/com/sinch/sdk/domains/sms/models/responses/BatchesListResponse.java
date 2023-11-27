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
  private BatchesListResponse nextPage;

  public BatchesListResponse(
      BatchesService service, Page<BatchesListRequestParameters, Batch<?>, Integer> page) {
    this.service = service;
    this.page = page;
  }

  public boolean hasNextPage() {

    if (null == nextPage) {
      BatchesListRequestParameters.Builder newParameters =
          BatchesListRequestParameters.builder(page.getParameters());
      newParameters.setPage(page.getNextPageToken());
      nextPage = service.list(newParameters.build());
    }
    return (null != nextPage.getContent() && !nextPage.getContent().isEmpty());
  }

  public BatchesListResponse nextPage() {

    if (!hasNextPage()) {
      throw new NoSuchElementException("Reached the last page of the API response");
    }

    BatchesListResponse response = nextPage;
    nextPage = null;
    return response;
  }

  public Collection<Batch<?>> getContent() {
    return page.getEntities();
  }

  @Override
  public String toString() {
    return "BatchesListResponse{" + "page=" + page + '}';
  }
}
