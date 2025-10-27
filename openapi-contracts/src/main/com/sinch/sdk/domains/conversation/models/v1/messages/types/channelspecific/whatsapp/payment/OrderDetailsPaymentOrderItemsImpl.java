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
  OrderDetailsPaymentOrderItemsImpl.JSON_PROPERTY_RETAILER_ID,
  OrderDetailsPaymentOrderItemsImpl.JSON_PROPERTY_NAME,
  OrderDetailsPaymentOrderItemsImpl.JSON_PROPERTY_AMOUNT_VALUE,
  OrderDetailsPaymentOrderItemsImpl.JSON_PROPERTY_QUANTITY,
  OrderDetailsPaymentOrderItemsImpl.JSON_PROPERTY_SALE_AMOUNT_VALUE
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OrderDetailsPaymentOrderItemsImpl implements OrderDetailsPaymentOrderItems {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_RETAILER_ID = "retailer_id";

  private OptionalValue<String> retailerId;

  public static final String JSON_PROPERTY_NAME = "name";

  private OptionalValue<String> name;

  public static final String JSON_PROPERTY_AMOUNT_VALUE = "amount_value";

  private OptionalValue<Integer> amountValue;

  public static final String JSON_PROPERTY_QUANTITY = "quantity";

  private OptionalValue<Integer> quantity;

  public static final String JSON_PROPERTY_SALE_AMOUNT_VALUE = "sale_amount_value";

  private OptionalValue<Integer> saleAmountValue;

  public OrderDetailsPaymentOrderItemsImpl() {}

  protected OrderDetailsPaymentOrderItemsImpl(
      OptionalValue<String> retailerId,
      OptionalValue<String> name,
      OptionalValue<Integer> amountValue,
      OptionalValue<Integer> quantity,
      OptionalValue<Integer> saleAmountValue) {
    this.retailerId = retailerId;
    this.name = name;
    this.amountValue = amountValue;
    this.quantity = quantity;
    this.saleAmountValue = saleAmountValue;
  }

  @JsonIgnore
  public String getRetailerId() {
    return retailerId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_RETAILER_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> retailerId() {
    return retailerId;
  }

  @JsonIgnore
  public String getName() {
    return name.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_NAME)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> name() {
    return name;
  }

  @JsonIgnore
  public Integer getAmountValue() {
    return amountValue.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_AMOUNT_VALUE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Integer> amountValue() {
    return amountValue;
  }

  @JsonIgnore
  public Integer getQuantity() {
    return quantity.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_QUANTITY)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Integer> quantity() {
    return quantity;
  }

  @JsonIgnore
  public Integer getSaleAmountValue() {
    return saleAmountValue.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SALE_AMOUNT_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> saleAmountValue() {
    return saleAmountValue;
  }

  /**
   * Return true if this
   * WhatsApp_Payment_Order_Details_channel_specific_message__payment_order_items object is equal to
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
    OrderDetailsPaymentOrderItemsImpl
        whatsAppPaymentOrderDetailsChannelSpecificMessagePaymentOrderItems =
            (OrderDetailsPaymentOrderItemsImpl) o;
    return Objects.equals(
            this.retailerId,
            whatsAppPaymentOrderDetailsChannelSpecificMessagePaymentOrderItems.retailerId)
        && Objects.equals(
            this.name, whatsAppPaymentOrderDetailsChannelSpecificMessagePaymentOrderItems.name)
        && Objects.equals(
            this.amountValue,
            whatsAppPaymentOrderDetailsChannelSpecificMessagePaymentOrderItems.amountValue)
        && Objects.equals(
            this.quantity,
            whatsAppPaymentOrderDetailsChannelSpecificMessagePaymentOrderItems.quantity)
        && Objects.equals(
            this.saleAmountValue,
            whatsAppPaymentOrderDetailsChannelSpecificMessagePaymentOrderItems.saleAmountValue);
  }

  @Override
  public int hashCode() {
    return Objects.hash(retailerId, name, amountValue, quantity, saleAmountValue);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderDetailsPaymentOrderItemsImpl {\n");
    sb.append("    retailerId: ").append(toIndentedString(retailerId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    amountValue: ").append(toIndentedString(amountValue)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    saleAmountValue: ").append(toIndentedString(saleAmountValue)).append("\n");
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
  static class Builder implements OrderDetailsPaymentOrderItems.Builder {
    OptionalValue<String> retailerId = OptionalValue.empty();
    OptionalValue<String> name = OptionalValue.empty();
    OptionalValue<Integer> amountValue = OptionalValue.empty();
    OptionalValue<Integer> quantity = OptionalValue.empty();
    OptionalValue<Integer> saleAmountValue = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_RETAILER_ID, required = true)
    public Builder setRetailerId(String retailerId) {
      this.retailerId = OptionalValue.of(retailerId);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_NAME, required = true)
    public Builder setName(String name) {
      this.name = OptionalValue.of(name);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_AMOUNT_VALUE, required = true)
    public Builder setAmountValue(Integer amountValue) {
      this.amountValue = OptionalValue.of(amountValue);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_QUANTITY, required = true)
    public Builder setQuantity(Integer quantity) {
      this.quantity = OptionalValue.of(quantity);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SALE_AMOUNT_VALUE)
    public Builder setSaleAmountValue(Integer saleAmountValue) {
      this.saleAmountValue = OptionalValue.of(saleAmountValue);
      return this;
    }

    public OrderDetailsPaymentOrderItems build() {
      return new OrderDetailsPaymentOrderItemsImpl(
          retailerId, name, amountValue, quantity, saleAmountValue);
    }
  }
}
