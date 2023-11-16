package com.sinch.sdk.domains.sms.models.requests;

import java.time.Instant;
import java.util.Optional;

/**
 * Parameters request to list batches for a project
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Batches/#tag/Batches/operation/ListBatches">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Batches/#tag/Batches/operation/ListBatches/</a>
 * @since 1.0
 */
public class BatchesListRequestParameters {

  private final String from;
  private final Instant startDate;
  private final Instant endDate;
  private final String clientReference;
  private final Integer page;
  private final Integer pageSize;

  /**
   * @param from Only list messages sent from this sender number. Multiple originating numbers can
   *     be comma separated. Must be phone numbers or short code.
   * @param startDate Only list messages received at or after this date/time.
   * @param endDate Only list messages received before this date/time
   * @param clientReference Client reference to include
   * @param page The page number starting from 0
   * @param pageSize Determines the size of a page
   */
  public BatchesListRequestParameters(
      String from,
      Instant startDate,
      Instant endDate,
      String clientReference,
      Integer page,
      Integer pageSize) {
    this.from = from;
    this.startDate = startDate;
    this.endDate = endDate;
    this.clientReference = clientReference;
    this.page = page;
    this.pageSize = pageSize;
  }

  public Optional<String> getFrom() {
    return Optional.ofNullable(from);
  }

  public Optional<Instant> getStartDate() {
    return Optional.ofNullable(startDate);
  }

  public Optional<Instant> getEndDate() {
    return Optional.ofNullable(endDate);
  }

  public Optional<String> getClientReference() {
    return Optional.ofNullable(clientReference);
  }

  public Optional<Integer> getPage() {
    return Optional.ofNullable(page);
  }

  public Optional<Integer> getPageSize() {
    return Optional.ofNullable(pageSize);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(BatchesListRequestParameters parameters) {
    return new Builder(parameters);
  }

  public static class Builder {

    String from;
    Instant startDate;
    Instant endDate;
    String clientReference;
    Integer page;
    Integer pageSize;

    private Builder() {}

    private Builder(BatchesListRequestParameters parameters) {
      this.from = parameters.from;
      this.startDate = parameters.startDate;
      this.endDate = parameters.endDate;
      this.clientReference = parameters.clientReference;
      this.page = parameters.page;
      this.pageSize = parameters.pageSize;
    }

    public Builder setFrom(String from) {
      this.from = from;
      return this;
    }

    public Builder setStartDate(Instant startDate) {
      this.startDate = startDate;
      return this;
    }

    public Builder setEndDate(Instant endDate) {
      this.endDate = endDate;
      return this;
    }

    public Builder setClientReference(String clientReference) {
      this.clientReference = clientReference;
      return this;
    }

    public Builder setPage(Integer page) {
      this.page = page;
      return this;
    }

    public Builder setPageSize(Integer pageSize) {
      this.pageSize = pageSize;
      return this;
    }

    public BatchesListRequestParameters build() {
      return new BatchesListRequestParameters(
          from, startDate, endDate, clientReference, page, pageSize);
    }
  }
}
