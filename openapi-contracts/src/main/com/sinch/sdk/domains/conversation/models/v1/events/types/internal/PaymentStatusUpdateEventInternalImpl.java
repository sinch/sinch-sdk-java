package com.sinch.sdk.domains.conversation.models.v1.events.types.internal;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.events.types.PaymentStatus;
import com.sinch.sdk.domains.conversation.models.v1.events.types.PaymentTransactionStatus;
import java.util.Objects;

@JsonPropertyOrder({
  PaymentStatusUpdateEventInternalImpl.JSON_PROPERTY_REFERENCE_ID,
  PaymentStatusUpdateEventInternalImpl.JSON_PROPERTY_PAYMENT_STATUS,
  PaymentStatusUpdateEventInternalImpl.JSON_PROPERTY_PAYMENT_TRANSACTION_STATUS,
  PaymentStatusUpdateEventInternalImpl.JSON_PROPERTY_PAYMENT_TRANSACTION_ID
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class PaymentStatusUpdateEventInternalImpl implements PaymentStatusUpdateEventInternal {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_REFERENCE_ID = "reference_id";

  private OptionalValue<String> referenceId;

  public static final String JSON_PROPERTY_PAYMENT_STATUS = "payment_status";

  private OptionalValue<PaymentStatus> paymentStatus;

  public static final String JSON_PROPERTY_PAYMENT_TRANSACTION_STATUS =
      "payment_transaction_status";

  private OptionalValue<PaymentTransactionStatus> paymentTransactionStatus;

  public static final String JSON_PROPERTY_PAYMENT_TRANSACTION_ID = "payment_transaction_id";

  private OptionalValue<String> paymentTransactionId;

  public PaymentStatusUpdateEventInternalImpl() {}

  protected PaymentStatusUpdateEventInternalImpl(
      OptionalValue<String> referenceId,
      OptionalValue<PaymentStatus> paymentStatus,
      OptionalValue<PaymentTransactionStatus> paymentTransactionStatus,
      OptionalValue<String> paymentTransactionId) {
    this.referenceId = referenceId;
    this.paymentStatus = paymentStatus;
    this.paymentTransactionStatus = paymentTransactionStatus;
    this.paymentTransactionId = paymentTransactionId;
  }

  @JsonIgnore
  public String getReferenceId() {
    return referenceId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REFERENCE_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> referenceId() {
    return referenceId;
  }

  @JsonIgnore
  public PaymentStatus getPaymentStatus() {
    return paymentStatus.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PAYMENT_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<PaymentStatus> paymentStatus() {
    return paymentStatus;
  }

  @JsonIgnore
  public PaymentTransactionStatus getPaymentTransactionStatus() {
    return paymentTransactionStatus.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PAYMENT_TRANSACTION_STATUS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<PaymentTransactionStatus> paymentTransactionStatus() {
    return paymentTransactionStatus;
  }

  @JsonIgnore
  public String getPaymentTransactionId() {
    return paymentTransactionId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PAYMENT_TRANSACTION_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> paymentTransactionId() {
    return paymentTransactionId;
  }

  /** Return true if this PaymentStatusUpdateEvent object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentStatusUpdateEventInternalImpl paymentStatusUpdateEvent =
        (PaymentStatusUpdateEventInternalImpl) o;
    return Objects.equals(this.referenceId, paymentStatusUpdateEvent.referenceId)
        && Objects.equals(this.paymentStatus, paymentStatusUpdateEvent.paymentStatus)
        && Objects.equals(
            this.paymentTransactionStatus, paymentStatusUpdateEvent.paymentTransactionStatus)
        && Objects.equals(this.paymentTransactionId, paymentStatusUpdateEvent.paymentTransactionId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(referenceId, paymentStatus, paymentTransactionStatus, paymentTransactionId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentStatusUpdateEventInternalImpl {\n");
    sb.append("    referenceId: ").append(toIndentedString(referenceId)).append("\n");
    sb.append("    paymentStatus: ").append(toIndentedString(paymentStatus)).append("\n");
    sb.append("    paymentTransactionStatus: ")
        .append(toIndentedString(paymentTransactionStatus))
        .append("\n");
    sb.append("    paymentTransactionId: ")
        .append(toIndentedString(paymentTransactionId))
        .append("\n");
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
  static class Builder implements PaymentStatusUpdateEventInternal.Builder {
    OptionalValue<String> referenceId = OptionalValue.empty();
    OptionalValue<PaymentStatus> paymentStatus = OptionalValue.empty();
    OptionalValue<PaymentTransactionStatus> paymentTransactionStatus = OptionalValue.empty();
    OptionalValue<String> paymentTransactionId = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_REFERENCE_ID)
    public Builder setReferenceId(String referenceId) {
      this.referenceId = OptionalValue.of(referenceId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PAYMENT_STATUS)
    public Builder setPaymentStatus(PaymentStatus paymentStatus) {
      this.paymentStatus = OptionalValue.of(paymentStatus);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PAYMENT_TRANSACTION_STATUS)
    public Builder setPaymentTransactionStatus(PaymentTransactionStatus paymentTransactionStatus) {
      this.paymentTransactionStatus = OptionalValue.of(paymentTransactionStatus);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PAYMENT_TRANSACTION_ID)
    public Builder setPaymentTransactionId(String paymentTransactionId) {
      this.paymentTransactionId = OptionalValue.of(paymentTransactionId);
      return this;
    }

    public PaymentStatusUpdateEventInternal build() {
      return new PaymentStatusUpdateEventInternalImpl(
          referenceId, paymentStatus, paymentTransactionStatus, paymentTransactionId);
    }
  }
}
