package com.sinch.sdk.domains.sms.models.v1.batches.request;

import com.sinch.sdk.core.models.OptionalValue;
import java.time.Instant;

public class ListBatchesRequest {

  private final OptionalValue<String> from;
  private final OptionalValue<Instant> startDate;
  private final OptionalValue<Instant> endDate;
  private final OptionalValue<String> clientReference;
  private final OptionalValue<Integer> page;
  private final OptionalValue<Integer> pageSize;

  private ListBatchesRequest(
      OptionalValue<String> from,
      OptionalValue<Instant> startDate,
      OptionalValue<Instant> endDate,
      OptionalValue<String> clientReference,
      OptionalValue<Integer> page,
      OptionalValue<Integer> pageSize) {
    this.from = from;
    this.startDate = startDate;
    this.endDate = endDate;
    this.clientReference = clientReference;
    this.page = page;
    this.pageSize = pageSize;
  }

  public OptionalValue<String> getFrom() {
    return from;
  }

  public OptionalValue<Instant> getStartDate() {
    return startDate;
  }

  public OptionalValue<Instant> getEndDate() {
    return endDate;
  }

  public OptionalValue<String> getClientReference() {
    return clientReference;
  }

  public OptionalValue<Integer> getPage() {
    return page;
  }

  public OptionalValue<Integer> getPageSize() {
    return pageSize;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(ListBatchesRequest parameters) {
    return new Builder(parameters);
  }

  public static class Builder {

    OptionalValue<String> from = OptionalValue.empty();
    OptionalValue<Instant> startDate = OptionalValue.empty();
    OptionalValue<Instant> endDate = OptionalValue.empty();
    OptionalValue<String> clientReference = OptionalValue.empty();
    OptionalValue<Integer> page = OptionalValue.empty();
    OptionalValue<Integer> pageSize = OptionalValue.empty();

    private Builder() {}

    private Builder(ListBatchesRequest parameters) {
      this.from = parameters.from;
      this.startDate = parameters.startDate;
      this.endDate = parameters.endDate;
      this.clientReference = parameters.clientReference;
      this.page = parameters.page;
      this.pageSize = parameters.pageSize;
    }

    /**
     * @param from Only list messages sent from this sender number. Multiple originating numbers can
     *     be comma separated. Must be phone numbers or short code.
     * @return current builder
     */
    public Builder setFrom(String from) {
      this.from = OptionalValue.of(from);
      return this;
    }

    /**
     * @param startDate Only list messages received at or after this date/time.
     * @return current builder
     */
    public Builder setStartDate(Instant startDate) {
      this.startDate = OptionalValue.of(startDate);
      return this;
    }

    /**
     * @param endDate Only list messages received before this date/time
     * @return current builder
     */
    public Builder setEndDate(Instant endDate) {
      this.endDate = OptionalValue.of(endDate);
      return this;
    }

    /**
     * @param clientReference Client reference to include
     * @return current builder
     */
    public Builder setClientReference(String clientReference) {
      this.clientReference = OptionalValue.of(clientReference);
      return this;
    }

    /**
     * @param page The page number starting from 0
     * @return current builder
     */
    public Builder setPage(Integer page) {
      this.page = OptionalValue.of(page);
      return this;
    }

    /**
     * @param pageSize Determines the size of a page
     * @return current builder
     */
    public Builder setPageSize(Integer pageSize) {
      this.pageSize = OptionalValue.of(pageSize);
      return this;
    }

    public ListBatchesRequest build() {
      return new ListBatchesRequest(from, startDate, endDate, clientReference, page, pageSize);
    }
  }
}
