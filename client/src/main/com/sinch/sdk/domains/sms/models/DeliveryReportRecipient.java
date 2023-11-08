package com.sinch.sdk.domains.sms.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.util.Optional;

/**
 * Common Definition to Delivery Report
 *
 * @since 1.0
 */
public abstract class DeliveryReportRecipient extends BaseDeliveryReport {

  static final String JSON_PROPERTY_AT = "at";
  private final Instant at;
  static final String JSON_PROPERTY_CODE = "code";
  private final Integer code;
  static final String JSON_PROPERTY_RECIPIENT = "recipient";
  private final String recipient;
  static final String JSON_PROPERTY_STATUS = "status";
  private final DeliveryReportStatus status;
  static final String JSON_PROPERTY_APPLIED_ORIGINATOR = "applied_originator";
  private final String appliedOriginator;
  static final String JSON_PROPERTY_ENCODING = "encoding";
  private final String encoding;
  static final String JSON_PROPERTY_NUMBER_OF_MESSAGE_PARTS = "number_of_message_parts";
  private final Integer numberOfMessageParts;
  static final String JSON_PROPERTY_OPERATOR = "operator";
  private final String operator;
  static final String JSON_PROPERTY_OPERATOR_STATUS_AT = "operator_status_at";
  private final Instant operatorStatusAt;

  /**
   * Recipient Delivery Report Recipient
   *
   * @param batchId <code>Required.</code> The ID of the batch this delivery report belongs to.
   * @param clientReference The client identifier of the batch this delivery report belongs to, if
   *     set when submitting batch.
   * @param at <code>Required.</code> A timestamp of when the Delivery Report was created in the
   *     Sinch service
   * @param code <code>Required.</code> The detailed <a
   *     href="https://developers.sinch.com/docs/sms/api-reference/sms/tag/Delivery-reports/#tag/Delivery-reports/section/Delivery-report-error-codes">status
   *     code</a>.
   * @param recipient <code>Required.</code> Phone number that was queried.
   * @param status <code>Required.</code> The simplified status as described in <em>Delivery Report
   *     Statuses</em>
   * @param appliedOriginator The default originator used for the recipient this delivery report
   *     belongs to, if default originator pool configured and no originator set when submitting
   *     batch.
   * @param encoding Applied encoding for message. Present only if smart encoding is enabled.
   * @param numberOfMessageParts The number of parts the message was split into. Present only if
   *     <code>max_number_of_message_parts</code> parameter was set.
   * @param operator The operator that was used for delivering the message to this recipient, if
   *     enabled on the account by Sinch.
   * @param operatorStatusAt A timestamp extracted from the Delivery Receipt from the originating
   *     SMSC
   */
  @JsonCreator
  public DeliveryReportRecipient(
      @JsonProperty(JSON_PROPERTY_BATCH_ID) String batchId,
      @JsonProperty(JSON_PROPERTY_CLIENT_REFERENCE) String clientReference,
      @JsonProperty(JSON_PROPERTY_AT) OffsetDateTime at,
      @JsonProperty(JSON_PROPERTY_CODE) Integer code,
      @JsonProperty(JSON_PROPERTY_RECIPIENT) String recipient,
      @JsonProperty(JSON_PROPERTY_STATUS) String status,
      @JsonProperty(JSON_PROPERTY_APPLIED_ORIGINATOR) String appliedOriginator,
      @JsonProperty(JSON_PROPERTY_ENCODING) String encoding,
      @JsonProperty(JSON_PROPERTY_NUMBER_OF_MESSAGE_PARTS) Integer numberOfMessageParts,
      @JsonProperty(JSON_PROPERTY_OPERATOR) String operator,
      @JsonProperty(JSON_PROPERTY_OPERATOR_STATUS_AT) OffsetDateTime operatorStatusAt) {
    super(batchId, clientReference);
    this.at = null != at ? at.toInstant() : null;
    this.code = code;
    this.recipient = recipient;
    this.status = DeliveryReportStatus.from(status);
    this.appliedOriginator = appliedOriginator;
    this.encoding = encoding;
    this.numberOfMessageParts = numberOfMessageParts;
    this.operator = operator;
    this.operatorStatusAt = null != operatorStatusAt ? operatorStatusAt.toInstant() : null;
  }

  public Instant getAt() {
    return at;
  }

  public Integer getCode() {
    return code;
  }

  public String getRecipient() {
    return recipient;
  }

  public DeliveryReportStatus getStatus() {
    return status;
  }

  public Optional<String> getAppliedOriginator() {
    return Optional.ofNullable(appliedOriginator);
  }

  public Optional<String> getEncoding() {
    return Optional.ofNullable(encoding);
  }

  public Optional<Integer> getNumberOfMessageParts() {
    return Optional.ofNullable(numberOfMessageParts);
  }

  public Optional<String> getOperator() {
    return Optional.ofNullable(operator);
  }

  public Optional<Instant> getOperatorStatusAt() {
    return Optional.ofNullable(operatorStatusAt);
  }

  @Override
  public String toString() {
    return "DeliveryReportRecipient{"
        + "at="
        + at
        + ", code='"
        + code
        + '\''
        + ", recipient='"
        + recipient
        + '\''
        + ", status="
        + status
        + ", appliedOriginator='"
        + appliedOriginator
        + '\''
        + ", encoding='"
        + encoding
        + '\''
        + ", numberOfMessageParts="
        + numberOfMessageParts
        + ", operator='"
        + operator
        + '\''
        + ", operatorStatusAt="
        + operatorStatusAt
        + "} "
        + super.toString();
  }
}
