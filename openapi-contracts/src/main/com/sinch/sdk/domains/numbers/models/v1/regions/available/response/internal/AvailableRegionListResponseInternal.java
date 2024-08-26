/*
 * Numbers | Sinch
 *
 * OpenAPI document version: 1.0.2
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.numbers.models.v1.regions.available.response.internal;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.sinch.sdk.domains.numbers.models.v1.regions.available.response.AvailableRegion;
import java.util.List;

/** Response message to list regions for which numbers are provided. */
@JsonDeserialize(builder = AvailableRegionListResponseInternalImpl.Builder.class)
public interface AvailableRegionListResponseInternal {

  /**
   * @return availableRegions
   */
  List<AvailableRegion> getAvailableRegions();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new AvailableRegionListResponseInternalImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param availableRegions see getter
     * @return Current builder
     * @see #getAvailableRegions
     */
    Builder setAvailableRegions(List<AvailableRegion> availableRegions);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    AvailableRegionListResponseInternal build();
  }
}
