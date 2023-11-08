package com.sinch.sdk.domains.sms.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collection;

/**
 * SMS delivery Report
 *
 * @since 1.0
 */
public class DeliveryReportBatchSMS extends DeliveryReportBatch {

  /**
   * @param batchId <code>Required.</code> The ID of the batch this delivery report belongs to.
   * @param clientReference The client identifier of the batch this delivery report belongs to, if
   *     set when submitting batch.
   * @param statuses <code>Required.</code> Array with status objects. Only status codes with at
   *     least one recipient will be listed.
   * @param totalMessageCount <code>Required.</code> The total number of messages in the batch.
   */
  @JsonCreator
  public DeliveryReportBatchSMS(
      @JsonProperty(JSON_PROPERTY_BATCH_ID) String batchId,
      @JsonProperty(JSON_PROPERTY_CLIENT_REFERENCE) String clientReference,
      @JsonProperty(JSON_PROPERTY_STATUSES) Collection<DeliveryReportStatusDetails> statuses,
      @JsonProperty(JSON_PROPERTY_TOTAL_MESSAGE_COUNT) Integer totalMessageCount) {
    super(batchId, clientReference, statuses, totalMessageCount);
  }

  @Override
  public String toString() {
    return "DeliveryReportBatchSMS{} " + super.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends DeliveryReportBatch.Builder<Builder> {

    private Builder() {
      super();
    }

    public DeliveryReportBatchSMS build() {
      return new DeliveryReportBatchSMS(batchId, clientReference, statuses, totalMessageCount);
    }
  }
}
