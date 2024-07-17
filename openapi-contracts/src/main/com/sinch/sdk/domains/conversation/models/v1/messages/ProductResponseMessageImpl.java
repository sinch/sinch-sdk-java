package com.sinch.sdk.domains.conversation.models.v1.messages;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import com.sinch.sdk.core.models.OptionalValue;
import com.sinch.sdk.domains.conversation.models.v1.messages.internal.ProductResponseMessageInternal;
import java.util.List;
import java.util.Objects;

@JsonPropertyOrder({ProductResponseMessageImpl.JSON_PROPERTY_PRODUCT_RESPONSE_MESSAGE})
@JsonFilter("uninitializedFilter")
@JsonInclude(value = JsonInclude.Include.CUSTOM)
public class ProductResponseMessageImpl
    implements ProductResponseMessage,
        com.sinch.sdk.domains.conversation.models.v1.messages.ContactMessage {
  private static final long serialVersionUID = 1L;

  public static final String JSON_PROPERTY_PRODUCT_RESPONSE_MESSAGE = "product_response_message";

  private OptionalValue<ProductResponseMessageInternal> productResponseMessage;

  public ProductResponseMessageImpl() {}

  protected ProductResponseMessageImpl(
      OptionalValue<ProductResponseMessageInternal> productResponseMessage) {
    this.productResponseMessage = productResponseMessage;
  }

  @JsonIgnore
  public ProductResponseMessageInternal getProductResponseMessage() {
    return productResponseMessage.orElse(null);
  }

  @JsonProperty(JSON_PROPERTY_PRODUCT_RESPONSE_MESSAGE)
  @JsonInclude(value = JsonInclude.Include.USE_DEFAULTS)
  public OptionalValue<ProductResponseMessageInternal> productResponseMessage() {
    return productResponseMessage;
  }

  @JsonIgnore
  public List<ProductItem> getProducts() {
    if (null == productResponseMessage
        || !productResponseMessage.isPresent()
        || null == productResponseMessage.get().getProducts()) {
      return null;
    }
    return productResponseMessage.get().getProducts();
  }

  public OptionalValue<List<ProductItem>> products() {
    return null != productResponseMessage
        ? productResponseMessage.map(ProductResponseMessageInternal::getProducts)
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getTitle() {
    if (null == productResponseMessage
        || !productResponseMessage.isPresent()
        || null == productResponseMessage.get().getTitle()) {
      return null;
    }
    return productResponseMessage.get().getTitle();
  }

  public OptionalValue<String> title() {
    return null != productResponseMessage
        ? productResponseMessage.map(ProductResponseMessageInternal::getTitle)
        : OptionalValue.empty();
  }

  @JsonIgnore
  public String getCatalogId() {
    if (null == productResponseMessage
        || !productResponseMessage.isPresent()
        || null == productResponseMessage.get().getCatalogId()) {
      return null;
    }
    return productResponseMessage.get().getCatalogId();
  }

  public OptionalValue<String> catalogId() {
    return null != productResponseMessage
        ? productResponseMessage.map(ProductResponseMessageInternal::getCatalogId)
        : OptionalValue.empty();
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
    return Objects.equals(
        this.productResponseMessage, productResponseMessage.productResponseMessage);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productResponseMessage);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProductResponseMessageImpl {\n");
    sb.append("    productResponseMessage: ")
        .append(toIndentedString(productResponseMessage))
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
  static class Builder implements ProductResponseMessage.Builder {
    OptionalValue<ProductResponseMessageInternal> productResponseMessage = OptionalValue.empty();

    ProductResponseMessageInternal.Builder _delegatedBuilder = null;

    @JsonProperty(value = JSON_PROPERTY_PRODUCT_RESPONSE_MESSAGE, required = true)
    public Builder setProductResponseMessage(
        ProductResponseMessageInternal productResponseMessage) {
      this.productResponseMessage = OptionalValue.of(productResponseMessage);
      return this;
    }

    @JsonIgnore
    public Builder setProducts(List<ProductItem> products) {
      getDelegatedBuilder().setProducts(products);
      return this;
    }

    @JsonIgnore
    public Builder setTitle(String title) {
      getDelegatedBuilder().setTitle(title);
      return this;
    }

    @JsonIgnore
    public Builder setCatalogId(String catalogId) {
      getDelegatedBuilder().setCatalogId(catalogId);
      return this;
    }

    private ProductResponseMessageInternal.Builder getDelegatedBuilder() {
      if (null == _delegatedBuilder) {
        this._delegatedBuilder = ProductResponseMessageInternal.builder();
      }
      return this._delegatedBuilder;
    }

    public ProductResponseMessage build() {
      // delegated builder was used: filling the related source of delegation field
      if (null != this._delegatedBuilder) {
        this.productResponseMessage = OptionalValue.of(this._delegatedBuilder.build());
      }
      return new ProductResponseMessageImpl(productResponseMessage);
    }
  }
}
