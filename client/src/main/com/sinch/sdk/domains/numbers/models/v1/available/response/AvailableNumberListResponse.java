package com.sinch.sdk.domains.numbers.models.v1.available.response;

import com.sinch.sdk.core.models.pagination.ListResponse;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Lists all available numbers for a project
 *
 * @since TODO NEXT_RELEASE_VERSION
 */
public class AvailableNumberListResponse extends ListResponse<AvailableNumber> {

  Collection<AvailableNumber> content;

  public AvailableNumberListResponse(Collection<AvailableNumber> content) {
    this.content = content;
  }

  public boolean hasNextPage() {
    return false;
  }

  public AvailableNumberListResponse nextPage() {
    throw new NoSuchElementException("Reached the last page of the API response");
  }

  public Collection<AvailableNumber> getContent() {
    return content;
  }

  @Override
  public String toString() {
    return "AvailableNumberListResponse{" + "content=" + content + '}';
  }
}
