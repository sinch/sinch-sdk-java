package com.sinch.sdk.domains.sms.models.v1.inbounds.response;

import com.sinch.sdk.core.models.pagination.ListResponse;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.domains.sms.api.v1.InboundsService;
import com.sinch.sdk.domains.sms.models.v1.inbounds.InboundMessage;
import com.sinch.sdk.domains.sms.models.v1.inbounds.request.ListInboundMessagesQueryParameters;
import java.util.Collection;
import java.util.NoSuchElementException;

public class ListInboundsResponse extends ListResponse<InboundMessage> {

  private final Page<ListInboundMessagesQueryParameters, InboundMessage, Integer> page;
  private final InboundsService service;
  private ListInboundsResponse nextPage;

  public ListInboundsResponse(
      InboundsService service,
      Page<ListInboundMessagesQueryParameters, InboundMessage, Integer> page) {
    this.service = service;
    this.page = page;
  }

  public boolean hasNextPage() {

    if (null == page.getNextPageToken() || null == getContent() || getContent().isEmpty()) {
      return false;
    }

    if (null == nextPage) {
      ListInboundMessagesQueryParameters.Builder newParameters =
          ListInboundMessagesQueryParameters.builder(page.getParameters());
      newParameters.setPage(page.getNextPageToken());
      nextPage = service.list(newParameters.build());
    }
    return (null != nextPage.getContent() && !nextPage.getContent().isEmpty());
  }

  public ListInboundsResponse nextPage() {

    if (!hasNextPage()) {
      throw new NoSuchElementException("Reached the last page of the API response");
    }

    ListInboundsResponse response = nextPage;
    nextPage = null;
    return response;
  }

  public Collection<InboundMessage> getContent() {
    return page.getEntities();
  }

  @Override
  public String toString() {
    return "ListInboundsResponse{" + "page=" + page + '}';
  }
}
