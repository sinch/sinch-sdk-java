package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import java.util.Objects;

@JsonPropertyOrder({ProductImpl.JSON_PROPERTY_PRODUCT})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ProductImpl implements Product {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PRODUCT = "product";

  private OptionalValue<ProductItem> product;

  public ProductImpl() {}

  protected ProductImpl(OptionalValue<ProductItem> product) {
    this.product = product;
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

  /** Return true if this product object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductImpl product = (ProductImpl) o;
    return Objects.equals(this.product, product.product);
  }

  @Override
  public int hashCode() {
    return Objects.hash(product);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductImpl {\n");
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
  static class Builder implements Product.Builder {
    OptionalValue<ProductItem> product = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_PRODUCT)
    public Builder setProduct(ProductItem product) {
      this.product = OptionalValue.of(product);
      return this;
    }

    public Product build() {
      return new ProductImpl(product);
    }
  }
}