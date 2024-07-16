/*
 * Numbers | Sinch
 * An API service for getting, listing and managing Sinch virtual numbers.
 *
 * The version of the OpenAPI document: 1.0.2
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.numbers.models.v1;

import java.time.Instant;

/** ScheduledVoiceProvisioning */
public interface ScheduledVoiceProvisioning {

  /**
   * Timestamp when the status was last updated.
   *
   * @return lastUpdatedTime
   */
  Instant getLastUpdatedTime();

  /**
   * Get status
   *
   * @return status
   */
  ProvisioningStatus getStatus();

  /** Dedicated Builder */
  interface Builder {

    /**
     * see getter
     *
     * @param lastUpdatedTime see getter
     * @return Current builder
     * @see #getLastUpdatedTime
     */
    Builder setLastUpdatedTime(Instant lastUpdatedTime);

    /**
     * see getter
     *
     * @param status see getter
     * @return Current builder
     * @see #getStatus
     */
    Builder setStatus(ProvisioningStatus status);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    ScheduledVoiceProvisioning build();
  }
}