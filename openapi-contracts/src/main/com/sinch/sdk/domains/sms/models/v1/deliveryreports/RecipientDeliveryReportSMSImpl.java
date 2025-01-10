package com.sinch.sdk.domains.sms.models.v1.deliveryreports;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.core.utils.EnumDynamic;
import com.sinch.sdk.core.utils.EnumSupportDynamic;
import java.time.Instant;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

@JsonPropertyOrder({
  RecipientDeliveryReportSMSImpl.JSON_PROPERTY_APPLIED_ORIGINATOR,
  RecipientDeliveryReportSMSImpl.JSON_PROPERTY_AT,
  RecipientDeliveryReportSMSImpl.JSON_PROPERTY_BATCH_ID,
  RecipientDeliveryReportSMSImpl.JSON_PROPERTY_CLIENT_REFERENCE,
  RecipientDeliveryReportSMSImpl.JSON_PROPERTY_CODE,
  RecipientDeliveryReportSMSImpl.JSON_PROPERTY_ENCODING,
  RecipientDeliveryReportSMSImpl.JSON_PROPERTY_NUMBER_OF_MESSAGE_PARTS,
  RecipientDeliveryReportSMSImpl.JSON_PROPERTY_OPERATOR,
  RecipientDeliveryReportSMSImpl.JSON_PROPERTY_OPERATOR_STATUS_AT,
  RecipientDeliveryReportSMSImpl.JSON_PROPERTY_RECIPIENT,
  RecipientDeliveryReportSMSImpl.JSON_PROPERTY_STATUS,
  RecipientDeliveryReportSMSImpl.JSON_PROPERTY_TYPE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class RecipientDeliveryReportSMSImpl
    implements RecipientDeliveryReportSMS, RecipientDeliveryReport {
  private static final long serialVersionUID = 1L;

  /** Gets or Sets type */
  public static class TypeEnum extends EnumDynamic<String, TypeEnum> {
    public static final TypeEnum RECIPIENT_DELIVERY_REPORT_SMS =
        new TypeEnum("recipient_delivery_report_sms");

    private static final EnumSupportDynamic<String, TypeEnum> ENUM_SUPPORT =
        new EnumSupportDynamic<>(
            TypeEnum.class, TypeEnum::new, Arrays.asList(RECIPIENT_DELIVERY_REPORT_SMS));

    private TypeEnum(String value) {
      super(value);
    }

    public static Stream<TypeEnum> values() {
      return ENUM_SUPPORT.values();
    }

    public static TypeEnum from(String value) {
      return ENUM_SUPPORT.from(value);
    }

    public static String valueOf(TypeEnum e) {
      return ENUM_SUPPORT.valueOf(e);
    }
  }

  public static final String JSON_PROPERTY_APPLIED_ORIGINATOR = "applied_originator";

  private OptionalValue<String> appliedOriginator;

  public static final String JSON_PROPERTY_AT = "at";

  private OptionalValue<Instant> createdAt;

  public static final String JSON_PROPERTY_BATCH_ID = "batch_id";

  private OptionalValue<String> batchId;

  public static final String JSON_PROPERTY_CLIENT_REFERENCE = "client_reference";

  private OptionalValue<String> clientReference;

  public static final String JSON_PROPERTY_CODE = "code";

  private OptionalValue<DeliveryReceiptErrorCode> code;

  public static final String JSON_PROPERTY_ENCODING = "encoding";

  private OptionalValue<EncodingType> encoding;

  public static final String JSON_PROPERTY_NUMBER_OF_MESSAGE_PARTS = "number_of_message_parts";

  private OptionalValue<Integer> numberOfMessageParts;

  public static final String JSON_PROPERTY_OPERATOR = "operator";

  private OptionalValue<String> operator;

  public static final String JSON_PROPERTY_OPERATOR_STATUS_AT = "operator_status_at";

  private OptionalValue<Instant> operatorStatusAt;

  public static final String JSON_PROPERTY_RECIPIENT = "recipient";

  private OptionalValue<String> recipient;

  public static final String JSON_PROPERTY_STATUS = "status";

  private OptionalValue<DeliveryStatus> status;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public RecipientDeliveryReportSMSImpl() {}

  protected RecipientDeliveryReportSMSImpl(
      OptionalValue<String> appliedOriginator,
      OptionalValue<Instant> createdAt,
      OptionalValue<String> batchId,
      OptionalValue<String> clientReference,
      OptionalValue<DeliveryReceiptErrorCode> code,
      OptionalValue<EncodingType> encoding,
      OptionalValue<Integer> numberOfMessageParts,
      OptionalValue<String> operator,
      OptionalValue<Instant> operatorStatusAt,
      OptionalValue<String> recipient,
      OptionalValue<DeliveryStatus> status,
      OptionalValue<TypeEnum> type) {
    this.appliedOriginator = appliedOriginator;
    this.createdAt = createdAt;
    this.batchId = batchId;
    this.clientReference = clientReference;
    this.code = code;
    this.encoding = encoding;
    this.numberOfMessageParts = numberOfMessageParts;
    this.operator = operator;
    this.operatorStatusAt = operatorStatusAt;
    this.recipient = recipient;
    this.status = status;
    this.type = type;
  }

  @JsonIgnore
  public String getAppliedOriginator() {
    return appliedOriginator.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_APPLIED_ORIGINATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> appliedOriginator() {
    return appliedOriginator;
  }

  @JsonIgnore
  public Instant getCreatedAt() {
    return createdAt.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_AT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Instant> createdAt() {
    return createdAt;
  }

  @JsonIgnore
  public String getBatchId() {
    return batchId.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<String> batchId() {
    return batchId;
  }

  @JsonIgnore
  public String getClientReference() {
    return clientReference.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CLIENT_REFERENCE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> clientReference() {
    return clientReference;
  }

  @JsonIgnore
  public DeliveryReceiptErrorCode getCode() {
    return code.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CODE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<DeliveryReceiptErrorCode> code() {
    return code;
  }

  @JsonIgnore
  public EncodingType getEncoding() {
    return encoding.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ENCODING)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<EncodingType> encoding() {
    return encoding;
  }

  @JsonIgnore
  public Integer getNumberOfMessageParts() {
    return numberOfMessageParts.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NUMBER_OF_MESSAGE_PARTS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> numberOfMessageParts() {
    return numberOfMessageParts;
  }

  @JsonIgnore
  public String getOperator() {
    return operator.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_OPERATOR)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> operator() {
    return operator;
  }

  @JsonIgnore
  public Instant getOperatorStatusAt() {
    return operatorStatusAt.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_OPERATOR_STATUS_AT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> operatorStatusAt() {
    return operatorStatusAt;
  }

  @JsonIgnore
  public String getRecipient() {
    return recipient.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RECIPIENT)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> recipient() {
    return recipient;
  }

  @JsonIgnore
  public DeliveryStatus getStatus() {
    return status.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_STATUS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<DeliveryStatus> status() {
    return status;
  }

  @JsonIgnore
  public TypeEnum getType() {
    return type.orElse(null);
  }

  @JsonIgnore
  public OptionalValue<TypeEnum> type() {
    return type;
  }

  /** Return true if this RecipientDeliveryReportSMS object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RecipientDeliveryReportSMSImpl recipientDeliveryReportSMS = (RecipientDeliveryReportSMSImpl) o;
    return Objects.equals(this.appliedOriginator, recipientDeliveryReportSMS.appliedOriginator)
        && Objects.equals(this.createdAt, recipientDeliveryReportSMS.createdAt)
        && Objects.equals(this.batchId, recipientDeliveryReportSMS.batchId)
        && Objects.equals(this.clientReference, recipientDeliveryReportSMS.clientReference)
        && Objects.equals(this.code, recipientDeliveryReportSMS.code)
        && Objects.equals(this.encoding, recipientDeliveryReportSMS.encoding)
        && Objects.equals(
            this.numberOfMessageParts, recipientDeliveryReportSMS.numberOfMessageParts)
        && Objects.equals(this.operator, recipientDeliveryReportSMS.operator)
        && Objects.equals(this.operatorStatusAt, recipientDeliveryReportSMS.operatorStatusAt)
        && Objects.equals(this.recipient, recipientDeliveryReportSMS.recipient)
        && Objects.equals(this.status, recipientDeliveryReportSMS.status)
        && Objects.equals(this.type, recipientDeliveryReportSMS.type);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        appliedOriginator,
        createdAt,
        batchId,
        clientReference,
        code,
        encoding,
        numberOfMessageParts,
        operator,
        operatorStatusAt,
        recipient,
        status,
        type);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RecipientDeliveryReportSMSImpl {\n");
    sb.append("    appliedOriginator: ").append(toIndentedString(appliedOriginator)).append("\n");
    sb.append("    createdAt: ").append(toIndentedString(createdAt)).append("\n");
    sb.append("    batchId: ").append(toIndentedString(batchId)).append("\n");
    sb.append("    clientReference: ").append(toIndentedString(clientReference)).append("\n");
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    encoding: ").append(toIndentedString(encoding)).append("\n");
    sb.append("    numberOfMessageParts: ")
        .append(toIndentedString(numberOfMessageParts))
        .append("\n");
    sb.append("    operator: ").append(toIndentedString(operator)).append("\n");
    sb.append("    operatorStatusAt: ").append(toIndentedString(operatorStatusAt)).append("\n");
    sb.append("    recipient: ").append(toIndentedString(recipient)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
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

  @JsonPOJOBuilder(withPrefix = "set")
  static class Builder implements RecipientDeliveryReportSMS.Builder {
    OptionalValue<String> appliedOriginator = OptionalValue.empty();
    OptionalValue<Instant> createdAt = OptionalValue.empty();
    OptionalValue<String> batchId = OptionalValue.empty();
    OptionalValue<String> clientReference = OptionalValue.empty();
    OptionalValue<DeliveryReceiptErrorCode> code = OptionalValue.empty();
    OptionalValue<EncodingType> encoding = OptionalValue.empty();
    OptionalValue<Integer> numberOfMessageParts = OptionalValue.empty();
    OptionalValue<String> operator = OptionalValue.empty();
    OptionalValue<Instant> operatorStatusAt = OptionalValue.empty();
    OptionalValue<String> recipient = OptionalValue.empty();
    OptionalValue<DeliveryStatus> status = OptionalValue.empty();
    OptionalValue<TypeEnum> type = OptionalValue.of(TypeEnum.RECIPIENT_DELIVERY_REPORT_SMS);

    @JsonProperty(JSON_PROPERTY_APPLIED_ORIGINATOR)
    public Builder setAppliedOriginator(String appliedOriginator) {
      this.appliedOriginator = OptionalValue.of(appliedOriginator);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_AT)
    public Builder setCreatedAt(Instant createdAt) {
      this.createdAt = OptionalValue.of(createdAt);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_BATCH_ID)
    public Builder setBatchId(String batchId) {
      this.batchId = OptionalValue.of(batchId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CLIENT_REFERENCE)
    public Builder setClientReference(String clientReference) {
      this.clientReference = OptionalValue.of(clientReference);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CODE)
    public Builder setCode(DeliveryReceiptErrorCode code) {
      this.code = OptionalValue.of(code);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ENCODING)
    public Builder setEncoding(EncodingType encoding) {
      this.encoding = OptionalValue.of(encoding);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_NUMBER_OF_MESSAGE_PARTS)
    public Builder setNumberOfMessageParts(Integer numberOfMessageParts) {
      this.numberOfMessageParts = OptionalValue.of(numberOfMessageParts);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_OPERATOR)
    public Builder setOperator(String operator) {
      this.operator = OptionalValue.of(operator);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_OPERATOR_STATUS_AT)
    public Builder setOperatorStatusAt(Instant operatorStatusAt) {
      this.operatorStatusAt = OptionalValue.of(operatorStatusAt);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_RECIPIENT)
    public Builder setRecipient(String recipient) {
      this.recipient = OptionalValue.of(recipient);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_STATUS)
    public Builder setStatus(DeliveryStatus status) {
      this.status = OptionalValue.of(status);
      return this;
    }

    public RecipientDeliveryReportSMS build() {
      return new RecipientDeliveryReportSMSImpl(
          appliedOriginator,
          createdAt,
          batchId,
          clientReference,
          code,
          encoding,
          numberOfMessageParts,
          operator,
          operatorStatusAt,
          recipient,
          status,
          type);
    }
  }
}
