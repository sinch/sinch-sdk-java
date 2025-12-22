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
  OrderDetailsPaymentImpl.JSON_PROPERTY_TYPE,
  OrderDetailsPaymentImpl.JSON_PROPERTY_REFERENCE_ID,
  OrderDetailsPaymentImpl.JSON_PROPERTY_TYPE_OF_GOODS,
  OrderDetailsPaymentImpl.JSON_PROPERTY_PAYMENT_SETTINGS,
  OrderDetailsPaymentImpl.JSON_PROPERTY_TOTAL_AMOUNT_VALUE,
  OrderDetailsPaymentImpl.JSON_PROPERTY_ORDER
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OrderDetailsPaymentImpl implements OrderDetailsPayment {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_TYPE = "type";

  private OptionalValue<TypeEnum> type;

  public static final String JSON_PROPERTY_REFERENCE_ID = "reference_id";

  private OptionalValue<String> referenceId;

  public static final String JSON_PROPERTY_TYPE_OF_GOODS = "type_of_goods";

  private OptionalValue<TypeOfGoodsEnum> typeOfGoods;

  public static final String JSON_PROPERTY_PAYMENT_SETTINGS = "payment_settings";

  private OptionalValue<OrderDetailsSettings> paymentSettings;

  public static final String JSON_PROPERTY_TOTAL_AMOUNT_VALUE = "total_amount_value";

  private OptionalValue<Integer> totalAmountValue;

  public static final String JSON_PROPERTY_ORDER = "order";

  private OptionalValue<OrderDetailsPaymentOrder> order;

  public OrderDetailsPaymentImpl() {}

  protected OrderDetailsPaymentImpl(
      OptionalValue<TypeEnum> type,
      OptionalValue<String> referenceId,
      OptionalValue<TypeOfGoodsEnum> typeOfGoods,
      OptionalValue<OrderDetailsSettings> paymentSettings,
      OptionalValue<Integer> totalAmountValue,
      OptionalValue<OrderDetailsPaymentOrder> order) {
    this.type = type;
    this.referenceId = referenceId;
    this.typeOfGoods = typeOfGoods;
    this.paymentSettings = paymentSettings;
    this.totalAmountValue = totalAmountValue;
    this.order = order;
  }

  @JsonIgnore
  public TypeEnum getType() {
    return type.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<TypeEnum> type() {
    return type;
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
  public TypeOfGoodsEnum getTypeOfGoods() {
    return typeOfGoods.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TYPE_OF_GOODS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<TypeOfGoodsEnum> typeOfGoods() {
    return typeOfGoods;
  }

  @JsonIgnore
  public OrderDetailsSettings getPaymentSettings() {
    return paymentSettings.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PAYMENT_SETTINGS)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<OrderDetailsSettings> paymentSettings() {
    return paymentSettings;
  }

  @JsonIgnore
  public Integer getTotalAmountValue() {
    return totalAmountValue.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TOTAL_AMOUNT_VALUE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Integer> totalAmountValue() {
    return totalAmountValue;
  }

  @JsonIgnore
  public OrderDetailsPaymentOrder getOrder() {
    return order.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ORDER)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<OrderDetailsPaymentOrder> order() {
    return order;
  }

  /**
   * Return true if this WhatsApp_Payment_Order_Details_channel_specific_message__payment object is
   * equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderDetailsPaymentImpl whatsAppPaymentOrderDetailsChannelSpecificMessagePayment =
        (OrderDetailsPaymentImpl) o;
    return Objects.equals(this.type, whatsAppPaymentOrderDetailsChannelSpecificMessagePayment.type)
        && Objects.equals(
            this.referenceId, whatsAppPaymentOrderDetailsChannelSpecificMessagePayment.referenceId)
        && Objects.equals(
            this.typeOfGoods, whatsAppPaymentOrderDetailsChannelSpecificMessagePayment.typeOfGoods)
        && Objects.equals(
            this.paymentSettings,
            whatsAppPaymentOrderDetailsChannelSpecificMessagePayment.paymentSettings)
        && Objects.equals(
            this.totalAmountValue,
            whatsAppPaymentOrderDetailsChannelSpecificMessagePayment.totalAmountValue)
        && Objects.equals(
            this.order, whatsAppPaymentOrderDetailsChannelSpecificMessagePayment.order);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, referenceId, typeOfGoods, paymentSettings, totalAmountValue, order);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderDetailsPaymentImpl {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    referenceId: ").append(toIndentedString(referenceId)).append("\n");
    sb.append("    typeOfGoods: ").append(toIndentedString(typeOfGoods)).append("\n");
    sb.append("    paymentSettings: ").append(toIndentedString(paymentSettings)).append("\n");
    sb.append("    totalAmountValue: ").append(toIndentedString(totalAmountValue)).append("\n");
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
  static class Builder implements OrderDetailsPayment.Builder {
    OptionalValue<TypeEnum> type = OptionalValue.empty();
    OptionalValue<String> referenceId = OptionalValue.empty();
    OptionalValue<TypeOfGoodsEnum> typeOfGoods = OptionalValue.empty();
    OptionalValue<OrderDetailsSettings> paymentSettings = OptionalValue.empty();
    OptionalValue<Integer> totalAmountValue = OptionalValue.empty();
    OptionalValue<OrderDetailsPaymentOrder> order = OptionalValue.empty();

    @JsonProperty(value = JSON_PROPERTY_TYPE, required = true)
    public Builder setType(TypeEnum type) {
      this.type = OptionalValue.of(type);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_REFERENCE_ID, required = true)
    public Builder setReferenceId(String referenceId) {
      this.referenceId = OptionalValue.of(referenceId);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_TYPE_OF_GOODS, required = true)
    public Builder setTypeOfGoods(TypeOfGoodsEnum typeOfGoods) {
      this.typeOfGoods = OptionalValue.of(typeOfGoods);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PAYMENT_SETTINGS)
    public Builder setPaymentSettings(OrderDetailsSettings paymentSettings) {
      this.paymentSettings = OptionalValue.of(paymentSettings);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_TOTAL_AMOUNT_VALUE, required = true)
    public Builder setTotalAmountValue(Integer totalAmountValue) {
      this.totalAmountValue = OptionalValue.of(totalAmountValue);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_ORDER, required = true)
    public Builder setOrder(OrderDetailsPaymentOrder order) {
      this.order = OptionalValue.of(order);
      return this;
    }

    public OrderDetailsPayment build() {
      return new OrderDetailsPaymentImpl(
          type, referenceId, typeOfGoods, paymentSettings, totalAmountValue, order);
    }
  }
}
