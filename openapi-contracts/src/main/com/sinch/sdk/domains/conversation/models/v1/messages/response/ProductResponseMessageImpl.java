package com.sinch.sdk.domains.conversation.models.v1.messages.response;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.ProductItem;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({
  ProductResponseMessageImpl.JSON_PROPERTY_PRODUCTS,
  ProductResponseMessageImpl.JSON_PROPERTY_TITLE,
  ProductResponseMessageImpl.JSON_PROPERTY_CATALOG_ID
})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ProductResponseMessageImpl implements ProductResponseMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PRODUCTS = "products";

  private OptionalValue<List<ProductItem>> products;

  public static final String JSON_PROPERTY_TITLE = "title";

  private OptionalValue<String> title;

  public static final String JSON_PROPERTY_CATALOG_ID = "catalog_id";

  private OptionalValue<String> catalogId;

  public ProductResponseMessageImpl() {}

  protected ProductResponseMessageImpl(
      OptionalValue<List<ProductItem>> products,
      OptionalValue<String> title,
      OptionalValue<String> catalogId) {
    this.products = products;
    this.title = title;
    this.catalogId = catalogId;
  }

  @JsonIgnore
  public List<ProductItem> getProducts() {
    return products.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PRODUCTS)
  @JsonInclude(value = JsonInclude.Include.ALWAYS)
  public OptionalValue<List<ProductItem>> products() {
    return products;
  }

  @JsonIgnore
  public String getTitle() {
    return title.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_TITLE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<String> title() {
    return title;
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

  /** Return true if this ProductResponseMessage object is equal to o. */
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProductResponseMessageImpl productResponseMessage = (ProductResponseMessageImpl) o;
    return Objects.equals(this.products, productResponseMessage.products)
        && Objects.equals(this.title, productResponseMessage.title)
        && Objects.equals(this.catalogId, productResponseMessage.catalogId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(products, title, catalogId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductResponseMessageImpl {\n");
    sb.append("    products: ").append(toIndentedString(products)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    catalogId: ").append(toIndentedString(catalogId)).append("\n");
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
  static class Builder implements ProductResponseMessage.Builder {
    OptionalValue<List<ProductItem>> products = OptionalValue.empty();
    OptionalValue<String> title = OptionalValue.empty();
    OptionalValue<String> catalogId = OptionalValue.empty();

    @JsonProperty(JSON_PROPERTY_PRODUCTS)
    public Builder setProducts(List<ProductItem> products) {
      this.products = OptionalValue.of(products);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_TITLE)
    public Builder setTitle(String title) {
      this.title = OptionalValue.of(title);
      return this;
    }

    @JsonProperty(JSON_PROPERTY_CATALOG_ID)
    public Builder setCatalogId(String catalogId) {
      this.catalogId = OptionalValue.of(catalogId);
      return this;
    }

    public ProductResponseMessage build() {
      return new ProductResponseMessageImpl(products, title, catalogId);
    }
  }
}
