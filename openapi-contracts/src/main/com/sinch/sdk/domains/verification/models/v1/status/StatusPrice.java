/*
 * Verification | Sinch
 * Verify users with SMS, flash calls (missed calls), a regular call, or data verification.
 *
 * The version of the OpenAPI document: 2.0.1
 * Contact: support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.verification.models.v1.status;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.verification.models.v1.Price;

/** Prices associated with this verification */
@JsonDeserialize(builder = StatusPriceImpl.Builder.class)
public interface StatusPrice {

  /**
   * Get verificationPrice
   *
   * @return verificationPrice
   */
  Price getVerificationPrice();

  /**
   * Get terminationPrice
   *
   * @return terminationPrice
   */
  Price getTerminationPrice();

  /**
   * The time of the call for which the fee was charged. Present only when termination debiting is
   * enabled (disabled by default). Depending on the type of rounding used, the value is the actual
   * call time rounded to the nearest second, minute or other value.
   *
   * @return billableDuration
   */
  Integer getBillableDuration();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new StatusPriceImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param verificationPrice see getter
     * @return Current builder
     * @see #getVerificationPrice
     */
    Builder setVerificationPrice(Price verificationPrice);

    /**
     * see getter
     *
     * @param terminationPrice see getter
     * @return Current builder
     * @see #getTerminationPrice
     */
    Builder setTerminationPrice(Price terminationPrice);

    /**
     * see getter
     *
     * @param billableDuration see getter
     * @return Current builder
     * @see #getBillableDuration
     */
    Builder setBillableDuration(Integer billableDuration);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    StatusPrice build();
  }
}
