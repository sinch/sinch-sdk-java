/*
 * Numbers | Sinch
 *
 * OpenAPI document version: 1.0.2
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.numbers.models.v1.response.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.numbers.models.v1.response.AvailableNumber;
import java.util.List;

/** Response message to list available phone numbers. */
@JsonDeserialize(builder = AvailableNumberListResponseInternalImpl.Builder.class)
public interface AvailableNumberListResponseInternal {

  /**
   * List of available phone numbers.
   *
   * @return availableNumbers
   */
  List<AvailableNumber> getAvailableNumbers();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new AvailableNumberListResponseInternalImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param availableNumbers see getter
     * @return Current builder
     * @see #getAvailableNumbers
     */
    Builder setAvailableNumbers(List<AvailableNumber> availableNumbers);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    AvailableNumberListResponseInternal build();
  }
}
