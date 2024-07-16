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

/** RTC VoiceConfiguration */
@JsonDeserialize(builder = VoiceConfigurationRTCImpl.Builder.class)
public interface VoiceConfigurationRTC
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
   * Your app ID for the Voice API. The <code>appId</code> can be found in your <a
   * href="https://dashboard.sinch.com/voice/apps">Sinch Customer Dashboard</a>.
   *
   * @return appId
   */
  String getAppId();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new VoiceConfigurationRTCImpl.Builder();
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
     * @param appId see getter
     * @return Current builder
     * @see #getAppId
     */
    Builder setAppId(String appId);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    VoiceConfigurationRTC build();
  }
}
