package com.sinch.sdk.domains.sms.models.responses;

import com.sinch.sdk.core.models.pagination.ListResponse;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.domains.sms.DeliveryReportsService;
import com.sinch.sdk.domains.sms.models.DeliveryReportRecipient;
import com.sinch.sdk.domains.sms.models.requests.DeliveryReportListRequestParameters;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Lists batches response
 *
 * @since 1.0
 */
public class DeliveryReportsListResponse extends ListResponse<DeliveryReportRecipient> {

  private final Page<DeliveryReportListRequestParameters, DeliveryReportRecipient, Integer> page;
  private final DeliveryReportsService service;

  public DeliveryReportsListResponse(
      DeliveryReportsService service,
      Page<DeliveryReportListRequestParameters, DeliveryReportRecipient, Integer> page) {
    this.service = service;
    this.page = page;
  }

  public boolean hasNextPage() {
    return (null != page.getNextPageToken());
  }

  public DeliveryReportsListResponse nextPage() {
    if (!hasNextPage()) {
      throw new NoSuchElementException("Reached the last page of the API response");
    }
    DeliveryReportListRequestParameters.Builder newParameters =
        DeliveryReportListRequestParameters.builder(page.getParameters());
    newParameters.setPage(page.getNextPageToken());
    return service.list(newParameters.build());
  }

  public Collection<DeliveryReportRecipient> getContent() {
    return page.getEntities();
  }

  @Override
  public String toString() {
    return "DeliveryReportsListResponse{" + "page=" + page + '}';
  }
}
