package com.sinch.sdk.domains.sms.models.requests;

import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.sms.models.DeliveryReportStatus;
import com.sinch.sdk.domains.sms.models.DeliveryReportType;
import java.util.Collection;

/**
 * Parameters request to get a Batch Delivery Report
 *
 * @since 1.0
 */
public class DeliveryReportBatchGetRequestParameters {

  private final OptionalValue<DeliveryReportType> type;
  private final OptionalValue<Collection<DeliveryReportStatus>> statuses;
  private final OptionalValue<Collection<Integer>> codes;

  private DeliveryReportBatchGetRequestParameters(
      OptionalValue<DeliveryReportType> type,
      OptionalValue<Collection<DeliveryReportStatus>> statuses,
      OptionalValue<Collection<Integer>> codes) {
    this.type = type;
    this.statuses = statuses;
    this.codes = codes;
  }

  public OptionalValue<DeliveryReportType> getType() {
    return type;
  }

  public OptionalValue<Collection<DeliveryReportStatus>> geStatues() {
    return statuses;
  }

  public OptionalValue<Collection<Integer>> getCodes() {
    return codes;
  }

  public static Builder builder() {
    return new Builder();
  }

  public static Builder builder(DeliveryReportBatchGetRequestParameters parameters) {
    return new Builder(parameters);
  }

  public static class Builder {

    OptionalValue<DeliveryReportType> type = OptionalValue.empty();
    OptionalValue<Collection<DeliveryReportStatus>> statuses = OptionalValue.empty();
    OptionalValue<Collection<Integer>> codes = OptionalValue.empty();

    private Builder() {}

    private Builder(DeliveryReportBatchGetRequestParameters parameters) {
      this.type = parameters.type;
      this.statuses = parameters.statuses;
      this.codes = parameters.codes;
    }

    /**
     * @param type Filter by type of delivery report.
     *     <ul>
     *       <li>A <code>summary</code> will count the number of messages sent per status.
     *       <li>A <code>full</code> report give that of a summary report but in addition, lists
     *           phone numbers.
     *     </ul>
     *
     * @return current builder
     */
    public Builder setType(DeliveryReportType type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    /**
     * @param statuses Filter by list of <a
     *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/section/Delivery-report-statuses">statuses</a>
     *     to include
     * @return current builder
     */
    public Builder setStatuses(Collection<DeliveryReportStatus> statuses) {
      this.statuses = OptionalValue.of(statuses);
      return this;
    }

    /**
     * @param codes Filter by list of <a
     *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/section/Delivery-report-error-codes">codes</a>
     *     to include
     * @return current builder
     */
    public Builder setCodes(Collection<Integer> codes) {
      this.codes = OptionalValue.of(codes);
      return this;
    }

    public DeliveryReportBatchGetRequestParameters build() {
      return new DeliveryReportBatchGetRequestParameters(type, statuses, codes);
    }
  }
}
