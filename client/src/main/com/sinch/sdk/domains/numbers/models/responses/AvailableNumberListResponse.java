package com.sinch.sdk.domains.numbers.models.responses;

import com.sinch.sdk.core.models.pagination.ListResponse;
import com.sinch.sdk.domains.numbers.models.AvailableNumber;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Lists all available numbers
 *
 * @since 1.0
 */
public class AvailableNumberListResponse extends ListResponse<AvailableNumber> {

  Collection<AvailableNumber> content;

  public AvailableNumberListResponse(Collection<AvailableNumber> list) {
    this.content = list;
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
