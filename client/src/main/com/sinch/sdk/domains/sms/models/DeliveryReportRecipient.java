package com.sinch.sdk.domains.sms.models;

import java.time.Instant;
import java.util.Optional;

/**
 * Common Definition to Delivery Report
 *
 * @since 1.0
 */
public abstract class DeliveryReportRecipient extends BaseDeliveryReport {

  private final Instant at;
  private final DeliveryReportErrorCode code;
  private final String recipient;
  private final DeliveryReportStatus status;
  private final String appliedOriginator;
  private final DeliveryReportRecipientEncoding encoding;
  private final Integer numberOfMessageParts;
  private final String operator;
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
  public DeliveryReportRecipient(
      String batchId,
      String clientReference,
      Instant at,
      DeliveryReportErrorCode code,
      String recipient,
      DeliveryReportStatus status,
      String appliedOriginator,
      DeliveryReportRecipientEncoding encoding,
      Integer numberOfMessageParts,
      String operator,
      Instant operatorStatusAt) {
    super(batchId, clientReference);
    this.at = at;
    this.code = code;
    this.recipient = recipient;
    this.status = status;
    this.appliedOriginator = appliedOriginator;
    this.encoding = encoding;
    this.numberOfMessageParts = numberOfMessageParts;
    this.operator = operator;
    this.operatorStatusAt = operatorStatusAt;
  }

  public Instant getAt() {
    return at;
  }

  public DeliveryReportErrorCode getCode() {
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

  public Optional<DeliveryReportRecipientEncoding> getEncoding() {
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

  public abstract static class Builder<B extends Builder<B>> extends BaseDeliveryReport.Builder<B> {

    protected Instant at;
    protected DeliveryReportErrorCode code;
    protected String recipient;
    protected DeliveryReportStatus status;
    protected String appliedOriginator;
    protected DeliveryReportRecipientEncoding encoding;
    protected Integer numberOfMessageParts;
    protected String operator;
    protected Instant operatorStatusAt;

    public Builder<B> setAt(Instant at) {
      this.at = at;
      return this;
    }

    public Builder<B> setCode(DeliveryReportErrorCode code) {
      this.code = code;
      return this;
    }

    public Builder<B> setRecipient(String recipient) {
      this.recipient = recipient;
      return this;
    }

    public Builder<B> setStatus(DeliveryReportStatus status) {
      this.status = status;
      return this;
    }

    public Builder<B> setAppliedOriginator(String appliedOriginator) {
      this.appliedOriginator = appliedOriginator;
      return this;
    }

    public Builder<B> setEncoding(DeliveryReportRecipientEncoding encoding) {
      this.encoding = encoding;
      return this;
    }

    public Builder<B> setNumberOfMessageParts(Integer numberOfMessageParts) {
      this.numberOfMessageParts = numberOfMessageParts;
      return this;
    }

    public Builder<B> setOperator(String operator) {
      this.operator = operator;
      return this;
    }

    public Builder<B> setOperatorStatusAt(Instant operatorStatusAt) {
      this.operatorStatusAt = operatorStatusAt;
      return this;
    }

    public abstract DeliveryReportRecipient build();
  }
}
