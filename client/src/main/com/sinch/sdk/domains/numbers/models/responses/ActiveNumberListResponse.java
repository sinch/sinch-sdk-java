package com.sinch.sdk.domains.numbers.models.responses;

import com.sinch.sdk.core.models.pagination.ListResponse;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.core.utils.StringUtil;
import com.sinch.sdk.domains.numbers.ActiveNumberService;
import com.sinch.sdk.domains.numbers.models.ActiveNumber;
import com.sinch.sdk.domains.numbers.models.requests.ActiveNumberListRequestParameters;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Lists all active numbers for a project
 *
 * @since 1.0
 */
public class ActiveNumberListResponse extends ListResponse<ActiveNumber> {

  private final Page<ActiveNumberListRequestParameters, ActiveNumber, String> page;
  private final ActiveNumberService service;

  public ActiveNumberListResponse(
      ActiveNumberService service,
      Page<ActiveNumberListRequestParameters, ActiveNumber, String> page) {
    this.service = service;
    this.page = page;
  }

  public boolean hasNextPage() {
    return (null != page.getNextPageToken()
        && !StringUtil.isEmpty(page.getNextPageToken().getToken()));
  }

  public ActiveNumberListResponse nextPage() {
    if (!hasNextPage()) {
      throw new NoSuchElementException("Reached the last page of the API response");
    }
    ActiveNumberListRequestParameters.Builder newParameters =
        new ActiveNumberListRequestParameters.Builder(page.getParameters());
    String nextToken = page.getNextPageToken().getToken();
    newParameters.setPageToken(nextToken);
    return service.list(newParameters.build());
  }

  public Collection<ActiveNumber> getContent() {
    return page.getEntities();
  }

  @Override
  public String toString() {
    return "ActiveNumberListResponse{" + "page=" + page + '}';
  }
}
