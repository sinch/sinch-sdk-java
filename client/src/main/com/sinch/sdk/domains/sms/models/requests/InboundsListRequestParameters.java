package com.sinch.sdk.domains.sms.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import java.time.Instant;
import java.util.Collection;

/**
 * Parameters request to list delivery reports for a project
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/operation/getDeliveryReports">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/operation/getDeliveryReports</a>
 * @since 1.0
 */
public class InboundsListRequestParameters {

  private final OptionalValue<Instant> startDate;
  private final OptionalValue<Instant> endDate;
  private final OptionalValue<String> clientReference;
  private final OptionalValue<Integer> page;
  private final OptionalValue<Integer> pageSize;
  private final OptionalValue<Collection<String>> to;

  private InboundsListRequestParameters(
      OptionalValue<Instant> startDate,
      OptionalValue<Instant> endDate,
      OptionalValue<String> clientReference,
      OptionalValue<Integer> page,
      OptionalValue<Integer> pageSize,
      OptionalValue<Collection<String>> to) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.clientReference = clientReference;
    this.page = page;
    this.pageSize = pageSize;
    this.to = to;
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

  public OptionalValue<Collection<String>> getTo() {
    return to;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(InboundsListRequestParameters parameters) {
    return new Builder(parameters);
  }

  public static class Builder {

    OptionalValue<Instant> startDate = OptionalValue.empty();
    OptionalValue<Instant> endDate = OptionalValue.empty();
    OptionalValue<String> clientReference = OptionalValue.empty();
    OptionalValue<Integer> page = OptionalValue.empty();
    OptionalValue<Integer> pageSize = OptionalValue.empty();
    OptionalValue<Collection<String>> to = OptionalValue.empty();

    private Builder() {}

    private Builder(InboundsListRequestParameters parameters) {
      this.startDate = parameters.startDate;
      this.endDate = parameters.endDate;
      this.clientReference = parameters.clientReference;
      this.page = parameters.page;
      this.pageSize = parameters.pageSize;
      this.to = parameters.to;
    }

    /**
     * @param startDate Only list messages received at or after this date/time
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
     * @param clientReference Using a client reference in inbound messages requires additional setup
     *     on your account. Contact your account manager to enable this feature. Only list inbound
     *     messages that are in response to messages with a previously provided client reference.
     * @return current builder
     */
    public Builder setClientReference(String clientReference) {
      this.clientReference = OptionalValue.of(clientReference);
      return this;
    }

    /**
     * @param page The page number starting from 0.
     * @return current builder
     */
    public Builder setPage(Integer page) {
      this.page = OptionalValue.of(page);
      return this;
    }

    /**
     * @param pageSize Determines the size of a page.
     * @return current builder
     */
    public Builder setPageSize(Integer pageSize) {
      this.pageSize = OptionalValue.of(pageSize);
      return this;
    }

    /**
     * @param to Only list messages sent to these destinations
     * @return current builder
     */
    public Builder setTo(Collection<String> to) {
      this.to = OptionalValue.of(to);
      return this;
    }

    public InboundsListRequestParameters build() {
      return new InboundsListRequestParameters(
          startDate, endDate, clientReference, page, pageSize, to);
    }
  }
}
