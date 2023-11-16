package com.sinch.sdk.domains.sms.models;

import java.util.Collection;

/**
 * MMS delivery Report
 *
 * @since 1.0
 */
public class DeliveryReportBatchMMS extends DeliveryReportBatch {

  /**
   * @param batchId <code>Required.</code> The ID of the batch this delivery report belongs to.
   * @param clientReference The client identifier of the batch this delivery report belongs to, if
   *     set when submitting batch.
   * @param statuses <code>Required.</code> Array with status objects. Only status codes with at
   *     least one recipient will be listed.
   * @param totalMessageCount <code>Required.</code> The total number of messages in the batch.
   */
  public DeliveryReportBatchMMS(
      String batchId,
      String clientReference,
      Collection<DeliveryReportStatusDetails> statuses,
      Integer totalMessageCount) {
    super(batchId, clientReference, statuses, totalMessageCount);
  }

  @Override
  public String toString() {
    return "DeliveryReportBatchMMS{} " + super.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends DeliveryReportBatch.Builder<Builder> {

    protected Builder() {
      super();
    }

    public DeliveryReportBatchMMS build() {
      return new DeliveryReportBatchMMS(batchId, clientReference, statuses, totalMessageCount);
    }
  }
}
