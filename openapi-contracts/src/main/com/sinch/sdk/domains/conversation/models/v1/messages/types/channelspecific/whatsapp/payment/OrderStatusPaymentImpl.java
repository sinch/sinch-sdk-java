package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  OrderStatusPaymentImpl.JSON_PROPERTY_REFERENCE_ID,
  OrderStatusPaymentImpl.JSON_PROPERTY_ORDER
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OrderStatusPaymentImpl implements OrderStatusPayment {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_REFERENCE_ID = "reference_id";

  private OptionalValue<String> referenceId;

  public static final String JSON_PROPERTY_ORDER = "order";

  private OptionalValue<OrderStatusPaymentDetails> order;

  public OrderStatusPaymentImpl() {}

  protected OrderStatusPaymentImpl(
      OptionalValue<String> referenceId, OptionalValue<OrderStatusPaymentDetails> order) {
    this.referenceId = referenceId;
    this.order = order;
  }

  @JsonIgnore
  public String getReferenceId() {
    return referenceId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_REFERENCE_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> referenceId() {
    return referenceId;
  }

  @JsonIgnore
  public OrderStatusPaymentDetails getOrder() {
    return order.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ORDER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<OrderStatusPaymentDetails> order() {
    return order;
  }

  /**
   * Return true if this Payment_Order_Status_channel_specific_message__payment object is equal to
   * o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderStatusPaymentImpl paymentOrderStatusChannelSpecificMessagePayment =
        (OrderStatusPaymentImpl) o;
    return Objects.equals(
            this.referenceId, paymentOrderStatusChannelSpecificMessagePayment.referenceId)
        && Objects.equals(this.order, paymentOrderStatusChannelSpecificMessagePayment.order);
  }

  @Override
  public int hashCode() {
    return Objects.hash(referenceId, order);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderStatusPaymentImpl {\n");
    sb.append("    referenceId: ").append(toIndentedString(referenceId)).append("\n");
    sb.append("    order: ").append(toIndentedString(order)).append("\n");
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
  static class Builder implements OrderStatusPayment.Builder {
    OptionalValue<String> referenceId = OptionalValue.empty();
    OptionalValue<OrderStatusPaymentDetails> order = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_REFERENCE_ID, required = true)
    public Builder setReferenceId(String referenceId) {
      this.referenceId = OptionalValue.of(referenceId);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_ORDER, required = true)
    public Builder setOrder(OrderStatusPaymentDetails order) {
      this.order = OptionalValue.of(order);
      return this;
    }

    public OrderStatusPayment build() {
      return new OrderStatusPaymentImpl(referenceId, order);
    }
  }
}
