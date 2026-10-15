package com.sinch.sdk.domains.voice.models.v2.calls.response;

import com.sinch.sdk.core.http.HttpRequest;
import com.sinch.sdk.core.models.pagination.ListResponse;
import com.sinch.sdk.core.models.pagination.Page;
import com.sinch.sdk.domains.voice.models.v2.Call;
import java.util.Collection;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.function.Supplier;

/** Auto paginated response for list of Call */
public class CallsListResponse extends ListResponse<Call> {

  private final Page<Call, HttpRequest> page;
  private final Supplier<CallsListResponse> supplier;

  public CallsListResponse(Supplier<CallsListResponse> supplier, Page<Call, HttpRequest> page) {
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
  public CallsListResponse nextPage() {
    if (!hasNextPage()) {
      throw new NoSuchElementException("Reached the last page of the API response");
    }
    return supplier.get();
  }

  @Override
  public Collection<Call> getContent() {
    return page == null ? Collections.emptyList() : page.getEntities();
  }

  @Override
  public String toString() {
    return "CallsListResponse {" + "page=" + page + '}';
  }
}
