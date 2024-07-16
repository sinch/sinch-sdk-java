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

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.Instant;

/** EST VoiceConfiguration */
@JsonDeserialize(builder = VoiceConfigurationESTImpl.Builder.class)
public interface VoiceConfigurationEST
    extends com.sinch.sdk.domains.numbers.models.v1.VoiceConfiguration {

  /**
   * Timestamp when the status was last updated.
   *
   * @return lastUpdatedTime
   */
  Instant getLastUpdatedTime();

  /**
   * Get scheduledProvisioning
   *
   * @return scheduledProvisioning
   */
  ScheduledVoiceProvisioning getScheduledProvisioning();

  /**
   * The trunk ID if the type is EST. The <code>trunkId</code> can be found in your <a
   * href="https://dashboard.sinch.com/trunks/your-trunks">Sinch Customer Dashboard</a>.
   *
   * @return trunkId
   */
  String getTrunkId();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new VoiceConfigurationESTImpl.Builder();
  }

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
     * @param scheduledProvisioning see getter
     * @return Current builder
     * @see #getScheduledProvisioning
     */
    Builder setScheduledProvisioning(ScheduledVoiceProvisioning scheduledProvisioning);

    /**
     * see getter
     *
     * @param trunkId see getter
     * @return Current builder
     * @see #getTrunkId
     */
    Builder setTrunkId(String trunkId);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    VoiceConfigurationEST build();
  }
}