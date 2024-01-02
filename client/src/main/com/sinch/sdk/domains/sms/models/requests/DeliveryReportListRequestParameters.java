package com.sinch.sdk.domains.sms.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.sms.models.DeliveryReportErrorCode;
import com.sinch.sdk.domains.sms.models.DeliveryReportStatus;
import java.time.Instant;
import java.util.Collection;

/**
 * Parameters request to list delivery reports for a project
 *
 * @see <a
 *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/operation/getDeliveryReports">https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/operation/getDeliveryReports</a>
 * @since 1.0
 */
public class DeliveryReportListRequestParameters {

  private final OptionalValue<Instant> startDate;
  private final OptionalValue<Instant> endDate;
  private final OptionalValue<String> clientReference;
  private final OptionalValue<Integer> page;
  private final OptionalValue<Integer> pageSize;
  private final OptionalValue<Collection<DeliveryReportStatus>> statuses;
  private final OptionalValue<Collection<DeliveryReportErrorCode>> codes;

  private DeliveryReportListRequestParameters(
      OptionalValue<Instant> startDate,
      OptionalValue<Instant> endDate,
      OptionalValue<String> clientReference,
      OptionalValue<Integer> page,
      OptionalValue<Integer> pageSize,
      OptionalValue<Collection<DeliveryReportStatus>> statuses,
      OptionalValue<Collection<DeliveryReportErrorCode>> codes) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.clientReference = clientReference;
    this.page = page;
    this.pageSize = pageSize;
    this.statuses = statuses;
    this.codes = codes;
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

  public OptionalValue<Collection<DeliveryReportStatus>> getStatuses() {
    return statuses;
  }

  public OptionalValue<Collection<DeliveryReportErrorCode>> getCodes() {
    return codes;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(DeliveryReportListRequestParameters parameters) {
    return new Builder(parameters);
  }

  public static class Builder {

    OptionalValue<Instant> startDate = OptionalValue.empty();
    OptionalValue<Instant> endDate = OptionalValue.empty();
    OptionalValue<String> clientReference = OptionalValue.empty();
    OptionalValue<Integer> page = OptionalValue.empty();
    OptionalValue<Integer> pageSize = OptionalValue.empty();
    OptionalValue<Collection<DeliveryReportStatus>> statuses = OptionalValue.empty();
    OptionalValue<Collection<DeliveryReportErrorCode>> codes = OptionalValue.empty();

    private Builder() {}

    private Builder(DeliveryReportListRequestParameters parameters) {
      this.startDate = parameters.startDate;
      this.endDate = parameters.endDate;
      this.clientReference = parameters.clientReference;
      this.page = parameters.page;
      this.pageSize = parameters.pageSize;
      this.statuses = parameters.statuses;
      this.codes = parameters.codes;
    }

    /**
     * @param startDate Only list messages received at or after this date/time. Default: 24h ago
     * @return current builder
     */
    public Builder setStartDate(Instant startDate) {
      this.startDate = OptionalValue.of(startDate);
      return this;
    }

    /**
     * @param endDate Only list messages received before this date/time.
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
     * @param statuses List of delivery report statuses to include
     * @return current builder
     */
    public Builder setStatuses(Collection<DeliveryReportStatus> statuses) {
      this.statuses = OptionalValue.of(statuses);
      return this;
    }

    /**
     * @param codes List of delivery receipt error codes to include
     * @return current builder
     */
    public Builder setCodes(Collection<DeliveryReportErrorCode> codes) {
      this.codes = OptionalValue.of(codes);
      return this;
    }

    public DeliveryReportListRequestParameters build() {
      return new DeliveryReportListRequestParameters(
          startDate, endDate, clientReference, page, pageSize, statuses, codes);
    }
  }
}
