package com.sinch.sdk.domains.conversation.models.v1.events.types;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.events.types.internal.PaymentStatusUpdateEventInternal;
import com.sinch.sdk.domains.conversation.models.v1.events.types.internal.PaymentStatusUpdateEventInternalImpl;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@JsonPropertyOrder({PaymentStatusUpdateEventImpl.JSON_PROPERTY_PAYMENT_STATUS_UPDATE_EVENT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class PaymentStatusUpdateEventImpl
    implements PaymentStatusUpdateEvent,
        com.sinch.sdk.domains.conversation.models.v1.events.ContactMessageEvent {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PAYMENT_STATUS_UPDATE_EVENT =
      "payment_status_update_event";

  private OptionalValue<PaymentStatusUpdateEventInternal> paymentStatusUpdateEvent;

  public PaymentStatusUpdateEventImpl() {}

  protected PaymentStatusUpdateEventImpl(
      OptionalValue<PaymentStatusUpdateEventInternal> paymentStatusUpdateEvent) {
    this.paymentStatusUpdateEvent = paymentStatusUpdateEvent;
  }

  @JsonIgnore
  public PaymentStatusUpdateEventInternal getPaymentStatusUpdateEvent() {
    return paymentStatusUpdateEvent.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PAYMENT_STATUS_UPDATE_EVENT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<PaymentStatusUpdateEventInternal> paymentStatusUpdateEvent() {
    return paymentStatusUpdateEvent;
  }

  @JsonIgnore
  public String getReferenceId() {
    if (null == paymentStatusUpdateEvent
        || !paymentStatusUpdateEvent.isPresent()
        || null == paymentStatusUpdateEvent.get().getReferenceId()) {
      return null;
    }
    return paymentStatusUpdateEvent.get().getReferenceId();
  }

  public OptionalValue<String> referenceId() {
    return null != paymentStatusUpdateEvent && paymentStatusUpdateEvent.isPresent()
        ? paymentStatusUpdateEvent
            .map(f -> ((PaymentStatusUpdateEventInternalImpl) f).referenceId())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public PaymentStatus getPaymentStatus() {
    if (null == paymentStatusUpdateEvent
        || !paymentStatusUpdateEvent.isPresent()
        || null == paymentStatusUpdateEvent.get().getPaymentStatus()) {
      return null;
    }
    return paymentStatusUpdateEvent.get().getPaymentStatus();
  }

  public OptionalValue<PaymentStatus> paymentStatus() {
    return null != paymentStatusUpdateEvent && paymentStatusUpdateEvent.isPresent()
        ? paymentStatusUpdateEvent
            .map(f -> ((PaymentStatusUpdateEventInternalImpl) f).paymentStatus())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public PaymentTransactionStatus getPaymentTransactionStatus() {
    if (null == paymentStatusUpdateEvent
        || !paymentStatusUpdateEvent.isPresent()
        || null == paymentStatusUpdateEvent.get().getPaymentTransactionStatus()) {
      return null;
    }
    return paymentStatusUpdateEvent.get().getPaymentTransactionStatus();
  }

  public OptionalValue<PaymentTransactionStatus> paymentTransactionStatus() {
    return null != paymentStatusUpdateEvent && paymentStatusUpdateEvent.isPresent()
        ? paymentStatusUpdateEvent
            .map(f -> ((PaymentStatusUpdateEventInternalImpl) f).paymentTransactionStatus())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getPaymentTransactionId() {
    if (null == paymentStatusUpdateEvent
        || !paymentStatusUpdateEvent.isPresent()
        || null == paymentStatusUpdateEvent.get().getPaymentTransactionId()) {
      return null;
    }
    return paymentStatusUpdateEvent.get().getPaymentTransactionId();
  }

  public OptionalValue<String> paymentTransactionId() {
    return null != paymentStatusUpdateEvent && paymentStatusUpdateEvent.isPresent()
        ? paymentStatusUpdateEvent
            .map(f -> ((PaymentStatusUpdateEventInternalImpl) f).paymentTransactionId())
            .orElse(OptionalValue.empty())
        : OptionalValue.empty();
  }

  /** Return true if this Payment_Status_Update object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentStatusUpdateEventImpl paymentStatusUpdate = (PaymentStatusUpdateEventImpl) o;
    return Objects.equals(
        this.paymentStatusUpdateEvent, paymentStatusUpdate.paymentStatusUpdateEvent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentStatusUpdateEvent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentStatusUpdateEventImpl {\n");
    sb.append("    paymentStatusUpdateEvent: ")
        .append(toIndentedString(paymentStatusUpdateEvent))
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
  static class Builder implements PaymentStatusUpdateEvent.Builder {
    OptionalValue<PaymentStatusUpdateEventInternal> paymentStatusUpdateEvent =
        OptionalValue.empty();

    PaymentStatusUpdateEventInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_PAYMENT_STATUS_UPDATE_EVENT, required = true)
    public Builder setPaymentStatusUpdateEvent(
        PaymentStatusUpdateEventInternal paymentStatusUpdateEvent) {
      this.paymentStatusUpdateEvent = OptionalValue.of(paymentStatusUpdateEvent);
      return this;
    }

    @JsonIgnore
    public Builder setReferenceId(String referenceId) {
      getDelegatedBuilder().setReferenceId(referenceId);
      return this;
    }

    @JsonIgnore
    public Builder setPaymentStatus(PaymentStatus paymentStatus) {
      getDelegatedBuilder().setPaymentStatus(paymentStatus);
      return this;
    }

    @JsonIgnore
    public Builder setPaymentTransactionStatus(PaymentTransactionStatus paymentTransactionStatus) {
      getDelegatedBuilder().setPaymentTransactionStatus(paymentTransactionStatus);
      return this;
    }

    @JsonIgnore
    public Builder setPaymentTransactionId(String paymentTransactionId) {
      getDelegatedBuilder().setPaymentTransactionId(paymentTransactionId);
      return this;
    }

    private PaymentStatusUpdateEventInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = PaymentStatusUpdateEventInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public PaymentStatusUpdateEvent build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.paymentStatusUpdateEvent = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new PaymentStatusUpdateEventImpl(paymentStatusUpdateEvent);
    }
  }

  public static class DelegatedSerializer
      extends JsonSerializer<OptionalValue<PaymentStatusUpdateEvent>> {
    @Override
    public void serialize(
        OptionalValue<PaymentStatusUpdateEvent> value,
        JsonGenerator jgen,
        SerializerProvider provider)
        throws IOException {

      if (!value.isPresent()) {
        return;
      }
      PaymentStatusUpdateEventImpl impl = (PaymentStatusUpdateEventImpl) value.get();
      jgen.writeObject(null != impl ? impl.getPaymentStatusUpdateEvent() : null);
    }
  }

  public static class DelegatedDeSerializer extends JsonDeserializer<PaymentStatusUpdateEvent> {
    @Override
    public PaymentStatusUpdateEvent deserialize(JsonParser jp, DeserializationContext ctxt)
        throws IOException {

      PaymentStatusUpdateEventImpl.Builder builder = new PaymentStatusUpdateEventImpl.Builder();
      PaymentStatusUpdateEventInternalImpl deserialized =
          jp.readValueAs(PaymentStatusUpdateEventInternalImpl.class);
      builder.setPaymentStatusUpdateEvent(deserialized);
      return builder.build();
    }
  }

  public static Optional<PaymentStatusUpdateEvent> delegatedConverter(
      PaymentStatusUpdateEventInternal internal) {
    if (null == internal) {
      return Optional.empty();
    }
    return Optional.of(new Builder().setPaymentStatusUpdateEvent(internal).build());
  }
}
