package com.sinch.sdk.domains.sms.models.webhooks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Collection;
import java.util.Objects;

/**
 * Common Definition to Delivery Report
 *
 * @since 1.0
 */
public abstract class DeliveryReport extends BaseDeliveryReport {

  static final String JSON_PROPERTY_STATUSES = "statuses";
  private final Collection<DeliveryReportStatusDetails> statuses;
  static final String JSON_PROPERTY_TOTAL_MESSAGE_COUNT = "total_message_count";
  private final Integer totalMessageCount;

  /**
   * @param batchId <code>Required.</code> The ID of the batch this delivery report belongs to.
   * @param clientReference The client identifier of the batch this delivery report belongs to, if
   *     set when submitting batch.
   * @param statuses <code>Required.</code> Array with status objects. Only status codes with at
   *     least one recipient will be listed.
   * @param totalMessageCount <code>Required.</code> The total number of messages in the batch.
   */
  @JsonCreator
  public DeliveryReport(
      @JsonProperty(JSON_PROPERTY_BATCH_ID) String batchId,
      @JsonProperty(JSON_PROPERTY_CLIENT_REFERENCE) String clientReference,
      @JsonProperty(JSON_PROPERTY_STATUSES) Collection<DeliveryReportStatusDetails> statuses,
      @JsonProperty(JSON_PROPERTY_TOTAL_MESSAGE_COUNT) Integer totalMessageCount) {
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
    return "DeliveryReport{"
        + "statuses="
        + statuses
        + ", totalMessageCount="
        + totalMessageCount
        + "} "
        + super.toString();
  }
}
