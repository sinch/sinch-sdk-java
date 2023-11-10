package com.sinch.sdk.domains.sms.models;

import java.util.Collection;
import java.util.Objects;

/**
 * Common Definition to Delivery Report
 *
 * @since 1.0
 */
public abstract class DeliveryReportBatch extends BaseDeliveryReport {

  private final Collection<DeliveryReportStatusDetails> statuses;
  private final Integer totalMessageCount;

  /**
   * @param batchId <code>Required.</code> The ID of the batch this delivery report belongs to.
   * @param clientReference The client identifier of the batch this delivery report belongs to, if
   *     set when submitting batch.
   * @param statuses <code>Required.</code> Array with status objects. Only status codes with at
   *     least one recipient will be listed.
   * @param totalMessageCount <code>Required.</code> The total number of messages in the batch.
   */
  public DeliveryReportBatch(
      String batchId,
      String clientReference,
      Collection<DeliveryReportStatusDetails> statuses,
      Integer totalMessageCount) {
    super(batchId, clientReference);
    Objects.requireNonNull(statuses);
    Objects.requireNonNull(totalMessageCount);
    this.statuses = statuses;
    this.totalMessageCount = totalMessageCount;
  }

  public Collection<DeliveryReportStatusDetails> getStatuses() {
    return statuses;
  }

  public Integer getTotalMessageCount() {
    return totalMessageCount;
  }

  @Override
  public String toString() {
    return "DeliveryReportBatch{"
        + "statuses="
        + statuses
        + ", totalMessageCount="
        + totalMessageCount
        + "} "
        + super.toString();
  }

  public abstract static class Builder<B extends Builder<B>> extends BaseDeliveryReport.Builder<B> {
    protected Collection<DeliveryReportStatusDetails> statuses;
    protected Integer totalMessageCount;

    public B setStatuses(Collection<DeliveryReportStatusDetails> statuses) {
      this.statuses = statuses;
      return self();
    }

    public B setTotalMessageCount(Integer totalMessageCount) {
      this.totalMessageCount = totalMessageCount;
      return self();
    }

    @SuppressWarnings("unchecked")
    protected B self() {
      return (B) this;
    }

    public abstract DeliveryReportBatch build();
  }
}
