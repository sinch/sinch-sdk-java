package com.sinch.sdk.domains.sms.models.responses;

import com.sinch.sdk.core.models.pagination.ListResponse;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.domains.sms.InboundsService;
import com.sinch.sdk.domains.sms.models.Inbound;
import com.sinch.sdk.domains.sms.models.requests.InboundsListRequestParameters;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * List Incoming Messages response
 *
 * @since 1.0
 */
public class InboundsListResponse extends ListResponse<Inbound<?>> {

  private final Page<InboundsListRequestParameters, Inbound<?>, Integer> page;
  private final InboundsService service;

  public InboundsListResponse(
      InboundsService service, Page<InboundsListRequestParameters, Inbound<?>, Integer> page) {
    this.service = service;
    this.page = page;
  }

  public boolean hasNextPage() {
    return (null != page.getNextPageToken());
  }

  public InboundsListResponse nextPage() {
    if (!hasNextPage()) {
      throw new NoSuchElementException("Reached the last page of the API response");
    }
    InboundsListRequestParameters.Builder newParameters =
        InboundsListRequestParameters.builder(page.getParameters());
    newParameters.setPage(page.getNextPageToken());
    return service.list(newParameters.build());
  }

  public Collection<Inbound<?>> getContent() {
    return page.getEntities();
  }

  @Override
  public String toString() {
    return "InboundsListResponse{" + "page=" + page + '}';
  }
}
