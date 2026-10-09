package com.sinch.sdk.domains.voice.models.v2.services.response;

import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.models.pagination.ListResponse;
import com.sinch.sdk.core.models.pagination.Page;
import java.util.Collection;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

/** Auto paginated response for list of ServiceShortResponse */
public class ServicesListResponse extends ListResponse<ServiceShortResponse> {

  private final Page<ServiceShortResponse, HttpRequest> page;
  private final Supplier<ServicesListResponse> supplier;

  public ServicesListResponse(
      Supplier<ServicesListResponse> supplier, Page<ServiceShortResponse, HttpRequest> page) {
    this.supplier = supplier;
    this.page = page;
  }

  @Override
  public boolean hasNextPage() {
    if (null == page.getNextPageToken() || null == getContent() || getContent().isEmpty()) {
      return false;
    }
    return true;
  }

  @Override
  public ServicesListResponse nextPage() {
    if (!hasNextPage()) {
      throw new NoSuchElementException("Reached the last page of the API response");
    }
    return supplier.get();
  }

  @Override
  public Collection<ServiceShortResponse> getContent() {
    return page == null ? Collections.emptyList() : page.getEntities();
  }

  @Override
  public String toString() {
    return "ServicesListResponse {" + "page=" + page + '}';
  }
}
