package com.sinch.sdk.domains.numbers.models.v1.regions.available.response;

import com.sinch.sdk.core.models.pagination.ListResponse;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Lists all available numbers for a project
 *
 * @since 1.2
 */
public class AvailableRegionListResponse extends ListResponse<AvailableRegion> {

  Collection<AvailableRegion> content;

  public AvailableRegionListResponse(Collection<AvailableRegion> content) {
    this.content = content;
  }

  public boolean hasNextPage() {
    return false;
  }

  public AvailableRegionListResponse nextPage() {
    throw new NoSuchElementException("Reached the last page of the API response");
  }

  public Collection<AvailableRegion> getContent() {
    return content;
  }

  @Override
  public String toString() {
    return "AvailableRegionListResponse{" + "content=" + content + '}';
  }
}
