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
import com.sinch.sdk.domains.numbers.models.v1.ActiveNumber;
import java.util.List;

/** Response message to list your active phone numbers. */
@JsonDeserialize(builder = ActiveNumberListResponseInternalImpl.Builder.class)
public interface ActiveNumberListResponseInternal {

  /**
   * List of numbers associated to the client project specified in <code>ListActiveNumbers</code>.
   *
   * @return activeNumbers
   */
  List<ActiveNumber> getActiveNumbers();

  /**
   * Get nextPageToken
   *
   * @return nextPageToken
   */
  String getNextPageToken();

  /**
   * Get totalSize
   *
   * @return totalSize
   */
  Integer getTotalSize();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new ActiveNumberListResponseInternalImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param activeNumbers see getter
     * @return Current builder
     * @see #getActiveNumbers
     */
    Builder setActiveNumbers(List<ActiveNumber> activeNumbers);

    /**
     * see getter
     *
     * @param nextPageToken see getter
     * @return Current builder
     * @see #getNextPageToken
     */
    Builder setNextPageToken(String nextPageToken);

    /**
     * see getter
     *
     * @param totalSize see getter
     * @return Current builder
     * @see #getTotalSize
     */
    Builder setTotalSize(Integer totalSize);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ActiveNumberListResponseInternal build();
  }
}
