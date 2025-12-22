package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.sinch.sdk.core.models.OptionalValue;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  OrderDetailsPaymentOrderImpl.JSON_PROPERTY_CATALOG_ID,
  OrderDetailsPaymentOrderImpl.JSON_PROPERTY_EXPIRATION_TIME,
  OrderDetailsPaymentOrderImpl.JSON_PROPERTY_EXPIRATION_DESCRIPTION,
  OrderDetailsPaymentOrderImpl.JSON_PROPERTY_SUBTOTAL_VALUE,
  OrderDetailsPaymentOrderImpl.JSON_PROPERTY_TAX_VALUE,
  OrderDetailsPaymentOrderImpl.JSON_PROPERTY_TAX_DESCRIPTION,
  OrderDetailsPaymentOrderImpl.JSON_PROPERTY_SHIPPING_VALUE,
  OrderDetailsPaymentOrderImpl.JSON_PROPERTY_SHIPPING_DESCRIPTION,
  OrderDetailsPaymentOrderImpl.JSON_PROPERTY_DISCOUNT_VALUE,
  OrderDetailsPaymentOrderImpl.JSON_PROPERTY_DISCOUNT_DESCRIPTION,
  OrderDetailsPaymentOrderImpl.JSON_PROPERTY_DISCOUNT_PROGRAM_NAME,
  OrderDetailsPaymentOrderImpl.JSON_PROPERTY_ITEMS
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class OrderDetailsPaymentOrderImpl implements OrderDetailsPaymentOrder {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CATALOG_ID = "catalog_id";

  private OptionalValue<String> catalogId;

  public static final String JSON_PROPERTY_EXPIRATION_TIME = "expiration_time";

  private OptionalValue<Instant> expirationTime;

  public static final String JSON_PROPERTY_EXPIRATION_DESCRIPTION = "expiration_description";

  private OptionalValue<String> expirationDescription;

  public static final String JSON_PROPERTY_SUBTOTAL_VALUE = "subtotal_value";

  private OptionalValue<Integer> subtotalValue;

  public static final String JSON_PROPERTY_TAX_VALUE = "tax_value";

  private OptionalValue<Integer> taxValue;

  public static final String JSON_PROPERTY_TAX_DESCRIPTION = "tax_description";

  private OptionalValue<String> taxDescription;

  public static final String JSON_PROPERTY_SHIPPING_VALUE = "shipping_value";

  private OptionalValue<Integer> shippingValue;

  public static final String JSON_PROPERTY_SHIPPING_DESCRIPTION = "shipping_description";

  private OptionalValue<String> shippingDescription;

  public static final String JSON_PROPERTY_DISCOUNT_VALUE = "discount_value";

  private OptionalValue<Integer> discountValue;

  public static final String JSON_PROPERTY_DISCOUNT_DESCRIPTION = "discount_description";

  private OptionalValue<String> discountDescription;

  public static final String JSON_PROPERTY_DISCOUNT_PROGRAM_NAME = "discount_program_name";

  private OptionalValue<String> discountProgramName;

  public static final String JSON_PROPERTY_ITEMS = "items";

  private OptionalValue<List<OrderDetailsPaymentOrderItems>> items;

  public OrderDetailsPaymentOrderImpl() {}

  protected OrderDetailsPaymentOrderImpl(
      OptionalValue<String> catalogId,
      OptionalValue<Instant> expirationTime,
      OptionalValue<String> expirationDescription,
      OptionalValue<Integer> subtotalValue,
      OptionalValue<Integer> taxValue,
      OptionalValue<String> taxDescription,
      OptionalValue<Integer> shippingValue,
      OptionalValue<String> shippingDescription,
      OptionalValue<Integer> discountValue,
      OptionalValue<String> discountDescription,
      OptionalValue<String> discountProgramName,
      OptionalValue<List<OrderDetailsPaymentOrderItems>> items) {
    this.catalogId = catalogId;
    this.expirationTime = expirationTime;
    this.expirationDescription = expirationDescription;
    this.subtotalValue = subtotalValue;
    this.taxValue = taxValue;
    this.taxDescription = taxDescription;
    this.shippingValue = shippingValue;
    this.shippingDescription = shippingDescription;
    this.discountValue = discountValue;
    this.discountDescription = discountDescription;
    this.discountProgramName = discountProgramName;
    this.items = items;
  }

  @JsonIgnore
  public String getCatalogId() {
    return catalogId.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CATALOG_ID)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> catalogId() {
    return catalogId;
  }

  @JsonIgnore
  public Instant getExpirationTime() {
    return expirationTime.orElse(null);
  }

  @JsonSerialize(
      using =
          com.sinch.sdk.core.utils.databind.EpochTimeMapper.InstantToEpochSecondsStringSerializer
              .class)
  @JsonProperty(JSON_PROPERTY_EXPIRATION_TIME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Instant> expirationTime() {
    return expirationTime;
  }

  @JsonIgnore
  public String getExpirationDescription() {
    return expirationDescription.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_EXPIRATION_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> expirationDescription() {
    return expirationDescription;
  }

  @JsonIgnore
  public Integer getSubtotalValue() {
    return subtotalValue.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SUBTOTAL_VALUE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Integer> subtotalValue() {
    return subtotalValue;
  }

  @JsonIgnore
  public Integer getTaxValue() {
    return taxValue.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TAX_VALUE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<Integer> taxValue() {
    return taxValue;
  }

  @JsonIgnore
  public String getTaxDescription() {
    return taxDescription.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TAX_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> taxDescription() {
    return taxDescription;
  }

  @JsonIgnore
  public Integer getShippingValue() {
    return shippingValue.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SHIPPING_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> shippingValue() {
    return shippingValue;
  }

  @JsonIgnore
  public String getShippingDescription() {
    return shippingDescription.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_SHIPPING_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> shippingDescription() {
    return shippingDescription;
  }

  @JsonIgnore
  public Integer getDiscountValue() {
    return discountValue.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DISCOUNT_VALUE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> discountValue() {
    return discountValue;
  }

  @JsonIgnore
  public String getDiscountDescription() {
    return discountDescription.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DISCOUNT_DESCRIPTION)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> discountDescription() {
    return discountDescription;
  }

  @JsonIgnore
  public String getDiscountProgramName() {
    return discountProgramName.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_DISCOUNT_PROGRAM_NAME)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> discountProgramName() {
    return discountProgramName;
  }

  @JsonIgnore
  public List<OrderDetailsPaymentOrderItems> getItems() {
    return items.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ITEMS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<OrderDetailsPaymentOrderItems>> items() {
    return items;
  }

  /**
   * Return true if this WhatsApp_Payment_Order_Details_channel_specific_message__payment_order
   * object is equal to o.
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderDetailsPaymentOrderImpl whatsAppPaymentOrderDetailsChannelSpecificMessagePaymentOrder =
        (OrderDetailsPaymentOrderImpl) o;
    return Objects.equals(
            this.catalogId, whatsAppPaymentOrderDetailsChannelSpecificMessagePaymentOrder.catalogId)
        && Objects.equals(
            this.expirationTime,
            whatsAppPaymentOrderDetailsChannelSpecificMessagePaymentOrder.expirationTime)
        && Objects.equals(
            this.expirationDescription,
            whatsAppPaymentOrderDetailsChannelSpecificMessagePaymentOrder.expirationDescription)
        && Objects.equals(
            this.subtotalValue,
            whatsAppPaymentOrderDetailsChannelSpecificMessagePaymentOrder.subtotalValue)
        && Objects.equals(
            this.taxValue, whatsAppPaymentOrderDetailsChannelSpecificMessagePaymentOrder.taxValue)
        && Objects.equals(
            this.taxDescription,
            whatsAppPaymentOrderDetailsChannelSpecificMessagePaymentOrder.taxDescription)
        && Objects.equals(
            this.shippingValue,
            whatsAppPaymentOrderDetailsChannelSpecificMessagePaymentOrder.shippingValue)
        && Objects.equals(
            this.shippingDescription,
            whatsAppPaymentOrderDetailsChannelSpecificMessagePaymentOrder.shippingDescription)
        && Objects.equals(
            this.discountValue,
            whatsAppPaymentOrderDetailsChannelSpecificMessagePaymentOrder.discountValue)
        && Objects.equals(
            this.discountDescription,
            whatsAppPaymentOrderDetailsChannelSpecificMessagePaymentOrder.discountDescription)
        && Objects.equals(
            this.discountProgramName,
            whatsAppPaymentOrderDetailsChannelSpecificMessagePaymentOrder.discountProgramName)
        && Objects.equals(
            this.items, whatsAppPaymentOrderDetailsChannelSpecificMessagePaymentOrder.items);
  }

  @Override
  public int hashCode() {
    return Objects.hash(
        catalogId,
        expirationTime,
        expirationDescription,
        subtotalValue,
        taxValue,
        taxDescription,
        shippingValue,
        shippingDescription,
        discountValue,
        discountDescription,
        discountProgramName,
        items);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderDetailsPaymentOrderImpl {\n");
    sb.append("    catalogId: ").append(toIndentedString(catalogId)).append("\n");
    sb.append("    expirationTime: ").append(toIndentedString(expirationTime)).append("\n");
    sb.append("    expirationDescription: ")
        .append(toIndentedString(expirationDescription))
        .append("\n");
    sb.append("    subtotalValue: ").append(toIndentedString(subtotalValue)).append("\n");
    sb.append("    taxValue: ").append(toIndentedString(taxValue)).append("\n");
    sb.append("    taxDescription: ").append(toIndentedString(taxDescription)).append("\n");
    sb.append("    shippingValue: ").append(toIndentedString(shippingValue)).append("\n");
    sb.append("    shippingDescription: ")
        .append(toIndentedString(shippingDescription))
        .append("\n");
    sb.append("    discountValue: ").append(toIndentedString(discountValue)).append("\n");
    sb.append("    discountDescription: ")
        .append(toIndentedString(discountDescription))
        .append("\n");
    sb.append("    discountProgramName: ")
        .append(toIndentedString(discountProgramName))
        .append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
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
  static class Builder implements OrderDetailsPaymentOrder.Builder {
    OptionalValue<String> catalogId = OptionalValue.empty();
    OptionalValue<Instant> expirationTime = OptionalValue.empty();
    OptionalValue<String> expirationDescription = OptionalValue.empty();
    OptionalValue<Integer> subtotalValue = OptionalValue.empty();
    OptionalValue<Integer> taxValue = OptionalValue.empty();
    OptionalValue<String> taxDescription = OptionalValue.empty();
    OptionalValue<Integer> shippingValue = OptionalValue.empty();
    OptionalValue<String> shippingDescription = OptionalValue.empty();
    OptionalValue<Integer> discountValue = OptionalValue.empty();
    OptionalValue<String> discountDescription = OptionalValue.empty();
    OptionalValue<String> discountProgramName = OptionalValue.empty();
    OptionalValue<List<OrderDetailsPaymentOrderItems>> items = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CATALOG_ID)
    public Builder setCatalogId(String catalogId) {
      this.catalogId = OptionalValue.of(catalogId);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_EXPIRATION_TIME)
    public Builder setExpirationTime(Instant expirationTime) {
      this.expirationTime = OptionalValue.of(expirationTime);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_EXPIRATION_DESCRIPTION)
    public Builder setExpirationDescription(String expirationDescription) {
      this.expirationDescription = OptionalValue.of(expirationDescription);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_SUBTOTAL_VALUE, required = true)
    public Builder setSubtotalValue(Integer subtotalValue) {
      this.subtotalValue = OptionalValue.of(subtotalValue);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_TAX_VALUE, required = true)
    public Builder setTaxValue(Integer taxValue) {
      this.taxValue = OptionalValue.of(taxValue);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TAX_DESCRIPTION)
    public Builder setTaxDescription(String taxDescription) {
      this.taxDescription = OptionalValue.of(taxDescription);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SHIPPING_VALUE)
    public Builder setShippingValue(Integer shippingValue) {
      this.shippingValue = OptionalValue.of(shippingValue);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_SHIPPING_DESCRIPTION)
    public Builder setShippingDescription(String shippingDescription) {
      this.shippingDescription = OptionalValue.of(shippingDescription);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DISCOUNT_VALUE)
    public Builder setDiscountValue(Integer discountValue) {
      this.discountValue = OptionalValue.of(discountValue);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DISCOUNT_DESCRIPTION)
    public Builder setDiscountDescription(String discountDescription) {
      this.discountDescription = OptionalValue.of(discountDescription);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_DISCOUNT_PROGRAM_NAME)
    public Builder setDiscountProgramName(String discountProgramName) {
      this.discountProgramName = OptionalValue.of(discountProgramName);
      return this;
    }

    @JsonProperty(value = JSON_PROPERTY_ITEMS, required = true)
    public Builder setItems(List<OrderDetailsPaymentOrderItems> items) {
      this.items = OptionalValue.of(items);
      return this;
    }

    public OrderDetailsPaymentOrder build() {
      return new OrderDetailsPaymentOrderImpl(
          catalogId,
          expirationTime,
          expirationDescription,
          subtotalValue,
          taxValue,
          taxDescription,
          shippingValue,
          shippingDescription,
          discountValue,
          discountDescription,
          discountProgramName,
          items);
    }
  }
}
