/*
 * Conversation API | Sinch
 *
 * OpenAPI document version: 1.0
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.conversation.models.v1.messages.types.channelspecific.whatsapp.payment;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.Instant;
import java.util.List;

/** The payment order. */
@JsonDeserialize(builder = OrderDetailsPaymentOrderImpl.Builder.class)
public interface OrderDetailsPaymentOrder {

  /**
   * Unique ID of the Facebook catalog being used by the business.
   *
   * @return catalogId
   */
  String getCatalogId();

  /**
   * UTC timestamp indicating when the order should expire. The timestamp must be given in seconds.
   * The minimum threshold for the timestamp is 300 seconds.
   *
   * @return expirationTime
   */
  Instant getExpirationTime();

  /**
   * Description of the expiration.
   *
   * @return expirationDescription
   */
  String getExpirationDescription();

  /**
   * Value representing the subtotal amount of this order.
   *
   * @return subtotalValue
   */
  Integer getSubtotalValue();

  /**
   * Value representing the tax amount for this order.
   *
   * @return taxValue
   */
  Integer getTaxValue();

  /**
   * Description of the tax for this order.
   *
   * @return taxDescription
   */
  String getTaxDescription();

  /**
   * Value representing the shipping amount for this order.
   *
   * @return shippingValue
   */
  Integer getShippingValue();

  /**
   * Shipping description for this order.
   *
   * @return shippingDescription
   */
  String getShippingDescription();

  /**
   * Value of the discount for this order.
   *
   * @return discountValue
   */
  Integer getDiscountValue();

  /**
   * Description of the discount for this order.
   *
   * @return discountDescription
   */
  String getDiscountDescription();

  /**
   * Discount program name for this order.
   *
   * @return discountProgramName
   */
  String getDiscountProgramName();

  /**
   * The items list for this order.
   *
   * @return items
   */
  List<OrderDetailsPaymentOrderItems> getItems();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new OrderDetailsPaymentOrderImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param catalogId see getter
     * @return Current builder
     * @see #getCatalogId
     */
    Builder setCatalogId(String catalogId);

    /**
     * see getter
     *
     * @param expirationTime see getter
     * @return Current builder
     * @see #getExpirationTime
     */
    Builder setExpirationTime(Instant expirationTime);

    /**
     * see getter
     *
     * @param expirationDescription see getter
     * @return Current builder
     * @see #getExpirationDescription
     */
    Builder setExpirationDescription(String expirationDescription);

    /**
     * see getter
     *
     * @param subtotalValue see getter
     * @return Current builder
     * @see #getSubtotalValue
     */
    Builder setSubtotalValue(Integer subtotalValue);

    /**
     * see getter
     *
     * @param taxValue see getter
     * @return Current builder
     * @see #getTaxValue
     */
    Builder setTaxValue(Integer taxValue);

    /**
     * see getter
     *
     * @param taxDescription see getter
     * @return Current builder
     * @see #getTaxDescription
     */
    Builder setTaxDescription(String taxDescription);

    /**
     * see getter
     *
     * @param shippingValue see getter
     * @return Current builder
     * @see #getShippingValue
     */
    Builder setShippingValue(Integer shippingValue);

    /**
     * see getter
     *
     * @param shippingDescription see getter
     * @return Current builder
     * @see #getShippingDescription
     */
    Builder setShippingDescription(String shippingDescription);

    /**
     * see getter
     *
     * @param discountValue see getter
     * @return Current builder
     * @see #getDiscountValue
     */
    Builder setDiscountValue(Integer discountValue);

    /**
     * see getter
     *
     * @param discountDescription see getter
     * @return Current builder
     * @see #getDiscountDescription
     */
    Builder setDiscountDescription(String discountDescription);

    /**
     * see getter
     *
     * @param discountProgramName see getter
     * @return Current builder
     * @see #getDiscountProgramName
     */
    Builder setDiscountProgramName(String discountProgramName);

    /**
     * see getter
     *
     * @param items see getter
     * @return Current builder
     * @see #getItems
     */
    Builder setItems(List<OrderDetailsPaymentOrderItems> items);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    OrderDetailsPaymentOrder build();
  }
}
