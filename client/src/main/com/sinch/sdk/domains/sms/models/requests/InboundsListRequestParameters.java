package com.sinch.sdk.domains.sms.models.requests;

import java.time.Instant;
import java.util.Collection;
import java.util.Optional;

/**
 * Parameters request to list delivery reports for a project
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/operation/getDeliveryReports">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/operation/getDeliveryReports</a>
 * @since 1.0
 */
public class InboundsListRequestParameters {

  private final Instant startDate;
  private final Instant endDate;
  private final String clientReference;
  private final Integer page;
  private final Integer pageSize;
  private final Collection<String> to;

  /**
   * @param startDate Only list messages received at or after this date/time
   * @param endDate Only list messages received before this date/time
   * @param clientReference Using a client reference in inbound messages requires additional setup
   *     on your account. Contact your account manager to enable this feature. Only list inbound
   *     messages that are in response to messages with a previously provided client reference.
   * @param page The page number starting from 0.
   * @param pageSize Determines the size of a page.
   * @param to Only list messages sent to these destinations
   */
  public InboundsListRequestParameters(
      Instant startDate,
      Instant endDate,
      String clientReference,
      Integer page,
      Integer pageSize,
      Collection<String> to) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.clientReference = clientReference;
    this.page = page;
    this.pageSize = pageSize;
    this.to = to;
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

  public Optional<Collection<String>> getTo() {
    return Optional.ofNullable(to);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(InboundsListRequestParameters parameters) {
    return new Builder(parameters);
  }

  public static class Builder {

    Instant startDate;
    Instant endDate;
    String clientReference;
    Integer page;
    Integer pageSize;
    Collection<String> to;

    private Builder() {}

    private Builder(InboundsListRequestParameters parameters) {
      this.startDate = parameters.startDate;
      this.endDate = parameters.endDate;
      this.clientReference = parameters.clientReference;
      this.page = parameters.page;
      this.pageSize = parameters.pageSize;
      this.to = parameters.to;
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

    public Builder setTo(Collection<String> to) {
      this.to = to;
      return this;
    }

    public InboundsListRequestParameters build() {
      return new InboundsListRequestParameters(
          startDate, endDate, clientReference, page, pageSize, to);
    }
  }
}
