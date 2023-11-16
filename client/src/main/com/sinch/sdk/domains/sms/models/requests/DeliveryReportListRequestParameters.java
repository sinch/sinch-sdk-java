package com.sinch.sdk.domains.sms.models.requests;

import com.sinch.sdk.domains.sms.models.DeliveryReportErrorCode;
import com.sinch.sdk.domains.sms.models.DeliveryReportStatus;
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
public class DeliveryReportListRequestParameters {

  private final Instant startDate;
  private final Instant endDate;
  private final String clientReference;
  private final Integer page;
  private final Integer pageSize;
  private final Collection<DeliveryReportStatus> statuses;
  private final Collection<DeliveryReportErrorCode> codes;

  /**
   * @param startDate Only list messages received at or after this date/time. Default: 24h ago
   * @param endDate Only list messages received before this date/time.
   * @param clientReference Client reference to include
   * @param page The page number starting from 0.
   * @param pageSize Determines the size of a page.
   * @param statuses List of delivery report statuses to include
   * @param codes List of delivery receipt error codes to include
   */
  public DeliveryReportListRequestParameters(
      Instant startDate,
      Instant endDate,
      String clientReference,
      Integer page,
      Integer pageSize,
      Collection<DeliveryReportStatus> statuses,
      Collection<DeliveryReportErrorCode> codes) {
    this.startDate = startDate;
    this.endDate = endDate;
    this.clientReference = clientReference;
    this.page = page;
    this.pageSize = pageSize;
    this.statuses = statuses;
    this.codes = codes;
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

  public Optional<Collection<DeliveryReportStatus>> getStatuses() {
    return Optional.ofNullable(statuses);
  }

  public Optional<Collection<DeliveryReportErrorCode>> getCodes() {
    return Optional.ofNullable(codes);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(DeliveryReportListRequestParameters parameters) {
    return new Builder(parameters);
  }

  public static class Builder {

    Instant startDate;
    Instant endDate;
    String clientReference;
    Integer page;
    Integer pageSize;
    Collection<DeliveryReportStatus> statuses;
    Collection<DeliveryReportErrorCode> codes;

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

    public Builder setStatuses(Collection<DeliveryReportStatus> statuses) {
      this.statuses = statuses;
      return this;
    }

    public Builder setCodes(Collection<DeliveryReportErrorCode> codes) {
      this.codes = codes;
      return this;
    }

    public DeliveryReportListRequestParameters build() {
      return new DeliveryReportListRequestParameters(
          startDate, endDate, clientReference, page, pageSize, statuses, codes);
    }
  }
}
