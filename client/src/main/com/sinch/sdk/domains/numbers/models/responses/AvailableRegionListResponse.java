package com.sinch.sdk.domains.numbers.models.responses;

import com.sinch.sdk.core.models.pagination.ListResponse;
import com.sinch.sdk.domains.numbers.models.Region;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Lists all regions for numbers provided for the project ID.
 *
 * @since 1.0
 */
public class AvailableRegionListResponse extends ListResponse<Region> {

  Collection<Region> content;

  public AvailableRegionListResponse(Collection<Region> list) {
    this.content = list;
  }

  public boolean hasNextPage() {
    return false;
  }

  public AvailableRegionListResponse nextPage() {
    throw new NoSuchElementException("Reached the last page of the API response");
  }

  public Collection<Region> getContent() {
    return content;
  }

  @Override
  public String toString() {
    return "AvailableRegionListResponse{" + "content=" + content + '}';
  }
}
