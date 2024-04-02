package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.ProductItem;
import java.util.Objects;

@JsonPropertyOrder({ListItemItemImpl.JSON_PROPERTY_CHOICE, ListItemItemImpl.JSON_PROPERTY_PRODUCT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ListItemItemImpl implements ListItemItem {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_CHOICE = "choice";

  private OptionalValue<ListItemChoice> choice;

  public static final String JSON_PROPERTY_PRODUCT = "product";

  private OptionalValue<ProductItem> product;

  public ListItemItemImpl() {}

  protected ListItemItemImpl(
      OptionalValue<ListItemChoice> choice, OptionalValue<ProductItem> product) {
    this.choice = choice;
    this.product = product;
  }

  @JsonIgnore
  public ListItemChoice getChoice() {
    return choice.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_CHOICE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ListItemChoice> choice() {
    return choice;
  }

  @JsonIgnore
  public ProductItem getProduct() {
    return product.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PRODUCT)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ProductItem> product() {
    return product;
  }

  /** Return true if this ListItem_item object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ListItemItemImpl listItemItem = (ListItemItemImpl) o;
    return Objects.equals(this.choice, listItemItem.choice)
        && Objects.equals(this.product, listItemItem.product);
  }

  @Override
  public int hashCode() {
    return Objects.hash(choice, product);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ListItemItemImpl {\n");
    sb.append("    choice: ").append(toIndentedString(choice)).append("\n");
    sb.append("    product: ").append(toIndentedString(product)).append("\n");
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
  static class Builder implements ListItemItem.Builder {
    OptionalValue<ListItemChoice> choice = OptionalValue.empty();
    OptionalValue<ProductItem> product = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_CHOICE)
    public Builder setChoice(ListItemChoice choice) {
      this.choice = OptionalValue.of(choice);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_PRODUCT)
    public Builder setProduct(ProductItem product) {
      this.product = OptionalValue.of(product);
      return this;
    }

    public ListItemItem build() {
      return new ListItemItemImpl(choice, product);
    }
  }
}
