/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.messages.types.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.conversation.models.v1.messages.ProductItem;

/** Product */
@JsonDeserialize(builder = ListItemOneOfProductInternalImpl.Builder.class)
public interface ListItemOneOfProductInternal {

  /**
   * Get product
   *
   * @return product
   */
  ProductItem getProduct();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ListItemOneOfProductInternalImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param product see getter
     * @return Current builder
     * @see #getProduct
     */
    Builder setProduct(ProductItem product);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ListItemOneOfProductInternal build();
  }
}
