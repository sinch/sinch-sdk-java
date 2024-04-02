package com.sinch.sdk.domains.conversation.models.v1;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({
  ProductItemImpl.JSON_PROPERTY_ID,
  ProductItemImpl.JSON_PROPERTY_MARKETPLACE,
  ProductItemImpl.JSON_PROPERTY_QUANTITY,
  ProductItemImpl.JSON_PROPERTY_ITEM_PRICE,
  ProductItemImpl.JSON_PROPERTY_CURRENCY
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ProductItemImpl implements ProductItem {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_ID = "id";

  private OptionalValue<String> id;

  public static final String JSON_PROPERTY_MARKETPLACE = "marketplace";

  private OptionalValue<String> marketplace;

  public static final String JSON_PROPERTY_QUANTITY = "quantity";

  private OptionalValue<Integer> quantity;

  public static final String JSON_PROPERTY_ITEM_PRICE = "item_price";

  private OptionalValue<Float> itemPrice;

  public static final String JSON_PROPERTY_CURRENCY = "currency";

  private OptionalValue<String> currency;

  public ProductItemImpl() {}

  protected ProductItemImpl(
      OptionalValue<String> id,
      OptionalValue<String> marketplace,
      OptionalValue<Integer> quantity,
      OptionalValue<Float> itemPrice,
      OptionalValue<String> currency) {
    this.id = id;
    this.marketplace = marketplace;
    this.quantity = quantity;
    this.itemPrice = itemPrice;
    this.currency = currency;
  }

  @JsonIgnore
  public String getId() {
    return id.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ID)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> id() {
    return id;
  }

  @JsonIgnore
  public String getMarketplace() {
    return marketplace.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_MARKETPLACE)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<String> marketplace() {
    return marketplace;
  }

  @JsonIgnore
  public Integer getQuantity() {
    return quantity.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_QUANTITY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Integer> quantity() {
    return quantity;
  }

  @JsonIgnore
  public Float getItemPrice() {
    return itemPrice.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_ITEM_PRICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<Float> itemPrice() {
    return itemPrice;
  }

  @JsonIgnore
  public String getCurrency() {
    return currency.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CURRENCY)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> currency() {
    return currency;
  }

  /** Return true if this ProductItem object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductItemImpl productItem = (ProductItemImpl) o;
    return Objects.equals(this.id, productItem.id)
        && Objects.equals(this.marketplace, productItem.marketplace)
        && Objects.equals(this.quantity, productItem.quantity)
        && Objects.equals(this.itemPrice, productItem.itemPrice)
        && Objects.equals(this.currency, productItem.currency);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, marketplace, quantity, itemPrice, currency);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductItemImpl {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    marketplace: ").append(toIndentedString(marketplace)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    itemPrice: ").append(toIndentedString(itemPrice)).append("\n");
    sb.append("    currency: ").append(toIndentedString(currency)).append("\n");
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
  static class Builder implements ProductItem.Builder {
    OptionalValue<String> id = OptionalValue.empty();
    OptionalValue<String> marketplace = OptionalValue.empty();
    OptionalValue<Integer> quantity = OptionalValue.empty();
    OptionalValue<Float> itemPrice = OptionalValue.empty();
    OptionalValue<String> currency = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_ID)
    public Builder setId(String id) {
      this.id = OptionalValue.of(id);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_MARKETPLACE)
    public Builder setMarketplace(String marketplace) {
      this.marketplace = OptionalValue.of(marketplace);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_QUANTITY)
    public Builder setQuantity(Integer quantity) {
      this.quantity = OptionalValue.of(quantity);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_ITEM_PRICE)
    public Builder setItemPrice(Float itemPrice) {
      this.itemPrice = OptionalValue.of(itemPrice);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CURRENCY)
    public Builder setCurrency(String currency) {
      this.currency = OptionalValue.of(currency);
      return this;
    }

    public ProductItem build() {
      return new ProductItemImpl(id, marketplace, quantity, itemPrice, currency);
    }
  }
}
