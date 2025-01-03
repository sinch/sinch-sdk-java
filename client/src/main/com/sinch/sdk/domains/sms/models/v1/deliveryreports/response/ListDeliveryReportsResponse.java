package com.sinch.sdk.domains.sms.models.v1.deliveryreports.response;

import com.sinch.sdk.core.models.pagination.ListResponse;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.domains.sms.api.v1.DeliveryReportsService;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.RecipientDeliveryReport;
import com.sinch.sdk.domains.sms.models.v1.deliveryreports.request.ListDeliveryReportsQueryParameters;
import java.util.Collection;
import java.util.NoSuchElementException;

public class ListDeliveryReportsResponse extends ListResponse<RecipientDeliveryReport> {

  private final Page<ListDeliveryReportsQueryParameters, RecipientDeliveryReport, Integer> page;
  private final DeliveryReportsService service;
  private ListDeliveryReportsResponse nextPage;

  public ListDeliveryReportsResponse(
      DeliveryReportsService service,
      Page<ListDeliveryReportsQueryParameters, RecipientDeliveryReport, Integer> page) {
    this.service = service;
    this.page = page;
  }

  public boolean hasNextPage() {

    if (null == page.getNextPageToken() || null == getContent() || getContent().isEmpty()) {
      return false;
    }

    if (null == nextPage) {
      ListDeliveryReportsQueryParameters.Builder newParameters =
          ListDeliveryReportsQueryParameters.builder(page.getParameters());
      newParameters.setPage(page.getNextPageToken());
      nextPage = service.list(newParameters.build());
    }
    return (null != nextPage.getContent() && !nextPage.getContent().isEmpty());
  }

  public ListDeliveryReportsResponse nextPage() {

    if (!hasNextPage()) {
      throw new NoSuchElementException("Reached the last page of the API response");
    }

    ListDeliveryReportsResponse response = nextPage;
    nextPage = null;
    return response;
  }

  public Collection<RecipientDeliveryReport> getContent() {
    return page.getEntities();
  }

  @Override
  public String toString() {
    return "RecipientDeliveryReport{" + "page=" + page + '}';
  }
}
