package com.sinch.sdk.domains.sms.models.requests;

import com.sinch.sdk.domains.sms.models.DeliveryReportStatus;
import com.sinch.sdk.domains.sms.models.DeliveryReportType;
import java.util.Collection;
import java.util.Optional;

/**
 * Parameters request to get a Batch Delivery Report
 *
 * @since 1.0
 */
public class DeliveryReportBatchGetRequestParameters {

  private final DeliveryReportType type;
  private final Collection<DeliveryReportStatus> statuses;
  private final Collection<Integer> codes;

  /**
   * @param type Filter by type of delivery report.
   *     <ul>
   *       <li>A <code>summary</code> will count the number of messages sent per status.
   *       <li>A <code>full</code> report give that of a summary report but in addition, lists phone
   *           numbers.
   *     </ul>
   *
   * @param statuses Filter by list of <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/section/Delivery-report-statuses">statuses</a>
   *     to include
   * @param codes Filter by list of <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/section/Delivery-report-error-codes">codes</a>
   *     to include
   */
  public DeliveryReportBatchGetRequestParameters(
      DeliveryReportType type,
      Collection<DeliveryReportStatus> statuses,
      Collection<Integer> codes) {
    this.type = type;
    this.statuses = statuses;
    this.codes = codes;
  }

  public Optional<DeliveryReportType> getType() {
    return Optional.ofNullable(type);
  }

  public Optional<Collection<DeliveryReportStatus>> geStatues() {
    return Optional.ofNullable(statuses);
  }

  public Optional<Collection<Integer>> getCodes() {
    return Optional.ofNullable(codes);
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(DeliveryReportBatchGetRequestParameters parameters) {
    return new Builder(parameters);
  }

  public static class Builder {

    DeliveryReportType type;
    Collection<DeliveryReportStatus> statuses;
    Collection<Integer> codes;

    private Builder() {}

    private Builder(DeliveryReportBatchGetRequestParameters parameters) {
      this.type = parameters.type;
      this.statuses = parameters.statuses;
      this.codes = parameters.codes;
    }

    public Builder setType(DeliveryReportType type) {
      this.type = type;
      return this;
    }

    public Builder setStatuses(Collection<DeliveryReportStatus> statuses) {
      this.statuses = statuses;
      return this;
    }

    public Builder setCodes(Collection<Integer> codes) {
      this.codes = codes;
      return this;
    }

    public DeliveryReportBatchGetRequestParameters build() {
      return new DeliveryReportBatchGetRequestParameters(type, statuses, codes);
    }
  }
}
