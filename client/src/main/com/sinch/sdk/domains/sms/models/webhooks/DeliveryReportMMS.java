package com.sinch.sdk.domains.sms.models.webhooks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.sinch.sdk.domains.sms.models.webhooks.DeliveryReport.Builder;
import java.util.Collection;

/**
 * MMS delivery Report
 *
 * @since 1.0
 */
public class DeliveryReportMMS extends DeliveryReport {

  /**
   * @param batchId <code>Required.</code> The ID of the batch this delivery report belongs to.
   * @param clientReference The client identifier of the batch this delivery report belongs to, if
   *     set when submitting batch.
   * @param statuses <code>Required.</code> Array with status objects. Only status codes with at
   *     least one recipient will be listed.
   * @param totalMessageCount <code>Required.</code> The total number of messages in the batch.
   */
  @JsonCreator
  public DeliveryReportMMS(
      @JsonProperty(JSON_PROPERTY_BATCH_ID) String batchId,
      @JsonProperty(JSON_PROPERTY_CLIENT_REFERENCE) String clientReference,
      @JsonProperty(JSON_PROPERTY_STATUSES) Collection<DeliveryReportStatusDetails> statuses,
      @JsonProperty(JSON_PROPERTY_TOTAL_MESSAGE_COUNT) Integer totalMessageCount) {
    super(batchId, clientReference, statuses, totalMessageCount);
  }

  @Override
  public String toString() {
    return "DeliveryReportMMS{} " + super.toString();
  }

  public static Builder builder() {
    return new Builder();
  }

  public static class Builder extends DeliveryReport.Builder<Builder> {

    protected Builder() {
      super();
    }

    public DeliveryReportMMS build() {
      return new DeliveryReportMMS(batchId, clientReference, statuses, totalMessageCount);
    }
  }
}
