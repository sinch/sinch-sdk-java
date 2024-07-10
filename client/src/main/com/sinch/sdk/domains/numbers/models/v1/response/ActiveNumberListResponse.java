package com.sinch.sdk.domains.numbers.models.v1.response;

import com.sinch.sdk.core.models.pagination.ListResponse;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.numbers.api.v1.NumbersService;
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.v1.request.ActiveNumberListRequest;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Lists all active numbers for a project
 *
 * @since 1.2
 */
public class ActiveNumberListResponse extends ListResponse<ActiveNumber> {

  private final Page<ActiveNumberListRequest, ActiveNumber, String> page;
  private final NumbersService service;

  public ActiveNumberListResponse(
      NumbersService service, Page<ActiveNumberListRequest, ActiveNumber, String> page) {
    this.service = service;
    this.page = page;
  }

  public boolean hasNextPage() {
    return (null != page.getNextPageToken() && !StringUtil.isEmpty(page.getNextPageToken()));
  }

  public ActiveNumberListResponse nextPage() {
    if (!hasNextPage()) {
      throw new NoSuchElementException("Reached the last page of the API response");
    }
    ActiveNumberListRequest.Builder newParameters =
        ActiveNumberListRequest.builder(page.getParameters());
    newParameters.setPageToken(page.getNextPageToken());
    return service.list(newParameters.build());
  }

  /**
   * Do not use / Internal usage only
   *
   * @return Internal usage only
   * @deprecated
   */
  public String getNextPageToken() {
    return page.getNextPageToken();
  }

  public Collection<ActiveNumber> getContent() {
    return page.getEntities();
  }

  @Override
  public String toString() {
    return "ActiveNumberListResponse{" + "page=" + page + '}';
  }
}
