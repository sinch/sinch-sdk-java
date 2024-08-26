/*
 * Numbers | Sinch
 *
 * OpenAPI document version: 1.0.2
 * Contact: Support@sinch.com
 *
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech).
 * Do not edit the class manually.
 */

package com.sinch.sdk.domains.numbers.models.v1;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.Instant;

/** ScheduledVoiceProvisioningRTC */
@JsonDeserialize(builder = ScheduledVoiceProvisioningRTCImpl.Builder.class)
public interface ScheduledVoiceProvisioningRTC
    extends com.sinch.sdk.domains.numbers.models.v1.ScheduledVoiceProvisioning {

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
    return new ScheduledVoiceProvisioningRTCImpl.Builder();
  }

  /** Dedicated Builder */
  interface Builder
      extends com.sinch.sdk.domains.numbers.models.v1.ScheduledVoiceProvisioning.Builder {

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
    ScheduledVoiceProvisioningRTC build();
  }
}
