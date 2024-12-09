package com.sinch.sdk.domains.sms.models.v1.batches.response;

import com.sinch.sdk.core.models.pagination.ListResponse;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.domains.sms.api.v1.BatchesService;
import com.sinch.sdk.domains.sms.models.v1.batches.request.ListBatchesRequest;
import java.util.Collection;
import java.util.NoSuchElementException;

public class ListBatchesResponse extends ListResponse<Batch> {

  private final Page<ListBatchesRequest, Batch, Integer> page;
  private final BatchesService service;
  private ListBatchesResponse nextPage;

  public ListBatchesResponse(
      BatchesService service, Page<ListBatchesRequest, Batch, Integer> page) {
    this.service = service;
    this.page = page;
  }

  public boolean hasNextPage() {

    if (null == nextPage) {
      ListBatchesRequest.Builder newParameters = ListBatchesRequest.builder(page.getParameters());
      newParameters.setPage(page.getNextPageToken());
      nextPage = service.list(newParameters.build());
    }
    return (null != nextPage.getContent() && !nextPage.getContent().isEmpty());
  }

  public ListBatchesResponse nextPage() {

    if (!hasNextPage()) {
      throw new NoSuchElementException("Reached the last page of the API response");
    }

    ListBatchesResponse response = nextPage;
    nextPage = null;
    return response;
  }

  public Collection<Batch> getContent() {
    return page.getEntities();
  }

  @Override
  public String toString() {
    return "ListBatchesResponse{" + "page=" + page + '}';
  }
}