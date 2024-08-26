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

/** FAX VoiceConfiguration */
@JsonDeserialize(builder = VoiceConfigurationFAXImpl.Builder.class)
public interface VoiceConfigurationFAX
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
   * The service ID if the type is FAX. The <code>serviceId</code> can be found in your <a
   * href="https://dashboard.sinch.com/fax/services">Sinch Customer Dashboard</a>.
   *
   * @return serviceId
   */
  String getServiceId();

  /**
   * Getting builder
   *
   * @return New Builder instance
   */
  static Builder builder() {
    return new VoiceConfigurationFAXImpl.Builder();
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
     * @param serviceId see getter
     * @return Current builder
     * @see #getServiceId
     */
    Builder setServiceId(String serviceId);

    /**
     * Create instance
     *
     * @return The instance build with current builder values
     */
    VoiceConfigurationFAX build();
  }
}
