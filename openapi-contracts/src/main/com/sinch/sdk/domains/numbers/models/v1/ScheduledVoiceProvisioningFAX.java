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

/** ScheduledVoiceProvisioningFAX */
@JsonDeserialize(builder = ScheduledVoiceProvisioningFAXImpl.Builder.class)
public interface ScheduledVoiceProvisioningFAX
    extends com.sinch.sdk.domains.numbers.models.v1.ScheduledVoiceProvisioning {

  /**
   * Timestamp when the status was last updated.
   *
   * @return lastUpdatedTime
   * @readOnly <em>This field is returned by the server and cannot be modified</em>
   */
  Instant getLastUpdatedTime();

  /**
   * Get status
   *
   * @return status
   */
  ProvisioningStatus getStatus();

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
    return new ScheduledVoiceProvisioningFAXImpl.Builder();
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
     * @readOnly <em>This field is returned by the server and cannot be modified</em>
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
    ScheduledVoiceProvisioningFAX build();
  }
}
