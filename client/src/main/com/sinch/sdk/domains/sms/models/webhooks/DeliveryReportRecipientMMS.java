package com.sinch.sdk.domains.sms.models.webhooks;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/**
 * SMS Delivery Report Recipient for MMS
 *
 * @since 1.0
 */
public class DeliveryReportRecipientMMS extends DeliveryReportRecipient {

  /**
   * Recipient Delivery Report for MMS
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
  public DeliveryReportRecipientMMS(
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
    super(
        batchId,
        clientReference,
        at,
        code,
        recipient,
        status,
        appliedOriginator,
        encoding,
        numberOfMessageParts,
        operator,
        operatorStatusAt);
  }

  @Override
  public String toString() {
    return "DeliveryReportRecipientMMS{} " + super.toString();
  }
}
