/*
 * API Overview | Sinch
 * Sinch SMS API is one of the easiest APIs we offer and enables you to add fast and reliable global SMS to your applications. Send single messages, scheduled batch messages, use available message templates and more.
 *
 * The version of the OpenAPI document: v1
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.sms.models.dto.v1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import java.util.Objects;

/** RecipientDeliveryReportDto */
@JsonPropertyOrder({
  RecipientDeliveryReportDto.JSON_PROPERTY_AT,
  RecipientDeliveryReportDto.JSON_PROPERTY_BATCH_ID,
  RecipientDeliveryReportDto.JSON_PROPERTY_CODE,
  RecipientDeliveryReportDto.JSON_PROPERTY_RECIPIENT,
  RecipientDeliveryReportDto.JSON_PROPERTY_STATUS,
  RecipientDeliveryReportDto.JSON_PROPERTY_TYPE,
  RecipientDeliveryReportDto.JSON_PROPERTY_APPLIED_ORIGINATOR,
  RecipientDeliveryReportDto.JSON_PROPERTY_CLIENT_REFERENCE,
  RecipientDeliveryReportDto.JSON_PROPERTY_ENCODING,
  RecipientDeliveryReportDto.JSON_PROPERTY_NUMBER_OF_MESSAGE_PARTS,
  RecipientDeliveryReportDto.JSON_PROPERTY_OPERATOR,
  RecipientDeliveryReportDto.JSON_PROPERTY_OPERATOR_STATUS_AT
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class RecipientDeliveryReportDto {
  private static final long serialVersionUID = 1L;
  public static final String JSON_PROPERTY_AT = "at";
  private OffsetDateTime at;
  private boolean atDefined = false;

  public static final String JSON_PROPERTY_BATCH_ID = "batch_id";
  private String batchId;
  private boolean batchIdDefined = false;

  public static final String JSON_PROPERTY_CODE = "code";
  private Integer code;
  private boolean codeDefined = false;

  public static final String JSON_PROPERTY_RECIPIENT = "recipient";
  private String recipient;
  private boolean recipientDefined = false;

  public static final String JSON_PROPERTY_STATUS = "status";
  private String status;
  private boolean statusDefined = false;

  /** The recipient delivery report type. */
  public enum TypeEnum {
    SMS("recipient_delivery_report_sms"),

    MMS("recipient_delivery_report_mms"),

    UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

    private String value;

    TypeEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static TypeEnum fromValue(String value) {
      for (TypeEnum b : TypeEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return UNKNOWN_DEFAULT_OPEN_API;
    }
  }

  public static final String JSON_PROPERTY_TYPE = "type";
  private String type;
  private boolean typeDefined = false;

  public static final String JSON_PROPERTY_APPLIED_ORIGINATOR = "applied_originator";
  private String appliedOriginator;
  private boolean appliedOriginatorDefined = false;

  public static final String JSON_PROPERTY_CLIENT_REFERENCE = "client_reference";
  private String clientReference;
  private boolean clientReferenceDefined = false;

  /** Applied encoding for message. Present only if smart encoding is enabled. */
  public enum EncodingEnum {
    GSM("GSM"),

    UNICODE("UNICODE"),

    UNKNOWN_DEFAULT_OPEN_API("unknown_default_open_api");

    private String value;

    EncodingEnum(String value) {
      this.value = value;
    }

    @JsonValue
    public String getValue() {
      return value;
    }

    @Override
    public String toString() {
      return String.valueOf(value);
    }

    @JsonCreator
    public static EncodingEnum fromValue(String value) {
      for (EncodingEnum b : EncodingEnum.values()) {
        if (b.value.equals(value)) {
          return b;
        }
      }
      return UNKNOWN_DEFAULT_OPEN_API;
    }
  }

  public static final String JSON_PROPERTY_ENCODING = "encoding";
  private String encoding;
  private boolean encodingDefined = false;

  public static final String JSON_PROPERTY_NUMBER_OF_MESSAGE_PARTS = "number_of_message_parts";
  private Integer numberOfMessageParts;
  private boolean numberOfMessagePartsDefined = false;

  public static final String JSON_PROPERTY_OPERATOR = "operator";
  private String operator;
  private boolean operatorDefined = false;

  public static final String JSON_PROPERTY_OPERATOR_STATUS_AT = "operator_status_at";
  private OffsetDateTime operatorStatusAt;
  private boolean operatorStatusAtDefined = false;

  public RecipientDeliveryReportDto() {}

  @JsonCreator
  public RecipientDeliveryReportDto(@JsonProperty(JSON_PROPERTY_BATCH_ID) String batchId) {
    this();
    this.batchId = batchId;
    this.batchIdDefined = true;
  }

  public RecipientDeliveryReportDto at(OffsetDateTime at) {
    this.at = at;
    this.atDefined = true;
    return this;
  }

  /**
   * A timestamp of when the Delivery Report was created in the Sinch service. Formatted as
   * [ISO-8601](https://en.wikipedia.org/wiki/ISO_8601): &#x60;YYYY-MM-DDThh:mm:ss.SSSZ&#x60;.
   *
   * @return at
   */
  @JsonProperty(JSON_PROPERTY_AT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OffsetDateTime getAt() {
    return at;
  }

  @JsonIgnore
  public boolean getAtDefined() {
    return atDefined;
  }

  @JsonProperty(JSON_PROPERTY_AT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setAt(OffsetDateTime at) {
    this.at = at;
    this.atDefined = true;
  }

  /**
   * The ID of the batch this delivery report belongs to
   *
   * @return batchId
   */
  @JsonProperty(JSON_PROPERTY_BATCH_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getBatchId() {
    return batchId;
  }

  @JsonIgnore
  public boolean getBatchIdDefined() {
    return batchIdDefined;
  }

  public RecipientDeliveryReportDto code(Integer code) {
    this.code = code;
    this.codeDefined = true;
    return this;
  }

  /**
   * The detailed status code.
   *
   * @return code
   */
  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public Integer getCode() {
    return code;
  }

  @JsonIgnore
  public boolean getCodeDefined() {
    return codeDefined;
  }

  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setCode(Integer code) {
    this.code = code;
    this.codeDefined = true;
  }

  public RecipientDeliveryReportDto recipient(String recipient) {
    this.recipient = recipient;
    this.recipientDefined = true;
    return this;
  }

  /**
   * Phone number that was queried.
   *
   * @return recipient
   */
  @JsonProperty(JSON_PROPERTY_RECIPIENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getRecipient() {
    return recipient;
  }

  @JsonIgnore
  public boolean getRecipientDefined() {
    return recipientDefined;
  }

  @JsonProperty(JSON_PROPERTY_RECIPIENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setRecipient(String recipient) {
    this.recipient = recipient;
    this.recipientDefined = true;
  }

  public RecipientDeliveryReportDto status(String status) {
    this.status = status;
    this.statusDefined = true;
    return this;
  }

  /**
   * The simplified status as described in _Delivery Report Statuses_.
   *
   * @return status
   */
  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getStatus() {
    return status;
  }

  @JsonIgnore
  public boolean getStatusDefined() {
    return statusDefined;
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setStatus(String status) {
    this.status = status;
    this.statusDefined = true;
  }

  public RecipientDeliveryReportDto type(String type) {
    this.type = type;
    this.typeDefined = true;
    return this;
  }

  /**
   * The recipient delivery report type.
   *
   * @return type
   */
  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public String getType() {
    return type;
  }

  @JsonIgnore
  public boolean getTypeDefined() {
    return typeDefined;
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public void setType(String type) {
    this.type = type;
    this.typeDefined = true;
  }

  public RecipientDeliveryReportDto appliedOriginator(String appliedOriginator) {
    this.appliedOriginator = appliedOriginator;
    this.appliedOriginatorDefined = true;
    return this;
  }

  /**
   * The default originator used for the recipient this delivery report belongs to, if default
   * originator pool configured and no originator set when submitting batch.
   *
   * @return appliedOriginator
   */
  @JsonProperty(JSON_PROPERTY_APPLIED_ORIGINATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getAppliedOriginator() {
    return appliedOriginator;
  }

  @JsonIgnore
  public boolean getAppliedOriginatorDefined() {
    return appliedOriginatorDefined;
  }

  @JsonProperty(JSON_PROPERTY_APPLIED_ORIGINATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setAppliedOriginator(String appliedOriginator) {
    this.appliedOriginator = appliedOriginator;
    this.appliedOriginatorDefined = true;
  }

  public RecipientDeliveryReportDto clientReference(String clientReference) {
    this.clientReference = clientReference;
    this.clientReferenceDefined = true;
    return this;
  }

  /**
   * The client identifier of the batch this delivery report belongs to, if set when submitting
   * batch.
   *
   * @return clientReference
   */
  @JsonProperty(JSON_PROPERTY_CLIENT_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getClientReference() {
    return clientReference;
  }

  @JsonIgnore
  public boolean getClientReferenceDefined() {
    return clientReferenceDefined;
  }

  @JsonProperty(JSON_PROPERTY_CLIENT_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setClientReference(String clientReference) {
    this.clientReference = clientReference;
    this.clientReferenceDefined = true;
  }

  public RecipientDeliveryReportDto encoding(String encoding) {
    this.encoding = encoding;
    this.encodingDefined = true;
    return this;
  }

  /**
   * Applied encoding for message. Present only if smart encoding is enabled.
   *
   * @return encoding
   */
  @JsonProperty(JSON_PROPERTY_ENCODING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getEncoding() {
    return encoding;
  }

  @JsonIgnore
  public boolean getEncodingDefined() {
    return encodingDefined;
  }

  @JsonProperty(JSON_PROPERTY_ENCODING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setEncoding(String encoding) {
    this.encoding = encoding;
    this.encodingDefined = true;
  }

  public RecipientDeliveryReportDto numberOfMessageParts(Integer numberOfMessageParts) {
    this.numberOfMessageParts = numberOfMessageParts;
    this.numberOfMessagePartsDefined = true;
    return this;
  }

  /**
   * The number of parts the message was split into. Present only if
   * &#x60;max_number_of_message_parts&#x60; parameter was set.
   *
   * @return numberOfMessageParts
   */
  @JsonProperty(JSON_PROPERTY_NUMBER_OF_MESSAGE_PARTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public Integer getNumberOfMessageParts() {
    return numberOfMessageParts;
  }

  @JsonIgnore
  public boolean getNumberOfMessagePartsDefined() {
    return numberOfMessagePartsDefined;
  }

  @JsonProperty(JSON_PROPERTY_NUMBER_OF_MESSAGE_PARTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setNumberOfMessageParts(Integer numberOfMessageParts) {
    this.numberOfMessageParts = numberOfMessageParts;
    this.numberOfMessagePartsDefined = true;
  }

  public RecipientDeliveryReportDto operator(String operator) {
    this.operator = operator;
    this.operatorDefined = true;
    return this;
  }

  /**
   * The operator that was used for delivering the message to this recipient, if enabled on the
   * account by Sinch.
   *
   * @return operator
   */
  @JsonProperty(JSON_PROPERTY_OPERATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public String getOperator() {
    return operator;
  }

  @JsonIgnore
  public boolean getOperatorDefined() {
    return operatorDefined;
  }

  @JsonProperty(JSON_PROPERTY_OPERATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOperator(String operator) {
    this.operator = operator;
    this.operatorDefined = true;
  }

  public RecipientDeliveryReportDto operatorStatusAt(OffsetDateTime operatorStatusAt) {
    this.operatorStatusAt = operatorStatusAt;
    this.operatorStatusAtDefined = true;
    return this;
  }

  /**
   * A timestamp extracted from the Delivery Receipt from the originating SMSC. Formatted as
   * [ISO-8601](https://en.wikipedia.org/wiki/ISO_8601): &#x60;YYYY-MM-DDThh:mm:ss.SSSZ&#x60;.
   *
   * @return operatorStatusAt
   */
  @JsonProperty(JSON_PROPERTY_OPERATOR_STATUS_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OffsetDateTime getOperatorStatusAt() {
    return operatorStatusAt;
  }

  @JsonIgnore
  public boolean getOperatorStatusAtDefined() {
    return operatorStatusAtDefined;
  }

  @JsonProperty(JSON_PROPERTY_OPERATOR_STATUS_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public void setOperatorStatusAt(OffsetDateTime operatorStatusAt) {
    this.operatorStatusAt = operatorStatusAt;
    this.operatorStatusAtDefined = true;
  }

  /** Return true if this RecipientDeliveryReport object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecipientDeliveryReportDto recipientDeliveryReport = (RecipientDeliveryReportDto) o;
    return Objects.equals(this.at, recipientDeliveryReport.at)
        && Objects.equals(this.batchId, recipientDeliveryReport.batchId)
        && Objects.equals(this.code, recipientDeliveryReport.code)
        && Objects.equals(this.recipient, recipientDeliveryReport.recipient)
        && Objects.equals(this.status, recipientDeliveryReport.status)
        && Objects.equals(this.type, recipientDeliveryReport.type)
        && Objects.equals(this.appliedOriginator, recipientDeliveryReport.appliedOriginator)
        && Objects.equals(this.clientReference, recipientDeliveryReport.clientReference)
        && Objects.equals(this.encoding, recipientDeliveryReport.encoding)
        && Objects.equals(this.numberOfMessageParts, recipientDeliveryReport.numberOfMessageParts)
        && Objects.equals(this.operator, recipientDeliveryReport.operator)
        && Objects.equals(this.operatorStatusAt, recipientDeliveryReport.operatorStatusAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        at,
        batchId,
        code,
        recipient,
        status,
        type,
        appliedOriginator,
        clientReference,
        encoding,
        numberOfMessageParts,
        operator,
        operatorStatusAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RecipientDeliveryReportDto {\n");
    sb.append("    at: ").append(toIndentedString(at)).append("\n");
    sb.append("    batchId: ").append(toIndentedString(batchId)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    recipient: ").append(toIndentedString(recipient)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    appliedOriginator: ").append(toIndentedString(appliedOriginator)).append("\n");
    sb.append("    clientReference: ").append(toIndentedString(clientReference)).append("\n");
    sb.append("    encoding: ").append(toIndentedString(encoding)).append("\n");
    sb.append("    numberOfMessageParts: ")
        .append(toIndentedString(numberOfMessageParts))
        .append("\n");
    sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
    sb.append("    operatorStatusAt: ").append(toIndentedString(operatorStatusAt)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}
